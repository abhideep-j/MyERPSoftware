package myLibrary.shared;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.xmlbeans.impl.common.JarHelper;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class MyLibrary {

    JTextField numericTextField;
    int columns;

    public String sNull(String x) {
        if (x == null) {
            return "";
        } else {
            x = x.trim();
            return x;
        }
    }

    public JTextField createNumericTextFieldWithLimit(int columns, int digitLimit, boolean showRedLine) {
        SpecialJTextField numericTextField = new SpecialJTextField(columns);
        numericTextField.setShowRedLine(showRedLine);

        numericTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = numericTextField.getText();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE ))){
                    e.consume();
                }
                if (c == '.' && text.contains(".")) {
                    e.consume();
                }

                if (numericTextField.getText().length() >= digitLimit) {
                    e.consume();
                }
            }
        });

        return numericTextField;
    }

    public static SpecialJTextField createSpecialJTextField(int columns, boolean showRedLine) {
        SpecialJTextField textField = new SpecialJTextField(columns);
        textField.setShowRedLine(showRedLine);
        return textField;
    }

    public static SpecialJComboBox createSpecialJComboBox(Object[] items, boolean showRedLine) {
        SpecialJComboBox comboBox = new SpecialJComboBox(items);
        comboBox.setToolTipText("Enter text to Find");
        comboBox.setShowRedLine(showRedLine);
        AutoCompleteDecorator.decorate(comboBox); // Decorate the JComboBox
        return comboBox;
    }

    public boolean validatePanCard(String panNumber) {
        // Regular expression pattern for Indian PAN card number
        Pattern pattern = Pattern.compile("^[A-Z]{3}[PCHFATBLJG][A-Z]\\d{4}[A-Z]$");
        return pattern.matcher(panNumber).matches();
    }

    public boolean validateGSTINwithPAN(String gstin) {
        // Regular expression pattern for Indian GSTIN
//        Pattern pattern = Pattern.compile("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}[Z0-9]{1}$");
//
//        Matcher matcher = pattern.matcher(gstin);
//        if (matcher.matches()) {
//            // Extract PAN from GSTIN
//            String extractedPAN = gstin.substring(2, 12);
//            return validatePanCard(extractedPAN);
//        }
        return false;
    }
}

class SpecialJTextField extends JTextField {

    private boolean showRedLine = false;

    public SpecialJTextField(int columns) {
        super(columns);
    }

    public void setShowRedLine(boolean showRedLine) {
        this.showRedLine = showRedLine;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (showRedLine) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, 3, getHeight());
        }
    }
}

class SpecialJComboBox extends JComboBox {

    private boolean showRedLine = false;

    public SpecialJComboBox(Object[] items) {
        super(items);
    }

    public void setShowRedLine(boolean showRedLine) {
        this.showRedLine = showRedLine;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (showRedLine) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, 3, getHeight());
        }
    }

}
