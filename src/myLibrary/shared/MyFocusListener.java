package myLibrary.shared;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFocusListener {

    private JTextField[] textFields;
    private int currentFieldIndex;
    Color bgColor = new Color(155, 237, 255);

    public MyFocusListener(JTextField... fields) {
        textFields = fields;
        currentFieldIndex = 0;

        for (int i = 0; i < fields.length; i++) {
            final JTextField currentField = fields[i];
            final JTextField nextField = (i < fields.length - 1) ? fields[i + 1] : null;

            if (nextField != null) {
                currentField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nextField.setBackground(bgColor);
                        nextField.requestFocusInWindow();
                        nextField.repaint();
                    }
                });
            }
        }
    }

    public void startTraversal() {
        textFields[0].requestFocusInWindow();
    }
}
