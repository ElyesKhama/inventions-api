package technical.test.elyes.inventionsapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import technical.test.elyes.inventionsapi.model.Invention;

//Unit tests
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InventionsApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void shouldReturnStatusOkGetInvention() throws Exception {
		this.mockMvc.perform(get("/inventions")).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnStatusOkGetInventionId() throws Exception {
		this.mockMvc.perform(get("/inventions/1")).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnStatus400GetInventionWrongId() throws Exception {
		this.mockMvc.perform(get("/inventions/toto")).andExpect(status().isBadRequest());
	}

	@Test
	public void shouldReturnBodyMalFormedPostInvention() throws Exception {
		// test if the return status code is 400 if we don't provide the name
		Invention inv = new Invention();
		inv.setDate(1234);
		this.mockMvc.perform(post("/inventions").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(inv))).andExpect(status().isBadRequest());
	}

	@Test
	public void shouldReturnStatusOKPostInvention() throws Exception {
		// test if the return status code is 201 if we provide the name
		Invention inv = new Invention();
		inv.setName("toto");
		inv.setDate(1234);
		this.mockMvc.perform(post("/inventions").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(inv))).andExpect(status().isCreated());
	}

}
