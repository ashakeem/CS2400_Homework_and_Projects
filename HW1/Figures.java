
public class Figures {
    public static void main(String[] args) {
        Measurable[] figures = {
                new Circle(3.0),
                new Square(7.0),
                new Rectangle(9.0, 5.0),
                new Circle(5.0),
                new Square(4.0)
        };

        System.out.println("Measurable A. Hakeem\n");

        System.out.printf("%-6s %-6s %-6s\n", "Figure", "Area", "Perimeter");

        int i = 1;
        for (Measurable figure : figures) {
            System.out.printf(" %-5d %-6.1f %-7.1f\n", i++, figure.getArea(), figure.getPerimeter());

        }

    }
}
