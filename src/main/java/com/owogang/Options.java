package com.owogang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Options extends JPanel implements MouseInputListener {
    private static final long serialVersionUID = 1L;

    public JButton save;

    public Options(int WIDTH, int HEIGHT) {
        setFocusable(true);

        addMouseListener(this);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        makeSaveButton();

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveButtonPressed();
            }
            
        });
    }

    public void makeSaveButton() {
        save = new JButton("Save");
        this.add(save);
        save.setVisible(true);
    }

    public void saveButtonPressed() {
        for(int[] row : pixelsToNumbers(Canvas.getArray())) {
            System.out.println(Arrays.toString(row));
        }
    }

    // this boi works
    public int[][] pixelsToNumbers(ArrayPixel[][] pixelarray) {
        int[][] array = new int[Canvas.getArrayWidth()][Canvas.getArrayHeight()];
        for(int i = 0; i < pixelarray.length; i++) {
            for(int j = 0; j < pixelarray[0].length; j++) {
                if(pixelarray[i][j].getColor() == Color.WHITE) {array[j][i] = 0;}
                if(pixelarray[i][j].getColor() == Color.BLACK) {array[j][i] = 1;}
                if(pixelarray[i][j].getColor() == Color.BLUE) {array[j][i] = 2;}
                if(pixelarray[i][j].getColor() == Color.GREEN) {array[j][i] = 3;}
                if(pixelarray[i][j].getColor() == Color.MAGENTA) {array[j][i] = 4;}
                if(pixelarray[i][j].getColor() == Color.ORANGE) {array[j][i] = 5;}
                if(pixelarray[i][j].getColor() == Color.PINK) {array[j][i] = 6;}
                if(pixelarray[i][j].getColor() == Color.RED) {array[j][i] = 7;}
                if(pixelarray[i][j].getColor() == Color.YELLOW) {array[j][i] = 8;}
                if(pixelarray[i][j].getColor() == Color.CYAN) {array[j][i] = 9;}
                if(pixelarray[i][j].getColor() == Color.GRAY) {array[j][i] = 10;}
            }
        }
        return array;
    }

    // this boi idk if it works
    public ArrayPixel[][] numbersToPixels(int[][] array) {
        ArrayPixel[][] pixelarray = new ArrayPixel[Canvas.getArrayWidth()][Canvas.getArrayHeight()];
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                if(array[i][j] == 0) {pixelarray[i][j] = new ArrayPixel(Color.WHITE, i, j, Canvas.getRes());}
                if(array[i][j] == 1) {pixelarray[i][j] = new ArrayPixel(Color.BLACK, i, j, Canvas.getRes());}
                if(array[i][j] == 2) {pixelarray[i][j] = new ArrayPixel(Color.BLUE, i, j, Canvas.getRes());}
                if(array[i][j] == 3) {pixelarray[i][j] = new ArrayPixel(Color.GREEN, i, j, Canvas.getRes());}
                if(array[i][j] == 4) {pixelarray[i][j] = new ArrayPixel(Color.MAGENTA, i, j, Canvas.getRes());}
                if(array[i][j] == 5) {pixelarray[i][j] = new ArrayPixel(Color.ORANGE, i, j, Canvas.getRes());}
                if(array[i][j] == 6) {pixelarray[i][j] = new ArrayPixel(Color.PINK, i, j, Canvas.getRes());}
                if(array[i][j] == 7) {pixelarray[i][j] = new ArrayPixel(Color.RED, i, j, Canvas.getRes());}
                if(array[i][j] == 8) {pixelarray[i][j] = new ArrayPixel(Color.YELLOW, i, j, Canvas.getRes());}
                if(array[i][j] == 9) {pixelarray[i][j] = new ArrayPixel(Color.CYAN, i, j, Canvas.getRes());}
                if(array[i][j] == 10) {pixelarray[i][j] = new ArrayPixel(Color.GRAY, i, j, Canvas.getRes());}
            }
        }
        return pixelarray;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
    
}