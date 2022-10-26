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
	
	@ManyToOne(optional = false)
	@JoinColumn(name="tapahtumaid")
	private Tapahtuma tapahtuma;  //monta lipputyyppiä/tapahtuma
	
	@ManyToOne(optional = false)
	@JoinColumn(name="tyyppiid")
	private Lipputyyppi lipputyyppi; //viiteavain lipputyyppi
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="tapahtumalipputyyppi")
	private List <Lippu> liput;  //monta lippua tapahtumalipputyypissä

	public Tapahtumalipputyyppi(){}
	
			
	public Tapahtumalipputyyppi(long hinta, Tapahtuma tapahtuma, Lipputyyppi lipputyyppi) {
		super();
		this.hinta = hinta;
		this.tapahtuma = tapahtuma;
		this.lipputyyppi = lipputyyppi;
	}

	
	/*public Tapahtumalipputyyppi(long hinta, Tapahtuma tapahtuma) {
		this.hinta=hinta;
		this.tapahtuma = tapahtuma;
	}	*/
	
	public long getLipputyyppiid() {
		return lipputyyppiid;
	}

	public void setLipputyyppiid(long lipputyyppiid) {
		this.lipputyyppiid = lipputyyppiid;
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
	
	public Lipputyyppi getLipputyyppi() {
		return lipputyyppi;
	}

	public void setLipputyyppi(Lipputyyppi lipputyyppi) {
		this.lipputyyppi = lipputyyppi;
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
