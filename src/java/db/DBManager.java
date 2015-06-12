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
    private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/ProvaUtenti";
    
    // Inizializzazione delle variabili usate per connettersi al DB
    private PreparedStatement preparedStatement = null;
    
    public DBManager() {
    }
    
    private static Connection getConnection() {
       
        Connection dbConnectionLocal = null;
        
        try {
           Class.forName(DB_DRIVER);
       } catch (ClassNotFoundException e) {
           System.out.println("Errore: "+ e.toString());
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
        
        // Creo una dbConnection per prelevare i dati
        Connection dbConnection = null;
        
        String insertUtenteSQL = "INSERT INTO Utente" +
                                 " (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO)" +
                                 " VALUES (?,?,?,?,?)";
        
        try {
            // Popolo la dbConnection
            dbConnection = getConnection();
            
            // Preparo la query da mandare al DB
            preparedStatement = dbConnection.prepareStatement(insertUtenteSQL);
            
            // Inserisco gli argomenti della funzione al posto dei ? 
            preparedStatement.setInt(1,0);
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
