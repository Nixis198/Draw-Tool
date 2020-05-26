package com.owogang;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class makes Pixels for the 2D array in Canvas.java
 * @author Nixis198
 * @version 1.0
 */
public class ArrayPixel {
    /**
     * Holds the color of the pixel
     */
    private Color m_Color;

    /**
     * Holds the location and the size of the pixel
     */
    private int m_Xcor, m_Ycor, m_size;

    /**
     * Makes a new Pixel object to be put in the 2D array
     * @param color The color of the pixel
     * @param xCoor The X postion of the pixel in the 2D array
     * @param yCoor The Y postion of the pixel in the 2D array
     * @param RES The "Resolution" or size of the pixel
     */
    public ArrayPixel(Color color, int xCoor, int yCoor, int RES) {
        m_Color = color;
        m_Xcor = xCoor;
        m_Ycor = yCoor;
        m_size = RES;
    }

    /**
     * Method to draw the pixel on the grid.
     * @param g The Graphics needed to draw the pixel
     */
    public void draw(Graphics g) {
        g.setColor(m_Color);
        g.fillRect(m_Xcor * m_size, m_Ycor * m_size, m_size, m_size);
    }

    /**
     * Method to get the color of a pixel.
     * @return The color of the pixel.
     */
    public Color getColor() {
        return m_Color;
    }
}