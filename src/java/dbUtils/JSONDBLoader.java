package dbUtils;

import db.DBManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONDBLoader {
   
    public static void main(String argv[]) {
        
        FileReader fr = null;   
        try {
            File f = new File(".");
            
            String jsonPath = f.getAbsolutePath().substring(0, f.getAbsolutePath().length() -1) + "/web/Other/film.json";
            fr = new FileReader(jsonPath);
            
            BufferedReader bf = new BufferedReader(fr);
            
            boolean avanti = true;
            List<Map> film = new ArrayList<Map>();
            
            Map tmp = new HashMap();
            
            try {   
                while (avanti) {
                    
                    String riga = bf.readLine();
                    
                    if (riga != null) {
                        
                        switch (riga.trim()) {
                            case "[":
                                //System.out.println("Entra[");
                                // Inizio l'array
                                break;
                            case "{":
                                //System.out.println("Entra{");
                                // Devo creare un oggetto Map
                                tmp = new HashMap();
                                break;
                            case "},":
                                // Qui devo salvare i dati!
                                //System.out.println("Entra},");
                                break;
                            default:
                                // qui ho i dati!
                                //String[] coppia = new String[2];
                                //System.out.println(riga);
                                String[] coppia = riga.split(":");
                                
                                tmp.put(coppia[0], coppia[1]);
                                //System.out.println(coppia[1]);
                                break;
                        }
                        
                    } else {
                        avanti = false;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(JSONDBLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONDBLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(JSONDBLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
           
        
    }
    
}
