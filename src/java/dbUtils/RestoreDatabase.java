package dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Questo file serve per fare il restore del DATABASE dopo che qualcuno 
    Ha modificato i dati in una versione locale!
*/


public class RestoreDatabase {
    public static void main(String argv[]) throws SQLException {
        
        final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        final String DB_NAME = "JabberBlabDB";
        final String PATH_RESTORE_DB = "backups/JabberBlabDB";
        final String DB_CONNECTION_RESTORE = "jdbc:derby:" + DB_NAME + ";restoreFrom=" + PATH_RESTORE_DB;
        
        System.out.println(DB_CONNECTION_RESTORE);
        
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Errore: " + e.toString());
        }
        
        Connection dbConnectionRestore = null;
        
        try {
            dbConnectionRestore = DriverManager.getConnection(DB_CONNECTION_RESTORE);
        } catch (SQLException e) {
            System.out.println("Errore: " + e.toString());
        }
       
        System.out.println(DB_NAME + " database aggiornato e funzionante!");
        
        if (dbConnectionRestore != null) {
            dbConnectionRestore.close();
        }
        
    }
}
