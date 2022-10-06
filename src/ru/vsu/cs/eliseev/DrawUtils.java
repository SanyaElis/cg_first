package ru.vsu.cs.eliseev;

import java.awt.*;


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
        int rgb = 10;
        int currHeight = 0;
        for (int i = 0; i < 15; i++) {
            g.setColor(new Color(96 + rgb, 163, 192));
            g.fillRect(0, currHeight, width, currHeight + height / 18);
            currHeight = currHeight + height / 18;
            rgb += 10;
        }
        g.setColor(new Color(100, 200, 100));
        g.fillRect(0, height / 3, width, height);
        g.setColor(c);
        g.fillOval(width / 3, height / 3, width * 3 / 4, height * 2 / 3);
        g.fillOval(width / 2, height / 3, width * 3 / 4, height * 2 / 3);
        Oval oval1 = new Oval(width * 3 / 8, height * 2 / 6, width / 3 + width * 3 / 8, height / 3 + height * 2 / 6);
        Oval oval2 = new Oval(width * 3 / 8, height * 2 / 6, width / 2 + width * 3 / 8, height / 3 + height * 2 / 6);
        for (int i = width / 3; i < width; i += width / 6) {
            for (int j = height / 3; j < height * 4 / 5; j += height / 10) {
                if (oval1.IsPointInOval(i, j) || oval2.IsPointInOval(i, j)) {
                    drawWaterLily(g, 50, new Position(i, j));
                }
            }
        }
        int[] yPoints;
        for (int i = width / 3 + 30; i < width * 3 / 4; i += 30) {
            yPoints = oval1.PointOnOval(i);
            g.setColor(Color.BLACK);
            drawTypha(g, new Typha(80, DrawPanel.TYPHA_COLOR, DrawPanel.STUMP_COLOR, new Position(i, yPoints[0])));
            drawTypha(g, new Typha(100, DrawPanel.TYPHA_COLOR, DrawPanel.STUMP_COLOR, new Position(i, yPoints[1])));
        }
    }

    public static void drawWaterLily(Graphics2D g, int length, Position position) {
        g.setColor(new Color(0, 149, 3));
        g.fillArc(position.x, position.y, length, length * 4 / 5, 45, 315);
    }


    public static void drawTreeFirstType(Graphics2D g, Tree tree) {
        Position pos = tree.positionOfStump;
        g.setColor(tree.colorOfLeaves);
        g.fillOval(pos.x - tree.length * 3 / 10, pos.y - tree.length * 3 / 10, tree.length * 2 / 5, tree.length * 2 / 5);
        g.fillOval(pos.x + tree.length / 30, pos.y - tree.length * 3 / 10, tree.length * 2 / 5, tree.length * 2 / 5);
        g.fillOval(pos.x - tree.length / 7, pos.y - tree.length / 2, tree.length * 2 / 5, tree.length * 2 / 5);
        g.setColor(tree.colorOfStump);
        g.fillRect(pos.x, pos.y, tree.length / 10, tree.length * 4 / 9);
        g.fillPolygon(new int[]{pos.x + tree.length / 40, pos.x + tree.length * 3 / 40, pos.x + tree.length * 3 / 40, pos.x + tree.length / 40}, new int[]{pos.y, pos.y, pos.y - tree.length / 3, pos.y - tree.length / 3}, 4);
        g.fillPolygon(new int[]{pos.x + tree.length * 3 / 40, pos.x + tree.length / 10, pos.x + tree.length / 4 + tree.length / 40, pos.x + tree.length / 4}, new int[]{pos.y, pos.y + tree.length / 40, pos.y - tree.length / 4 + tree.length / 40, pos.y - tree.length / 4}, 4);
        g.fillPolygon(new int[]{pos.x + tree.length / 40, pos.x, pos.x - tree.length * 3 / 20 - tree.length / 40, pos.x - tree.length * 3 / 20}, new int[]{pos.y, pos.y + tree.length / 40, pos.y - tree.length / 4 + tree.length / 40, pos.y - tree.length / 4}, 4);
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

    public static void drawTypha(Graphics2D g, Typha typha) {
        g.setColor(typha.colorOfLeaves);
        Position pos = typha.position;
        g.fillRect(pos.x, pos.y - typha.length * 2 / 3, typha.length / 15, typha.length * 2 / 3);
        g.setColor(typha.colorOfHead);
        g.fillOval(pos.x - typha.length / 20, pos.y - typha.length * 7 / 15 - typha.length * 2 / 3,
                typha.length / 6, typha.length / 2);
    }

    public static void drawStump(Graphics2D g, Stump stump) {
        g.setColor(stump.colorOfStump);
        Position pos = stump.position;
        g.fillRect(pos.x, pos.y, stump.length * 2 / 3, stump.length);
        g.fillOval(pos.x, pos.y + stump.length * 9 / 10, stump.length * 2 / 3, stump.length / 5);
        g.setColor(stump.colorOfCut);
        g.fillOval(pos.x, pos.y - stump.length / 6, stump.length * 2 / 3, stump.length / 3);
        g.setColor(stump.colorOfStump);
        int deltaX = stump.length * 2 / (3 * stump.age);
        int deltaY = stump.length / (3 * stump.age);
        for (int i = 1; i <= stump.age; i++) {
            g.drawOval(pos.x + i * deltaX, pos.y - stump.length / 6 + i * deltaY,
                    stump.length * 2 / 3 - deltaX * 2 * i, stump.length / 3 - deltaY * 2 * i);
        }
    }

}
