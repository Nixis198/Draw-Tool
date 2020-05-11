package com.owogang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.SwingUtilities;

public class Canvas extends JPanel implements MouseInputListener, KeyListener {
    private static final long serialVersionUID = 1L;

    private static final int WIDTH = 500, HEIGHT = 500;

    private ArrayList<Pixels> grid;

    private Color m_color = Color.BLACK;

    public Canvas() {
        setFocusable(true);

        addMouseListener(this);
        addKeyListener(this);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        grid = new ArrayList<Pixels>();
    }

    public void setColor(Color color) {
        m_color = color;
    }

    public Color getColor(){
        return m_color;
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < grid.size(); i++) {
            grid.get(i).draw(g);
        }
        g.setColor(Color.black);
        for(int i = 0; i < WIDTH / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
        }
        for(int i = 0; i < HEIGHT / 10; i++) {
            g.drawLine(0, i * 10, WIDTH, i * 10);
        }
    }

    public void paintSquare(int xCoor, int yCoor, boolean isRight) {
        if(isRight) {
            grid.add(new Pixels(xCoor, yCoor, Color.WHITE, 10));
        }else {
            grid.add(new Pixels(xCoor, yCoor, getColor(), 10));
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        paintSquare(e.getX() / 10, e.getY() / 10, SwingUtilities.isRightMouseButton(e));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_1: setColor(Color.BLACK); break;
            case KeyEvent.VK_2: setColor(Color.BLUE); break;
            case KeyEvent.VK_3: setColor(Color.GREEN); break;
            case KeyEvent.VK_4: setColor(Color.MAGENTA); break;
            case KeyEvent.VK_5: setColor(Color.ORANGE); break;
            case KeyEvent.VK_6: setColor(Color.PINK); break;
            case KeyEvent.VK_7: setColor(Color.RED); break;
            case KeyEvent.VK_8: setColor(Color.YELLOW); break;
            case KeyEvent.VK_9: setColor(Color.CYAN); break;
            case KeyEvent.VK_0: setColor(Color.GRAY); break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}