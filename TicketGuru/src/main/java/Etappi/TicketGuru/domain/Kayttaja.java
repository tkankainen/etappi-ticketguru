package Etappi.TicketGuru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import javax.persistence.Table;


@Entity
//@Table(name = "\"kayttaja\"")
public class Kayttaja {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long kayttajaid;
	
	private String etunimi;
	private String sukunimi;
	private String tunnus;
	private String salasana;
	private String rooli;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kayttaja")
	
	private List <Myyntitapahtuma> myyntitapahtumat;
	
	public Kayttaja() {}
	
	public Kayttaja(String etunimi, String sukunimi,
				String tunnus, String salasana, String rooli) {
		
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.tunnus = tunnus;
		this.salasana = salasana;
		this.rooli = rooli;
	}

	public long getKayttajaid() {
		return kayttajaid;
	}

	public void setKayttajaid(long kayttajaid) {
		this.kayttajaid = kayttajaid;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getTunnus() {
		return tunnus;
	}

	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}
	
	public List<Myyntitapahtuma> getMyyntitapahtumat(){
		return myyntitapahtumat;
	}
		
	public void setMyyntitapahtumat(List<Myyntitapahtuma> myyntitapahtumat) {
			this.myyntitapahtumat = myyntitapahtumat;
		}


	@Override
	public String toString() {
		return "Kayttaja [kayttajaid=" + kayttajaid + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", tunnus=" + tunnus
				+ ", salasana=" + salasana + ", rooli=" + rooli + "]";
	}
	
	
}
