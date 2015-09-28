package import_dati_csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.opencsv.CSVReader;
import model.KeyListTerna;

public class LoadIstatTotaleMorti {
    private BufferedReader reader;

    
    public LoadIstatTotaleMorti() {
    }
    
    public KeyListTerna load_data() throws IOException{
    	reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dataset/file6.csv")));

    	KeyListTerna istat = new KeyListTerna();
        String line=reader.readLine();
        try {
            while((line=reader.readLine())!=null){
            	String[] nextLine = line.split(",");
                
                istat.aggiungi(nextLine[0], Integer.parseInt(nextLine[1]), Integer.parseInt(nextLine[2]),Integer.parseInt(nextLine[3]));
                
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(LoadEurostatMorti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return istat;
    }
    
    

}
