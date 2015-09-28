package model;

public class CoppiaCittaProp implements Comparable<CoppiaCittaProp> {
	
	private String citta;
	private String proprieta;
	
	
	public CoppiaCittaProp(String citta, String proprieta) {
		this.citta = citta;
		this.proprieta = proprieta;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProprieta() {
		return proprieta;
	}
	public void setProprieta(String proprieta) {
		this.proprieta = proprieta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citta == null) ? 0 : citta.hashCode());
		result = prime * result + ((proprieta == null) ? 0 : proprieta.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoppiaCittaProp other = (CoppiaCittaProp) obj;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (proprieta == null) {
			if (other.proprieta != null)
				return false;
		} else if (!proprieta.equals(other.proprieta))
			return false;
		return true;
	}
	@Override
	public int compareTo(CoppiaCittaProp c) {
		// TODO Auto-generated method stub
		
		return citta.compareTo(c.citta)+proprieta.compareTo(c.proprieta);
	}
	
	


	

}
