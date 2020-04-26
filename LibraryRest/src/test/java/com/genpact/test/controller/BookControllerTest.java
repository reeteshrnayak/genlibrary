package com.genpact.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.genpact.test.data.TestData;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void listBook() throws Exception {
		mockMvc.perform(get("/books/1")).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void findOne() throws Exception {
		mockMvc.perform(get("/books/lib/1")).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void updateBook() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/books/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(TestData.getBookJson(1));

		this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(
						"{\"status\":200,\"message\":\"Book updated successfully.\",\"result\":{\"id\":1,\"name\":\"Genpact Interview\",\"author\":\"Reetesh\",\"year\":2020,\"lid\":1}}"))
				.andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void saveBook() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/books")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(TestData.getBookJson(1));

		this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void deleteBook() throws Exception {

		mockMvc.perform(delete("/books/1")).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}


}
