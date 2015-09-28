package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyProprietaList {
	private Map<CoppiaCittaProp,List<TernaAnnoValorePop>> mappa;

	public KeyProprietaList() {
		super();
		// TODO Auto-generated constructor stub
		mappa = new HashMap<CoppiaCittaProp,List<TernaAnnoValorePop>>();
	}
	
	public Map<CoppiaCittaProp,List<TernaAnnoValorePop>> getMappa() {
        return mappa;
    }

  
    
    public void aggiungi(String citta,String proprieta,int anno,int valore,int popolazione){
    	CoppiaCittaProp tmp = new CoppiaCittaProp(citta,proprieta);
        if(mappa.containsKey(tmp)){
        	List<TernaAnnoValorePop> listaTmp = mappa.get(tmp);
        	listaTmp.add(new TernaAnnoValorePop(anno,valore,popolazione));
        	mappa.put(tmp, listaTmp);
        	
        }else{
        	List<TernaAnnoValorePop> listaTmp = new ArrayList<TernaAnnoValorePop>();
        	listaTmp.add(new TernaAnnoValorePop(anno,valore,popolazione));
        	mappa.put(tmp, listaTmp);

        	
        }
        
    }
    
    public List<TernaAnnoValorePop> getList(CoppiaCittaProp cpp){
        return mappa.get(cpp);
    }
    
    public List<CoppiaCittaProp> getListOrdinataChiavi(){
    	List<CoppiaCittaProp> lista = new ArrayList<CoppiaCittaProp>();
    	for(CoppiaCittaProp s:mappa.keySet())
    		lista.add(s);
    	Collections.sort(lista, new Comparator<CoppiaCittaProp>(){
    		public int compare(CoppiaCittaProp c1, CoppiaCittaProp c2){
    			return (c1.getCitta().compareTo(c2.getCitta()));
    		}
    		
    	});
    	return lista;
    }
    

}
