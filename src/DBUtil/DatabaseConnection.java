/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class DatabaseConnection {
                     public static Connection c = null;
                             
	public static Connection setConnnection() throws Exception{
            
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&useSSL=false","root","11999N@s");
                return c;
	}
	public static void iud(String sql)throws Exception{
		if(c==null) {
			setConnnection();
		}
		c.createStatement().executeUpdate(sql);
	}
	public static ResultSet search(String sql)throws Exception{
		if(c == null) {
			setConnnection();
		}
		return c.createStatement().executeQuery(sql);
	}
             
  
             
        public static Connection ValidateLogin(){
                try{
                  
                    return c;
                } 

            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                 return null;
            }
            }
}
