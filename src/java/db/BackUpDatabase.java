package db;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
  Eseguibile che fa il BackUp del Database
  E lo inserisce nella cartella /backups/

*/
public class BackUpDatabase {   
    public static void main(String[] argv) throws SQLException {
        
        // Dati relativi alla connessione al DB
        final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        final String DB_CONNECTION = "jdbc:derby://localhost:1527/ProvaUtenti";
        
        Connection dbConnection = null;
        
        try {
           Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
           System.out.println("Errore: "+ e.toString());
        }
        
        try {
           //Cerco di creare la connessione al DB
           dbConnection = DriverManager.getConnection(DB_CONNECTION);
           
        } catch (SQLException e) {
           System.out.println("Errore in GetConnection(): " + e.toString());
        }
        
        
        // Get today's date as a string:
        java.text.SimpleDateFormat todaysDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
        
        String backupdirectory = "/Users/giacomo/NetBeansProjects/JabberBlab2/backups/";

        CallableStatement cs = dbConnection.prepareCall("CALL SYSCS_UTIL.SYSCS_BACKUP_DATABASE(?)"); 
        cs.setString(1, backupdirectory);
        cs.execute(); 
        cs.close();
        System.out.println("backed up database to "+backupdirectory);
        
        if (dbConnection != null) {
            dbConnection.close();
        }
        
        
    }
    
    
}
