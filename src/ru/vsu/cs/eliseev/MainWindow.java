package ru.vsu.cs.eliseev;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private DrawPanel panel = new DrawPanel();

    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        this.add(panel);
    }
}
