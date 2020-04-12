package com.owogang;

import java.awt.Color;
import java.awt.Graphics;

public class Pixels {

    private int m_xCoor, m_yCoor, m_width, m_hight;
    private Color m_color;

    public Pixels(int xCoor, int yCoor, Color color, int size) {
        m_xCoor = xCoor;
        m_yCoor = yCoor;
        m_color = color;
        m_hight = size;
        m_width = size;
    }

    public void draw(Graphics g) {
        g.setColor(m_color);
        g.fillRect(m_xCoor * m_width, m_yCoor * m_hight, m_width, m_hight);
    }

}