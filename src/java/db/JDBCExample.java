package db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//STEP 1. Import required packages
import bean.User;
import static java.lang.System.out;
import java.sql.*;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class JDBCExample {
    
    public JDBCExample () {

    }
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";  
   static final String DB_URL = "jdbc:derby://localhost:1527/JabberBlabDBInterno";

   //  Database credentials
   static final String USER = "";
   static final String PASS = "";
   static int hitId = 0;
   private transient Connection con;
   
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

   
   public String addUser(String username, String email, String password) throws SQLException, Exception {

   String returnmessage = null;
   
   returnmessage += "doing a connection.. <br>";
   
   con = getConnection();
   
   try{
  
      //STEP 3: Open a connection
      returnmessage +="Connecting to a selected database... <br>";
      
      /*
       Statement stmt = con.createStatement();
       stmt.executeUpdate( "INSERT INTO Utente (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO, USERNAME) VALUES (2,bellameda@gmail.com,stornzo,100,1,merdaschifosa)" );  
       
       PreparedStatement stmtprova = con.prepareStatement("INSERT INTO Utente (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO, USERNAME) VALUES (3,bellameda@gmail.com,stornzo,100,1,merdaschifosa)");
       stmtprova.executeUpdate();
       
       */
       //STEP 4: Execute a query
      returnmessage += "Inserting records into the table...<br>";
      
      
      String insertUtenteSQL = "INSERT INTO Utente (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO, USERNAME) VALUES (?,?,?,?,?,?)";
        
        returnmessage += "Arrivato prima del prepareStatement <br>";
        PreparedStatement stm = con.prepareStatement(insertUtenteSQL);
        try {
              
            
             returnmessage += "Arrivato dopo la connessione <br>";
            // Preparo la query da mandare al DB
            
            returnmessage += "Arrivato che prepara lo statement <br>";
            // Inserisco gli argomenti della funzione al posto dei ? 
            stm.setInt(1,4);
            stm.setString(2,email);
            stm.setString(3,password);
            stm.setDouble(4,0);
            stm.setInt(5,1);
            stm.setString(6,username);
            
            stm.executeQuery();
            returnmessage += "Inserted records into the table...<br>";
      
     
            
      
      

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }
            if(stm!=null) stm.close();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      
   }
   finally{
      //finally block used to close resources
      // do nothing
      if(con!=null){
          con.close();
      }//end finally try
   }//end try
   returnmessage += "Ho registrato con successo " + username + " con l'email " + email + "<br>"; 
   System.out.println("Goodbye!");
        return returnmessage;
    }//end addUser
   
   
  
        /**
     * Ottiene la lista dei prodotti dal DB
     * 
     * @return
     * @throws SQLException 
     */

    public List<User> getUtente() throws SQLException {
        List<User> esseriumani = new ArrayList<User>();
        
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

        
        if(con!=null)
          con.close();
        return esseriumani;
    }
    
    
    public static void shutdown() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).info(ex.getMessage());
        }
    }
    
    
    
    
/**
*  Example to show how to set /enable tracing when obtaining connections from DataSource
*  - using the setTraceDirectory method on the DataSource
*/

}//end JDBCExample
