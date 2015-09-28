/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package import_dati_csv;
import com.opencsv.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KeyListTerna;
/**
 *
 * @author daniele
 */
public class LoadEurostatMorti {
    
    private BufferedReader reader;


    public LoadEurostatMorti() {
        	reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dataset/file1.csv")));
       
    }
    
  
    
    public KeyListTerna load_data() throws IOException{
    	KeyListTerna eurostat = new KeyListTerna();
        String line = reader.readLine();
       
        try {
            while((line=reader.readLine())!=null){
            	String[] nextLine = line.split(",");
            	
                
                if(nextLine[2].equals(":")){
                    eurostat.aggiungi(nextLine[1], Integer.parseInt(nextLine[0]), 0,Integer.parseInt(nextLine[3]));
                }else{
                    eurostat.aggiungi(nextLine[1], Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[2]),Integer.parseInt(nextLine[3].replace(" ", "")));
                }
                
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(LoadEurostatMorti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eurostat;
    }
    
    
    
    
    
}
