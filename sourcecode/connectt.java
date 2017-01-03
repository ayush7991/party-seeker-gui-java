/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myparty;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class connectt {
    Connection conn = null;
    public static Connection dbConnector()
    {
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/silentwraith/NetBeansProjects/Company/employeeinfo.sqlite");
          //  JOptionPane.showMessageDialog(null, "Connect");
            
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}