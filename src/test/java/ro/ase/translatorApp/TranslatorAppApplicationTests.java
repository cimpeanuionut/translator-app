package ro.ase.translatorApp;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ro.ase.translatorApp.controllers.TranslateController.TranslateController;

import java.security.Principal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class TranslatorAppApplicationTests {

	private MockMvc mockMvc;

	@Mock
	private Principal principal;

	@BeforeEach
	public void setup() {
		this.mockMvc = standaloneSetup(new TranslateController()).build();
	}

	@Test
	void testController() throws Exception {
		this.mockMvc.perform(get("/api/translate").header("Authorization","Basic").header("username","guest").header("password","guest123").principal(principal))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=ISO-8859-1"));
	}



}
