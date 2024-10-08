package com.springrest.sampleapi.api.controller;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
// حذف یا کامنت کردن import تداخل‌کننده
// import okhttp3.RequestBody;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class LeonardoController {

    // متغیر برای ذخیره کردن توکن
    private static final String API_TOKEN = "2a4fcce5-8ce7-4e86-9096-537050cd8679";  // توکن خود را اینجا جایگزین کنید

    @PostMapping("/generate")
    public ResponseEntity<String> generateImage(@RequestBody ImageRequest requestBody) {
        // ایجاد OkHttpClient
        OkHttpClient client = new OkHttpClient();

        // نوع داده برای ارسال به API
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        // ساختن بدنه درخواست با پارامترهای ورودی از درخواست
        String jsonBody = "{"
                + "\"alchemy\": true,"
                + "\"height\": " + requestBody.getHeight() + ","
                + "\"modelId\": \"" + requestBody.getModelId() + "\","
                + "\"num_images\": " + requestBody.getNumImages() + ","
                + "\"presetStyle\": \"" + requestBody.getPresetStyle() + "\","
                + "\"prompt\": \"" + requestBody.getPrompt() + "\","
                + "\"width\": " + requestBody.getWidth()
                + "}";

        // استفاده از کلاس RequestBody مربوط به OkHttp با نام کامل
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, jsonBody);

        // ساختن درخواست HTTP با هدرها، از جمله هدر Authorization برای احراز هویت
        Request request = new Request.Builder()
                .url("https://cloud.leonardo.ai/api/rest/v1/generations")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer " + API_TOKEN)  // اضافه کردن توکن به هدر Authorization
                .build();

        // ارسال درخواست و دریافت پاسخ
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                // استخراج generationId از پاسخ
                String responseBody = response.body().string();
                JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
                String generationId = jsonObject.getAsJsonObject("sdGenerationJob").get("generationId").getAsString();

                // بازگرداندن generationId به کاربر
                return ResponseEntity.ok("Generation ID: " + generationId);
            } else {
                // مدیریت خطا
                return ResponseEntity.status(response.code()).body("Error: " + response.message());
            }
        } catch (IOException e) {
            // مدیریت استثنا در صورت خطا
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    // متد جدید برای دریافت لینک تصویر با استفاده از generationId
    @GetMapping("/image/{generationId}")
    public ResponseEntity<String> getImageLink(@PathVariable String generationId) {
        OkHttpClient client = new OkHttpClient();

        String url = "https://cloud.leonardo.ai/api/rest/v1/generations/" + generationId;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Bearer " + API_TOKEN)
                .build();

        int maxRetries = 10;
        int attempt = 0;

        while (attempt < maxRetries) {
            attempt++;

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();

                    // چاپ پاسخ دریافتی برای بررسی ساختار
                    System.out.println("Response Body: " + responseBody);

                    // تجزیه JSON پاسخ
                    JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();

                    // دسترسی به کلید 'generations_by_pk'
                    JsonObject generationsByPk = jsonObject.getAsJsonObject("generations_by_pk");

                    if (generationsByPk == null) {
                        return ResponseEntity.status(500).body("Error: 'generations_by_pk' key not found in the response.");
                    }

                    String status = generationsByPk.get("status").getAsString();

                    if ("COMPLETE".equalsIgnoreCase(status)) {
                        // استخراج لینک تصویر
                        JsonArray generatedImages = generationsByPk.getAsJsonArray("generated_images");
                        if (generatedImages == null || generatedImages.size() == 0) {
                            return ResponseEntity.status(500).body("Error: No images found in the response.");
                        }

                        String imageUrl = generatedImages.get(0).getAsJsonObject().get("url").getAsString();

                        // دانلود و ذخیره تصویر
                        String savedFilePath = downloadImage(client, imageUrl, generationId);

                        return ResponseEntity.ok("Image saved at: " + savedFilePath);
                    } else if ("FAILED".equalsIgnoreCase(status)) {
                        return ResponseEntity.status(500).body("Image generation failed.");
                    } else {
                        System.out.println("Status: " + status);
                    }
                } else {
                    return ResponseEntity.status(response.code()).body("Error: " + response.message());
                }
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(500).body("Error: " + e.getMessage());
            }

            // صبر قبل از تلاش مجدد
            try {
                Thread.sleep(5000); // 5 ثانیه صبر
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return ResponseEntity.status(500).body("Thread interrupted");
            }
        }

        return ResponseEntity.status(500).body("Image generation timed out.");
    }


    private String downloadImage(OkHttpClient client, String imageUrl, String generationId) throws IOException {
        Request imageRequest = new Request.Builder()
                .url(imageUrl)
                .get()
                .build();

        try (Response imageResponse = client.newCall(imageRequest).execute()) {
            if (imageResponse.isSuccessful()) {
                byte[] imageBytes = imageResponse.body().bytes();

                // مسیر ذخیره تصویر
                String filePath = "images/" + generationId + ".png";

                // ایجاد دایرکتوری اگر وجود ندارد
                java.nio.file.Path path = java.nio.file.Paths.get("images");
                if (!java.nio.file.Files.exists(path)) {
                    java.nio.file.Files.createDirectories(path);
                }

                // ذخیره تصویر
                java.nio.file.Files.write(java.nio.file.Paths.get(filePath), imageBytes);

                return filePath;
            } else {
                throw new IOException("Failed to download image: " + imageResponse.message());
            }
        }
    }


    // کلاس مدل برای دریافت پارامترهای درخواست
    public static class ImageRequest {
        private boolean alchemy;
        private int height;
        private String modelId;
        private int numImages;
        private String presetStyle;
        private String prompt;
        private int width;

        // گتر و سترها

        public boolean isAlchemy() {
            return alchemy;
        }

        public void setAlchemy(boolean alchemy) {
            this.alchemy = alchemy;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getModelId() {
            return modelId;
        }

        public void setModelId(String modelId) {
            this.modelId = modelId;
        }

        public int getNumImages() {
            return numImages;
        }

        public void setNumImages(int numImages) {
            this.numImages = numImages;
        }

        public String getPresetStyle() {
            return presetStyle;
        }

        public void setPresetStyle(String presetStyle) {
            this.presetStyle = presetStyle;
        }

        public String getPrompt() {
            return prompt;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }
}
