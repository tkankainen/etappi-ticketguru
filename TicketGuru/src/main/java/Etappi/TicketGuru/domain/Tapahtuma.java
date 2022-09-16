package Etappi.TicketGuru.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;


import javax.persistence.CascadeType;

//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;



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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="tapahtuma")
	
	private List <Tapahtumalipputyyppi> tapahtumalipputyypit;  //monta lipputyyppiä/tapahtuma*/
	/*@ManyToOne
	@JoinColumn(name="lipputyyppiid")
	private Tapahtumalipputyyppi tapahtumalipputyyppi;  //monta lipputyyppiä/tapahtuma/*
	/*@ManyToMany
	@JoinTable(
			name="tapahtuma_lipputyyppi",
			joinColumns = @JoinColumn(name="tapahtumaid"),
			inverseJoinColumns = @JoinColumn(name="lipputyyppiid")
			)*/
	
//	private Set<Tapahtumalipputyyppi> lipputyypit =new HashSet<>();//pitää määritellä set elementti että voi määriettlä get
	
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

	public List<Tapahtumalipputyyppi> getTapahtumalipputyypit(){
		return tapahtumalipputyypit;
	}
		
	public void setTapahtumalipputyypit(List<Tapahtumalipputyyppi> tapahtumalipputyypit) {
			this.tapahtumalipputyypit = tapahtumalipputyypit;
		}

	
	/*@Override
	public String toString() {
		return "[ lipputyypit ]";
	}*/

	@Override
	public String toString() {
		return "Tapahtuma [ aika=" + aika + ", nimi=" + nimi + ", osoite=" + osoite
				+ ", kaupunki=" + kaupunki + ", kpl=" + kpl + ", loppupvm=" + loppupvm + "]";
	}
	
	
	
	
}

