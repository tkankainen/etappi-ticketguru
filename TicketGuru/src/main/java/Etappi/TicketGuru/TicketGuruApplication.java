package Etappi.TicketGuru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/*import Etappi.TicketGuru.domain.Lipputyyppi;
import Etappi.TicketGuru.domain.LipputyyppiRepository;*/
import Etappi.TicketGuru.domain.Tapahtuma;
import Etappi.TicketGuru.domain.TapahtumaRepository;
import Etappi.TicketGuru.domain.Tapahtumalipputyyppi;
import Etappi.TicketGuru.domain.TapahtumalipputyyppiRepository;


//jos haluaa commanline runner testiä

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketGuruApplication {
	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);//jos testiä
	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}
	@Bean //jos testiä
	public CommandLineRunner tapahtumaDemo(TapahtumaRepository brepository, TapahtumalipputyyppiRepository trepository) {
		return (args) -> {
		log.info("save a couple of tapahtuma");
		
		//lrepository.save(new Lipputyyppi("Aikuinen"));
	//	lrepository.save(new Lipputyyppi("Lapsi"));
		
						
		Tapahtuma tapahtuma1= new Tapahtuma("1.9.2022", "Tapahtuma1", "os1","HKI",5,"15.9.2022");
		Tapahtuma tapahtuma2= new Tapahtuma("1.9.2023", "Tapahtuma2", "os1","HKI",5,"15.9.2023");
		
				
		brepository.save(tapahtuma1);
		brepository.save(tapahtuma2);
		
		log.info("fetch all tapahtuma");
		for (Tapahtuma tapahtuma : brepository.findAll()) {
			log.info(tapahtuma.toString());
		}
		log.info("fetch all tapahtumalipputyyppi ");
		for (Tapahtumalipputyyppi tapahtumalipputyyppi : trepository.findAll()) {
			log.info(tapahtumalipputyyppi.toString());
		}
		/*log.info("fetch all lipputyyppi");
		for (Lipputyyppi lipputyyppi : lrepository.findAll()) {
			log.info(lipputyyppi.toString());
		}*/
		};
	}

}