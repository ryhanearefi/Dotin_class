public class Restaurant {

    public String[] menuItems;
    public int itemCount = 0;

    public Restaurant() {
        this.menuItems = new String[10]; // ظرفیت اولیه 10 آیتم
    }

    public void addItem(String name, double price, double rating) {
        validateItem(name);

        if (itemCount == menuItems.length) {
            // افزایش ظرفیت آرایه در صورت نیاز
            String[] newMenuItems = new String[menuItems.length * 2];
            System.arraycopy(menuItems, 0, newMenuItems, 0, menuItems.length);
            menuItems = newMenuItems;
        }

        menuItems[itemCount] = new MenuItem(name, price, rating).toString();
        itemCount++;
        System.out.println("غذای " + name + " با موفقیت به رستوران اضافه شد.");
    }

    private void validateItem(String name) {
        for (int i = 0; i < itemCount; i++) {
            if (menuItems[i].contains(name)) {
                throw new IllegalArgumentException("غذایی با نام " + name + " در رستوران موجود است");
            }
        }
    }

    public void removeItem(String name) {
        int index = findItemIndex(name);

        if (index == -1) {
            throw new IllegalArgumentException("غذایی با نام " + name + " در رستوران یافت نشد");
        }

        // جابجایی آیتم‌های بعدی به سمت چپ برای پر کردن جای آیتم حذف شده
        for (int i = index; i < itemCount - 1; i++) {
            menuItems[i] = menuItems[i + 1];
        }

        itemCount--;
        System.out.println("غذای " + name + " با موفقیت از رستوران حذف شد.");
    }

    private int findItemIndex(String name) {
        for (int i = 0; i < itemCount; i++) {
            if (menuItems[i].contains(name)) {
                return i;
            }
        }
        return -1;
    }

    public MenuItem getItem(String name) {
        int index = findItemIndex(name);

        if (index == -1) {
            throw new IllegalArgumentException("غذایی با نام " + name + " در رستوران یافت نشد");
        }

        // تبدیل رشته به شیء MenuItem
        String itemString = menuItems[index];
        String[] itemParts = itemString.split(",");
        return new MenuItem(itemParts[0], Double.parseDouble(itemParts[1]), Double.parseDouble(itemParts[2]));
    }

    public void updateItem(MenuItem item) {
        for (int i = 0; !(i >= itemCount); i++) {
            if (menuItems[i].contains(item.toString())) {
                menuItems[i] = item.toString(); // جایگزینی آیتم در آرایه
                return;
            }
        }
        throw new IllegalArgumentException("آیتم مورد نظر یافت نشد: " + item.getName());
    }

    public static class MenuItem {
        private String name;
        private double price;
        private double rating;

        public MenuItem(String name, double price, double rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public String toString() {
            return name + "," + price + "," + rating;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }
}