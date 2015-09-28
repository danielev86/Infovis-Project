package import_dati_csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KeyProprietaList;

public class LoadIstatMortiProprieta {
    private BufferedReader reader;

    
    
    public LoadIstatMortiProprieta() {
		super();
		// TODO Auto-generated constructor stub
	}



	public KeyProprietaList load_morti_localizzazione() throws IOException{
    	KeyProprietaList istat = new KeyProprietaList();
    	reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dataset/file8.csv")));

    	String line=reader.readLine();
        try {
            while((line=reader.readLine())!=null){
            	String[] nextLine = line.split(",");
                
                istat.aggiungi(nextLine[1], nextLine[0],Integer.parseInt(nextLine[2]), Integer.parseInt(nextLine[3]),Integer.parseInt(nextLine[4]));
                
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(LoadEurostatMorti.class.getName()).log(Level.SEVERE, null, ex);
        }
    	return istat;
    	
    }
	
	public KeyProprietaList load_morti_natura() throws IOException{
    	KeyProprietaList istat = new KeyProprietaList();
    	reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dataset/file9.csv")));


    	String line=reader.readLine();
        try {
            while((line=reader.readLine())!=null){
            	String[] nextLine = line.split(",");
                
                istat.aggiungi(nextLine[1], nextLine[0],Integer.parseInt(nextLine[2]), Integer.parseInt(nextLine[3]),Integer.parseInt(nextLine[4]));
                
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(LoadEurostatMorti.class.getName()).log(Level.SEVERE, null, ex);
        }
    	return istat;
    	
    	
    }
	
	public KeyProprietaList load_morti_classe_eta() throws IOException{
		KeyProprietaList istat = new KeyProprietaList();
    	reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dataset/file10.csv")));

    	String line=reader.readLine();
        try {
            while((line=reader.readLine())!=null){
            	String[] nextLine = line.split(",");
                
                istat.aggiungi(nextLine[1], nextLine[0],Integer.parseInt(nextLine[2]), Integer.parseInt(nextLine[3]),Integer.parseInt(nextLine[4]));
                
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(LoadEurostatMorti.class.getName()).log(Level.SEVERE, null, ex);
        }
    	return istat;
    	
    }

}
