package Etappi.TicketGuru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Myyntitapahtuma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long myyntiid;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	private String timestamp;
	
	public Myyntitapahtuma() {}
	
	public Myyntitapahtuma(long myyntiid, User user, String timestamp) {
		
		super();
		this.user = user;
		this.timestamp = timestamp;
	}

	public long getMyyntiid() {
		return myyntiid;
	}

	public void setMyyntiid(long myyntiid) {
		this.myyntiid = myyntiid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Myyntitapahtuma [myyntiid=" + myyntiid + ", user=" + this.getUser() + ", timestamp=" + timestamp + "]";
	}
	
	
	

}
