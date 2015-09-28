package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;

import chart.EurostatChart;
import chart.IstatMortiChart;
import chart.IstatMortiIncidentiChart;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;

public class Home extends JFrame {

	/* Inizio Variabili per pannello Eurostat */
	private ChartPanel chPanelEu;
	private JFreeChart chartEu;
	private JComboBox cbEu1;
	private JInternalFrame internalFrame;
	private JComboBox cmbViewEuAnno, cmbEuPeriodo1, cmbEuPeriodo2;
	private EurostatChart eurostatchart;
	private JSlider sldFilterEuAnno;
	private JSlider sldFilterEuDecessiAnno;

	/* Fine Variabili per pannello Eurostat */
	/* Inizio Variabili per secondo pannellot */
	private IstatMortiChart istatMorti;
	private JComboBox cmbNazione1, cmbAnno1, cmbNazione2;
	private JInternalFrame internalFrame_1;
	private ChartPanel chPanel2;
	private JFreeChart chart2;
	private JSlider sldFilterAnnoDecessiCittaIta;
	/* Fine Variabili per pannello Eurostat/Istat */
	/* Inizio Variabili per pannello Istat Incidenti/Morti */
	private JInternalFrame internalFrame_2;
	private ChartPanel chPanel3;
	private JFreeChart chart3;
	private JComboBox cmbCittaDecessiIncidenti1, cmbCittaDecessiMorti, cmbCittaDecessiIncidenti2, cmbDecessiIncidentiTipo, cmbCittaDecessiIncidenti3, cmbDecessiIncidentiNatura;
	private IstatMortiIncidentiChart imi;
	private JPanel panel_3;
	private JSlider sldDecessiCittaSesso;
	/* Fine Variabili per pannello Istat Incidenti/Decessi */
	private JInternalFrame internalFrame_3;
	private ChartPanel chPanel4;
	private JFreeChart chart4;
	private JComboBox cmbIncidentiCitta1, cmbIncidentiCitta2, cmbIncidentiCitta3, cmbDecessiCittaClasseEta, cmbDecessiCittaLuogo;
	private JPanel panel_4;
	private JSlider sldFiltraDecessiLuogo;
	private Font font = new Font("Serif", Font.ITALIC, 10);
	private JButton btnReset;
	private JButton btnReset_1;
	private JSlider sldIncidentiCitta1;
	private JLabel lblVisualizzaPerAnno_2;
	private JLabel lblVisualizzaPerAnno_3;
	private JSlider sldIncidentiCitta2;
	private JSlider sldIncidentiCitta3;
	private JSlider sldDecessiCittaClasse;
	private JLabel lblVisualizzaPerAnno_5;
	private JSeparator separator;

	/* Fine Variabili per pannello Istat Varie Statistiche */

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
					frame.setTitle("VISUALIZZAZIONE OPEN DATA EUROPEO ED ITALIANO");
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	
	public void setColori(CategoryPlot plot) {

		plot.getRenderer().setSeriesPaint(0, new Color(255,155,0));
		plot.getRenderer().setSeriesPaint(1, new Color(0,127,255));
		plot.getRenderer().setSeriesPaint(2, new Color(144,132,53));
		plot.getRenderer().setSeriesPaint(3, new Color(255,228,196));
		plot.getRenderer().setSeriesPaint(4, new Color(205,127,50));
		plot.getRenderer().setSeriesPaint(5, new Color(244,0,61));
		plot.getRenderer().setSeriesPaint(6, new Color(255,255,0));
		plot.getRenderer().setSeriesPaint(7, new Color(201,160,220));
		plot.getRenderer().setSeriesPaint(8, new Color(128,128,128));
		plot.getRenderer().setSeriesPaint(9, new Color(230,230,250));
		plot.getRenderer().setSeriesPaint(10, new Color(150,75,0));
		plot.getRenderer().setSeriesPaint(11, new Color(0,0,0));
		plot.getRenderer().setSeriesPaint(12, new Color(204,119,34));
		plot.getRenderer().setSeriesPaint(13, new Color(102,0,102));
		plot.getRenderer().setSeriesPaint(14, new Color(255,192,203));
		plot.getRenderer().setSeriesPaint(15, new Color(255,0,0));
		plot.getRenderer().setSeriesPaint(16, new Color(186,98,98));
		plot.getRenderer().setSeriesPaint(17, new Color(65,0,18));
		plot.getRenderer().setSeriesPaint(18, new Color(208,240,192));
		plot.getRenderer().setSeriesPaint(19, new Color(0,255,0));
		plot.getRenderer().setSeriesPaint(20, new Color(0,0,255));
		plot.getRenderer().setSeriesPaint(21, new Color(152,105,96));
		plot.getRenderer().setSeriesPaint(22, new Color(255,253,208));
		plot.getRenderer().setSeriesPaint(23, new Color(247,232,159));
		plot.getRenderer().setSeriesPaint(24, new Color(47,79,79));
		plot.getRenderer().setSeriesPaint(25, new Color(204,255,0));
		plot.getRenderer().setSeriesPaint(26, new Color(204,204,255));
		plot.getRenderer().setSeriesPaint(27, new Color(128,0,0));
		plot.getRenderer().setSeriesPaint(28, new Color(255,0,255));
		plot.getRenderer().setSeriesPaint(29, new Color(112,66,20));
		plot.getRenderer().setSeriesPaint(30, new Color(150,222,209));

	
		







	}
	
	public void setColoriPie(PiePlot plot) {

		plot.setSectionPaint(0, new Color(255,155,0));
		plot.setSectionPaint(1, new Color(0,127,255));
		plot.setSectionPaint(2, new Color(144,132,53));
		plot.setSectionPaint(3, new Color(255,228,196));
		plot.setSectionPaint(4, new Color(205,127,50));
		plot.setSectionPaint(5, new Color(244,0,61));
		plot.setSectionPaint(6, new Color(255,255,0));
		plot.setSectionPaint(7, new Color(201,160,220));
		plot.setSectionPaint(8, new Color(128,128,128));
		plot.setSectionPaint(9, new Color(230,230,250));
		plot.setSectionPaint(10, new Color(150,75,0));
		plot.setSectionPaint(11, new Color(100,20,30));
		plot.setSectionPaint(12, new Color(204,119,34));
		plot.setSectionPaint(13, new Color(102,0,102));
		plot.setSectionPaint(14, new Color(255,192,203));
		plot.setSectionPaint(15, new Color(255,0,0));
		plot.setSectionPaint(16, new Color(186,98,98));
		plot.setSectionPaint(17, new Color(65,0,18));
		plot.setSectionPaint(18, new Color(208,240,192));
		plot.setSectionPaint(19, new Color(0,255,0));
		plot.setSectionPaint(20, new Color(0,0,255));
		plot.setSectionPaint(21, new Color(152,105,96));
		plot.setSectionPaint(22, new Color(255,253,208));
		plot.setSectionPaint(23, new Color(247,232,159));
		plot.setSectionPaint(24, new Color(47,79,79));
		plot.setSectionPaint(25, new Color(204,255,0));
		plot.setSectionPaint(26, new Color(204,204,255));
		plot.setSectionPaint(27, new Color(128,0,0));
		plot.setSectionPaint(28, new Color(255,0,255));
		plot.setSectionPaint(29, new Color(112,66,20));
		plot.setSectionPaint(30, new Color(150,222,209));

	
		







	}
	
	public void setColoriSerie(XYPlot plot) {

		plot.getRenderer().setSeriesPaint(0, new Color(255,155,0));
		plot.getRenderer().setSeriesPaint(1, new Color(0,127,255));
		plot.getRenderer().setSeriesPaint(2, new Color(144,132,53));
		plot.getRenderer().setSeriesPaint(3, new Color(255,228,196));
		plot.getRenderer().setSeriesPaint(4, new Color(205,127,50));
		plot.getRenderer().setSeriesPaint(5, new Color(244,0,61));
		plot.getRenderer().setSeriesPaint(6, new Color(255,255,0));
		plot.getRenderer().setSeriesPaint(7, new Color(201,160,220));
		plot.getRenderer().setSeriesPaint(8, new Color(128,128,128));
		plot.getRenderer().setSeriesPaint(9, new Color(230,230,250));
		plot.getRenderer().setSeriesPaint(10, new Color(150,75,0));
		plot.getRenderer().setSeriesPaint(11, new Color(100,20,30));
		plot.getRenderer().setSeriesPaint(12, new Color(204,119,34));
		plot.getRenderer().setSeriesPaint(13, new Color(102,0,102));
		plot.getRenderer().setSeriesPaint(14, new Color(255,192,203));
		plot.getRenderer().setSeriesPaint(15, new Color(255,0,0));
		plot.getRenderer().setSeriesPaint(16, new Color(186,98,98));
		plot.getRenderer().setSeriesPaint(17, new Color(65,0,18));
		plot.getRenderer().setSeriesPaint(18, new Color(208,240,192));
		plot.getRenderer().setSeriesPaint(19, new Color(0,255,0));
		plot.getRenderer().setSeriesPaint(20, new Color(0,0,255));
		plot.getRenderer().setSeriesPaint(21, new Color(152,105,96));
		plot.getRenderer().setSeriesPaint(22, new Color(255,253,208));
		plot.getRenderer().setSeriesPaint(23, new Color(247,232,159));
		plot.getRenderer().setSeriesPaint(24, new Color(47,79,79));
		plot.getRenderer().setSeriesPaint(25, new Color(204,255,0));
		plot.getRenderer().setSeriesPaint(26, new Color(204,204,255));
		plot.getRenderer().setSeriesPaint(27, new Color(128,0,0));
		plot.getRenderer().setSeriesPaint(28, new Color(255,0,255));
		plot.getRenderer().setSeriesPaint(29, new Color(112,66,20));
		plot.getRenderer().setSeriesPaint(30, new Color(150,222,209));

	
		







	}

	public Home() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 700);

		eurostatchart = new EurostatChart();
		imi = new IstatMortiIncidentiChart();
		getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 12, 1280, 700);
		getContentPane().add(tabbedPane);
		JPanel panel = new JPanel();
		tabbedPane.addTab("EUROSTAT INCIDENTI MORTALI", null, panel, null);
		panel.setLayout(null);
		JLabel lblVisualizzaPerAnno = new JLabel("Visualizza per anno");
		lblVisualizzaPerAnno.setBounds(12, 29, 188, 15);
		panel.add(lblVisualizzaPerAnno);
		Integer[] array = { 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013 };
		cmbViewEuAnno = new JComboBox(array);
		cmbViewEuAnno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sldFilterEuAnno.setValue(0);
					internalFrame.remove(chPanelEu);
					internalFrame.revalidate();
					CategoryDataset dataset = eurostatchart.createDataset((Integer) cmbViewEuAnno.getSelectedItem());
					ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
					BarRenderer.setDefaultBarPainter(new StandardBarPainter());

					chartEu = ChartFactory.createBarChart("",
							"Anno", "Vittime Stradali", dataset, PlotOrientation.VERTICAL, true, true, false);
					setColori(chartEu.getCategoryPlot());
					CategoryItemRenderer render = chartEu.getCategoryPlot().getRenderer();
					render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
					render.setItemLabelFont(font);
					render.setItemLabelsVisible(true);

					chPanelEu = new ChartPanel(chartEu);

					internalFrame.getContentPane().add(chPanelEu);

				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

			}
		});
		cmbViewEuAnno.setBounds(26, 56, 125, 24);
		panel.add(cmbViewEuAnno);
		internalFrame = new JInternalFrame("Statistiche Morte Europa Eurostat");
		internalFrame.setBounds(388, 12, 875, 623);
		panel.add(internalFrame);
		internalFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		internalFrame.setVisible(true);
		chPanelEu = new ChartPanel(chartEu);

		internalFrame.getContentPane().add(chPanelEu);
		JLabel lblVisualizzaPerPeriodo = new JLabel("Visualizza per periodo");
		lblVisualizzaPerPeriodo.setBounds(12, 207, 188, 15);
		panel.add(lblVisualizzaPerPeriodo);
		cmbEuPeriodo1 = new JComboBox(array);
		cmbEuPeriodo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					internalFrame.remove(chPanelEu);
					internalFrame.revalidate();
					cmbEuPeriodo2.setSelectedIndex(cmbEuPeriodo1.getSelectedIndex()+1);
					DefaultPieDataset dataset = eurostatchart.createDatasetNazioniPeriodoPie(
							(Integer) cmbEuPeriodo1.getSelectedItem(), (Integer) cmbEuPeriodo2.getSelectedItem());

					chartEu = ChartFactory.createPieChart3D("Vittime UE Per Periodo:" + cmbEuPeriodo1.getSelectedItem()
							+ "/" + cmbEuPeriodo2.getSelectedItem(), dataset, true, true, false);
					setColoriPie((PiePlot) chartEu.getPlot());

					chPanelEu = new ChartPanel(chartEu);
					internalFrame.getContentPane().add(chPanelEu);

				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		cmbEuPeriodo1.setBounds(26, 257, 125, 24);
		panel.add(cmbEuPeriodo1);
		cmbEuPeriodo2 = new JComboBox(array);
		cmbEuPeriodo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					internalFrame.remove(chPanelEu);
					internalFrame.revalidate();
					DefaultPieDataset dataset = eurostatchart.createDatasetNazioniPeriodoPie(
							(Integer) cmbEuPeriodo1.getSelectedItem(), (Integer) cmbEuPeriodo2.getSelectedItem());

					chartEu = ChartFactory.createPieChart3D("Vittime UE Per Periodo:" + cmbEuPeriodo1.getSelectedItem()
							+ "/" + cmbEuPeriodo2.getSelectedItem(), dataset, true, true, false);
					setColoriPie((PiePlot) chartEu.getPlot());

					chPanelEu = new ChartPanel(chartEu);
					internalFrame.getContentPane().add(chPanelEu);

				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		cmbEuPeriodo2.setBounds(182, 257, 125, 24);
		panel.add(cmbEuPeriodo2);

		JLabel lblVisualizzaPerNazione = new JLabel("Visualizza per nazioni");
		lblVisualizzaPerNazione.setBounds(12, 413, 188, 15);
		panel.add(lblVisualizzaPerNazione);
		JButton btViewEuDecessi = new JButton("View");
		btViewEuDecessi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					internalFrame.remove(chPanelEu);
					internalFrame.revalidate();
					XYDataset dataset = eurostatchart.createDatasetNazioni();
					chartEu = ChartFactory.createTimeSeriesChart(
							"Nb: Gli elementi nulli corrispondono a dati non pervenuti", // title
							"Anno", // x-axis label
							"Morti Nazione Per Anno", // y-axis label
							dataset, // data
							true, // create legend?
							true, // generate tooltips?
							false // generate URLs?
					);
					setColoriSerie(chartEu.getXYPlot());
					chartEu.getXYPlot().setBackgroundPaint(Color.BLACK);
					chPanelEu = new ChartPanel(chartEu);
					chartEu.getXYPlot().setDomainPannable(true);

					chPanelEu.setMouseWheelEnabled(true);
					chPanelEu.setMouseZoomable(true);
					chPanelEu.setRangeZoomable(false);
					internalFrame.getContentPane().add(chPanelEu);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btViewEuDecessi.setBounds(26, 440, 125, 25);
		panel.add(btViewEuDecessi);

		JLabel lblFiltraMortiAnno = new JLabel("Filtra morti per anno");
		lblFiltraMortiAnno.setBounds(26, 102, 174, 15);
		panel.add(lblFiltraMortiAnno);

		sldFilterEuAnno = new JSlider(JSlider.HORIZONTAL, 0, 3000, 0);
		sldFilterEuAnno.setMajorTickSpacing(500);
		sldFilterEuAnno.setPaintLabels(true);
		sldFilterEuAnno.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				try {
					internalFrame.remove(chPanelEu);
					internalFrame.revalidate();
					CategoryDataset dataset = eurostatchart.createDatasetSlider((Integer) cmbViewEuAnno.getSelectedItem(),
							(Integer) sldFilterEuAnno.getValue());
					ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
					BarRenderer.setDefaultBarPainter(new StandardBarPainter());
					chartEu = ChartFactory.createBarChart("",
							"Anno", "Vittime Stradali", dataset, PlotOrientation.VERTICAL, true, true, false);
					CategoryItemRenderer render = chartEu.getCategoryPlot().getRenderer();
					render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
					render.setItemLabelFont(font);
					render.setItemLabelsVisible(true);
					setColori(chartEu.getCategoryPlot());

					chPanelEu = new ChartPanel(chartEu);
					chPanelEu.setVisible(true);
					chPanelEu.setMouseWheelEnabled(true);
					chPanelEu.setMouseZoomable(true);
					internalFrame.getContentPane().add(chPanelEu);

				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		sldFilterEuAnno.setBounds(24, 131, 321, 24);
		panel.add(sldFilterEuAnno);

		JLabel lblVisualizzaPerAnno_6 = new JLabel("Filtra per anno");
		lblVisualizzaPerAnno_6.setBounds(26, 492, 174, 15);
		panel.add(lblVisualizzaPerAnno_6);

		sldFilterEuDecessiAnno = new JSlider(JSlider.HORIZONTAL, 2004, 2013, 2004);
		sldFilterEuDecessiAnno.setMajorTickSpacing(1);
		sldFilterEuDecessiAnno.setPaintLabels(true);
		sldFilterEuDecessiAnno.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				internalFrame.remove(chPanelEu);
				internalFrame.revalidate();
				try {
					DefaultPieDataset dataset;

					dataset = eurostatchart.createDatasetNazioniSlider(sldFilterEuDecessiAnno.getValue());
					chartEu = ChartFactory.createPieChart3D(
							"Tasso Decessi/Numero Abitanti per nazioni incidenti:" + sldFilterEuDecessiAnno.getValue()
									+ "(I valori nella legenda rappresentano numero abitanti)", // chart
							// title
							dataset, // data
							true, // include legend
							true, false);
					setColoriPie((PiePlot) chartEu.getPlot());
					chPanelEu = new ChartPanel(chartEu);
					internalFrame.getContentPane().add(chPanelEu);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		sldFilterEuDecessiAnno.setBounds(26, 531, 354, 31);
		panel.add(sldFilterEuDecessiAnno);

		/*----------------------------------Fine Implementazione Pannello Numero Uno-------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------------------------
		 */

		istatMorti = new IstatMortiChart();

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("CONFRONTO INCENTI MORTALI CITTA ITALIANE/EUROPA", null, panel_1, null);
		panel_1.setLayout(null);
		internalFrame_1 = new JInternalFrame("Confronto Morti Incidenti Statali Istat/Eurostat");
		internalFrame_1.setBounds(403, 12, 860, 621);
		panel_1.add(internalFrame_1);
		internalFrame_1.setVisible(true);
		chPanel2 = new ChartPanel(chart2);
		internalFrame_1.getContentPane().add(chPanel2);
		String[] arrayNazioni = { "Seleziona Nazione", "Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus",
				"Czech Republic", "Denmark", "Estonia", "Finland", "France",
				"Germany(until 1990 former territory of the FRG)", "Greece", "Hungary", "Iceland", "Ireland", "Latvia",
				"Liechtenstein", "Luxembourg", "Malta", "Netherlands", "Norway", "Poland", "Portugal", "Romania",
				"Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "United Kingdom" };
		JLabel lblConfrontaNazionePer = new JLabel("Confronto nazione per anno con citta italiane");
		lblConfrontaNazionePer.setBounds(12, 12, 362, 15);
		panel_1.add(lblConfrontaNazionePer);

		JLabel lblNewLabel = new JLabel("Confronto nazione con citta italiane");
		lblNewLabel.setBounds(12, 177, 362, 15);
		panel_1.add(lblNewLabel);

		JLabel lblVisualizzaMortiCitta = new JLabel("Visualizza deceduti citta italiane");
		lblVisualizzaMortiCitta.setBounds(12, 354, 362, 15);
		panel_1.add(lblVisualizzaMortiCitta);

		cmbNazione1 = new JComboBox(arrayNazioni);
		cmbNazione1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = (String) cmbNazione1.getSelectedItem();
				if (!val.equals("Seleziona Nazione")) {
					cmbAnno1.setEnabled(true);
					cmbNazione2.setSelectedIndex(0);
					try {
						internalFrame_1.remove(chPanel2);
						internalFrame_1.revalidate();
						CategoryDataset dataset = istatMorti.createDatasetNazioneCittaAnno(
								(String) cmbNazione1.getSelectedItem(), eurostatchart,
								(Integer) cmbAnno1.getSelectedItem());
						chart2 = ChartFactory.createBarChart3D(
								"Rapporto decessi/popolazione per anno(Nb: Gli elementi nulli corrispondono a dati non pervenuti)",
								"Anno", "Morti Citta/Nazione Per Anno", dataset, PlotOrientation.VERTICAL, true, true,
								false);
						CategoryItemRenderer render = chart2.getCategoryPlot().getRenderer();
						setColori(chart2.getCategoryPlot());
						render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
						render.setItemLabelFont(font);
						render.setItemLabelsVisible(true);
						chPanel2 = new ChartPanel(chart2);
						chPanel2.setDomainZoomable(true);
						chPanel2.setMouseZoomable(true);
						chPanel2.setVisible(true);
						internalFrame_1.getContentPane().add(chPanel2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					cmbAnno1.setEnabled(false);

				}

			}
		});
		cmbNazione1.setBounds(42, 39, 151, 24);
		panel_1.add(cmbNazione1);

		cmbAnno1 = new JComboBox(array);
		cmbAnno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					internalFrame_1.remove(chPanel2);
					internalFrame_1.revalidate();
					CategoryDataset dataset = istatMorti.createDatasetNazioneCittaAnno(
							(String) cmbNazione1.getSelectedItem(), eurostatchart,
							(Integer) cmbAnno1.getSelectedItem());
					chart2 = ChartFactory.createBarChart3D(
							"Rapporto decessi/popolazione per anno(Nb: Gli elementi nulli corrispondono a dati non pervenuti)",
							"Anno", "Morti Citta/Nazione Per Anno", dataset, PlotOrientation.VERTICAL, true, true,
							false);
					CategoryItemRenderer render = chart2.getCategoryPlot().getRenderer();
					render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
					render.setItemLabelFont(font);
					render.setItemLabelsVisible(true);
					setColori(chart2.getCategoryPlot());
					chPanel2 = new ChartPanel(chart2);
					chPanel2.setDomainZoomable(true);
					chPanel2.setMouseZoomable(true);
					chPanel2.setVisible(true);
					internalFrame_1.getContentPane().add(chPanel2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cmbAnno1.setBounds(223, 39, 151, 24);
		panel_1.add(cmbAnno1);

		cmbNazione2 = new JComboBox(arrayNazioni);
		cmbNazione2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String val = (String) cmbNazione2.getSelectedItem();
				if (!val.equals("Seleziona Nazione")) {

					try {
						internalFrame_1.remove(chPanel2);
						internalFrame_1.revalidate();
						cmbNazione1.setSelectedIndex(0);
						XYDataset dataset = istatMorti.createDatasetNazioneCitta((String) cmbNazione2.getSelectedItem(),
								eurostatchart);
						chart2 = ChartFactory.createTimeSeriesChart(
								"Andamento tasso decessi/popolazione dal 2004 al 2013", // title
								"Anno", // x-axis label
								"Morti Citta/Nazione Anni 2004/2013", // y-axis
																		// label
								dataset, // data
								true, // create legend?
								true, // generate tooltips?
								false // generate URLs?
						);
						chart2.getPlot().setBackgroundPaint(Color.black);
						chPanel2 = new ChartPanel(chart2);
						chart2.getXYPlot().setDomainPannable(true);

						chPanel2.setMouseWheelEnabled(true);
						chPanel2.setMouseZoomable(true);
						chPanel2.setRangeZoomable(false);
						internalFrame_1.getContentPane().add(chPanel2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {

				}

			}
		});
		cmbNazione2.setBounds(42, 204, 151, 24);
		panel_1.add(cmbNazione2);

		JButton btnViewDecessiCittaIta = new JButton("VIEW");
		btnViewDecessiCittaIta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					cmbNazione1.setSelectedIndex(0);
					cmbNazione2.setSelectedIndex(0);
					internalFrame_1.remove(chPanel2);
					internalFrame_1.revalidate();
					XYDataset dataset = istatMorti.createDatasetCitta();
					chart2 = ChartFactory.createTimeSeriesChart("Andamento tasso decessi/popolazione dal 2004 al 2013", // title
							"Anno", // x-axis label
							"Morti Citta Italiane Anni 2004/2013", // y-axis
																	// label
							dataset, // data
							true, // create legend?
							true, // generate tooltips?
							false // generate URLs?
					);
					chart2.getPlot().setBackgroundPaint(Color.black);
					chPanel2 = new ChartPanel(chart2);
					chart2.getXYPlot().setDomainPannable(true);

					chPanel2.setMouseWheelEnabled(true);
					chPanel2.setMouseZoomable(true);
					chPanel2.setRangeZoomable(false);
					internalFrame_1.getContentPane().add(chPanel2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnViewDecessiCittaIta.setBounds(42, 381, 151, 25);
		panel_1.add(btnViewDecessiCittaIta);

		lblVisualizzaPerAnno_5 = new JLabel("Filtra per anno");
		lblVisualizzaPerAnno_5.setBounds(42, 428, 151, 15);
		panel_1.add(lblVisualizzaPerAnno_5);

		sldFilterAnnoDecessiCittaIta = new JSlider(JSlider.HORIZONTAL, 2004, 2013, 2004);
		sldFilterAnnoDecessiCittaIta.setMajorTickSpacing(1);
		sldFilterAnnoDecessiCittaIta.setPaintLabels(true);
		sldFilterAnnoDecessiCittaIta.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				cmbNazione1.setSelectedIndex(0);
				cmbNazione2.setSelectedIndex(0);
				internalFrame_1.remove(chPanel2);
				internalFrame_1.revalidate();
				try {
					DefaultPieDataset dataset;

					dataset = istatMorti.createDatasetCittaPieChart(sldFilterAnnoDecessiCittaIta.getValue());
					chart2 = ChartFactory.createPieChart3D(
							"Tasso Decessi/Numero Abitanti citta italiane:" + sldFilterAnnoDecessiCittaIta.getValue()
									+ "(I valori nella legenda rappresentano numero abitanti)", // chart
							// title
							dataset, // data
							true, // include legend
							true, false);
					chPanel2 = new ChartPanel(chart2);
					internalFrame_1.getContentPane().add(chPanel2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		sldFilterAnnoDecessiCittaIta.setBounds(42, 455, 353, 26);
		panel_1.add(sldFilterAnnoDecessiCittaIta);

		/*----------------------------------Fine Implementazione Pannello Numero Due-------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------------------------
		 */

		String[] arrayCitta = { "Seleziona Citta", "Bari", "Firenze", "Milano", "Napoli", "Palermo", "Roma", "Torino" };
		String[] arrayLoc = { "altra strada", "autostrada", "strada urbana" };
		String[] arrayNatura = { "incidente a veicolo isolato", "incidente tra veicoli",
				"incidente tra veicolo e pedone" };

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("ISTAT CONFRONTO INCIDENTI/DECEDUTI CITTA", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblVisualizzaIncidentidecedutiPer_1 = new JLabel("Visualizza tasso decessi/incidenti per citta");
		lblVisualizzaIncidentidecedutiPer_1.setBounds(24, 12, 399, 15);
		panel_2.add(lblVisualizzaIncidentidecedutiPer_1);

		cmbCittaDecessiIncidenti1 = new JComboBox(arrayCitta);
		cmbCittaDecessiIncidenti1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = (String) cmbCittaDecessiIncidenti1.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					internalFrame_2.remove(chPanel3);
					internalFrame_2.revalidate();
					cmbCittaDecessiIncidenti2.setSelectedIndex(0);
					cmbCittaDecessiIncidenti3.setSelectedIndex(0);
					cmbCittaDecessiMorti.setSelectedIndex(0);
					CategoryDataset dataset = imi
							.createDatasetMortiIncidentiPerCitta((String) cmbCittaDecessiIncidenti1.getSelectedItem());

					chart3 = ChartFactory.createLineChart(
							(String) cmbCittaDecessiIncidenti1.getSelectedItem()
									+ " tasso (decessi/incidenti) periodo 2004/2013",
							"Anno", "Totale", dataset, PlotOrientation.VERTICAL, true, true, true);
					chart3.getCategoryPlot().getRangeAxis().setAutoRange(true);

					chPanel3 = new ChartPanel(chart3);
					chPanel3.setMouseWheelEnabled(true);
					chPanel3.setMouseZoomable(true);
					chPanel3.setRangeZoomable(false);
					chPanel3 = new ChartPanel(chart3);
					internalFrame_2.getContentPane().add(chPanel3);

				} else {

				}

			}
		});
		cmbCittaDecessiIncidenti1.setBounds(56, 39, 164, 24);
		panel_2.add(cmbCittaDecessiIncidenti1);

		JLabel lblVisualizzaIncidentiPer = new JLabel("Visualizza decessi per sesso citta italiane");
		lblVisualizzaIncidentiPer.setBounds(24, 462, 363, 15);
		panel_2.add(lblVisualizzaIncidentiPer);

		internalFrame_2 = new JInternalFrame("Confronto Decessi/Incidenti Citta Italiane");
		internalFrame_2.setBounds(424, 12, 839, 616);
		panel_2.add(internalFrame_2);
		internalFrame_2.setVisible(true);
		chPanel3 = new ChartPanel(chart3);
		internalFrame_2.getContentPane().add(chPanel3);

		cmbCittaDecessiMorti = new JComboBox(arrayCitta);
		cmbCittaDecessiMorti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String val = (String) cmbCittaDecessiMorti.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					sldDecessiCittaSesso.setEnabled(true);
					sldDecessiCittaSesso.setValue(2004);
					cmbCittaDecessiIncidenti2.setSelectedIndex(0);
					cmbCittaDecessiIncidenti1.setSelectedIndex(0);
					cmbCittaDecessiIncidenti3.setSelectedIndex(0);

					internalFrame_2.remove(chPanel3);
					internalFrame_2.revalidate();
					XYDataset dataset = imi.createDatasetMortiPerSesso((String) cmbCittaDecessiMorti.getSelectedItem());
					chart3 = ChartFactory.createTimeSeriesChart("", // title
							"Anno", // x-axis label
							"Morti Citta/Sesso Anni 2004/2013", // y-axis label
							dataset, // data
							true, // create legend?
							true, // generate tooltips?
							false // generate URLs?
					);
					chart3.getPlot().setBackgroundPaint(Color.BLACK);
					chPanel3 = new ChartPanel(chart3);
					chart3.getXYPlot().setDomainPannable(true);

					chPanel3.setMouseWheelEnabled(true);
					chPanel3.setMouseZoomable(true);
					chPanel3.setRangeZoomable(false);
					internalFrame_2.getContentPane().add(chPanel3);

				} else {
					sldDecessiCittaSesso.setValue(2004);
					sldDecessiCittaSesso.setEnabled(false);
				}

			}
		});
		cmbCittaDecessiMorti.setBounds(56, 489, 164, 24);
		panel_2.add(cmbCittaDecessiMorti);

		JLabel lblVisualizzaIncidentidecedutiCittaluogo = new JLabel(
				"Visualizza incidenti/deceduti citta/tipo strada incidente");
		lblVisualizzaIncidentidecedutiCittaluogo.setBounds(24, 154, 399, 15);
		panel_2.add(lblVisualizzaIncidentidecedutiCittaluogo);

		cmbCittaDecessiIncidenti2 = new JComboBox(arrayCitta);
		cmbCittaDecessiIncidenti2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String val = (String) cmbCittaDecessiIncidenti2.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					internalFrame_2.remove(chPanel3);
					internalFrame_2.revalidate();
					cmbCittaDecessiIncidenti1.setSelectedIndex(0);
					cmbCittaDecessiMorti.setSelectedIndex(0);
					cmbCittaDecessiIncidenti3.setSelectedIndex(0);

					cmbDecessiIncidentiTipo.setEnabled(true);

					try {
						CategoryDataset dataset = imi.createDatasetMortiIncidentiCittaLocalizzazione(
								(String) cmbCittaDecessiIncidenti2.getSelectedItem(), (String) cmbDecessiIncidentiTipo.getSelectedItem());

						chart3 = ChartFactory.createLineChart(
								(String) cmbCittaDecessiIncidenti2.getSelectedItem()
										+ " tasso (decessi/incidenti) periodo 2004/2013 per "
										+ (String) cmbDecessiIncidentiTipo.getSelectedItem(),
								"Anno", "Totale", dataset, PlotOrientation.VERTICAL, true, true, true);
						chPanel3 = new ChartPanel(chart3);
						internalFrame_2.getContentPane().add(chPanel3);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					cmbDecessiIncidentiTipo.setEnabled(false);

				}

			}
		});
		cmbCittaDecessiIncidenti2.setBounds(56, 181, 164, 24);
		panel_2.add(cmbCittaDecessiIncidenti2);

		cmbDecessiIncidentiTipo = new JComboBox(arrayLoc);
		cmbDecessiIncidentiTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = (String) cmbCittaDecessiIncidenti2.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					internalFrame_2.remove(chPanel3);
					internalFrame_2.revalidate();

					try {
						CategoryDataset dataset = imi.createDatasetMortiIncidentiCittaLocalizzazione(
								(String) cmbCittaDecessiIncidenti2.getSelectedItem(), (String) cmbDecessiIncidentiTipo.getSelectedItem());

						chart3 = ChartFactory.createLineChart(
								(String) cmbCittaDecessiIncidenti2.getSelectedItem()
										+ " tasso (decessi/incidenti) periodo 2004/2013 per "
										+ (String) cmbDecessiIncidentiTipo.getSelectedItem()
										,
								"Anno", "Totale", dataset, PlotOrientation.VERTICAL, true, true, true);
						chPanel3 = new ChartPanel(chart3);
						internalFrame_2.getContentPane().add(chPanel3);
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}

				}

			}
		});
		cmbDecessiIncidentiTipo.setBounds(232, 181, 154, 27);
		panel_2.add(cmbDecessiIncidentiTipo);

		JLabel lblVisualizzaIncidentidecedutiCitta = new JLabel("Visualizza incidenti/deceduti citta/natura incidente");
		lblVisualizzaIncidentidecedutiCitta.setBounds(24, 308, 399, 15);
		panel_2.add(lblVisualizzaIncidentidecedutiCitta);

		cmbCittaDecessiIncidenti3 = new JComboBox(arrayCitta);
		cmbCittaDecessiIncidenti3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String val = (String) cmbCittaDecessiIncidenti3.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					internalFrame_2.remove(chPanel3);
					internalFrame_2.revalidate();
					cmbCittaDecessiIncidenti2.setSelectedIndex(0);
					cmbCittaDecessiIncidenti1.setSelectedIndex(0);
					cmbCittaDecessiMorti.setSelectedIndex(0);

					cmbDecessiIncidentiNatura.setEnabled(true);
					sldDecessiCittaSesso.setEnabled(false);

					try {
						CategoryDataset dataset = imi.createDatasetMortiIncidentiCittaNatura(
								(String) cmbCittaDecessiIncidenti3.getSelectedItem(), (String) cmbDecessiIncidentiNatura.getSelectedItem());
						chart3 = ChartFactory.createLineChart((String) cmbCittaDecessiIncidenti3.getSelectedItem()
								+ " tasso (decessi/incidenti)*Numero Abitanti periodo 2004/2013 per " + (String) cmbDecessiIncidentiNatura.getSelectedItem()
								, "Anno", "Totale", dataset, PlotOrientation.VERTICAL, true, true, true);
						chPanel3 = new ChartPanel(chart3);
						internalFrame_2.getContentPane().add(chPanel3);
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}

				} else {
					cmbDecessiIncidentiNatura.setEnabled(false);

				}

			}
		});
		cmbCittaDecessiIncidenti3.setBounds(56, 335, 164, 24);
		panel_2.add(cmbCittaDecessiIncidenti3);

		cmbDecessiIncidentiNatura = new JComboBox(arrayNatura);
		cmbDecessiIncidentiNatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = (String) cmbCittaDecessiIncidenti3.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					internalFrame_2.remove(chPanel3);
					internalFrame_2.revalidate();

					try {
						CategoryDataset dataset = imi.createDatasetMortiIncidentiCittaNatura(
								(String) cmbCittaDecessiIncidenti3.getSelectedItem(), (String) cmbDecessiIncidentiNatura.getSelectedItem());

						chart3 = ChartFactory.createLineChart(
								(String) cmbCittaDecessiIncidenti3.getSelectedItem() + " tasso (decessi/incidenti)*Numero Abitanti periodo 2004/2013 "
										+ (String) cmbDecessiIncidentiNatura.getSelectedItem(),
								"Anno", "Totale", dataset, PlotOrientation.VERTICAL, true, true, true);
						chPanel3 = new ChartPanel(chart3);
						internalFrame_2.getContentPane().add(chPanel3);
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}

				}

			}
		});
		cmbDecessiIncidentiNatura.setBounds(232, 335, 154, 24);
		panel_2.add(cmbDecessiIncidentiNatura);

		JLabel lblVisualizzaPerAnno_4 = new JLabel("Filtra per anno");
		lblVisualizzaPerAnno_4.setBounds(56, 525, 211, 15);
		panel_2.add(lblVisualizzaPerAnno_4);

		sldDecessiCittaSesso = new JSlider(JSlider.HORIZONTAL, 2004, 2013, 2004);
		sldDecessiCittaSesso.setMajorTickSpacing(1);
		sldDecessiCittaSesso.setPaintLabels(true);
		sldDecessiCittaSesso.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				String val = (String) cmbCittaDecessiMorti.getSelectedItem();
				if (!val.equals("Seleziona Citta")){
					internalFrame_2.remove(chPanel3);
					internalFrame_2.revalidate();
					try {
						DefaultPieDataset dataset;

						dataset = imi.createDatasetMortiPerSessoPieChart((String) cmbCittaDecessiMorti.getSelectedItem(),
								sldDecessiCittaSesso.getValue());
						chart3 = ChartFactory.createPieChart3D(
								(String) cmbCittaDecessiMorti.getSelectedItem() + " Decessi per sesso:" + sldDecessiCittaSesso.getValue(), // chart
								// title
								dataset, // data
								true, // include legend
								true, false);
						
						chPanel3 = new ChartPanel(chart3);
						internalFrame_2.getContentPane().add(chPanel3);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				}else{
					sldDecessiCittaSesso.setValue(2004);
				}
				
			}
		});
		sldDecessiCittaSesso.setBounds(56, 552, 356, 35);
		panel_2.add(sldDecessiCittaSesso);

		/*----------------------------------Fine Implementazione Pannello Numero Tre-------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------------------------
		 */

		panel_4 = new JPanel();
		tabbedPane.addTab("ALTRE STATISTICHE INCIDENTI", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblVisualizzaIncidentiCitta = new JLabel("Visualizza incidenti citta per tipo veicolo");
		lblVisualizzaIncidentiCitta.setBounds(12, 12, 307, 15);
		panel_4.add(lblVisualizzaIncidentiCitta);

		JLabel lblVisualizzaIncidentiCitta_1 = new JLabel("Visualizza incidenti citta per luogo");
		lblVisualizzaIncidentiCitta_1.setBounds(12, 123, 307, 15);
		panel_4.add(lblVisualizzaIncidentiCitta_1);

		JLabel lblVisualizzaIncidentiCitta_2 = new JLabel("Visualizza incidenti citta per tipo incidente");
		lblVisualizzaIncidentiCitta_2.setBounds(12, 247, 307, 15);
		panel_4.add(lblVisualizzaIncidentiCitta_2);

		JLabel lblVisualizzaDecessiCitta = new JLabel("Visualizza decessi citta per classe eta");
		lblVisualizzaDecessiCitta.setBounds(12, 362, 307, 15);
		panel_4.add(lblVisualizzaDecessiCitta);

		JLabel lblVisualizzaDecessiCitta_1 = new JLabel("Visualizza decessi citta per luogo");
		lblVisualizzaDecessiCitta_1.setBounds(12, 488, 307, 15);
		panel_4.add(lblVisualizzaDecessiCitta_1);

		cmbIncidentiCitta1 = new JComboBox(arrayCitta);
		cmbIncidentiCitta1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			
				String valSel = (String) cmbIncidentiCitta1.getSelectedItem();
				if (!(valSel.equals("Seleziona Citta"))) {
					sldIncidentiCitta1.setEnabled(true);
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();
					cmbIncidentiCitta2.setSelectedIndex(0);
					cmbIncidentiCitta3.setSelectedIndex(0);
					cmbDecessiCittaClasseEta.setSelectedIndex(0);
					cmbDecessiCittaLuogo.setSelectedIndex(0);

					try {
						XYDataset dataset;
						dataset = imi.createDatasetIncidentiCittaTipoVeicolo((String) cmbIncidentiCitta1.getSelectedItem());
						chart4 = ChartFactory.createTimeSeriesChart("", // title
								"Anno", // x-axis label
								"Incidenti Per Tipo Veicolo", // y-axis label
								dataset, // data
								true, // create legend?
								true, // generate tooltips?
								false // generate URLs?
						);
						chart4.getPlot().setBackgroundPaint(Color.BLACK);
						chPanel4 = new ChartPanel(chart4);
						chart4.getXYPlot().setDomainPannable(true);

						chPanel4.setMouseWheelEnabled(true);
						chPanel4.setMouseZoomable(true);
						chPanel4.setRangeZoomable(false);
						internalFrame_3.getContentPane().add(chPanel4);

					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				}else{
					sldIncidentiCitta1.setValue(2004);
					sldIncidentiCitta1.setEnabled(false);

				}

			}
		});
		cmbIncidentiCitta1.setBounds(58, 34, 162, 24);
		panel_4.add(cmbIncidentiCitta1);

		cmbIncidentiCitta2 = new JComboBox(arrayCitta);
		cmbIncidentiCitta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			
				String valSel = (String) cmbIncidentiCitta2.getSelectedItem();
				if (!(valSel.equals("Seleziona Citta"))) {
					sldIncidentiCitta2.setEnabled(true);
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();
					cmbIncidentiCitta1.setSelectedIndex(0);
					cmbIncidentiCitta3.setSelectedIndex(0);
					cmbDecessiCittaClasseEta.setSelectedIndex(0);
					cmbDecessiCittaLuogo.setSelectedIndex(0);

					try {
						XYDataset dataset;
						dataset = imi.createDatasetIncidentiCittaLocalizzazione((String) cmbIncidentiCitta2.getSelectedItem());
						chart4 = ChartFactory.createTimeSeriesChart("", // title
								"Anno", // x-axis label
								"Incidenti Per Tipo Strada", // y-axis label
								dataset, // data
								true, // create legend?
								true, // generate tooltips?
								false // generate URLs?
						);
						chart4.getPlot().setBackgroundPaint(Color.BLACK);
						chPanel4 = new ChartPanel(chart4);
						chart4.getXYPlot().setDomainPannable(true);

						chPanel4.setMouseWheelEnabled(true);
						chPanel4.setMouseZoomable(true);
						chPanel4.setRangeZoomable(false);
						internalFrame_3.getContentPane().add(chPanel4);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					sldIncidentiCitta2.setValue(2004);
					sldIncidentiCitta2.setEnabled(false);

				}

			}
		});
		cmbIncidentiCitta2.setBounds(58, 150, 162, 24);
		panel_4.add(cmbIncidentiCitta2);

		cmbIncidentiCitta3 = new JComboBox(arrayCitta);
		cmbIncidentiCitta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			
				String valSel = (String) cmbIncidentiCitta3.getSelectedItem();
				if (!(valSel.equals("Seleziona Citta"))) {
					sldIncidentiCitta3.setEnabled(true);
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();
					cmbIncidentiCitta1.setSelectedIndex(0);
					cmbIncidentiCitta2.setSelectedIndex(0);
					cmbDecessiCittaClasseEta.setSelectedIndex(0);
					cmbDecessiCittaLuogo.setSelectedIndex(0);

					try {
						XYDataset dataset;
						dataset = imi.createDatasetIncidentiCittaNatura((String) cmbIncidentiCitta3.getSelectedItem());
						chart4 = ChartFactory.createTimeSeriesChart("", // title
								"Anno", // x-axis label
								"Natura Dell'Incidente", // y-axis label
								dataset, // data
								true, // create legend?
								true, // generate tooltips?
								false // generate URLs?
						);
						chart4.getPlot().setBackgroundPaint(Color.BLACK);
						chPanel4 = new ChartPanel(chart4);
						chart4.getXYPlot().setDomainPannable(true);

						chPanel4.setMouseWheelEnabled(true);
						chPanel4.setMouseZoomable(true);
						chPanel4.setRangeZoomable(false);
						internalFrame_3.getContentPane().add(chPanel4);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					sldIncidentiCitta3.setValue(2004);
					sldIncidentiCitta3.setEnabled(false);

				}

			}
		});
		cmbIncidentiCitta3.setBounds(58, 274, 162, 24);
		panel_4.add(cmbIncidentiCitta3);

		cmbDecessiCittaClasseEta = new JComboBox(arrayCitta);
		cmbDecessiCittaClasseEta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				String valSel = (String) cmbDecessiCittaClasseEta.getSelectedItem();
				if (!(valSel.equals("Seleziona Citta"))) {
					sldDecessiCittaClasse.setEnabled(true);
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();
					cmbIncidentiCitta1.setSelectedIndex(0);
					cmbIncidentiCitta2.setSelectedIndex(0);
					cmbIncidentiCitta3.setSelectedIndex(0);
					cmbDecessiCittaLuogo.setSelectedIndex(0);

					try {
						XYDataset dataset;
						dataset = imi.createDatasetMortiCittaClasse((String) cmbDecessiCittaClasseEta.getSelectedItem());
						chart4 = ChartFactory.createTimeSeriesChart("", // title
								"Anno", // x-axis label
								"Vittime Per Classe Eta", // y-axis label
								dataset, // data
								true, // create legend?
								true, // generate tooltips?
								false // generate URLs?
						);
						chart4.getPlot().setBackgroundPaint(Color.BLACK);

						chPanel4 = new ChartPanel(chart4);
						chart4.getXYPlot().setDomainPannable(true);

						chPanel4.setMouseWheelEnabled(true);
						chPanel4.setMouseZoomable(true);
						chPanel4.setRangeZoomable(false);
						internalFrame_3.getContentPane().add(chPanel4);
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				}else{
					sldDecessiCittaClasse.setValue(2004);
					sldDecessiCittaClasse.setEnabled(false);

				}

			}
		});
		cmbDecessiCittaClasseEta.setBounds(58, 389, 162, 24);
		panel_4.add(cmbDecessiCittaClasseEta);

		cmbDecessiCittaLuogo = new JComboBox(arrayCitta);
		cmbDecessiCittaLuogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				String valSel = (String) cmbDecessiCittaLuogo.getSelectedItem();
				if (!(valSel.equals("Seleziona Citta"))) {
					sldFiltraDecessiLuogo.setEnabled(true);
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();
					cmbIncidentiCitta1.setSelectedIndex(0);
					cmbIncidentiCitta2.setSelectedIndex(0);
					cmbIncidentiCitta3.setSelectedIndex(0);
					cmbDecessiCittaClasseEta.setSelectedIndex(0);

					try {
						sldFiltraDecessiLuogo.setValue(0);
						CategoryDataset dataset = imi
								.createDatasetMortiCittaLocalizzazione((String) cmbDecessiCittaLuogo.getSelectedItem());

						chart4 = ChartFactory.createBarChart3D((String) cmbDecessiCittaLuogo.getSelectedItem(), "Anno",
								"Vittime Totali", dataset, PlotOrientation.VERTICAL, true, true, true);
						chPanel4 = new ChartPanel(chart4);
						internalFrame_3.getContentPane().add(chPanel4);
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				}else{
					sldFiltraDecessiLuogo.setValue(0);
					sldFiltraDecessiLuogo.setEnabled(false);

				}

			}
		});
		cmbDecessiCittaLuogo.setBounds(58, 521, 162, 24);
		panel_4.add(cmbDecessiCittaLuogo);

		internalFrame_3 = new JInternalFrame("VARIE STATISTICHE ISTAT");
		internalFrame_3.setBounds(433, 0, 830, 631);
		panel_4.add(internalFrame_3);

		internalFrame_3.setVisible(true);
		chPanel4 = new ChartPanel(chart4, true, true, true, true, true);
		internalFrame_3.getContentPane().add(chPanel4, BorderLayout.NORTH);

		JLabel lblFiltraDecessi = new JLabel("Filtra decessi");
		lblFiltraDecessi.setBounds(58, 557, 133, 15);
		panel_4.add(lblFiltraDecessi);

		sldFiltraDecessiLuogo = new JSlider(JSlider.HORIZONTAL, 0, 40, 0);
		sldFiltraDecessiLuogo.setMajorTickSpacing(5);
		sldFiltraDecessiLuogo.setPaintLabels(true);
		sldFiltraDecessiLuogo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				String valSel = (String) cmbDecessiCittaLuogo.getSelectedItem();
				if (!(valSel.equals("Seleziona Citta"))) {
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();
					try {
						CategoryDataset dataset = imi.createDatasetMortiCittaLocalizzazioneSlider(
								(String) cmbDecessiCittaLuogo.getSelectedItem(), (Integer) sldFiltraDecessiLuogo.getValue());

						chart4 = ChartFactory.createBarChart3D((String) cmbDecessiCittaLuogo.getSelectedItem(), "Anno",
								"Vittime Totali", dataset, PlotOrientation.VERTICAL, true, true, true);
						chPanel4 = new ChartPanel(chart4);
						internalFrame_3.getContentPane().add(chPanel4);
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				}

			}
		});
		sldFiltraDecessiLuogo.setBounds(58, 584, 363, 29);
		panel_4.add(sldFiltraDecessiLuogo);

		JLabel lblNewLabel_1 = new JLabel("Filtra per anno");
		lblNewLabel_1.setBounds(58, 70, 200, 15);
		panel_4.add(lblNewLabel_1);

		sldIncidentiCitta1 = new JSlider(JSlider.HORIZONTAL, 2004, 2013, 2004);
		sldIncidentiCitta1.setMajorTickSpacing(1);
		sldIncidentiCitta1.setPaintLabels(true);
		sldIncidentiCitta1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				String val = (String) cmbIncidentiCitta1.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();
					try {
						DefaultPieDataset dataset;

						dataset = imi.createDatasetIncidentiCittaTipoVeicoloPieChart(
								(String) cmbIncidentiCitta1.getSelectedItem(), sldIncidentiCitta1.getValue());
						chart4 = ChartFactory.createPieChart3D(
								(String) cmbIncidentiCitta1.getSelectedItem() + " Incidenti per tipo veicoli anno:"
										+ sldIncidentiCitta1.getValue(), // chart
								// title
								dataset, // data
								true, // include legend
								true, false);
						chPanel4 = new ChartPanel(chart4);

						internalFrame_3.getContentPane().add(chPanel4);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		sldIncidentiCitta1.setBounds(58, 97, 363, 24);
		panel_4.add(sldIncidentiCitta1);

		JLabel lblVisualizzaPerAnno_1 = new JLabel("Filtra per anno");
		lblVisualizzaPerAnno_1.setBounds(58, 186, 200, 15);
		panel_4.add(lblVisualizzaPerAnno_1);

		lblVisualizzaPerAnno_2 = new JLabel("Filtra per anno");
		lblVisualizzaPerAnno_2.setBounds(58, 425, 200, 15);
		panel_4.add(lblVisualizzaPerAnno_2);

		lblVisualizzaPerAnno_3 = new JLabel("Filtra per anno");
		lblVisualizzaPerAnno_3.setBounds(58, 299, 200, 15);
		panel_4.add(lblVisualizzaPerAnno_3);

		sldIncidentiCitta2 = new JSlider(JSlider.HORIZONTAL, 2004, 2013, 2004);
		sldIncidentiCitta2.setMajorTickSpacing(1);
		sldIncidentiCitta2.setPaintLabels(true);
		sldIncidentiCitta2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				String val = (String) cmbIncidentiCitta2.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();

					try {
						DefaultPieDataset dataset;

						dataset = imi.createDatasetIncidentiCittaPerLuogoPieChart(
								(String) cmbIncidentiCitta2.getSelectedItem(), sldIncidentiCitta2.getValue());
						chart4 = ChartFactory.createPieChart3D(
								(String) cmbIncidentiCitta2.getSelectedItem() + " Incidenti per tipo di strada:"
										+ sldIncidentiCitta2.getValue(), // chart
								// title
								dataset, // data
								true, // include legend
								true, false);
						chPanel4 = new ChartPanel(chart4);
						internalFrame_3.getContentPane().add(chPanel4);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		sldIncidentiCitta2.setBounds(58, 213, 363, 24);
		panel_4.add(sldIncidentiCitta2);

		sldIncidentiCitta3 = new JSlider(JSlider.HORIZONTAL, 2004, 2013, 2004);
		sldIncidentiCitta3.setMajorTickSpacing(1);
		sldIncidentiCitta3.setPaintLabels(true);
		sldIncidentiCitta3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				String val = (String) cmbIncidentiCitta3.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();
					try {
						DefaultPieDataset dataset;

						dataset = imi.createDatasetIncidentiCittaNaturaPieChart((String) cmbIncidentiCitta3.getSelectedItem(),
								sldIncidentiCitta3.getValue());
						chart4 = ChartFactory.createPieChart3D(
								(String) cmbIncidentiCitta3.getSelectedItem() + " Incidenti per tipologia:"
										+ sldIncidentiCitta3.getValue(), // chart
								// title
								dataset, // data
								true, // include legend
								true, false);
						chPanel4 = new ChartPanel(chart4);
						internalFrame_3.getContentPane().add(chPanel4);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		sldIncidentiCitta3.setBounds(58, 326, 363, 24);
		panel_4.add(sldIncidentiCitta3);

		sldDecessiCittaClasse = new JSlider(JSlider.HORIZONTAL, 2004, 2013, 2004);
		sldDecessiCittaClasse.setMajorTickSpacing(1);
		sldDecessiCittaClasse.setPaintLabels(true);
		sldDecessiCittaClasse.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				String val = (String) cmbDecessiCittaClasseEta.getSelectedItem();
				if (!val.equals("Seleziona Citta")) {
					internalFrame_3.remove(chPanel4);
					internalFrame_3.revalidate();
					try {
						DefaultPieDataset dataset;

						dataset = imi.createDatasetMortiCittaClassePieChart((String) cmbDecessiCittaClasseEta.getSelectedItem(),
								sldDecessiCittaClasse.getValue());
						chart4 = ChartFactory.createPieChart3D(
								(String) cmbDecessiCittaClasseEta.getSelectedItem() + " Decessi per classe di eta:"
										+ sldDecessiCittaClasse.getValue(), // chart
								// title
								dataset, // data
								true, // include legend
								true, false);
						chPanel4 = new ChartPanel(chart4);
						internalFrame_3.getContentPane().add(chPanel4);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		sldDecessiCittaClasse.setBounds(58, 452, 363, 24);
		panel_4.add(sldDecessiCittaClasse);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				internalFrame.remove(chPanelEu);
				internalFrame.revalidate();
				internalFrame_1.remove(chPanel2);
				internalFrame_1.revalidate();
				internalFrame_2.remove(chPanel3);
				internalFrame_2.revalidate();
				internalFrame_3.remove(chPanel4);
				internalFrame_3.revalidate();
				sldFilterEuAnno.setValue(0);
				sldFiltraDecessiLuogo.setValue(0);
				sldIncidentiCitta1.setValue(2004);
				sldIncidentiCitta2.setValue(2004);
				sldIncidentiCitta3.setValue(2004);
				sldDecessiCittaClasse.setValue(2004);
				sldDecessiCittaSesso.setValue(2004);
				sldFilterAnnoDecessiCittaIta.setValue(2004);
				sldFilterEuDecessiAnno.setValue(2004);
				sldIncidentiCitta1.setEnabled(false);
				sldIncidentiCitta2.setEnabled(false);
				sldIncidentiCitta3.setEnabled(false);
				sldDecessiCittaClasse.setEnabled(false);
				sldFiltraDecessiLuogo.setEnabled(false);
				sldDecessiCittaSesso.setEnabled(false);
				cmbAnno1.setEnabled(false);
				cmbDecessiIncidentiTipo.setEnabled(false);
				cmbDecessiIncidentiNatura.setEnabled(false);

				cmbCittaDecessiIncidenti1.setSelectedIndex(0);
				cmbDecessiIncidentiTipo.setSelectedIndex(0);
				cmbCittaDecessiIncidenti3.setSelectedIndex(0);
				cmbCittaDecessiMorti.setSelectedIndex(0);
				cmbDecessiIncidentiNatura.setSelectedIndex(0);
				cmbIncidentiCitta1.setSelectedIndex(0);
				cmbIncidentiCitta2.setSelectedIndex(0);
				cmbIncidentiCitta3.setSelectedIndex(0);
				cmbDecessiCittaClasseEta.setSelectedIndex(0);
				cmbDecessiCittaLuogo.setSelectedIndex(0);
			}
		});

	}
}
