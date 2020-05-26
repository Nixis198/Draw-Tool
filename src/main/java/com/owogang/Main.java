package com.owogang;

import java.awt.Dimension;

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

    public static JFrame optionsFrame;

    public Main() {
        JFrame mainFrame = new JFrame();
        optionsFrame = new JFrame();
        Canvas canvas = new Canvas(500, 500, 50);
        Options options = new Options(300, 350);

        mainFrame.add(canvas);
        mainFrame.setPreferredSize(new Dimension(506, 529));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Draw");
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        optionsFrame.add(options);
        optionsFrame.setPreferredSize(new Dimension(300, 350));
        optionsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        optionsFrame.setTitle("Options");
        optionsFrame.setResizable(false);
        optionsFrame.pack();
        optionsFrame.setVisible(false);
        optionsFrame.setLocationRelativeTo(null);
    }

    public static JFrame getOptions() {
        return optionsFrame;
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