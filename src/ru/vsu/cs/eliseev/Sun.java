package ru.vsu.cs.eliseev;

import java.awt.*;

public class Sun {
    private Position pos;
    private int radius, lengthOfaRay, numOfRays;
    private Color color;

    public Sun(Position pos, int radius, int lengthOfaRay, int numOfRays, Color color) {
        this.pos = pos;
        this.radius = radius;
        this.lengthOfaRay = lengthOfaRay;
        this.numOfRays = numOfRays;
        this.color = color;
    }


    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getLengthOfaRay() {
        return lengthOfaRay;
    }

    public void setLengthOfaRay(int lengthOfaRay) {
        this.lengthOfaRay = lengthOfaRay;
    }

    public int getNumOfRays() {
        return numOfRays;
    }

    public void setNumOfRays(int numOfRays) {
        this.numOfRays = numOfRays;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
