package com.owogang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Options extends JPanel {
    private static final long serialVersionUID = 1L;

    public JButton save;
    public JButton load;

    public int m_WIDTH, m_HEIGHT;

    public Options(int WIDTH, int HEIGHT) {
        setFocusable(true);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        m_WIDTH = WIDTH;
        m_HEIGHT = HEIGHT;

        makeSaveButton();
        makeLoadButton();

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveButtonPressed();
            }

        });

        load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadButtonPressed();
            }

        });
    }

    public void makeSaveButton() {
        save = new JButton("Save");
        this.add(save);
        save.setVisible(true);
    }

    public void makeLoadButton() {
        load = new JButton("Load");
        this.add(load);
        load.setVisible(true);
    }

    public void saveButtonPressed() {
        saveToFile(Canvas.getArray());
    }

    public void loadButtonPressed() {
        Canvas.gridArray = readFromFile();
        Canvas.can.repaint();
    }

    // this boi works
    public static int[][] pixelsToNumbers(ArrayPixel[][] pixelarray) {
        int[][] array = new int[Canvas.getArrayWidth()][Canvas.getArrayHeight()];
        for (int i = 0; i < pixelarray.length; i++) {
            for (int j = 0; j < pixelarray[0].length; j++) {
                if (pixelarray[i][j].getColor() == Color.WHITE) {array[i][j] = 0;}
                if (pixelarray[i][j].getColor() == Color.BLACK) {array[i][j] = 1;}
                if (pixelarray[i][j].getColor() == Color.BLUE) {array[i][j] = 2;}
                if (pixelarray[i][j].getColor() == Color.GREEN) {array[i][j] = 3;}
                if (pixelarray[i][j].getColor() == Color.MAGENTA) {array[i][j] = 4;}
                if (pixelarray[i][j].getColor() == Color.ORANGE) {array[i][j] = 5;}
                if (pixelarray[i][j].getColor() == Color.PINK) {array[i][j] = 6;}
                if (pixelarray[i][j].getColor() == Color.RED) {array[i][j] = 7;}
                if (pixelarray[i][j].getColor() == Color.YELLOW) {array[i][j] = 8;}
                if (pixelarray[i][j].getColor() == Color.CYAN) {array[i][j] = 9;}
                if (pixelarray[i][j].getColor() == Color.GRAY) {array[i][j] = 10;}
            }
        }
        return array;
    }

    // this boi seems to work
    public ArrayPixel[][] numbersToPixels(int[][] array) {
        ArrayPixel[][] pixelarray = new ArrayPixel[Canvas.getArrayWidth()][Canvas.getArrayHeight()];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {pixelarray[i][j] = new ArrayPixel(Color.WHITE, i, j, Canvas.getRes());}
                if (array[i][j] == 1) {pixelarray[i][j] = new ArrayPixel(Color.BLACK, i, j, Canvas.getRes());}
                if (array[i][j] == 2) {pixelarray[i][j] = new ArrayPixel(Color.BLUE, i, j, Canvas.getRes());}
                if (array[i][j] == 3) {pixelarray[i][j] = new ArrayPixel(Color.GREEN, i, j, Canvas.getRes());}
                if (array[i][j] == 4) {pixelarray[i][j] = new ArrayPixel(Color.MAGENTA, i, j, Canvas.getRes());}
                if (array[i][j] == 5) {pixelarray[i][j] = new ArrayPixel(Color.ORANGE, i, j, Canvas.getRes());}
                if (array[i][j] == 6) {pixelarray[i][j] = new ArrayPixel(Color.PINK, i, j, Canvas.getRes());}
                if (array[i][j] == 7) {pixelarray[i][j] = new ArrayPixel(Color.RED, i, j, Canvas.getRes());}
                if (array[i][j] == 8) {pixelarray[i][j] = new ArrayPixel(Color.YELLOW, i, j, Canvas.getRes());}
                if (array[i][j] == 9) {pixelarray[i][j] = new ArrayPixel(Color.CYAN, i, j, Canvas.getRes());}
                if (array[i][j] == 10) {pixelarray[i][j] = new ArrayPixel(Color.GRAY, i, j, Canvas.getRes());
                }
            }
        }
        return pixelarray;
    }

    public void saveToFile(ArrayPixel[][] pixelarray) {
        StringBuilder builder = new StringBuilder();
        int[][] array = pixelsToNumbers(pixelarray);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                builder.append(array[j][i] + "");
                if (j < array.length - 1) {
                    builder.append(",");
                }
            }
            builder.append("\n");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("draw.owo"));
            writer.write(builder.toString());
            writer.close();
            //System.out.println("Saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayPixel[][] readFromFile() {
        String saveFile = "draw.owo";
        int[][] array = new int[Canvas.getArrayWidth()][Canvas.getArrayHeight()];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(saveFile));
            String line = "";
            int row = 0;
            try {
                while ((line = reader.readLine()) != null) {
                    String[] cols = line.split(",");
                    int col = 0;
                    for(String c: cols) {
                        array[col][row] = Integer.parseInt(c);
                        col++;
                    }
                    row++;
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return numbersToPixels(array);
    }
}