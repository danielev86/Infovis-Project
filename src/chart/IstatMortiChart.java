package chart;

import java.io.IOException;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;

import import_dati_csv.LoadIstatTotaleMorti;
import model.KeyListTerna;
import model.TernaAnnoValorePop;

public class IstatMortiChart {
	
	private LoadIstatTotaleMorti load;
	private KeyListTerna istat;
	
	public IstatMortiChart() throws IOException{
		load = new LoadIstatTotaleMorti();
		istat = load.load_data();
	}
	
	public XYDataset createDatasetCitta() throws IOException{
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		for(String citta:istat.getListOrdinataChiavi()){
			TimeSeries s1 = new TimeSeries(citta);
			for(TernaAnnoValorePop coppia:istat.getList(citta)){
				
				s1.addOrUpdate(new Year(coppia.getAnno()), (coppia.getValore()*100000)/coppia.getPopolazione());
				
			}
			dataset.addSeries(s1);

		}
		
		return dataset;
		
	}
	
	public XYDataset createDatasetNazioneCitta(String nazione,EurostatChart eurostat) throws IOException{
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		TimeSeries 	s1 = new TimeSeries(nazione);

		for(TernaAnnoValorePop coppia:eurostat.getEuro().getList(nazione)){
			s1.add(new Year(coppia.getAnno()), (coppia.getValore()*100000)/coppia.getPopolazione());

		}
		dataset.addSeries(s1);
		for(String citta:istat.getListOrdinataChiavi()){
			TimeSeries s2 = new TimeSeries(citta);
			for(TernaAnnoValorePop coppia:istat.getList(citta)){
				
				s2.add(new Year(coppia.getAnno()), (coppia.getValore()*100000)/coppia.getPopolazione());
				
			}
			dataset.addSeries(s2);

		}
		
		return dataset;
		
	}
	public CategoryDataset createDatasetNazioneCittaPeriodo(String nazione,EurostatChart eurostat, int anno1, int anno2) throws IOException{
	
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for(TernaAnnoValorePop coppia:eurostat.getEuro().getList(nazione)){
			if((coppia.getAnno() >= anno1) && (coppia.getAnno() <= anno2))
				dataset.addValue(coppia.getValore(), nazione+"="+coppia.getPopolazione(), String.valueOf(coppia.getAnno()));
		}
		for(String citta:istat.getListOrdinataChiavi()){
			for(TernaAnnoValorePop coppia:istat.getList(citta)){
				if((coppia.getAnno() >= anno1) && (coppia.getAnno() <= anno2))
					dataset.addValue(coppia.getValore(), citta+"="+coppia.getPopolazione(), String.valueOf(coppia.getAnno()));				
			}
			

		}
		
		return dataset;
		
	}
	
	public CategoryDataset createDatasetNazioneCittaAnno(String nazione,EurostatChart eurostat, int anno1) throws IOException{
		
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for(TernaAnnoValorePop coppia:eurostat.getEuro().getList(nazione)){
			if((coppia.getAnno() == anno1))
				dataset.addValue((coppia.getValore()*100000)/coppia.getPopolazione(), nazione+"="+coppia.getPopolazione(), String.valueOf(coppia.getAnno()));
		}
		for(String citta:istat.getListOrdinataChiavi()){
			for(TernaAnnoValorePop coppia:istat.getList(citta)){
				if((coppia.getAnno() == anno1))
					dataset.addValue((coppia.getValore()*100000)/coppia.getPopolazione(), citta+"="+coppia.getPopolazione(), String.valueOf(coppia.getAnno()));				
			}
			

		}
		
		return dataset;
		
	}
	public DefaultPieDataset createDatasetCittaPieChart(int value) throws IOException{
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(String citta:istat.getListOrdinataChiavi()){
			for(TernaAnnoValorePop coppia:istat.getList(citta)){
				
				if(coppia.getAnno()==value)
					dataset.setValue(citta+"="+coppia.getPopolazione(), (coppia.getValore()*1000000)/coppia.getPopolazione());
			}

		}
		
		return dataset;
	
		
	}

}
