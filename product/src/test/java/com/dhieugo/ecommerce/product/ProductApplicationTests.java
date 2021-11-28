package com.dhieugo.ecommerce.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // clear data every single test case
class ProductApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetProductList() throws Exception {
		this.mockMvc.perform(get("/api/products"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(4)))
				.andExpect(jsonPath("$.totalPages", is(1)))
				.andExpect(jsonPath("$.totalElements", is(4)));

		// verify filter in case empty result
		this.mockMvc.perform(get("/api/products?brands=-1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(0)))
				.andExpect(jsonPath("$.totalPages", is(0)))
				.andExpect(jsonPath("$.totalElements", is(0)));

		// verify filter in case - has result - category
		this.mockMvc.perform(get("/api/products?categories=1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(2)))
				.andExpect(jsonPath("$.totalPages", is(1)))
				.andExpect(jsonPath("$.totalElements", is(2)))
				.andExpect(jsonPath("$.content[0].productName", is("BMW M5")));

		// verify filter in case - has result - brand
		this.mockMvc.perform(get("/api/products?brands=1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(1)))
				.andExpect(jsonPath("$.totalPages", is(1)))
				.andExpect(jsonPath("$.totalElements", is(1)))
				.andExpect(jsonPath("$.content[0].productName", is("BMW M5")));

		// verify filter in case - has result - color
		this.mockMvc.perform(get("/api/products?colors=red,blue"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(2)))
				.andExpect(jsonPath("$.totalPages", is(1)))
				.andExpect(jsonPath("$.totalElements", is(2)))
				.andExpect(jsonPath("$.content[0].productName", is("BMW M5")));

		// verify filter in case - has result - price
		this.mockMvc.perform(get("/api/products?price=30000-50000"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(2)))
				.andExpect(jsonPath("$.totalPages", is(1)))
				.andExpect(jsonPath("$.totalElements", is(2)))
				.andExpect(jsonPath("$.content[0].productName", is("BMW M5")));

		// verify filter in case - no result - price
		this.mockMvc.perform(get("/api/products?price=0-0"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(0)))
				.andExpect(jsonPath("$.totalPages", is(0)))
				.andExpect(jsonPath("$.totalElements", is(0)));

	}

	@Test
	public void testProductDetails() throws Exception {
		// in case 404 - not found the product
		this.mockMvc.perform(get("/api/products/-1"))
				.andDo(print())
				.andExpect(status().is4xxClientError());

		// when we found the product
		this.mockMvc.perform(get("/api/products/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productName", is("BMW M5")));
	}

	@Test
	public void testGetCategories() throws Exception {
		this.mockMvc.perform(get("/api/categories"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(5)))
				.andExpect(jsonPath("$.totalPages", is(1)))
				.andExpect(jsonPath("$.totalElements", is(5)));
	}

	@Test
	public void testGetBrands() throws Exception {
		this.mockMvc.perform(get("/api/brands"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(3)))
				.andExpect(jsonPath("$.totalPages", is(1)))
				.andExpect(jsonPath("$.totalElements", is(3)));
	}

}
