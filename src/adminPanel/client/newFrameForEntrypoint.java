package adminPanel.client;

import java.awt.Color;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class newFrameForEntrypoint {

    JFrame getFrame;
    JPanel getFormPanel;
    JPanel userControl;
    JTextField createdbyL, modifiedOnL, txtCreatedBy, txtModifiedBy;
    
//    Date modifiedDate = new Date();
//    Date createdByDate = new Date();
//    Date realDate = new Date();
    public Color maingreen = new Color(0, 111, 102);
    private Color formPanelColor = new Color(81, 99, 149);
    public Border dashBorder1 = new LineBorder(Color.BLACK, 1);

    ControlBar_Dsg control = new ControlBar_Dsg();

    int y;

    public JFrame addFrame() {

        getFrame = new JFrame("");
        getFrame.setBounds(0, 0, 1542, 830);
        getFrame.getContentPane().setBackground(maingreen);
        getFrame.setResizable(false);

        getFormPanel = new JPanel(null);
        getFormPanel.setBounds(100, 5, 1328, y);
        getFormPanel.setBackground(Color.WHITE);

        userControl = new JPanel(null);
        userControl.setBounds(0, y - 40, 1328, 45);
        userControl.setBackground(Color.WHITE);

        createdbyL = new JTextField("Created On");
        createdbyL.setBounds(0, 1, 200, 20);
        createdbyL.setEditable(false);
        createdbyL.setForeground(Color.WHITE);
        createdbyL.setBackground(formPanelColor);
        createdbyL.setHorizontalAlignment(SwingConstants.CENTER);
        createdbyL.setBorder(null);

        txtCreatedBy = new JTextField();
        txtCreatedBy.setBounds(0, 21, 200, 20);
        txtCreatedBy.setEditable(false);
        txtCreatedBy.setBackground(Color.WHITE);
        txtCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);

        modifiedOnL = new JTextField("Modified On");
        modifiedOnL.setBounds(1128, 1, 200, 20);
        modifiedOnL.setEditable(false);
        modifiedOnL.setForeground(Color.WHITE);
        modifiedOnL.setBackground(formPanelColor);
        modifiedOnL.setHorizontalAlignment(SwingConstants.CENTER);
        modifiedOnL.setBorder(null);

//        if(realDate== modifiedDate){
//        }
        txtModifiedBy = new JTextField();
        txtModifiedBy.setBounds(1128, 21, 200, 20);
        txtModifiedBy.setEditable(false);
        txtModifiedBy.setBackground(Color.WHITE);
        txtModifiedBy.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel space = new JPanel(null);
        space.setBackground(Color.WHITE);
        space.setBounds(101, 1, 1226, 40);
        space.setBorder(dashBorder1);

        userControl.add(createdbyL);
        userControl.add(txtCreatedBy);
        userControl.add(modifiedOnL);
        userControl.add(txtModifiedBy);
        userControl.add(space);

        getFormPanel.add(userControl);
        getFormPanel.add(control.controlBar());
 

        getFrame.add(getFormPanel);

        getFrame.setLayout(null);
        getFrame.setVisible(true);

        return getFrame;
    }

    public void setFormName(String formName) {

        control.txtFormName.setText(formName);
        control.txtFormName.setHorizontalAlignment(SwingConstants.CENTER);

    }

    public void setFormPanelHeightBounds(int y) {
        this.y = y;
    }
    


}
