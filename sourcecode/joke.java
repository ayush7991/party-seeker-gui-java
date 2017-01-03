/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myparty;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.awt.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author silentwraith
 */
public class joke extends javax.swing.JFrame {
    static String cityy;
    static String sortbyy;
    static String occasionn;
    static int fff;
    /**
     * Creates new form joke
     */
    public joke(String city,String sortby,String occasion,int ff) {
        cityy= city;
        sortbyy = sortby;
        occasionn= occasion;
        fff=ff;
        initComponents();
        try {
            go();
        } catch (Exception ex) {
            Logger.getLogger(joke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    String ss,dd;
    int l;
    int f=0,x=0;
    String[] nameList = { null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
    String[] addrList = { null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
    String[] latt = { null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
    String[] ratee= {null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
    String[] votee = {null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
    String[] longg = { null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
    String[] ur = {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
//    String[]
    int[] avcost  ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] onlineavai = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public void getQuestionsUsingUnirest() throws Exception {

        Unirest.setProxy(new HttpHost("172.31.1.4", 8080));
       // String city = "agra";
        //String ocassion = "Birthday";

       // ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
       // map.put("Birthday", 31);
        //map.put("Engagement", 16);
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        map.put("Birthdays", 31);
        map.put("Anniversaries", 16);
        map.put("Weddings", 18);
        map.put("Graduations", 7);
        map.put("Holidays", 61);
        map.put("Just Becoz", 1);
        map.put("Festivities", 291);
        map.put("Quick bites", 21);
// getting the city_id
        HttpResponse<JsonNode> response = Unirest.get("https://developers.zomato.com/api/v2.1/cities").
                header("accept", "application/json").
                header("User-Agent", "curl/7.30.0").
                header("user-key", "547b5a77eb1485027f5bbd93603fbe44").
                //field("q","allahabad");
                        queryString("q", cityy).
                //queryString("sort", "creation").

                        asJson();


        //System.out.println(response.getBody().getObject().toString(2));
        JSONObject feast = response.getBody().getObject();
        int pid = feast.getJSONArray("location_suggestions").getJSONObject(0).getInt("id");
        // System.out.println(pid);

// listing out the resstaurants
        int etype = map.get(occasionn);  // get estb type

        HttpResponse<JsonNode> reslist = Unirest.get("https://developers.zomato.com/api/v2.1/search").
                header("accept", "application/json").
                header("User-Agent", "curl/7.30.0").
                header("user-key", "547b5a77eb1485027f5bbd93603fbe44").
                //field("q","allahabad");
                        queryString("entity_id", pid).
                        queryString("entity_type", "city").
                        queryString("count", "10").
                        queryString("establishment_type", etype).
                        queryString("sort", sortbyy).
                        asJson();

        JSONObject yummy = reslist.getBody().getObject();
        JSONArray jsonArray = yummy.getJSONArray("restaurants");
        l=jsonArray.length();
        //   System.out.println(jsonArray.getJSONObject(0).getJSONObject("restaurant").getString("name"));
        for (int i=0;i<jsonArray.length();i++){
            ss = jsonArray.getJSONObject(i).getJSONObject("restaurant").getString("name");
            dd = jsonArray.getJSONObject(i).getJSONObject("restaurant").getJSONObject("location").getString("address");
            nameList[i]=ss;
            addrList[i]=dd;
            latt[i] = jsonArray.getJSONObject(i).getJSONObject("restaurant").getJSONObject("location").getString("latitude");
            longg[i] = jsonArray.getJSONObject(i).getJSONObject("restaurant").getJSONObject("location").getString("longitude");
            ratee[i] = jsonArray.getJSONObject(i).getJSONObject("restaurant").getJSONObject("user_rating").getString("aggregate_rating");
            avcost[i] =  jsonArray.getJSONObject(i).getJSONObject("restaurant").getInt("average_cost_for_two");
            onlineavai[i]=jsonArray.getJSONObject(i).getJSONObject("restaurant").getInt("has_online_delivery");
            ur[i]=jsonArray.getJSONObject(i).getJSONObject("restaurant").getString("url");
            float ff = Float.parseFloat(latt[i]);
            System.out.println(ff);
        }
          //  dd = jsonArray.getJSONObject(0).getJSONObject("restaurant").getJSONObject("location").getString("address");
           // System.out.println(ss);
//    nameList[i] = jsonArray.getJSONObject(i).getJSONObject("restaurant").getString("name");
      //      System.out.println(nameList[i]);
          //  System.out.println("Name : "+jsonArray.getJSONObject(i).getJSONObject("restaurant").getString("name"));
           // System.out.println("Location : "+jsonArray.getJSONObject(i).getJSONObject("restaurant").getJSONObject("location").getString("address"));
       // }

    }
    private void go() throws Exception{
        getQuestionsUsingUnirest();
        MyModel m = new MyModel();
        jTable_Click.setModel(m);
        jTable_Click.setRowHeight(100);
        jTable_Click.getColumnModel().getColumn(0).setCellRenderer(new Renderer());
    }
    
    class MyModel extends AbstractTableModel
    {

        @Override
        public int getRowCount() {
            return l;
        }

        @Override
        public int getColumnCount() {
            return 2;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            String ko=null;
            String ro=null;
            if(columnIndex%3==1)
                ko=nameList[rowIndex];
            ro=addrList[rowIndex];
            return ko;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    class Renderer extends DefaultTableCellRenderer
    {
        JLabel lbl = new JLabel();
        ImageIcon[] images = {new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/i.jpg"),new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/b.jpg"),new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/d.jpg"),new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/c.jpg"),new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/e.jpg"),new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/f.jpg"),new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/g.jpg"),new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/h.jpg"),new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/j.jpg"),new ImageIcon("/home/silentwraith/NetBeansProjects/MyParty/src/myparty/c.jpg")};       
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            
            lbl.setText((String) value);
            lbl.setIcon(images[row]);  
            return lbl;
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Click = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(650, 700));
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        jTable_Click.setFont(new java.awt.Font("MathJax_Main", 3, 36)); // NOI18N
        jTable_Click.setRowHeight(36);
        jTable_Click.setRowMargin(2);
        jTable_Click.setShowHorizontalLines(false);
        jTable_Click.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ClickMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Click);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_ClickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClickMouseClicked
        int index = jTable_Click.getSelectedRow();
        TableModel model = jTable_Click.getModel();
        String value1 = model.getValueAt(index,1).toString();
        String lattit=null;
        String longit=null;
        String rateei=null;
        String name=null;
        String addre=null;
        String urr=null;
        int onav=0;
        int avcos=0;
        lattit=latt[index];
        longit=longg[index];
        rateei=ratee[index];
        onav=onlineavai[index];
        avcos=avcost[index];
        name=nameList[index];
        addre=addrList[index];
        urr=ur[index];
       // JOptionPane.showMessageDialog(null,addrList[index]);
        new displayin(lattit,longit,rateei,onav,avcos,name,addre,fff,urr).setVisible(true);
    }//GEN-LAST:event_jTable_ClickMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(joke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(joke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(joke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(joke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new joke(cityy , sortbyy , occasionn,fff).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Click;
    // End of variables declaration//GEN-END:variables
}
