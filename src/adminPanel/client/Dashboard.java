package adminPanel.client;

import adminPanel.server.Dashboard_srvImpl;
import adminPanel.shared.SalesChart_Vld;
import javax.swing.JTextField;

public class Dashboard {

    Dashboard_srvImpl srv = new Dashboard_srvImpl();
    SalesChart_Vld vld = new SalesChart_Vld();

    public String[] getSalesBarChartData() {
        String [] arrayrecieved = srv.getSalesBarChartData();
        return arrayrecieved;
    }
    public String[] getPurchaseBarChartData() {
        String [] arrayrecieved = srv.getPurchaseBarChartData();
        return arrayrecieved;
    }

    public boolean chkVld(JTextField salesJan, JTextField salesfeb, JTextField salesmar, JTextField salesApr, JTextField salesmay, JTextField salesJun,
            JTextField salesJul, JTextField salesaug, JTextField salessep, JTextField salesoct, JTextField salesnov, JTextField salesdec) {
        boolean noterror = vld.chkVld(salesJan, salesfeb, salesmar, salesApr, salesmay, salesJun, salesJul, salesaug, salessep, salesoct, salesnov, salesdec);
        return noterror;
    }

    public void saveRecord(String[] salesArray) {
        srv.save(salesArray);
    }
    public void saveRecordPurchase(String[] purchaseArray) {
        srv.savePurchase(purchaseArray);
    }

}
