package com.brokerapp.btcusdtrend;

import com.brokerapp.btcusdtrend.controllers.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
@SpringBootTest
public class BtcTrendApplicationTests {

	private String[] curr = {"BTCUSD","ETHUSD"};
	@Autowired
	WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void whenPost_thenChart() throws Exception{
		mockMvc.perform(post("/chart")
			.param("startingDate","2018-06-01")
			.param("currencies", Arrays.asList(curr).toString())
		).andExpect(status().isOk());
	}

}
