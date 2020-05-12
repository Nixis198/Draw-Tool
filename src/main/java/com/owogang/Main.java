package com.owogang;

import javax.swing.JFrame;

/**
 * The Draw Tool program is a simple (for now) program
 * that lets you make simple pixel art.
 * 
 * @author Nixis198
 * @version 1.0
 * @since 5-11-2020
 */

public class Main {

    /**
     * This method is used to makes the main window and adds the drawing window.
     */

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

    /**
     * The main method which just makes a window.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
        new Main();
    }
}