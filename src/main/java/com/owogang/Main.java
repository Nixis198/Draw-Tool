package com.owogang;

import javax.swing.JFrame;

public class Main {

    public Main() {
        JFrame mainFrame = new JFrame();
        Canvas canvas = new Canvas();

        mainFrame.add(canvas);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Draw");
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Main();
    }
}