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
   
   private static int NUM_ORE;
   private static int NUM_SALE;
   private static final int INTERVALLO_SPETTACOLI = 3;
   private static final int SPETTACOLI_PER_FILM = 5;
   private static int OffsetOraCorrente = 0;
   public static int counter = 0;

    public static int getOffsetOraCorrente() {
        return OffsetOraCorrente;
    }

    public static void setOffsetOraCorrente(int OffsetOraCorrente) {
        DBManager.OffsetOraCorrente = OffsetOraCorrente;
    }

    public static int getNUM_ORE() {
        return NUM_ORE;
    }

    public static void setNUM_ORE(int NUM_ORE) {
        DBManager.NUM_ORE = NUM_ORE;
    }

    public static int getNUM_SALE() {
        return NUM_SALE;
    }

    public static void setNUM_SALE(int NUM_SALE) {
        DBManager.NUM_SALE = NUM_SALE;
    }
   
          
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
        
        con = getConnection();
        //controlID = con.prepareStatement("SELECT LAST (id_utente) FROM Utente");
        
        String qid = "SELECT MAX(id_utente) FROM Utente";
     
        PreparedStatement stm = con.prepareStatement(qid); 
        ResultSet rs = stm.executeQuery();

              //int last = rs.getInt("id_utente");
              
              
              String str = rs.getString("id_utente");
              int last = Integer.parseInt(str);
              //Integer last = (Integer) rs.getObject("id_utente");
               

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
    
    public static void creaSpettacoli() throws SQLException{
        
        setNUM_SALE(5);
       
        Connection dbConnection = null;
        
        // Cancello tutti gli spettacoli presenti 
        dbConnection = getConnection();
        String queryDeleteSpettacolo = "DELETE FROM SPETTACOLO";
        Statement deleteStm = dbConnection.createStatement();
        deleteStm.execute(queryDeleteSpettacolo);
        
        deleteStm.close();
        dbConnection.close();
        
        dbConnection = getConnection();
        
        // Data che inseriamo al momento della prima run del programma
        Date oraInUnCertoMomento = new Date();
        Calendar cursoreOra = Calendar.getInstance();
        cursoreOra.setTime(oraInUnCertoMomento);
        
        String querySelectAllFilm = "SELECT * FROM FILM";
        Statement stm = dbConnection.createStatement();
        
        ResultSet recordSetAllFilm = stm.executeQuery(querySelectAllFilm);
        
        int NUM_FILM = 0;
        while (recordSetAllFilm.next()) {
            NUM_FILM++;
        }
        
        recordSetAllFilm.close();
        recordSetAllFilm = stm.executeQuery(querySelectAllFilm);
        
        setNUM_ORE(SPETTACOLI_PER_FILM * NUM_FILM / getNUM_SALE());
         
        //printOraMassima(cursoreOra);
        // Inserisco i nuovi spettacoli
        
        while (recordSetAllFilm.next()) {
            
            //out.println(j + " " + recordSetAllFilm.getString("titolo") + "<br>");
 
            // Creiamo 5 spettacoli per ogni fil
            for (int i = 0; i < SPETTACOLI_PER_FILM; i++) {
                
                creaNuovoSpettacoloFilm(recordSetAllFilm.getInt("id_film"), cursoreOra);
                
            }
            
        }
     
    }
    
    /*
    public static void insertElemSpettacolo(Calendar orario) throws SQLException {
        
        con = getConnection();
       
        
        Calendar calendarioWork = (Calendar) orario.clone();
        String queryInsertSpettacolo;
        
        PreparedStatement statement;
        ResultSet resultSetSalaOra;
        //querySelectSalaOra = "SELECT id_spettacolo FROM spettacolo WHERE data_ora = '" + new Timestamp(calendarioWork.getTimeInMillis()) + "' AND id_sala = " + j;
        // Inserisco lo spettacolo a questa ora e sala
        queryInsertSpettacolo = "INSERT INTO SPETTACOLO" +
                                " (ID_SPETTACOLO, ID_FILM, DATA_ORA, ID_SALA) " +
                                " VALUES (?,?,?,?) ";
        try (PreparedStatement stm = con.prepareStatement(queryInsertSpettacolo)) {
            stm.setInt(1, nuovoID("spettacolo"));
            stm.setInt(2,1);
            stm.setTimestamp(3, new Timestamp(calendarioWork.getTimeInMillis()));
            stm.setInt(4, 1);

            stm.execute();
            stm.close();
            
            //out.println("Inserito elemento in spettacolo!<br>");
            
            con = getConnection();
            
            String querySelectAllSpettacoli = "SELECT * FROM SPETTACOLO";
            try (Statement insert = con.createStatement()) {
                ResultSet rs = insert.executeQuery(querySelectAllSpettacoli);

                while (rs.next()) {
                    //out.println("Data: " + rs.getTimestamp("data_ora") + "<br>");
                }
            }
        } catch (SQLException e) {
            System.out.println("Errore nell'inserire nel DB il record Spettacolo: " + e.toString());
        }
 
        con.close();
        
        
    }*/
    public static void creaNuovoSpettacoloFilm(int id_film, Calendar orario) {
        
        // Piazza ogni singolo spettacolo all'interno della "scacchiera" degli spettacoli/orari
        
        // Vogliamo che nella stessa ora siano presenti 5 spettacoli diversi,
        // Non lo stesso nelle 5 sale
        
        // for ora 
        //      for sala
        //          while(isNotLibera)
        //              next
        //          inserisciSpettacolo
        
        
        // Nuovo algoritmo
        
        // Se è presente per l'ora attuale uno spettacolo del film che vogliamo inserire
        // Allora passa all'ora dopo
        // Altrimenti cerco una sala in cui inserire i film guardando a quelle libere
        // Ogni volta che arrivo alla 5 sala di una certa ora aumento di uno le
        // ore occupate e quindi il prossimo while riparto da quell'ora e non dall'inizio
        
        Calendar calendarioWork = (Calendar) orario.clone();
        
        // Porto l'ora al corrente spazio in cui sono presenti sale libere
        calendarioWork.add(Calendar.MINUTE, INTERVALLO_SPETTACOLI * getOffsetOraCorrente());
        
        //out.println(calendarioWork.getTime() + " offset: " + getOffsetOraCorrente() + "<br>");
        
        boolean notInserito = true;
        
        while (notInserito && getIsNotOraMassima(calendarioWork, orario)) {

            try {
               
                con = getConnection();
                String querySelectSpettacoloOra = "SELECT ID_FILM FROM SPETTACOLO WHERE DATA_ORA = ?";
                try (PreparedStatement sptOraStm = con.prepareStatement(querySelectSpettacoloOra)) {
                    sptOraStm.setTimestamp(1, new Timestamp(calendarioWork.getTimeInMillis()));
                    ResultSet resultSetSpettacoloOra = sptOraStm.executeQuery();
                    
                    if (isEmpty(resultSetSpettacoloOra)) {
                        
                        // Posso cercare la sala e inserire il film
                        
                        //out.println("Cerco la sala in cui inserire il film<br>");
                        DBManager.inserisciFilmSalaOra(calendarioWork, id_film);
                        notInserito = false;
                        
                    } else {
                        //out.println("E' già presente un film " + id_film + " a questa ora " + calendarioWork.getTime() + "<br>");
                        //out.println("Ma è il film per cui stiamo cercando una sala?<br>");
                        int filmPresente = resultSetSpettacoloOra.getInt("id_film");
                        
                        if (filmPresente != id_film) {
                            
                            //out.println("No. Quindi gli troviamo una sala!<br>");
                            DBManager.inserisciFilmSalaOra(calendarioWork, id_film);
                            notInserito = false;
        
                        } else {
                            //out.println("Strano ma vero è lui. Niente si va avanti alla prossima ora<br>");
                            //out.println("Offset: " + DBManager.getOffsetOraCorrente() + " Attuale: " + calendarioWork.getTime() + "<br>");
                        }
                        // Aggiorno offset corrente e cerco una nuova sala nella prossima ora
                        calendarioWork.add(Calendar.MINUTE, INTERVALLO_SPETTACOLI);
                    }
                }
                con.close();
                
            } catch (SQLException e) {
                System.out.println("Errore nella select spettacolo data! " + e.toString());
                System.out.println(e.getStackTrace());
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
            } 
            
        }
           
    }
    
    private static void inserisciFilmSalaOra(Calendar calendarioWork, int id_film) {
        
        counter++;
        String querySelectSpettacoloSala = "SELECT ID_FILM FROM SPETTACOLO WHERE DATA_ORA = ? AND ID_SALA = ?";
        PreparedStatement stm = null;
        ResultSet rsSpettacoloOra = null;
        
        boolean notInserito = true;

        // Mi porto all'inizio dell'elenco delle varie sale
        int j = 1;

        while (notInserito && j <= getNUM_SALE()) {
            
            con  = getConnection();
            try {
                stm = con.prepareStatement(querySelectSpettacoloSala);

                stm.setTimestamp(1, new Timestamp(calendarioWork.getTimeInMillis()));
                stm.setInt(2, j);
                
            

                rsSpettacoloOra = stm.executeQuery();

                if (isEmpty(rsSpettacoloOra)) {
                    System.out.println("Inserisco il film " + id_film + " alle " + calendarioWork.getTime() + " nella sala " + j + " counter " + counter + " <br>");
                    // Posso scrivere in questa casella
                    notInserito = false;

                    // PROCEDURA DI INSERT

                    con = getConnection();

                    String queryInsertSpettacolo = "INSERT INTO SPETTACOLO" +
                        " (ID_SPETTACOLO, ID_FILM, DATA_ORA, ID_SALA) " +
                        " VALUES (?,?,?,?) ";
                    try (PreparedStatement insertStm = con.prepareStatement(queryInsertSpettacolo)) {
                        insertStm.setInt(1, nuovoID("spettacolo"));
                        insertStm.setInt(2, id_film);
                        insertStm.setTimestamp(3, new Timestamp(calendarioWork.getTimeInMillis()));
                        insertStm.setInt(4, j);

                        insertStm.execute();
                        insertStm.close();

                        //out.println("Inserito elemento in spettacolo!<br>");
                        con.close();

                    } catch (SQLException e) {
                        System.out.println("Errore nella insert: " + e.toString());
                    } 
                }
                } catch (SQLException e) {
                    System.out.println("Errore nella select spettacolo data sala! " + e.toString());
                    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
                }

                if (j==5) {
                    System.out.println("Entra aumenta offset<br>");
                    // Siamo all'ultima sala! Mando avanti il currentOffset
                    // in modo da limitare i calcoli del server
                    setOffsetOraCorrente(getOffsetOraCorrente() + 1);
                    // Aumento l'ora di 3 minuti solo quando tutte le sale
                    // sono state controllate
                    calendarioWork.add(Calendar.MINUTE, INTERVALLO_SPETTACOLI);
                }

                j++;

                try {
                stm.close();

                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Errore nel chiudere connessione o statement in insert: " + e.toString());
            }

        }
    }
    private static boolean getIsNotOraMassima(Calendar attuale, Calendar iniziale) {
        
        Calendar tmp = (Calendar) iniziale.clone();
        tmp.add(Calendar.MINUTE, INTERVALLO_SPETTACOLI * (getNUM_ORE() + 1));
        if (attuale.compareTo(tmp) <= 0) {
            // Attuale <= tmp
            return true;
        } else { 
            return false;
        }
    }
    private static void printOraMassima(Calendar ora) {
        Calendar tmp = (Calendar) ora.clone();
        tmp.add(Calendar.MINUTE,INTERVALLO_SPETTACOLI * getNUM_ORE());
        System.out.println("Ora massima: " + tmp.getTime());
    }
    public static boolean isEmpty(ResultSet rs) {
        try {
            return rs.next() != true;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            return  true;
        }
    }
    
    
    public static int nuovoID(String tabella) throws SQLException {
        
        con = getConnection();
        
        tabella = tabella.toUpperCase();
        
        Statement stm = con.createStatement();
        
        ResultSet rs = stm.executeQuery("SELECT ID_" + tabella + " FROM " + tabella + " ORDER BY ID_" + tabella + " DESC");
        
        int nuovoId = 0;
        
        if (rs.next()) {
            // E' necessario mandare avanti la row in quanto il rs di default parte
            // da prima dela prima riga!
            nuovoId = rs.getInt("ID_" + tabella) + 1;
        }
        
        stm.close();
        con.close();
        
        return nuovoId;
      
    }
    
    public static List<String> getAll(String tabella, String campo) {
        
        List<String> res = new ArrayList();
        
        con = getConnection();
        
        try {
            
            String querySelectAllFilm = "SELECT * FROM " + tabella.toUpperCase();
            Statement stm = con.createStatement();
            ResultSet recordSetAllFilm = stm.executeQuery(querySelectAllFilm);
            
            while (recordSetAllFilm.next()) {

                res.add(recordSetAllFilm.getString(campo));
            }
            
            stm.close();
            con.close();
            
            return res;
            
            
        } catch (SQLException e) {
            System.out.println("Errore nel retrive film: " + e.toString());
            return null;
        } 
        
    }
    public static List<String> getFilmPerSala(String film , String sala) {
        
        List<String> res = new ArrayList();
        try {
            con = getConnection();
            String where_film = " FILM.TITOLO = '" + film + "'";
            String where_sala = " SALA.ID_SALA = " + sala + "";
            String where = " WHERE ";
            String and = " AND ";
            
            if (film.equals("")) {
                where_film = "";
            }
            
            if (sala.equals("")) {
                where_sala = "";
                and = "";
            }
            
            if ("".equals(where_sala) && "".equals(where_film)) {
                where = "";
            }
            
           
        
            String querySelectFilmPerSala = "SELECT SPETTACOLO.DATA_ORA, SPETTACOLO.ID_SALA FROM SPETTACOLO " +
                                        " JOIN SALA ON SPETTACOLO.ID_SALA = SALA.ID_SALA" +
                                        " JOIN FILM ON SPETTACOLO.ID_FILM = FILM.ID_FILM " +
                                        where + where_sala + and + where_film;
            
            System.out.println(querySelectFilmPerSala);
            PreparedStatement statement = con.prepareStatement(querySelectFilmPerSala);
            
            //statement.setString(1, sala);
            //statement.setString(2, film);
            
            ResultSet resultSetFilmPerSala = statement.executeQuery();
            
            while (resultSetFilmPerSala.next()) {
                res.add(resultSetFilmPerSala.getTimestamp("data_ora").toString() + ";" + resultSetFilmPerSala.getInt("id_sala"));
            }
            
            statement.close();
            con.close();
            
            return res;
            
        } catch (SQLException e) {
            System.out.println("Errore in select film per sala: " + e.toString());
            return null;
        }
    }
}
