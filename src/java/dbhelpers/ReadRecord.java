
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


public class ReadRecord 
{
    private Connection conn;
    private ResultSet results;
    
    private Basketball basketball = new Basketball();
    private int ballerID;

    public ReadRecord (int ballerID)
    {
        try {
               Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            
            this.ballerID = ballerID;
           
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch ( SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {
    
        try {
            String query = "SELECT * FROM basketball WHERE ballerID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, ballerID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            basketball.setBallerID(this.results.getInt("ballerID"));
            basketball.setPlayerName(this.results.getString("playerName"));
            basketball.setAge(this.results.getInt("age"));
            basketball.setCollege(this.results.getString("college"));
            basketball.setPpg(this.results.getInt("ppg"));
            basketball.setRpg(this.results.getInt("rpg"));
            basketball.setApg(this.results.getInt("apg"));
       
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    
        
    }
   
    public Basketball getBasketball() {
        
        return this.basketball;
    }
    
}





