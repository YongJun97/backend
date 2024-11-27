package a1127.shape;

public class Rectangle extends Shape{
    
    double width, height;

    public Rectangle() {
        this(0,0);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        // 가로 x 세로
        return width * height;
    }

    @Override
    double round() {
        // (가로 + 세로) * 2
        return (width+height)*2;
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "]";
    }
}
