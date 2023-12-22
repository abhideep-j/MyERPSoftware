package myLibrary.shared;

import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BackgroundColorChanger {

    private Color focusBackgroundColor;
    private Color unfocusedBackgroundColor;

    public BackgroundColorChanger(Color focusColor, Color unfocusedColor) {
        focusBackgroundColor = focusColor;
        unfocusedBackgroundColor = unfocusedColor;
    }

    public void setFocusListeners(JTextField... textFields) {
        for (JTextField textField : textFields) {
            textField.setBackground(unfocusedBackgroundColor);

            textField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    textField.setBackground(focusBackgroundColor);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    textField.setBackground(unfocusedBackgroundColor);
                }
            });
        }
    }
        public void setFocusListenersforJCombo(JComboBox... comboBoxs) {
        for (JComboBox comboBox : comboBoxs) {
            comboBox.setBackground(unfocusedBackgroundColor);

            comboBox.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    comboBox.setBackground(focusBackgroundColor);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    comboBox.setBackground(unfocusedBackgroundColor);
                }
            });
        }
    }
}
