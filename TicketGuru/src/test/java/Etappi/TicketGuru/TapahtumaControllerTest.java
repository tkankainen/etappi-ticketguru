package Etappi.TicketGuru;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TapahtumaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	
	// luo tapahtuma
	
	JSONObject testiTapahtuma() throws JSONException {
		  JSONObject tapahtuma = new JSONObject();
		  tapahtuma.put("aika", "2023-01-01T12:00:00");
		  tapahtuma.put("nimi", "TestRock");
		  tapahtuma.put("osoite", "Testilä");
		  tapahtuma.put("kaupunki", "Helsinki");
		  tapahtuma.put("kpl", 10);
		  tapahtuma.put("loppupvm", "02.01.2023");
		  return tapahtuma;
	  }
	  // Testaa POST
	  @Test
	  @WithMockUser(username = "a2", password = "admin", authorities = "ADMIN")
	  public void testLuoJaPoista() throws Exception {
		  
		  JSONObject testiTapahtuma = testiTapahtuma();
		  
		  mockMvc.perform(post("/api/tapahtumat/")
		  		.content(testiTapahtuma.toString())
		  		.contentType("application/json"))
		  		.andExpect(status().isCreated());
	
		  
		  		  
	  }
	  

}
