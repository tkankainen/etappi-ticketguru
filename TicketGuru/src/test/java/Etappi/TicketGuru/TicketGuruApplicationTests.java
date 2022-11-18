package Etappi.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class TicketGuruApplicationTests {

	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@Test
	public void statusOk() throws Exception {
		mockMvc.perform(get("/liput")).andExpect(status().isOk());
	}
	
	@Test
	public void statusidOk() throws Exception {
		mockMvc.perform(get("/liput/0")).andExpect(status().isOk());
	}
	
	@Test
	public void EiTyhjälippu() throws Exception {
		assertThat("/liput/0").isNotNull();
		}

	@Test
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/liput"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void apiStatusOk() throws Exception {
		mockMvc.perform(get("/api/liput")).andExpect(status().isOk());
	}
	
	@Test
	public void statusOkTLT() throws Exception {
		mockMvc.perform(get("/tapahtumalipputyypit")).andExpect(status().isOk());
	}
	
	@Test
	public void statusidOkTLT() throws Exception {
		mockMvc.perform(get("/tapahtumalipputyypit/1")).andExpect(status().isOk());
	}
	
	@Test
	public void EiTyhjälipputyyppi() throws Exception {
		assertThat("//tapahtumalipputyypit/1").isNotNull();
		}

	@Test
	public void responseTypeApplicationJsonTLT() throws Exception {
		mockMvc.perform(get("/tapahtumalipputyypit"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void apiStatusOkTLTkayttaja() throws Exception {
		mockMvc.perform(get("/api/tapahtumalipputyypit")).andExpect(status().isOk());
	}
	
	@Test
	public void statusOkkayttaja() throws Exception {
		mockMvc.perform(get("/kayttajat")).andExpect(status().isOk());
	}
	
	@Test
	public void statusidOkkayttaja() throws Exception {
		mockMvc.perform(get("/kayttajat/1")).andExpect(status().isOk());
	}
	
	@Test
	public void EiTyhjäkayttaja() throws Exception {
		assertThat("/kayttajat/1").isNotNull();
		}

	@Test
	public void responseTypeApplicationJsonkayttaja() throws Exception {
		mockMvc.perform(get("/kayttajat"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void apiStatusOkkayttaja() throws Exception {
		mockMvc.perform(get("/api/kayttajat")).andExpect(status().isOk());
	}
	
	@Test
	public void statusOkMT() throws Exception {
		mockMvc.perform(get("/myyntitapahtumat")).andExpect(status().isOk());
	}
	
	@Test
	public void statusidOkMT() throws Exception {
		mockMvc.perform(get("/myyntitapahtumat/1")).andExpect(status().isOk());
	}
	
	@Test
	public void EiTyhjäMT() throws Exception {
		assertThat("/myyntitapahtumat/1").isNotNull();
		}

	@Test
	public void responseTypeApplicationJsonMT() throws Exception {
		mockMvc.perform(get("/myyntitapahtumat"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void apiStatusOkMT() throws Exception {
		mockMvc.perform(get("/api/myyntitapahtumat")).andExpect(status().isOk());
	}
	
	@Test
	public void statusOkTapahtuma() throws Exception {
		mockMvc.perform(get("/tapahtumat")).andExpect(status().isOk());
	}
	
	@Test
	public void statusidOkTapahtuma() throws Exception {
		mockMvc.perform(get("/tapahtumat/1")).andExpect(status().isOk());
		
	}

	@Test
	public void EiTyhjäTapahtuma() throws Exception {
		assertThat("/tapahtumat/1").isNotNull();
	}
	
	@Test
	public void responseTypeApplicationJsonTapahtuma() throws Exception {
		mockMvc.perform(get("/tapahtumat"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void apiStatusOkTapahtuma() throws Exception {
		mockMvc.perform(get("/api/tapahtumat")).andExpect(status().isOk());
	}
}

