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
public class Tila {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tilaid;
	
	private String nimi;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tila")
	private List<Lippu> liput;
	
	public Tila() {
	}

	public Tila(String nimi) {
		this.nimi = nimi;
	}

	public long getTilaid() {
		return tilaid;
	}

	public void setTilaid(long tilaid) {
		this.tilaid = tilaid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Lippu> getLiput() {
		return liput;
	}

	public void setLiput(List<Lippu> liput) {
		this.liput = liput;
	}

	@Override
	public String toString() {
		return "Tila [tilaid=" + tilaid + ", nimi=" + nimi + "]";
	}

}
