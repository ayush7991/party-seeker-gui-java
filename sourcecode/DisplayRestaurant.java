/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myparty;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author silentwraith
 */
public class DisplayRestaurant extends javax.swing.JFrame {

    /**
     * Creates new form DisplayRestaurant
     */
  //  private final Map<String, ImageIcon> imageMap;
    String city,sortby,occasion;
    
    /*public void getQuestionsUsingUnirest(String city, String sortby, String occassion) throws Exception {
       // imageMap = createImageMap(nameList);
        Unirest.setProxy(new HttpHost("172.31.1.4", 8080));

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        map.put("Birthday", 31);
        map.put("Engagement", 16);

// getting the city_id        
        HttpResponse<JsonNode> response = Unirest.get("https://developers.zomato.com/api/v2.1/cities").
                header("accept", "application/json").
                header("User-Agent", "curl/7.30.0").
                header("user-key", "547b5a77eb1485027f5bbd93603fbe44").
                //field("q","allahabad");
                queryString("q", city).
                //queryString("sort", "creation").

                asJson();

        //System.out.println(response.getBody().getObject().toString(2));
        JSONObject feast = response.getBody().getObject();
        int pid = feast.getJSONArray("location_suggestions").getJSONObject(0).getInt("id");
        // System.out.println(pid);
        
        
// listing out the resstaurants    
        int etype = map.get(occassion);  // get estb type

        HttpResponse<JsonNode> reslist = Unirest.get("https://developers.zomato.com/api/v2.1/search").
                header("accept", "application/json").
                header("User-Agent", "curl/7.30.0").
                header("user-key", "547b5a77eb1485027f5bbd93603fbe44").
                //field("q","allahabad");
                queryString("entity_id", pid).
                queryString("entity_type", "city").
                queryString("count", "10").
                queryString("establishment_type", etype).
                asJson();

        JSONObject yummy = reslist.getBody().getObject();
        JSONArray jsonArray = yummy.getJSONArray("restaurants");
        //   System.out.println(jsonArray.getJSONObject(0).getJSONObject("restaurant").getString("name"));
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            System.out.println("Name : " + jsonArray.getJSONObject(i).getJSONObject("restaurant").getString("name"));
            System.out.println("Location : " + jsonArray.getJSONObject(i).getJSONObject("restaurant").getJSONObject("location").getString("address"));
        
            //model.addRow(new Object[]{city,jsonArray.getJSONObject(i).getJSONObject("restaurant").getString("name"),jsonArray.getJSONObject(i).getJSONObject("restaurant").getJSONObject("location").getString("address")});
            listModel.add(i,jsonArray.getJSONObject(i).getJSONObject("restaurant").getString("name") + "  " + jsonArray.getJSONObject(i).getJSONObject("restaurant").getJSONObject("location").getString("address"));
          
        }
        
        RestaurantList.setModel(listModel);
     
        
        
    }*/
    
    public DisplayRestaurant(String city,String sortby, String occasion) throws Exception{
        
        this.city = city;
        this.sortby = sortby;
        this.occasion = occasion;
        
        initComponents();
    //    getQuestionsUsingUnirest(city, sortby, occasion);
        
    }
    
    public DisplayRestaurant() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        RestaurantList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jScrollPane2.setViewportView(RestaurantList);

        getContentPane().add(jScrollPane2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line argumeknts
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
            java.util.logging.Logger.getLogger(DisplayRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayRestaurant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> RestaurantList;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
