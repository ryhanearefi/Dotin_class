public class Rectangle {
    private int widht;
    private int hight;

    public Rectangle(int wight, int hight) {
        this.widht = wight;
        this.hight = hight;
    }

  public void perimeter() {
        int perimeter= (widht + hight)*2;
      System.out.println("Mohit ="+perimeter);
  }
  public void area() {
        int area= widht * hight;
          System.out.println("Masahat ="+area);
  }


}
