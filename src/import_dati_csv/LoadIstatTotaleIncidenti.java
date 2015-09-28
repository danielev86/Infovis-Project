package import_dati_csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KeyListTerna;

public class LoadIstatTotaleIncidenti {
	
private BufferedReader reader;

    
    public LoadIstatTotaleIncidenti() {
    }
    
    public KeyListTerna load_totale_incidenti() throws IOException{
    	reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dataset/file2.csv")));
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
