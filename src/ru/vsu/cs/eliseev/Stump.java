package ru.vsu.cs.eliseev;

import java.awt.*;

public class Stump {
    final Position position;
    final Color colorOfStump;
    final Color colorOfCut;
    final int age;
    final int length;

    public Stump(Position position, Color colorOfStump, Color colorOfCut, int age, int length) {
        this.position = position;
        this.colorOfStump = colorOfStump;
        this.colorOfCut = colorOfCut;
        this.age = age;
        this.length = length;
    }
}
