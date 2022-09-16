package Etappi.TicketGuru.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Tapahtumalipputyyppi {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long lipputyyppiid;
	
	private String nimi;
	private long hinta;
	
	@ManyToOne
	@JoinColumn(name="tapahtumaid")
	private Tapahtuma tapahtuma;  //monta lipputyyppiä/tapahtuma
	


	public Tapahtumalipputyyppi(){}
	
	public Tapahtumalipputyyppi( String nimi, long hinta) {
		super();
		this.nimi = nimi;
		this.hinta=hinta;
		
	}	
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

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	
	@Override
	public String toString() {
		return "Lipputyyppi [lipputyyppiid= "+ lipputyyppiid+ ", "+ nimi+ ",  "+ hinta+"]";
	}
	
	
}
