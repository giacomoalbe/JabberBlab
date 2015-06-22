package db;

import bean.User;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static javafx.application.Platform.exit;

public class DBManager implements Serializable{
    
    // Printer used for printing on the web page
    private PrintWriter out;
    
    
    /*
    
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/TodoDB", "testuser", "testpassword");
    
    */
    // Dati relativi alla connessione al DB
    //private static final String DB_PATH = "/Users/giacomo/NetBeansProjects/JabberBlab2/";
    /*private static final String DB_PATH = "//localhost:1527/";
    private static final String DB_NAME = "JabberBlabDBInterno";
    private static final String DB_BACKUP = "backups/JabberBlabDB";
    //private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String DB_CONNECTION = "jdbc:derby:" + DB_PATH + DB_NAME;
    */
    
   static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
   static final String DB_URL = "jdbc:derby://localhost:1527/JabberBlabDBInterno";

   //  Database credentials
   static final String USER = "";
   static final String PASS = "";
   static int hitId = 0;
   private transient Connection con;
    
   
    
    // Inizializzazione delle variabili usate per connettersi al DB
    private PreparedStatement preparedStatement = null;
    private PreparedStatement controlID = null;
    
    public DBManager() {
    }
    
    public Connection getConnection() {
       
        Connection dbConnectionLocal = null;
        
        try {
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException e) {
           System.out.println("Errore: " + e.toString());
       }
     
       try {
           //Cerco di creare la connessione al DB
           dbConnectionLocal = DriverManager.getConnection(DB_URL);
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
    
    public void controlID() throws SQLException{
        
        con = getConnection();
        //controlID = con.prepareStatement("SELECT LAST (id_utente) FROM Utente");
        
        String qid = "SELECT MAX(id_utente) FROM Utente";
        //String qid = "SELECT * FROM Utente";
        PreparedStatement stm = con.prepareStatement(qid); 
        //controlID = con.prepareStatement("SELECT TOP 1 id_utente FROM Utente ORDER BY id_utente DESC");
        ResultSet lastId = stm.executeQuery();
        int last =  ((Number) lastId.getObject(1)).intValue();
        if(last == hitId){
        ++hitId;
        }
        if(last<hitId){
        hitId = ++last;
        }
        else{
        exit();
        }
        if(stm!=null){
           stm.close();
        }
        if(con!=null)
          con.close();
    }
    
    
    
    public String addUser(String username, String email, String password) throws SQLException {
        
        String returnmessage = null;
        Connection dbConnection = getConnection();
   
        
        returnmessage += "Arrivato db manager " + " " + username + " " + email + "<br>";
        
        //controlID();
        
        String insertUtenteSQL = "INSERT INTO Utente" +
                                 " (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO, USERNAME)" +
                                 " VALUES (?,?,?,?,?,?)";
        
        returnmessage +="Arrivato prima del prepareStatement <br>";
        
            
        try {
            // Popolo la dbConnection
            
             returnmessage +="Arrivato dopo la connessione <br>";
            // Preparo la query da mandare al DB
            preparedStatement = dbConnection.prepareStatement(insertUtenteSQL);
            returnmessage +="Arrivato che prepara lo statement <br>";
            // Inserisco gli argomenti della funzione al posto dei ? 
            preparedStatement.setInt(1,hitId++);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            preparedStatement.setDouble(4,0);
            preparedStatement.setInt(5,1);
            preparedStatement.setString(6,username);
            
            
            // Eseguo la query associata al SQL
            preparedStatement.executeUpdate();
            
            returnmessage +="Utente inserito con successo!<br>";
            
          
            
        } catch (SQLException e) {
            returnmessage += "Errore in addUser: " + e.toString() + "<br>";
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
        
        return returnmessage;
    }
    
    public List<User> getUtente() throws SQLException {
        List<User> esseriumani = new ArrayList<>();
        
        con = getConnection();
        
        
        String qr = "SELECT * FROM Utente";
        PreparedStatement stm = con.prepareStatement(qr); 
        ResultSet rs = stm.executeQuery();
            
            while(rs.next()) {
                User p = new User();
                
                p.setId_utente(rs.getInt("ID_UTENTE"));
                p.setUsername(rs.getString("USERNAME"));
                p.setEmail(rs.getString("EMAIL"));
                p.setPassword(rs.getString("PASSWORD"));
                
                esseriumani.add(p);
            }

        if(stm!=null){
           stm.close();
        }
        if(con!=null)
          con.close();
        return esseriumani;
    }
  
}
