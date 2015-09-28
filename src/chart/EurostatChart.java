package chart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JInternalFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;

import import_dati_csv.LoadEurostatMorti;
import model.CoppiaAnnoValore;
import model.KeyListTerna;
import model.TernaAnnoValorePop;

public class EurostatChart {
	private LoadEurostatMorti load;
	private KeyListTerna euro;

	public EurostatChart() throws IOException {
		load = new LoadEurostatMorti();
		euro = load.load_data();

	}

	public LoadEurostatMorti getLoad() {
		return load;
	}

	public void setLoad(LoadEurostatMorti load) {
		this.load = load;
	}



	public KeyListTerna getEuro() {
		return euro;
	}

	public void setEuro(KeyListTerna euro) {
		this.euro = euro;
	}

	public CategoryDataset createDataset(int anno) throws IOException {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (String nazione : euro.getListOrdinataChiavi()) {
			for (TernaAnnoValorePop coppia : euro.getList(nazione)) {
				if (coppia.getAnno() == anno && coppia.getValore()>0)
					dataset.addValue(coppia.getValore(), nazione + "=" + coppia.getPopolazione(),
							String.valueOf(coppia.getAnno()));

			}
		}

		return dataset;
	}


	public CategoryDataset createDatasetPeriodo(int anno1, int anno2) throws IOException {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (String nazione : euro.getListOrdinataChiavi()) {
			for (TernaAnnoValorePop coppia : euro.getList(nazione)) {
				if ((coppia.getAnno() >= anno1) && (coppia.getAnno() <= anno2))
					dataset.addValue(coppia.getValore(), nazione, String.valueOf(coppia.getAnno()));

			}
		}

		return dataset;
	}

	public XYDataset createDatasetPerNazione(String country) throws IOException {
		TimeSeries s1 = new TimeSeries(country);

		for (TernaAnnoValorePop coppia : euro.getList(country)) {

			s1.add(new Year(coppia.getAnno()), coppia.getValore());

		}
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);
		return dataset;
	}



	public XYDataset createDatasetNazioni() throws IOException {

		TimeSeriesCollection dataset = new TimeSeriesCollection();

		for (String nazione : euro.getListOrdinataChiavi()) {
			TimeSeries s1 = new TimeSeries(nazione);
			for (TernaAnnoValorePop coppia : euro.getList(nazione)) {
				s1.add(new Year(coppia.getAnno()), coppia.getValore());
			}
			dataset.addSeries(s1);
		}

		return dataset;
	}



	public CategoryDataset createDatasetSlider(int anno, int value) throws IOException {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (String nazione : euro.getListOrdinataChiavi()) {
			for (TernaAnnoValorePop coppia : euro.getList(nazione)) {
				if (coppia.getAnno() == anno && coppia.getValore() >= value && coppia.getValore()>0)
					dataset.addValue(coppia.getValore(), nazione + "=" + coppia.getPopolazione(),
							String.valueOf(coppia.getAnno()));

			}
		}

		return dataset;
	}

	public CategoryDataset createDatasetPeriodoSlider(int anno1, int anno2, int value) throws IOException {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (String nazione : euro.getListOrdinataChiavi()) {
			for (TernaAnnoValorePop coppia : euro.getList(nazione)) {
				if ((coppia.getAnno() >= anno1) && (coppia.getAnno() <= anno2) && (coppia.getValore() >= value))
					dataset.addValue(coppia.getValore(), nazione, String.valueOf(coppia.getAnno()));

			}
		}

		return dataset;
	}


	public DefaultPieDataset createDatasetNazioniSlider(int anno) throws IOException {
		final DefaultPieDataset dataset = new DefaultPieDataset();
		for (String nazione : euro.getListOrdinataChiavi()) {
			for (TernaAnnoValorePop coppia : euro.getList(nazione)) {
				if (coppia.getAnno() == anno)
					dataset.setValue(nazione+"="+coppia.getPopolazione(), (coppia.getValore()*100000)/coppia.getPopolazione());

			}
		}

		return dataset;
	}


	public DefaultPieDataset createDatasetNazioniPeriodoPie(int anno1, int anno2) throws IOException {
		final DefaultPieDataset dataset = new DefaultPieDataset();
		Map<String, Integer> tmp = new HashMap<String, Integer>();
		for (String nazione : euro.getListOrdinataChiavi()) {
			for (TernaAnnoValorePop coppia : euro.getList(nazione)) {
				if ((coppia.getAnno() >= anno1) && (coppia.getAnno() <= anno2) && coppia.getValore()>0) {
					if (tmp.containsKey(nazione)) {
						Integer tot = coppia.getValore() + tmp.get(nazione);
						tmp.put(nazione, tot);
					} else {
						tmp.put(nazione, coppia.getValore());
					}

				}
			}
		}
		for (String nazione : tmp.keySet()) {
			dataset.setValue(nazione, tmp.get(nazione));

		}

		return dataset;
	}

}
