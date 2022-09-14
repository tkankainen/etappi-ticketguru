package Etappi.TicketGuru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tapahtuma {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long tapahtumaid;
	
	private String aika;
	private String nimi;
	private String osoite;
	private String kaupunki;
	private long kpl;
	private String loppupvm;
	
	public Tapahtuma() {}
	
	
	
	public Tapahtuma(String aika, String nimi, String osoite, String kaupunki, long kpl,
			String loppupvm) {
		super();
		this.aika = aika;
		this.nimi = nimi;
		this.osoite = osoite;
		this.kaupunki = kaupunki;
		this.kpl = kpl;
		this.loppupvm = loppupvm;
	}



	public long getTapahtumaid() {
		return tapahtumaid;
	}
	public void setTapahtumaid(long tapahtumaid) {
		this.tapahtumaid = tapahtumaid;
	}
	public String getAika() {
		return aika;
	}
	public void setAika(String aika) {
		this.aika = aika;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getOsoite() {
		return osoite;
	}
	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}
	public String getKaupunki() {
		return kaupunki;
	}
	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}
	public long getKpl() {
		return kpl;
	}
	public void setKpl(long kpl) {
		this.kpl = kpl;
	}
	public String getLoppupvm() {
		return loppupvm;
	}
	public void setLoppupvm(String loppupvm) {
		this.loppupvm = loppupvm;
	}



	@Override
	public String toString() {
		return "Tapahtuma [ aika=" + aika + ", nimi=" + nimi + ", osoite=" + osoite
				+ ", kaupunki=" + kaupunki + ", kpl=" + kpl + ", loppupvm=" + loppupvm + "]";
	}
	
	
	
	
}

