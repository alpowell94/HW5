
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Basketball;


public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery(){
        
            Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            
        } catch ( SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void doRead(){
    
        
        try {
            String query = "Select * from basketball";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
       
        
        
       }
        
        
    }
    
    public String getHTMLTable(){

    String table = "";
    table += "<table>";
        
        try {
            while(this.results.next()){
                
                Basketball basketball = new Basketball();
                basketball.setBallerID(this.results.getInt("ballerID"));
                basketball.setPlayerName(this.results.getString("playerName"));
                basketball.setAge(this.results.getInt("age"));
                basketball.setCollege(this.results.getString("college"));
                basketball.setPpg(this.results.getInt("ppg"));
                basketball.setRpg(this.results.getInt("rpg"));
                basketball.setApg(this.results.getInt("apg"));
                
                
                
                table += "<tr>";
                
            
                
                table += "<td>";
                table += basketball.getBallerID();
                table += "</td>";
                
                table += "<td>";
                table += basketball.getPlayerName();
                table += "</td>";
                
                table += "<td>";
                table += basketball.getAge();
                table += "</td>";
                
                table += "<td>";
                table += basketball.getCollege();
                table += "</td>";
                
                table += "<td>";
                table += basketball.getPpg();
                table += "</td>";
                
                table += "<td>";
                table += basketball.getRpg();
                table += "</td>";
                
                table += "<td>";
                table += basketball.getApg();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?ballerID=" +basketball.getBallerID() + ">Update </a>" + "<a href=delete?ballerID=" + basketball.getBallerID() + "> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
                
                
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    table += "</table>";
            
            return table;
    }        
            
    
    
    
    }
