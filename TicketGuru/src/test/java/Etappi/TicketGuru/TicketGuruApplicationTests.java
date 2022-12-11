package Etappi.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class TicketGuruApplicationTests {

	@Autowired
	private WebApplicationContext webAppContext;
	
	@Before
	public void setUp() {
		MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	
	@Test
	public void EiTyhjälippu() throws Exception {
		assertThat("/liput/0").isNotNull();
		}
	
	
	@Test
	public void EiTyhjälipputyyppi() throws Exception {
		assertThat("//tapahtumalipputyypit/0").isNotNull();
		}

	
	@Test
	public void EiTyhjäkayttaja() throws Exception {
		assertThat("/kayttajat/0").isNotNull();
		}

	@Test
	public void EiTyhjäMT() throws Exception {
		assertThat("/myyntitapahtumat/0").isNotNull();
		}
	

	@Test
	public void EiTyhjäTapahtuma() throws Exception {
		assertThat("/tapahtumat/0").isNotNull();
	}
	
	@Test
	public void EiTyhjäLipputyyppi() throws Exception {
		assertThat("/lipputyypit/0").isNotNull();
	}
	
}

