
public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        // اضافه کردن آیتم‌های منو
        restaurant.addItem("قرمه‌سبزی", 25000, 4.8);
        restaurant.addItem("چلوکباب", 30000, 4.5);
        restaurant.addItem("کوبیده", 22000, 4.2);

        // نمایش منوی رستوران
        System.out.println("\nمنوی رستوران:");
        for (int i = 0; i < restaurant.itemCount; i++) {
            Restaurant.MenuItem item = restaurant.getItem(restaurant.menuItems[i]);
            System.out.println(" - " + item.getName() + ": " + item.getPrice() + " تومان، امتیاز: " + item.getRating());
        }

        // حذف آیتم از منو
        System.out.println("\nحذف آیتم قرمه‌سبزی از منو:");
        restaurant.removeItem("قرمه‌سبزی");

        // نمایش منوی رستوران بعد از حذف
        System.out.println("\nمنوی رستوران بعد از حذف قرمه‌سبزی:");
        Restaurant.MenuItem item;
        for (int i = 0; i < restaurant.itemCount; i++) {
            item = restaurant.getItem(restaurant.menuItems[i]);
            System.out.println(" - " + item.getName() + ": " + item.getPrice() + " تومان، امتیاز: " + item.getRating());
        }

        // جستجوی آیتم در منو
        System.out.println("\nجستجوی آیتم چلوکباب:");
        item = restaurant.getItem("چلوکباب");
        System.out.println(" - " + item.getName() + ": " + item.getPrice() + " تومان، امتیاز: " + item.getRating());

        // بروزرسانی قیمت آیتم
        System.out.println("\nبروزرسانی قیمت چلوکباب به 35000 تومان:");
        item.setPrice(35000);
        restaurant.updateItem(item);

        // نمایش منوی رستوران بعد از بروزرسانی
        System.out.println("\nمنوی رستوران بعد از بروزرسانی قیمت چلوکباب:");
        for (int i = 0; i < restaurant.itemCount; i++) {
            item = restaurant.getItem(restaurant.menuItems[i]);
            System.out.println(" - " + item.getName() + ": " + item.getPrice() + " تومان، امتیاز: " + item.getRating());
        }
    }

}