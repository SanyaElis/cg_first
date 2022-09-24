package ru.vsu.cs.eliseev;
// (x - x0)^2 / a^2 + (y - y0)^2 / b^2 = 1
public class Oval {

    final int a;
    final int b;
    final int x0;
    final int y0;


    public Oval(int a, int b, int x0, int y0) {
        this.a = a;
        this.b = b;
        this.x0 = x0;
        this.y0 = y0;
    }

    /**
     *
     * @param x
     * @param y
     * @return подходит ли точка для рисования кувшинки
     */
    public  boolean IsPointInOval(int x, int y){
        return 1 > (x - x0) * (x - x0) / (a * a) + (y - y0) * (y - y0) / (b * b) ;
    }

    /**
     *
     * @param x
     * @return точка для рисования рогоза
     */
    public static int PointOnOval(int x){
        return 0;
    }
}
