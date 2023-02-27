package com.claro.resttest;

import com.claro.resttest.Repository.UsuarioRepository;
import com.claro.resttest.Rest.UsuarioController;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

//@WebMvcTest
@AutoConfigureMockMvc
@SpringBootTest
class RestTestApplicationTests {

	@MockBean
	private UsuarioRepository userRepository;

	@Autowired
	UsuarioController userController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void TestCreateUser() throws Exception {
		String user = "{\"nombre\": \"bob\", \"apellido\" : \"romero\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/Usuarios").content(user)
						.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content()
						.contentType(new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"))));
	}

	@Test
	public void TestbadDataRequest() throws Exception {
		String user = "{\"nombre\": \"bob\", \"apellido\" : \"\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/Usuarios").content(user)
						.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
