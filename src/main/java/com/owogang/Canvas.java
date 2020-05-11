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

    private static final int WIDTH = 500, HEIGHT = 500, RES = 10;

    private ArrayPixel[][] gridArray;

    private Color m_color = Color.BLACK;

    public Canvas() {
        setFocusable(true);

        addMouseListener(this);
        addKeyListener(this);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        gridArray = new ArrayPixel[WIDTH / RES][HEIGHT / RES];

        fillGrid();
    }

    public void fillGrid(){
        for(int i = 0; i < WIDTH / RES; i++) {
            for(int j = 0; j < HEIGHT / RES; j++) {
                gridArray[i][j] = new ArrayPixel(Color.WHITE, i, j, RES);
            }
        }
    }

    public void setColor(Color color) {
        m_color = color;
    }

    public Color getColor(){
        return m_color;
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < gridArray.length; i++) {
            for(int j = 0; j < gridArray[0].length; j++) {
                gridArray[i][j].draw(g);
            }
        }

        g.setColor(Color.black);
        for(int i = 0; i < WIDTH / RES; i++) {
            g.drawLine(i * RES, 0, i * RES, HEIGHT);
        }
        for(int i = 0; i < HEIGHT / RES; i++) {
            g.drawLine(0, i * RES, WIDTH, i * RES);
        }
    }

    public void paintSquare(int xCoor, int yCoor, boolean isRight) {
        if(isRight) {
            gridArray[xCoor][yCoor] = new ArrayPixel(Color.WHITE, xCoor, yCoor, RES);
        }else {
            gridArray[xCoor][yCoor] = new ArrayPixel(getColor(), xCoor, yCoor, RES);
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        paintSquare(e.getX() / RES, e.getY() / RES, SwingUtilities.isRightMouseButton(e));
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