package Etappi.TicketGuru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tapahtumalipputyyppi {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long lipputyyppiid;
	
	private long hinta;
	
	private String nimi;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="tapahtumaid")
	private Tapahtuma tapahtuma;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="tapahtumalipputyyppi")
	private List <Lippu> liput;

	public Tapahtumalipputyyppi(){}
	
	public Tapahtumalipputyyppi(long hinta, String nimi, Tapahtuma tapahtuma) {
		this.hinta = hinta;
		this.nimi = nimi;
		this.tapahtuma = tapahtuma;
	}
	
	public long getLipputyyppiid() {
		return lipputyyppiid;
	}

	public void setLipputyyppiid(long lipputyyppiid) {
		this.lipputyyppiid = lipputyyppiid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public long getHinta() {
		return hinta;
	}

	public void setHinta(long hinta) {
		this.hinta = hinta;
	}
	
	
	public Tapahtuma getTapahtuma() {
		return tapahtuma;
	}

	public void setTapahtuma(Tapahtuma tapahtuma) {
		this.tapahtuma = tapahtuma;
	}
	
	public List<Lippu> getLiput(){
		return liput;
	}
		
	public void setLiput(List<Lippu> liput) {
			this.liput = liput;
	}
	@Override
	public String toString() {
		return "Lipputyyppi [lipputyyppiid= "+ lipputyyppiid+ ", "+ ",  "+ hinta+"]";
	}
	
}
