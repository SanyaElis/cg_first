package ru.vsu.cs.eliseev;

import java.awt.*;

public class Tree {
    final int length;
    final Color colorOfLeaves;
    final Color colorOfStump;
    final Position positionOfStump;

    public Tree(int length, Position position, Color leaves, Color stump) {
        this.length = length;
        this.positionOfStump = position;
        this.colorOfLeaves = leaves;
        this.colorOfStump = stump;
    }
}
