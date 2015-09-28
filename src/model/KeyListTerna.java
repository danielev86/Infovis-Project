package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyListTerna {
	
	private Map<String,List<TernaAnnoValorePop>> mappa;

	public KeyListTerna() {
		super();
		// TODO Auto-generated constructor stub
		mappa = new HashMap<String,List<TernaAnnoValorePop>>();
	}
	
	public Map<String, List<TernaAnnoValorePop>> getMappa() {
        return mappa;
    }

    public void setMappa(Map<String, List<TernaAnnoValorePop>> mappa) {
        this.mappa = mappa;
    }
    
    public void aggiungi(String key,int anno,int valore,int popolazione){
        if(this.mappa.keySet().contains(key)){
            List<TernaAnnoValorePop> listaTmp = mappa.get(key);
            listaTmp.add(new TernaAnnoValorePop(anno,valore,popolazione));
            mappa.put(key, listaTmp);
        }else {
            List<TernaAnnoValorePop> listaTmp = new ArrayList<TernaAnnoValorePop>();
            listaTmp.add(new TernaAnnoValorePop(anno,valore,popolazione));
            mappa.put(key, listaTmp);
        }
        
    }
    
    public List<TernaAnnoValorePop> getList(String key){
        return mappa.get(key);
    }
    
    public List<String> getListOrdinataChiavi(){
    	List<String> lista = new ArrayList<String>();
    	for(String s:mappa.keySet())
    		lista.add(s);
    	Collections.sort(lista);
    	return lista;
    }


}
