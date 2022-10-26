package Etappi.TicketGuru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lipputyyppi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tyyppiid;
	private String nimi;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="lipputyyppi")
	
	private List <Tapahtumalipputyyppi> tapahtumalipputyypit;  //monta lipputyyppiä/tapahtuma*/
	
	public Lipputyyppi() {
		
	}
	public Lipputyyppi(String nimi) {
		this.nimi = nimi;
	}
	public long getTyyppiid() {
		return tyyppiid;
	}
	public void setTyyppiid(long tyyppiid) {
		this.tyyppiid = tyyppiid;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public List<Tapahtumalipputyyppi> getTapahtumalipputyypit(){
		return tapahtumalipputyypit;
	}
		
	public void setTapahtumalipputyypit(List<Tapahtumalipputyyppi> tapahtumalipputyypit) {
		this.tapahtumalipputyypit = tapahtumalipputyypit;
	}
	
	@Override
	public String toString() {
		return "Lipputyyppi [tyyppiid=" + tyyppiid + ", nimi=" + nimi + "]";
	}

}
