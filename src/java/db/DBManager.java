package db;

import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager implements Serializable{
    
    // Printer used for printing on the web page
    private PrintWriter out;
    
    
    /*
    
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/TodoDB", "testuser", "testpassword");
    
    */
    // Dati relativi alla connessione al DB
    //private static final String DB_PATH = "/Users/giacomo/NetBeansProjects/JabberBlab2/";
    private static final String DB_PATH = "//localhost:1527/";
    private static final String DB_NAME = "JabberBlabDBInterno";
    private static final String DB_BACKUP = "backups/JabberBlabDB";
    //private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String DB_CONNECTION = "jdbc:derby:" + DB_PATH + DB_NAME;
    
    private static int hitId = 0;
    
    // Inizializzazione delle variabili usate per connettersi al DB
    private PreparedStatement preparedStatement = null;
    
    public DBManager() {
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

    /*
    public Connection getConnectionDynimic() throws SQLException{
     
    Connection conndync = null;
    
    if (this.dbms.equals("mysql")) {
        conn = DriverManager.getConnection(
                   "jdbc:" + this.dbms + "://" +
                   this.serverName +
                   ":" + this.portNumber + "/",
                   connectionProps);
    } else if (this.dbms.equals("derby")) {
        conn = DriverManager.getConnection(
                   "jdbc:" + this.dbms + ":" +
                   this.dbName +
                   ";create=true",
                   connectionProps);
    }
    System.out.println("Connected to database");
    return conndync;
}
       
    */
    
    public void addUser(String username, String email, String password) throws SQLException {
        
        out.println("Arrivato db manager " + " " + username + " " + email + "\n");
        
        out.println("Arrivato in mezzo perché non so \n");
        
        // Creo una dbConnection per prelevare i dati
        
        
        out.println("Arrivato in mezzo perché non so \n");
        
        String insertUtenteSQL = "INSERT INTO Utente" +
                                 " (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO, USERNAME)" +
                                 " VALUES (?,?,?,?,?,?)";
        
        out.println("Arrivato prima del prepareStatement \n");
        Connection dbConnection = null;
            dbConnection = getConnection();
        try {
            // Popolo la dbConnection
            
             out.println("Arrivato dopo la connessione \n");
            // Preparo la query da mandare al DB
            preparedStatement = dbConnection.prepareStatement(insertUtenteSQL);
            out.println("Arrivato che prepara lo statement \n");
            // Inserisco gli argomenti della funzione al posto dei ? 
            preparedStatement.setInt(1,++hitId);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            preparedStatement.setDouble(4,0);
            preparedStatement.setInt(5,1);
            preparedStatement.setString(6,username);
            
            
            // Eseguo la query associata al SQL
            preparedStatement.executeUpdate();
            
            System.out.println("Utente inserito con successo!");
            
          
            
        } catch (SQLException e) {
            System.out.println("Errore in addUser: " + e.toString());
        } finally {
            // Questa clausola viene eseguita a prescindere dagli errori
            // e dunque serve a chiudere le connessioni.
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
  
}
