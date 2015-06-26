/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtils;

import java.util.Date;

/**
 *
 * @author Andrea
 */
public class SalaManager {
    
    SalaManager() {
        
    }
    
    public static double trovaSalaOrario(int sala, Date orario) {
        return ((double) sala + orario.getTime());
    }
    
    
    
}
