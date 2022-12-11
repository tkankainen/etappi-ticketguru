package Etappi.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDateTime;

import Etappi.TicketGuru.domain.Kayttaja;
import Etappi.TicketGuru.domain.KayttajaRepository;
import Etappi.TicketGuru.domain.Lippu;
import Etappi.TicketGuru.domain.LippuRepository;
import Etappi.TicketGuru.domain.Myyntitapahtuma;
import Etappi.TicketGuru.domain.MyyntitapahtumaRepository;
import Etappi.TicketGuru.domain.Tapahtuma;
import Etappi.TicketGuru.domain.TapahtumaRepository;
import Etappi.TicketGuru.domain.Tapahtumalipputyyppi;
import Etappi.TicketGuru.domain.TapahtumalipputyyppiRepository;



@DataJpaTest
public class LippuTests {
	
	private LocalDateTime aika;

	@Autowired
	private LippuRepository LRepo;
	
	@Autowired
	private KayttajaRepository Krepo;
	
	@Autowired
	private MyyntitapahtumaRepository Mrepo;

	@Autowired
	private TapahtumaRepository TRepo;

	@Autowired
	private TapahtumalipputyyppiRepository TypeRepo;
	
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "lippukoodi", columnDefinition = "uuid", unique = true, nullable = false)
	@Type(type="pg-uuid") //type="uuid-char" mikäli käytössä h2
	private UUID lippukoodi;
	


	@Test
	public void LuoLippu() {

		Tapahtuma TapahtumaTest = new Tapahtuma(aika,"TestiRock", "Testilä", "Helsinki", 300, "12.12.2023");
		Tapahtumalipputyyppi TyyppiTest = new Tapahtumalipputyyppi(2, "Opiskelija", TapahtumaTest);
		Kayttaja KayttajaTest = new Kayttaja("Testi","Testinen", "Testaaja", "abc123", "admin");
		Myyntitapahtuma MyyntiTest = new Myyntitapahtuma(KayttajaTest, aika, "Toteutunut");
		Lippu TestiLippu = new Lippu(TyyppiTest, MyyntiTest, lippukoodi, 10, "käytetty");
		LRepo.save(TestiLippu);
		Krepo.save(KayttajaTest);
		Mrepo.save(MyyntiTest);
		TRepo.save(TapahtumaTest);
		TypeRepo.save(TyyppiTest);

		assertThat(TestiLippu.getKaytetty()).isNotNull();
		assertThat(TestiLippu.getLippuid()).isNotNull();
		assertThat(TestiLippu.getHinta()).isNotNull();
		assertThat(TestiLippu.getLippukoodi()).isNotNull();
		assertThat(TestiLippu.getMyyntitapahtuma()).isNotNull();
		assertThat(TestiLippu.getTapahtumalipputyyppi()).isNotNull();

	}

}
