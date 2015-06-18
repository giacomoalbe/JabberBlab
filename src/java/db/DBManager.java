package db;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManager {
    
    // Printer used for printing on the web page
    private PrintWriter out;
    
    // Dati relativi alla connessione al DB
    //private static final String DB_PATH = "/Users/giacomo/NetBeansProjects/JabberBlab2/";
    private static final String DB_PATH = "localhost:1527/";
    private static final String DB_NAME = "JabberBlabDBInterno";
    private static final String DB_BACKUP = "backups/JabberBlabDB";
    //private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String DB_CONNECTION = "jdbc:derby:" + DB_PATH + DB_NAME;
    
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
    
    public void addUser(String email, String password) throws SQLException {
        
        out.println("Arrivato db manager");
        
        // Creo una dbConnection per prelevare i dati
        Connection dbConnection = null;
        
        String insertUtenteSQL = "INSERT INTO Utente" +
                                 " (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO)" +
                                 " VALUES (?,?,?,?,?)";
        
        out.println("Arrivato prima del prepareStatement");
        
        try {
            // Popolo la dbConnection
            dbConnection = getConnection();
            
            // Preparo la query da mandare al DB
            preparedStatement = dbConnection.prepareStatement(insertUtenteSQL);
            
            // Inserisco gli argomenti della funzione al posto dei ? 
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            preparedStatement.setDouble(4,0);
            preparedStatement.setInt(5,1);
            
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
