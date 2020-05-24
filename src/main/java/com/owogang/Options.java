package com.owogang;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

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