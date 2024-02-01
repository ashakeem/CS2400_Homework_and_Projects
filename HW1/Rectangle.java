//
// Name: Hakeem, Ayomide
// Homework: #1
// Due: 02/01/2024
// Course: cs-2400-sp24
//
// Description:
// Interfaces and Classes to calculate area and perimeter of shapes
//
public class Rectangle implements Measurable {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double getArea() {
        return length * breadth;
    }

    public double getPerimeter() {
        return 2 * (length + breadth);
    }

}
