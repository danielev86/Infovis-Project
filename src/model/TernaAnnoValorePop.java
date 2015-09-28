package model;

public class TernaAnnoValorePop {
	
	private int anno;
	private int valore;
	private int popolazione;
	public TernaAnnoValorePop(int anno, int valore, int popolazione) {
		super();
		this.anno = anno;
		this.valore = valore;
		this.popolazione = popolazione;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getValore() {
		return valore;
	}
	public void setValore(int valore) {
		this.valore = valore;
	}
	public int getPopolazione() {
		return popolazione;
	}
	public void setPopolazione(int popolazione) {
		this.popolazione = popolazione;
	}
	@Override
	public String toString() {
		return "TernaAnnoValorePop [anno=" + anno + ", valore=" + valore + ", popolazione=" + popolazione + "]";
	}
	

}
