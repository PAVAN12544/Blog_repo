package com.zensar.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.dto.BlogDto;
import com.zensar.service.BlogService;

@WebMvcTest(BlogController.class)
public class TestBlogController {
	
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@MockBean
	BlogService blogService;
	
	@Test
	public  void testCreateBlogDto() throws Exception
	{
		BlogDto blogDto= new BlogDto("India", "India is a Best Country");
		when(blogService.createBlog(blogDto)).thenReturn(blogDto);
		MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8080/blogmenu/post")
				.contentType("application/json").content(objectMapper.writeValueAsString(blogDto)))
		        .andExpect(status().isOk())
		        .andReturn();
		String contentAsString = mvcResult.getResponse().getContentAsString();
		assertTrue(contentAsString.contains("India"));
		
	}



	
}
