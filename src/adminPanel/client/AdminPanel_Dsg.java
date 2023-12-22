package adminPanel.client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import adminPanel.shared.Area_MastModel;
import adminPanel.shared.Department_MastModel;
import adminPanel.shared.DesignationMastModel;
import adminPanel.shared.Employee_MastModel;
import adminPanel.shared.Enquiry_Model;
import adminPanel.shared.Indent_Model;
import adminPanel.shared.ItemCategory_MastModel;
import adminPanel.shared.Item_MastModel;
import adminPanel.shared.Party_MastModel;
import adminPanel.shared.Requisition_Model;
import myLibrary.shared.MyFocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import myLibrary.shared.MyLibrary;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.ScrollBar;
import javax.imageio.ImageIO;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import myLibrary.shared.BackgroundColorChanger;

public class AdminPanel_Dsg {

    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate1 = dateFormat.format(currentDate);

    String[] test = new String[]{"Test"};
    String[] gstbasedOn = new String[]{"Fixed"};
    String[] gstnature = new String[]{"GST", "NON GST", "Exempted", "Nill Rated"};
    String[] gstType = new String[]{"Nill", "5%", "12%", "18%", "28%"};
    String[] tdscat = new String[]{"Tax Deducted on source on Advertising", "TCS @1%", "TCS @0.1%", "TCS on Sales @0.1%", "TDS on Advertising @2%", "TDS on Frieght @1%", "TDS on Commision @5%", "TDS on jobwork @2%", "TDS on Professional Fee @5% ", "TDS on Salary", "Any other form of tax"};
    String[] tcsCat = new String[]{"TCS @0.1%", "TCS @1%", "TCS on Sale @.1%"};
    String[] nametype = new String[]{"Mr.", "Miss.", "Shri", "Dr.", "Mrs."};
    String[] unitData = {
        "Meter/m",
        "Kilogram/kg",
        "Liter/L",
        "Pound/lb",
        "Gallon/gal",
        "Centimeter/cm",
        "Millimeter/mm",
        "Inch/in",
        "Foot/ft",
        "Ounce/oz",
        "Gram/g",
        "Milliliter/mL",
        "Fluid Ounce/fl oz",
        "Piece/pc",
        "Square Meter/m²",
        "Square Foot/ft²",
        "Cubic Meter/m³",
        "Cubic Foot/ft³",
        "Milligram/mg",
        "Tonne/t",
        "Pint/pt",
        "Quart/qt",
        "Dozen/doz"
    };
    String[] yesNo = new String[]{"Yes", "No"};

    boolean duplicate;
    MyLibrary myLib = new MyLibrary();
    JTextField searchfield;
    JTextField searchfield2;
    JButton search;

    /*text fields for Employee master*/
    newFrameForEntrypoint entryPoint = new newFrameForEntrypoint();
    Employee_MastModel employeeModel = new Employee_MastModel();

    JFrame EmpmasterFrame;

    JLabel nameL;
    JComboBox<String> mrmrs;
    JTextField empName;

    JLabel displayNameL;
    JTextField empDisplayName;

    JLabel genderL;
    JComboBox<String> empGender;

    JLabel empCodeL;
    JTextField empCode;

    JLabel maritalStatusL;
    JComboBox<String> empMaritalStatus;

    JLabel empSpouseL;
    JTextField empSpouse;

    JLabel religionL;
    JComboBox<String> empReligion;

    JLabel natL;
    JComboBox<String> empNature;

    JLabel desigL;
    JComboBox<String> empDesignation;

    JLabel deparL;
    JComboBox<String> empDepartment;

    JLabel fatherNameL;
    JTextField empFatherName;

    JLabel phoneNoL;
    JTextField empPhoneNo;

    JLabel mobileL;
    JTextField empMobileNo;

    JLabel adharL;
    JTextField empAdhar;

    JLabel permanentAddressL;

    JLabel addressL;
    JTextField empAddress;

    JLabel cityL;
    JComboBox<String> empCity;

    JLabel countryL;
    JTextField empCountry;

    JLabel pinL;
    JTextField empPincode;

    JLabel temporaryAddressL;
    JButton temporaryButton;

    JLabel taddressL;
    JTextField tEmpAddress;

    JLabel tcityL;
    JComboBox<String> tEmpCity;

    JLabel tcountryL;
    JTextField tEmpCountry;

    JLabel tpinL;
    JTextField tEmpPincode;
//////////////////////////////////////
    JLabel empdobL;
    JTextField empDob;

    JLabel empdojL;
    JTextField empDoj;

    JLabel addEmpPhoto;
    JButton addEmpPhotoButton;

    JLabel empRsignationL;
    JTextField empResignation;

    JLabel bloodGroupL;
    JComboBox<String> bloodgroup;

    JLabel emppanL;
    JTextField empPan;

    JLabel empifscL;
    JTextField empifsc;

    JLabel empBankAccL;
    JTextField empBankAcc;

    JLabel empPFAccL;
    JTextField empPFAcc;

    JLabel empLicenseL;
    JTextField empLicense;

    JLabel empPassportL;
    JTextField empPassport;

    JLabel empQualificationL;
    JTextField empQualification;

    JLabel empTDSL;
    JComboBox<String> empTDS;

    JLabel empActiveL;
    JComboBox<String> empActive;

    JLabel empRemarkL;
    JTextField empRemark;

    File employeeImageFile;
    JLabel empImage;
    byte[] empImageByte;
    ImageIcon empimagePhotoIcon;

    String moverecCodeforEmpM;

    public int employeeSearchby;

    /*text fields for designation master*/
    JFrame desMasterFrame;

    newFrameForEntrypoint entryPointDes = new newFrameForEntrypoint();
    DesignationMastModel model = new DesignationMastModel();

    JLabel designationL;
    JLabel designationShortNameL;
    JLabel designationCodeL;

    protected JTextField designation;
    protected JTextField designationShortName;
    protected JTextField designationCode;
    String moverecCodeforDesM;

    public int designationsearchby;

    /*text fields for department master*/
    JFrame depMasterFrame;
    newFrameForEntrypoint entryPointDep = new newFrameForEntrypoint();
    Department_MastModel Departmentmodel = new Department_MastModel();

    JLabel departmentL;
    JLabel departmentShortNameL;
    JLabel natureL;
    JLabel activeL;
    JLabel depCodeL;

    protected JTextField department;
    protected JTextField departmentShortName;
    protected JTextField depCode;
    protected JComboBox<String> nature;
    protected JComboBox<String> active;
    String moverecCodeforDepM;

    public int departmentsearchby;


    /*text fields for area master*/
    newFrameForEntrypoint entryPointArea = new newFrameForEntrypoint();
    Area_MastModel AreaModel = new Area_MastModel();

    JFrame areaMasterFrame;

    JLabel areaL;
    JLabel parentAreaL;

    protected JTextField area;
    protected JComboBox<String> parentArea;

    String moverecCodeforAreaM;

    public int areasearchby;
    /*text fields for Item master*/
    newFrameForEntrypoint entryPointItem = new newFrameForEntrypoint();
    Item_MastModel itemMasterModel = new Item_MastModel();

    JFrame itemMasterFrame;

    JLabel line;
    JLabel itemL;
    JLabel itemCodeL;
    JLabel itemCategorySelectL;
    JLabel itemHSNL;
    JLabel itemDescriptionL;
    JLabel itemPropertyL;
    JLabel indentReqL;
    JLabel pOReqL;
    JLabel gSTNatureL;
    JLabel itemGSTBasedOnL;
    JLabel purchaseUnitL;
    JLabel salesUnitL;
    JLabel itemSKUL;
    JLabel itemGSTTypeL;
    JLabel itemSaleReturnableTypeL;
    JLabel itemActiveL;
    JLabel itemRemarkL;

    protected JTextField itemRemark;
    protected JTextField item;
    protected JTextField itemCode;
    protected JComboBox<String> itemCategorySelect;
    protected JComboBox<String> itemHSN;
    protected JTextArea itemDescription;
    JScrollPane scrollPaneitemDescription;
    protected JTextArea itemProperty;
    JScrollPane scrollPaneitemProperty;
    protected JComboBox<String> indentReq;
    protected JComboBox<String> pOReq;
    protected JComboBox<String> gSTNature;
    protected JComboBox<String> purchaseUnit;
    protected JComboBox<String> salesUnit;
    protected JComboBox<String> itemSKU;
    protected JComboBox<String> itemGSTType;
    protected JComboBox<String> itemGSTBasedOn;
    protected JComboBox<String> itemSaleReturnableType;
    protected JComboBox<String> itemActive;

    String moverecCodeforitemMaster;

    public int itemSearchby;

    /*text fields for party master*/
    newFrameForEntrypoint entryPointParty = new newFrameForEntrypoint();
    Party_MastModel partyMasterModel = new Party_MastModel();

    JFrame partyMasterFrame;

    JLabel lineParty;
    JLabel partyL;
    JLabel partyLegalL;
    JLabel partyDisplayNameL;
    JLabel partyCodeL;
    JLabel partyNatureL;
    JLabel partyTcsActiveL;
    JLabel partyTcsCategoryL;
    JLabel partyReferedToL;
    JLabel partyMSMETypeL;
    JLabel partyGSTTypeL;
    JLabel partyGSTINL;
    JLabel partyPANL;
    JLabel partyAdharL;
    JLabel partyTDSCategoryL;
    JLabel partyAddressL;
    JLabel partyCityL;
    JLabel partyCountryL;
    JLabel partyPinL;
    JLabel partyAreaL;
    JLabel partyPhoneL;
    JLabel partyMobileL;
    JLabel partyActiveL;
    JLabel partyRemarkL;

    protected JTextField party;
    protected JTextField partyLegal;
    protected JTextField partyDisplay;
    protected JTextField partyCode;
    protected JTextField partyGSTIN;
    protected JTextField partyPAN;
    protected JTextField partyAdhar;
    protected JTextField partyAddress;
    protected JTextField partyCountry;
    protected JTextField partyPin;
    protected JTextField partyPhoneNumber;
    protected JTextField partyMobileNumber;
    protected JTextField partyRemark;
    protected JComboBox<String> partyNature;
    protected JComboBox<String> partyTCSActive;
    protected JComboBox<String> partyTCScategory;
    protected JComboBox<String> partyTDScategory;
    protected JComboBox<String> partyReferredTo;
    protected JComboBox<String> partyMSMEType;
    protected JComboBox<String> partyGSTType;
    protected JComboBox<String> partyCity;
    protected JComboBox<String> partyArea;
    protected JComboBox<String> partyActive;

    String moverecCodeforPartyMaster;

    public int partySearchby;

    /*text fields for Item Category master*/
    newFrameForEntrypoint entryPointICategory = new newFrameForEntrypoint();
    ItemCategory_MastModel iCategoryModel = new ItemCategory_MastModel();

    JFrame iCategoryMasterFrame;

    JLabel itemCategoryL;
    JLabel itemCategoryShortNameL;

    protected JTextField itemCategory;
    protected JTextField itemCategoryShortName;

    String moverecCodeforiCategory;

    public int icategorySearchby;


    /*text fields for Employee master*/
    public JFrame rootpanel;
    public JPanel rootLoginPanel;
    public JPanel moduleMenu;
    public JPanel topControlBar;
    public JPanel dashboardPanel;
    JPanel mBarChartPanel;
    JPanel pieChartPanel;
    JPanel adminstratorPanel;
    JPanel financePanel;
    JPanel notepadPanel;

    /*text fields for requisition*/
    newFrameForEntrypoint entryPointReq = new newFrameForEntrypoint();
    Requisition_Model reqModel = new Requisition_Model();

    JFrame reqFrame;

    JLabel requisitionTypeL;
    JLabel requisitionNoL;
    JLabel requisitionDateL;
    JLabel requisitionByL;
    JLabel departmentByL;
    JLabel departmentToL;
    JLabel requsitionRemarkL;

    protected JTextField requisitionDate;
    protected JTextField requisitionNo;
    protected JTextField requisitionRemark;
    protected JComboBox requisitionType;
    protected JComboBox requisitionBy;
    protected JComboBox departmentBy;
    protected JComboBox departmentTo;

    String moverecCodeforRequisition;

    public int requisitionSearchby;

    private JTable reqtable;
    private DefaultTableModel reqTableModel;

    /*text fields for Indent*/
    newFrameForEntrypoint entryPointIndent = new newFrameForEntrypoint();
    Indent_Model indentModel = new Indent_Model();

    JFrame indentFrame;

    JLabel indentTypeL;
    JLabel indentNoL;
    JLabel indentDateL;
    JLabel indentorL;
    JLabel indentDepartmentL;
    JLabel indentRequisitionL;
    JLabel indentRemarkL;

    protected JTextField indentNo;
    protected JTextField indentDate;
    protected JTextField indentRemark;
    protected JComboBox indentType;
    protected JComboBox indentDepartment;
    protected JComboBox indentRequisition;
    protected JComboBox indentor;

    String moverecCodeforIndent;

    public int indentSearchby;

    private JTable indenttable;
    private DefaultTableModel indentTableModel;
    /*text fields for Enquiry*/
    newFrameForEntrypoint entryPointEnquiry = new newFrameForEntrypoint();
    Enquiry_Model enquiryModel = new Enquiry_Model();

    JFrame enquiryFrame;

    JLabel enquiryTypeL;
    JLabel enquiryNoL;
    JLabel enquiryDateL;
    JLabel enquiryDepartmentL;
    JLabel enquiryIndentL;
    JLabel enquiryRemarkL;

    protected JTextField enquiryNo;
    protected JTextField enquiryDate;
    protected JTextField enquiryRemark;
    protected JComboBox enquiryType;
    protected JComboBox enquiryDepartment;
    protected JComboBox enquiryIndent;

    String moverecCodeforEnquiry;

    public int enquirySearchby;

    private JTable enquirytable;
    private DefaultTableModel enquiryTableModel;

    private JTable enquirypartytable;
    private DefaultTableModel enquiryPartyTableModel;
    /*text fields for Enquiry*/
    newFrameForEntrypoint entryPointPO = new newFrameForEntrypoint();
    Enquiry_Model pOModel = new Enquiry_Model();

    JFrame pOFrame;

    JLabel pOTypeL;
    JLabel pOSupplierL;
    JLabel pOGSTTransactionL;
    JLabel pOStateL;
    JLabel pOReferenceNoL;
    JLabel pODateL;
    JLabel pONoL;
    JLabel pOEnquiryL;
    JLabel pOAmendmentL;
    JLabel pOAmendmentDateL;

    protected JTextField pOReferenceNo;
    protected JTextField pODate;
    protected JTextField pONo;
    protected JTextField pOAmendmentDate;
    protected JComboBox pOType;
    protected JComboBox pOSupplier;
    protected JComboBox pOGSTTransaction;
    protected JComboBox pOState;
    protected JComboBox pOEnquiry;
    protected JComboBox pOAmendment;

    String moverecCodeforPO;

    public int pOSearchby;

    private JTable pOtable;
    private DefaultTableModel pOTableModel;

    private JTable pOServicetable;
    private DefaultTableModel pOServiceTableModel;

    /*-------sales barchart textfields start-----------*/
    String[] salesArrayForBarChart = new String[12];

    newFrameForEntrypoint entryPointSalesBarChart = new newFrameForEntrypoint();
    JFrame salesBarFrame;

    JLabel salesJanL;
    JLabel salesfebL;
    JLabel salesmarL;
    JLabel salesAprL;
    JLabel salesmayL;
    JLabel salesJunL;
    JLabel salesJulL;
    JLabel salesaugL;
    JLabel salessepL;
    JLabel salesoctL;
    JLabel salesnovL;
    JLabel salesdecL;

    JTextField salesJan;
    JTextField salesfeb;
    JTextField salesmar;
    JTextField salesApr;
    JTextField salesmay;
    JTextField salesJun;
    JTextField salesJul;
    JTextField salesaug;
    JTextField salessep;
    JTextField salesoct;
    JTextField salesnov;
    JTextField salesdec;
    /*-------sales barchart textfields start-----------*/
    String[] purchaseArrayForBarChart = new String[12];

    newFrameForEntrypoint entryPointPurchaseBarChart = new newFrameForEntrypoint();
    JFrame purchaseBarFrame;

    JLabel purchaseJanL;
    JLabel purchasefebL;
    JLabel purchasemarL;
    JLabel purchaseAprL;
    JLabel purchasemayL;
    JLabel purchaseJunL;
    JLabel purchaseJulL;
    JLabel purchaseaugL;
    JLabel purchasesepL;
    JLabel purchaseoctL;
    JLabel purchasenovL;
    JLabel purchasedecL;

    JTextField purchaseJan;
    JTextField purchasefeb;
    JTextField purchasemar;
    JTextField purchaseApr;
    JTextField purchasemay;
    JTextField purchaseJun;
    JTextField purchaseJul;
    JTextField purchaseaug;
    JTextField purchasesep;
    JTextField purchaseoct;
    JTextField purchasenov;
    JTextField purchasedec;
    ///////////////////////////////////////////////////////////////////////////////////
    ///// text field for asset master ///////
    
     /*text fields for asset category */
    JFrame assetCatFrame;

    newFrameForEntrypoint entryPointAssetCat = new newFrameForEntrypoint();
//    DesignationMastModel model = new DesignationMastModel();

    JLabel assetCategoryL;
  

    protected JTextField assetCategory;
    
       String moverecCodeforAssetCat;

    public int assetCatsearchby;

    /*text fields for department master*/
    
    
    
    
    
    
    
    
    
    
    //////////////////////////////////////////////////////////////////////
    
    
    
    private JPanel imagePanel = createImagePanel();
    public JMenuBar menuBar = new JMenuBar();

    JMenu masterMenu;
    JMenu purchaseMenu;
    JMenu gateMenu;
    JMenu salesMenu;
    JMenu storeMenu;
    JMenu assetsMenu;
    JMenu dashboardMenu;
    JMenu settingMenu;

    public JLabel erpimage, profileLogo;
    public JButton next;
    public static JTextField username, password;
    public boolean enablePanel = true;
    boolean searchflag = true;
    boolean addsearchFlag = true;
    boolean addButtonFlag = true;

    boolean flag = true;
    boolean formFlag = false;
    boolean pieChartFlag = true;
    boolean setHomeFalg = true;
    String companyName = "M.D. Enterprises Pvt. Ltd.";
    String fStartYear = "2023";
    String fEndYear = "2024";
    String user = "HEAD OFFICE";
    String formattedDate;

    int RecMenuNumber = 0;
    public int menuNumber = 0;
    public int menuFlag = 0;

    public ImageIcon erpimageicon, profilelogoicon;
    private ImageIcon imageIcon;
    String notepad = "Write Your Tasks\n "
            + "I will Remind You\n"
            + "Your Personal Assistant :)\n";

    public Color maingreen = new Color(0, 111, 102);
    public Color lightgreen = new Color(0, 170, 123);
    public Color lightgrey = new Color(183, 189, 189);
    public Color lightblue = new Color(170, 215, 255);
    public Color darkblue = new Color(14, 109, 133);
    public Color salesBarColor = new Color(0, 191, 196, 255);
    public Color purchaseBarColor = new Color(199, 124, 255, 255);
    public Color graphBgColor = new Color(0, 191, 196, 255);
    Color color13 = new Color(50, 93, 127);

    private Color color1 = new Color(255, 228, 210);
    private Color color2 = new Color(255, 245, 212);
    private Color color3 = new Color(74, 123, 166);
    private Color color4 = new Color(216, 238, 255);
    private Color color5 = new Color(255, 210, 210);
    private Color color6 = new Color(151, 153, 186);
    private Color color7 = new Color(229, 255, 225);
    private Color quicklinkColor = new Color(30, 175, 240);
    private Color quicklinkColor1 = new Color(40, 215, 250);

    public Border dashBorder1 = new LineBorder(Color.BLACK, 1);
    public Border dashBorder2 = new LineBorder(lightgrey, 1);
    public Border dashBorder1Green = new LineBorder(lightgreen, 1);

    boolean fg = true;
    boolean fgi = true;
    boolean fgC = true;

    public AdminPanel_Dsg() {
        this.color1 = new Color(0, 111, 102);
        try {

            // Create a timer to hide the image panel after 3 seconds
            Timer timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    imagePanel.setVisible(false); // Hide the image panel
                    showLoginForm(); // Show the login form

                }
            });
            timer.setRepeats(false); // Run the timer only once
            timer.start();
        } catch (Exception e) {
        }
    }

    public void showImagePanel() {
        rootpanel = new JFrame();
        rootpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rootpanel.setBounds(0, 0, 1542, 830);

        rootpanel.getContentPane().add(imagePanel);
        rootpanel.setVisible(true);
    }

    public void showLoginForm() {
        try {
            String nexttxt = "Next";
            AdminPanel ap = new AdminPanel();

            rootpanel.getContentPane().setBackground(maingreen);
            erpimageicon = new ImageIcon("src\\pictures used\\erplogo.png");
            profilelogoicon = new ImageIcon("src\\pictures used\\profilelogo.png");

            erpimage = new JLabel(erpimageicon);
            erpimage.setBounds(0, 0, 370, 300);

            profileLogo = new JLabel(profilelogoicon);
            profileLogo.setBounds(455, 20, 50, 50);

            username = new JTextField("Username");
            username.setBounds(420, 110, 120, 30);
            username.setBackground(Color.WHITE);

            password = new JTextField("Password");
            password.setBounds(420, 170, 120, 30);
            password.setBackground(Color.WHITE);

            next = new JButton("<html><div style='color: white; text-align: center; font-weight: bold;'>Next</div></html>");
            next.setBounds(440, 220, 80, 30);
            next.setBackground(maingreen);

            rootLoginPanel = new JPanel();
            rootLoginPanel.setBounds(470, 280, 600, 290);
            rootLoginPanel.setLayout(null);
            rootLoginPanel.setBackground(Color.WHITE);
            rootLoginPanel.add(erpimage);
            rootLoginPanel.add(profileLogo);
            rootLoginPanel.add(username);
            rootLoginPanel.add(password);
            rootLoginPanel.add(next);

            rootpanel.add(rootLoginPanel);

            rootpanel.setResizable(false);
            rootpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rootpanel.setBounds(0, 0, 1542, 830);
            rootpanel.setLayout(null);
            rootpanel.setVisible(true);

            username.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    password.requestFocus();
                }
            });

            username.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
//                if (username.getText() == "Username") {
                    username.setText("");
//                }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (username.getText() == "") {
                        username.setText("Username");
                    }
                }
            });
            password.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    password.setText("");
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (password.getText() == "") {
                        password.setText("password");
                    }
                }
            });

            next.addMouseListener(new MouseInputListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    next.setText("<html><div style='color: rgb(0,111,102); text-align: center; font-weight: bold;'>Next</div></html>");
                    next.setBackground(Color.WHITE);

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    next.setText("<html><div style='color: rgb(0,111,102); text-align: center; font-weight: bold;'>Next</div></html>");
                    next.setBackground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    next.setText("<html><div style='color: white; text-align: center; font-weight: bold;'>Next</div></html>");
                    next.setBackground(maingreen);
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                }
            });

            next.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ap.NextSave();
                    rootLoginPanel.remove(next);
                    rootLoginPanel.add(next);
                    if (username.getText().equals("****") || password.getText().equals("****")) {
                        panelRemove();
                    }
                }
            });

            password.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean lo = ap.NextSave();
                    rootLoginPanel.remove(next);
                    rootLoginPanel.add(next);
                    if (lo) {
                        if (username.getText().equals("****") || password.getText().equals("****")) {
                            panelRemove();
                            rootpanel.add(dashboard());
                            rootpanel.repaint();
                            rootpanel.revalidate();
                        }
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    private JPanel createImagePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("src\\pictures used\\erphomeimagenew.jpg"); // Replace with your image path
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);
        return panel;
    }

    public void panelRemove() {
        rootLoginPanel.setVisible(false);
        rootpanel.remove(rootLoginPanel);
        rootpanel.setBackground(maingreen);
    }

    public JPanel topControlBar() {
        JLabel homeIcon, logoutIcon;
        JLabel txtCompany;
        ImageIcon homeIcon_Image = null, logout_Image = null;
        JButton txtModuleButton;

        topControlBar = new JPanel();
        topControlBar.setBounds(0, 0, 1515, 30);
        Border border = new LineBorder(Color.BLACK, 1);
        Border companyBorder = new LineBorder(Color.DARK_GRAY, 1);

        try {
            homeIcon_Image = new ImageIcon("src\\pictures used\\homeicon.png");
            logout_Image = new ImageIcon("src\\pictures used\\logout.png");
        } catch (Exception e) {
            e.printStackTrace();
            homeIcon_Image = new ImageIcon();
        }

        txtModuleButton = new JButton();
        txtModuleButton.setText("<html><div style='color: rgb(0,137,102); text-align: center; font-weight: bold;'>Module</div></html>");
        txtModuleButton.setBackground(Color.WHITE);
        txtModuleButton.setBounds(34, 1, 100, 28);

        homeIcon = new JLabel(homeIcon_Image);
        homeIcon.setBounds(0, 1, 34, 28);
        logoutIcon = new JLabel(logout_Image);
        logoutIcon.setBounds(1482, 1, 32, 28);
        txtCompany = new JLabel("<html> <div style='color: rgb(0, 0, 102); text-align: center; font-weight: bold; font-size: 12px;'>&nbsp;&nbsp;&nbsp;'" + companyName + "' ('" + fStartYear + "'-'" + fEndYear + "')</div></html>");
        txtCompany.setBounds(1130, 3, 340, 24);
        txtCompany.setBackground(Color.LIGHT_GRAY);
        txtCompany.setBorder(companyBorder);

        topControlBar.add(homeIcon);
        topControlBar.add(logoutIcon);
        topControlBar.add(txtModuleButton);
        topControlBar.add(txtCompany);

        topControlBar.setBorder(border);
        topControlBar.setLayout(null);
        topControlBar.setVisible(true);

        logoutIcon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                showImagePanel();
                JOptionPane.showConfirmDialog(rootpanel, "Are you sure ?", "LogOut", 2);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        txtCompany.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (fgC) {
                    txtCompany.setBounds(250, 3, 340, 24);
                    rootLoginPanel.repaint();
                    rootpanel.repaint();
                    rootLoginPanel.revalidate();
                    rootpanel.revalidate();
                    fgC = false;
                } else {
                    txtCompany.setBounds(1130, 3, 340, 24);
                    rootLoginPanel.repaint();
                    rootpanel.repaint();
                    rootLoginPanel.revalidate();
                    rootpanel.revalidate();
                    fgC = true;
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                txtCompany.setText("<html> <div style='color: rgb(0,137,102); text-align: center; font-weight: bold; font-size: 12px;'>&nbsp;&nbsp;&nbsp;'" + companyName + "' ('" + fStartYear + "'-'" + fEndYear + "')</div></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                txtCompany.setText("<html> <div style='color: rgb(0, 0, 102); text-align: center; font-weight: bold; font-size: 12px;'>&nbsp;&nbsp;&nbsp;'" + companyName + "' ('" + fStartYear + "'-'" + fEndYear + "')</div></html>");
                txtCompany.setBackground(Color.WHITE);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        txtModuleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (enablePanel && pieChartFlag) {
                    dashboardPanel.remove(pieChartPanel);
                    dashboardPanel.add(moduleMenu());
                    rootpanel.repaint();
                    rootpanel.revalidate();
                    enablePanel = false;

                } //                    else if (!enablePanel && !pieChartFlag) {
                //                        dashboardPanel.remove(moduleMenu);
                //                        rootpanel.repaint();
                //                        rootpanel.revalidate();
                //                        enablePanel = true;
                //                    }
                else if (!enablePanel) {
                    dashboardPanel.remove(moduleMenu);
                    dashboardPanel.add(pieChartPanel());
                    rootpanel.repaint();
                    rootpanel.revalidate();
                    enablePanel = true;
                }
//                    else if (enablePanel && !pieChartFlag) {
//                        dashboardPanel.add(moduleMenu());
//                        rootpanel.repaint();
//                        rootpanel.revalidate();
//                        enablePanel = false;
//                    }

            }
        });

        homeIcon.addMouseListener(
                new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {

            }

            @Override
            public void mousePressed(MouseEvent e
            ) {

            }

            @Override
            public void mouseReleased(MouseEvent e
            ) {
//                addDashboardComponents();

            }

            @Override
            public void mouseEntered(MouseEvent e
            ) {

            }

            @Override
            public void mouseExited(MouseEvent e
            ) {

            }
        });

        return topControlBar;
    }

    public JPanel moduleMenu() {
        try {
            Border dashBorder = new LineBorder(Color.BLACK, 1);
            ImageIcon iconMaster = new ImageIcon("src\\pictures used\\master.png");
            ImageIcon iconPurchase = new ImageIcon("src\\pictures used\\purchase.png");
            ImageIcon iconSales = new ImageIcon("src\\pictures used\\sales.png");
            ImageIcon iconStore = new ImageIcon("src\\pictures used\\store.png");
            ImageIcon iconDashboard = new ImageIcon("src\\pictures used\\dashboard.png");
            ImageIcon iconAssets = new ImageIcon("src\\pictures used\\assets.png");
            ImageIcon iconSetting = new ImageIcon("src\\pictures used\\utility.png");
            ImageIcon iconGate = new ImageIcon("src\\pictures used\\gate.png");
//        ImageIcon iconProduction = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\production.png");

            moduleMenu = new JPanel();
            moduleMenu.setBounds(282, 35, 930, 430);
            moduleMenu.setBackground(Color.WHITE);
            moduleMenu.setBorder(dashBorder);

            JPanel moduleMTopC = new JPanel();
            moduleMTopC.setBounds(2, 2, 926, 30);
            moduleMTopC.setBorder(dashBorder1);
            moduleMTopC.setBackground(lightgreen);
            moduleMTopC.setLayout(null);

            JLabel txtMaster = new JLabel(iconMaster);
            txtMaster.setBounds(100, 80, 100, 100);

            JLabel txtPurchase = new JLabel(iconPurchase);
            txtPurchase.setBounds(300, 80, 100, 100);

            JLabel txtGate = new JLabel(iconGate);
            txtGate.setBounds(500, 80, 100, 100);

            JLabel txtSales = new JLabel(iconSales);
            txtSales.setBounds(700, 80, 100, 100);

            JLabel txtStore = new JLabel(iconStore);
            txtStore.setBounds(100, 260, 100, 100);

            JLabel txtSetting = new JLabel(iconSetting);
            txtSetting.setBounds(300, 260, 100, 100);

            JLabel txtDashBoard = new JLabel(iconDashboard);
            txtDashBoard.setBounds(500, 260, 100, 100);

            JLabel txtAsset = new JLabel(iconAssets);
            txtAsset.setBounds(700, 260, 100, 100);
//        JLabel txtProduction = new JLabel(iconProduction);

            moduleMenu.add(moduleMTopC);
            moduleMenu.add(txtMaster);
            moduleMenu.add(txtPurchase);
            moduleMenu.add(txtGate);
            moduleMenu.add(txtSales);
            moduleMenu.add(txtStore);
            moduleMenu.add(txtSetting);
            moduleMenu.add(txtDashBoard);
            moduleMenu.add(txtAsset);

            moduleMenu.setLayout(null);
            moduleMenu.setVisible(true);

            myMouseListenerForModuleMenu(txtMaster, 100, 80, 1);
            myMouseListenerForModuleMenu(txtPurchase, 300, 80, 2);
            myMouseListenerForModuleMenu(txtGate, 500, 80, 3);
            myMouseListenerForModuleMenu(txtSales, 700, 80, 4);
            myMouseListenerForModuleMenu(txtStore, 100, 260, 5);
            myMouseListenerForModuleMenu(txtSetting, 300, 260, 6);
            myMouseListenerForModuleMenu(txtDashBoard, 500, 260, 7);
            myMouseListenerForModuleMenu(txtAsset, 700, 260, 8);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return moduleMenu;

    }

    public JPanel dashboard() {

        Border dashBorder = new LineBorder(Color.BLACK, 2);
        dashboardPanel = new JPanel();
        dashboardPanel.setBounds(10, 10, 1515, 774);
        dashboardPanel.setBorder(dashBorder1);
        dashboardPanel.add(topControlBar());
        addDashboardComponent();

        dashboardPanel.setLayout(null);
        dashboardPanel.setVisible(true);

        return dashboardPanel;

    }

    public void myMouseListenerForModuleMenu(JLabel jLabel, int x, int y, int formNumber) {
        jLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (formNumber == 1) {
                    if (menuFlag == 0) {
                        menuNumber = formNumber;
                        masterMenu(topControlBar);
                        menuFlag = 1;
                    } else if (menuFlag == 1) {
                        if (menuNumber == 1) {
                            menuBar.remove(masterMenu);
                            masterMenu(topControlBar);

                        } else if (menuNumber == 2) {
                            menuBar.remove(purchaseMenu);
                            masterMenu(topControlBar);

                        } else if (menuNumber == 3) {
                            menuBar.remove(gateMenu);
                            masterMenu(topControlBar);

                        } else if (menuNumber == 4) {
                            menuBar.remove(salesMenu);
                            masterMenu(topControlBar);
                        } else if (menuNumber == 5) {
                            menuBar.remove(storeMenu);
                            masterMenu(topControlBar);
                        } else if (menuNumber == 6) {
                            menuBar.remove(settingMenu);
                            masterMenu(topControlBar);
                        } else if (menuNumber == 7) {
                            menuBar.remove(dashboardMenu);
                            masterMenu(topControlBar);
                        } else if (menuNumber == 8) {
                            menuBar.remove(assetsMenu);
                            masterMenu(topControlBar);
                        }
                        menuNumber = formNumber;
                    }
                } else if (formNumber == 2) {
                    if (menuFlag == 0) {
                        menuNumber = formNumber;

                        purchaseMenu(topControlBar);
                        menuFlag = 1;
                    } else if (menuFlag == 1) {
                        if (menuNumber == 1) {
                            menuBar.remove(masterMenu);
                            purchaseMenu(topControlBar);

                        } else if (menuNumber == 2) {
                            menuBar.remove(purchaseMenu);
                            purchaseMenu(topControlBar);

                        } else if (menuNumber == 3) {
                            menuBar.remove(gateMenu);
                            purchaseMenu(topControlBar);

                        } else if (menuNumber == 4) {
                            menuBar.remove(salesMenu);
                            purchaseMenu(topControlBar);

                        } else if (menuNumber == 5) {
                            menuBar.remove(storeMenu);
                            purchaseMenu(topControlBar);
                        } else if (menuNumber == 6) {
                            menuBar.remove(settingMenu);
                            purchaseMenu(topControlBar);
                        } else if (menuNumber == 7) {
                            menuBar.remove(dashboardMenu);
                            purchaseMenu(topControlBar);
                        } else if (menuNumber == 8) {
                            menuBar.remove(assetsMenu);
                            purchaseMenu(topControlBar);
                        }
                        menuNumber = formNumber;

                    }

                } else if (formNumber == 3) {
                    if (menuFlag == 0) {
                        menuNumber = formNumber;

                        gateMenu(topControlBar);
                        menuFlag = 1;
                    } else if (menuFlag == 1) {
                        if (menuNumber == 1) {
                            menuBar.remove(masterMenu);
                            gateMenu(topControlBar);

                        } else if (menuNumber == 2) {
                            menuBar.remove(purchaseMenu);
                            gateMenu(topControlBar);

                        } else if (menuNumber == 3) {
                            menuBar.remove(gateMenu);
                            gateMenu(topControlBar);

                        } else if (menuNumber == 4) {

                            menuBar.remove(salesMenu);
                            gateMenu(topControlBar);
                        } else if (menuNumber == 5) {
                            menuBar.remove(storeMenu);
                            gateMenu(topControlBar);
                        } else if (menuNumber == 6) {
                            menuBar.remove(settingMenu);
                            gateMenu(topControlBar);
                        } else if (menuNumber == 7) {
                            menuBar.remove(dashboardMenu);
                            gateMenu(topControlBar);
                        } else if (menuNumber == 8) {
                            menuBar.remove(assetsMenu);
                            gateMenu(topControlBar);
                        }
                        menuNumber = formNumber;

                    }

                } else if (formNumber == 4) {
                    if (menuFlag == 0) {
                        menuNumber = formNumber;

                        salesMenu(topControlBar);
                        menuFlag = 1;
                    } else if (menuFlag == 1) {
                        if (menuNumber == 1) {
                            menuBar.remove(masterMenu);
                            salesMenu(topControlBar);
                        } else if (menuNumber == 2) {
                            menuBar.remove(purchaseMenu);
                            salesMenu(topControlBar);
                        } else if (menuNumber == 3) {
                            menuBar.remove(gateMenu);
                            salesMenu(topControlBar);
                        } else if (menuNumber == 4) {
                            menuBar.remove(salesMenu);
                            salesMenu(topControlBar);
                        } else if (menuNumber == 5) {
                            menuBar.remove(storeMenu);
                            salesMenu(topControlBar);
                        } else if (menuNumber == 6) {
                            menuBar.remove(settingMenu);
                            salesMenu(topControlBar);
                        } else if (menuNumber == 7) {
                            menuBar.remove(dashboardMenu);
                            salesMenu(topControlBar);
                        } else if (menuNumber == 8) {
                            menuBar.remove(assetsMenu);
                            salesMenu(topControlBar);
                        }
                        menuNumber = formNumber;

                    }

                } else if (formNumber == 5) {
                    if (menuFlag == 0) {
                        menuNumber = formNumber;

                        storeMenu(topControlBar);
                        menuFlag = 1;
                    } else if (menuFlag == 1) {
                        if (menuNumber == 1) {
                            menuBar.remove(masterMenu);
                            storeMenu(topControlBar);

                        } else if (menuNumber == 2) {
                            menuBar.remove(purchaseMenu);
                            storeMenu(topControlBar);

                        } else if (menuNumber == 3) {
                            menuBar.remove(gateMenu);
                            storeMenu(topControlBar);

                        } else if (menuNumber == 4) {
                            menuBar.remove(salesMenu);
                            storeMenu(topControlBar);
                        } else if (menuNumber == 5) {
                            menuBar.remove(storeMenu);
                            storeMenu(topControlBar);
                        } else if (menuNumber == 6) {
                            menuBar.remove(settingMenu);
                            storeMenu(topControlBar);
                        } else if (menuNumber == 7) {
                            menuBar.remove(dashboardMenu);
                            storeMenu(topControlBar);
                        } else if (menuNumber == 8) {
                            menuBar.remove(assetsMenu);
                            storeMenu(topControlBar);
                        }
                        menuNumber = formNumber;
                    }
                } else if (formNumber == 6) {
                    if (menuFlag == 0) {
                        menuNumber = formNumber;

                        settingMenu(topControlBar);
                        menuFlag = 1;
                    } else if (menuFlag == 1) {
                        if (menuNumber == 1) {
                            menuBar.remove(masterMenu);
                            settingMenu(topControlBar);

                        } else if (menuNumber == 2) {
                            menuBar.remove(purchaseMenu);
                            settingMenu(topControlBar);

                        } else if (menuNumber == 3) {
                            menuBar.remove(gateMenu);
                            settingMenu(topControlBar);

                        } else if (menuNumber == 4) {
                            menuBar.remove(salesMenu);
                            settingMenu(topControlBar);
                        } else if (menuNumber == 5) {
                            menuBar.remove(storeMenu);
                            settingMenu(topControlBar);
                        } else if (menuNumber == 6) {
                            menuBar.remove(settingMenu);
                            settingMenu(topControlBar);
                        } else if (menuNumber == 7) {
                            menuBar.remove(dashboardMenu);
                            settingMenu(topControlBar);
                        } else if (menuNumber == 8) {
                            menuBar.remove(assetsMenu);
                            settingMenu(topControlBar);
                        }
                        menuNumber = formNumber;

                    }
                } else if (formNumber == 7) {
                    if (menuFlag == 0) {
                        menuNumber = formNumber;

                        dashboardMenu(topControlBar);
                        menuFlag = 1;
                    } else if (menuFlag == 1) {
                        if (menuNumber == 1) {
                            menuBar.remove(masterMenu);
                            dashboardMenu(topControlBar);

                        } else if (menuNumber == 2) {
                            menuBar.remove(purchaseMenu);
                            dashboardMenu(topControlBar);

                        } else if (menuNumber == 3) {
                            menuBar.remove(gateMenu);
                            dashboardMenu(topControlBar);

                        } else if (menuNumber == 4) {
                            menuBar.remove(salesMenu);
                            dashboardMenu(topControlBar);
                        } else if (menuNumber == 5) {
                            menuBar.remove(storeMenu);
                            dashboardMenu(topControlBar);
                        } else if (menuNumber == 6) {
                            menuBar.remove(settingMenu);
                            dashboardMenu(topControlBar);
                        } else if (menuNumber == 7) {
                            menuBar.remove(dashboardMenu);
                            dashboardMenu(topControlBar);
                        } else if (menuNumber == 8) {
                            menuBar.remove(assetsMenu);
                            dashboardMenu(topControlBar);
                        }
                        menuNumber = formNumber;
                    }
                } else if (formNumber == 8) {
                    if (menuFlag == 0) {
                        menuNumber = formNumber;

                        assetsMenu(topControlBar);
                        menuFlag = 1;
                    } else if (menuFlag == 1) {
                        if (menuNumber == 1) {
                            menuBar.remove(masterMenu);
                            assetsMenu(topControlBar);

                        } else if (menuNumber == 2) {
                            menuBar.remove(purchaseMenu);
                            assetsMenu(topControlBar);

                        } else if (menuNumber == 3) {
                            menuBar.remove(gateMenu);
                            assetsMenu(topControlBar);

                        } else if (menuNumber == 4) {
                            menuBar.remove(salesMenu);
                            assetsMenu(topControlBar);
                        } else if (menuNumber == 5) {
                            menuBar.remove(storeMenu);
                            assetsMenu(topControlBar);
                        } else if (menuNumber == 6) {
                            menuBar.remove(settingMenu);
                            assetsMenu(topControlBar);
                        } else if (menuNumber == 7) {
                            menuBar.remove(dashboardMenu);
                            assetsMenu(topControlBar);
                        } else if (menuNumber == 8) {
                            menuBar.remove(assetsMenu);
                            assetsMenu(topControlBar);
                        }
                        menuNumber = formNumber;
                    }
                }

//                formPanelRemover(RecMenuNumber);
                rootpanel.repaint();
                rootpanel.revalidate();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menusEntered(jLabel, x, y);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                menusExited(jLabel, x, y);

            }
        });
    }

    public void menusEntered(JLabel jLabel, int x, int y) {
        jLabel.setBounds(x, y, 120, 120);
        jLabel.setBorder(dashBorder1);
    }

    public void menusExited(JLabel jLabel, int x, int y) {
        jLabel.setBounds(x, y, 100, 100);
        jLabel.setBorder(null);
    }

    public void masterMenu(JPanel jPanel) {

        masterMenu = new JMenu("<html> <div style='color: rgb(0,137,102); text-align: center; font-weight: bold; font-size: 10px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Master&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></html>");
        JMenuItem empMaster = new JMenuItem("Employee Master");
        JMenuItem itemMaster = new JMenuItem("Item Master");
        JMenuItem depMaster = new JMenuItem("Department Master");
        JMenuItem partyMaster = new JMenuItem("Party Master");
        JMenuItem designationMaster = new JMenuItem("Designation Master");
        JMenuItem areaMaster = new JMenuItem("Area Master");
        JMenuItem itemCatMaster = new JMenuItem("Item Category Master");

        masterMenu.add(empMaster);
        masterMenu.add(designationMaster);
        masterMenu.add(depMaster);
        masterMenu.addSeparator();
        masterMenu.add(partyMaster);
        masterMenu.add(areaMaster);
        masterMenu.addSeparator();
        masterMenu.add(itemMaster);
        masterMenu.add(itemCatMaster);
        menuBar.add(masterMenu);
        menuBar.setBounds(135, 1, 100, 28);

        jPanel.add(menuBar);

        myActionListenerForFormPanels(empMaster, 1);
        myActionListenerForFormPanels(designationMaster, 2);
        myActionListenerForFormPanels(depMaster, 3);
        myActionListenerForFormPanels(partyMaster, 4);
        myActionListenerForFormPanels(areaMaster, 5);
        myActionListenerForFormPanels(itemMaster, 6);
        myActionListenerForFormPanels(itemCatMaster, 7);

    }

    public void purchaseMenu(JPanel jPanel) {

        purchaseMenu = new JMenu("<html> <div style='color: rgb(0,137,102); text-align: center; font-weight: bold; font-size: 10px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Purchase&nbsp;&nbsp;&nbsp;&nbsp;</div></html>");
        JMenuItem indent = new JMenuItem("Indent");
        JMenuItem enquiry = new JMenuItem("Enquiry");
        JMenuItem pOrder = new JMenuItem("Purchase Order");

        JMenuItem grn = new JMenuItem("Goods Recieved Note");
        JMenuItem pBill = new JMenuItem("Purchase Bill");

        JMenuItem indentReport = new JMenuItem("Indent Report");
        JMenuItem pOReport = new JMenuItem("Purchase Order Report");
        JMenuItem pBReport = new JMenuItem("Purchase Bill Report");

        purchaseMenu.add(indent);
        purchaseMenu.add(enquiry);
        purchaseMenu.addSeparator();
        purchaseMenu.add(pOrder);
        purchaseMenu.add(grn);
        purchaseMenu.add(pBill);
        purchaseMenu.addSeparator();
        purchaseMenu.add(indentReport);
        purchaseMenu.add(pOReport);
        purchaseMenu.add(pBReport);

        menuBar.add(purchaseMenu);
        menuBar.setBounds(134, 1, 100, 28);

        // Add the menuBar to the panel
        jPanel.add(menuBar);

        myActionListenerForFormPanels(indent, 21);
        myActionListenerForFormPanels(enquiry, 22);
        myActionListenerForFormPanels(pOrder, 23);

    }

    public void gateMenu(JPanel jPanel) {

        gateMenu = new JMenu("<html> <div style='color: rgb(0,137,102); text-align: center; font-weight: bold; font-size: 10px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></html>");
        JMenuItem gateNoMaster = new JMenuItem("Gate Number Master");
        JMenuItem vTypeMaster = new JMenuItem("Vehicle Type Master");

        JMenuItem gateEntry = new JMenuItem("Gate Entry");
        JMenuItem visitorPass = new JMenuItem("Visitors Entry Pass");

        gateMenu.add(gateNoMaster);
        gateMenu.add(vTypeMaster);
        gateMenu.addSeparator();
        gateMenu.add(gateEntry);
        gateMenu.add(visitorPass);

        menuBar.add(gateMenu);
        menuBar.setBounds(135, 1, 100, 28);

        // Add the menuBar to the panel
        jPanel.add(menuBar);

    }

    public void salesMenu(JPanel jPanel) {

        salesMenu = new JMenu("<html> <div style='color: rgb(0,137,102); text-align: center; font-weight: bold; font-size: 10px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sales&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></html>");
        JMenuItem salesOrder = new JMenuItem("Sales Order");
        JMenuItem salesInvoice = new JMenuItem("Sales Invoice");

        salesMenu.add(salesOrder);
        salesMenu.add(salesInvoice);

        menuBar.add(salesMenu);
        menuBar.setBounds(135, 1, 100, 28);

        // Add the menuBar to the panel
        jPanel.add(menuBar);

    }

    public void storeMenu(JPanel jPanel) {

        storeMenu = new JMenu("<html> <div style='color: rgb(0,137,102); text-align: center; font-weight: bold; font-size: 10px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Store&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></html>");
        JMenuItem requisition = new JMenuItem("Requisition");
        JMenuItem itemRecieve = new JMenuItem("Item Recieve");
        JMenuItem stockOpening = new JMenuItem("Stock Opening");

        storeMenu.add(requisition);
        storeMenu.add(itemRecieve);
        storeMenu.add(stockOpening);

        menuBar.add(storeMenu);
        menuBar.setBounds(135, 1, 100, 28);

        // Add the menuBar to the panel
        jPanel.add(menuBar);

        myActionListenerForFormPanels(requisition, 51);
        myActionListenerForFormPanels(itemRecieve, 52);
        myActionListenerForFormPanels(stockOpening, 53);

    }

    public void settingMenu(JPanel jPanel) {

        settingMenu = new JMenu("<html> <div style='color: rgb(0,137,102); text-align: center; font-weight: bold; font-size: 10px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Utility&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></html>");
        JMenuItem addUser = new JMenuItem("Add User");
        JMenuItem deleteUser = new JMenuItem("Delete User");
        JMenuItem changeCompanyName = new JMenuItem("Change Enterprise name");
        JMenuItem changeYear = new JMenuItem("Change Financial Year");

        settingMenu.add(addUser);
        settingMenu.add(deleteUser);
        settingMenu.add(changeCompanyName);
        settingMenu.add(changeYear);

        menuBar.add(settingMenu);
        menuBar.setBounds(135, 1, 100, 28);

        // Add the menuBar to the panel
        jPanel.add(menuBar);

    }

    public void dashboardMenu(JPanel jPanel) {

        dashboardMenu = new JMenu("<html> <div style='color: rgb(0,137,102); text-align: center; font-weight: bold; font-size: 10px;'>&nbsp;&nbsp;&nbsp;Dashboard&nbsp;&nbsp;&nbsp;&nbsp;</div></html>");
        JMenuItem salesBar = new JMenuItem("Sales Chart");
        JMenuItem purchaseBar = new JMenuItem("Purchase Chart");

        dashboardMenu.add(salesBar);
        dashboardMenu.add(purchaseBar);

        menuBar.add(dashboardMenu);
        menuBar.setBounds(135, 1, 100, 28);

        // Add the menuBar to the panel
        jPanel.add(menuBar);

        salesBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myActionListenerForFormPanels(salesBar, 71);
            }
        });
        purchaseBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myActionListenerForFormPanels(salesBar, 72);
            }
        });

    }

    public void assetsMenu(JPanel jPanel) {

        assetsMenu = new JMenu("<html> <div style='color: rgb(0,137,102); text-align: center; font-weight: bold; font-size: 10px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Assets&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></html>");
        JMenuItem aCategoryMaster = new JMenuItem("Assets Category Master");
        JMenuItem assetsMaster = new JMenuItem("Assets Master");

        assetsMenu.add(aCategoryMaster);
        assetsMenu.add(assetsMaster);

        menuBar.add(assetsMenu);
        menuBar.setBounds(135, 1, 100, 28);

        aCategoryMaster.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 myActionListenerForFormPanels(aCategoryMaster, 81);
                
            }
        });
        
        
        // Add the menuBar to the panel
        jPanel.add(menuBar);

    }

    public JPanel mBarChartPanel() {

        mBarChartPanel = new JPanel();
        mBarChartPanel.setBounds(2, 470, 1510, 300);
        mBarChartPanel.setBorder(dashBorder1Green);
        mBarChartPanel.setBackground(Color.YELLOW);

        mBarChartPanel.add(salesChartPanel());
        mBarChartPanel.add(purchaseChartPanel());

        mBarChartPanel.setLayout(null);
        mBarChartPanel.setVisible(true);

        return mBarChartPanel;
    }

    public ChartPanel salesChartPanel() {
        Dashboard dashboardObject = new Dashboard();
        salesArrayForBarChart = dashboardObject.getSalesBarChartData();
        DefaultCategoryDataset mSalesBarChart = new DefaultCategoryDataset();

        Timer timer = new Timer(10, e -> {
            salesArrayForBarChart = dashboardObject.getSalesBarChartData();
            rootpanel.repaint();
            rootpanel.revalidate();
            rootLoginPanel.repaint();
            rootLoginPanel.revalidate();
//        Arrays.fill(salesArrayForBarChart, "10");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[0]), "In Crores(Rs)", "January");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[1]), "In Crores(Rs)", "February");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[2]), "In Crores(Rs)", "March");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[3]), "In Crores(Rs)", "April");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[4]), "In Crores(Rs)", "May");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[5]), "In Crores(Rs)", "June");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[6]), "In Crores(Rs)", "July");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[7]), "In Crores(Rs)", "August");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[8]), "In Crores(Rs)", "September");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[9]), "In Crores(Rs)", "October");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[10]), "In Crores(Rs)", "November");
            mSalesBarChart.setValue(Double.parseDouble(salesArrayForBarChart[11]), "In Crores(Rs)", "December");
        });
        timer.start();

        JFreeChart jSalesBarChart = ChartFactory.createBarChart("Monthly Sales", "Months", "Sales", mSalesBarChart, PlotOrientation.VERTICAL, true, true, false);

        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, salesBarColor);
        renderer.setSeriesPaint(1, salesBarColor);
        renderer.setSeriesPaint(2, salesBarColor);
        renderer.setSeriesPaint(3, salesBarColor);
        renderer.setSeriesPaint(4, salesBarColor);
        renderer.setSeriesPaint(5, salesBarColor);
        renderer.setSeriesPaint(6, salesBarColor);
        renderer.setSeriesPaint(7, salesBarColor);
        renderer.setSeriesPaint(8, salesBarColor);
        renderer.setSeriesPaint(9, salesBarColor);
        renderer.setSeriesPaint(10, salesBarColor);
        renderer.setSeriesPaint(11, salesBarColor);

        CategoryPlot plot = jSalesBarChart.getCategoryPlot();
        plot.setRenderer(renderer);
        plot.setRangeGridlinePaint(graphBgColor);

        ChartPanel salesChartPanel = new ChartPanel(jSalesBarChart);
        salesChartPanel.setBounds(3, 2, 750, 295);
        salesChartPanel.setVisible(true);
        salesChartPanel.setToolTipText("Go to DashBoard Module to edit");

        return salesChartPanel;
    }

    public ChartPanel purchaseChartPanel() {

        Dashboard dashboardObject = new Dashboard();
        DefaultCategoryDataset mPurchaseBarChart = new DefaultCategoryDataset();

        Timer timer = new Timer(10, e -> {
            purchaseArrayForBarChart = dashboardObject.getPurchaseBarChartData();
            rootpanel.repaint();
            rootpanel.revalidate();
            rootLoginPanel.repaint();
            rootLoginPanel.revalidate();
//        Arrays.fill(salesArrayForBarChart, "10");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[0]), "In Crores(Rs)", "January");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[1]), "In Crores(Rs)", "February");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[2]), "In Crores(Rs)", "March");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[3]), "In Crores(Rs)", "April");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[4]), "In Crores(Rs)", "May");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[5]), "In Crores(Rs)", "June");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[6]), "In Crores(Rs)", "July");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[7]), "In Crores(Rs)", "August");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[8]), "In Crores(Rs)", "September");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[9]), "In Crores(Rs)", "October");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[10]), "In Crores(Rs)", "November");
            mPurchaseBarChart.setValue(Double.parseDouble(purchaseArrayForBarChart[11]), "In Crores(Rs)", "December");
        });
        timer.start();

        JFreeChart jPurchaseBarChart = ChartFactory.createBarChart("Monthly Purchase", "Months", "Purchase", mPurchaseBarChart, PlotOrientation.VERTICAL, true, true, false);

        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, purchaseBarColor);
        renderer.setSeriesPaint(1, purchaseBarColor);
        renderer.setSeriesPaint(2, purchaseBarColor);
        renderer.setSeriesPaint(3, purchaseBarColor);
        renderer.setSeriesPaint(4, purchaseBarColor);
        renderer.setSeriesPaint(5, purchaseBarColor);
        renderer.setSeriesPaint(6, purchaseBarColor);
        renderer.setSeriesPaint(7, purchaseBarColor);
        renderer.setSeriesPaint(8, purchaseBarColor);
        renderer.setSeriesPaint(9, purchaseBarColor);
        renderer.setSeriesPaint(10, purchaseBarColor);
        renderer.setSeriesPaint(11, purchaseBarColor);

        CategoryPlot plot = jPurchaseBarChart.getCategoryPlot();
        plot.setRenderer(renderer);
        plot.setRangeGridlinePaint(graphBgColor);

        ChartPanel salesChartPanel = new ChartPanel(jPurchaseBarChart);
        salesChartPanel.setBounds(756, 2, 750, 295);
        salesChartPanel.setVisible(true);

        salesChartPanel.setToolTipText("Go to DashBoard Module to edit");

        return salesChartPanel;
    }

    public JPanel pieChartPanel() {

        pieChartPanel = new JPanel();
        pieChartPanel.setBounds(282, 31, 930, 434);
        pieChartPanel.setBackground(Color.WHITE);
        pieChartPanel.add(pieChart());
        pieChartPanel.add(administratorInfo());
        pieChartPanel.setLayout(null);
        return pieChartPanel;
    }

    public ChartPanel pieChart() {

        DefaultPieDataset stockPieChartData = new DefaultPieDataset();
        stockPieChartData.setValue("Unnao", 30);
        stockPieChartData.setValue("Kanpur", 50);
        stockPieChartData.setValue("Lucknow", 54);
        stockPieChartData.setValue("Prayagraj", 130);
        stockPieChartData.setValue("Mumbai", 153);
        stockPieChartData.setValue("Delhi", 152);
        stockPieChartData.setValue("Kolkata", 80);

        JFreeChart pieChart = ChartFactory.createPieChart3D("Area Wise Sales(in Cr)", stockPieChartData, true, true, false);

        pieChart.setBackgroundPaint(Color.WHITE);

        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setSectionPaint("Unnao", color1);
        plot.setSectionPaint("Kanpur", color2);
        plot.setSectionPaint("Lucknow", color3);
        plot.setSectionPaint("Prayagraj", color4);
        plot.setSectionPaint("Mumbai", color5);
        plot.setSectionPaint("Delhi", color6);
        plot.setSectionPaint("Kolkata", color7);

        ChartPanel stockPieChart = new ChartPanel(pieChart);
        stockPieChart.setLayout(null);
        stockPieChart.setBounds(0, 0, 650, 434);

        return stockPieChart;

    }

    public JPanel administratorInfo() {

        adminstratorPanel = new JPanel();
        adminstratorPanel.setBounds(650, 0, 278, 434);
        adminstratorPanel.setBackground(lightblue);
        adminstratorPanel.setBorder(dashBorder1);

        JLabel datel = new JLabel("Date & Time:");
        datel.setBounds(5, 5, 100, 30);
        datel.setForeground(Color.DARK_GRAY);

        JLabel txtDate = new JLabel();
        Timer timer = new Timer(1000, e -> {
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd & HH:mm:ss");
            formattedDate = dateFormat.format(now);
            txtDate.setText(formattedDate);
        });
        timer.start();
        txtDate.setBounds(90, 5, 175, 30);
        txtDate.setForeground(Color.DARK_GRAY);
        txtDate.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel sitePanel = new JPanel();
        sitePanel.setBounds(5, 45, 268, 30);
        sitePanel.setLayout(null);
        sitePanel.setBackground(Color.WHITE);

        JLabel site = new JLabel();
        site.setBounds(1, 0, 266, 30);
        site.setText(user);
        site.setFont(new Font("Arial", Font.ITALIC, 16));
        site.setHorizontalAlignment(SwingConstants.CENTER);

        sitePanel.add(site);

        adminstratorPanel.add(quickLinks());
        adminstratorPanel.add(sitePanel);
        adminstratorPanel.add(datel);
        adminstratorPanel.add(txtDate);
        adminstratorPanel.setLayout(null);
        return adminstratorPanel;

    }

    public JPanel financeDashboard() {
        Color color11 = new Color(192, 108, 134);
        Color color12 = new Color(109, 92, 126);
        Color color14 = new Color(46, 149, 152);

        Color color111 = new Color(77, 13, 33);
        Color color112 = new Color(41, 21, 61);
        Color color113 = new Color(17, 38, 54);
        Color color114 = new Color(14, 30, 50);

        Font myFont = new Font("Forte", Font.BOLD, 14);

        financePanel = new JPanel();
        financePanel.setBounds(2, 31, 278, 434);
        financePanel.setBorder(dashBorder2);
        financePanel.setBackground(Color.WHITE);

        JTextField financeL = new JTextField("Finance Dashboard");
        financeL.setEditable(false);
        financeL.setBackground(lightblue);
        financeL.setForeground(darkblue);
        financeL.setFont(new Font("Forte", Font.BOLD, 18));
        financeL.setBounds(1, 1, 276, 30);

        Timer timers = new Timer(1300, e -> {
            if (fgi) {
                financeL.setBackground(lightblue);
                financeL.setForeground(darkblue);
                fgi = false;
            } else {
                financeL.setBackground(darkblue);
                financeL.setForeground(lightblue);
                fgi = true;
            }
            rootLoginPanel.revalidate();
            rootLoginPanel.repaint();

        });
        timers.start();

        JPanel cashPanel = new JPanel();
        cashPanel.setBounds(2, 36, 270, 100);
        cashPanel.setBackground(color11);

        JPanel bankPanel = new JPanel();
        bankPanel.setBounds(2, 141, 270, 100);
        bankPanel.setBackground(color12);

        JPanel dayPanel = new JPanel();
        dayPanel.setBounds(2, 246, 270, 100);
        dayPanel.setBackground(color13);

        JLabel cashBalance = new JLabel("Cash Balance");
        cashBalance.setForeground(Color.WHITE);
        cashBalance.setFont(myFont);
        cashBalance.setBounds(5, 5, 200, 30);

        JLabel cashBalanceRs = new JLabel("10,00,000 Lakh");
        cashBalanceRs.setBounds(5, 65, 200, 30);
        cashBalanceRs.setForeground(Color.WHITE);

        JLabel bankBalance = new JLabel("Bank Balance");
        bankBalance.setForeground(Color.WHITE);
        bankBalance.setFont(myFont);
        bankBalance.setBounds(5, 5, 200, 30);

        JLabel bankBalanceRs = new JLabel("56.78 Crore");
        bankBalanceRs.setBounds(5, 65, 200, 30);
        bankBalanceRs.setForeground(Color.WHITE);

        JLabel dailyExpense = new JLabel("Daily Expense");
        dailyExpense.setForeground(Color.WHITE);
        dailyExpense.setFont(myFont);
        dailyExpense.setBounds(5, 5, 200, 30);

        JLabel monthlyExpense = new JLabel("Monthly Expense");
        monthlyExpense.setForeground(Color.WHITE);
        monthlyExpense.setFont(myFont);
        monthlyExpense.setBounds(5, 5, 200, 30);

        JPanel monthPanel = new JPanel();
        monthPanel.setBounds(2, 351, 270, 100);
        monthPanel.setBackground(color14);

        JProgressBar cashProgress = new JProgressBar(0, 100);
        cashProgress.setValue(30);
        cashProgress.setForeground(Color.WHITE);
        cashProgress.setBackground(color111);
        cashProgress.setBounds(2, 47, 266, 6);

        JProgressBar bankProgress = new JProgressBar(0, 100);
        bankProgress.setValue(60);
        bankProgress.setForeground(Color.WHITE);
        bankProgress.setBackground(color112);
        bankProgress.setBounds(2, 47, 266, 6);

        JProgressBar dayProgress = new JProgressBar(0, 100);
        dayProgress.setValue(50);
        dayProgress.setForeground(Color.WHITE);
        dayProgress.setBackground(color113);
        dayProgress.setBounds(2, 47, 266, 6);

        JProgressBar monthProgress = new JProgressBar(0, 100);
        monthProgress.setValue(50);
        monthProgress.setForeground(Color.WHITE);
        monthProgress.setBackground(color114);
        monthProgress.setBounds(2, 47, 266, 6);

        cashPanel.add(cashProgress);
        cashPanel.add(cashBalance);
        cashPanel.add(cashBalanceRs);

        bankPanel.add(bankProgress);
        bankPanel.add(bankBalance);
        bankPanel.add(bankBalanceRs);

        monthPanel.add(monthProgress);
        monthPanel.add(monthlyExpense);

        dayPanel.add(dayProgress);
        dayPanel.add(dailyExpense);

        financePanel.add(cashPanel);
        financePanel.add(bankPanel);
        financePanel.add(monthPanel);
        financePanel.add(dayPanel);
        financePanel.add(financeL);

        cashPanel.setLayout(null);
        bankPanel.setLayout(null);
        monthPanel.setLayout(null);
        dayPanel.setLayout(null);
        financePanel.setLayout(null);
        return financePanel;

    }

    public JPanel notepad() {
        Color newColor = new Color(238, 255, 255);
        Color redColor = new Color(255, 240, 0);
        Color blueColor = new Color(136, 198, 237);

        Font myStyle = new Font("Garamond", Font.BOLD, 16);
        notepadPanel = new JPanel();
        notepadPanel.setBounds(1214, 31, 297, 434);
        notepadPanel.setBorder(dashBorder2);

        JTextField txtNotepad = new JTextField("  To-Do");
        txtNotepad.setBounds(1, 1, 80, 30);
        txtNotepad.setEditable(false);
        txtNotepad.setBackground(color13);
        txtNotepad.setForeground(salesBarColor);
        txtNotepad.setFont(new Font("Forte", Font.BOLD, 18));

        JButton reload = new JButton("Reload");
        reload.setBounds(82, 1, 75, 30);

        JButton save = new JButton("Save");
        save.setBounds(157, 1, 68, 30);

        JButton clear = new JButton("Clear");
        clear.setBounds(225, 1, 71, 30);

        reload.setBackground(blueColor);
        reload.setForeground(redColor);
        clear.setBackground(blueColor);
        clear.setForeground(redColor);
        save.setForeground(blueColor);
        save.setBackground(redColor);

        Timer timers = new Timer(2000, e -> {
            if (fg) {
                reload.setBackground(redColor);
                reload.setForeground(blueColor);
                clear.setBackground(redColor);
                clear.setForeground(blueColor);
                save.setForeground(redColor);
                save.setBackground(blueColor);
                fg = false;
            } else {
                reload.setBackground(blueColor);
                reload.setForeground(redColor);
                clear.setBackground(blueColor);
                clear.setForeground(redColor);
                save.setForeground(blueColor);
                save.setBackground(redColor);
                fg = true;
            }
            rootLoginPanel.revalidate();
            rootLoginPanel.repaint();

        });
        timers.start();

        JTextArea notepadArea = new JTextArea(notepad);
        notepadArea.setBackground(newColor);
        notepadArea.setFont(myStyle);
        notepadArea.setForeground(maingreen);
        notepadArea.setLineWrap(true); // Enable automatic line wrapping
        notepadArea.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane scroll = new JScrollPane(notepadArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(2, 32, 295, 400);

        notepadPanel.add(scroll);
        notepadPanel.add(save);
        notepadPanel.add(reload);
        notepadPanel.add(clear);
        notepadPanel.add(txtNotepad);

        notepadPanel.setLayout(null);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad = "";
                notepad = notepadArea.getText();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepadArea.setText("");
            }
        });
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepadArea.setText(notepad);

            }
        });

        notepadArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (notepadArea.getText().equals("Write Your Tasks\n "
                        + "I will Remind You\n"
                        + "Your Personal Assistant :)\n")) {
                    notepadArea.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        Timer timer = new Timer(10000, e -> {
            if (notepadArea.getText().equals("")) {
                notepadArea.setText("Write Your Tasks\n "
                        + "I will Remind You\n"
                        + "Your Personal Assistant :)\n");
                txtNotepad.requestFocus(true);
            }
        });
        timer.start();

        return notepadPanel;
    }

    public void addDashboardComponent() {
        if (pieChartFlag) {
            dashboardPanel.add(pieChartPanel());
            dashboardPanel.add(mBarChartPanel());
            dashboardPanel.add(financeDashboard());
            dashboardPanel.add(notepad());
            rootpanel.repaint();
            rootpanel.revalidate();
            enablePanel = true;
            pieChartFlag = true;

        } else if (!pieChartFlag) {
            dashboardPanel.remove(moduleMenu);
            dashboardPanel.add(pieChartPanel());
            dashboardPanel.add(mBarChartPanel());
            dashboardPanel.add(financeDashboard());
            dashboardPanel.add(notepad());

            rootpanel.repaint();
            rootpanel.revalidate();
            pieChartFlag = true;
            enablePanel = true;
        }
    }

    public JPanel quickLinks() {
        JPanel quickLinksPanel = new JPanel();
        quickLinksPanel.setBounds(5, 80, 268, 350);
        quickLinksPanel.setLayout(null);
        quickLinksPanel.setBackground(Color.WHITE);

        JTextField quicklinksl = new JTextField("Quick - Links");
        quicklinksl.setBounds(5, 7, 258, 30);
        quicklinksl.setEditable(false);
        quicklinksl.setBackground(quicklinkColor1);
        quicklinksl.setForeground(Color.WHITE);
        quicklinksl.setHorizontalAlignment(SwingConstants.CENTER);
        quicklinksl.setFont(new Font("forte", Font.ITALIC, 18));
        quicklinksl.setBorder(dashBorder1);
        quicklinksl.setEnabled(false);

        JButton empMaster = new JButton("Emp Master");
        empMaster.setBounds(5, 55, 126, 30);
        empMaster.setHorizontalAlignment(SwingConstants.CENTER);
        empMaster.setBackground(quicklinkColor);
        empMaster.setForeground(Color.WHITE);

        JButton indent = new JButton("Indent");
        indent.setBounds(136, 55, 126, 30);
        indent.setHorizontalAlignment(SwingConstants.CENTER);
        indent.setBackground(quicklinkColor);
        indent.setForeground(Color.WHITE);

        JButton purchaseBill = new JButton("Purchase Bill");
        purchaseBill.setBounds(5, 105, 126, 30);
        purchaseBill.setHorizontalAlignment(SwingConstants.CENTER);
        purchaseBill.setBackground(quicklinkColor);
        purchaseBill.setForeground(Color.WHITE);

        JButton gateEntry = new JButton("Gate Entry");
        gateEntry.setBounds(136, 105, 126, 30);
        gateEntry.setHorizontalAlignment(SwingConstants.CENTER);
        gateEntry.setBackground(quicklinkColor);
        gateEntry.setForeground(Color.WHITE);

        JButton visitorEntryPass = new JButton("Visitors Entry Pass");
        visitorEntryPass.setBounds(5, 155, 258, 30);
        visitorEntryPass.setHorizontalAlignment(SwingConstants.CENTER);
        visitorEntryPass.setBackground(quicklinkColor);
        visitorEntryPass.setForeground(Color.WHITE);

        JButton salesInvoice = new JButton("Sales Invoice");
        salesInvoice.setBounds(5, 205, 126, 30);
        salesInvoice.setHorizontalAlignment(SwingConstants.CENTER);
        salesInvoice.setBackground(quicklinkColor);
        salesInvoice.setForeground(Color.WHITE);

        JButton requisition = new JButton("Requisition");
        requisition.setBounds(136, 205, 126, 30);
        requisition.setHorizontalAlignment(SwingConstants.CENTER);
        requisition.setBackground(quicklinkColor);
        requisition.setForeground(Color.WHITE);

        JButton assetsMaster = new JButton("Assets Master");
        assetsMaster.setBounds(5, 255, 126, 30);
        assetsMaster.setHorizontalAlignment(SwingConstants.CENTER);
        assetsMaster.setBackground(quicklinkColor);
        assetsMaster.setForeground(Color.WHITE);

        quickLinksPanel.add(quicklinksl);
        quickLinksPanel.add(empMaster);
        quickLinksPanel.add(indent);
        quickLinksPanel.add(purchaseBill);
        quickLinksPanel.add(gateEntry);
        quickLinksPanel.add(visitorEntryPass);
        quickLinksPanel.add(salesInvoice);
        quickLinksPanel.add(requisition);
        quickLinksPanel.add(assetsMaster);

        myQuickLinkMouseListener(empMaster);
        myQuickLinkMouseListener(indent);
        myQuickLinkMouseListener(purchaseBill);
        myQuickLinkMouseListener(gateEntry);
        myQuickLinkMouseListener(visitorEntryPass);
        myQuickLinkMouseListener(salesInvoice);
        myQuickLinkMouseListener(requisition);
        myQuickLinkMouseListener(assetsMaster);

        quicklinksl.addMouseListener(new MouseListener() {
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
                quicklinksl.setFont(new Font("forte", Font.BOLD, 22));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                quicklinksl.setFont(new Font("forte", Font.ITALIC, 18));

            }
        });

        empMaster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmpMasterFrame();
            }
        });

        requisition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRequisitionFrame();
            }
        });

        indent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addIndentFrame();
            }
        });

        return quickLinksPanel;
    }

    public void removeDashboardPanel() {
        dashboardPanel.remove(pieChartPanel);
        dashboardPanel.remove(mBarChartPanel);
        dashboardPanel.remove(financePanel);
        dashboardPanel.remove(notepadPanel);
        if (formFlag) {
            if (RecMenuNumber == 0) {
//            } else if (RecMenuNumber == 1) {
//                dashboardPanel.remove(addMasterPanel);
            }
        }
        pieChartFlag = false;
        rootpanel.repaint();
        rootpanel.revalidate();
    }

    public void myActionListenerForFormPanels(JMenuItem m, int entrypointNumber) {

        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (entrypointNumber == 1) {
                    addEmpMasterFrame();
                } else if (entrypointNumber == 2) {
                    addDesignationMasterFrame();
                } else if (entrypointNumber == 3) {
                    addDepartmentMasterFrame();
                } else if (entrypointNumber == 4) {
                    addPartyMasterFrame();
                } else if (entrypointNumber == 5) {
                    addAreaMasterFrame();
                } else if (entrypointNumber == 6) {
                    addItemMasterFrame();
                } else if (entrypointNumber == 7) {
                    addICategoryMasterFrame();
                }

                if (entrypointNumber == 21) {
                    addIndentFrame();
                }
                if (entrypointNumber == 22) {
                    addEnquiryFrame();
                }
                if (entrypointNumber == 23) {
                    addPOFrame();
                }
                if (entrypointNumber == 51) {
                    addRequisitionFrame();
                }

                if (entrypointNumber == 71) {
                    addSalesBarChartFrame();
                }
                if (entrypointNumber == 72) {
                    addpurchaseBarChartFrame();
                }
                
                
                
                if(entrypointNumber == 81){
                    addAssetCategoryFrame();
                }
                
                

            }
        });
    }

    public void myQuickLinkMouseListener(JButton n) {

        n.addMouseListener(new MouseListener() {
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
                n.setBackground(Color.WHITE);
                n.setForeground(quicklinkColor);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                n.setBackground(quicklinkColor);
                n.setForeground(Color.WHITE);
            }
        });
    }

    public void myKeyListnerForCharacterControl(JTextField j, int character) {
        j.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if ((j.getText().length()) >= character) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    ////<<<<------------------====================MASTER STARTS====================------------------>>>>////
    //<------------------------------**** EMPLOYEE MASTER STARTS ****-------------------------------->//
    public JFrame addEmpMasterFrame() {

        EmployeeMast em = new EmployeeMast();
        MyLibrary myL = new MyLibrary();
        ArrayList<String> designationList = new ArrayList<String>();
        ArrayList<String> departmentList = new ArrayList<String>();
        ArrayList<String> cityList = new ArrayList<String>();
        empimagePhotoIcon = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftware8\\src\\pictures used\\uploadimage.png"); // Replace with your image path

        cityList.addAll(em.getCityList());
        designationList.addAll(em.getDesignationList());
        departmentList.addAll(em.getDepartmentList());

        entryPoint.setFormPanelHeightBounds(750);
        EmpmasterFrame = entryPoint.addFrame();
        entryPoint.getFrame.setTitle("Employee Master");
        entryPoint.setFormName("Employee Master");
        entryPoint.control.printButton.setEnabled(false);

        nameL = new JLabel("Name");
        nameL.setBounds(25, 45, 100, 25);
        mrmrs = myL.createSpecialJComboBox(nametype, false);
        mrmrs.setBounds(150, 45, 50, 25);
        mrmrs.setEditable(false);
        empName = myL.createSpecialJTextField(20, true);
        empName.setBounds(205, 45, 460, 25);
        empName.setEditable(false);

        displayNameL = new JLabel("Display Name");
        displayNameL.setBounds(25, 75, 100, 25);
        empDisplayName = myL.createSpecialJTextField(20, true);
        empDisplayName.setBounds(150, 75, 515, 25);
        empDisplayName.setEditable(false);

        genderL = new JLabel("Gender");
        genderL.setBounds(25, 105, 100, 25);
        String[] gender = new String[]{"Male", "Female", "Other"};
        empGender = myL.createSpecialJComboBox(gender, true);
        empGender.setBounds(150, 105, 170, 25);
        empGender.setEditable(false);

        empCodeL = new JLabel("Employee ID");
        empCodeL.setBounds(350, 105, 94, 25);
        empCode = myL.createSpecialJTextField(20, false);
        empCode.setBounds(430, 105, 235, 25);
        empCode.setEditable(false);

        maritalStatusL = new JLabel("Marital Status");
        maritalStatusL.setBounds(25, 135, 100, 25);
        String[] maritalStatus = new String[]{"Married", "UnMarried", "Seperated", "Divorced", "Widowed"};
        empMaritalStatus = myL.createSpecialJComboBox(maritalStatus, true);
        empMaritalStatus.setBounds(150, 135, 170, 25);
        empMaritalStatus.setEditable(false);

        empSpouseL = new JLabel("Spouse");
        empSpouseL.setBounds(350, 135, 94, 25);
        empSpouse = myL.createSpecialJTextField(20, false);
        empSpouse.setBounds(430, 135, 235, 25);
        empSpouse.setEditable(false);

        religionL = new JLabel("Religion");
        religionL.setBounds(25, 165, 100, 25);
        String[] religion = new String[]{"Hindu", "Sikh", "Budhhist", "Christian", "Muslim"};
        empReligion = myL.createSpecialJComboBox(religion, false);
        empReligion.setBounds(150, 165, 515, 25);
        empReligion.setEditable(false);

        natL = new JLabel("Nature");
        natL.setBounds(25, 195, 100, 25);
        String[] nature = new String[]{"Employee", "Godown", "Ledger", "Location", "Manufacturer", "Other", "Party", "Process", "Purchase", "Sales", "Agent", "Bank", "Broker", "Cash", "Common", "Contractor", "Customer", "Department", "Division", "Driver"};
        empNature = myL.createSpecialJComboBox(nature, true);
        empNature.setBounds(150, 195, 515, 25);
        empNature.setEditable(false);

        String[] designationRecieved = designationList.toArray(new String[designationList.size()]);
        desigL = new JLabel("Designation");
        desigL.setBounds(25, 225, 100, 25);
        empDesignation = myL.createSpecialJComboBox(designationRecieved, false);////////////////////////////////////////////////////////////////////////////////////////////////////////////
        empDesignation.setBounds(150, 225, 515, 25);
        empDesignation.setEditable(false);

        String[] departmentRecieved = departmentList.toArray(new String[departmentList.size()]);
        deparL = new JLabel("Department");
        deparL.setBounds(25, 255, 100, 25);
        empDepartment = myL.createSpecialJComboBox(departmentRecieved, false);
        empDepartment.setBounds(150, 255, 515, 25);
        empDepartment.setEditable(false);

        fatherNameL = new JLabel("Father Name");
        fatherNameL.setBounds(25, 285, 100, 25);
        empFatherName = myL.createSpecialJTextField(20, false);
        empFatherName.setBounds(150, 285, 515, 25);
        empFatherName.setEditable(false);

        phoneNoL = new JLabel("Phone Number");
        phoneNoL.setBounds(25, 315, 100, 25);
        empPhoneNo = myL.createNumericTextFieldWithLimit(10, 10, false);
        empPhoneNo.setBounds(150, 315, 170, 25);
        empPhoneNo.setEditable(false);

        mobileL = new JLabel("Mobile No.");
        mobileL.setBounds(350, 315, 94, 25);
        empMobileNo = myL.createNumericTextFieldWithLimit(10, 10, true);
        empMobileNo.setBounds(430, 315, 235, 25);
        empMobileNo.setEditable(false);

        adharL = new JLabel("Adhaar Number");
        adharL.setBounds(25, 345, 100, 25);
        empAdhar = myL.createNumericTextFieldWithLimit(16, 16, true);
        empAdhar.setBounds(150, 345, 515, 25);
        empAdhar.setEditable(false);

        permanentAddressL = new JLabel("PERMANENT ADDRESS");
        permanentAddressL.setBounds(25, 375, 150, 25);
        permanentAddressL.setForeground(color1);

        addressL = new JLabel("Address");
        addressL.setBounds(25, 405, 100, 25);
        empAddress = myL.createSpecialJTextField(50, true);
        empAddress.setBounds(150, 405, 515, 25);
        empAddress.setEditable(false);

        String[] cityRecieved = cityList.toArray(new String[cityList.size()]);
        cityL = new JLabel("City");
        cityL.setBounds(25, 435, 100, 25);
        empCity = myL.createSpecialJComboBox(cityRecieved, true);
        empCity.setBounds(150, 435, 515, 25);
        empCity.setEditable(false);

        countryL = new JLabel("Country");
        countryL.setBounds(25, 465, 100, 25);
        empCountry = myL.createSpecialJTextField(20, true);
        empCountry.setBounds(150, 465, 300, 25);
        empCountry.setEditable(false);
        empCountry.setText("India");

        pinL = new JLabel("Pin");
        pinL.setBounds(25, 495, 100, 25);
        empPincode = myL.createNumericTextFieldWithLimit(6, 6, true);
        empPincode.setBounds(150, 495, 300, 25);
        empPincode.setEditable(false);

        temporaryAddressL = new JLabel("TEMPORARY ADDRESS");
        temporaryAddressL.setBounds(25, 525, 150, 25);
        temporaryAddressL.setForeground(color1);
        temporaryButton = new JButton("Copy Permanent Address");
        temporaryButton.setBounds(200, 525, 250, 25);
        temporaryButton.setForeground(Color.WHITE);
        temporaryButton.setBackground(lightblue);

        taddressL = new JLabel("Address");
        taddressL.setBounds(25, 555, 100, 25);
        tEmpAddress = myLib.createSpecialJTextField(20, false);
        tEmpAddress.setBounds(150, 555, 515, 25);
        tEmpAddress.setEditable(false);

        tcityL = new JLabel("City");
        tcityL.setBounds(25, 585, 100, 25);
        tEmpCity = myL.createSpecialJComboBox(cityRecieved, false);
        tEmpCity.setBounds(150, 585, 515, 25);
        tEmpCity.setEditable(false);

        tcountryL = new JLabel("Country");
        tcountryL.setBounds(25, 615, 100, 25);
        tEmpCountry = myL.createSpecialJTextField(20, false);
        tEmpCountry.setBounds(150, 615, 300, 25);
        tEmpCountry.setEditable(false);
        tEmpCountry.setText("India");

        tpinL = new JLabel("Pin");
        tpinL.setBounds(25, 645, 100, 25);
        tEmpPincode = myL.createNumericTextFieldWithLimit(6, 6, false);
        tEmpPincode.setBounds(150, 645, 300, 25);
        tEmpPincode.setEditable(false);

        empdobL = new JLabel("Date of Birth");
        empdobL.setBounds(690, 45, 100, 25);
        empDob = myL.createSpecialJTextField(11, false);
        empDob.setBounds(800, 45, 200, 25);
        empDob.setEditable(false);
        empDob.setToolTipText("dd/mm/yyyy");
        myKeyListnerForCharacterControl(empDob, 11);

        empdojL = new JLabel("Joining Date");
        empdojL.setBounds(690, 75, 100, 25);
        empDoj = myL.createSpecialJTextField(11, false);
        empDoj.setBounds(800, 75, 200, 25);
        empDoj.setEditable(false);
        empDoj.setToolTipText("dd/mm/yyyy");
        myKeyListnerForCharacterControl(empDoj, 11);

        empRsignationL = new JLabel("Resignation Date");
        empRsignationL.setBounds(690, 105, 100, 25);
        empResignation = myL.createSpecialJTextField(11, false);
        empResignation.setBounds(800, 105, 200, 25);
        empResignation.setEditable(false);
        empResignation.setToolTipText("dd/mm/yyyy");

        bloodGroupL = new JLabel("Blood Group");
        bloodGroupL.setBounds(690, 135, 100, 25);
        String[] bloodGroup = new String[]{"O+", "A+", "B+", "AB+", "O-", "A-", "B-", "AB-"};
        bloodgroup = myL.createSpecialJComboBox(bloodGroup, false);
        bloodgroup.setBounds(800, 135, 250, 25);
        bloodgroup.setEditable(false);

        emppanL = new JLabel("PAN");
        emppanL.setBounds(690, 165, 100, 25);
        empPan = myL.createSpecialJTextField(10, false);
        empPan.setBounds(800, 165, 250, 25);
        empPan.setEditable(false);
        myKeyListnerForCharacterControl(empPan, 10);

        empBankAccL = new JLabel("Bank Account No.");
        empBankAccL.setBounds(690, 195, 100, 25);
        empBankAcc = myL.createNumericTextFieldWithLimit(20, 20, false);
        empBankAcc.setBounds(800, 195, 250, 25);
        empBankAcc.setEditable(false);

        empPFAccL = new JLabel("PF Account No.");
        empPFAccL.setBounds(690, 225, 100, 25);
        empPFAcc = myL.createNumericTextFieldWithLimit(20, 20, false);
        empPFAcc.setBounds(800, 225, 250, 25);
        empPFAcc.setEditable(false);

        empLicenseL = new JLabel("License No.");
        empLicenseL.setBounds(690, 255, 250, 25);
        empLicense = myL.createNumericTextFieldWithLimit(20, 20, false);
        empLicense.setBounds(800, 255, 515, 25);
        empLicense.setEditable(false);

        empPassportL = new JLabel("Passport No.");
        empPassportL.setBounds(690, 285, 100, 25);
        empPassport = myL.createSpecialJTextField(20, false);
        empPassport.setBounds(800, 285, 515, 25);
        empPassport.setEditable(false);

        empQualificationL = new JLabel("Qualification");
        empQualificationL.setBounds(690, 315, 100, 25);
        empQualification = myL.createSpecialJTextField(20, false);
        empQualification.setBounds(800, 315, 515, 25);
        empQualification.setEditable(false);

        empTDSL = new JLabel("TDS Category");
        empTDSL.setBounds(690, 345, 100, 25);
        empTDS = myL.createSpecialJComboBox(tdscat, false);
        empTDS.setBounds(800, 345, 515, 25);
        empTDS.setEditable(false);

        empActiveL = new JLabel("Active");
        empActiveL.setBounds(690, 375, 100, 25);
        String[] activeStatus = new String[]{"Yes", "No"};
        empActive = myL.createSpecialJComboBox(activeStatus, false);
        empActive.setBounds(800, 375, 200, 25);
        empActive.setEditable(false);

        empRemarkL = new JLabel("Remark");
        empRemarkL.setBounds(690, 405, 100, 25);
        empRemark = myL.createSpecialJTextField(20, false);
        empRemark.setBounds(800, 405, 515, 25);
        empRemark.setEditable(false);

        empImage = new JLabel(empimagePhotoIcon);
        empImage.setBounds(1100, 45, 200, 200);
        empImage.setBorder(dashBorder1);
        empImage.setToolTipText("Click to Add Image");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(2, 1));
        searchPanel.setBounds(900, 450, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JRadioButton searchByEmployee = new JRadioButton("Search by Employee Name");
        JRadioButton searchByCode = new JRadioButton("Search by Employee ID");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByEmployee);
        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        entryPoint.getFormPanel.add(nameL);
        entryPoint.getFormPanel.add(mrmrs);
        entryPoint.getFormPanel.add(empName);

        entryPoint.getFormPanel.add(displayNameL);
        entryPoint.getFormPanel.add(empDisplayName);

        entryPoint.getFormPanel.add(genderL);
        entryPoint.getFormPanel.add(empGender);

        entryPoint.getFormPanel.add(empCode);
        entryPoint.getFormPanel.add(empCodeL);

        entryPoint.getFormPanel.add(maritalStatusL);
        entryPoint.getFormPanel.add(empMaritalStatus);

        entryPoint.getFormPanel.add(empSpouse);
        entryPoint.getFormPanel.add(empSpouseL);

        entryPoint.getFormPanel.add(religionL);
        entryPoint.getFormPanel.add(empReligion);

        entryPoint.getFormPanel.add(natL);
        entryPoint.getFormPanel.add(empNature);

        entryPoint.getFormPanel.add(desigL);
        entryPoint.getFormPanel.add(empDesignation);

        entryPoint.getFormPanel.add(deparL);
        entryPoint.getFormPanel.add(empDepartment);

        entryPoint.getFormPanel.add(fatherNameL);
        entryPoint.getFormPanel.add(empFatherName);

        entryPoint.getFormPanel.add(phoneNoL);
        entryPoint.getFormPanel.add(empPhoneNo);
        entryPoint.getFormPanel.add(mobileL);
        entryPoint.getFormPanel.add(empMobileNo);

        entryPoint.getFormPanel.add(adharL);
        entryPoint.getFormPanel.add(empAdhar);

        entryPoint.getFormPanel.add(permanentAddressL);

        entryPoint.getFormPanel.add(addressL);
        entryPoint.getFormPanel.add(empAddress);

        entryPoint.getFormPanel.add(cityL);
        entryPoint.getFormPanel.add(empCity);

        entryPoint.getFormPanel.add(countryL);
        entryPoint.getFormPanel.add(empCountry);

        entryPoint.getFormPanel.add(pinL);
        entryPoint.getFormPanel.add(empPincode);

        entryPoint.getFormPanel.add(temporaryAddressL);
        entryPoint.getFormPanel.add(temporaryButton);

        entryPoint.getFormPanel.add(taddressL);
        entryPoint.getFormPanel.add(tEmpAddress);

        entryPoint.getFormPanel.add(tcityL);
        entryPoint.getFormPanel.add(tEmpCity);

        entryPoint.getFormPanel.add(tcountryL);
        entryPoint.getFormPanel.add(tEmpCountry);

        entryPoint.getFormPanel.add(tpinL);
        entryPoint.getFormPanel.add(tEmpPincode);

        entryPoint.getFormPanel.add(empdobL);
        entryPoint.getFormPanel.add(empDob);

        entryPoint.getFormPanel.add(empdojL);
        entryPoint.getFormPanel.add(empDoj);

        entryPoint.getFormPanel.add(empRsignationL);
        entryPoint.getFormPanel.add(empResignation);

        entryPoint.getFormPanel.add(empBankAccL);
        entryPoint.getFormPanel.add(empBankAcc);

        entryPoint.getFormPanel.add(emppanL);
        entryPoint.getFormPanel.add(empPan);

        entryPoint.getFormPanel.add(empLicenseL);
        entryPoint.getFormPanel.add(empLicense);

        entryPoint.getFormPanel.add(empPFAccL);
        entryPoint.getFormPanel.add(empPFAcc);

        entryPoint.getFormPanel.add(empRemarkL);
        entryPoint.getFormPanel.add(empRemark);

        entryPoint.getFormPanel.add(bloodGroupL);
        entryPoint.getFormPanel.add(bloodgroup);

        entryPoint.getFormPanel.add(empActiveL);
        entryPoint.getFormPanel.add(empActive);

        entryPoint.getFormPanel.add(empQualificationL);
        entryPoint.getFormPanel.add(empQualification);

        entryPoint.getFormPanel.add(empTDSL);
        entryPoint.getFormPanel.add(empTDS);

        entryPoint.getFormPanel.add(empPassportL);
        entryPoint.getFormPanel.add(empPassport);

        entryPoint.getFormPanel.add(empImage);

        empCity.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String countryrec = em.getCountry(empCity.getSelectedItem().toString());
                empCountry.setText(countryrec);
            }
        });
        tEmpCity.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String countryrec = em.getCountry(tEmpCity.getSelectedItem().toString());
                tEmpCountry.setText(countryrec);
            }
        });

        temporaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tEmpAddress.setText(empAddress.getText());
                tEmpCountry.setText(empCountry.getText());
                tEmpPincode.setText(empPincode.getText());
                tEmpCity.setSelectedItem(empCity.getSelectedItem());
            }
        });

        empImage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Choosing Photo...");

                JFileChooser selectImage = new JFileChooser(); // To select the file

                FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif", "bmp");
                selectImage.setFileFilter(imageFilter);

                int rVal = selectImage.showOpenDialog(null); // Returns value for success and failure

                if (rVal == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = selectImage.getSelectedFile(); // Storing the selected file
                    employeeImageFile = selectedFile;

                    try {
                        // Load the selected image into a BufferedImage
                        BufferedImage originalImage = ImageIO.read(selectedFile);

                        // Get the dimensions of the imageLabel
                        int labelWidth = empImage.getWidth();
                        int labelHeight = empImage.getHeight();

                        // Scale the image to fit the label while preserving its aspect ratio
                        ImageIcon scaledImageIcon = new ImageIcon(originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH));

                        FileInputStream fis = new FileInputStream(selectedFile);
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        byte[] buf = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = fis.read(buf)) != -1) {
                            bos.write(buf, 0, bytesRead);
                        }
//                        employeeModel.setEmpImage(bos.toByteArray());
                        empImageByte = bos.toByteArray();
                        // Set the scaled image in the JLabel
                        empImage.setIcon(scaledImageIcon);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        myFocusListenerForDate(empResignation);
        myFocusListenerForDate(empDob);
        myFocusListenerForDate(empDoj);

        MyFocusListener setFocusMethod = new MyFocusListener();

        MyFocusListener manager = new MyFocusListener(empName, empDisplayName, empSpouse, empFatherName, empPhoneNo, empMobileNo, empAdhar, empAddress, empPincode,
                tEmpAddress, tEmpPincode, empDob, empDoj, empResignation, empPan, empBankAcc, empPFAcc, empLicense, empPassport, empQualification, empRemark);

        BackgroundColorChanger colorChanger = new BackgroundColorChanger(lightblue, Color.WHITE);
        colorChanger.setFocusListeners(empName, empDisplayName, empSpouse, empFatherName, empPhoneNo, empMobileNo, empAdhar, empAddress, empPincode,
                tEmpAddress, tEmpPincode, empDob, empDoj, empResignation, empPan, empBankAcc, empPFAcc, empLicense, empPassport, empQualification, empRemark);

        colorChanger.setFocusListenersforJCombo(mrmrs, empMaritalStatus, empGender, empReligion, empNature, empDesignation, empDepartment, empCity, tEmpCity, bloodgroup, empTDS, empActive);

        JTextField[] allTextFiledsArray = new JTextField[]{empName, empDisplayName, empSpouse, empFatherName, empPhoneNo, empMobileNo, empAdhar, empAddress, empPincode,
            tEmpAddress, tEmpPincode, empDob, empDoj, empResignation, empPan, empBankAcc, empPFAcc, empLicense, empPassport, empQualification, empRemark};

        JComboBox[] allComboBoxArray = new JComboBox[]{mrmrs, empMaritalStatus, empGender, empReligion, empNature, empDesignation, empDepartment, empCity, tEmpCity, bloodgroup, empTDS, empActive};

        entryPoint.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    employeeMasterClear(allComboBoxArray, allTextFiledsArray);
                    setEditableFieldEmployeeMaster(allComboBoxArray, allTextFiledsArray);
                    empName.requestFocus(true);
                    entryPoint.control.saveButton.setEnabled(true);
                    entryPoint.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setUneditableFieldEmployeeMaster(allComboBoxArray, allTextFiledsArray);
                    entryPoint.control.searchButton.setEnabled(true);
                    entryPoint.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPoint.control.deleteButton.setEnabled(false);
        entryPoint.control.printButton.setEnabled(false);
        entryPoint.control.editButton.setEnabled(false);
        entryPoint.control.saveButton.setEnabled(false);

        empRemark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = em.chkVld(empName, empDisplayName, empGender, empMaritalStatus, empNature, empDesignation, empDepartment, empMobileNo, empAdhar, empAddress,
                        empCity, empCountry, empPincode);

                if (isValid) {
                    if (entryPoint.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        em.saveRecord(mrmrs, empName, empDisplayName, empGender, empMaritalStatus, empSpouse, empReligion, empNature, empDesignation,
                                empDepartment, empFatherName, empPhoneNo, empMobileNo, empAdhar, empAddress, empCity,
                                empCountry, empPincode, tEmpAddress, tEmpCity, tEmpCountry, tEmpPincode, empDob, empDoj,
                                empResignation, bloodgroup, empPan, empBankAcc, empPFAcc, empLicense,
                                empPassport, empQualification, empTDS, empActive, empRemark, employeeImageFile, moverecCodeforEmpM, addButtonFlag);
                        entryPoint.control.addButton.setEnabled(true);
                        entryPoint.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        employeeMasterClear(allComboBoxArray, allTextFiledsArray);
                        empName.requestFocus(true);

                    } else {
                        addButtonFlag = true;
                        em.saveRecord(mrmrs, empName, empDisplayName, empGender, empMaritalStatus, empSpouse, empReligion, empNature, empDesignation,
                                empDepartment, empFatherName, empPhoneNo, empMobileNo, empAdhar, empAddress, empCity,
                                empCountry, empPincode, tEmpAddress, tEmpCity, tEmpCountry, tEmpPincode, empDob, empDoj,
                                empResignation, bloodgroup, empPan, empBankAcc, empPFAcc, empLicense,
                                empPassport, empQualification, empTDS, empActive, empRemark, employeeImageFile, moverecCodeforEmpM, addButtonFlag);
                        employeeMasterClear(allComboBoxArray, allTextFiledsArray);
                        empName.requestFocus(true);
                    }
                }
            }
        });
        entryPoint.control.saveButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                boolean isValid = em.chkVld(empName, empDisplayName, empGender, empMaritalStatus, empNature, empDesignation, empDepartment, empMobileNo, empAdhar, empAddress,
                        empCity, empCountry, empPincode);

                if (isValid) {
                    if (entryPoint.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        em.saveRecord(mrmrs, empName, empDisplayName, empGender, empMaritalStatus, empSpouse, empReligion, empNature, empDesignation,
                                empDepartment, empFatherName, empPhoneNo, empMobileNo, empAdhar, empAddress, empCity,
                                empCountry, empPincode, tEmpAddress, tEmpCity, tEmpCountry, tEmpPincode, empDob, empDoj,
                                empResignation, bloodgroup, empPan, empBankAcc, empPFAcc, empLicense,
                                empPassport, empQualification, empTDS, empActive, empRemark, employeeImageFile, moverecCodeforEmpM, addButtonFlag);
                        entryPoint.control.addButton.setEnabled(true);
                        entryPoint.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        employeeMasterClear(allComboBoxArray, allTextFiledsArray);
                        empName.requestFocus(true);

                    } else {
                        addButtonFlag = true;
                        em.saveRecord(mrmrs, empName, empDisplayName, empGender, empMaritalStatus, empSpouse, empReligion, empNature, empDesignation,
                                empDepartment, empFatherName, empPhoneNo, empMobileNo, empAdhar, empAddress, empCity,
                                empCountry, empPincode, tEmpAddress, tEmpCity, tEmpCountry, tEmpPincode, empDob, empDoj,
                                empResignation, bloodgroup, empPan, empBankAcc, empPFAcc, empLicense,
                                empPassport, empQualification, empTDS, empActive, empRemark, employeeImageFile, moverecCodeforEmpM, addButtonFlag);
                        employeeMasterClear(allComboBoxArray, allTextFiledsArray);
                        empName.requestFocus(true);

                    }
                }
            }
        }
        );
        entryPoint.control.editButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                setEditableFieldDepmaster();
                entryPoint.control.addButton.setEnabled(true);
                entryPoint.control.deleteButton.setEnabled(false);
                entryPoint.control.printButton.setEnabled(false);
                entryPoint.control.searchButton.setEnabled(false);
            }
        }
        );

        entryPoint.control.searchButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByEmployee);
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    entryPoint.getFormPanel.add(searchPanel);
                    entryPoint.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateEmployee_Master();

                } else if (!searchflag) {
                    searchPanel.setVisible(false);
                    entryPoint.control.addButton.setEnabled(true);
                    entryPoint.control.deleteButton.setEnabled(false);
                    entryPoint.control.printButton.setEnabled(false);
                    entryPoint.control.editButton.setEnabled(false);
                    setUneditableFieldEmployeeMaster(allComboBoxArray, allTextFiledsArray);

                    revalidateEmployee_Master();

                    searchflag = true;
                }
            }
        }
        );

        searchByEmployee.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Employee Name");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);
                    searchfield.requestFocus();

                    revalidateEmployee_Master();

                    employeeSearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            em.moverec(searchfield.getText(), employeeSearchby, employeeModel);
                            if (employeeModel.isStatus()) {
                                moverecCodeforEmpM = employeeModel.getCode();

                                mrmrs.setSelectedItem(myLib.sNull(employeeModel.getTxtmrmrs()));
                                empGender.setSelectedItem(myLib.sNull(employeeModel.getTxtGender()));
                                empMaritalStatus.setSelectedItem(myLib.sNull(employeeModel.getTxtMaritalStatus()));
                                empReligion.setSelectedItem(myLib.sNull(employeeModel.getTxtReligion()));
                                empNature.setSelectedItem(myLib.sNull(employeeModel.getTxtNature()));
                                empDesignation.setSelectedItem(myLib.sNull(employeeModel.getTxtDesignation()));
                                empDepartment.setSelectedItem(myLib.sNull(employeeModel.getTxtDepartment()));
                                empCity.setSelectedItem(myLib.sNull(employeeModel.getTxtCity()));
                                tEmpCity.setSelectedItem(myLib.sNull(employeeModel.getTxtTempCity()));
                                bloodgroup.setSelectedItem(myLib.sNull(employeeModel.getTxtBloodGroup()));

                                empName.setText(myLib.sNull(employeeModel.getTxtName()));
                                empFatherName.setText(myLib.sNull(employeeModel.getTxtFatherName()));
                                empPhoneNo.setText(myLib.sNull(employeeModel.getTxtPhone()));
                                empMobileNo.setText(myLib.sNull(employeeModel.getTxtMobile()));
                                empAdhar.setText(myLib.sNull(employeeModel.getTxtAdhar()));
                                empAddress.setText(myLib.sNull(employeeModel.getTxtAddress()));
                                empAddress.setText(myLib.sNull(employeeModel.getTxtAddress()));//////////////////
                                empSpouse.setText(myLib.sNull(employeeModel.getTxtSpouse()));
                                empCode.setText(myLib.sNull(employeeModel.getTxtEmpID()));
                                empDisplayName.setText(myLib.sNull(employeeModel.getTxtDisplayName()));
                                empCountry.setText(myLib.sNull(employeeModel.getTxtCountry()));
                                empPincode.setText(myLib.sNull(employeeModel.getTxtpinCode()));
                                tEmpPincode.setText(myLib.sNull(employeeModel.getTxtTempPincode()));
                                tEmpAddress.setText(myLib.sNull(employeeModel.getTxtTempAddress()));
                                tEmpCountry.setText(myLib.sNull(employeeModel.getTxtTempCountry()));
                                empDob.setText(myLib.sNull(employeeModel.getTxtDOB()));
                                empDoj.setText(myLib.sNull(employeeModel.getTxtDOJ()));
                                empResignation.setText(myLib.sNull(employeeModel.getTxtResignation()));
                                empPan.setText(myLib.sNull(employeeModel.getTxtPan()));
                                empBankAcc.setText(myLib.sNull(employeeModel.getTxtBank()));
                                empPFAcc.setText(myLib.sNull(employeeModel.getTxtPF()));
                                empLicense.setText(myLib.sNull(employeeModel.getTxtLicense()));
                                empPassport.setText(myLib.sNull(employeeModel.getTxtPassport()));
                                empQualification.setText(myLib.sNull(employeeModel.getTxtQualification()));
                                empRemark.setText(myLib.sNull(employeeModel.getTxtRemark()));

                                try {

//                                    Image empImageRec = Toolkit.getDefaultToolkit().createImage(employeeModel.getEmpImage());
//                                    int labelWidth = empImage.getWidth();
//                                    int labelHeight = empImage.getHeight();
//                                    Image scaledImage = empImageRec.getScaledInstance(labelWidth, labelHeight, empImageRec.SCALE_SMOOTH);
//                                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                                    ImageIcon scaledImageIcon = new ImageIcon(employeeModel.getEmpImage());
                                    int labelWidth = empImage.getWidth(); // Replace empImage with the actual JLabel
                                    int labelHeight = empImage.getHeight(); // Replace empImage with the actual JLabel
                                    Image scaledImage = scaledImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                                    empImage.setIcon(new ImageIcon(scaledImage));

                                } catch (Exception l) {

                                }
                                String createdon = myLib.sNull(Departmentmodel.getCreatedOn());
                                String modifiedon = myLib.sNull(Departmentmodel.getModifiedOn());

                                entryPoint.txtCreatedBy.setText(createdon);
                                entryPoint.txtModifiedBy.setText(modifiedon);

                                entryPoint.getFormPanel.remove(searchPanel);

                                revalidateEmployee_Master();

                                entryPoint.control.editButton.setEnabled(true);
                                entryPoint.control.deleteButton.setEnabled(true);
                                entryPoint.control.printButton.setEnabled(true);
                                entryPoint.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        }
        );

        searchByCode.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Employee ID");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield2 = myLib.createSpecialJTextField(20, false);
                    searchfield2.setBounds(30, 55, 130, 25);
                    searchfield2.setToolTipText("EMP........");
                    searchPanel.add(searchfield2);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);
                    searchfield2.requestFocus();

                    revalidateEmployee_Master();

                    employeeSearchby = 2;

                    // Add action listeners for search field here
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            em.moverec(searchfield.getText(), employeeSearchby, employeeModel);
                            if (employeeModel.isStatus()) {
                                moverecCodeforEmpM = employeeModel.getCode();

                                mrmrs.setSelectedItem(myLib.sNull(employeeModel.getTxtmrmrs()));
                                empGender.setSelectedItem(myLib.sNull(employeeModel.getTxtGender()));
                                empMaritalStatus.setSelectedItem(myLib.sNull(employeeModel.getTxtMaritalStatus()));
                                empReligion.setSelectedItem(myLib.sNull(employeeModel.getTxtReligion()));
                                empNature.setSelectedItem(myLib.sNull(employeeModel.getTxtNature()));
                                empDesignation.setSelectedItem(myLib.sNull(employeeModel.getTxtDesignation()));
                                empDepartment.setSelectedItem(myLib.sNull(employeeModel.getTxtDepartment()));
                                empCity.setSelectedItem(myLib.sNull(employeeModel.getTxtCity()));
                                tEmpCity.setSelectedItem(myLib.sNull(employeeModel.getTxtTempCity()));
                                bloodgroup.setSelectedItem(myLib.sNull(employeeModel.getTxtBloodGroup()));

                                empName.setText(myLib.sNull(employeeModel.getTxtName()));
                                empFatherName.setText(myLib.sNull(employeeModel.getTxtFatherName()));
                                empPhoneNo.setText(myLib.sNull(employeeModel.getTxtPhone()));
                                empMobileNo.setText(myLib.sNull(employeeModel.getTxtMobile()));
                                empAdhar.setText(myLib.sNull(employeeModel.getTxtAdhar()));
                                empAddress.setText(myLib.sNull(employeeModel.getTxtAddress()));
                                empAddress.setText(myLib.sNull(employeeModel.getTxtAddress()));//////////////////
                                empSpouse.setText(myLib.sNull(employeeModel.getTxtSpouse()));
                                empCode.setText(myLib.sNull(employeeModel.getTxtEmpID()));
                                empDisplayName.setText(myLib.sNull(employeeModel.getTxtDisplayName()));
                                empCountry.setText(myLib.sNull(employeeModel.getTxtCountry()));
                                empPincode.setText(myLib.sNull(employeeModel.getTxtpinCode()));
                                tEmpPincode.setText(myLib.sNull(employeeModel.getTxtTempPincode()));
                                tEmpAddress.setText(myLib.sNull(employeeModel.getTxtTempAddress()));
                                tEmpCountry.setText(myLib.sNull(employeeModel.getTxtTempCountry()));
                                empDob.setText(myLib.sNull(employeeModel.getTxtDOB()));
                                empDoj.setText(myLib.sNull(employeeModel.getTxtDOJ()));
                                empResignation.setText(myLib.sNull(employeeModel.getTxtResignation()));
                                empPan.setText(myLib.sNull(employeeModel.getTxtPan()));
                                empBankAcc.setText(myLib.sNull(employeeModel.getTxtBank()));
                                empPFAcc.setText(myLib.sNull(employeeModel.getTxtPF()));
                                empLicense.setText(myLib.sNull(employeeModel.getTxtLicense()));
                                empPassport.setText(myLib.sNull(employeeModel.getTxtPassport()));
                                empQualification.setText(myLib.sNull(employeeModel.getTxtQualification()));
                                empRemark.setText(myLib.sNull(employeeModel.getTxtRemark()));

                                try {
                                    ByteArrayInputStream inputStream = new ByteArrayInputStream(employeeModel.getEmpImage());
                                    BufferedImage image = ImageIO.read(inputStream);

                                    int labelWidth = empImage.getWidth();
                                    int labelHeight = empImage.getHeight();
                                    Image scaledImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

                                    empImage.setIcon(scaledImageIcon);

                                } catch (Exception l) {

                                }
                                String createdon = myLib.sNull(employeeModel.getCreatedOn());
                                String modifiedon = myLib.sNull(employeeModel.getModifiedOn());

                                entryPoint.txtCreatedBy.setText(createdon);
                                entryPoint.txtModifiedBy.setText(modifiedon);

                                entryPoint.getFormPanel.remove(searchPanel);

                                revalidateEmployee_Master();

                                entryPoint.control.editButton.setEnabled(true);
                                entryPoint.control.deleteButton.setEnabled(true);
                                entryPoint.control.printButton.setEnabled(true);
                                entryPoint.control.saveButton.setEnabled(true);

                            }
                        }
                    });
                }
            }
        }
        );

        entryPoint.control.deleteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                em.deleteRecord(moverecCodeforEmpM);
                employeeMasterClear(allComboBoxArray, allTextFiledsArray);
                entryPoint.control.editButton.setEnabled(false);
                entryPoint.control.deleteButton.setEnabled(false);
                entryPoint.control.printButton.setEnabled(false);
                entryPoint.control.saveButton.setEnabled(false);
                entryPoint.control.addButton.setEnabled(true);
                entryPoint.control.searchButton.setEnabled(true);
            }
        }
        );

        entryPoint.control.printButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                JOptionPane.showMessageDialog(depMasterFrame, "Available Soon..........!");
//                dpm.prnRecord(moverecCodeforDepM);
                entryPoint.control.editButton.setEnabled(false);
                entryPoint.control.deleteButton.setEnabled(false);
                entryPoint.control.printButton.setEnabled(false);
                entryPoint.control.saveButton.setEnabled(false);
                entryPoint.control.addButton.setEnabled(true);
                entryPoint.control.searchButton.setEnabled(true);

            }
        }
        );

        return EmpmasterFrame;

    }
    // helping functions for Employee master //

    public void myFocusListenerForDate(JTextField textField) {

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().equals("")) {
                    textField.setText("dd/mm/yyyy");
                }
            }
        });

    }

    public void revalidateEmployee_Master() {
        EmpmasterFrame.repaint();
        EmpmasterFrame.revalidate();
    }

    public void employeeMasterClear(JComboBox[] jcomboBoxs, JTextField... jtextFields) {

        for (JComboBox comboBox : jcomboBoxs) {
            comboBox.setSelectedIndex(0);
        }
        for (JTextField fields : jtextFields) {
            fields.setText("");
        }

        empImage.setIcon(empimagePhotoIcon);
        empDob.setText("dd/mm/yyyy");
        empDoj.setText("dd/mm/yyyy");
        empResignation.setText("dd/mm/yyyy");
        empCode.setText("");
        empCountry.setText("India");
        tEmpCountry.setText("India");
        entryPoint.txtCreatedBy.setText("");
        entryPoint.txtModifiedBy.setText("");
    }

    private void setEditableFieldEmployeeMaster(JComboBox[] jcomboBoxs, JTextField... jtextFields) {
        for (JComboBox comboBox : jcomboBoxs) {
            comboBox.setEditable(true);
        }
        for (JTextField fields : jtextFields) {
            fields.setEditable(true);
        }
    }

    private void setUneditableFieldEmployeeMaster(JComboBox[] jcomboBoxs, JTextField... jtextFields) {
        for (JComboBox comboBox : jcomboBoxs) {
            comboBox.setEditable(false);
        }
        for (JTextField fields : jtextFields) {
            fields.setEditable(false);
        }
    }
//<------------------------------**** DESIGNATION MASTER STARTS ****-------------------------------->//

    public JFrame addDesignationMasterFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        DesignationMast dm = new DesignationMast();

        entryPointDes.setFormPanelHeightBounds(750);
        desMasterFrame = entryPointDes.addFrame();

        JPanel formPanel = new JPanel(null);

        designationL = new JLabel("Designation");
        designationL.setBounds(200, 100, 100, 25);

        designation = myL.createSpecialJTextField(100, true);
        designation.setBounds(400, 100, 700, 25);
        designation.setEditable(false);

        designationShortNameL = new JLabel("Short Name");
        designationShortNameL.setBounds(200, 130, 100, 25);

        designationShortName = myL.createSpecialJTextField(100, true);
        designationShortName.setBounds(400, 130, 200, 25);
        designationShortName.setEditable(false);

        designationCodeL = new JLabel("Designation code");
        designationCodeL.setBounds(700, 130, 100, 25);

        designationCode = myL.createNumericTextFieldWithLimit(10, 8, true);
        designationCode.setBounds(900, 130, 200, 25);
        designationCode.setEditable(false);

        entryPointDes.setFormName("Designation Master");
        entryPointDes.getFrame.setTitle("Designation Master");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(2, 1));
        searchPanel.setBounds(10, 35, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JRadioButton searchByDesignation = new JRadioButton("Search by Designation");
        JRadioButton searchByCode = new JRadioButton("Search by Designation Code");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByDesignation);
        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        entryPointDes.getFormPanel.add(designationL);
        entryPointDes.getFormPanel.add(designationShortNameL);

        entryPointDes.getFormPanel.add(designation);
        entryPointDes.getFormPanel.add(designationShortName);

        entryPointDes.getFormPanel.add(designationCodeL);
        entryPointDes.getFormPanel.add(designationCode);

        MyFocusListener manager = new MyFocusListener(designation, designationShortName, designationCode);

        BackgroundColorChanger colorChanger = new BackgroundColorChanger(lightblue, Color.WHITE);
        colorChanger.setFocusListeners(designation, designationShortName, designationCode);

        MyFocusListener setFocusMethod = new MyFocusListener();
//        setFocusMethod.setFocusTraversalOrder(designation, designationShortName, designationCode);

        entryPointDes.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    desMasterClear();
                    setEditableFieldDesmaster();
                    designation.requestFocus(true);
                    entryPointDes.control.saveButton.setEnabled(true);
                    entryPointDes.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setUneditableFieldDesmaster();
                    entryPointDes.control.searchButton.setEnabled(true);
                    entryPointDes.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointDes.control.deleteButton.setEnabled(false);
        entryPointDes.control.printButton.setEnabled(false);
        entryPointDes.control.editButton.setEnabled(false);
        entryPointDes.control.saveButton.setEnabled(false);

        entryPointDes.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dm.chkVld(designation, designationShortName, designationCode);

                if (isValid) {
                    if (entryPointDes.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        dm.saveRecord(designation, designationShortName, designationCode, moverecCodeforDesM, addButtonFlag);
                        entryPointDes.control.addButton.setEnabled(true);
                        entryPointDes.control.editButton.setEnabled(false);
                        addButtonFlag = true;

                    } else {
                        addButtonFlag = true;
                        dm.saveRecord(designation, designationShortName, designationCode, moverecCodeforDesM, addButtonFlag);

                    }
                }
            }
        });
        entryPointDes.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldDesmaster();
                entryPointDes.control.addButton.setEnabled(true);
                entryPointDes.control.deleteButton.setEnabled(false);
                entryPointDes.control.printButton.setEnabled(false);
                entryPointDes.control.searchButton.setEnabled(false);
            }
        });

        designationCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dm.chkVld(designation, designationShortName, designationCode);

                if (isValid) {
                    if (entryPointDes.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        dm.saveRecord(designation, designationShortName, designationCode, moverecCodeforDesM, addButtonFlag);
                        entryPointDes.control.addButton.setEnabled(true);
                        entryPointDes.control.editButton.setEnabled(false);
                        addButtonFlag = true;

                    } else {
                        addButtonFlag = true;
                        dm.saveRecord(designation, designationShortName, designationCode, moverecCodeforDesM, addButtonFlag);

                    }
                }
            }
        });

        entryPointDes.control.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByDesignation);
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    entryPointDes.getFormPanel.add(searchPanel);
                    entryPointDes.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateDesignation_Master();

                } else if (!searchflag) {
                    searchPanel.setVisible(false);
                    entryPointDes.control.addButton.setEnabled(true);
                    entryPointDes.control.deleteButton.setEnabled(false);
                    entryPointDes.control.printButton.setEnabled(false);
                    entryPointDes.control.editButton.setEnabled(false);
                    setUneditableFieldDesmaster();

                    revalidateDesignation_Master();

                    searchflag = true;
                }
            }
        });

        searchByDesignation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Designation");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    revalidateDesignation_Master();

                    designationsearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dm.moverec(searchfield.getText(), designationsearchby, model);
                            if (model.isStatus()) {
                                moverecCodeforDesM = model.getCode();

                                designation.setText(myLib.sNull(model.getTxtDesignation()));
                                designationShortName.setText(myLib.sNull(model.getTxtDesignationShortName()));
                                designationCode.setText(myLib.sNull(model.getTxtDesignationCode()));

                                String createdon = myLib.sNull(model.getCreatedOn());
                                String modifiedon = myLib.sNull(model.getModifiedOn());

                                entryPointDes.txtCreatedBy.setText(createdon);
                                entryPointDes.txtModifiedBy.setText(modifiedon);

                                entryPointDes.getFormPanel.remove(searchPanel);

                                revalidateDesignation_Master();

                                entryPointDes.control.editButton.setEnabled(true);
                                entryPointDes.control.deleteButton.setEnabled(true);
                                entryPointDes.control.printButton.setEnabled(true);
                                entryPointDes.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        });

        searchByCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Designation Code");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield2 = new JTextField();
                    searchfield2.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield2);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    desMasterFrame.repaint();
                    desMasterFrame.revalidate();
                    designationsearchby = 2;

                    // Add action listeners for search field here
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dm.moverec(searchfield2.getText(), designationsearchby, model);
                            if (model.isStatus()) {
                                moverecCodeforDesM = model.getCode();

                                designation.setText(myLib.sNull(model.getTxtDesignation()));
                                designationShortName.setText(myLib.sNull(model.getTxtDesignationShortName()));
                                designationCode.setText(myLib.sNull(model.getTxtDesignationCode()));

                                String createdon = myLib.sNull(model.getCreatedOn());
                                String modifiedon = myLib.sNull(model.getModifiedOn());

                                entryPointDes.txtCreatedBy.setText(createdon);
                                entryPointDes.txtModifiedBy.setText(modifiedon);

                                entryPointDes.getFormPanel.remove(searchPanel);

                                revalidateDesignation_Master();

                                entryPointDes.control.editButton.setEnabled(true);
                                entryPointDes.control.deleteButton.setEnabled(true);
                                entryPointDes.control.printButton.setEnabled(true);
                                entryPointDes.control.saveButton.setEnabled(true);

                            }
                        }
                    });
                }
            }
        });

        entryPointDes.control.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.deleteRecord(moverecCodeforDesM);
                desMasterClear();
                entryPointDep.control.editButton.setEnabled(false);
                entryPointDep.control.deleteButton.setEnabled(false);
                entryPointDep.control.printButton.setEnabled(false);
                entryPointDep.control.saveButton.setEnabled(false);
                entryPointDep.control.addButton.setEnabled(true);
                entryPointDep.control.searchButton.setEnabled(true);
            }
        });

        entryPointDes.control.printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.prnRecord(moverecCodeforDesM);

            }
        });

        return desMasterFrame;

    }

    // helping functions for designation master //
    public void revalidateDesignation_Master() {
        desMasterFrame.repaint();
        desMasterFrame.revalidate();
    }

    public void desMasterClear() {
        designation.setText("");
        designationShortName.setText("");
        designationCode.setText("");
        entryPointDes.txtCreatedBy.setText("");
        entryPointDes.txtModifiedBy.setText("");
    }

    private void setEditableFieldDesmaster() {
        designation.setEditable(true);
        designationShortName.setEditable(true);
        designationCode.setEditable(true);
    }

    private void setUneditableFieldDesmaster() {
        designation.setEditable(false);
        designationShortName.setEditable(false);
        designationCode.setEditable(false);
    }

    //<------------------------------**** DEPARTMENT MASTER STARTS ****-------------------------------->//
    public JFrame addDepartmentMasterFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        DepartmentMast dpm = new DepartmentMast();
        String[] activeOptions = new String[]{"Yes", "No"};
        String[] natureOptions = new String[]{"Common", "Department", "Godown"};

        entryPointDep.setFormPanelHeightBounds(300);
        depMasterFrame = entryPointDep.addFrame();

        JPanel formPanel = new JPanel(null);

        departmentL = new JLabel("Department");
        departmentL.setBounds(200, 100, 100, 25);

        department = myL.createSpecialJTextField(100, true);
        department.setBounds(400, 100, 200, 25);
        department.setEditable(false);

        departmentShortNameL = new JLabel("Short Name");
        departmentShortNameL.setBounds(700, 100, 100, 25);

        departmentShortName = myL.createSpecialJTextField(20, true);
        departmentShortName.setBounds(900, 100, 200, 25);
        departmentShortName.setEditable(false);

        activeL = new JLabel("Active");
        activeL.setBounds(200, 130, 100, 25);

        active = myL.createSpecialJComboBox(activeOptions, true);
        active.setBounds(400, 130, 200, 25);
        active.setEditable(false);

        natureL = new JLabel("Nature");
        natureL.setBounds(700, 130, 100, 25);

        nature = myL.createSpecialJComboBox(natureOptions, true);
        nature.setBounds(900, 130, 200, 25);
        nature.setEditable(false);

        depCodeL = new JLabel("Department Code");
        depCodeL.setBounds(200, 160, 100, 25);

        depCode = myL.createNumericTextFieldWithLimit(20, 8, false);
        depCode.setBounds(400, 160, 200, 25);
        depCode.setEditable(false);
        depCode.setToolTipText("Auto Generated");

        entryPointDep.setFormName("Department Master");
        entryPointDep.getFrame.setTitle("Department Master");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(2, 1));
        searchPanel.setBounds(10, 35, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JRadioButton searchByDepartment = new JRadioButton("Search by Department");
        JRadioButton searchByCode = new JRadioButton("Search by Department Code");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByDepartment);
        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        entryPointDep.getFormPanel.add(departmentL);
        entryPointDep.getFormPanel.add(department);

        entryPointDep.getFormPanel.add(departmentShortName);
        entryPointDep.getFormPanel.add(departmentShortNameL);

        entryPointDep.getFormPanel.add(nature);
        entryPointDep.getFormPanel.add(natureL);

        entryPointDep.getFormPanel.add(activeL);
        entryPointDep.getFormPanel.add(active);

        entryPointDep.getFormPanel.add(depCode);
        entryPointDep.getFormPanel.add(depCodeL);

        MyFocusListener setFocusMethod = new MyFocusListener();

        MyFocusListener manager = new MyFocusListener(department, departmentShortName);

        BackgroundColorChanger colorChanger = new BackgroundColorChanger(lightblue, Color.WHITE);
        colorChanger.setFocusListeners(department, departmentShortName);

        entryPointDep.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    depMasterClear();
                    setEditableFieldDepmaster();
                    department.requestFocus(true);
                    entryPointDep.control.saveButton.setEnabled(true);
                    entryPointDep.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setUneditableFieldDepmaster();
                    entryPointDep.control.searchButton.setEnabled(true);
                    entryPointDep.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointDep.control.deleteButton.setEnabled(false);
        entryPointDep.control.printButton.setEnabled(false);
        entryPointDep.control.editButton.setEnabled(false);
        entryPointDep.control.saveButton.setEnabled(false);

        depCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dpm.chkVld(department, departmentShortName);

                if (isValid) {
                    if (entryPointDep.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        dpm.saveRecord(department, departmentShortName, nature, active, depCode, moverecCodeforDepM, addButtonFlag);
                        entryPointDep.control.addButton.setEnabled(true);
                        entryPointDep.control.editButton.setEnabled(false);
                        addButtonFlag = true;

                    } else {
                        addButtonFlag = true;
                        dpm.saveRecord(department, departmentShortName, nature, active, depCode, moverecCodeforDepM, addButtonFlag);

                    }
                }
            }
        });
        entryPointDep.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dpm.chkVld(department, departmentShortName);

                if (isValid) {
                    if (entryPointDep.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        dpm.saveRecord(department, departmentShortName, nature, active, depCode, moverecCodeforDepM, addButtonFlag);
                        entryPointDep.control.addButton.setEnabled(true);
                        entryPointDep.control.editButton.setEnabled(false);
                        addButtonFlag = true;

                    } else {
                        addButtonFlag = true;
                        dpm.saveRecord(department, departmentShortName, nature, active, depCode, moverecCodeforDepM, addButtonFlag);

                    }
                }
            }
        });
        entryPointDep.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldDepmaster();
                entryPointDep.control.addButton.setEnabled(true);
                entryPointDep.control.deleteButton.setEnabled(false);
                entryPointDep.control.printButton.setEnabled(false);
                entryPointDep.control.searchButton.setEnabled(false);
            }
        });

        entryPointDep.control.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByDepartment);
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    entryPointDep.getFormPanel.add(searchPanel);
                    entryPointDep.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateDepartment_Master();

                } else if (!searchflag) {
                    searchPanel.setVisible(false);
                    entryPointDep.control.addButton.setEnabled(true);
                    entryPointDep.control.deleteButton.setEnabled(false);
                    entryPointDep.control.printButton.setEnabled(false);
                    entryPointDep.control.editButton.setEnabled(false);
                    setUneditableFieldDepmaster();

                    revalidateDepartment_Master();

                    searchflag = true;
                }
            }
        });

        searchByDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Department");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);
                    searchfield.requestFocus();

                    revalidateDepartment_Master();

                    departmentsearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dpm.moverec(searchfield.getText(), departmentsearchby, Departmentmodel);
                            if (Departmentmodel.isStatus()) {
                                moverecCodeforDepM = Departmentmodel.getCode();

                                department.setText(myLib.sNull(Departmentmodel.getTxtDepartment()));
                                departmentShortName.setText(myLib.sNull(Departmentmodel.getTxtDepartmentShortName()));
                                depCode.setText(myLib.sNull(Departmentmodel.getTxtDepCode()));

                                nature.setSelectedItem(myLib.sNull(Departmentmodel.getTxtNature()));
                                active.setSelectedItem(myLib.sNull(Departmentmodel.getTxtActive()));

                                String createdon = myLib.sNull(Departmentmodel.getCreatedOn());
                                String modifiedon = myLib.sNull(Departmentmodel.getModifiedOn());

                                entryPointDep.txtCreatedBy.setText(createdon);
                                entryPointDep.txtModifiedBy.setText(modifiedon);

                                entryPointDep.getFormPanel.remove(searchPanel);

                                revalidateDepartment_Master();

                                entryPointDep.control.editButton.setEnabled(true);
                                entryPointDep.control.deleteButton.setEnabled(true);
                                entryPointDep.control.printButton.setEnabled(true);
                                entryPointDep.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        });

        searchByCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Department Code");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield2 = myLib.createSpecialJTextField(20, false);
                    searchfield2.setBounds(30, 55, 130, 25);
                    searchfield2.setToolTipText("Dep........");
                    searchPanel.add(searchfield2);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);
                    searchfield2.requestFocus();

                    depMasterFrame.repaint();
                    depMasterFrame.revalidate();
                    departmentsearchby = 2;

                    // Add action listeners for search field here
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dpm.moverec(searchfield.getText(), departmentsearchby, Departmentmodel);
                            if (Departmentmodel.isStatus()) {
                                moverecCodeforDepM = Departmentmodel.getCode();

                                department.setText(myLib.sNull(Departmentmodel.getTxtDepartment()));
                                departmentShortName.setText(myLib.sNull(Departmentmodel.getTxtDepartmentShortName()));
                                depCode.setText(myLib.sNull(Departmentmodel.getTxtDepCode()));

                                nature.setSelectedItem(myLib.sNull(Departmentmodel.getTxtNature()));
                                active.setSelectedItem(myLib.sNull(Departmentmodel.getTxtActive()));

                                String createdon = myLib.sNull(Departmentmodel.getCreatedOn());
                                String modifiedon = myLib.sNull(Departmentmodel.getModifiedOn());

                                entryPointDep.txtCreatedBy.setText(createdon);
                                entryPointDep.txtModifiedBy.setText(modifiedon);

                                entryPointDep.getFormPanel.remove(searchPanel);

                                revalidateDepartment_Master();

                                entryPointDep.control.editButton.setEnabled(true);
                                entryPointDep.control.deleteButton.setEnabled(true);
                                entryPointDep.control.printButton.setEnabled(true);
                                entryPointDep.control.saveButton.setEnabled(true);

                            }
                        }
                    });
                }
            }
        });

        entryPointDep.control.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dpm.deleteRecord(moverecCodeforDepM);
                depMasterClear();
                entryPointDep.control.editButton.setEnabled(false);
                entryPointDep.control.deleteButton.setEnabled(false);
                entryPointDep.control.printButton.setEnabled(false);
                entryPointDep.control.saveButton.setEnabled(false);
                entryPointDep.control.addButton.setEnabled(true);
                entryPointDep.control.searchButton.setEnabled(true);
            }
        });

        entryPointDep.control.printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(depMasterFrame, "Available Soon..........!");
                dpm.prnRecord(moverecCodeforDepM);
                entryPointDep.control.editButton.setEnabled(false);
                entryPointDep.control.deleteButton.setEnabled(false);
                entryPointDep.control.printButton.setEnabled(false);
                entryPointDep.control.saveButton.setEnabled(false);
                entryPointDep.control.addButton.setEnabled(true);
                entryPointDep.control.searchButton.setEnabled(true);

            }
        });

        return desMasterFrame;
    }

    // helping functions for department master //
    public void revalidateDepartment_Master() {
        depMasterFrame.repaint();
        depMasterFrame.revalidate();
    }

    public void depMasterClear() {
        department.setText("");
        departmentShortName.setText("");
        active.setSelectedIndex(0);
        nature.setSelectedIndex(0);
        depCode.setText("");
        entryPointDep.txtCreatedBy.setText("");
        entryPointDep.txtModifiedBy.setText("");
    }

    private void setEditableFieldDepmaster() {
        department.setEditable(true);
        departmentShortName.setEditable(true);
        active.setEditable(true);
        nature.setEditable(true);
    }

    private void setUneditableFieldDepmaster() {
        department.setEditable(false);
        departmentShortName.setEditable(false);
        active.setEditable(false);
        nature.setEditable(false);
    }

    //<------------------------------**** PARTY MASTER STARTS ****-------------------------------->//
    public JFrame addPartyMasterFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        PartyMast pm = new PartyMast();
        String[] partyGstType = new String[]{"Registered", "Unregistered", "Composite"};
        String[] partyTDSCat = new String[]{"C&F", "Retailer", "Distributor", "Super Stockist"};
        String[] partyMSME = new String[]{"Micro", "Small", "Medium"};
        String[] partyNatureArray = new String[]{"Customer", "Supplier", "Party(Common)", "Transporter"};

        ArrayList<String> cityList = new ArrayList<String>();
        ArrayList<String> areaList = new ArrayList<String>();
        ArrayList<String> partyList = new ArrayList<String>();

        areaList.addAll(pm.getArea());
        cityList.addAll(pm.getCityList());
        partyList.addAll(pm.getPartyList());

        String[] areaArrayRecieved = areaList.toArray(new String[areaList.size()]);
        String[] cityArrayRecieved = cityList.toArray(new String[cityList.size()]);
        String[] partyArrayRecieved = partyList.toArray(new String[partyList.size()]);

        entryPointParty.setFormPanelHeightBounds(650);
        partyMasterFrame = entryPointParty.addFrame();

        JPanel formPanel = new JPanel(null);

        partyL = new JLabel("Party Name");
        partyL.setBounds(350, 60, 100, 25);
        party = myL.createSpecialJTextField(30, true);
        party.setEditable(false);
        party.setBounds(470, 60, 450, 25);

        lineParty = new JLabel("______________________________________________________________________________________________________________________________________________________________________________________________________________");
        lineParty.setBounds(0, 90, 2000, 20);

        partyCodeL = new JLabel("Party Code");
        partyCodeL.setBounds(25, 130, 100, 25);
        partyCode = myL.createSpecialJTextField(20, false);
        partyCode.setBounds(150, 130, 200, 25);
        partyCode.setEditable(false);

        partyLegalL = new JLabel("Legal Name");
        partyLegalL.setBounds(25, 160, 100, 25);
        partyLegal = myL.createSpecialJTextField(30, true);///////////////
        partyLegal.setBounds(150, 160, 515, 25);
        partyLegal.setEditable(false);

        partyDisplayNameL = new JLabel("Display Name");
        partyDisplayNameL.setBounds(25, 190, 100, 25);
        partyDisplay = myL.createSpecialJTextField(30, true);//////////
        partyDisplay.setBounds(150, 190, 515, 25);
        partyDisplay.setEditable(false);

        partyNatureL = new JLabel("Nature");
        partyNatureL.setBounds(25, 220, 100, 25);
        partyNature = myL.createSpecialJComboBox(partyNatureArray, true);
        partyNature.setBounds(150, 220, 515, 25);
        partyNature.setEditable(false);

        partyReferedToL = new JLabel("Referred to");
        partyReferedToL.setBounds(25, 250, 100, 25);
        partyReferredTo = myL.createSpecialJComboBox(partyArrayRecieved, false);
        partyReferredTo.setEditable(false);
        partyReferredTo.setBounds(150, 250, 515, 25);

        partyAddressL = new JLabel("Address");
        partyAddressL.setBounds(25, 280, 100, 25);
        partyAddress = myL.createSpecialJTextField(20, true);
        partyAddress.setBounds(150, 280, 515, 25);
        partyAddress.setEditable(false);

        partyCityL = new JLabel("City");
        partyCityL.setBounds(25, 310, 100, 25);
        partyCity = myL.createSpecialJComboBox(cityArrayRecieved, true);
        partyCity.setBounds(150, 310, 200, 25);
        partyCity.setEditable(false);

        partyCountryL = new JLabel("Country");
        partyCountryL.setBounds(25, 340, 100, 25);
        partyCountry = myL.createSpecialJTextField(30, false);
        partyCountry.setBounds(150, 340, 200, 25);
        partyCountry.setEditable(false);
        partyCountry.setText("India");

        partyPinL = new JLabel("Pincode");
        partyPinL.setBounds(25, 370, 100, 25);
        partyPin = myL.createNumericTextFieldWithLimit(20, 6, false);
        partyPin.setBounds(150, 370, 200, 25);
        partyPin.setEditable(false);

        partyPhoneL = new JLabel("Phone No.");
        partyPhoneL.setBounds(25, 400, 100, 25);
        partyPhoneNumber = myL.createNumericTextFieldWithLimit(20, 10, false);
        partyPhoneNumber.setBounds(150, 400, 200, 25);
        partyPhoneNumber.setEditable(false);

        partyMobileL = new JLabel("Mobile No.");
        partyMobileL.setBounds(25, 430, 100, 25);
        partyMobileNumber = myL.createNumericTextFieldWithLimit(20, 10, true);
        partyMobileNumber.setBounds(150, 430, 200, 25);
        partyMobileNumber.setEditable(false);

        partyAreaL = new JLabel("Party Area");
        partyAreaL.setBounds(690, 130, 100, 25);
        partyArea = myL.createSpecialJComboBox(areaArrayRecieved, true);
        partyArea.setBounds(800, 130, 515, 25);
        partyArea.setEditable(false);

        partyMSMETypeL = new JLabel("MSME Type");
        partyMSMETypeL.setBounds(690, 160, 100, 25);
        partyMSMEType = myL.createSpecialJComboBox(partyMSME, false);
        partyMSMEType.setBounds(800, 160, 185, 25);
        partyMSMEType.setEditable(false);

        partyActiveL = new JLabel("Active");
        partyActiveL.setBounds(1020, 160, 100, 25);
        partyActive = myL.createSpecialJComboBox(yesNo, true);
        partyActive.setBounds(1130, 160, 185, 25);
        partyActive.setEditable(false);

        partyGSTTypeL = new JLabel("GST Type");
        partyGSTTypeL.setBounds(690, 190, 100, 25);
        partyGSTType = myL.createSpecialJComboBox(partyGstType, true);
        partyGSTType.setBounds(800, 190, 515, 25);
        partyGSTType.setEditable(false);

        partyGSTINL = new JLabel("GSTIN");
        partyGSTINL.setBounds(690, 220, 150, 25);
        partyGSTIN = myL.createSpecialJTextField(15, true);
        partyGSTIN.setBounds(800, 220, 515, 25);
        partyGSTIN.setEditable(false);
        myKeyListnerForCharacterControl(partyGSTIN, 15);

        partyPANL = new JLabel("Party PAN");
        partyPANL.setBounds(690, 250, 100, 25);
        partyPAN = myL.createSpecialJTextField(10, true);
        partyPAN.setBounds(800, 250, 515, 25);
        partyPAN.setEditable(false);
        myKeyListnerForCharacterControl(partyPAN, 10);

        partyAdharL = new JLabel("Party Adhar");
        partyAdharL.setBounds(690, 280, 100, 25);
        partyAdhar = myL.createNumericTextFieldWithLimit(16, 16, false);
        partyAdhar.setBounds(800, 280, 515, 25);
        partyAdhar.setEditable(false);

        partyTcsActiveL = new JLabel("TCS Active");
        partyTcsActiveL.setBounds(690, 310, 100, 25);
        partyTCSActive = myL.createSpecialJComboBox(yesNo, true);
        partyTCSActive.setEditable(false);
        partyTCSActive.setBounds(800, 310, 515, 25);

        partyTcsCategoryL = new JLabel("TCS Category");
        partyTcsCategoryL.setBounds(690, 340, 100, 25);
        partyTCScategory = myL.createSpecialJComboBox(tcsCat, true);
        partyTCScategory.setBounds(800, 340, 200, 25);
        partyTCScategory.setEditable(false);

        partyTDSCategoryL = new JLabel("TDS Category");
        partyTDSCategoryL.setBounds(690, 370, 100, 25);
        partyTDScategory = myL.createSpecialJComboBox(partyTDSCat, true);
        partyTDScategory.setBounds(800, 370, 200, 25);
        partyTDScategory.setEditable(false);

        partyRemarkL = new JLabel("Remark");
        partyRemarkL.setBounds(690, 400, 100, 25);
        partyRemark = myL.createSpecialJTextField(10, false);
        partyRemark.setBounds(800, 400, 515, 25);
        partyRemark.setEditable(false);

        entryPointParty.setFormName("Party Master");
        entryPointParty.getFrame.setTitle("Party Master");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(2, 1));
        searchPanel.setBounds(900, 450, 190, 150);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JRadioButton searchByParty = new JRadioButton("Search by Party");
        JRadioButton searchByCode = new JRadioButton("Search by Code");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByParty);
        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        MyFocusListener manager = new MyFocusListener(party, partyLegal, partyDisplay, partyAddress, partyPin, partyPhoneNumber, partyMobileNumber, partyGSTIN,
                partyPAN, partyAdhar, partyRemark);

        BackgroundColorChanger colorChanger = new BackgroundColorChanger(lightblue, Color.WHITE);
        colorChanger.setFocusListeners(party, partyLegal, partyDisplay, partyAddress, partyPin, partyPhoneNumber, partyMobileNumber, partyGSTIN,
                partyPAN, partyAdhar, partyRemark);

        entryPointParty.getFormPanel.add(lineParty);
        entryPointParty.getFormPanel.add(party);
        entryPointParty.getFormPanel.add(partyL);
        entryPointParty.getFormPanel.add(partyLegalL);
        entryPointParty.getFormPanel.add(partyLegal);
        entryPointParty.getFormPanel.add(partyDisplayNameL);
        entryPointParty.getFormPanel.add(partyDisplay);
        entryPointParty.getFormPanel.add(partyCodeL);
        entryPointParty.getFormPanel.add(partyCode);
        entryPointParty.getFormPanel.add(partyNatureL);
        entryPointParty.getFormPanel.add(partyNature);
        entryPointParty.getFormPanel.add(partyTCSActive);
        entryPointParty.getFormPanel.add(partyTcsActiveL);
        entryPointParty.getFormPanel.add(partyTDSCategoryL);
        entryPointParty.getFormPanel.add(partyTDScategory);
        entryPointParty.getFormPanel.add(partyTCScategory);
        entryPointParty.getFormPanel.add(partyTcsCategoryL);
        entryPointParty.getFormPanel.add(partyReferedToL);
        entryPointParty.getFormPanel.add(partyReferredTo);
        entryPointParty.getFormPanel.add(partyMSMETypeL);
        entryPointParty.getFormPanel.add(partyMSMEType);
        entryPointParty.getFormPanel.add(partyGSTTypeL);
        entryPointParty.getFormPanel.add(partyGSTType);
        entryPointParty.getFormPanel.add(partyGSTINL);
        entryPointParty.getFormPanel.add(partyGSTIN);
        entryPointParty.getFormPanel.add(partyPAN);
        entryPointParty.getFormPanel.add(partyPANL);
        entryPointParty.getFormPanel.add(partyAdhar);
        entryPointParty.getFormPanel.add(partyAdharL);
        entryPointParty.getFormPanel.add(partyRemarkL);
        entryPointParty.getFormPanel.add(partyRemark);
        entryPointParty.getFormPanel.add(partyAddressL);
        entryPointParty.getFormPanel.add(partyAddress);
        entryPointParty.getFormPanel.add(partyCityL);
        entryPointParty.getFormPanel.add(partyCity);
        entryPointParty.getFormPanel.add(partyCountryL);
        entryPointParty.getFormPanel.add(partyCountry);
        entryPointParty.getFormPanel.add(partyPinL);
        entryPointParty.getFormPanel.add(partyPin);
        entryPointParty.getFormPanel.add(partyAreaL);
        entryPointParty.getFormPanel.add(partyArea);
        entryPointParty.getFormPanel.add(partyPhoneL);
        entryPointParty.getFormPanel.add(partyPhoneNumber);
        entryPointParty.getFormPanel.add(partyMobileNumber);
        entryPointParty.getFormPanel.add(partyMobileL);
        entryPointParty.getFormPanel.add(partyActiveL);
        entryPointParty.getFormPanel.add(partyActive);

        party.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                partyLegal.setText(party.getText());
                partyDisplay.setText(party.getText());
            }
        });

        partyCity.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String countryrec = pm.getCountry(partyCity.getSelectedItem().toString());
                partyCountry.setText(countryrec);
            }
        });

        entryPointParty.control.printButton.setEnabled(false);

        entryPointParty.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    partyMasterClear();
                    setEditableFieldPartyMaster();
                    party.requestFocus(true);
                    party.setBackground(lightblue);
                    entryPointParty.control.saveButton.setEnabled(true);
                    entryPointParty.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setEditableFieldPartyMaster();
                    entryPointParty.control.searchButton.setEnabled(true);
                    entryPointParty.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointParty.control.deleteButton.setEnabled(false);
        entryPointParty.control.editButton.setEnabled(false);
        entryPointParty.control.saveButton.setEnabled(false);

        entryPointParty.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = pm.chkVld(party, partyLegal, partyDisplay, partyAddress, partyMobileNumber, partyGSTIN, partyPAN, partyRemark);
                if (isValid) {
                    if (entryPointParty.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        pm.saveRecord(party,
                                partyLegal,
                                partyDisplay,
                                partyCode,
                                partyGSTIN,
                                partyPAN,
                                partyAdhar,
                                partyAddress,
                                partyCountry,
                                partyPin,
                                partyPhoneNumber,
                                partyMobileNumber,
                                partyRemark,
                                partyNature,
                                partyTCSActive,
                                partyTCScategory,
                                partyTDScategory,
                                partyReferredTo,
                                partyMSMEType,
                                partyGSTType,
                                partyCity, partyArea,
                                partyActive, moverecCodeforPartyMaster, addButtonFlag);
                        entryPointParty.control.addButton.setEnabled(true);
                        entryPointParty.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        partyMasterClear();
                        party.requestFocus(true);

                    } else {
                        addButtonFlag = true;
                        pm.saveRecord(party, partyLegal, partyDisplay, partyCode, partyGSTIN, partyPAN, partyAdhar, partyAddress, partyCountry, partyPin, partyPhoneNumber, partyMobileNumber,
                                partyRemark, partyNature, partyTCSActive, partyTCScategory, partyTDScategory, partyReferredTo, partyMSMEType, partyGSTType, partyCity, partyArea,
                                partyActive, moverecCodeforPartyMaster, addButtonFlag);
                        partyMasterClear();
                        party.requestFocus(true);

                    }
                }
            }

        });
        entryPointParty.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldItemMaster();
                entryPointItem.control.addButton.setEnabled(true);
                entryPointItem.control.deleteButton.setEnabled(false);
                entryPointItem.control.searchButton.setEnabled(false);

            }
        });

        partyRemark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = pm.chkVld(party, partyLegal, partyDisplay, partyAddress, partyMobileNumber, partyGSTIN, partyPAN, partyRemark);
                if (isValid) {
                    if (entryPointParty.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        pm.saveRecord(party,
                                partyLegal,
                                partyDisplay,
                                partyCode,
                                partyGSTIN,
                                partyPAN,
                                partyAdhar,
                                partyAddress,
                                partyCountry,
                                partyPin,
                                partyPhoneNumber,
                                partyMobileNumber,
                                partyRemark,
                                partyNature,
                                partyTCSActive,
                                partyTCScategory,
                                partyTDScategory,
                                partyReferredTo,
                                partyMSMEType,
                                partyGSTType,
                                partyCity, partyArea,
                                partyActive, moverecCodeforPartyMaster, addButtonFlag);
                        entryPointParty.control.addButton.setEnabled(true);
                        entryPointParty.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        partyMasterClear();
                        party.requestFocus(true);

                    } else {
                        addButtonFlag = true;
                        pm.saveRecord(party,
                                partyLegal,
                                partyDisplay,
                                partyCode,
                                partyGSTIN,
                                partyPAN,
                                partyAdhar,
                                partyAddress,
                                partyCountry,
                                partyPin,
                                partyPhoneNumber,
                                partyMobileNumber,
                                partyRemark,
                                partyNature,
                                partyTCSActive,
                                partyTCScategory,
                                partyTDScategory,
                                partyReferredTo,
                                partyMSMEType,
                                partyGSTType,
                                partyCity, partyArea,
                                partyActive, moverecCodeforPartyMaster, addButtonFlag);
                        partyMasterClear();
                        party.requestFocus(true);

                    }
                }
            }
        }
        );
        entryPointParty.control.searchButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByParty);
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    entryPointParty.getFormPanel.add(searchPanel);
                    entryPointParty.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidatePartyMaster();

                } else if (!searchflag) {
                    searchPanel.setVisible(false);
                    entryPointParty.control.addButton.setEnabled(true);
                    entryPointParty.control.deleteButton.setEnabled(false);
                    entryPointParty.control.editButton.setEnabled(false);
                    setUneditableFieldPartyMaster();

                    revalidatePartyMaster();

                    searchflag = true;
                }
            }
        }
        );

        searchByParty.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(5, 1));
                    JLabel searchL = new JLabel("Party");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    JLabel searchByNatureL = new JLabel("Nature");
                    searchByNatureL.setBounds(30, 90, 130, 25);
                    JComboBox searchByNature = new JComboBox(partyNatureArray);
                    searchByNature.setBounds(30, 125, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(searchByNatureL);
                    searchPanel.add(searchByNature);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    revalidatePartyMaster();

                    partySearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            pm.moverec(searchfield.getText(), searchByNature.getSelectedItem().toString(), partySearchby, partyMasterModel);///////////////
                            if (partyMasterModel.isStatus()) {//////////////////////

                                moverecCodeforPartyMaster = partyMasterModel.getCode();/////////////

                                party.setText(myLib.sNull(partyMasterModel.getParty()));
                                partyLegal.setText(myLib.sNull(partyMasterModel.getPartyLegal()));
                                partyDisplay.setText(myLib.sNull(partyMasterModel.getPartyDisplay()));
                                partyCode.setText(myLib.sNull(partyMasterModel.getPartyCode()));
                                partyGSTIN.setText(myLib.sNull(partyMasterModel.getPartyGSTIN()));
                                partyPAN.setText(myLib.sNull(partyMasterModel.getPartyPAN()));
                                partyAdhar.setText(myLib.sNull(partyMasterModel.getPartyAdhar()));
                                partyPhoneNumber.setText(myLib.sNull(partyMasterModel.getPartyPhoneNumber()));
                                partyMobileNumber.setText(myLib.sNull(partyMasterModel.getPartyMobileNumber()));
                                partyAddress.setText(myLib.sNull(partyMasterModel.getPartyAddress()));
                                partyCountry.setText(myLib.sNull(partyMasterModel.getPartyCountry()));
                                partyPin.setText(myLib.sNull(partyMasterModel.getPartyPin()));
                                partyRemark.setText(myLib.sNull(partyMasterModel.getPartyRemark()));

                                partyNature.setSelectedItem(myLib.sNull(partyMasterModel.getPartyNature()));
                                partyTCSActive.setSelectedItem(myLib.sNull(partyMasterModel.getPartyTCSActive()));
                                partyTCScategory.setSelectedItem(myLib.sNull(partyMasterModel.getPartyTCScategory()));
                                partyTDScategory.setSelectedItem(myLib.sNull(partyMasterModel.getPartyTDScategory()));
                                partyReferredTo.setSelectedItem(myLib.sNull(partyMasterModel.getPartyReferredTo()));
                                partyMSMEType.setSelectedItem(myLib.sNull(partyMasterModel.getPartyMSMEType()));
                                partyGSTType.setSelectedItem(myLib.sNull(partyMasterModel.getPartyGSTType()));
                                partyCity.setSelectedItem(myLib.sNull(partyMasterModel.getPartyCity()));
                                partyArea.setSelectedItem(myLib.sNull(partyMasterModel.getPartyArea()));
                                partyActive.setSelectedItem(myLib.sNull(partyMasterModel.getPartyActive()));

                                String createdon = myLib.sNull(partyMasterModel.getCreatedOn());
                                String modifiedon = myLib.sNull(partyMasterModel.getModifiedOn());

                                entryPointParty.txtCreatedBy.setText(createdon);
                                entryPointParty.txtModifiedBy.setText(modifiedon);

                                entryPointParty.getFormPanel.remove(searchPanel);

                                revalidatePartyMaster();

                                entryPointParty.control.editButton.setEnabled(true);
                                entryPointParty.control.deleteButton.setEnabled(true);
                                entryPointParty.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        }
        );
        searchByCode.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Party Code");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    revalidatePartyMaster();

                    partySearchby = 2;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            pm.moverec(searchfield.getText(), partyNature.getSelectedItem().toString(), partySearchby, partyMasterModel);///////////////
                            if (partyMasterModel.isStatus()) {//////////////////////
                                moverecCodeforPartyMaster = partyMasterModel.getCode();/////////////

                                party.setText(myLib.sNull(partyMasterModel.getParty()));
                                partyLegal.setText(myLib.sNull(partyMasterModel.getPartyLegal()));
                                partyDisplay.setText(myLib.sNull(partyMasterModel.getPartyDisplay()));
                                partyCode.setText(myLib.sNull(partyMasterModel.getPartyCode()));
                                partyGSTIN.setText(myLib.sNull(partyMasterModel.getPartyGSTIN()));
                                partyPAN.setText(myLib.sNull(partyMasterModel.getPartyPAN()));
                                partyAdhar.setText(myLib.sNull(partyMasterModel.getPartyAdhar()));
                                partyPhoneNumber.setText(myLib.sNull(partyMasterModel.getPartyPhoneNumber()));
                                partyMobileNumber.setText(myLib.sNull(partyMasterModel.getPartyMobileNumber()));
                                partyAddress.setText(myLib.sNull(partyMasterModel.getPartyAddress()));
                                partyCountry.setText(myLib.sNull(partyMasterModel.getPartyCountry()));
                                partyPin.setText(myLib.sNull(partyMasterModel.getPartyPin()));
                                partyRemark.setText(myLib.sNull(partyMasterModel.getPartyRemark()));

                                partyNature.setSelectedItem(myLib.sNull(partyMasterModel.getPartyNature()));
                                partyTCSActive.setSelectedItem(myLib.sNull(partyMasterModel.getPartyTCSActive()));
                                partyTCScategory.setSelectedItem(myLib.sNull(partyMasterModel.getPartyTCScategory()));
                                partyTDScategory.setSelectedItem(myLib.sNull(partyMasterModel.getPartyTDScategory()));
                                partyReferredTo.setSelectedItem(myLib.sNull(partyMasterModel.getPartyReferredTo()));
                                partyMSMEType.setSelectedItem(myLib.sNull(partyMasterModel.getPartyMSMEType()));
                                partyGSTType.setSelectedItem(myLib.sNull(partyMasterModel.getPartyGSTType()));
                                partyCity.setSelectedItem(myLib.sNull(partyMasterModel.getPartyCity()));
                                partyArea.setSelectedItem(myLib.sNull(partyMasterModel.getPartyArea()));
                                partyActive.setSelectedItem(myLib.sNull(partyMasterModel.getPartyActive()));

                                String createdon = myLib.sNull(partyMasterModel.getCreatedOn());
                                String modifiedon = myLib.sNull(partyMasterModel.getModifiedOn());

                                entryPointParty.txtCreatedBy.setText(createdon);
                                entryPointParty.txtModifiedBy.setText(modifiedon);

                                entryPointParty.getFormPanel.remove(searchPanel);

                                revalidatePartyMaster();

                                entryPointParty.control.editButton.setEnabled(true);
                                entryPointParty.control.deleteButton.setEnabled(true);
                                entryPointParty.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        }
        );

        entryPointParty.control.deleteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                pm.deleteRecord(moverecCodeforPartyMaster);
                entryPointParty.control.editButton.setEnabled(false);
                entryPointParty.control.deleteButton.setEnabled(false);
                entryPointParty.control.printButton.setEnabled(false);
                entryPointParty.control.saveButton.setEnabled(false);
                entryPointParty.control.addButton.setEnabled(true);
                entryPointParty.control.searchButton.setEnabled(true);
                partyMasterClear();

            }
        }
        );

        entryPointParty.control.printButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
//                am.prnRecord(moverecCodeforitemMaster);
            }
        }
        );

        return partyMasterFrame;
    }

// helping functions for Party master //
    public void revalidatePartyMaster() {
        partyMasterFrame.repaint();
        partyMasterFrame.revalidate();
    }

    public void partyMasterClear() {
        party.setText("");
        partyCode.setText("");
        partyLegal.setText("");
        partyDisplay.setText("");
        partyGSTIN.setText("");
        partyAdhar.setText("");
        partyPAN.setText("");
        partyAddress.setText("");
        partyPin.setText("");
        partyCountry.setText("India");
        partyMobileNumber.setText("");
        partyPhoneNumber.setText("");
        partyRemark.setText("");
        partyNature.setSelectedIndex(0);
        partyTCSActive.setSelectedIndex(0);
        partyTDScategory.setSelectedIndex(0);
        partyTCScategory.setSelectedIndex(0);
        partyReferredTo.setSelectedIndex(0);
        partyMSMEType.setSelectedIndex(0);
        partyGSTType.setSelectedIndex(0);
        partyCity.setSelectedIndex(0);
        partyArea.setSelectedIndex(0);
        partyActive.setSelectedIndex(0);

        entryPointParty.txtCreatedBy.setText("");
        entryPointParty.txtModifiedBy.setText("");
    }

    private void setEditableFieldPartyMaster() {
        party.setEditable(true);
        partyLegal.setEditable(true);
        partyDisplay.setEditable(true);
        partyGSTIN.setEditable(true);
        partyAdhar.setEditable(true);
        partyPAN.setEditable(true);
        partyAddress.setEditable(true);
        partyPin.setEditable(true);
        partyMobileNumber.setEditable(true);
        partyPhoneNumber.setEditable(true);
        partyRemark.setEditable(true);
        partyNature.setEditable(true);
        partyTCSActive.setEditable(true);
        partyTDScategory.setEditable(true);
        partyTCScategory.setEditable(true);
        partyReferredTo.setEditable(true);
        partyMSMEType.setEditable(true);
        partyGSTType.setEditable(true);
        partyCity.setEditable(true);
        partyArea.setEditable(true);
        partyActive.setEditable(true);
    }

    private void setUneditableFieldPartyMaster() {
        party.setEditable(false);
        partyLegal.setEditable(false);
        partyDisplay.setEditable(false);
        partyGSTIN.setEditable(false);
        partyAdhar.setEditable(false);
        partyPAN.setEditable(false);
        partyAddress.setEditable(false);
        partyPin.setEditable(false);
        partyMobileNumber.setEditable(false);
        partyPhoneNumber.setEditable(false);
        partyRemark.setEditable(false);
        partyNature.setEditable(false);
        partyTCSActive.setEditable(false);
        partyTDScategory.setEditable(false);
        partyTCScategory.setEditable(false);
        partyReferredTo.setEditable(false);
        partyMSMEType.setEditable(false);
        partyGSTType.setEditable(false);
        partyCity.setEditable(false);
        partyArea.setEditable(false);
        partyActive.setEditable(false);
    }

    //<------------------------------**** AREA MASTER STARTS ****-------------------------------->//
    public JFrame addAreaMasterFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        AreaMast am = new AreaMast();
        ArrayList<String> recievedList = new ArrayList<String>();

        recievedList.addAll(am.getParentArea());

        entryPointArea.setFormPanelHeightBounds(300);
        areaMasterFrame = entryPointArea.addFrame();

        JPanel formPanel = new JPanel(null);

        areaL = new JLabel("Area");
        areaL.setBounds(200, 100, 100, 25);

        area = myL.createSpecialJTextField(100, true);
        area.setBounds(400, 100, 700, 25);
        area.setEditable(false);

        parentAreaL = new JLabel("Parent Area");
        parentAreaL.setBounds(200, 130, 100, 25);

        String[] arrayRecieved = recievedList.toArray(new String[recievedList.size()]);

        parentArea = myL.createSpecialJComboBox(arrayRecieved, false);

        parentArea.setBounds(400, 130, 200, 25);
        parentArea.setEditable(false);

        entryPointArea.setFormName("Area Master");
        entryPointArea.getFrame.setTitle("Area Master");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(2, 1));
        searchPanel.setBounds(10, 35, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JRadioButton searchByArea = new JRadioButton("Search by Area");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByArea);

        searchPanel.setVisible(false);

        entryPointArea.getFormPanel.add(areaL);
        entryPointArea.getFormPanel.add(area);

        entryPointArea.getFormPanel.add(parentAreaL);
        entryPointArea.getFormPanel.add(parentArea);

        MyFocusListener manager = new MyFocusListener(area);
        BackgroundColorChanger colorChanger = new BackgroundColorChanger(lightblue, Color.WHITE);
        colorChanger.setFocusListeners(area);

        entryPointArea.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    areaMasterClear();
                    setEditableFieldAreamaster();
                    area.requestFocus(true);
                    entryPointArea.control.saveButton.setEnabled(true);
                    entryPointArea.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setEditableFieldAreamaster();
                    entryPointArea.control.searchButton.setEnabled(true);
                    entryPointArea.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointArea.control.deleteButton.setEnabled(false);
        entryPointArea.control.printButton.setEnabled(false);
        entryPointArea.control.editButton.setEnabled(false);
        entryPointArea.control.saveButton.setEnabled(false);

        entryPointArea.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = am.chkVld(area, parentArea);

                if (isValid) {
                    if (entryPointArea.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        am.saveRecord(area, parentArea, moverecCodeforAreaM, addButtonFlag);
                        entryPointArea.control.addButton.setEnabled(true);
                        entryPointArea.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        areaMasterClear();

                    } else {
                        addButtonFlag = true;
                        am.saveRecord(area, parentArea, moverecCodeforAreaM, addButtonFlag);
                        areaMasterClear();

                    }
                }
            }

        });
        entryPointArea.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldAreamaster();
                entryPointArea.control.addButton.setEnabled(true);
                entryPointArea.control.deleteButton.setEnabled(false);
                entryPointArea.control.printButton.setEnabled(false);
                entryPointArea.control.searchButton.setEnabled(false);

            }
        });

        area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = am.chkVld(area, parentArea);

                if (isValid) {
                    if (entryPointArea.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        am.saveRecord(area, parentArea, moverecCodeforAreaM, addButtonFlag);
                        entryPointArea.control.addButton.setEnabled(true);
                        entryPointArea.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        areaMasterClear();

                    } else {
                        addButtonFlag = true;
                        am.saveRecord(area, parentArea, moverecCodeforAreaM, addButtonFlag);
                        areaMasterClear();

                    }
                }
            }
        }
        );

        entryPointArea.control.searchButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByArea);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    entryPointArea.getFormPanel.add(searchPanel);
                    entryPointArea.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateArea_Master();

                } else if (!searchflag) {
                    searchPanel.setVisible(false);
                    entryPointArea.control.addButton.setEnabled(true);
                    entryPointArea.control.deleteButton.setEnabled(false);
                    entryPointArea.control.printButton.setEnabled(false);
                    entryPointArea.control.editButton.setEnabled(false);
                    setUneditableFieldAreamaster();

                    revalidateArea_Master();

                    searchflag = true;
                }
            }
        }
        );

        searchByArea.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Area");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    revalidateArea_Master();

                    areasearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            am.moverec(searchfield.getText(), areasearchby, AreaModel);
                            if (AreaModel.isStatus()) {
                                moverecCodeforAreaM = AreaModel.getCode();

                                area.setText(myLib.sNull(AreaModel.getTxtArea()));
                                parentArea.setSelectedItem(myLib.sNull(AreaModel.getTxtParentArea()));

                                String createdon = myLib.sNull(model.getCreatedOn());
                                String modifiedon = myLib.sNull(model.getModifiedOn());

                                entryPointArea.txtCreatedBy.setText(createdon);
                                entryPointArea.txtModifiedBy.setText(modifiedon);

                                entryPointArea.getFormPanel.remove(searchPanel);

                                revalidateArea_Master();

                                entryPointArea.control.editButton.setEnabled(true);
                                entryPointArea.control.deleteButton.setEnabled(true);
                                entryPointArea.control.printButton.setEnabled(true);
                                entryPointArea.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        }
        );

        entryPointArea.control.deleteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                am.deleteRecord(moverecCodeforAreaM);
                entryPointArea.control.editButton.setEnabled(false);
                entryPointArea.control.deleteButton.setEnabled(false);
                entryPointArea.control.printButton.setEnabled(false);
                entryPointArea.control.saveButton.setEnabled(false);
                entryPointArea.control.addButton.setEnabled(true);
                entryPointArea.control.searchButton.setEnabled(true);
                areaMasterClear();

            }
        }
        );

        entryPointArea.control.printButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                am.prnRecord(moverecCodeforAreaM);
            }
        }
        );

        return desMasterFrame;
    }

// helping functions for Area master //
    public void revalidateArea_Master() {
        areaMasterFrame.repaint();
        areaMasterFrame.revalidate();
    }

    public void areaMasterClear() {
        area.setText("");
        parentArea.setSelectedIndex(0);
        entryPointArea.txtCreatedBy.setText("");
        entryPointArea.txtModifiedBy.setText("");
    }

    private void setEditableFieldAreamaster() {
        area.setEditable(true);
        parentArea.setEditable(true);
    }

    private void setUneditableFieldAreamaster() {
        area.setEditable(false);
        parentArea.setEditable(false);
    }

    //<------------------------------**** ITEM MASTER STARTS ****-------------------------------->//
    public JFrame addItemMasterFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        ItemMast am = new ItemMast();
        ArrayList<String> recievedList = new ArrayList<String>();
        String[] test = new String[]{""};

        ArrayList<String> itemCatList = new ArrayList<String>();

        recievedList.addAll(am.getItemCatList());

        entryPointItem.setFormPanelHeightBounds(450);
        itemMasterFrame = entryPointItem.addFrame();

        JPanel formPanel = new JPanel(null);

        itemL = new JLabel("Item Name");
        itemL.setBounds(350, 60, 100, 25);
        item = myL.createSpecialJTextField(30, true);
        item.setEditable(false);
        item.setBounds(470, 60, 450, 25);

        line = new JLabel("______________________________________________________________________________________________________________________________________________________________________________________________________________");
        line.setBounds(0, 90, 2000, 20);

        itemCodeL = new JLabel("Item Code");
        itemCodeL.setBounds(25, 130, 100, 25);
        itemCode = myL.createSpecialJTextField(20, false);
        itemCode.setBounds(150, 130, 200, 25);
        itemCode.setEditable(false);

        String[] arrayRecieved = recievedList.toArray(new String[recievedList.size()]);
        itemCategorySelectL = new JLabel("Item Category");
        itemCategorySelectL.setBounds(25, 160, 100, 25);
        itemCategorySelect = myL.createSpecialJComboBox(arrayRecieved, true);///////////////
        itemCategorySelect.setBounds(150, 160, 515, 25);
        itemCategorySelect.setEditable(false);

        itemHSNL = new JLabel("HSN/SAC");
        itemHSNL.setBounds(25, 190, 100, 25);
        itemHSN = myL.createSpecialJComboBox(test, true);//////////
        itemHSN.setBounds(150, 190, 515, 25);
        itemHSN.setEditable(false);

        itemDescriptionL = new JLabel("Description");
        itemDescriptionL.setBounds(25, 220, 100, 25);

        itemDescription = new JTextArea();
        itemDescription.setLineWrap(true);
        itemDescription.setWrapStyleWord(true);
        itemDescription.setEditable(false);

        scrollPaneitemDescription = new JScrollPane(itemDescription);
        scrollPaneitemDescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneitemDescription.setBounds(150, 220, 515, 25);

        itemPropertyL = new JLabel("Properties");
        itemPropertyL.setBounds(25, 250, 100, 25);

        itemProperty = new JTextArea();
        itemProperty.setLineWrap(true);
        itemProperty.setWrapStyleWord(true);
        itemProperty.setEditable(false);

        scrollPaneitemProperty = new JScrollPane(itemProperty);
        scrollPaneitemProperty.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneitemProperty.setBounds(150, 250, 515, 25);

        indentReqL = new JLabel("Indent Required");
        indentReqL.setBounds(25, 280, 100, 25);
        indentReq = myL.createSpecialJComboBox(yesNo, true);
        indentReq.setBounds(150, 280, 200, 25);
        indentReq.setEditable(false);

        pOReqL = new JLabel("PO Required");
        pOReqL.setBounds(25, 310, 100, 25);
        pOReq = myL.createSpecialJComboBox(yesNo, true);
        pOReq.setBounds(150, 310, 200, 25);
        pOReq.setEditable(false);

        itemSaleReturnableTypeL = new JLabel("Sale Item Returnable");
        itemSaleReturnableTypeL.setBounds(25, 340, 150, 25);

        itemSaleReturnableType = myL.createSpecialJComboBox(yesNo, false);
        itemSaleReturnableType.setBounds(200, 340, 150, 25);
        itemSaleReturnableType.setEditable(false);

        gSTNatureL = new JLabel("GST Nature");
        gSTNatureL.setBounds(690, 130, 100, 25);
        gSTNature = myL.createSpecialJComboBox(gstnature, true);
        gSTNature.setBounds(800, 130, 515, 25);
        gSTNature.setEditable(false);

        itemGSTBasedOnL = new JLabel("GST Based On");
        itemGSTBasedOnL.setBounds(690, 160, 100, 25);
        itemGSTBasedOn = myL.createSpecialJComboBox(gstbasedOn, true);
        itemGSTBasedOn.setBounds(800, 160, 515, 25);
        itemGSTBasedOn.setEditable(false);

        itemGSTTypeL = new JLabel("GST Type");
        itemGSTTypeL.setBounds(690, 190, 100, 25);
        itemGSTType = myL.createSpecialJComboBox(gstType, true);
        itemGSTType.setBounds(800, 190, 515, 25);
        itemGSTType.setEditable(false);

        itemSKUL = new JLabel("Store Keeping Unit");
        itemSKUL.setBounds(690, 220, 150, 25);
        itemSKU = myL.createSpecialJComboBox(unitData, true);
        itemSKU.setBounds(810, 220, 505, 25);
        itemSKU.setEditable(false);

        purchaseUnitL = new JLabel("Purchase Unit");
        purchaseUnitL.setBounds(690, 250, 100, 25);
        purchaseUnit = myL.createSpecialJComboBox(unitData, true);
        purchaseUnit.setBounds(800, 250, 515, 25);
        purchaseUnit.setEditable(false);

        salesUnitL = new JLabel("Sales Unit");
        salesUnitL.setBounds(690, 280, 100, 25);
        salesUnit = myL.createSpecialJComboBox(unitData, true);
        salesUnit.setBounds(800, 280, 515, 25);
        salesUnit.setEditable(false);

        itemActiveL = new JLabel("Item Active");
        itemActiveL.setBounds(690, 310, 100, 25);
        itemActive = myL.createSpecialJComboBox(yesNo, true);
        itemActive.setEditable(false);
        itemActive.setBounds(800, 310, 515, 25);

        itemRemarkL = new JLabel("Item Remark");
        itemRemarkL.setBounds(690, 340, 100, 25);
        itemRemark = myL.createSpecialJTextField(20, false);
        itemRemark.setBounds(800, 340, 200, 25);
        itemRemark.setEditable(false);

        entryPointItem.setFormName("Item Master");
        entryPointItem.getFrame.setTitle("Item Master");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(2, 1));
        searchPanel.setBounds(10, 35, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JRadioButton searchByItem = new JRadioButton("Search by Item");
        JRadioButton searchByCode = new JRadioButton("Search by Code");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByItem);
        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        entryPointItem.getFormPanel.add(itemL);
        entryPointItem.getFormPanel.add(item);
        entryPointItem.getFormPanel.add(line);
        entryPointItem.getFormPanel.add(itemCode);
        entryPointItem.getFormPanel.add(itemCodeL);
        entryPointItem.getFormPanel.add(itemCategorySelectL);
        entryPointItem.getFormPanel.add(itemCategorySelect);
        entryPointItem.getFormPanel.add(itemHSNL);
        entryPointItem.getFormPanel.add(itemHSN);
        entryPointItem.getFormPanel.add(itemDescriptionL);
        entryPointItem.getFormPanel.add(scrollPaneitemDescription);
        entryPointItem.getFormPanel.add(itemPropertyL);
        entryPointItem.getFormPanel.add(scrollPaneitemProperty);
        entryPointItem.getFormPanel.add(indentReqL);
        entryPointItem.getFormPanel.add(indentReq);
        entryPointItem.getFormPanel.add(pOReq);
        entryPointItem.getFormPanel.add(pOReqL);
        entryPointItem.getFormPanel.add(itemSaleReturnableType);
        entryPointItem.getFormPanel.add(itemSaleReturnableTypeL);
        entryPointItem.getFormPanel.add(gSTNature);
        entryPointItem.getFormPanel.add(gSTNatureL);
        entryPointItem.getFormPanel.add(itemGSTBasedOn);
        entryPointItem.getFormPanel.add(itemGSTBasedOnL);
        entryPointItem.getFormPanel.add(itemGSTType);
        entryPointItem.getFormPanel.add(itemGSTTypeL);
        entryPointItem.getFormPanel.add(itemSKUL);
        entryPointItem.getFormPanel.add(itemSKU);
        entryPointItem.getFormPanel.add(purchaseUnit);
        entryPointItem.getFormPanel.add(purchaseUnitL);
        entryPointItem.getFormPanel.add(salesUnitL);
        entryPointItem.getFormPanel.add(salesUnit);
        entryPointItem.getFormPanel.add(itemActive);
        entryPointItem.getFormPanel.add(itemActiveL);
        entryPointItem.getFormPanel.add(itemRemark);
        entryPointItem.getFormPanel.add(itemRemarkL);

        entryPointItem.control.printButton.setEnabled(false);

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemDescription.requestFocus(true);
                item.setBackground(Color.WHITE);
                itemDescription.setBackground(lightblue);
            }
        });
        itemDescription.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    itemProperty.requestFocus();
                    itemDescription.setBackground(Color.WHITE);
                    itemProperty.setBackground(lightblue);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        itemProperty.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    itemRemark.requestFocus();
                    itemProperty.setBackground(Color.WHITE);
                    itemRemark.setBackground(lightblue);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        itemDescription.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                itemDescription.setBackground(lightblue);
            }

            @Override
            public void focusLost(FocusEvent e) {
                itemDescription.setBackground(Color.WHITE);
            }
        });
        itemProperty.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                itemProperty.setBackground(lightblue);
            }

            @Override
            public void focusLost(FocusEvent e) {
                itemProperty.setBackground(Color.WHITE);
            }
        });
        item.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                item.setBackground(lightblue);
            }

            @Override
            public void focusLost(FocusEvent e) {
                item.setBackground(Color.WHITE);
            }
        });
        itemRemark.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                itemRemark.setBackground(lightblue);
            }

            @Override
            public void focusLost(FocusEvent e) {
                itemRemark.setBackground(Color.WHITE);
            }
        });

        entryPointItem.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    itemMasterClear();
                    setEditableFieldItemMaster();
                    item.requestFocus(true);
                    item.setBackground(lightblue);
                    entryPointItem.control.saveButton.setEnabled(true);
                    entryPointItem.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setEditableFieldItemMaster();
                    entryPointItem.control.searchButton.setEnabled(true);
                    entryPointItem.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointItem.control.deleteButton.setEnabled(false);
        entryPointItem.control.editButton.setEnabled(false);
        entryPointItem.control.saveButton.setEnabled(false);

        entryPointItem.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = am.chkVld(item, itemRemark, itemProperty, itemDescription);

                if (isValid) {
                    if (entryPointItem.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        am.saveRecord(item, itemDescription, itemProperty, itemCategorySelect, itemHSN, indentReq, pOReq, itemSaleReturnableType,
                                gSTNature, itemGSTBasedOn, itemGSTType, itemSKU, purchaseUnit, salesUnit, itemActive, itemRemark, moverecCodeforitemMaster, addButtonFlag);
                        entryPointItem.control.addButton.setEnabled(true);
                        entryPointItem.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        itemMasterClear();
                        item.requestFocus(true);
                        item.setBackground(lightblue);
                        itemRemark.setBackground(Color.WHITE);

                    } else {
                        addButtonFlag = true;
                        am.saveRecord(item, itemDescription, itemProperty, itemCategorySelect, itemHSN, indentReq, pOReq, itemSaleReturnableType,
                                gSTNature, itemGSTBasedOn, itemGSTType, itemSKU, purchaseUnit, salesUnit, itemActive, itemRemark, moverecCodeforitemMaster, addButtonFlag);
                        itemMasterClear();
                        item.requestFocus(true);
                        item.setBackground(lightblue);
                        itemRemark.setBackground(Color.WHITE);

                    }
                }
            }

        });
        entryPointItem.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldItemMaster();
                entryPointItem.control.addButton.setEnabled(true);
                entryPointItem.control.deleteButton.setEnabled(false);
                entryPointItem.control.searchButton.setEnabled(false);

            }
        });

        itemRemark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = am.chkVld(item, itemRemark, itemProperty, itemDescription);

                if (isValid) {
                    if (entryPointItem.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        am.saveRecord(item, itemDescription, itemProperty, itemCategorySelect, itemHSN, indentReq, pOReq, itemSaleReturnableType,
                                gSTNature, itemGSTBasedOn, itemGSTType, itemSKU, purchaseUnit, salesUnit, itemActive, itemRemark, moverecCodeforitemMaster, addButtonFlag);
                        entryPointItem.control.addButton.setEnabled(true);
                        entryPointItem.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        itemMasterClear();

                    } else {
                        addButtonFlag = true;
                        am.saveRecord(item, itemDescription, itemProperty, itemCategorySelect, itemHSN, indentReq, pOReq, itemSaleReturnableType,
                                gSTNature, itemGSTBasedOn, itemGSTType, itemSKU, purchaseUnit, salesUnit, itemActive, itemRemark, moverecCodeforitemMaster, addButtonFlag);
                        itemMasterClear();

                    }
                }
            }
        }
        );
        entryPointItem.control.searchButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByItem);
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    entryPointItem.getFormPanel.add(searchPanel);
                    entryPointItem.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateItemMaster();

                } else if (!searchflag) {
                    searchPanel.setVisible(false);
                    entryPointItem.control.addButton.setEnabled(true);
                    entryPointItem.control.deleteButton.setEnabled(false);
                    entryPointItem.control.editButton.setEnabled(false);
                    setUneditableFieldItemMaster();

                    revalidateItemMaster();

                    searchflag = true;
                }
            }
        }
        );

        searchByItem.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Item");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    revalidateItemMaster();

                    itemSearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            am.moverec(searchfield.getText(), itemSearchby, itemMasterModel);///////////////
                            if (itemMasterModel.isStatus()) {//////////////////////

                                moverecCodeforitemMaster = itemMasterModel.getCode();/////////////

                                item.setText(myLib.sNull(itemMasterModel.getTxtItem()));
                                itemCode.setText(myLib.sNull(itemMasterModel.getTxtItemCode()));
                                itemDescription.setText(myLib.sNull(itemMasterModel.getTxtDescription()));
                                itemProperty.setText(myLib.sNull(itemMasterModel.getTxtProperties()));
                                itemRemark.setText(myLib.sNull(itemMasterModel.getTxtRemark()));
                                itemCategorySelect.setSelectedItem(myLib.sNull(itemMasterModel.getTxtCategory()));
                                itemHSN.setSelectedItem(myLib.sNull(itemMasterModel.getTxtHSN_SAC()));
                                indentReq.setSelectedItem(myLib.sNull(itemMasterModel.getTxtIndentReq()));
                                pOReq.setSelectedItem(myLib.sNull(itemMasterModel.getTxtPOReq()));
                                itemSaleReturnableType.setSelectedItem(myLib.sNull(itemMasterModel.getTxtReturnable()));
                                gSTNature.setSelectedItem(myLib.sNull(itemMasterModel.getTxtGSTNature()));
                                itemGSTBasedOn.setSelectedItem(myLib.sNull(itemMasterModel.getTxtGSTbasedOn()));
                                itemGSTType.setSelectedItem(myLib.sNull(itemMasterModel.getTxtGSTType()));
                                itemSKU.setSelectedItem(myLib.sNull(itemMasterModel.getTxtSKU()));
                                purchaseUnit.setSelectedItem(myLib.sNull(itemMasterModel.getTxtpurchaseUnit()));
                                salesUnit.setSelectedItem(myLib.sNull(itemMasterModel.getTxtSalesUnit()));
                                itemActive.setSelectedItem(myLib.sNull(itemMasterModel.getTxtActive()));

                                String createdon = myLib.sNull(itemMasterModel.getCreatedOn());
                                String modifiedon = myLib.sNull(itemMasterModel.getModifiedOn());

                                entryPointItem.txtCreatedBy.setText(createdon);
                                entryPointItem.txtModifiedBy.setText(modifiedon);

                                entryPointItem.getFormPanel.remove(searchPanel);

                                revalidateItemMaster();

                                entryPointItem.control.editButton.setEnabled(true);
                                entryPointItem.control.deleteButton.setEnabled(true);
                                entryPointItem.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        }
        );
        searchByCode.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Item Code");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    revalidateItemMaster();

                    itemSearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            am.moverec(searchfield.getText(), itemSearchby, itemMasterModel);///////////////
                            if (itemMasterModel.isStatus()) {//////////////////////
                                moverecCodeforitemMaster = itemMasterModel.getCode();/////////////

                                item.setText(myLib.sNull(itemMasterModel.getTxtItem()));
                                itemCode.setText(myLib.sNull(itemMasterModel.getTxtItemCode()));
                                itemDescription.setText(myLib.sNull(itemMasterModel.getTxtDescription()));
                                itemProperty.setText(myLib.sNull(itemMasterModel.getTxtProperties()));
                                itemRemark.setText(myLib.sNull(itemMasterModel.getTxtRemark()));
                                itemCategorySelect.setSelectedItem(myLib.sNull(itemMasterModel.getTxtCategory()));
                                itemHSN.setSelectedItem(myLib.sNull(itemMasterModel.getTxtHSN_SAC()));
                                indentReq.setSelectedItem(myLib.sNull(itemMasterModel.getTxtIndentReq()));
                                pOReq.setSelectedItem(myLib.sNull(itemMasterModel.getTxtPOReq()));
                                itemSaleReturnableType.setSelectedItem(myLib.sNull(itemMasterModel.getTxtReturnable()));
                                gSTNature.setSelectedItem(myLib.sNull(itemMasterModel.getTxtGSTNature()));
                                itemGSTBasedOn.setSelectedItem(myLib.sNull(itemMasterModel.getTxtGSTbasedOn()));
                                itemGSTType.setSelectedItem(myLib.sNull(itemMasterModel.getTxtGSTType()));
                                itemSKU.setSelectedItem(myLib.sNull(itemMasterModel.getTxtSKU()));
                                purchaseUnit.setSelectedItem(myLib.sNull(itemMasterModel.getTxtpurchaseUnit()));
                                salesUnit.setSelectedItem(myLib.sNull(itemMasterModel.getTxtSalesUnit()));
                                itemActive.setSelectedItem(myLib.sNull(itemMasterModel.getTxtActive()));

                                String createdon = myLib.sNull(itemMasterModel.getCreatedOn());
                                String modifiedon = myLib.sNull(itemMasterModel.getModifiedOn());

                                entryPointItem.txtCreatedBy.setText(createdon);
                                entryPointItem.txtModifiedBy.setText(modifiedon);

                                entryPointItem.getFormPanel.remove(searchPanel);

                                revalidateItemMaster();

                                entryPointItem.control.editButton.setEnabled(true);
                                entryPointItem.control.deleteButton.setEnabled(true);
                                entryPointItem.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        }
        );

        entryPointItem.control.deleteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                am.deleteRecord(moverecCodeforitemMaster);
                entryPointItem.control.editButton.setEnabled(false);
                entryPointItem.control.deleteButton.setEnabled(false);
                entryPointItem.control.printButton.setEnabled(false);
                entryPointItem.control.saveButton.setEnabled(false);
                entryPointItem.control.addButton.setEnabled(true);
                entryPointItem.control.searchButton.setEnabled(true);
                itemMasterClear();

            }
        }
        );

        entryPointItem.control.printButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
//                am.prnRecord(moverecCodeforitemMaster);
            }
        }
        );

        return itemMasterFrame;
    }

// helping functions for Item master //
    public void revalidateItemMaster() {
        itemMasterFrame.repaint();
        itemMasterFrame.revalidate();
    }

    public void itemMasterClear() {
        item.setText("");
        itemRemark.setText("");
        itemCode.setText("");
        itemDescription.setText("");
        itemProperty.setText("");
        itemCategorySelect.setSelectedIndex(0);
        itemHSN.setSelectedIndex(0);
        itemSKU.setSelectedIndex(0);
        itemActive.setSelectedIndex(0);
        purchaseUnit.setSelectedIndex(0);
        salesUnit.setSelectedIndex(0);
        itemGSTType.setSelectedIndex(0);
        itemGSTBasedOn.setSelectedIndex(0);
        gSTNature.setSelectedIndex(0);
        itemSaleReturnableType.setSelectedIndex(0);
        indentReq.setSelectedIndex(0);
        pOReq.setSelectedIndex(0);
        entryPointItem.txtCreatedBy.setText("");
        entryPointItem.txtModifiedBy.setText("");
    }

    private void setEditableFieldItemMaster() {
        item.setEditable(true);
        itemRemark.setEditable(true);
        itemDescription.setEditable(true);
        itemProperty.setEditable(true);
        itemCategorySelect.setEditable(true);
        itemHSN.setEditable(true);
        itemSKU.setEditable(true);
        itemActive.setEditable(true);
        itemRemark.setEditable(true);
        purchaseUnit.setEditable(true);
        salesUnit.setEditable(true);
        itemSaleReturnableType.setEditable(true);
        itemGSTBasedOn.setEditable(true);
        itemGSTType.setEditable(true);
        gSTNature.setEditable(true);
        indentReq.setEditable(true);
        pOReq.setEditable(true);
    }

    private void setUneditableFieldItemMaster() {
        item.setEditable(false);
        itemRemark.setEditable(false);
        itemDescription.setEditable(false);
        itemProperty.setEditable(false);
        itemCategorySelect.setEditable(false);
        itemHSN.setEditable(false);
        itemSKU.setEditable(false);
        itemActive.setEditable(false);
        itemRemark.setEditable(false);
        purchaseUnit.setEditable(false);
        salesUnit.setEditable(false);
        itemSaleReturnableType.setEditable(false);
        itemGSTBasedOn.setEditable(false);
        itemGSTType.setEditable(false);
        gSTNature.setEditable(false);
        indentReq.setEditable(false);
        pOReq.setEditable(false);
    }

    //<------------------------------**** ITEM CATEGORY MASTER STARTS ****-------------------------------->//
    public JFrame addICategoryMasterFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        ItemCategory ic = new ItemCategory();

        entryPointICategory.setFormPanelHeightBounds(300);
        iCategoryMasterFrame = entryPointICategory.addFrame();

        JPanel formPanel = new JPanel(null);

        itemCategoryL = new JLabel("Item Category");
        itemCategoryL.setBounds(200, 100, 100, 25);

        itemCategory = myL.createSpecialJTextField(100, true);
        itemCategory.setBounds(400, 100, 700, 25);
        itemCategory.setEditable(false);

        itemCategoryShortNameL = new JLabel("Short Name");
        itemCategoryShortNameL.setBounds(200, 130, 100, 25);

        itemCategoryShortName = myL.createSpecialJTextField(20, true);
        itemCategoryShortName.setBounds(400, 130, 700, 25);
        itemCategoryShortName.setEditable(false);

        entryPointICategory.setFormName("Item Category Master");
        entryPointICategory.getFrame.setTitle("Item Category Master");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(2, 1));
        searchPanel.setBounds(10, 35, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JRadioButton searchByCategory = new JRadioButton("Search by Item Category");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByCategory);

        searchPanel.setVisible(false);

        entryPointICategory.getFormPanel.add(itemCategoryL);
        entryPointICategory.getFormPanel.add(itemCategory);

        entryPointICategory.getFormPanel.add(itemCategoryShortName);
        entryPointICategory.getFormPanel.add(itemCategoryShortNameL);

        MyFocusListener manager = new MyFocusListener(itemCategory, itemCategoryShortName);
        BackgroundColorChanger colorChanger = new BackgroundColorChanger(lightblue, Color.WHITE);
        colorChanger.setFocusListeners(itemCategory, itemCategoryShortName);

        entryPointICategory.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    iCategoryMasterClear();
                    setEditableFieldICategorymaster();
                    itemCategory.requestFocus(true);
                    entryPointICategory.control.saveButton.setEnabled(true);
                    entryPointICategory.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setEditableFieldICategorymaster();
                    entryPointICategory.control.searchButton.setEnabled(true);
                    entryPointICategory.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointICategory.control.deleteButton.setEnabled(false);
        entryPointICategory.control.printButton.setEnabled(false);
        entryPointICategory.control.editButton.setEnabled(false);
        entryPointICategory.control.saveButton.setEnabled(false);

        entryPointICategory.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = ic.chkVld(itemCategory, itemCategoryShortName);

                if (isValid) {
                    if (entryPointICategory.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        ic.saveRecord(itemCategory, itemCategoryShortName, moverecCodeforiCategory, addButtonFlag);
                        entryPointICategory.control.addButton.setEnabled(true);
                        entryPointICategory.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        if (!duplicate) {
                            iCategoryMasterClear();
                        }
                    } else {
                        addButtonFlag = true;
                        ic.saveRecord(itemCategory, itemCategoryShortName, moverecCodeforiCategory, addButtonFlag);
                        if (!duplicate) {
                            iCategoryMasterClear();
                        }
                    }
                }
            }

        });
        entryPointICategory.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldICategorymaster();
                entryPointICategory.control.addButton.setEnabled(true);
                entryPointICategory.control.deleteButton.setEnabled(false);
                entryPointICategory.control.printButton.setEnabled(false);
                entryPointICategory.control.searchButton.setEnabled(false);

            }
        });

        itemCategoryShortName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = ic.chkVld(itemCategory, itemCategoryShortName);

                if (isValid) {
                    if (entryPointICategory.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        ic.saveRecord(itemCategory, itemCategoryShortName, moverecCodeforiCategory, addButtonFlag);
                        entryPointICategory.control.addButton.setEnabled(true);
                        entryPointICategory.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        iCategoryMasterClear();
                    } else {
                        addButtonFlag = true;
                        ic.saveRecord(itemCategory, itemCategoryShortName, moverecCodeforiCategory, addButtonFlag);
                        iCategoryMasterClear();

                    }
                }
            }
        }
        );

        entryPointICategory.control.searchButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByCategory);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    entryPointICategory.getFormPanel.add(searchPanel);
                    entryPointICategory.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateICategory_Master();

                } else if (!searchflag) {
                    searchPanel.setVisible(false);
                    entryPointICategory.control.addButton.setEnabled(true);
                    entryPointICategory.control.deleteButton.setEnabled(false);
                    entryPointICategory.control.printButton.setEnabled(false);
                    entryPointICategory.control.editButton.setEnabled(false);
                    setUneditableFieldICategorymaster();

                    revalidateICategory_Master();

                    searchflag = true;
                }
            }
        }
        );

        searchByCategory.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Item Category");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    revalidateICategory_Master();

                    icategorySearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ic.moverec(searchfield.getText(), icategorySearchby, iCategoryModel);
                            if (iCategoryModel.isStatus()) {
                                moverecCodeforiCategory = iCategoryModel.getCode();

                                itemCategory.setText(myLib.sNull(iCategoryModel.getTxtItemCategory()));
                                itemCategoryShortName.setText(myLib.sNull(iCategoryModel.getTxtItemCategoryShortName()));

                                String createdon = myLib.sNull(model.getCreatedOn());
                                String modifiedon = myLib.sNull(model.getModifiedOn());

                                entryPointICategory.txtCreatedBy.setText(createdon);
                                entryPointICategory.txtModifiedBy.setText(modifiedon);

                                entryPointICategory.getFormPanel.remove(searchPanel);

                                revalidateICategory_Master();

                                entryPointICategory.control.editButton.setEnabled(true);
                                entryPointICategory.control.deleteButton.setEnabled(true);
                                entryPointICategory.control.printButton.setEnabled(true);
                                entryPointICategory.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        }
        );

        entryPointICategory.control.deleteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ic.deleteRecord(moverecCodeforiCategory);
                entryPointICategory.control.editButton.setEnabled(false);
                entryPointICategory.control.deleteButton.setEnabled(false);
                entryPointICategory.control.printButton.setEnabled(false);
                entryPointICategory.control.saveButton.setEnabled(false);
                entryPointICategory.control.addButton.setEnabled(true);
                entryPointICategory.control.searchButton.setEnabled(true);
                iCategoryMasterClear();

            }
        }
        );

        entryPointICategory.control.printButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ic.prnRecord(moverecCodeforiCategory);
            }
        }
        );

        return iCategoryMasterFrame;
    }

// helping functions for item category master //
    public void revalidateICategory_Master() {
        iCategoryMasterFrame.repaint();
        iCategoryMasterFrame.revalidate();
    }

    public void iCategoryMasterClear() {
        itemCategory.setText("");
        itemCategoryShortName.setText("");
        entryPointICategory.txtCreatedBy.setText("");
        entryPointICategory.txtModifiedBy.setText("");
    }

    private void setEditableFieldICategorymaster() {
        itemCategory.setEditable(true);
        itemCategoryShortName.setEditable(true);
    }

    private void setUneditableFieldICategorymaster() {
        itemCategory.setEditable(false);
        itemCategoryShortName.setEditable(false);
    }

    ////<<<<------------------====================STORE STARTS====================------------------>>>>////
    //<------------------------------**** REQUISITION STARTS ****-------------------------------->//
    public JFrame addRequisitionFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        Requisition ic = new Requisition();
        String[] reqTypeArray = new String[]{"Requisition", "Service Req."};

        ArrayList<String> designationList = new ArrayList<String>();
        ArrayList<String> departmentList = new ArrayList<String>();
        ArrayList<String> employeeList = new ArrayList<String>();

        employeeList.addAll(ic.getCityList());
        departmentList.addAll(ic.getDepartmentList());

        String[] employeeRecieved = employeeList.toArray(new String[employeeList.size()]);
        String[] departmentRecieved = departmentList.toArray(new String[departmentList.size()]);

        entryPointReq.setFormPanelHeightBounds(750);
        reqFrame = entryPointReq.addFrame();

        JPanel formPanel = new JPanel(null);

        requisitionTypeL = new JLabel("Requisition Type");
        requisitionTypeL.setBounds(25, 45, 100, 25);

        requisitionType = myL.createSpecialJComboBox(reqTypeArray, true);
        requisitionType.setBounds(150, 45, 515, 25);
        requisitionType.setEditable(false);

        requisitionNoL = new JLabel("Requisition No.");
        requisitionNoL.setBounds(25, 75, 100, 25);

        requisitionNo = myL.createSpecialJTextField(20, true);
        requisitionNo.setBounds(150, 75, 170, 25);
        requisitionNo.setEditable(false);

        requisitionDateL = new JLabel("Date");
        requisitionDateL.setBounds(350, 75, 94, 25);

        requisitionDate = myL.createSpecialJTextField(20, true);
        requisitionDate.setBounds(430, 75, 235, 25);
        requisitionDate.setEditable(false);
        requisitionDate.setText(formattedDate1);

        requisitionByL = new JLabel("Requisition By");
        requisitionByL.setBounds(25, 105, 100, 25);

        requisitionBy = myL.createSpecialJComboBox(employeeRecieved, true);
        requisitionBy.setBounds(150, 105, 515, 25);
        requisitionBy.setEditable(false);

        departmentByL = new JLabel("Department By");
        departmentByL.setBounds(690, 45, 100, 25);

        departmentBy = myL.createSpecialJComboBox(departmentRecieved, true);
        departmentBy.setBounds(800, 45, 515, 25);
        departmentBy.setEditable(false);

        departmentToL = new JLabel("Department To");
        departmentToL.setBounds(690, 75, 100, 25);

        departmentTo = myL.createSpecialJComboBox(departmentRecieved, true);
        departmentTo.setBounds(800, 75, 515, 25);
        departmentTo.setEditable(false);

        requsitionRemarkL = new JLabel("Remark");
        requsitionRemarkL.setBounds(690, 105, 100, 25);

        requisitionRemark = myL.createSpecialJTextField(20, false);
        requisitionRemark.setBounds(800, 105, 515, 25);
        requisitionRemark.setEditable(false);

        entryPointReq.setFormName("Requisition");
        entryPointReq.getFrame.setTitle("Requisition");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(3, 1));
        searchPanel.setBounds(500, 500, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JDialog popupDialog = new JDialog();
        popupDialog.setBounds(500, 500, 200, 200);
        popupDialog.add(searchPanel);

        JRadioButton searchByCode = new JRadioButton("Search by Code");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        entryPointReq.getFormPanel.add(requisitionBy);
        entryPointReq.getFormPanel.add(requisitionByL);
        entryPointReq.getFormPanel.add(requisitionTypeL);
        entryPointReq.getFormPanel.add(requisitionType);
        entryPointReq.getFormPanel.add(requisitionDate);
        entryPointReq.getFormPanel.add(requisitionDateL);
        entryPointReq.getFormPanel.add(requisitionNoL);
        entryPointReq.getFormPanel.add(requisitionNo);
        entryPointReq.getFormPanel.add(requisitionRemark);
        entryPointReq.getFormPanel.add(requsitionRemarkL);
        entryPointReq.getFormPanel.add(departmentByL);
        entryPointReq.getFormPanel.add(departmentBy);
        entryPointReq.getFormPanel.add(departmentTo);
        entryPointReq.getFormPanel.add(departmentToL);
        entryPointReq.getFormPanel.add(requisitionTable());
        reqtable.setEnabled(false);

        entryPointReq.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    requisitionBy.setSelectedIndex(0);
                    requisitionType.setSelectedIndex(0);
                    departmentBy.setSelectedIndex(0);
                    departmentTo.setSelectedIndex(0);
                    requisitionRemark.setText("");
                    requisitionNo.setText("");
                    requisitionDate.setText(formattedDate1);
                    entryPointReq.txtCreatedBy.setText("");
                    entryPointReq.txtModifiedBy.setText("");
                    setEditableFieldRequisition();
                    entryPointReq.control.saveButton.setEnabled(true);
                    entryPointReq.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setEditableFieldRequisition();
                    entryPointReq.control.searchButton.setEnabled(true);
                    entryPointReq.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointReq.control.deleteButton.setEnabled(false);
        entryPointReq.control.printButton.setEnabled(false);
        entryPointReq.control.editButton.setEnabled(false);
        entryPointReq.control.saveButton.setEnabled(false);

        entryPointReq.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = ic.chkVld(requisitionRemark);
                ArrayList<Object[]> list = getDataFromReqTable();
                if (isValid) {
                    if (entryPointReq.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        ic.saveRecord(requisitionType, requisitionBy, departmentTo, departmentBy,
                                requisitionDate, requisitionRemark, moverecCodeforRequisition, addButtonFlag, list);
                        entryPointReq.control.addButton.setEnabled(true);
                        entryPointReq.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        if (!duplicate) {
                            requisitionClear();
                        }
                    } else {
                        addButtonFlag = true;
                        ic.saveRecord(requisitionType, requisitionBy, departmentTo, departmentBy,
                                requisitionDate, requisitionRemark, moverecCodeforRequisition, addButtonFlag, list);
                        if (!duplicate) {
                            requisitionClear();
                        }
                    }
                }
            }
        });
        entryPointReq.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldRequisition();
                entryPointReq.control.addButton.setEnabled(true);
                entryPointReq.control.deleteButton.setEnabled(false);
                entryPointReq.control.printButton.setEnabled(false);
                entryPointReq.control.searchButton.setEnabled(false);
            }
        });
        entryPointReq.control.searchButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    popupDialog.setVisible(true);
                    entryPointReq.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateRequisition();
                    popupDialog.revalidate();
                    popupDialog.repaint();

                } else if (!searchflag) {
                    popupDialog.dispose();
                    entryPointReq.control.addButton.setEnabled(true);
                    entryPointReq.control.deleteButton.setEnabled(false);
                    entryPointReq.control.printButton.setEnabled(false);
                    entryPointReq.control.editButton.setEnabled(false);
                    setUneditableFieldRequisition();

                    revalidateRequisition();
                    popupDialog.revalidate();
                    popupDialog.repaint();

                    searchflag = true;
                }
            }
        });
        searchByCode.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Requisition Code");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);
                    popupDialog.revalidate();
                    popupDialog.repaint();

                    revalidateRequisition();

                    requisitionSearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            ArrayList<Object[]> retrievedData = ic.moverec(searchfield.getText(), requisitionSearchby, reqModel);

                            if (reqModel.isStatus()) {
                                moverecCodeforRequisition = reqModel.getCode();

                                requisitionRemark.setText(myLib.sNull(reqModel.getTxtRemark()));
                                requisitionDate.setText(myLib.sNull(reqModel.getTxtDate()));
                                requisitionNo.setText(myLib.sNull(reqModel.getTxtRequisitionNo()));
                                requisitionBy.setSelectedItem(myLib.sNull(reqModel.getTxtRequisitionBy()));
                                requisitionType.setSelectedItem(myLib.sNull(reqModel.getTxtRequisitionType()));
                                departmentBy.setSelectedItem(myLib.sNull(reqModel.getTxtDepartmentBy()));
                                departmentTo.setSelectedItem(myLib.sNull(reqModel.getTxtDepartmentTo()));

                                /////////////////////////////////////////////////////////////////////////////////////////
                                reqTableModel.setRowCount(0);

                                for (Object[] rowData : retrievedData) {
                                    reqTableModel.addRow(rowData);
                                }
                                /////////////////////////////////////////////////////////////////////////////////////////                                

                                String createdon = myLib.sNull(reqModel.getCreatedOn());
                                String modifiedon = myLib.sNull(reqModel.getModifiedOn());
                                entryPointReq.txtCreatedBy.setText(createdon);
                                entryPointReq.txtModifiedBy.setText(modifiedon);

                                entryPointReq.getFormPanel.remove(popupDialog);
                                popupDialog.dispose();
                                popupDialog.revalidate();
                                popupDialog.repaint();

                                revalidateRequisition();

                                entryPointReq.control.editButton.setEnabled(true);
                                entryPointReq.control.deleteButton.setEnabled(true);
                                entryPointReq.control.printButton.setEnabled(true);
                                entryPointReq.control.saveButton.setEnabled(true);
                            }
                        }
                    });
                }
            }
        });
        entryPointReq.control.deleteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ic.deleteRecord(moverecCodeforRequisition);
                entryPointReq.control.editButton.setEnabled(false);
                entryPointReq.control.deleteButton.setEnabled(false);
                entryPointReq.control.printButton.setEnabled(false);
                entryPointReq.control.saveButton.setEnabled(false);
                entryPointReq.control.addButton.setEnabled(true);
                entryPointReq.control.searchButton.setEnabled(true);
                requisitionClear();
            }
        });
        entryPointReq.control.printButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ic.prnRecord(moverecCodeforRequisition);
            }
        });
        return reqFrame;
    }

// =======================================Requisition table ====================================== //
    public JScrollPane requisitionTable() {
        MyLibrary myL = new MyLibrary();

        // Create JTable with headers
        String[] columnNames = {"Item Name", "Properties", "Unit", "Required Qty", "Remark"};
        reqTableModel = new DefaultTableModel(columnNames, 1) {// Add an empty row
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        reqtable = new JTable(reqTableModel);

        // Create JScrollPane and add JTable to it
        JScrollPane scrollPane = new JScrollPane(reqtable);
        scrollPane.setBounds(25, 150, 1290, 550);
        reqFrame.add(scrollPane);

        JTableHeader header = reqtable.getTableHeader();
        header.setBackground(maingreen); // Set background color
        header.setForeground(Color.WHITE);

        reqtable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reqtable.setRowHeight(25);
        reqtable.setAutoscrolls(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 25));

        // Add click event to the table
        reqtable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = reqtable.rowAtPoint(evt.getPoint());
                int col = reqtable.columnAtPoint(evt.getPoint());

                if (evt.getClickCount() == 1) {
                    // Check if the clicked row is the last row (empty row)
                    if (row == reqTableModel.getRowCount() - 1) {
                        // Clicked on the last row
                        showPopupReq(evt.getX(), evt.getY(), row);
                    } else {
                        // Clicked on an existing row
                        showPopupReq(evt.getX(), evt.getY(), row);
                    }
                } else {
                }
            }
        });

        // Display the JFrame
        reqtable.setVisible(true);

        return scrollPane;
    }

    private void showPopupReq(int x, int y, int row) {
        MyLibrary myL = new MyLibrary();
        Requisition ic = new Requisition();

        ArrayList<String> itemList = new ArrayList<String>();
        itemList.addAll(ic.getItemList());
        String[] itemRecieved = itemList.toArray(new String[itemList.size()]);

        ImageIcon saveImage, deleteImage;

        deleteImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\delete.png");
        saveImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\save.png");

        // Get data from the selected row
        String itemName = (String) reqTableModel.getValueAt(row, 0);
        String itemProperty = (String) reqTableModel.getValueAt(row, 1);
        String reqQty = (String) reqTableModel.getValueAt(row, 2);
        String itemUnit = (String) reqTableModel.getValueAt(row, 3);
        String remark = (String) reqTableModel.getValueAt(row, 4);

        // Create a JDialog for the popup content
        JDialog popupDialog = new JDialog();
        JPanel popupPanel = new JPanel(null);
        popupPanel.setBounds(0, 0, 400, 200);

        JPanel popupControls = new JPanel(null);
        popupControls.setBounds(0, 0, 400, 29);
        popupControls.setBackground(lightgrey);

        JLabel itemNameL = new JLabel("Item Name");
        itemNameL.setBounds(25, 35, 100, 25);
        JComboBox nameField = myL.createSpecialJComboBox(itemRecieved, true);
        nameField.setBounds(125, 35, 250, 25);
        nameField.setSelectedItem(itemName);

        JLabel itemPropL = new JLabel("Properties");
        itemPropL.setBounds(25, 65, 100, 25);
        JTextField itemPropertyField = new JTextField(itemProperty);
        itemPropertyField.setBounds(125, 65, 250, 25);
        itemPropertyField.setEditable(false);

        JLabel reqQtyL = new JLabel("Req Qty");
        reqQtyL.setBounds(25, 95, 100, 25);
        JTextField reqQuantity = myL.createNumericTextFieldWithLimit(20, 200, true);
        reqQuantity.setText(reqQty);
        reqQuantity.setBounds(125, 95, 250, 25);

        JLabel itemUnitL = new JLabel("Item Unit");
        itemUnitL.setBounds(25, 125, 100, 25);
        JTextField itemUnitField = new JTextField(itemUnit);
        itemUnitField.setBounds(125, 125, 100, 25);
        itemUnitField.setEditable(false);

        JLabel remarkFieldL = new JLabel("Remark");
        remarkFieldL.setBounds(25, 155, 100, 25);
        JTextField remarkField = new JTextField(remark);
        remarkField.setBounds(125, 155, 100, 25);

        JButton okButton = new JButton(saveImage);
        okButton.setBounds(320, 0, 30, 29);
        okButton.setBackground(lightgrey);
        JButton deleteButton = new JButton(deleteImage);
        deleteButton.setBounds(350, 0, 30, 29);
        deleteButton.setBackground(lightgrey);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update data in the table
                if (nameField.getSelectedItem() != null && reqQuantity.getText().length() != 0 && Integer.parseInt(reqQuantity.getText()) != 0) {
                    reqTableModel.setValueAt(myL.sNull(nameField.getSelectedItem().toString()), row, 0);
                    reqTableModel.setValueAt(myL.sNull(itemPropertyField.getText()), row, 1);
                    reqTableModel.setValueAt(myL.sNull(reqQuantity.getText()), row, 2);
                    reqTableModel.setValueAt(myL.sNull(itemUnitField.getText()), row, 3);
                    reqTableModel.setValueAt(myL.sNull(remarkField.getText()), row, 4);
                    // Check if the clicked row is the last row (empty row)
                    if (row == reqTableModel.getRowCount() - 1) {
                        // Add a new empty row
                        reqTableModel.addRow(new Object[]{"", "", "", "", ""});
                    }

                    // Close the popup
                    popupDialog.dispose();

                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reqTableModel.getRowCount() > 1) {
                    // Delete selected row from the table
                    reqTableModel.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot delete the last row.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the popup
                popupDialog.dispose();
            }
        });

        // Add components to the popupPanel
        popupPanel.add(nameField);
        popupPanel.add(itemNameL);
        popupPanel.add(itemPropertyField);
        popupPanel.add(itemPropL);
        popupPanel.add(remarkField);
        popupPanel.add(remarkFieldL);
        popupPanel.add(reqQuantity);
        popupPanel.add(reqQtyL);
        popupPanel.add(itemUnitField);
        popupPanel.add(itemUnitL);
        popupControls.add(okButton);
        popupControls.add(deleteButton);
        popupPanel.add(popupControls);

        // Set the size and background color of the popupPanel
        popupPanel.setPreferredSize(new Dimension(400, 200));
        popupPanel.setBackground(Color.WHITE);

        // Add the popupPanel to the popupDialog
        popupDialog.add(popupPanel);

        // Set the location of the popupDialog
        popupDialog.setLocation(x, y);

        // Set the size of the popupDialog
        popupDialog.setSize(400, 260);

        // Make the popupDialog visible
        popupDialog.setVisible(true);

        nameField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String[] recievedArray = ic.getItem(nameField.getSelectedItem().toString());
                itemPropertyField.setText(recievedArray[0]);
                itemUnitField.setText(recievedArray[1]);
            }
        });
    }

    private ArrayList<Object[]> getDataFromReqTable() {
        ArrayList<Object[]> data = new ArrayList<>();

        for (int i = 0; i < reqTableModel.getRowCount(); i++) {
            String itemname = (String) reqTableModel.getValueAt(i, 0);
            String itemProperties = (String) reqTableModel.getValueAt(i, 1);
            String unit = (String) reqTableModel.getValueAt(i, 2);
            String reqUnit = (String) reqTableModel.getValueAt(i, 3);
            String remark = (String) reqTableModel.getValueAt(i, 4);
            data.add(new Object[]{itemname, itemProperties, unit, reqUnit, remark});
        }

        return data;
    }

    private void clearReqTable() {
        // Clear the table
        reqTableModel.setRowCount(0);
        // Add an empty row
        reqTableModel.addRow(new Object[]{"", "", "", "", "", ""});
    }

    // helping functions for requisition //
    public void revalidateRequisition() {
        reqFrame.repaint();
        reqFrame.revalidate();
    }

    public void requisitionClear() {
        requisitionBy.setSelectedIndex(0);
        requisitionType.setSelectedIndex(0);
        departmentBy.setSelectedIndex(0);
        departmentTo.setSelectedIndex(0);
        requisitionRemark.setText("");
        requisitionNo.setText("");
        requisitionDate.setText(formattedDate1);
        entryPointReq.txtCreatedBy.setText("");
        entryPointReq.txtModifiedBy.setText("");
        clearReqTable();
    }

    private void setEditableFieldRequisition() {
        requisitionBy.setEditable(true);
        departmentBy.setEditable(true);
        departmentTo.setEditable(true);
        requisitionRemark.setEditable(true);
        requisitionType.setEditable(true);
        reqtable.setEnabled(true);

    }

    private void setUneditableFieldRequisition() {
        requisitionBy.setEditable(false);
        departmentBy.setEditable(false);
        departmentTo.setEditable(false);
        requisitionRemark.setEditable(false);
        requisitionType.setEditable(false);
        reqtable.setEnabled(false);

    }

    ////<<<<------------------====================PURCHASE STARTS====================------------------>>>>////
    //<------------------------------**** INDENT STARTS ****-------------------------------->//
    public JFrame addIndentFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        Indent ic = new Indent();
        String[] indentTypeArray = new String[]{"Indent", "Service Indent"};

        ArrayList<String> requisitionList = new ArrayList<String>();
        ArrayList<String> departmentList = new ArrayList<String>();
        ArrayList<String> employeeList = new ArrayList<String>();

        employeeList.addAll(ic.getCityList());
        departmentList.addAll(ic.getDepartmentList());
        requisitionList.addAll(ic.getRequisition());

        String[] employeeRecieved = employeeList.toArray(new String[employeeList.size()]);
        String[] departmentRecieved = departmentList.toArray(new String[departmentList.size()]);
        String[] requistionRecieved = requisitionList.toArray(new String[requisitionList.size()]);

        entryPointIndent.setFormPanelHeightBounds(750);
        indentFrame = entryPointIndent.addFrame();

        JPanel formPanel = new JPanel(null);

        indentTypeL = new JLabel("Indent Type");
        indentTypeL.setBounds(25, 45, 100, 25);

        indentType = myL.createSpecialJComboBox(indentTypeArray, true);
        indentType.setBounds(150, 45, 515, 25);
        indentType.setEditable(false);

        indentNoL = new JLabel("Indent No.");
        indentNoL.setBounds(25, 75, 100, 25);

        indentNo = myL.createSpecialJTextField(20, true);
        indentNo.setBounds(150, 75, 170, 25);
        indentNo.setEditable(false);

        indentDateL = new JLabel("Date");
        indentDateL.setBounds(350, 75, 94, 25);

        indentDate = myL.createSpecialJTextField(20, true);
        indentDate.setBounds(430, 75, 235, 25);
        indentDate.setEditable(false);
        indentDate.setText(formattedDate1);

        indentorL = new JLabel("Indentor");
        indentorL.setBounds(25, 105, 100, 25);

        indentor = myL.createSpecialJComboBox(employeeRecieved, true);
        indentor.setBounds(150, 105, 515, 25);
        indentor.setEditable(false);

        indentDepartmentL = new JLabel("Department");
        indentDepartmentL.setBounds(690, 45, 100, 25);

        indentDepartment = myL.createSpecialJComboBox(departmentRecieved, true);
        indentDepartment.setBounds(800, 45, 515, 25);
        indentDepartment.setEditable(false);

        indentRequisitionL = new JLabel("Requisition");
        indentRequisitionL.setBounds(690, 75, 100, 25);

        indentRequisition = myL.createSpecialJComboBox(requistionRecieved, true);
        indentRequisition.setBounds(800, 75, 515, 25);
        indentRequisition.setEditable(false);

        indentRemarkL = new JLabel("Remark");
        indentRemarkL.setBounds(690, 105, 100, 25);

        indentRemark = myL.createSpecialJTextField(20, false);
        indentRemark.setBounds(800, 105, 515, 25);
        indentRemark.setEditable(false);

        entryPointIndent.setFormName("Indent");
        entryPointIndent.getFrame.setTitle("Indent");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(3, 1));
        searchPanel.setBounds(500, 500, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JDialog popupDialog = new JDialog();
        popupDialog.setBounds(500, 500, 200, 200);
        popupDialog.add(searchPanel);

        JRadioButton searchByCode = new JRadioButton("Search by Code");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        entryPointIndent.getFormPanel.add(indentorL);
        entryPointIndent.getFormPanel.add(indentor);
        entryPointIndent.getFormPanel.add(indentTypeL);
        entryPointIndent.getFormPanel.add(indentType);
        entryPointIndent.getFormPanel.add(indentDate);
        entryPointIndent.getFormPanel.add(indentDateL);
        entryPointIndent.getFormPanel.add(indentNoL);
        entryPointIndent.getFormPanel.add(indentNo);
        entryPointIndent.getFormPanel.add(indentRemark);
        entryPointIndent.getFormPanel.add(indentRemarkL);
        entryPointIndent.getFormPanel.add(indentDepartmentL);
        entryPointIndent.getFormPanel.add(indentDepartment);
        entryPointIndent.getFormPanel.add(indentRequisitionL);
        entryPointIndent.getFormPanel.add(indentRequisition);
        entryPointIndent.getFormPanel.add(indentTable());
        indenttable.setEnabled(false);

        entryPointIndent.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    IndentClear();
                    setEditableFieldIndent();
                    entryPointIndent.control.saveButton.setEnabled(true);
                    entryPointIndent.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setEditableFieldIndent();
                    entryPointIndent.control.searchButton.setEnabled(true);
                    entryPointIndent.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointIndent.control.deleteButton.setEnabled(false);
        entryPointIndent.control.printButton.setEnabled(false);
        entryPointIndent.control.editButton.setEnabled(false);
        entryPointIndent.control.saveButton.setEnabled(false);

        entryPointIndent.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = ic.chkVld(indentRemark);
                ArrayList<Object[]> list = getDataFromIndentTable();
                if (isValid) {
                    if (entryPointIndent.control.editButton.isEnabled()) {
                        if (list.size() > 1) {
                            addButtonFlag = false;
                            ic.saveRecord(indentType, indentor, indentDepartment, indentRequisition,
                                    indentDate, indentRemark, moverecCodeforIndent, addButtonFlag, list);
                            entryPointIndent.control.addButton.setEnabled(true);
                            entryPointIndent.control.editButton.setEnabled(false);
                            addButtonFlag = true;
                            if (!duplicate) {
                                IndentClear();
                                clearIndentTable();
                            }
                        }
                    } else {
                        if (list.size() > 1) {

                            addButtonFlag = true;
                            ic.saveRecord(indentType, indentor, indentDepartment, indentRequisition,
                                    indentDate, indentRemark, moverecCodeforIndent, addButtonFlag, list);

                            if (!duplicate) {
                                IndentClear();
                                clearIndentTable();
                            }
                        }
                    }
                }
            }
        });
        entryPointIndent.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldIndent();
                entryPointIndent.control.addButton.setEnabled(true);
                entryPointIndent.control.deleteButton.setEnabled(false);
                entryPointIndent.control.printButton.setEnabled(false);
                entryPointIndent.control.searchButton.setEnabled(false);
            }
        });
        entryPointIndent.control.searchButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearIndentTable();
                IndentClear();
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    popupDialog.setVisible(true);
                    entryPointIndent.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateIndent();
                    popupDialog.revalidate();
                    popupDialog.repaint();

                } else if (!searchflag) {
                    popupDialog.dispose();
                    entryPointIndent.control.addButton.setEnabled(true);
                    entryPointIndent.control.deleteButton.setEnabled(false);
                    entryPointIndent.control.printButton.setEnabled(false);
                    entryPointIndent.control.editButton.setEnabled(false);
                    setUneditableFieldIndent();

                    revalidateIndent();
                    popupDialog.revalidate();
                    popupDialog.repaint();

                    searchflag = true;
                }
            }
        });
        searchByCode.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Indent Code");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);
                    popupDialog.revalidate();
                    popupDialog.repaint();

                    revalidateIndent();

                    indentSearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            ArrayList<Object[]> retrievedData = ic.moverec(searchfield.getText(), indentSearchby, indentModel);

                            if (indentModel.isStatus()) {

                                moverecCodeforIndent = indentModel.getCode();

                                indentRemark.setText(myLib.sNull(indentModel.getTxtRemark()));
                                indentDate.setText(myLib.sNull(indentModel.getTxtDate()));
                                indentNo.setText(myLib.sNull(indentModel.getTxtIndentNo()));
                                indentor.setSelectedItem(myLib.sNull(indentModel.getTxtIndentor()));
                                indentType.setSelectedItem(myLib.sNull(indentModel.getTxtIndentType()));
                                indentDepartment.setSelectedItem(myLib.sNull(indentModel.getTxtIndentDepartment()));
                                indentRequisition.setSelectedItem(myLib.sNull(indentModel.getTxtRequiition()));

                                /////////////////////////////////////////////////////////////////////////////////////////
                                indentTableModel.setRowCount(0);

                                for (Object[] rowData : retrievedData) {
                                    indentTableModel.addRow(rowData);
                                }
                                /////////////////////////////////////////////////////////////////////////////////////////                                

                                String createdon = myLib.sNull(indentModel.getCreatedOn());
                                String modifiedon = myLib.sNull(indentModel.getModifiedOn());
                                entryPointIndent.txtCreatedBy.setText(createdon);
                                entryPointIndent.txtModifiedBy.setText(modifiedon);

                                entryPointIndent.getFormPanel.remove(popupDialog);
                                popupDialog.dispose();
                                popupDialog.revalidate();
                                popupDialog.repaint();

                                revalidateIndent();

                                entryPointIndent.control.editButton.setEnabled(true);
                                entryPointIndent.control.deleteButton.setEnabled(true);
                                entryPointIndent.control.printButton.setEnabled(true);
                                entryPointIndent.control.saveButton.setEnabled(true);
                            }
                        }
                    });
                }
            }
        });
        entryPointIndent.control.deleteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ic.deleteRecord(moverecCodeforIndent);
                clearIndentTable();

                entryPointIndent.control.editButton.setEnabled(false);
                entryPointIndent.control.deleteButton.setEnabled(false);
                entryPointIndent.control.printButton.setEnabled(false);
                entryPointIndent.control.saveButton.setEnabled(false);
                entryPointIndent.control.addButton.setEnabled(true);
                entryPointIndent.control.searchButton.setEnabled(true);
                IndentClear();
            }
        });
        entryPointIndent.control.printButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ic.prnRecord(moverecCodeforIndent);
            }
        });
        indentRequisition.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (!indentRequisition.getSelectedItem().toString().equals("")) {
                    String s = indentRequisition.getSelectedItem().toString();
                    ArrayList<Object[]> retrievedData = ic.getRequisitionDetailsAll(indentRequisition.getSelectedItem().toString(), indentModel);
                    indentTableModel.setRowCount(0);
                    for (Object[] rowData : retrievedData) {
                        indentTableModel.addRow(rowData);
                    }
                }
            }
        });

        return indentFrame;
    }

// =======================================Indent table ====================================== //
    public JScrollPane indentTable() {
        MyLibrary myL = new MyLibrary();

        // Create JTable with headers
        String[] columnNames = {"Item Name", "Properties", "SKU", "Required Qty", "Remark"};
        indentTableModel = new DefaultTableModel(columnNames, 1) {// Add an empty row
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        indenttable = new JTable(indentTableModel);

        // Create JScrollPane and add JTable to it
        JScrollPane scrollPane = new JScrollPane(indenttable);
        scrollPane.setBounds(25, 150, 1290, 550);
        indentFrame.add(scrollPane);

        JTableHeader header = indenttable.getTableHeader();
        header.setBackground(maingreen); // Set background color
        header.setForeground(Color.WHITE);

        indenttable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        indenttable.setRowHeight(25);
        indenttable.setAutoscrolls(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 25));

        // Add click event to the table
        indenttable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = indenttable.rowAtPoint(evt.getPoint());
                int col = indenttable.columnAtPoint(evt.getPoint());

                if (evt.getClickCount() == 1) {
                    // Check if the clicked row is the last row (empty row)
                    if (row == indentTableModel.getRowCount() - 1) {
                        // Clicked on the last row
                        showPopupIndent(evt.getX(), evt.getY(), row);
                    } else {
                        // Clicked on an existing row
                        showPopupIndent(evt.getX(), evt.getY(), row);
                    }
                } else {
                }
            }
        });

        // Display the JFrame
        indenttable.setVisible(true);

        return scrollPane;
    }

    private void showPopupIndent(int x, int y, int row) {
        MyLibrary myL = new MyLibrary();
        Requisition ic = new Requisition();

        ArrayList<String> itemList = new ArrayList<String>();
        itemList.addAll(ic.getItemList());
        String[] itemRecieved = itemList.toArray(new String[itemList.size()]);

        ImageIcon saveImage, deleteImage;

        deleteImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\delete.png");
        saveImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\save.png");

        // Get data from the selected row
        String itemName = (String) indentTableModel.getValueAt(row, 0);
        String itemProperty = (String) indentTableModel.getValueAt(row, 1);
        String reqQty = (String) indentTableModel.getValueAt(row, 2);
        String itemUnit = (String) indentTableModel.getValueAt(row, 3);
        String remark = (String) indentTableModel.getValueAt(row, 4);

        // Create a JDialog for the popup content
        JDialog popupDialog = new JDialog();
        JPanel popupPanel = new JPanel(null);
        popupPanel.setBounds(0, 0, 400, 200);

        JPanel popupControls = new JPanel(null);
        popupControls.setBounds(0, 0, 400, 29);
        popupControls.setBackground(lightgrey);

        JLabel itemNameL = new JLabel("Item Name");
        itemNameL.setBounds(25, 35, 100, 25);
        JComboBox nameField = myL.createSpecialJComboBox(itemRecieved, true);
        nameField.setBounds(125, 35, 250, 25);
        nameField.setSelectedItem(itemName);

        JLabel itemPropL = new JLabel("Properties");
        itemPropL.setBounds(25, 65, 100, 25);
        JTextField itemPropertyField = new JTextField(itemProperty);
        itemPropertyField.setBounds(125, 65, 250, 25);
        itemPropertyField.setEditable(false);

        JLabel reqQtyL = new JLabel("Req Qty");
        reqQtyL.setBounds(25, 95, 100, 25);
        JTextField reqQuantity = myL.createNumericTextFieldWithLimit(20, 200, true);
        reqQuantity.setText(reqQty);
        reqQuantity.setBounds(125, 95, 250, 25);

        JLabel itemUnitL = new JLabel("SKU");
        itemUnitL.setBounds(25, 125, 100, 25);
        JTextField itemUnitField = new JTextField(itemUnit);
        itemUnitField.setBounds(125, 125, 100, 25);
        itemUnitField.setEditable(false);

        JLabel remarkFieldL = new JLabel("Remark");
        remarkFieldL.setBounds(25, 155, 100, 25);
        JTextField remarkField = new JTextField(remark);
        remarkField.setBounds(125, 155, 100, 25);

        JButton okButton = new JButton(saveImage);
        okButton.setBounds(320, 0, 30, 29);
        okButton.setBackground(lightgrey);
        JButton deleteButton = new JButton(deleteImage);
        deleteButton.setBounds(350, 0, 30, 29);
        deleteButton.setBackground(lightgrey);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update data in the table
                if (nameField.getSelectedItem() != null && reqQuantity.getText().length() != 0 && Integer.parseInt(reqQuantity.getText()) != 0) {
                    indentTableModel.setValueAt(myL.sNull(nameField.getSelectedItem().toString()), row, 0);
                    indentTableModel.setValueAt(myL.sNull(itemPropertyField.getText()), row, 1);
                    indentTableModel.setValueAt(myL.sNull(reqQuantity.getText()), row, 2);
                    indentTableModel.setValueAt(myL.sNull(itemUnitField.getText()), row, 3);
                    indentTableModel.setValueAt(myL.sNull(remarkField.getText()), row, 4);
                    // Check if the clicked row is the last row (empty row)
                    if (row == indentTableModel.getRowCount() - 1) {
                        // Add a new empty row
                        indentTableModel.addRow(new Object[]{"", "", "", "", ""});
                    }

                    // Close the popup
                    popupDialog.dispose();

                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indentTableModel.getRowCount() > 1) {
                    // Delete selected row from the table
                    indentTableModel.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot delete the last row.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the popup
                popupDialog.dispose();
            }
        });

        // Add components to the popupPanel
        popupPanel.add(nameField);
        popupPanel.add(itemNameL);
        popupPanel.add(itemPropertyField);
        popupPanel.add(itemPropL);
        popupPanel.add(remarkField);
        popupPanel.add(remarkFieldL);
        popupPanel.add(reqQuantity);
        popupPanel.add(reqQtyL);
        popupPanel.add(itemUnitField);
        popupPanel.add(itemUnitL);
        popupControls.add(okButton);
        popupControls.add(deleteButton);
        popupPanel.add(popupControls);

        // Set the size and background color of the popupPanel
        popupPanel.setPreferredSize(new Dimension(400, 200));
        popupPanel.setBackground(Color.WHITE);

        // Add the popupPanel to the popupDialog
        popupDialog.add(popupPanel);

        // Set the location of the popupDialog
        popupDialog.setLocation(x, y);

        // Set the size of the popupDialog
        popupDialog.setSize(400, 260);

        // Make the popupDialog visible
        popupDialog.setVisible(true);

        nameField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String[] recievedArray = ic.getItem(nameField.getSelectedItem().toString());
                itemPropertyField.setText(recievedArray[0]);
                itemUnitField.setText(recievedArray[1]);
            }
        });
    }

    private ArrayList<Object[]> getDataFromIndentTable() {
        ArrayList<Object[]> data = new ArrayList<>();

        for (int i = 0; i < indentTableModel.getRowCount(); i++) {
            String itemname = (String) indentTableModel.getValueAt(i, 0);
            String itemProperties = (String) indentTableModel.getValueAt(i, 1);
            String unit = (String) indentTableModel.getValueAt(i, 2);
            String reqUnit = (String) indentTableModel.getValueAt(i, 3);
            String remark = (String) indentTableModel.getValueAt(i, 4);
            data.add(new Object[]{itemname, itemProperties, unit, reqUnit, remark});
        }

        return data;
    }

    private void clearIndentTable() {
        // Clear the table
        indentTableModel.setRowCount(0);
        // Add an empty row
        indentTableModel.addRow(new Object[]{"", "", "", "", "", ""});
    }

    // helping functions for indent //
    public void revalidateIndent() {
        indentFrame.repaint();
        indentFrame.revalidate();
    }

    public void IndentClear() {
        indentDepartment.setSelectedIndex(0);
        indentor.setSelectedIndex(0);
        indentType.setSelectedIndex(0);
        indentRemark.setText("");
        indentNo.setText("");
        indentDate.setText(formattedDate1);
        entryPointIndent.txtCreatedBy.setText("");
        entryPointIndent.txtModifiedBy.setText("");
    }

    private void setEditableFieldIndent() {
        indentor.setEditable(true);
        indentRequisition.setEditable(true);
        indentRemark.setEditable(true);
        indentType.setEditable(true);
        indentDepartment.setEditable(true);
        indenttable.setEnabled(true);
    }

    private void setUneditableFieldIndent() {
        indentor.setEditable(false);
        indentRequisition.setEditable(false);
        indentRemark.setEditable(false);
        indentType.setEditable(false);
        indentDepartment.setEditable(false);
        indenttable.setEnabled(false);
    }

    //<------------------------------**** ENQUIRY STARTS ****-------------------------------->//
    public JFrame addEnquiryFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        Enquiry ic = new Enquiry();
        String[] indentTypeArray = new String[]{"Enquiry", "Service Enquiry"};

        ArrayList<String> indentList = new ArrayList<String>();
        ArrayList<String> departmentList = new ArrayList<String>();

        departmentList.addAll(ic.getDepartmentList());
        indentList.addAll(ic.getIndent());

        String[] departmentRecieved = departmentList.toArray(new String[departmentList.size()]);
        String[] indentRecieved = indentList.toArray(new String[indentList.size()]);

        entryPointEnquiry.setFormPanelHeightBounds(750);
        enquiryFrame = entryPointEnquiry.addFrame();

        JPanel formPanel = new JPanel(null);

        enquiryTypeL = new JLabel("Enquiry Type");
        enquiryTypeL.setBounds(25, 45, 100, 25);

        enquiryType = myL.createSpecialJComboBox(indentTypeArray, true);
        enquiryType.setBounds(150, 45, 515, 25);
        enquiryType.setEditable(false);

        enquiryNoL = new JLabel("Enquiry No.");
        enquiryNoL.setBounds(25, 75, 100, 25);

        enquiryNo = myL.createSpecialJTextField(20, true);
        enquiryNo.setBounds(150, 75, 170, 25);
        enquiryNo.setEditable(false);

        enquiryDateL = new JLabel("Date");
        enquiryDateL.setBounds(350, 75, 94, 25);

        enquiryDate = myL.createSpecialJTextField(20, true);
        enquiryDate.setBounds(430, 75, 235, 25);
        enquiryDate.setEditable(false);
        enquiryDate.setText(formattedDate1);

        enquiryRemarkL = new JLabel("Remark");
        enquiryRemarkL.setBounds(25, 105, 100, 25);

        enquiryRemark = myL.createSpecialJTextField(20, false);
        enquiryRemark.setBounds(150, 105, 515, 25);
        enquiryRemark.setEditable(false);

        enquiryDepartmentL = new JLabel("Department");
        enquiryDepartmentL.setBounds(690, 45, 100, 25);

        enquiryDepartment = myL.createSpecialJComboBox(departmentRecieved, true);
        enquiryDepartment.setBounds(800, 45, 515, 25);
        enquiryDepartment.setEditable(false);

        enquiryIndentL = new JLabel("Indent");
        enquiryIndentL.setBounds(690, 75, 100, 25);

        enquiryIndent = myL.createSpecialJComboBox(indentRecieved, true);
        enquiryIndent.setBounds(800, 75, 515, 25);
        enquiryIndent.setEditable(false);

        entryPointEnquiry.setFormName("Enquiry");
        entryPointEnquiry.getFrame.setTitle("Enquiry");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(3, 1));
        searchPanel.setBounds(500, 500, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JDialog popupDialog = new JDialog();
        popupDialog.setBounds(500, 500, 200, 200);
        popupDialog.add(searchPanel);

        JRadioButton searchByCode = new JRadioButton("Search by Code");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        entryPointEnquiry.getFormPanel.add(enquiryIndent);
        entryPointEnquiry.getFormPanel.add(enquiryIndentL);
        entryPointEnquiry.getFormPanel.add(enquiryDepartment);
        entryPointEnquiry.getFormPanel.add(enquiryDepartmentL);
        entryPointEnquiry.getFormPanel.add(enquiryRemark);
        entryPointEnquiry.getFormPanel.add(enquiryRemarkL);
        entryPointEnquiry.getFormPanel.add(enquiryDate);
        entryPointEnquiry.getFormPanel.add(enquiryDateL);
        entryPointEnquiry.getFormPanel.add(enquiryNoL);
        entryPointEnquiry.getFormPanel.add(enquiryNo);
        entryPointEnquiry.getFormPanel.add(enquiryType);
        entryPointEnquiry.getFormPanel.add(enquiryTypeL);
        entryPointEnquiry.getFormPanel.add(enquiryTable());
        entryPointEnquiry.getFormPanel.add(enquiryPartyTable());
        enquirytable.setEnabled(false);
        enquirypartytable.setEnabled(false);

        entryPointEnquiry.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    enquiryClear();
                    setEditableFieldEnquiry();
                    clearEnquiryPartyTable();
                    clearEnquiryTable();
                    entryPointEnquiry.control.saveButton.setEnabled(true);
                    entryPointEnquiry.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setEditableFieldEnquiry();
                    entryPointEnquiry.control.searchButton.setEnabled(true);
                    entryPointEnquiry.control.saveButton.setEnabled(false);
                    clearEnquiryPartyTable();
                    clearEnquiryTable();
                    addsearchFlag = true;
                }
            }
        });

        entryPointEnquiry.control.deleteButton.setEnabled(false);
        entryPointEnquiry.control.printButton.setEnabled(false);
        entryPointEnquiry.control.editButton.setEnabled(false);
        entryPointEnquiry.control.saveButton.setEnabled(false);

        entryPointEnquiry.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = ic.chkVld(enquiryRemark);
                ArrayList<Object[]> itemlist = getDataFromEnquiryTable();
                ArrayList<Object[]> supplierlist = getDataFromEnquiryPartyTable();
                if (isValid) {
                    if (entryPointEnquiry.control.editButton.isEnabled()) {
                        if (supplierlist.size() > 1 && itemlist.size() > 1) {
                            addButtonFlag = false;
                            ic.saveRecord(enquiryType, enquiryDepartment, enquiryIndent,
                                    enquiryDate, enquiryRemark, moverecCodeforEnquiry, addButtonFlag, itemlist, supplierlist);
                            entryPointEnquiry.control.addButton.setEnabled(true);
                            entryPointEnquiry.control.editButton.setEnabled(false);
                            addButtonFlag = true;
                            if (!duplicate) {
                                enquiryClear();
                                clearEnquiryTable();
                                clearEnquiryPartyTable();
                            }
                        }
                    } else {
                        if (supplierlist.size() > 1 && itemlist.size() > 1) {
                            addButtonFlag = true;
                            ic.saveRecord(enquiryType, enquiryDepartment, enquiryIndent,
                                    enquiryDate, enquiryRemark, moverecCodeforEnquiry, addButtonFlag, itemlist, supplierlist);

                            if (!duplicate) {
                                enquiryClear();
                                clearEnquiryTable();
                                clearEnquiryPartyTable();
                            }
                        } else {
                            JOptionPane.showMessageDialog(enquiryFrame, "Please select item or supplier");
                        }
                    }
                }
            }
        });
        entryPointEnquiry.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldEnquiry();
                entryPointEnquiry.control.addButton.setEnabled(true);
                entryPointEnquiry.control.deleteButton.setEnabled(false);
                entryPointEnquiry.control.printButton.setEnabled(false);
                entryPointEnquiry.control.searchButton.setEnabled(false);
            }
        });
        entryPointEnquiry.control.searchButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearEnquiryTable();
                enquiryClear();
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    popupDialog.setVisible(true);
                    entryPointEnquiry.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateEnquiry();
                    popupDialog.revalidate();
                    popupDialog.repaint();

                } else if (!searchflag) {
                    popupDialog.dispose();
                    entryPointEnquiry.control.addButton.setEnabled(true);
                    entryPointEnquiry.control.deleteButton.setEnabled(false);
                    entryPointEnquiry.control.printButton.setEnabled(false);
                    entryPointEnquiry.control.editButton.setEnabled(false);
                    setUneditableFieldEnquiry();

                    revalidateEnquiry();
                    popupDialog.revalidate();
                    popupDialog.repaint();

                    searchflag = true;
                }
            }
        });
        searchByCode.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Enquiry Code");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);
                    popupDialog.revalidate();
                    popupDialog.repaint();

                    revalidateEnquiry();

                    enquirySearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            ArrayList<Object[]> retrievedData = ic.moverec(searchfield.getText(), enquirySearchby, enquiryModel);
                            ArrayList<Object[]> retrievedSupplier = enquiryModel.getSupplierListRec();
                            if (enquiryModel.isStatus()) {

                                moverecCodeforEnquiry = enquiryModel.getCode();

                                enquiryRemark.setText(myLib.sNull(enquiryModel.getTxtRemark()));
                                enquiryDate.setText(myLib.sNull(enquiryModel.getTxtDate()));
                                enquiryNo.setText(myLib.sNull(enquiryModel.getTxtEnquiryNo()));
                                enquiryType.setSelectedItem(myLib.sNull(enquiryModel.getTxtEnquiryType()));
                                enquiryDepartment.setSelectedItem(myLib.sNull(enquiryModel.getTxtDepartment()));
                                enquiryIndent.setSelectedItem(myLib.sNull(enquiryModel.getTxtIndent()));

                                /////////////////////////////////////////////////////////////////////////////////////////
                                enquiryTableModel.setRowCount(0);

                                for (Object[] rowData : retrievedData) {
                                    enquiryTableModel.addRow(rowData);
                                }
                                enquiryPartyTableModel.setRowCount(0);

                                for (Object[] rowData : retrievedSupplier) {
                                    enquiryPartyTableModel.addRow(rowData);
                                }
                                /////////////////////////////////////////////////////////////////////////////////////////                                

                                String createdon = myLib.sNull(enquiryModel.getCreatedOn());
                                String modifiedon = myLib.sNull(enquiryModel.getModifiedOn());
                                entryPointEnquiry.txtCreatedBy.setText(createdon);
                                entryPointEnquiry.txtModifiedBy.setText(modifiedon);

                                entryPointEnquiry.getFormPanel.remove(popupDialog);
                                popupDialog.dispose();
                                popupDialog.revalidate();
                                popupDialog.repaint();

                                revalidateEnquiry();

                                entryPointEnquiry.control.editButton.setEnabled(true);
                                entryPointEnquiry.control.deleteButton.setEnabled(true);
                                entryPointEnquiry.control.printButton.setEnabled(true);
                                entryPointEnquiry.control.saveButton.setEnabled(true);
                            }
                        }
                    });
                }
            }
        });
        entryPointEnquiry.control.deleteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ic.deleteRecord(moverecCodeforEnquiry);
                clearEnquiryTable();

                entryPointEnquiry.control.editButton.setEnabled(false);
                entryPointEnquiry.control.deleteButton.setEnabled(false);
                entryPointEnquiry.control.printButton.setEnabled(false);
                entryPointEnquiry.control.saveButton.setEnabled(false);
                entryPointEnquiry.control.addButton.setEnabled(true);
                entryPointEnquiry.control.searchButton.setEnabled(true);
                enquiryClear();
            }
        });
        entryPointEnquiry.control.printButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ic.prnRecord(moverecCodeforEnquiry);
            }
        });
        enquiryIndent.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (!enquiryIndent.getSelectedItem().toString().equals("")) {
                    String s = enquiryIndent.getSelectedItem().toString();
                    ArrayList<Object[]> retrievedData = ic.getIndentDetailsAll(enquiryIndent.getSelectedItem().toString(), enquiryModel);
                    enquiryTableModel.setRowCount(0);
                    for (Object[] rowData : retrievedData) {
                        enquiryTableModel.addRow(rowData);
                    }
                }
            }
        });

        return enquiryFrame;
    }

// =======================================Enquiry table ====================================== //
    public JScrollPane enquiryTable() {
        MyLibrary myL = new MyLibrary();

        // Create JTable with headers
        String[] columnNames = {"Item Name", "Properties", "Unit", "Required Qty", "Remark"};
        enquiryTableModel = new DefaultTableModel(columnNames, 1) {// Add an empty row
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        enquirytable = new JTable(enquiryTableModel);

        // Create JScrollPane and add JTable to it
        JScrollPane scrollPane = new JScrollPane(enquirytable);
        scrollPane.setBounds(25, 150, 1290, 300);
        enquiryFrame.add(scrollPane);

        JTableHeader header = enquirytable.getTableHeader();
        header.setBackground(maingreen); // Set background color
        header.setForeground(Color.WHITE);

        enquirytable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        enquirytable.setRowHeight(25);
        enquirytable.setAutoscrolls(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 25));

        // Add click event to the table
        enquirytable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = enquirytable.rowAtPoint(evt.getPoint());
                int col = enquirytable.columnAtPoint(evt.getPoint());

                if (evt.getClickCount() == 1) {
                    // Check if the clicked row is the last row (empty row)
                    if (row == enquiryTableModel.getRowCount() - 1) {
                        // Clicked on the last row
                        showPopupEnquiry(evt.getX(), evt.getY(), row);
                    } else {
                        // Clicked on an existing row
                        showPopupEnquiry(evt.getX(), evt.getY(), row);
                    }
                } else {
                }
            }
        });

        // Display the JFrame
        enquirytable.setVisible(true);

        return scrollPane;
    }

    private void showPopupEnquiry(int x, int y, int row) {
        MyLibrary myL = new MyLibrary();
        Requisition ic = new Requisition();

        ArrayList<String> itemList = new ArrayList<String>();
        itemList.addAll(ic.getItemList());
        String[] itemRecieved = itemList.toArray(new String[itemList.size()]);

        ImageIcon saveImage, deleteImage;

        deleteImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\delete.png");
        saveImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\save.png");

        // Get data from the selected row
        String itemName = (String) enquiryTableModel.getValueAt(row, 0);
        String itemProperty = (String) enquiryTableModel.getValueAt(row, 1);
        String reqQty = (String) enquiryTableModel.getValueAt(row, 2);
        String itemUnit = (String) enquiryTableModel.getValueAt(row, 3);
        String remark = (String) enquiryTableModel.getValueAt(row, 4);

        // Create a JDialog for the popup content
        JDialog popupDialog = new JDialog();
        JPanel popupPanel = new JPanel(null);
        popupPanel.setBounds(0, 0, 400, 200);

        JPanel popupControls = new JPanel(null);
        popupControls.setBounds(0, 0, 400, 29);
        popupControls.setBackground(lightgrey);

        JLabel itemNameL = new JLabel("Item Name");
        itemNameL.setBounds(25, 35, 100, 25);
        JComboBox nameField = myL.createSpecialJComboBox(itemRecieved, true);
        nameField.setBounds(125, 35, 250, 25);
        nameField.setSelectedItem(itemName);

        JLabel itemPropL = new JLabel("Properties");
        itemPropL.setBounds(25, 65, 100, 25);
        JTextField itemPropertyField = new JTextField(itemProperty);
        itemPropertyField.setBounds(125, 65, 250, 25);
        itemPropertyField.setEditable(false);

        JLabel reqQtyL = new JLabel("Req Qty");
        reqQtyL.setBounds(25, 95, 100, 25);
        JTextField reqQuantity = myL.createNumericTextFieldWithLimit(20, 200, true);
        reqQuantity.setText(reqQty);
        reqQuantity.setBounds(125, 95, 250, 25);

        JLabel itemUnitL = new JLabel("SKU");
        itemUnitL.setBounds(25, 125, 100, 25);
        JTextField itemUnitField = new JTextField(itemUnit);
        itemUnitField.setBounds(125, 125, 100, 25);
        itemUnitField.setEditable(false);

        JLabel remarkFieldL = new JLabel("Remark");
        remarkFieldL.setBounds(25, 155, 100, 25);
        JTextField remarkField = new JTextField(remark);
        remarkField.setBounds(125, 155, 100, 25);

        JButton okButton = new JButton(saveImage);
        okButton.setBounds(320, 0, 30, 29);
        okButton.setBackground(lightgrey);
        JButton deleteButton = new JButton(deleteImage);
        deleteButton.setBounds(350, 0, 30, 29);
        deleteButton.setBackground(lightgrey);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update data in the table
                if (nameField.getSelectedItem() != null && reqQuantity.getText().length() != 0 && Integer.parseInt(reqQuantity.getText()) != 0) {
                    enquiryTableModel.setValueAt(myL.sNull(nameField.getSelectedItem().toString()), row, 0);
                    enquiryTableModel.setValueAt(myL.sNull(itemPropertyField.getText()), row, 1);
                    enquiryTableModel.setValueAt(myL.sNull(reqQuantity.getText()), row, 2);
                    enquiryTableModel.setValueAt(myL.sNull(itemUnitField.getText()), row, 3);
                    enquiryTableModel.setValueAt(myL.sNull(remarkField.getText()), row, 4);
                    // Check if the clicked row is the last row (empty row)
                    if (row == enquiryTableModel.getRowCount() - 1) {
                        // Add a new empty row
                        enquiryTableModel.addRow(new Object[]{"", "", "", "", ""});
                    }

                    // Close the popup
                    popupDialog.dispose();

                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (enquiryTableModel.getRowCount() > 1) {
                    // Delete selected row from the table
                    enquiryTableModel.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot delete the last row.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the popup
                popupDialog.dispose();
            }
        });

        // Add components to the popupPanel
        popupPanel.add(nameField);
        popupPanel.add(itemNameL);
        popupPanel.add(itemPropertyField);
        popupPanel.add(itemPropL);
        popupPanel.add(remarkField);
        popupPanel.add(remarkFieldL);
        popupPanel.add(reqQuantity);
        popupPanel.add(reqQtyL);
        popupPanel.add(itemUnitField);
        popupPanel.add(itemUnitL);
        popupControls.add(okButton);
        popupControls.add(deleteButton);
        popupPanel.add(popupControls);

        // Set the size and background color of the popupPanel
        popupPanel.setPreferredSize(new Dimension(400, 200));
        popupPanel.setBackground(Color.WHITE);

        // Add the popupPanel to the popupDialog
        popupDialog.add(popupPanel);

        // Set the location of the popupDialog
        popupDialog.setLocation(x, y);

        // Set the size of the popupDialog
        popupDialog.setSize(400, 400);

        // Make the popupDialog visible
        popupDialog.setVisible(true);

        nameField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String[] recievedArray = ic.getItem(nameField.getSelectedItem().toString());
                itemPropertyField.setText(recievedArray[0]);
                itemUnitField.setText(recievedArray[1]);
            }
        });
    }

    private ArrayList<Object[]> getDataFromEnquiryTable() {
        ArrayList<Object[]> data = new ArrayList<>();

        for (int i = 0; i < enquiryTableModel.getRowCount(); i++) {
            String itemname = (String) enquiryTableModel.getValueAt(i, 0);
            String itemProperties = (String) enquiryTableModel.getValueAt(i, 1);
            String unit = (String) enquiryTableModel.getValueAt(i, 2);
            String reqUnit = (String) enquiryTableModel.getValueAt(i, 3);
            String remark = (String) enquiryTableModel.getValueAt(i, 4);
            data.add(new Object[]{itemname, itemProperties, unit, reqUnit, remark});
        }

        return data;
    }

    private void clearEnquiryTable() {
        // Clear the table
        enquiryTableModel.setRowCount(0);
        // Add an empty row
        enquiryTableModel.addRow(new Object[]{"", "", "", "", "", ""});
    }
// =======================================Enquiry Party table ====================================== //

    public JScrollPane enquiryPartyTable() {
        MyLibrary myL = new MyLibrary();

        // Create JTable with headers
        String[] columnNames = {"Supplier", "City"};
        enquiryPartyTableModel = new DefaultTableModel(columnNames, 1) {// Add an empty row
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        enquirypartytable = new JTable(enquiryPartyTableModel);

        // Create JScrollPane and add JTable to it
        JScrollPane scrollPane = new JScrollPane(enquirypartytable);
        scrollPane.setBounds(25, 460, 645, 240);
        enquiryFrame.add(scrollPane);

        JTableHeader header = enquirypartytable.getTableHeader();
        header.setBackground(maingreen); // Set background color
        header.setForeground(Color.WHITE);

        enquirypartytable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        enquirypartytable.setRowHeight(25);
        enquirypartytable.setAutoscrolls(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 25));

        // Add click event to the table
        enquirypartytable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = enquirypartytable.rowAtPoint(evt.getPoint());
                int col = enquirypartytable.columnAtPoint(evt.getPoint());

                if (evt.getClickCount() == 1) {
                    // Check if the clicked row is the last row (empty row)
                    if (row == enquiryPartyTableModel.getRowCount() - 1) {
                        // Clicked on the last row
                        showPopupEnquiryParty(evt.getX(), evt.getY(), row);
                    } else {
                        // Clicked on an existing row
                        showPopupEnquiryParty(evt.getX(), evt.getY(), row);
                    }
                } else {
                }
            }
        });

        // Display the JFrame
        enquirypartytable.setVisible(true);

        return scrollPane;
    }

    private void showPopupEnquiryParty(int x, int y, int row) {
        MyLibrary myL = new MyLibrary();
        Enquiry ic = new Enquiry();

        ArrayList<String> itemList = new ArrayList<String>();
        itemList.addAll(ic.getPartyList());
        String[] itemRecieved = itemList.toArray(new String[itemList.size()]);

        ImageIcon saveImage, deleteImage;

        deleteImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\delete.png");
        saveImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\save.png");

        // Get data from the selected row
        String supplierString = (String) enquiryPartyTableModel.getValueAt(row, 0);
        String cityString = (String) enquiryPartyTableModel.getValueAt(row, 1);

        // Create a JDialog for the popup content
        JDialog popupDialog = new JDialog();
        JPanel popupPanel = new JPanel(null);
        popupPanel.setBounds(0, 0, 400, 200);

        JPanel popupControls = new JPanel(null);
        popupControls.setBounds(0, 0, 400, 29);
        popupControls.setBackground(lightgrey);

        JLabel supplierL = new JLabel("Supplier");
        supplierL.setBounds(25, 35, 100, 25);
        JComboBox supplier = myL.createSpecialJComboBox(itemRecieved, true);
        supplier.setBounds(125, 35, 250, 25);
        supplier.setSelectedItem(supplierString);

        JLabel cityL = new JLabel("City");
        cityL.setBounds(25, 65, 100, 25);
        JTextField city = new JTextField(cityString);
        city.setBounds(125, 65, 250, 25);
        city.setEditable(false);

        JButton okButton = new JButton(saveImage);
        okButton.setBounds(320, 0, 30, 29);
        okButton.setBackground(lightgrey);
        JButton deleteButton = new JButton(deleteImage);
        deleteButton.setBounds(350, 0, 30, 29);
        deleteButton.setBackground(lightgrey);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update data in the table
                if (supplier.getSelectedItem() != null && city.getText().length() != 0) {
                    String selectedSupplier = myL.sNull(supplier.getSelectedItem().toString());
                    String selectedCity = myL.sNull(city.getText());

                    if (!isSupplierAlreadyPresent(selectedSupplier)) {
                        // Set the value only if the supplier is not already present
                        enquiryPartyTableModel.setValueAt(selectedSupplier, row, 0);
                        enquiryPartyTableModel.setValueAt(selectedCity, row, 1);
                        // Check if the clicked row is the last row (empty row)
                        if (row == enquiryPartyTableModel.getRowCount() - 1) {
                            // Add a new empty row
                            enquiryPartyTableModel.addRow(new Object[]{"", ""});
                        }

                    } else {
                        // Handle the case where the supplier is already present (display a message or take appropriate action)
                        // For example:
                        JOptionPane.showMessageDialog(enquiryFrame, "Supplier Already Exists");
                    }

                    // Close the popup
                    popupDialog.dispose();

                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (enquiryPartyTableModel.getRowCount() > 1) {
                    // Delete selected row from the table
                    enquiryPartyTableModel.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot delete the last row.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the popup
                popupDialog.dispose();
            }
        });

        // Add components to the popupPanel
        popupPanel.add(supplier);
        popupPanel.add(supplierL);
        popupPanel.add(cityL);
        popupPanel.add(city);
        popupControls.add(okButton);
        popupControls.add(deleteButton);
        popupPanel.add(popupControls);

        // Set the size and background color of the popupPanel
        popupPanel.setPreferredSize(new Dimension(400, 200));
        popupPanel.setBackground(Color.WHITE);

        // Add the popupPanel to the popupDialog
        popupDialog.add(popupPanel);

        // Set the location of the popupDialog
        popupDialog.setLocation(x, y);

        // Set the size of the popupDialog
        popupDialog.setSize(400, 200);

        // Make the popupDialog visible
        popupDialog.setVisible(true);

        supplier.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String recieved = ic.getPartyCity(supplier.getSelectedItem().toString());
                city.setText(recieved);
            }
        });
    }

    private boolean isSupplierAlreadyPresent(String supplierName) {
        int rowCount = enquiryPartyTableModel.getRowCount();

        if (rowCount > 1) {
            for (int i = 0; i < rowCount; i++) {
                String existingSupplier = enquiryPartyTableModel.getValueAt(i, 0).toString();

                // Compare the existing supplier with the new supplier
                if (existingSupplier.equals(supplierName)) {
                    return true; // Supplier is already present
                }
            }
        }
        return false; // Supplier is not present
    }

    private ArrayList<Object[]> getDataFromEnquiryPartyTable() {
        ArrayList<Object[]> data = new ArrayList<>();

        for (int i = 0; i < enquiryPartyTableModel.getRowCount(); i++) {
            String supplier = (String) enquiryPartyTableModel.getValueAt(i, 0);
            String city = (String) enquiryPartyTableModel.getValueAt(i, 1);
            data.add(new Object[]{supplier, city});
        }

        return data;
    }

    private void clearEnquiryPartyTable() {
        // Clear the table
        enquiryPartyTableModel.setRowCount(0);
        // Add an empty row
        enquiryPartyTableModel.addRow(new Object[]{"", ""});
    }

    // helping functions for Enquiry //
    public void revalidateEnquiry() {
        enquiryFrame.repaint();
        enquiryFrame.revalidate();
    }

    public void enquiryClear() {
        enquiryDepartment.setSelectedIndex(0);
        enquiryType.setSelectedIndex(0);
        enquiryRemark.setText("");
        enquiryNo.setText("");
        enquiryDate.setText(formattedDate1);
        entryPointEnquiry.txtCreatedBy.setText("");
        entryPointEnquiry.txtModifiedBy.setText("");
    }

    private void setEditableFieldEnquiry() {
        enquiryIndent.setEditable(true);
        enquiryRemark.setEditable(true);
        enquiryType.setEditable(true);
        enquiryDepartment.setEditable(true);
        enquirytable.setEnabled(true);
        enquirypartytable.setEnabled(true);
    }

    private void setUneditableFieldEnquiry() {
        enquiryIndent.setEditable(false);
        enquiryRemark.setEditable(false);
        enquiryType.setEditable(false);
        enquiryDepartment.setEditable(false);
        enquirytable.setEnabled(false);
        enquirypartytable.setEnabled(false);
    }

    //<------------------------------**** PO STARTS ****-------------------------------->//
    public JFrame addPOFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        Indent ic = new Indent();
        String[] pOTypeArray = new String[]{"PO", "Service PO"};
        String[] gstTransaction = new String[]{"Inter State", "Intra State"};

        ArrayList<String> requisitionList = new ArrayList<String>();
        ArrayList<String> departmentList = new ArrayList<String>();
        ArrayList<String> states = new ArrayList<String>();

        states.addAll(ic.getCityList());
        departmentList.addAll(ic.getDepartmentList());
        requisitionList.addAll(ic.getRequisition());

        String[] statesRecieved = states.toArray(new String[states.size()]);
        String[] departmentRecieved = departmentList.toArray(new String[departmentList.size()]);
        String[] requistionRecieved = requisitionList.toArray(new String[requisitionList.size()]);

        entryPointPO.setFormPanelHeightBounds(750);
        pOFrame = entryPointPO.addFrame();

        JPanel formPanel = new JPanel(null);

        pOTypeL = new JLabel("PO Type");
        pOTypeL.setBounds(25, 45, 100, 25);

        pOType = myL.createSpecialJComboBox(pOTypeArray, true);
        pOType.setBounds(150, 45, 515, 25);
        pOType.setEditable(false);

        pONoL = new JLabel("PO No.");
        pONoL.setBounds(25, 75, 100, 25);

        pONo = myL.createSpecialJTextField(20, true);
        pONo.setBounds(150, 75, 515, 25);
        pONo.setEditable(false);

        pOGSTTransactionL = new JLabel("GST Transaction");
        pOGSTTransactionL.setBounds(25, 105, 100, 25);

        pOGSTTransaction = myL.createSpecialJComboBox(gstTransaction, true);
        pOGSTTransaction.setBounds(150, 105, 150, 25);
        pOGSTTransaction.setEditable(false);

        pOStateL = new JLabel("State");
        pOStateL.setBounds(330, 105, 100, 25);

        pOState = myL.createSpecialJComboBox(statesRecieved, true);
        pOState.setBounds(455, 105, 210, 25);
        pOState.setEditable(false);

        pOReferenceNoL = new JLabel("Reference Number");
        pOReferenceNoL.setBounds(25, 135, 150, 25);

        pOReferenceNo = myL.createSpecialJTextField(20, true);
        pOReferenceNo.setBounds(150, 135, 515, 25);
        pOReferenceNo.setEditable(false);

        pODateL = new JLabel("Date");
        pODateL.setBounds(25, 165, 100, 25);

        pODate = myL.createSpecialJTextField(20, true);
        pODate.setBounds(150, 165, 515, 25);
        pODate.setEditable(false);
        pODate.setText(formattedDate1);

        pOEnquiryL = new JLabel("Enquiry No.");
        pOEnquiryL.setBounds(690, 45, 100, 25);

        pOEnquiry = myL.createSpecialJComboBox(departmentRecieved, true);
        pOEnquiry.setBounds(800, 45, 515, 25);
        pOEnquiry.setEditable(false);

        pOAmendmentL = new JLabel("Amendment Order");
        pOAmendmentL.setBounds(690, 75, 150, 25);

        pOAmendment = myL.createSpecialJComboBox(requistionRecieved, true);
        pOAmendment.setBounds(800, 75, 515, 25);
        pOAmendment.setEditable(false);

        pOAmendmentDateL = new JLabel(" AO Date");
        pOAmendmentDateL.setBounds(690, 105, 100, 25);

        pOAmendmentDate = myL.createSpecialJTextField(20, false);
        pOAmendmentDate.setBounds(800, 105, 515, 25);
        pOAmendmentDate.setEditable(false);

        pOSupplierL = new JLabel("Supplier");
        pOSupplierL.setBounds(690, 135, 100, 25);

        pOSupplier = myL.createSpecialJComboBox(requistionRecieved, true);
        pOSupplier.setBounds(800, 135, 515, 25);
        pOSupplier.setEditable(false);

        //////////////////////////////////////Total Bar and menu//////////////////////////////////////////////////////
        Color formPanelBlueColor = new Color(81, 99, 149);
        Border emptyborder = new EmptyBorder(624, 122, 0, 122);
// Creating totalPanel
        JPanel totalPanel = new JPanel(null);
        totalPanel.setBounds(690, 672, 625, 27);
        totalPanel.setBackground(formPanelBlueColor);
        totalPanel.setVisible(true);

        JLabel totalL = new JLabel("NET AMOUNT");
        totalL.setBounds(10, 5, 150, 25);
        totalL.setFont(new Font("Arial", Font.BOLD, 16));
        totalL.setForeground(Color.WHITE);
        totalPanel.add(totalL);

        JLabel totalAmountL = new JLabel("0.00");
        totalAmountL.setBounds(473, 5, 140, 25);
        totalAmountL.setFont(new Font("Arial", Font.BOLD, 16));
        totalAmountL.setForeground(Color.WHITE);
        totalAmountL.setHorizontalAlignment(SwingConstants.RIGHT);
        totalPanel.add(totalAmountL);

// Creating calcPanel
        JPanel calcPanel = new JPanel(null);
        calcPanel.setBounds(690, 550, 624, 122); // Set the preferred size
        calcPanel.setBackground(Color.WHITE);
        calcPanel.setVisible(true);
        Border emptyBorder = new MatteBorder(1, 1, 0, 1, Color.BLACK); // Adjust these values
        calcPanel.setBorder(emptyBorder);
        // Adding to calcPanel

        JTextField goodsValue = new JTextField("0");
        goodsValue.setBounds(120, 5, 180, 25);
        goodsValue.setEditable(false);
        goodsValue.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField serviceValue = new JTextField("0");
        serviceValue.setBounds(120, 35, 180, 25);
        serviceValue.setEditable(false);
        serviceValue.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField discount = new JTextField("0");
        discount.setBounds(120, 65, 180, 25);
        discount.setEditable(false);
        discount.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField taxableValue = new JTextField("0");
        taxableValue.setBounds(120, 95, 180, 25);
        taxableValue.setEditable(false);
        taxableValue.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField SGST = new JTextField("0");
        SGST.setBounds(433, 5, 180, 25);
        SGST.setEditable(false);
        SGST.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField CGST = new JTextField("0");
        CGST.setBounds(433, 35, 180, 25);
        CGST.setEditable(false);
        CGST.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField amount = new JTextField("0");
        amount.setBounds(433, 65, 180, 25);
        amount.setEditable(false);
        amount.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField roundOff = new JTextField("0");
        roundOff.setBounds(433, 95, 180, 25);
        roundOff.setEditable(false);
        roundOff.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel goodsValueL = new JLabel("Goods Value");
        goodsValueL.setBounds(10, 5, 100, 25);
        calcPanel.add(goodsValueL);
        calcPanel.add(goodsValue);

        JLabel serviceValueL = new JLabel("Service Value");
        serviceValueL.setBounds(10, 35, 100, 25);
        calcPanel.add(serviceValueL);
        calcPanel.add(serviceValue);

        JLabel discountL = new JLabel("Discount");
        discountL.setBounds(10, 65, 100, 25);
        calcPanel.add(discountL);
        calcPanel.add(discount);

        JLabel taxableValueL = new JLabel("Taxable Value");
        taxableValueL.setBounds(10, 95, 100, 25);
        calcPanel.add(taxableValueL);
        calcPanel.add(taxableValue);

        JLabel SGSTL = new JLabel("SGST");
        SGSTL.setBounds(323, 5, 100, 25);
        calcPanel.add(SGSTL);
        calcPanel.add(SGST);

        JLabel CGSTL = new JLabel("CGST");
        CGSTL.setBounds(323, 35, 100, 25);
        calcPanel.add(CGSTL);
        calcPanel.add(CGST);

        JLabel amountL = new JLabel("Amount");
        amountL.setBounds(323, 65, 100, 25);
        calcPanel.add(amountL);
        calcPanel.add(amount);

        JLabel roundOffL = new JLabel("Round Off");
        roundOffL.setBounds(323, 95, 100, 25);
        calcPanel.add(roundOffL);
        calcPanel.add(roundOff);

        //////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        entryPointPO.setFormName("Purchase Order");
        entryPointPO.getFrame.setTitle("Purchase Order");

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(3, 1));
        searchPanel.setBounds(500, 500, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JDialog popupDialog = new JDialog();
        popupDialog.setBounds(500, 500, 200, 200);
        popupDialog.add(searchPanel);

        JRadioButton searchByCode = new JRadioButton("Search by Code");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        entryPointPO.getFormPanel.add(pOAmendment);
        entryPointPO.getFormPanel.add(pOAmendmentDate);
        entryPointPO.getFormPanel.add(pODate);
        entryPointPO.getFormPanel.add(pOEnquiry);
        entryPointPO.getFormPanel.add(pOGSTTransaction);
        entryPointPO.getFormPanel.add(pONo);
        entryPointPO.getFormPanel.add(pOReferenceNo);
        entryPointPO.getFormPanel.add(pOState);
        entryPointPO.getFormPanel.add(pOSupplier);
        entryPointPO.getFormPanel.add(pOType);
        entryPointPO.getFormPanel.add(pOAmendmentL);
        entryPointPO.getFormPanel.add(pOAmendmentDateL);
        entryPointPO.getFormPanel.add(pODateL);
        entryPointPO.getFormPanel.add(pOEnquiryL);
        entryPointPO.getFormPanel.add(pOGSTTransactionL);
        entryPointPO.getFormPanel.add(pONoL);
        entryPointPO.getFormPanel.add(pOReferenceNoL);
        entryPointPO.getFormPanel.add(pOStateL);
        entryPointPO.getFormPanel.add(pOSupplierL);
        entryPointPO.getFormPanel.add(pOTypeL);
        entryPointPO.getFormPanel.add(pOTable());
        entryPointPO.getFormPanel.add(pOServiceTable());
        entryPointPO.getFormPanel.add(totalPanel);
        entryPointPO.getFormPanel.add(calcPanel);
        pOtable.setEnabled(false);

        entryPointPO.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    IndentClear();
                    setEditableFieldIndent();
                    entryPointIndent.control.saveButton.setEnabled(true);
                    entryPointIndent.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setEditableFieldIndent();
                    entryPointIndent.control.searchButton.setEnabled(true);
                    entryPointIndent.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointPO.control.deleteButton.setEnabled(false);
        entryPointPO.control.printButton.setEnabled(false);
        entryPointPO.control.editButton.setEnabled(false);
        entryPointPO.control.saveButton.setEnabled(false);

        entryPointPO.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = ic.chkVld(indentRemark);
                ArrayList<Object[]> list = getDataFromIndentTable();
                if (isValid) {
                    if (entryPointIndent.control.editButton.isEnabled()) {
                        if (list.size() > 1) {
                            addButtonFlag = false;
                            ic.saveRecord(indentType, indentor, indentDepartment, indentRequisition,
                                    indentDate, indentRemark, moverecCodeforIndent, addButtonFlag, list);
                            entryPointIndent.control.addButton.setEnabled(true);
                            entryPointIndent.control.editButton.setEnabled(false);
                            addButtonFlag = true;
                            if (!duplicate) {
                                IndentClear();
                                clearIndentTable();
                            }
                        }
                    } else {
                        if (list.size() > 1) {

                            addButtonFlag = true;
                            ic.saveRecord(indentType, indentor, indentDepartment, indentRequisition,
                                    indentDate, indentRemark, moverecCodeforIndent, addButtonFlag, list);

                            if (!duplicate) {
                                IndentClear();
                                clearIndentTable();
                            }
                        }
                    }
                }
            }
        });
        entryPointPO.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldIndent();
                entryPointIndent.control.addButton.setEnabled(true);
                entryPointIndent.control.deleteButton.setEnabled(false);
                entryPointIndent.control.printButton.setEnabled(false);
                entryPointIndent.control.searchButton.setEnabled(false);
            }
        });
        entryPointPO.control.searchButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearIndentTable();
                IndentClear();
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    popupDialog.setVisible(true);
                    entryPointIndent.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateIndent();
                    popupDialog.revalidate();
                    popupDialog.repaint();

                } else if (!searchflag) {
                    popupDialog.dispose();
                    entryPointIndent.control.addButton.setEnabled(true);
                    entryPointIndent.control.deleteButton.setEnabled(false);
                    entryPointIndent.control.printButton.setEnabled(false);
                    entryPointIndent.control.editButton.setEnabled(false);
                    setUneditableFieldIndent();

                    revalidateIndent();
                    popupDialog.revalidate();
                    popupDialog.repaint();

                    searchflag = true;
                }
            }
        });
        searchByCode.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Indent Code");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);
                    popupDialog.revalidate();
                    popupDialog.repaint();

                    revalidateIndent();

                    indentSearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            ArrayList<Object[]> retrievedData = ic.moverec(searchfield.getText(), indentSearchby, indentModel);

                            if (indentModel.isStatus()) {

                                moverecCodeforIndent = indentModel.getCode();

                                indentRemark.setText(myLib.sNull(indentModel.getTxtRemark()));
                                indentDate.setText(myLib.sNull(indentModel.getTxtDate()));
                                indentNo.setText(myLib.sNull(indentModel.getTxtIndentNo()));
                                indentor.setSelectedItem(myLib.sNull(indentModel.getTxtIndentor()));
                                indentType.setSelectedItem(myLib.sNull(indentModel.getTxtIndentType()));
                                indentDepartment.setSelectedItem(myLib.sNull(indentModel.getTxtIndentDepartment()));
                                indentRequisition.setSelectedItem(myLib.sNull(indentModel.getTxtRequiition()));

                                /////////////////////////////////////////////////////////////////////////////////////////
                                indentTableModel.setRowCount(0);

                                for (Object[] rowData : retrievedData) {
                                    indentTableModel.addRow(rowData);
                                }
                                /////////////////////////////////////////////////////////////////////////////////////////                                

                                String createdon = myLib.sNull(indentModel.getCreatedOn());
                                String modifiedon = myLib.sNull(indentModel.getModifiedOn());
                                entryPointIndent.txtCreatedBy.setText(createdon);
                                entryPointIndent.txtModifiedBy.setText(modifiedon);

                                entryPointIndent.getFormPanel.remove(popupDialog);
                                popupDialog.dispose();
                                popupDialog.revalidate();
                                popupDialog.repaint();

                                revalidateIndent();

                                entryPointIndent.control.editButton.setEnabled(true);
                                entryPointIndent.control.deleteButton.setEnabled(true);
                                entryPointIndent.control.printButton.setEnabled(true);
                                entryPointIndent.control.saveButton.setEnabled(true);
                            }
                        }
                    });
                }
            }
        });
        entryPointPO.control.deleteButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ic.deleteRecord(moverecCodeforIndent);
                clearIndentTable();

                entryPointIndent.control.editButton.setEnabled(false);
                entryPointIndent.control.deleteButton.setEnabled(false);
                entryPointIndent.control.printButton.setEnabled(false);
                entryPointIndent.control.saveButton.setEnabled(false);
                entryPointIndent.control.addButton.setEnabled(true);
                entryPointIndent.control.searchButton.setEnabled(true);
                IndentClear();
            }
        });
        entryPointPO.control.printButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ic.prnRecord(moverecCodeforIndent);
            }
        });
        pOEnquiry.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (!indentRequisition.getSelectedItem().toString().equals("")) {
                    String s = indentRequisition.getSelectedItem().toString();
                    ArrayList<Object[]> retrievedData = ic.getRequisitionDetailsAll(indentRequisition.getSelectedItem().toString(), indentModel);
                    indentTableModel.setRowCount(0);
                    for (Object[] rowData : retrievedData) {
                        indentTableModel.addRow(rowData);
                    }
                }
            }
        });

        return pOFrame;
    }

// =======================================PO table ====================================== //
    public JScrollPane pOTable() {
        MyLibrary myL = new MyLibrary();

        // Create JTable with headers
        String[] columnNames = {"Item Name", "Properties", "SKU", "Order Quantity", "Unit", "Rate", "Discount", "Amount", "Remark"};
        pOTableModel = new DefaultTableModel(columnNames, 1) {// Add an empty row
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        pOtable = new JTable(pOTableModel);

        // Create JScrollPane and add JTable to it
        JScrollPane scrollPane = new JScrollPane(pOtable);
        scrollPane.setBounds(25, 200, 1290, 340);
        pOFrame.add(scrollPane);

        JTableHeader header = pOtable.getTableHeader();
        header.setBackground(maingreen); // Set background color
        header.setForeground(Color.WHITE);

        pOtable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pOtable.setRowHeight(20);
        pOtable.setAutoscrolls(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 25));

        // Add click event to the table
        pOtable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = pOtable.rowAtPoint(evt.getPoint());
                int col = pOtable.columnAtPoint(evt.getPoint());

                if (evt.getClickCount() == 1) {
                    // Check if the clicked row is the last row (empty row)
                    if (row == pOTableModel.getRowCount() - 1) {
                        // Clicked on the last row
                        showPopupPO(evt.getX(), evt.getY(), row);
                    } else {
                        // Clicked on an existing row
                        showPopupPO(evt.getX(), evt.getY(), row);
                    }
                } else {
                }
            }
        });

        // Display the JFrame
        pOtable.setVisible(true);

        return scrollPane;
    }

    private void showPopupPO(int x, int y, int row) {
        MyLibrary myL = new MyLibrary();
        Requisition ic = new Requisition();

        ArrayList<String> itemList = new ArrayList<String>();
        itemList.addAll(ic.getItemList());
        String[] itemRecieved = itemList.toArray(new String[itemList.size()]);

        ImageIcon saveImage, deleteImage;

        deleteImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\delete.png");
        saveImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\save.png");

        // Get data from the selected row
        String itemName = (String) pOTableModel.getValueAt(row, 0);
        String itemProperty = (String) pOTableModel.getValueAt(row, 1);
        String reqQty = (String) pOTableModel.getValueAt(row, 2);
        String itemUnit = (String) pOTableModel.getValueAt(row, 3);
        String remark = (String) pOTableModel.getValueAt(row, 4);
        String Sku = "0";

        // Create a JDialog for the popup content
        JDialog popupDialog = new JDialog();
        JPanel popupPanel = new JPanel(null);
        popupPanel.setBounds(0, 0, 600, 300);

        JPanel popupControls = new JPanel(null);
        popupControls.setBounds(0, 0, 600, 29);
        popupControls.setBackground(lightgrey);

        JLabel itemNameL = new JLabel("Item Name");
        itemNameL.setBounds(5, 35, 100, 25);
        JComboBox nameField = myL.createSpecialJComboBox(itemRecieved, true);
        nameField.setBounds(110, 35, 180, 25);
        nameField.setSelectedItem(itemName);

        JLabel itemPropL = new JLabel("Properties");
        itemPropL.setBounds(5, 65, 100, 25);
        JTextField itemPropertyField = new JTextField(itemProperty);
        itemPropertyField.setBounds(110, 65, 180, 25);
        itemPropertyField.setEditable(false);

        JLabel skuL = new JLabel("SKU");
        skuL.setBounds(5, 95, 100, 25);
        JTextField sku = new JTextField(Sku);
        sku.setText(reqQty);
        sku.setBounds(110, 95, 180, 25);
        sku.setEditable(false);

        JLabel itemUnitL = new JLabel("Unit");
        itemUnitL.setBounds(5, 125, 100, 25);
        JTextField itemUnitField = new JTextField(itemUnit);
        itemUnitField.setBounds(110, 125, 180, 25);
        itemUnitField.setEditable(false);

        JLabel quantityL = new JLabel("Quantity");
        quantityL.setBounds(5, 155, 100, 25);
        JTextField quantity = myL.createNumericTextFieldWithLimit(20, 10, true);
        quantity.setBounds(110, 155, 180, 25);

        JLabel rateL = new JLabel("Rate");
        rateL.setBounds(5, 185, 100, 25);
        JTextField rate = myL.createNumericTextFieldWithLimit(20, 10, true);
        rate.setBounds(110, 185, 180, 25);

        JLabel gAL = new JLabel("Gross Amount");
        gAL.setBounds(300, 35, 100, 25);
        JTextField gA = myL.createNumericTextFieldWithLimit(20, 100, true);
        gA.setBounds(410, 35, 180, 25);
        gA.setEditable(false);

        JLabel discountL = new JLabel("Discount");
        discountL.setBounds(300, 65, 100, 25);
        JTextField discount = myL.createNumericTextFieldWithLimit(20, 2, true);
        discount.setBounds(410, 65, 180, 25);

        JLabel taxL = new JLabel("Taxable Value");
        taxL.setBounds(300, 95, 100, 25);
        JTextField tax = new JTextField();
        tax.setBounds(410, 95, 180, 25);
        tax.setEditable(false);

        JLabel SGSTL = new JLabel("SGST");
        SGSTL.setBounds(300, 125, 100, 25);
        JTextField SGST = new JTextField("0");
        SGST.setBounds(410, 125, 180, 25);
        SGST.setEditable(false);

        JLabel CGSTL = new JLabel("CGST");
        CGSTL.setBounds(300, 155, 100, 25);
        JTextField CGST = new JTextField("0");
        CGST.setBounds(410, 155, 180, 25);
        CGST.setEditable(false);

        JLabel valueL = new JLabel("Value");
        valueL.setBounds(300, 185, 100, 25);
        JTextField value = myL.createNumericTextFieldWithLimit(20, 10, true);
        value.setBounds(410, 185, 180, 25);
        value.setEditable(false);

        JLabel remarkFieldL = new JLabel("Remark");
        remarkFieldL.setBounds(5, 215, 100, 25);
        JTextField remarkField = new JTextField(remark);
        remarkField.setBounds(110, 215, 480, 25);

        JButton okButton = new JButton(saveImage);
        okButton.setBounds(520, 0, 30, 29);
        okButton.setBackground(lightgrey);
        JButton deleteButton = new JButton(deleteImage);
        deleteButton.setBounds(550, 0, 30, 29);
        deleteButton.setBackground(lightgrey);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update data in the table
                if (nameField.getSelectedItem() != null && reqQuantity.getText().length() != 0 && Integer.parseInt(reqQuantity.getText()) != 0) {
                    indentTableModel.setValueAt(myL.sNull(nameField.getSelectedItem().toString()), row, 0);
                    indentTableModel.setValueAt(myL.sNull(itemPropertyField.getText()), row, 1);
                    indentTableModel.setValueAt(myL.sNull(reqQuantity.getText()), row, 2);
                    indentTableModel.setValueAt(myL.sNull(itemUnitField.getText()), row, 3);
                    indentTableModel.setValueAt(myL.sNull(remarkField.getText()), row, 4);
                    // Check if the clicked row is the last row (empty row)
                    if (row == indentTableModel.getRowCount() - 1) {
                        // Add a new empty row
                        indentTableModel.addRow(new Object[]{"", "", "", "", ""});
                    }

                    // Close the popup
                    popupDialog.dispose();

                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indentTableModel.getRowCount() > 1) {
                    // Delete selected row from the table
                    indentTableModel.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot delete the last row.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the popup
                popupDialog.dispose();
            }
        });

        // Add components to the popupPanel
        popupControls.add(okButton);
        popupControls.add(deleteButton);
        popupPanel.add(nameField);
        popupPanel.add(itemNameL);
        popupPanel.add(itemPropertyField);
        popupPanel.add(itemPropL);
        popupPanel.add(remarkField);
        popupPanel.add(remarkFieldL);
        popupPanel.add(skuL);
        popupPanel.add(sku);
        popupPanel.add(quantityL);
        popupPanel.add(quantity);
        popupPanel.add(rateL);
        popupPanel.add(rate);
        popupPanel.add(gAL);
        popupPanel.add(gA);
        popupPanel.add(discountL);
        popupPanel.add(discount);
        popupPanel.add(SGSTL);
        popupPanel.add(SGST);
        popupPanel.add(CGST);
        popupPanel.add(CGSTL);
        popupPanel.add(valueL);
        popupPanel.add(taxL);
        popupPanel.add(tax);
        popupPanel.add(value);
        popupPanel.add(itemUnitField);
        popupPanel.add(itemUnitL);
        popupPanel.add(popupControls);

        // Set the size and background color of the popupPanel
        popupPanel.setPreferredSize(new Dimension(400, 200));
        popupPanel.setBackground(Color.WHITE);

        // Add the popupPanel to the popupDialog
        popupDialog.add(popupPanel);

        // Set the location of the popupDialog
        popupDialog.setLocation(x, y);

        // Set the size of the popupDialog
        popupDialog.setSize(600, 300);

        popupDialog.setResizable(false);

        // Make the popupDialog visible
        popupDialog.setVisible(true);

        nameField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String[] recievedArray = ic.getItem(nameField.getSelectedItem().toString());
                itemPropertyField.setText(recievedArray[0]);
                itemUnitField.setText(recievedArray[1]);
            }
        });
    }

    private ArrayList<Object[]> getDataFromPOTable() {
        ArrayList<Object[]> data = new ArrayList<>();

        for (int i = 0; i < indentTableModel.getRowCount(); i++) {
            String itemname = (String) indentTableModel.getValueAt(i, 0);
            String itemProperties = (String) indentTableModel.getValueAt(i, 1);
            String unit = (String) indentTableModel.getValueAt(i, 2);
            String reqUnit = (String) indentTableModel.getValueAt(i, 3);
            String remark = (String) indentTableModel.getValueAt(i, 4);
            data.add(new Object[]{itemname, itemProperties, unit, reqUnit, remark});
        }

        return data;
    }

    private void clearPOTable() {
        // Clear the table
        indentTableModel.setRowCount(0);
        // Add an empty row
        indentTableModel.addRow(new Object[]{"", "", "", "", "", ""});
    }

    // =======================================PO Service table ====================================== //
    public JScrollPane pOServiceTable() {
        MyLibrary myL = new MyLibrary();

        // Create JTable with headers
        String[] columnNames = {"Service", "Amount", "GST@", "SGST", "CGST", "Net Amount"};
        pOServiceTableModel = new DefaultTableModel(columnNames, 1) {// Add an empty row
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        pOServicetable = new JTable(pOServiceTableModel);

        // Create JScrollPane and add JTable to it
        JScrollPane scrollPane = new JScrollPane(pOServicetable);
        scrollPane.setBounds(25, 550, 650, 150);
        pOFrame.add(scrollPane);

        JTableHeader header = pOServicetable.getTableHeader();
        header.setBackground(maingreen); // Set background color
        header.setForeground(Color.WHITE);

        pOServicetable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pOServicetable.setRowHeight(20);
        pOServicetable.setAutoscrolls(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 25));

        // Add click event to the table
        pOServicetable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = pOServicetable.rowAtPoint(evt.getPoint());
                int col = pOServicetable.columnAtPoint(evt.getPoint());

                if (evt.getClickCount() == 1) {
                    // Check if the clicked row is the last row (empty row)
                    if (row == enquiryPartyTableModel.getRowCount() - 1) {
                        // Clicked on the last row
                        showPopupEnquiryParty(evt.getX(), evt.getY(), row);
                    } else {
                        // Clicked on an existing row
                        showPopupEnquiryParty(evt.getX(), evt.getY(), row);
                    }
                } else {
                }
            }
        });

        // Display the JFrame
        pOServicetable.setVisible(true);

        return scrollPane;
    }

    private void showPopupPOService(int x, int y, int row) {
        MyLibrary myL = new MyLibrary();
        Enquiry ic = new Enquiry();

        ArrayList<String> itemList = new ArrayList<String>();
        itemList.addAll(ic.getPartyList());
        String[] itemRecieved = itemList.toArray(new String[itemList.size()]);

        ImageIcon saveImage, deleteImage;

        deleteImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\delete.png");
        saveImage = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\ErpSoftWare\\src\\pictures used\\save.png");

        // Get data from the selected row
        String supplierString = (String) pOServiceTableModel.getValueAt(row, 0);
        String cityString = (String) pOServiceTableModel.getValueAt(row, 1);

        // Create a JDialog for the popup content
        JDialog popupDialog = new JDialog();
        JPanel popupPanel = new JPanel(null);
        popupPanel.setBounds(0, 0, 400, 250);

        JPanel popupControls = new JPanel(null);
        popupControls.setBounds(0, 0, 400, 29);
        popupControls.setBackground(lightgrey);

        JLabel serviceL = new JLabel("Service");
        serviceL.setBounds(25, 25, 100, 25);
        JComboBox service = myL.createSpecialJComboBox(itemRecieved, true);
        service.setBounds(125, 25, 250, 25);
        service.setSelectedItem(supplierString);

        JLabel serviceUnitL = new JLabel("Service Unit");
        serviceUnitL.setBounds(25, 55, 100, 25);
        JTextField serviceUnit = new JTextField(cityString);
        serviceUnit.setBounds(125, 55, 250, 25);
        serviceUnit.setEditable(false);

        JLabel gstTypeL = new JLabel("GST Type");
        gstTypeL.setBounds(25, 85, 100, 25);
        JComboBox gstType = myL.createSpecialJComboBox(itemRecieved, true);
        gstType.setBounds(125, 85, 250, 25);
        gstType.setSelectedItem(supplierString);

        JLabel valueL = new JLabel("Value");
        valueL.setBounds(25, 115, 100, 25);
        JTextField value = new JTextField(cityString);
        value.setBounds(125, 115, 250, 25);
        value.setEditable(false);

        JLabel cgstL = new JLabel("CGST");
        cgstL.setBounds(25, 145, 100, 25);
        JTextField cgst = new JTextField(cityString);
        cgst.setBounds(125, 145, 250, 25);
        cgst.setEditable(false);

        JLabel sgstL = new JLabel("SGST");
        sgstL.setBounds(25, 175, 100, 25);
        JTextField sgst = new JTextField(cityString);
        sgst.setBounds(125, 175, 250, 25);
        sgst.setEditable(false);

        JLabel netAmountL = new JLabel("Net Amount");
        netAmountL.setBounds(25, 205, 100, 25);
        JTextField netAmount = new JTextField(cityString);
        netAmount.setBounds(125, 205, 250, 25);
        netAmount.setEditable(false);

        JButton okButton = new JButton(saveImage);
        okButton.setBounds(320, 0, 30, 29);
        okButton.setBackground(lightgrey);
        JButton deleteButton = new JButton(deleteImage);
        deleteButton.setBounds(350, 0, 30, 29);
        deleteButton.setBackground(lightgrey);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update data in the table
                if (supplier.getSelectedItem() != null && city.getText().length() != 0) {
                    String selectedSupplier = myL.sNull(supplier.getSelectedItem().toString());
                    String selectedCity = myL.sNull(city.getText());

                    if (!isSupplierAlreadyPresent(selectedSupplier)) {
                        // Set the value only if the supplier is not already present
                        enquiryPartyTableModel.setValueAt(selectedSupplier, row, 0);
                        enquiryPartyTableModel.setValueAt(selectedCity, row, 1);
                        // Check if the clicked row is the last row (empty row)
                        if (row == enquiryPartyTableModel.getRowCount() - 1) {
                            // Add a new empty row
                            enquiryPartyTableModel.addRow(new Object[]{"", ""});
                        }

                    } else {
                        // Handle the case where the supplier is already present (display a message or take appropriate action)
                        // For example:
                        JOptionPane.showMessageDialog(enquiryFrame, "Supplier Already Exists");
                    }

                    // Close the popup
                    popupDialog.dispose();

                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (enquiryPartyTableModel.getRowCount() > 1) {
                    // Delete selected row from the table
                    enquiryPartyTableModel.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot delete the last row.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the popup
                popupDialog.dispose();
            }
        });

        // Add components to the popupPanel
        popupPanel.add(serviceL);
        popupPanel.add(serviceUnitL);
        popupPanel.add(gstTypeL);
        popupPanel.add(valueL);
        popupPanel.add(cgstL);
        popupPanel.add(sgstL);
        popupPanel.add(netAmountL);
        popupPanel.add(service);
        popupPanel.add(serviceUnit);
        popupPanel.add(gstType);
        popupPanel.add(value);
        popupPanel.add(cgst);
        popupPanel.add(sgst);
        popupPanel.add(netAmount);

        popupControls.add(okButton);
        popupControls.add(deleteButton);
        popupPanel.add(popupControls);

        // Set the size and background color of the popupPanel
        popupPanel.setPreferredSize(new Dimension(400, 250));
        popupPanel.setBackground(Color.WHITE);

        // Add the popupPanel to the popupDialog
        popupDialog.add(popupPanel);

        // Set the location of the popupDialog
        popupDialog.setLocation(x, y);

        // Set the size of the popupDialog
        popupDialog.setSize(400, 250);

        // Make the popupDialog visible
        popupDialog.setVisible(true);

        service.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String recieved = ic.getPartyCity(service.getSelectedItem().toString());
                city.setText(recieved);
            }
        });
    }

    private boolean isServiceAlreadyPresent(String supplierName) {
        int rowCount = enquiryPartyTableModel.getRowCount();

        if (rowCount > 1) {
            for (int i = 0; i < rowCount; i++) {
                String existingSupplier = enquiryPartyTableModel.getValueAt(i, 0).toString();

                // Compare the existing supplier with the new supplier
                if (existingSupplier.equals(supplierName)) {
                    return true; // Supplier is already present
                }
            }
        }
        return false; // Supplier is not present
    }

    private ArrayList<Object[]> getDataFromPOServiceTable() {
        ArrayList<Object[]> data = new ArrayList<>();

        for (int i = 0; i < enquiryPartyTableModel.getRowCount(); i++) {
            String supplier = (String) enquiryPartyTableModel.getValueAt(i, 0);
            String city = (String) enquiryPartyTableModel.getValueAt(i, 1);
            data.add(new Object[]{supplier, city});
        }

        return data;
    }

    private void clearPOServiceTable() {
        // Clear the table
        enquiryPartyTableModel.setRowCount(0);
        // Add an empty row
        enquiryPartyTableModel.addRow(new Object[]{"", ""});
    }

    // helping functions for PO //
    public void revalidatePO() {
        indentFrame.repaint();
        indentFrame.revalidate();
    }

    public void pOClear() {
        indentDepartment.setSelectedIndex(0);
        indentor.setSelectedIndex(0);
        indentType.setSelectedIndex(0);
        indentRemark.setText("");
        indentNo.setText("");
        indentDate.setText(formattedDate1);
        entryPointIndent.txtCreatedBy.setText("");
        entryPointIndent.txtModifiedBy.setText("");
    }

    private void setEditableFieldPO() {
        indentor.setEditable(true);
        indentRequisition.setEditable(true);
        indentRemark.setEditable(true);
        indentType.setEditable(true);
        indentDepartment.setEditable(true);
        indenttable.setEnabled(true);
    }

    private void setUneditableFieldPO() {
        indentor.setEditable(false);
        indentRequisition.setEditable(false);
        indentRemark.setEditable(false);
        indentType.setEditable(false);
        indentDepartment.setEditable(false);
        indenttable.setEnabled(false);
    }

    ////<<<<------------------==================== DASHBOARD STARTS ====================------------------>>>>////
    //<------------------------------**** SALES BARCHART STARTS ****-------------------------------->//
    public JFrame addSalesBarChartFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        Dashboard dm = new Dashboard();

        entryPointSalesBarChart.setFormPanelHeightBounds(750);
        salesBarFrame = entryPointSalesBarChart.addFrame();

        JPanel formPanel = new JPanel(null);

        salesJanL = new JLabel("January");
        salesJanL.setBounds(200, 100, 100, 25);

        salesJan = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesJan.setBounds(400, 100, 700, 25);
        salesJan.setEditable(false);

        salesfebL = new JLabel("February");
        salesfebL.setBounds(200, 130, 100, 25);

        salesfeb = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesfeb.setBounds(400, 130, 700, 25);
        salesfeb.setEditable(false);

        salesmarL = new JLabel("March");
        salesmarL.setBounds(200, 160, 100, 25);

        salesmar = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesmar.setBounds(400, 160, 700, 25);
        salesmar.setEditable(false);

        salesAprL = new JLabel("April");
        salesAprL.setBounds(200, 190, 100, 25);

        salesApr = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesApr.setBounds(400, 190, 700, 25);
        salesApr.setEditable(false);

        salesmayL = new JLabel("May");
        salesmayL.setBounds(200, 220, 100, 25);

        salesmay = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesmay.setBounds(400, 220, 700, 25);
        salesmay.setEditable(false);

        salesJunL = new JLabel("June");
        salesJunL.setBounds(200, 250, 100, 25);

        salesJun = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesJun.setBounds(400, 250, 700, 25);
        salesJun.setEditable(false);

        salesJulL = new JLabel("July");
        salesJulL.setBounds(200, 280, 700, 25);

        salesJul = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesJul.setBounds(400, 280, 700, 25);
        salesJul.setEditable(false);

        salesaugL = new JLabel("August");
        salesaugL.setBounds(200, 310, 100, 25);

        salesaug = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesaug.setBounds(400, 310, 700, 25);
        salesaug.setEditable(false);

        salessepL = new JLabel("September");
        salessepL.setBounds(200, 340, 100, 25);

        salessep = myL.createNumericTextFieldWithLimit(10, 8, true);
        salessep.setBounds(400, 340, 700, 25);
        salessep.setEditable(false);

        salesoctL = new JLabel("October");
        salesoctL.setBounds(200, 370, 100, 25);

        salesoct = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesoct.setBounds(400, 370, 700, 25);
        salesoct.setEditable(false);

        salesnovL = new JLabel("November");
        salesnovL.setBounds(200, 400, 100, 25);

        salesnov = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesnov.setBounds(400, 400, 700, 25);
        salesnov.setEditable(false);

        salesdecL = new JLabel("December");
        salesdecL.setBounds(200, 430, 100, 25);

        salesdec = myL.createNumericTextFieldWithLimit(10, 8, true);
        salesdec.setBounds(400, 430, 700, 25);
        salesdec.setEditable(false);

        entryPointSalesBarChart.setFormName("Sales Chart(In Crore)");
        entryPointSalesBarChart.getFrame.setTitle("Sales Chart(In Crore)");

        entryPointSalesBarChart.getFormPanel.add(salesJan);
        entryPointSalesBarChart.getFormPanel.add(salesfeb);
        entryPointSalesBarChart.getFormPanel.add(salesmar);
        entryPointSalesBarChart.getFormPanel.add(salesApr);
        entryPointSalesBarChart.getFormPanel.add(salesmay);
        entryPointSalesBarChart.getFormPanel.add(salesJun);
        entryPointSalesBarChart.getFormPanel.add(salesJul);
        entryPointSalesBarChart.getFormPanel.add(salesaug);
        entryPointSalesBarChart.getFormPanel.add(salessep);
        entryPointSalesBarChart.getFormPanel.add(salesoct);
        entryPointSalesBarChart.getFormPanel.add(salesnov);
        entryPointSalesBarChart.getFormPanel.add(salesdec);

        entryPointSalesBarChart.getFormPanel.add(salesJanL);
        entryPointSalesBarChart.getFormPanel.add(salesfebL);
        entryPointSalesBarChart.getFormPanel.add(salesmarL);
        entryPointSalesBarChart.getFormPanel.add(salesAprL);
        entryPointSalesBarChart.getFormPanel.add(salesmayL);
        entryPointSalesBarChart.getFormPanel.add(salesJunL);
        entryPointSalesBarChart.getFormPanel.add(salesJulL);
        entryPointSalesBarChart.getFormPanel.add(salesaugL);
        entryPointSalesBarChart.getFormPanel.add(salessepL);
        entryPointSalesBarChart.getFormPanel.add(salesoctL);
        entryPointSalesBarChart.getFormPanel.add(salesnovL);
        entryPointSalesBarChart.getFormPanel.add(salesdecL);

        MyFocusListener manager = new MyFocusListener(salesJan, salesfeb, salesmar, salesApr, salesmay, salesJun, salesJul, salesaug, salessep, salesoct, salesnov, salesdec);

        BackgroundColorChanger colorChanger = new BackgroundColorChanger(lightblue, Color.WHITE);
        colorChanger.setFocusListeners(salesJan, salesfeb, salesmar, salesApr, salesmay, salesJun, salesJul, salesaug, salessep, salesoct, salesnov, salesdec);

        MyFocusListener setFocusMethod = new MyFocusListener();

        entryPointSalesBarChart.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    salesBarClear();
                    salesbarEditable();
                    salesJan.requestFocus(true);
                    entryPointSalesBarChart.control.saveButton.setEnabled(true);
                    entryPointSalesBarChart.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    salesbarUneditable();
                    entryPointSalesBarChart.control.searchButton.setEnabled(true);
                    entryPointSalesBarChart.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointSalesBarChart.control.deleteButton.setEnabled(false);
        entryPointSalesBarChart.control.printButton.setEnabled(false);
        entryPointSalesBarChart.control.editButton.setEnabled(false);
        entryPointSalesBarChart.control.saveButton.setEnabled(false);

        entryPointSalesBarChart.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dm.chkVld(salesJan, salesfeb, salesmar, salesApr, salesmay, salesJun, salesJul, salesaug, salessep, salesoct, salesnov, salesdec);

                if (isValid) {
                    if (entryPointSalesBarChart.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        salesArrayForBarChart[0] = salesJan.getText();
                        salesArrayForBarChart[1] = salesfeb.getText();
                        salesArrayForBarChart[2] = salesmar.getText();
                        salesArrayForBarChart[3] = salesApr.getText();
                        salesArrayForBarChart[4] = salesmay.getText();
                        salesArrayForBarChart[5] = salesJun.getText();
                        salesArrayForBarChart[6] = salesJul.getText();
                        salesArrayForBarChart[7] = salesaug.getText();
                        salesArrayForBarChart[8] = salessep.getText();
                        salesArrayForBarChart[9] = salesoct.getText();
                        salesArrayForBarChart[10] = salesnov.getText();
                        salesArrayForBarChart[11] = salesdec.getText();
                        dm.saveRecord(salesArrayForBarChart);

                        entryPointSalesBarChart.control.addButton.setEnabled(true);
                        entryPointSalesBarChart.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        salesBarClear();
                        rootpanel.repaint();
                        rootpanel.revalidate();
                        rootLoginPanel.repaint();
                        rootLoginPanel.revalidate();

                    } else {
                        addButtonFlag = true;
                        salesArrayForBarChart[0] = salesJan.getText();
                        salesArrayForBarChart[1] = salesfeb.getText();
                        salesArrayForBarChart[2] = salesmar.getText();
                        salesArrayForBarChart[3] = salesApr.getText();
                        salesArrayForBarChart[4] = salesmay.getText();
                        salesArrayForBarChart[5] = salesJun.getText();
                        salesArrayForBarChart[6] = salesJul.getText();
                        salesArrayForBarChart[7] = salesaug.getText();
                        salesArrayForBarChart[8] = salessep.getText();
                        salesArrayForBarChart[9] = salesoct.getText();
                        salesArrayForBarChart[10] = salesnov.getText();
                        salesArrayForBarChart[11] = salesdec.getText();
                        dm.saveRecord(salesArrayForBarChart);
                        salesBarClear();
                        rootpanel.repaint();
                        rootpanel.revalidate();
                        rootLoginPanel.repaint();
                        rootLoginPanel.revalidate();
                    }
                }
            }
        });

        salesdec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dm.chkVld(salesJan, salesfeb, salesmar, salesApr, salesmay, salesJun, salesJul, salesaug, salessep, salesoct, salesnov, salesdec);

                if (isValid) {
                    if (entryPointSalesBarChart.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        salesArrayForBarChart[0] = salesJan.getText();
                        salesArrayForBarChart[1] = salesfeb.getText();
                        salesArrayForBarChart[2] = salesmar.getText();
                        salesArrayForBarChart[3] = salesApr.getText();
                        salesArrayForBarChart[4] = salesmay.getText();
                        salesArrayForBarChart[5] = salesJun.getText();
                        salesArrayForBarChart[6] = salesJul.getText();
                        salesArrayForBarChart[7] = salesaug.getText();
                        salesArrayForBarChart[8] = salessep.getText();
                        salesArrayForBarChart[9] = salesoct.getText();
                        salesArrayForBarChart[10] = salesnov.getText();
                        salesArrayForBarChart[11] = salesdec.getText();
                        dm.saveRecord(salesArrayForBarChart);
                        salesBarClear();
                        rootpanel.repaint();
                        rootpanel.revalidate();
                        rootLoginPanel.repaint();
                        rootLoginPanel.revalidate();
                        entryPointSalesBarChart.control.addButton.setEnabled(true);
                        entryPointSalesBarChart.control.editButton.setEnabled(false);
                        addButtonFlag = true;

                    } else {
                        addButtonFlag = true;
                        salesArrayForBarChart[0] = salesJan.getText();
                        salesArrayForBarChart[1] = salesfeb.getText();
                        salesArrayForBarChart[2] = salesmar.getText();
                        salesArrayForBarChart[3] = salesApr.getText();
                        salesArrayForBarChart[4] = salesmay.getText();
                        salesArrayForBarChart[5] = salesJun.getText();
                        salesArrayForBarChart[6] = salesJul.getText();
                        salesArrayForBarChart[7] = salesaug.getText();
                        salesArrayForBarChart[8] = salessep.getText();
                        salesArrayForBarChart[9] = salesoct.getText();
                        salesArrayForBarChart[10] = salesnov.getText();
                        salesArrayForBarChart[11] = salesdec.getText();
                        dm.saveRecord(salesArrayForBarChart);
                        salesBarClear();
                        rootpanel.repaint();
                        rootpanel.revalidate();
                        rootLoginPanel.repaint();
                        rootLoginPanel.revalidate();
                    }
                }
            }
        });

        return salesBarFrame;
    }

    public void salesBarClear() {
        (salesJan).setText("");
        (salesfeb).setText("");
        (salesmar).setText("");
        (salesApr).setText("");
        (salesmay).setText("");
        (salesJun).setText("");
        (salesJul).setText("");
        (salesaug).setText("");
        (salessep).setText("");
        (salesoct).setText("");
        (salesnov).setText("");
        (salesdec).setText("");
    }

    public void salesbarEditable() {
        (salesJan).setEditable(true);
        (salesfeb).setEditable(true);
        (salesmar).setEditable(true);
        (salesApr).setEditable(true);
        (salesmay).setEditable(true);
        (salesJun).setEditable(true);
        (salesJul).setEditable(true);
        (salesaug).setEditable(true);
        (salessep).setEditable(true);
        (salesoct).setEditable(true);
        (salesnov).setEditable(true);
        (salesdec).setEditable(true);
    }

    public void salesbarUneditable() {
        (salesJan).setEditable(false);
        (salesfeb).setEditable(false);
        (salesmar).setEditable(false);
        (salesApr).setEditable(false);
        (salesmay).setEditable(false);
        (salesJun).setEditable(false);
        (salesJul).setEditable(false);
        (salesaug).setEditable(false);
        (salessep).setEditable(false);
        (salesoct).setEditable(false);
        (salesnov).setEditable(false);
        (salesdec).setEditable(false);
    }

    //<------------------------------**** SALES BARCHART STARTS ****-------------------------------->//
    public JFrame addpurchaseBarChartFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        Dashboard dm = new Dashboard();

        entryPointPurchaseBarChart.setFormPanelHeightBounds(750);
        purchaseBarFrame = entryPointPurchaseBarChart.addFrame();

        JPanel formPanel = new JPanel(null);

        purchaseJanL = new JLabel("January");
        purchaseJanL.setBounds(200, 100, 100, 25);

        purchaseJan = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchaseJan.setBounds(400, 100, 700, 25);
        purchaseJan.setEditable(false);

        purchasefebL = new JLabel("February");
        purchasefebL.setBounds(200, 130, 100, 25);

        purchasefeb = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchasefeb.setBounds(400, 130, 700, 25);
        purchasefeb.setEditable(false);

        purchasemarL = new JLabel("March");
        purchasemarL.setBounds(200, 160, 100, 25);

        purchasemar = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchasemar.setBounds(400, 160, 700, 25);
        purchasemar.setEditable(false);

        purchaseAprL = new JLabel("April");
        purchaseAprL.setBounds(200, 190, 100, 25);

        purchaseApr = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchaseApr.setBounds(400, 190, 700, 25);
        purchaseApr.setEditable(false);

        purchasemayL = new JLabel("May");
        purchasemayL.setBounds(200, 220, 100, 25);

        purchasemay = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchasemay.setBounds(400, 220, 700, 25);
        purchasemay.setEditable(false);

        purchaseJunL = new JLabel("June");
        purchaseJunL.setBounds(200, 250, 100, 25);

        purchaseJun = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchaseJun.setBounds(400, 250, 700, 25);
        purchaseJun.setEditable(false);

        purchaseJulL = new JLabel("July");
        purchaseJulL.setBounds(200, 280, 700, 25);

        purchaseJul = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchaseJul.setBounds(400, 280, 700, 25);
        purchaseJul.setEditable(false);

        purchaseaugL = new JLabel("August");
        purchaseaugL.setBounds(200, 310, 100, 25);

        purchaseaug = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchaseaug.setBounds(400, 310, 700, 25);
        purchaseaug.setEditable(false);

        purchasesepL = new JLabel("September");
        purchasesepL.setBounds(200, 340, 100, 25);

        purchasesep = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchasesep.setBounds(400, 340, 700, 25);
        purchasesep.setEditable(false);

        purchaseoctL = new JLabel("October");
        purchaseoctL.setBounds(200, 370, 100, 25);

        purchaseoct = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchaseoct.setBounds(400, 370, 700, 25);
        purchaseoct.setEditable(false);

        purchasenovL = new JLabel("November");
        purchasenovL.setBounds(200, 400, 100, 25);

        purchasenov = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchasenov.setBounds(400, 400, 700, 25);
        purchasenov.setEditable(false);

        purchasedecL = new JLabel("December");
        purchasedecL.setBounds(200, 430, 100, 25);

        purchasedec = myL.createNumericTextFieldWithLimit(10, 8, true);
        purchasedec.setBounds(400, 430, 700, 25);
        purchasedec.setEditable(false);

        entryPointPurchaseBarChart.setFormName("Sales Chart(In Crore)");
        entryPointPurchaseBarChart.getFrame.setTitle("Sales Chart(In Crore)");

        entryPointPurchaseBarChart.getFormPanel.add(purchaseJan);
        entryPointPurchaseBarChart.getFormPanel.add(purchasefeb);
        entryPointPurchaseBarChart.getFormPanel.add(purchasemar);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseApr);
        entryPointPurchaseBarChart.getFormPanel.add(purchasemay);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseJun);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseJul);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseaug);
        entryPointPurchaseBarChart.getFormPanel.add(purchasesep);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseoct);
        entryPointPurchaseBarChart.getFormPanel.add(purchasenov);
        entryPointPurchaseBarChart.getFormPanel.add(purchasedec);

        entryPointPurchaseBarChart.getFormPanel.add(purchaseJanL);
        entryPointPurchaseBarChart.getFormPanel.add(purchasefebL);
        entryPointPurchaseBarChart.getFormPanel.add(purchasemarL);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseAprL);
        entryPointPurchaseBarChart.getFormPanel.add(purchasemayL);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseJunL);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseJulL);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseaugL);
        entryPointPurchaseBarChart.getFormPanel.add(purchasesepL);
        entryPointPurchaseBarChart.getFormPanel.add(purchaseoctL);
        entryPointPurchaseBarChart.getFormPanel.add(purchasenovL);
        entryPointPurchaseBarChart.getFormPanel.add(purchasedecL);

        MyFocusListener manager = new MyFocusListener(purchaseJan, purchasefeb, purchasemar, purchaseApr, purchasemay, purchaseJun, purchaseJul, purchaseaug, purchasesep, purchaseoct, purchasenov, purchasedec);

        BackgroundColorChanger colorChanger = new BackgroundColorChanger(lightblue, Color.WHITE);
        colorChanger.setFocusListeners(purchaseJan, purchasefeb, purchasemar, purchaseApr, purchasemay, purchaseJun, purchaseJul, purchaseaug, purchasesep, purchaseoct, purchasenov, purchasedec);

        MyFocusListener setFocusMethod = new MyFocusListener();

        entryPointPurchaseBarChart.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    salesBarClear();
                    purchasebarEditable();
                    salesJan.requestFocus(true);
                    entryPointPurchaseBarChart.control.saveButton.setEnabled(true);
                    entryPointPurchaseBarChart.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    purchasebarUneditable();
                    entryPointPurchaseBarChart.control.searchButton.setEnabled(true);
                    entryPointPurchaseBarChart.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointPurchaseBarChart.control.deleteButton.setEnabled(false);
        entryPointPurchaseBarChart.control.printButton.setEnabled(false);
        entryPointPurchaseBarChart.control.editButton.setEnabled(false);
        entryPointPurchaseBarChart.control.saveButton.setEnabled(false);

        entryPointPurchaseBarChart.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dm.chkVld(purchaseJan, purchasefeb, purchasemar, purchaseApr, purchasemay, purchaseJun, purchaseJul, purchaseaug, purchasesep, purchaseoct, purchasenov, purchasedec);

                if (isValid) {
                    if (entryPointPurchaseBarChart.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        purchaseArrayForBarChart[0] = purchaseJan.getText();
                        purchaseArrayForBarChart[1] = purchasefeb.getText();
                        purchaseArrayForBarChart[2] = purchasemar.getText();
                        purchaseArrayForBarChart[3] = purchaseApr.getText();
                        purchaseArrayForBarChart[4] = purchasemay.getText();
                        purchaseArrayForBarChart[5] = purchaseJun.getText();
                        purchaseArrayForBarChart[6] = purchaseJul.getText();
                        purchaseArrayForBarChart[7] = purchaseaug.getText();
                        purchaseArrayForBarChart[8] = purchasesep.getText();
                        purchaseArrayForBarChart[9] = purchaseoct.getText();
                        purchaseArrayForBarChart[10] = purchasenov.getText();
                        purchaseArrayForBarChart[11] = purchasedec.getText();
                        dm.saveRecordPurchase(purchaseArrayForBarChart);

                        entryPointPurchaseBarChart.control.addButton.setEnabled(true);
                        entryPointPurchaseBarChart.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        purchaseBarClear();
                        rootpanel.repaint();
                        rootpanel.revalidate();
                        rootLoginPanel.repaint();
                        rootLoginPanel.revalidate();

                    } else {
                        addButtonFlag = true;
                        purchaseArrayForBarChart[0] = purchaseJan.getText();
                        purchaseArrayForBarChart[1] = purchasefeb.getText();
                        purchaseArrayForBarChart[2] = purchasemar.getText();
                        purchaseArrayForBarChart[3] = purchaseApr.getText();
                        purchaseArrayForBarChart[4] = purchasemay.getText();
                        purchaseArrayForBarChart[5] = purchaseJun.getText();
                        purchaseArrayForBarChart[6] = purchaseJul.getText();
                        purchaseArrayForBarChart[7] = purchaseaug.getText();
                        purchaseArrayForBarChart[8] = purchasesep.getText();
                        purchaseArrayForBarChart[9] = purchaseoct.getText();
                        purchaseArrayForBarChart[10] = purchasenov.getText();
                        purchaseArrayForBarChart[11] = purchasedec.getText();
                        dm.saveRecordPurchase(purchaseArrayForBarChart);
                        purchaseBarClear();
                        rootpanel.repaint();
                        rootpanel.revalidate();
                        rootLoginPanel.repaint();
                        rootLoginPanel.revalidate();
                    }
                }
            }
        });

        purchasedec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dm.chkVld(purchaseJan, purchasefeb, purchasemar, purchaseApr, purchasemay, purchaseJun, purchaseJul, purchaseaug, purchasesep, purchaseoct, purchasenov, purchasedec);

                if (isValid) {
                    if (entryPointPurchaseBarChart.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        purchaseArrayForBarChart[0] = purchaseJan.getText();
                        purchaseArrayForBarChart[1] = purchasefeb.getText();
                        purchaseArrayForBarChart[2] = purchasemar.getText();
                        purchaseArrayForBarChart[3] = purchaseApr.getText();
                        purchaseArrayForBarChart[4] = purchasemay.getText();
                        purchaseArrayForBarChart[5] = purchaseJun.getText();
                        purchaseArrayForBarChart[6] = purchaseJul.getText();
                        purchaseArrayForBarChart[7] = purchaseaug.getText();
                        purchaseArrayForBarChart[8] = purchasesep.getText();
                        purchaseArrayForBarChart[9] = purchaseoct.getText();
                        purchaseArrayForBarChart[10] = purchasenov.getText();
                        purchaseArrayForBarChart[11] = purchasedec.getText();
                        dm.saveRecordPurchase(purchaseArrayForBarChart);

                        entryPointPurchaseBarChart.control.addButton.setEnabled(true);
                        entryPointPurchaseBarChart.control.editButton.setEnabled(false);
                        addButtonFlag = true;
                        purchaseBarClear();
                        rootpanel.repaint();
                        rootpanel.revalidate();
                        rootLoginPanel.repaint();
                        rootLoginPanel.revalidate();

                    } else {
                        addButtonFlag = true;
                        purchaseArrayForBarChart[0] = purchaseJan.getText();
                        purchaseArrayForBarChart[1] = purchasefeb.getText();
                        purchaseArrayForBarChart[2] = purchasemar.getText();
                        purchaseArrayForBarChart[3] = purchaseApr.getText();
                        purchaseArrayForBarChart[4] = purchasemay.getText();
                        purchaseArrayForBarChart[5] = purchaseJun.getText();
                        purchaseArrayForBarChart[6] = purchaseJul.getText();
                        purchaseArrayForBarChart[7] = purchaseaug.getText();
                        purchaseArrayForBarChart[8] = purchasesep.getText();
                        purchaseArrayForBarChart[9] = purchaseoct.getText();
                        purchaseArrayForBarChart[10] = purchasenov.getText();
                        purchaseArrayForBarChart[11] = purchasedec.getText();
                        dm.saveRecordPurchase(purchaseArrayForBarChart);
                        purchaseBarClear();
                        rootpanel.repaint();
                        rootpanel.revalidate();
                        rootLoginPanel.repaint();
                        rootLoginPanel.revalidate();
                    }
                }
            }
        });

        return purchaseBarFrame;
    }

    public void purchaseBarClear() {
        (purchaseJan).setText("");
        (purchasefeb).setText("");
        (purchasemar).setText("");
        (purchaseApr).setText("");
        (purchasemay).setText("");
        (purchaseJun).setText("");
        (purchaseJul).setText("");
        (purchaseaug).setText("");
        (purchasesep).setText("");
        (purchaseoct).setText("");
        (purchasenov).setText("");
        (purchasedec).setText("");
    }

    public void purchasebarEditable() {
        (purchaseJan).setEditable(true);
        (purchasefeb).setEditable(true);
        (purchasemar).setEditable(true);
        (purchaseApr).setEditable(true);
        (purchasemay).setEditable(true);
        (purchaseJun).setEditable(true);
        (purchaseJul).setEditable(true);
        (purchaseaug).setEditable(true);
        (purchasesep).setEditable(true);
        (purchaseoct).setEditable(true);
        (purchasenov).setEditable(true);
        (purchasedec).setEditable(true);
    }

    public void purchasebarUneditable() {
        (purchaseJan).setEditable(false);
        (purchasefeb).setEditable(false);
        (purchasemar).setEditable(false);
        (purchaseApr).setEditable(false);
        (purchasemay).setEditable(false);
        (purchaseJun).setEditable(false);
        (purchaseJul).setEditable(false);
        (purchaseaug).setEditable(false);
        (purchasesep).setEditable(false);
        (purchaseoct).setEditable(false);
        (purchasenov).setEditable(false);
        (purchasedec).setEditable(false);
    }

    
    //////////<<<<<<<<<---------======= Assests Start ======= ----------->>>>>>>>>>////////////
    //////////////////////// asset category starts //////////////////
    //<------------------------------**** DESIGNATION MASTER STARTS ****-------------------------------->//

    public JFrame addAssetCategoryFrame() {
        addsearchFlag = true;
        MyLibrary myL = new MyLibrary();
        
        
//        DesignationMast dm = new DesignationMast();

        entryPointAssetCat.setFormPanelHeightBounds(450);
        assetCatFrame = entryPointAssetCat.addFrame();

        JPanel formPanel = new JPanel(null);

        assetCategoryL = new JLabel("Asset Category");
        assetCategoryL.setBounds(200, 100, 100, 25);

        assetCategory = myL.createSpecialJTextField(100, true);
        assetCategory.setBounds(400, 100, 700, 25);
        assetCategory.setEditable(false);

        entryPointAssetCat.setFormName("Asset Category");
        entryPointAssetCat.getFrame.setTitle("Asset category");

        
        
        
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(2, 1));
        searchPanel.setBounds(10, 35, 190, 95);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JRadioButton searchByAssetCat = new JRadioButton("Search by Asset Category");
        JRadioButton searchByCode = new JRadioButton("Search by Asset Category Code");
        ButtonGroup searchGroup = new ButtonGroup();

        search = new JButton("Search");
        search.setEnabled(false);

        searchGroup.add(searchByAssetCat);
        searchGroup.add(searchByCode);

        searchPanel.setVisible(false);

        entryPointAssetCat.getFormPanel.add(assetCategoryL);
        entryPointAssetCat.getFormPanel.add(assetCategory);


        MyFocusListener manager = new MyFocusListener(assetCategory);

        BackgroundColorChanger colorChanger = new BackgroundColorChanger(lightblue, Color.WHITE);
        colorChanger.setFocusListeners(assetCategory);


        entryPointAssetCat.control.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addsearchFlag) {
                    desMasterClear();
                    setEditableFieldDesmaster();
                    designation.requestFocus(true);
                    entryPointDes.control.saveButton.setEnabled(true);
                    entryPointDes.control.searchButton.setEnabled(false);
                    addsearchFlag = false;
                } else if (!addsearchFlag) {
                    setUneditableFieldDesmaster();
                    entryPointDes.control.searchButton.setEnabled(true);
                    entryPointDes.control.saveButton.setEnabled(false);

                    addsearchFlag = true;
                }
            }
        });

        entryPointAssetCat.control.deleteButton.setEnabled(false);
        entryPointAssetCat.control.printButton.setEnabled(false);
        entryPointAssetCat.control.editButton.setEnabled(false);
        entryPointAssetCat.control.saveButton.setEnabled(false);

        entryPointAssetCat.control.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dm.chkVld(designation, designationShortName, designationCode);

                if (isValid) {
                    if (entryPointDes.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        dm.saveRecord(designation, designationShortName, designationCode, moverecCodeforDesM, addButtonFlag);
                        entryPointDes.control.addButton.setEnabled(true);
                        entryPointDes.control.editButton.setEnabled(false);
                        addButtonFlag = true;

                    } else {
                        addButtonFlag = true;
                        dm.saveRecord(designation, designationShortName, designationCode, moverecCodeforDesM, addButtonFlag);

                    }
                }
            }
        });
        entryPointAssetCat.control.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditableFieldDesmaster();
                entryPointDes.control.addButton.setEnabled(true);
                entryPointDes.control.deleteButton.setEnabled(false);
                entryPointDes.control.printButton.setEnabled(false);
                entryPointDes.control.searchButton.setEnabled(false);
            }
        });

        assetCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = dm.chkVld(designation, designationShortName, designationCode);

                if (isValid) {
                    if (entryPointDes.control.editButton.isEnabled()) {
                        addButtonFlag = false;
                        dm.saveRecord(designation, designationShortName, designationCode, moverecCodeforDesM, addButtonFlag);
                        entryPointDes.control.addButton.setEnabled(true);
                        entryPointDes.control.editButton.setEnabled(false);
                        addButtonFlag = true;

                    } else {
                        addButtonFlag = true;
                        dm.saveRecord(designation, designationShortName, designationCode, moverecCodeforDesM, addButtonFlag);

                    }
                }
            }
        });

        entryPointAssetCat.control.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchflag) {
                    searchPanel.removeAll();
                    searchPanel.add(searchByDesignation);
                    searchPanel.add(searchByCode);
                    searchPanel.setBackground(Color.WHITE);
                    searchPanel.setVisible(true);
                    entryPointDes.getFormPanel.add(searchPanel);
                    entryPointDes.control.addButton.setEnabled(false);
                    searchflag = false;

                    search.setEnabled(false);
                    revalidateDesignation_Master();

                } else if (!searchflag) {
                    searchPanel.setVisible(false);
                    entryPointDes.control.addButton.setEnabled(true);
                    entryPointDes.control.deleteButton.setEnabled(false);
                    entryPointDes.control.printButton.setEnabled(false);
                    entryPointDes.control.editButton.setEnabled(false);
                    setUneditableFieldDesmaster();

                    revalidateDesignation_Master();

                    searchflag = true;
                }
            }
        });

        searchByAssetCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Designation");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield = new JTextField();
                    searchfield.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    revalidateDesignation_Master();

                    designationsearchby = 1;
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dm.moverec(searchfield.getText(), designationsearchby, model);
                            if (model.isStatus()) {
                                moverecCodeforDesM = model.getCode();

                                designation.setText(myLib.sNull(model.getTxtDesignation()));
                                designationShortName.setText(myLib.sNull(model.getTxtDesignationShortName()));
                                designationCode.setText(myLib.sNull(model.getTxtDesignationCode()));

                                String createdon = myLib.sNull(model.getCreatedOn());
                                String modifiedon = myLib.sNull(model.getModifiedOn());

                                entryPointDes.txtCreatedBy.setText(createdon);
                                entryPointDes.txtModifiedBy.setText(modifiedon);

                                entryPointDes.getFormPanel.remove(searchPanel);

                                revalidateDesignation_Master();

                                entryPointDes.control.editButton.setEnabled(true);
                                entryPointDes.control.deleteButton.setEnabled(true);
                                entryPointDes.control.printButton.setEnabled(true);
                                entryPointDes.control.saveButton.setEnabled(true);

                            }
                        }
                    });

                }
            }
        });

        searchByCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchflag) {
                    searchPanel.removeAll();
                    searchPanel.setLayout(new GridLayout(3, 1));
                    JLabel searchL = new JLabel("Designation Code");
                    searchL.setBounds(30, 20, 130, 25);
                    searchfield2 = new JTextField();
                    searchfield2.setBounds(30, 55, 130, 25);
                    searchPanel.add(searchfield2);
                    searchPanel.add(searchL);
                    searchPanel.add(search);
                    search.setEnabled(true);

                    desMasterFrame.repaint();
                    desMasterFrame.revalidate();
                    designationsearchby = 2;

                    // Add action listeners for search field here
                    search.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dm.moverec(searchfield2.getText(), designationsearchby, model);
                            if (model.isStatus()) {
                                moverecCodeforDesM = model.getCode();

                                designation.setText(myLib.sNull(model.getTxtDesignation()));
                                designationShortName.setText(myLib.sNull(model.getTxtDesignationShortName()));
                                designationCode.setText(myLib.sNull(model.getTxtDesignationCode()));

                                String createdon = myLib.sNull(model.getCreatedOn());
                                String modifiedon = myLib.sNull(model.getModifiedOn());

                                entryPointDes.txtCreatedBy.setText(createdon);
                                entryPointDes.txtModifiedBy.setText(modifiedon);

                                entryPointDes.getFormPanel.remove(searchPanel);

                                revalidateDesignation_Master();

                                entryPointDes.control.editButton.setEnabled(true);
                                entryPointDes.control.deleteButton.setEnabled(true);
                                entryPointDes.control.printButton.setEnabled(true);
                                entryPointDes.control.saveButton.setEnabled(true);

                            }
                        }
                    });
                }
            }
        });

        entryPointAssetCat.control.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.deleteRecord(moverecCodeforDesM);
                desMasterClear();
                entryPointDep.control.editButton.setEnabled(false);
                entryPointDep.control.deleteButton.setEnabled(false);
                entryPointDep.control.printButton.setEnabled(false);
                entryPointDep.control.saveButton.setEnabled(false);
                entryPointDep.control.addButton.setEnabled(true);
                entryPointDep.control.searchButton.setEnabled(true);
            }
        });

        entryPointAssetCat.control.printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.prnRecord(moverecCodeforDesM);

            }
        });

        return assetCatFrame;

    }

    // helping functions for designation master //
    public void revalidateAssetCategory() {
        desMasterFrame.repaint();
        desMasterFrame.revalidate();
    }

    public void assetCategoryClear() {
        designation.setText("");
        designationShortName.setText("");
        designationCode.setText("");
        entryPointDes.txtCreatedBy.setText("");
        entryPointDes.txtModifiedBy.setText("");
    }

    private void setEditableFieldAssetCategory() {
        designation.setEditable(true);
        designationShortName.setEditable(true);
        designationCode.setEditable(true);
    }

    private void setUneditableFieldAssetCategory() {
        designation.setEditable(false);
        designationShortName.setEditable(false);
        designationCode.setEditable(false);
    }

    
    
    
}
