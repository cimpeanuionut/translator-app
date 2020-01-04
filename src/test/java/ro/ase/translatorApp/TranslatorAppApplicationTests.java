package ro.ase.translatorApp;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ro.ase.translatorApp.controllers.TranslateController.TranslateController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class TranslatorAppApplicationTests {

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		this.mockMvc = standaloneSetup(new TranslateController()).build();
	}

	@Test
	void testController() throws Exception {
		this.mockMvc.perform(get("/api/translate"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=ISO-8859-1"));
	}



}
