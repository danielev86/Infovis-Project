package chart;

import java.io.IOException;
import java.util.*;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import import_dati_csv.*;
import model.*;

public class IstatMortiIncidentiChart {
	private LoadIstatMortiSesso load;
	private LoadIstatTotaleIncidenti load_incidenti;
	private LoadIstatIncidentiProprieta load_inc_prop;
	private LoadIstatMortiProprieta load_morti_prop;
	private LoadIstatTotaleMorti load_morti;
	private KeyListTerna incidenti ;
	private KeyListTerna morti;

	private KeyProprietaList lims;


	public IstatMortiIncidentiChart() throws IOException {
		load = new LoadIstatMortiSesso();
		load_incidenti = new LoadIstatTotaleIncidenti();
		load_morti = new LoadIstatTotaleMorti();
		load_inc_prop = new LoadIstatIncidentiProprieta();
		load_morti_prop = new LoadIstatMortiProprieta();
		incidenti = load_incidenti.load_totale_incidenti();
		morti = load_morti.load_data();
		lims = load.load_data();
	}

	public XYDataset createDatasetMortiPerSesso(String citta) {
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		TimeSeries s1 = null;
		List<String> lt = new ArrayList<String>();
		lt.add("femmine");
		lt.add("maschi");
		
		for(String it:lt){
			s1 = new TimeSeries(it);
			for (TernaAnnoValorePop iter2 : lims.getList(new CoppiaCittaProp(citta, it))) {
				s1.add(new Year(iter2.getAnno()), iter2.getValore());
			}
			
			dataset.addSeries(s1);

			
		}

		return dataset;
	}

	public CategoryDataset createDatasetMortiIncidentiPerCitta(String citta){
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();		

		for(TernaAnnoValorePop iter:incidenti.getList(citta)){		
			for(TernaAnnoValorePop iter2:morti.getList(citta)){
				if(iter.getAnno()==iter2.getAnno()){
					int prodotto = iter2.getValore()*1000;
					int valore = prodotto/iter.getValore();
					dataset.addValue(valore,"Tasso (Decessi/Incidenti)",String.valueOf(iter.getAnno()));


					
				}

			}


			
		}
		
	
		return dataset;
		
	}
	

	
	public CategoryDataset createDatasetMortiIncidentiCittaLocalizzazione(String citta, String loc) throws IOException{
		KeyProprietaList itmp = load_inc_prop.load_incidenti_localizzazione();
		KeyProprietaList mtmp = load_morti_prop.load_morti_localizzazione();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		
		
		for(TernaAnnoValorePop it:itmp.getList(new CoppiaCittaProp(citta,loc))){
			for(TernaAnnoValorePop it2:mtmp.getList(new CoppiaCittaProp(citta,loc))){
				if(it.getAnno()==it2.getAnno()){
					int prodotto = it2.getValore()*1000;
					int valore = prodotto/it.getValore();
					dataset.addValue(valore, "Tasso (Decessi/Incidenti)", String.valueOf(it.getAnno()));

					
				}
					
			}
				
		}
	
		
		

		
		return dataset;
	}
	
	public CategoryDataset createDatasetMortiIncidentiCittaNatura(String citta, String loc) throws IOException{
		KeyProprietaList itmp  = load_inc_prop.load_incidenti_natura();
		KeyProprietaList mtmp = load_morti_prop.load_morti_natura();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		
		
		for(TernaAnnoValorePop it:itmp.getList(new CoppiaCittaProp(citta,loc))){
			for(TernaAnnoValorePop it2:mtmp.getList(new CoppiaCittaProp(citta,loc))){
				if(it.getAnno()==it2.getAnno()){
					int prodotto = it2.getValore()*1000;
					int valore = prodotto/it.getValore();
					dataset.addValue(valore,"Tasso (Decessi/Incidenti)",String.valueOf(it.getAnno()));
				}
					
			}
				
		}

		

		
		return dataset;
	}
	
	public XYDataset createDatasetIncidentiCittaLocalizzazione(String citta) throws IOException {
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		KeyProprietaList itmp = load_inc_prop.load_incidenti_localizzazione();

		TimeSeries s1 = null;
		List<String> lt = new ArrayList<String>();
		lt.add("altra strada");
		lt.add("autostrada");
		lt.add("strada urbana");
		
		for(String it:lt){
			s1 = new TimeSeries(it);
			for (TernaAnnoValorePop iter2 : itmp.getList(new CoppiaCittaProp(citta, it))) {
				s1.add(new Year(iter2.getAnno()), iter2.getValore());
			}
			
			dataset.addSeries(s1);

			
		}

		return dataset;
	}
	
	public XYDataset createDatasetIncidentiCittaTipoVeicolo(String citta) throws IOException {
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		KeyProprietaList itmp = load_inc_prop.load_incidenti_tipo_veicolo();

		TimeSeries s1 = null;
		List<String> lt = new ArrayList<String>();
		lt.add("altri veicoli");
		lt.add("autobus e filobus");
		lt.add("autocarri e motrici");
		lt.add("autovetture");
		lt.add("ciclomotori");
		lt.add("motocarri");
		lt.add("motocicli");
		lt.add("quadricicli");
		lt.add("tram");
		lt.add("velocipede");
		
		for(String it:lt){
			s1 = new TimeSeries(it);
			for (TernaAnnoValorePop iter2 : itmp.getList(new CoppiaCittaProp(citta, it))) {
				s1.add(new Year(iter2.getAnno()), iter2.getValore());
			}
			
			dataset.addSeries(s1);

			
		}

		return dataset;
	}
	
	public XYDataset createDatasetIncidentiCittaNatura(String citta) throws IOException {
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		KeyProprietaList itmp = load_inc_prop.load_incidenti_natura();

		TimeSeries s1 = null;
		List<String> lt = new ArrayList<String>();
		lt.add("incidente a veicolo isolato");
		lt.add("incidente tra veicoli");
		lt.add("incidente tra veicolo e pedone");
		
		for(String it:lt){
			s1 = new TimeSeries(it);
			for (TernaAnnoValorePop iter2 : itmp.getList(new CoppiaCittaProp(citta, it))) {
				s1.add(new Year(iter2.getAnno()), iter2.getValore());
			}
			
			dataset.addSeries(s1);

			
		}

		return dataset;
	}
	
	public CategoryDataset createDatasetMortiCittaLocalizzazione(String citta) throws IOException{
		KeyProprietaList mtmp = load_morti_prop.load_morti_localizzazione();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		
		List<String> lt = new ArrayList<String>();
		lt.add("altra strada");
		lt.add("autostrada");
		lt.add("strada urbana");
		
		for(String it1:lt){
	
			for(TernaAnnoValorePop it2:mtmp.getList(new CoppiaCittaProp(citta,it1))){
				
				dataset.addValue(it2.getValore(), it1, String.valueOf(it2.getAnno()));
				
			}
			
		}

		
		
		
		return dataset;
	}
	
	public XYDataset createDatasetMortiCittaClasse(String citta) throws IOException {
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		KeyProprietaList itmp = load_morti_prop.load_morti_classe_eta();

		TimeSeries s1 = null;
		List<String> lt = new ArrayList<String>();
		lt.add("fino a 5 anni");
		lt.add("6-9 anni");
		lt.add("10-14 anni");
		lt.add("15-17 anni");
		lt.add("18-20 anni");
		lt.add("21-24 anni");
		lt.add("25-29 anni");
		lt.add("30-44 anni");
		lt.add("45-54 anni");
		lt.add("55-59 anni");
		lt.add("60-64 anni");
		lt.add("65 anni e più");
		
		for(String it:lt){
			s1 = new TimeSeries(it);
			for (TernaAnnoValorePop iter2 : itmp.getList(new CoppiaCittaProp(citta, it))) {
				s1.add(new Year(iter2.getAnno()), iter2.getValore());
			}
			
			dataset.addSeries(s1);

			
		}

		return dataset;
	}
	
	public CategoryDataset createDatasetMortiCittaLocalizzazioneSlider(String citta, int value) throws IOException{
		KeyProprietaList mtmp = load_morti_prop.load_morti_localizzazione();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		
		List<String> lt = new ArrayList<String>();
		lt.add("altra strada");
		lt.add("autostrada");
		lt.add("strada urbana");
		
		for(String it1:lt){
	
			for(TernaAnnoValorePop it2:mtmp.getList(new CoppiaCittaProp(citta,it1))){
				
				if(it2.getValore()>=value)
				
					dataset.addValue(it2.getValore(), it1, String.valueOf(it2.getAnno()));
				
			}
			
		}

		

		
		return dataset;
	}
	
	public DefaultPieDataset createDatasetIncidentiCittaTipoVeicoloPieChart(String citta, int anno) throws IOException {
		DefaultPieDataset dataset = new DefaultPieDataset();
		KeyProprietaList itmp = load_inc_prop.load_incidenti_tipo_veicolo();

		
		List<String> lt = new ArrayList<String>();
		lt.add("altri veicoli");
		lt.add("autobus e filobus");
		lt.add("autocarri e motrici");
		lt.add("autovetture");
		lt.add("ciclomotori");
		lt.add("motocarri");
		lt.add("motocicli");
		lt.add("quadricicli");
		lt.add("tram");
		lt.add("velocipede");
		
	
		for(String it:lt){
			for (TernaAnnoValorePop iter2 : itmp.getList(new CoppiaCittaProp(citta, it))) {
				if(iter2.getAnno()==anno)
					dataset.setValue(it, iter2.getValore());
			}

			
		}

		return dataset;
	}
	
	public DefaultPieDataset createDatasetIncidentiCittaPerLuogoPieChart(String citta, int anno) throws IOException {
		DefaultPieDataset dataset = new DefaultPieDataset();
		KeyProprietaList itmp = load_inc_prop.load_incidenti_localizzazione();

		
		List<String> lt = new ArrayList<String>();
		lt.add("altra strada");
		lt.add("autostrada");
		lt.add("strada urbana");
	
		for(String it:lt){
			for (TernaAnnoValorePop iter2 : itmp.getList(new CoppiaCittaProp(citta, it))) {
				if(iter2.getAnno()==anno)
					dataset.setValue(it, iter2.getValore());
			}

			
		}
		
		return dataset;
	}
	
	
	public DefaultPieDataset createDatasetIncidentiCittaNaturaPieChart(String citta, int anno) throws IOException {
		DefaultPieDataset dataset = new DefaultPieDataset();
		KeyProprietaList itmp = load_inc_prop.load_incidenti_natura();

		List<String> lt = new ArrayList<String>();
		lt.add("incidente a veicolo isolato");
		lt.add("incidente tra veicoli");
		lt.add("incidente tra veicolo e pedone");
	
		for(String it:lt){
			for (TernaAnnoValorePop iter2 : itmp.getList(new CoppiaCittaProp(citta, it))) {
				if(iter2.getAnno()==anno)
					dataset.setValue(it, iter2.getValore());
			}

			
		}

		return dataset;
	}
	
	public DefaultPieDataset createDatasetMortiCittaClassePieChart(String citta, int anno) throws IOException {
		DefaultPieDataset dataset = new DefaultPieDataset();
		KeyProprietaList itmp = load_morti_prop.load_morti_classe_eta();
		List<String> lt = new ArrayList<String>();
		lt.add("fino a 5 anni");
		lt.add("6-9 anni");
		lt.add("10-14 anni");
		lt.add("15-17 anni");
		lt.add("18-20 anni");
		lt.add("21-24 anni");
		lt.add("25-29 anni");
		lt.add("30-44 anni");
		lt.add("45-54 anni");
		lt.add("55-59 anni");
		lt.add("60-64 anni");
		lt.add("65 anni e più");
	
		for(String it:lt){
			for (TernaAnnoValorePop iter2 : itmp.getList(new CoppiaCittaProp(citta, it))) {
				if(iter2.getAnno()==anno)
					dataset.setValue(it, iter2.getValore());
			}

			
		}

		return dataset;
	}
	
	public DefaultPieDataset createDatasetMortiPerSessoPieChart(String citta, int anno) throws IOException {
		DefaultPieDataset dataset = new DefaultPieDataset();
		List<String> lt = new ArrayList<String>();
		lt.add("femmine");
		lt.add("maschi");
	
		for(String it:lt){
			for (TernaAnnoValorePop iter2 : lims.getList(new CoppiaCittaProp(citta, it))) {
				if(iter2.getAnno()==anno)
					dataset.setValue(it, iter2.getValore());
			}

			
		}

		return dataset;
	}
	
	
	

}
