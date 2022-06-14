package com.rameskum.dogfacts;

import com.rameskum.dogfacts.controller.FactsController;
import com.rameskum.dogfacts.service.FactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class DogFactsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private FactsController controller;

	@Autowired
	private FactService factService;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	void response() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/facts/dog"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.header().exists("Vary"));
	}

	@Test
	void responseType() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/facts/dog"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.header().string("Content-Type", "image/svg+xml;charset=UTF-8"));
	}

	@Test
	void testFactService() {
		Assertions.assertEquals(1, this.factService.getFacts(1).getFacts().size());
		Assertions.assertEquals(2, this.factService.getFacts(2).getFacts().size());
		Assertions.assertEquals(20, this.factService.getFacts(20).getFacts().size());
	}
}
