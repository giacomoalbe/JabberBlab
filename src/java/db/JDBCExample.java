package db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//STEP 1. Import required packages
import static java.lang.System.out;
import java.sql.*;

public class JDBCExample {
    
    public JDBCExample () {

    }
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";  
   static final String DB_URL = "jdbc:derby://localhost:1527/JabberBlabDBInterno";

   //  Database credentials
   static final String USER = "";
   static final String PASS = "";
   
   public String addUser(String username, String email, String password) throws SQLException {
   Connection conn = null;
   Statement stmt = null;
   String returnmessage = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
      
      String insertUtenteSQL = "INSERT INTO Utente" +
                                 " (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO, USERNAME)" +
                                 " VALUES (?,?,?,?,?,?)";
        
        out.println("Arrivato prima del prepareStatement \n");
        PreparedStatement stm = conn.prepareStatement(insertUtenteSQL);
        try {
            // Popolo la dbConnection
              
            
             out.println("Arrivato dopo la connessione \n");
            // Preparo la query da mandare al DB
            
            out.println("Arrivato che prepara lo statement \n");
            // Inserisco gli argomenti della funzione al posto dei ? 
            stm.setInt(1,1);
            stm.setString(2,email);
            stm.setString(3,password);
            stm.setDouble(4,0);
            stm.setInt(5,1);
            stm.setString(6,username);
            
            stm.executeUpdate();
      System.out.println("Inserted records into the table...");
      
     returnmessage = "Ho registrato " + username + " " + email + " ";
      
      

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }}catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
        return returnmessage;
}//end main
}//end JDBCExample
