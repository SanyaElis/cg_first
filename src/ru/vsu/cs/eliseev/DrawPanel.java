package ru.vsu.cs.eliseev;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final Color SKY_COLOR = new Color(16, 16, 171);
    private static final Color GROUND_COLOR = new Color(100,200,100);
    private static final Color LAKE_COLOR = new Color(21, 123, 197, 255);
    private static final Color LEAVES_COLOR = new Color(225, 202, 46, 255);
    private static final Color STUMP_COLOR = new Color(65, 45, 10, 255);

    private static final Random rnd = new Random();
    private static Timer timer;

    public DrawPanel() {
    }

    //ctrl + o
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        DrawUtils.drawLake(g2d, LAKE_COLOR, this.getHeight(), this.getWidth());
        //g2d.drawLine(0,0,100,50);
        Tree testTree = new Tree(200, new Position(100, 200), LEAVES_COLOR, STUMP_COLOR);
        DrawUtils.drawTreeSecondType(g2d, testTree);
        Tree testTree2 = new Tree(150, new Position(100, 400), LEAVES_COLOR, STUMP_COLOR);
        DrawUtils.drawTreeSecondType(g2d, testTree2);
    }
}
