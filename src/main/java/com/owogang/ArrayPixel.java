package com.owogang;

import java.awt.Color;
import java.awt.Graphics;

public class ArrayPixel {
    private Color m_Color;
    private int m_Xcor, m_Ycor, m_size;

    public ArrayPixel(Color color, int xCoor, int yCoor, int RES) {
        m_Color = color;
        m_Xcor = xCoor;
        m_Ycor = yCoor;
        m_size = RES;
    }

    public void draw(Graphics g) {
        g.setColor(m_Color);
        g.fillRect(m_Xcor * m_size, m_Ycor * m_size, m_size, m_size);
    }
}