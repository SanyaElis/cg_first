package ru.vsu.cs.eliseev;

import java.awt.*;
import java.awt.geom.Line2D;

public class DrawUtils {
    public static void drawSun(Graphics2D g, int x, int y, int r, int l, int n, Color c) {
        g.setColor(c);
        g.fillOval(x - r, y - r, r * 2, r * 2);

        double da = 2 * Math.PI / n;


        for (int i = 0; i < n; i++) {
            double a = i * da;
            double x1 = r * Math.cos(a) + x;
            double y1 = r * Math.sin(a) + y;
            double x2 = (r + l) * Math.cos(a) + x;
            double y2 = (r + l) * Math.sin(a) + y;

            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }

    public static void drawLake(Graphics2D g, Color c, int height, int width) {
        g.setColor(new Color(100, 200, 100));

        //g.fillRect(350, 270, 450, 350);
        g.fillRect(0, height / 3, width, height);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, width, height / 3);
        g.setColor(c);
        g.fillOval(200, 230, 600, 400);
        g.fillOval(400, 220, 600, 400);

    }

    public static void drawTreeFirstType(Graphics2D g, Tree tree) {
        g.setColor(tree.colorOfStump);
        Position pos = tree.positionOfStump;
        g.fillRect(pos.x, pos.y, tree.length / 10, tree.length / 4);
        g.setColor(tree.colorOfLeaves);
        g.fillOval(pos.x - tree.length / 9, pos.y - tree.length * 4 / 5, tree.length / 3, tree.length * 5 / 6);
    }

    public static void drawTreeSecondType(Graphics2D g, Tree tree) {
        g.setColor(tree.colorOfStump);
        Position pos = tree.positionOfStump;
        g.fillRect(pos.x, pos.y, tree.length / 10, tree.length / 3);
        g.setColor(tree.colorOfLeaves);
        g.fillOval(pos.x - tree.length / 10, pos.y - tree.length / 8, tree.length / 4, tree.length / 4);
        g.fillOval(pos.x, pos.y - tree.length / 4, tree.length / 3, tree.length / 3);
        g.fillOval(pos.x - tree.length / 4, pos.y - tree.length / 4, tree.length / 3, tree.length / 3);
        g.fillOval(pos.x, (int) (pos.y - tree.length / 2.5), (int) (tree.length / 3.2), (int) (tree.length / 3.2));
        g.fillOval((int) (pos.x - tree.length / 4.6), (int) (pos.y - tree.length / 2.5), (int) (tree.length / 3.2), (int) (tree.length / 3.2));
        g.fillOval(pos.x - tree.length / 10, pos.y - tree.length / 2, tree.length / 4, tree.length / 4);
    }
}
