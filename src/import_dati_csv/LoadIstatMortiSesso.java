package import_dati_csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KeyProprietaList;

public class LoadIstatMortiSesso {
	
	private BufferedReader reader;

	public LoadIstatMortiSesso() {
		super();
		// TODO Auto-generated constructor stub
		reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dataset/file7.csv")));

	}
	
	public KeyProprietaList load_data() throws IOException{
		KeyProprietaList istat = new KeyProprietaList();
        String line=reader.readLine();
        try {
            while((line=reader.readLine())!=null){
            	String[] nextLine = line.split(",");
                
                istat.aggiungi(nextLine[0], nextLine[1],Integer.parseInt(nextLine[2]), Integer.parseInt(nextLine[3]),Integer.parseInt(nextLine[4]));
                
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(LoadEurostatMorti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return istat;
		
	}
	


}
