package db;

import bean.User;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;

public class DBManager implements Serializable{
    
    // Printer used for printing on the web page
    private PrintWriter out;
    
    
    
   static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
   static final String DB_URL = "jdbc:derby://localhost:1527/JabberBlabDBInterno";

   //  Database credentials
   static final String USER = "";
   static final String PASS = "";
   static int hitId = 0;
   private static transient Connection con;
    
   
    
    // Inizializzazione delle variabili usate per connettersi al DB
    private PreparedStatement preparedStatement = null;
    private PreparedStatement controlID = null;
    
    public DBManager() {
    }
    
    public static Connection getConnection() {
       
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

    public void controlID() throws SQLException{
               //FUNZIONANTE! - Brune
        Connection controlConn = getConnection();
        String qid = "SELECT MAX (id_utente) AS id_utente FROM Utente";
     
        PreparedStatement stm = controlConn.prepareStatement(qid); 
        ResultSet rs = stm.executeQuery();
        int last = 0;
        
        while(rs.next()){
        last = rs.getInt("id_utente");
        }

        if(last >= hitId){
        hitId = last + 1;
        }
        
        else{
        exit();
        }
        if(stm!=null){
           stm.close();
        }
        if(controlConn!=null)
          controlConn.close();
    }
    
    public String controlUsername(String email) throws SQLException{
        Connection dbUserControl = getConnection();
        String result = null;
        
        PreparedStatement usrCtrl = dbUserControl.prepareStatement("SELECT * FROM utente WHERE email = ?");
       
            usrCtrl.setString(1, email);

            ResultSet rs = usrCtrl.executeQuery();
            if(rs == null){
                return result;
            }
            else{
            return result = "utente doppio!";
            }
    }
    
    
    
    public User addUser(String firstname, String lastname, String email, String password) throws SQLException {
        
        String returnmessage = null;
        Connection dbConnection = getConnection();

        controlID();
        String control = controlUsername(email);
        
        if(control != null){
            
        }
        
        String insertUtenteSQL = "INSERT INTO Utente" +
                                 " (ID_UTENTE, EMAIL, PASSWORD, CREDITO, ID_RUOLO, FIRSTNAME, LASTNAME)" +
                                 " VALUES (?,?,?,?,?,?,?)";
        
 
            
        try {
            
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
            preparedStatement.setString(6,firstname);
            preparedStatement.setString(7,lastname);
            
            
            // Eseguo la query associata al SQL
            preparedStatement.executeUpdate();
            User user = new User();
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setId_utente(hitId);
                    user.setEmail(email);
                    user.setCredito(0);
            returnmessage +="Utente " + firstname + " " + lastname +  " inserito con successo!<br>";
                return user;
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
        return null;
        
        
    }
    
    public User authenticate(String email, String password) throws SQLException {
        // usare SEMPRE i PreparedStatement, anche per query banali. 
        // *** MAI E POI MAI COSTRUIRE LE QUERY CONCATENANDO STRINGHE !!!! ***
        Connection dbConnection = getConnection();
        PreparedStatement logstm = dbConnection.prepareStatement("SELECT * FROM utente WHERE email = ? AND password = ?");
        try {
            logstm.setString(1, email);
            logstm.setString(2, password);
            
            ResultSet rs = logstm.executeQuery();

            try {
                if (rs.next()) {
                    User user = new User();
                    user.setFirstname(rs.getString("firstname"));
                    user.setLastname(rs.getString("lastname"));
                    user.setId_utente(rs.getInt("id_utente"));
                    user.setEmail(email);
                    user.setCredito(rs.getDouble("credito"));
                    return user;
                } else {
                    return null;
                }
            } finally {
                // ricordarsi SEMPRE di chiudere i ResultSet in un blocco finally 
                rs.close();
            }
        } finally { // ricordarsi SEMPRE di chiudere i PreparedStatement in un blocco finally 
            logstm.close();
        }
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
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
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
    
    public String RecuperoPassword(String email) throws SQLException{
        
        try (Connection dbConnection = getConnection(); 
            PreparedStatement recstm = dbConnection.prepareStatement("SELECT * FROM utente WHERE email = ?")) {
            recstm.setString(1, email);
            String recpwd = null;
            ResultSet rst = recstm.executeQuery();
            
            if (rst.next()) {
            recpwd = rst.getString("password");
            return recpwd; 
            } else {
            return recpwd;
            }
             
        } catch (SQLException e) {
            System.out.println("Errore in get utente: " + e.toString());
            System.out.println(e.getStackTrace());
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return "";
               
    }
    
    
    
    
    public static void CreaSpettacolo(PrintWriter out) throws SQLException{
        java.util.Date now = new java.util.Date();
        
        final int INTERVALLO_SPETTACOLI = 3;
        final int SPETTACOLI_PER_FILM = 5;
        
        Connection dbConnection = getConnection();
        
        // Data che inseriamo al momento della prima run del programma
        Date oraInUnCertoMomento = new Date();
        Calendar cursoreOra = Calendar.getInstance();
        cursoreOra.setTime(oraInUnCertoMomento);
        
        String querySelectAllFilm = "SELECT * FROM FILM";
        Statement stm = dbConnection.createStatement();
        
        ResultSet recordSetAllFilm = stm.executeQuery(querySelectAllFilm);
        int j = 1;
        while (recordSetAllFilm.next()) {
            out.println(j + " " + recordSetAllFilm.getString("titolo") + "<br>");
            j++;
 
            // Creiamo 5 spettacoli per ogni fil
            for (int i = 0; i < SPETTACOLI_PER_FILM; i++) {
                
                creaNuovoSpettacoloFilm(recordSetAllFilm.getInt("id_film"), cursoreOra.getTime(), out);
                out.println(cursoreOra.getTime());
                cursoreOra.add(Calendar.MINUTE, INTERVALLO_SPETTACOLI);
            }
            
        }
    
        
        
        
        
    
        
        
        
       
            
         
    }
    
    public static void creaNuovoSpettacoloFilm(int id_film, Date orario, PrintWriter out) throws SQLException {
        
        // Ritorna il numero della prima sala libera in quel momento.
        // Se non trova nessuna sala ritorna -1
        
        // Cerchiamo dunque tra tutti gli spettacoli se è presente una riga 
        // con ora == orario e sala == sala
        /*con = getConnection();
        
        java.sql.Time sqlTime = new java.sql.Time(orario.getTime());
        
        
        
        java.sql.Date sqlDate = new java.sql.Date(orario.getTime());
        out.println(sqlDate.toString() + sqlTime.toString());
        String querySelectSalaOrario = "SELECT id_spettacolo FROM spettacolo WHERE id_sala = ? AND data_ora = '" + new Timestamp(orario.getTime()) + "'";
        
        out.println(querySelectSalaOrario);
        
        PreparedStatement stm = con.prepareStatement(querySelectSalaOrario);
        
        stm.setInt(1, sala);
        //stm.setDate(2, (java.sql.Date) orario);
        
        out.println(stm.toString());
        
        ResultSet resultSetSalaOrario = stm.executeQuery();
        
        if (isEmpty(resultSetSalaOrario)) {
            // Inseriamo lo spettacolo nella tabella a questo orario e sala
        } else {
            // Non inseriamo l'orario in tabella
        }
        

        */
        
        
        
        out.println(" ora: " + orario.toString()+ "<br>");
        
         Connection dbConnection = getConnection();
         Statement pstm = dbConnection.createStatement();
         String insertUtenteSQL = "INSERT INTO Spettacolo" +
                                 " (ID_SPETTACOLO, ID_FILM, DATA_ORA, ID_SALA)" +
                                 " VALUES (?,?,?,?)";
         
         pstm = dbConnection.prepareStatement(insertUtenteSQL);
         /*
            
            pstm.setInt(1,);
            pstm.setString(2,email);
            pstm.setString(3,password);
            pstm.setDouble(4,0);*/
      
        
         
    }
    
    public static boolean isEmpty(ResultSet rs) {
        try {
            if (rs.getRow() != 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            return  true;
        }
    }
    
    
  
}
