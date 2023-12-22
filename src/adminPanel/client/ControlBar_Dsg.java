package adminPanel.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ControlBar_Dsg {

    public JPanel controlBar;
    public JPanel formNamePanel;
    public JButton saveButton;
    public JButton editButton;
    public JButton deleteButton;
    public JButton searchButton;
    public JButton addButton;
    public JButton printButton;
    public JLabel txtFormName;

    ImageIcon saveImage, editImage, deleteImage, searchImage, addImage, printImage;

    private Color controlBarColor = new Color(215, 215, 215);
    private Color controlBarColorBorder = new Color(180, 180, 180);
    private Color formPanelColor = new Color(81, 99, 149);

    Border controlBarButtonBorder = new LineBorder(controlBarColor);
    Border controlBarBorder = new LineBorder(controlBarColorBorder);

    public JPanel controlBar() {
        controlBar = new JPanel(null);
        controlBar.setBounds(0, 0, 1328, 30);
        controlBar.setBackground(controlBarColor);
        controlBar.setBorder(controlBarBorder);

        addImage = new ImageIcon("src\\pictures used\\add.png");
        searchImage = new ImageIcon("src\\pictures used\\search.png");
        editImage = new ImageIcon("src\\pictures used\\edit.png");
        deleteImage = new ImageIcon("src\\pictures used\\delete.png");
        saveImage = new ImageIcon("src\\pictures used\\save.png");
        printImage = new ImageIcon("src\\pictures used\\print.png");

        addButton = new JButton(addImage);
        addButton.setBackground(controlBarColor);
        addButton.setBorder(controlBarButtonBorder);
        addButton.setBounds(0, 0, 30, 29);
        addButton.setToolTipText("Add");

        searchButton = new JButton(searchImage);
        searchButton.setBackground(controlBarColor);
        searchButton.setBorder(controlBarButtonBorder);
        searchButton.setBounds(30, 0, 30, 29);
        searchButton.setToolTipText("Search");

        editButton = new JButton(editImage);
        editButton.setBackground(controlBarColor);
        editButton.setBorder(controlBarButtonBorder);
        editButton.setBounds(59, 0, 30, 29);
        editButton.setToolTipText("Update");

        deleteButton = new JButton(deleteImage);
        deleteButton.setBackground(controlBarColor);
        deleteButton.setBorder(controlBarButtonBorder);
        deleteButton.setBounds(118, 0, 30, 29);
        deleteButton.setToolTipText("Delete");

        saveButton = new JButton(saveImage);
        saveButton.setBackground(controlBarColor);
        saveButton.setBorder(controlBarButtonBorder);
        saveButton.setBounds(89, 0, 30, 29);
        saveButton.setToolTipText("Save");

        printButton = new JButton(printImage);
        printButton.setBackground(controlBarColor);
        printButton.setBorder(controlBarButtonBorder);
        printButton.setBounds(147, 0, 30, 29);
        printButton.setToolTipText("Print");

        formNamePanel = new JPanel(null);
        formNamePanel.setBounds(1128, 0, 200, 29);
        formNamePanel.setBackground(formPanelColor);

        txtFormName = new JLabel("Test");
        txtFormName.setForeground(Color.WHITE);
        txtFormName.setBounds(1, 0, 200, 28);

        txtFormName.setFont(new Font("Arial", Font.BOLD, 14));

        formNamePanel.add(txtFormName);

        controlBar.add(saveButton);
        controlBar.add(editButton);
        controlBar.add(deleteButton);
        controlBar.add(addButton);
        controlBar.add(searchButton);
        controlBar.add(printButton);
        controlBar.add(formNamePanel);

        controlButtonHoverEffect(addButton);
        controlButtonHoverEffect(saveButton);
        controlButtonHoverEffect(editButton);
        controlButtonHoverEffect(deleteButton);
        controlButtonHoverEffect(searchButton);
        controlButtonHoverEffect(printButton);

        formNamePanel.addMouseListener(new MouseListener() {
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
                formNamePanel.setBackground(Color.WHITE);
                txtFormName.setForeground(formPanelColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                formNamePanel.setBackground(formPanelColor);
                txtFormName.setForeground(Color.WHITE);
            }
        });

        return controlBar;
    }

    private void controlButtonHoverEffect(JButton button) {

        button.addMouseListener(new MouseListener() {
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
                button.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(controlBarColor);
            }
        });

    }

}
