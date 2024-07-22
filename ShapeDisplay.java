import javax.swing.*;
import java.util.Scanner;

public class ShapeDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a shape to display:");
        System.out.println("c for Circle");
        System.out.println("t for Triangle");
        System.out.println("r for Rectangle");
        char shape = scanner.next().charAt(0);

        JFrame frame = new JFrame("Shape Display");
        ShapePanel shapePanel = new ShapePanel(shape);
        
        switch (shape) {
            case 'c':
                shapePanel.setCircleDimensions(scanner);
                break;
            case 't':
                shapePanel.setTriangleDimensions(scanner);
                break;
            case 'r':
                shapePanel.setRectangleDimensions(scanner);
                break;
            default:
                System.out.println("Invalid option. Please choose c, t, or r.");
                System.exit(0);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(shapePanel);
        frame.setVisible(true);

        scanner.close();
    }
}
