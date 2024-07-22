import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

class ShapePanel extends JPanel {
    private char shape;
    private int radius;
    private int base, height;
    private int length, width;

    public ShapePanel(char shape) {
        this.shape = shape;
    }

    public void setCircleDimensions(Scanner scanner) {
        System.out.print("Enter the radius of the circle (min: 1, max: 100): ");
        radius = getValidInput(scanner, 1, 100);  
    }

    public void setTriangleDimensions(Scanner scanner) {
        System.out.print("Enter the base of the triangle (min: 1, max: 100): ");
        base = getValidInput(scanner, 1, 100);
        System.out.print("Enter the height of the triangle (min: 1, max: 100): ");
        height = getValidInput(scanner, 1, 100);
    }

    public void setRectangleDimensions(Scanner scanner) {
        System.out.print("Enter the length of the rectangle (min: 1, max: 100): ");
        length = getValidInput(scanner, 1, 100);
        System.out.print("Enter the width of the rectangle (min: 1, max: 100): ");
        width = getValidInput(scanner, 1, 100);
    }

    private int getValidInput(Scanner scanner, int min, int max) {
        int value = scanner.nextInt();
        while (value < min || value > max) {
            System.out.print("Invalid input. Please enter a value between " + min + " and " + max + ": ");
            value = scanner.nextInt();
        }
        return value;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        switch (shape) {
            case 'c':
                g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
                break;
            case 't':
                int[] xPoints = { centerX, centerX - base / 2, centerX + base / 2 };
                int[] yPoints = { centerY - height / 2, centerY + height / 2, centerY + height / 2 };
                g2d.drawPolygon(xPoints, yPoints, 3);
                break;
            case 'r':
                g2d.drawRect(centerX - length / 2, centerY - width / 2, length, width);
                break;
        }
    }
}
