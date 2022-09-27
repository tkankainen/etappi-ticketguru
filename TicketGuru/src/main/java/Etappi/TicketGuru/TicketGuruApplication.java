package Etappi.TicketGuru;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import Etappi.TicketGuru.domain.Kayttaja;
import Etappi.TicketGuru.domain.KayttajaRepository;
import Etappi.TicketGuru.domain.Lippu;
import Etappi.TicketGuru.domain.LippuRepository;
import Etappi.TicketGuru.domain.Lipputyyppi;
import Etappi.TicketGuru.domain.LipputyyppiRepository;
import Etappi.TicketGuru.domain.Myyntitapahtuma;
import Etappi.TicketGuru.domain.MyyntitapahtumaRepository;
import Etappi.TicketGuru.domain.Tapahtuma;
import Etappi.TicketGuru.domain.TapahtumaRepository;
import Etappi.TicketGuru.domain.Tapahtumalipputyyppi;
import Etappi.TicketGuru.domain.TapahtumalipputyyppiRepository;
import Etappi.TicketGuru.domain.Tila;
import Etappi.TicketGuru.domain.TilaRepository;

//jos haluaa commandline runner testiä

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketGuruApplication {
	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);//jos testiä
	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}
	@Bean //jos testiä
	public CommandLineRunner tapahtumaDemo(TapahtumaRepository brepository, TapahtumalipputyyppiRepository trepository, 
			LippuRepository lrepository, TilaRepository tilarepository, KayttajaRepository krepository) {
		return (args) -> {
		log.info("save a couple of tapahtuma");
		
//		lrepository.save(new Lipputyyppi("Aikuinen"));
//		lrepository.save(new Lipputyyppi("Lapsi"));
		
		LocalDateTime aika1 = LocalDateTime.of(2022,12,21,18,00); //int (vuosi,kk,pv,tunnit,minuutit(,sekunnit)
		LocalDateTime aika2 = LocalDateTime.of(2022,10,8,20,00);
		LocalDateTime aikanyt = LocalDateTime.now(); 
		
		//lisätään muutama käyttäjä
				// Create kayttajat: admin/admin user/user
				Kayttaja kayttaja1 = new Kayttaja("User1", "Snimi", "u1", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				Kayttaja kayttaja2 = new Kayttaja("User2", "Snimi", "u2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "ADMIN");
				krepository.save(kayttaja1);
				krepository.save(kayttaja2);
		
		
		Tapahtuma tapahtuma1= new Tapahtuma(aika1, "Tapahtuma1", "os1","HKI", 5, "15.9.2022");
		Tapahtuma tapahtuma2= new Tapahtuma(aika2, "Tapahtuma2", "os1","HKI",5,"15.9.2023");
		Tapahtuma tapahtuma3= new Tapahtuma(aikanyt, "Tapahtuma3", "Kulttuuritalo", "Helsinki", 500, "31.12.2022");
				
		brepository.save(tapahtuma1);
		brepository.save(tapahtuma2);
		brepository.save(tapahtuma3);
		
		Tila vapaa = new Tila("vapaa");
		Tila kaytetty = new Tila("käytetty");
		
		tilarepository.save(vapaa);
		tilarepository.save(kaytetty);
		
		Lippu lippu1 = new Lippu(tapahtuma1, vapaa, "abc234", 25);
		Lippu lippu2 = new Lippu(tapahtuma3, kaytetty, "iopp453f", 12);
		
		lrepository.save(lippu1);
		lrepository.save(lippu2);
		
		log.info("fetch all tapahtuma");
		for (Tapahtuma tapahtuma : brepository.findAll()) {
			log.info(tapahtuma.toString());
		}
		log.info("fetch all tapahtumalipputyyppi ");
		for (Tapahtumalipputyyppi tapahtumalipputyyppi : trepository.findAll()) {
			log.info(tapahtumalipputyyppi.toString());
		}
//		log.info("fetch all lipputyyppi");
//		for (Lipputyyppi lipputyyppi : lrepository.findAll()) {
//			log.info(lipputyyppi.toString());
//		}
		
		log.info("fetch all lippu");
		for (Lippu lippu : lrepository.findAll()) {
			log.info(lippu.toString());
		}
		};
	}

}