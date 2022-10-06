package ru.vsu.cs.eliseev;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    public static final Color SUN_COLOR = new Color(255, 226, 44);
    public static final Color LAKE_COLOR = new Color(21, 123, 197, 255);
    public static final Color LEAVES_COLOR = new Color(225, 202, 46, 255);
    public static final Color LEAVES_COLOR_SECOND = new Color(53, 148, 42, 255);
    public static final Color STUMP_COLOR = new Color(65, 45, 10, 255);
    public static final Color CUT_COLOR = new Color(185, 130, 34, 255);
    public static final Color TYPHA_COLOR = new Color(228, 217, 111, 255);

    private static final Random rnd = new Random();

    public DrawPanel() {
    }

    //ctrl + o
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Sun sun = new Sun(new Position(this.getWidth() * 5 / 6, this.getHeight() / 5), this.getWidth() / 18, this.getWidth() / 9, 0, SUN_COLOR);

        DrawUtils.drawLake(g2d, LAKE_COLOR, this.getHeight(), this.getWidth());
        sun.drawSun(g2d);
        int k;
        for (int i = 0; i < this.getWidth() / 3; i += this.getWidth() / 8) {
            for (int j = this.getHeight() / 3; j < this.getHeight() * 5 / 6; j += this.getHeight() / 7) {
                k = rnd.nextInt(3);
                if (k == 0) {
                    Tree myTreeType1 = new Tree(this.getHeight() / 3 - rnd.nextInt(0, this.getHeight() / 10), new Position(i, j), LEAVES_COLOR, STUMP_COLOR);
                    DrawUtils.drawTreeFirstType(g2d, myTreeType1);
                } else if (k == 1) {
                    Tree myTreeType2 = new Tree(this.getHeight() / 3 - rnd.nextInt(0, this.getHeight() / 10), new Position(i + rnd.nextInt(0, this.getHeight() / 10), j), LEAVES_COLOR_SECOND, STUMP_COLOR);
                    DrawUtils.drawTreeSecondType(g2d, myTreeType2);
                } else {
                    Stump myStump = new Stump(new Position(i, j), STUMP_COLOR, CUT_COLOR, rnd.nextInt(4, 10), this.getWidth() / 15);
                    DrawUtils.drawStump(g2d, myStump);
                }
            }
        }
    }
}
