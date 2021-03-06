/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class DBManagerStandard implements Serializable {
    // transient == non viene serializzato
    
    private static final String DB_PATH = "//localhost:1527/";
    private static final String DB_NAME = "JabberBlabDBInterno";
    private static final String DB_BACKUP = "backups/JabberBlabDB";
    //private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String DB_CONNECTION = "jdbc:derby:" + DB_PATH + DB_NAME;
    

    private transient Connection con;
    
    private static int hitId = 0;
    
    public DBManagerStandard () throws SQLException {

    }
    
    public Connection getConnection() {
       
        Connection dbConnectionLocal = null;
        
        try {
           Class.forName(DB_DRIVER);
       } catch (ClassNotFoundException e) {
           System.out.println("Errore: " + e.toString());
       }
     
       try {
           //Cerco di creare la connessione al DB
           dbConnectionLocal = DriverManager.getConnection(DB_CONNECTION);
           return dbConnectionLocal;
           
       } catch (SQLException e) {
           System.out.println("Errore in GetConnection(): " + e.toString());
       }
       
       return dbConnectionLocal;
    }
    
    /**
     * Autentica un utente in base a un nome utente e a una password
     * 
     * @param username il nome utente
     * @param email è l'email dell'utente
     * @param password la password
     * @return null se l'utente non è autenticato, un oggetto User se l'utente esiste ed è autenticato
     */

    public void addUser(String username, String email, String password) throws SQLException {
        // usare SEMPRE i PreparedStatement, anche per query banali. 
        // *** MAI E POI MAI COSTRUIRE LE QUERY CONCATENANDO STRINGHE !!!! ***
        out.println("Arrivato nell'adduser del dbmanagerstandard\n");
        
        Connection con = getConnection();
        out.println("Preparata la connessione\n");

        String insertUtenteSQL = "INSERT INTO Utente" +
                                 " (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO, USERNAME)" +
                                 " VALUES (?,?,?,?,?,?)";
        
        out.println("Arrivato prima del prepareStatement \n");
        PreparedStatement stm = con.prepareStatement(insertUtenteSQL);
        try {
            // Popolo la dbConnection
              
            
             out.println("Arrivato dopo la connessione \n");
            // Preparo la query da mandare al DB
            
            out.println("Arrivato che prepara lo statement \n");
            // Inserisco gli argomenti della funzione al posto dei ? 
            stm.setInt(1,++hitId);
            stm.setString(2,email);
            stm.setString(3,password);
            stm.setDouble(4,0);
            stm.setInt(5,1);
            stm.setString(6,username);
            
            
            // Eseguo la query associata al SQL
            stm.executeUpdate();
            
            System.out.println("Utente inserito con successo!");
            
          
            
        } catch (SQLException e) {
            System.out.println("Errore in addUser: " + e.toString());
        } finally {
            // Questa clausola viene eseguita a prescindere dagli errori
            // e dunque serve a chiudere le connessioni.
            
            if (stm != null) {
                stm.close();
            }
            
            if (con != null) {
                con.close();
            }
        }
    }
  
    


    public static void shutdown() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(DBManagerStandard.class.getName()).info(ex.getMessage());
            }
        
    }
}

