//
// Name: Hakeem, Ayomide
// Homework: #1
// Due: 02/01/2024
// Course: cs-2400-sp24
//
// Description:
// Interfaces and Classes to calculate area and perimeter of shapes
//
public class Square implements Measurable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}
