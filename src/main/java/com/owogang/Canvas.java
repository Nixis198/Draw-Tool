package com.owogang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.SwingUtilities;

public class Canvas extends JPanel implements MouseInputListener, KeyListener {
    private static final long serialVersionUID = 1L;

    public static Canvas can;

    private static int m_WIDTH, m_HEIGHT, m_RES;

    public static ArrayPixel[][] gridArray;

    private Color m_color = Color.BLACK;

    public Canvas(int WIDTH, int HEIGHT, int RES) {
        setFocusable(true);

        addMouseListener(this);
        addKeyListener(this);

        can = this;

        m_WIDTH = WIDTH;
        m_HEIGHT = HEIGHT;
        m_RES = RES;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        gridArray = new ArrayPixel[WIDTH / RES][HEIGHT / RES];

        fillGrid();
    }

    public static ArrayPixel[][] getArray() {
        return gridArray;
    }

    public void fillGrid(){
        for(int i = 0; i < m_WIDTH / m_RES; i++) {
            for(int j = 0; j < m_HEIGHT / m_RES; j++) {
                gridArray[i][j] = new ArrayPixel(Color.WHITE, i, j, m_RES);
            }
        }
    }

    public void runPaint() {
        repaint();
    }

    public void setColor(Color color) {
        m_color = color;
    }

    public Color getColor(){
        return m_color;
    }

    public static int getArrayWidth() {
        return m_WIDTH / m_RES;
    }

    public static int getArrayHeight() {
        return m_HEIGHT / m_RES;
    }

    public static int getRes() {
        return m_RES;
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < gridArray.length; i++) {
            for(int j = 0; j < gridArray[0].length; j++) {
                gridArray[i][j].draw(g);
            }
        }

        g.setColor(Color.black);
        for(int i = 0; i < m_WIDTH / m_RES; i++) {
            g.drawLine(i * m_RES, 0, i * m_RES, m_HEIGHT);
        }
        for(int i = 0; i < (m_HEIGHT / m_RES); i++) {
            g.drawLine(0, i * m_RES, m_WIDTH, i * m_RES);
        }
    }

    public void paintSquare(int xCoor, int yCoor, boolean isRight) {
        try {
            if(isRight) {
                gridArray[xCoor][yCoor] = new ArrayPixel(Color.WHITE, xCoor, yCoor, m_RES);
            }else {
                gridArray[xCoor][yCoor] = new ArrayPixel(getColor(), xCoor, yCoor, m_RES);
            }
            repaint();
        } catch (Exception e) {
            
        }
        
    }

    public void openOptions(){
        Main.optionsFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        paintSquare(e.getX() / m_RES, e.getY() / m_RES, SwingUtilities.isRightMouseButton(e));
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
            case KeyEvent.VK_ESCAPE: openOptions(); break;
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