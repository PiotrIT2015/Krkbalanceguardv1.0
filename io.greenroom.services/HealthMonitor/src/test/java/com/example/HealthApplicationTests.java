package com.example;

import com.example.service.HealthService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthApplicationTests {

	private HealthService myFile;

	@After
	public void closeReaderIfPresent() {
		if (myFile != null) {
			System.out.println("The file is open.");
		}
	}

	@Test
	public void contextLoads() {
		myFile = new HealthService("./data/shopping.txt");
		assert myFile.getPath().equals("./data/shopping.txt");
		assert myFile.getNameOfFile().equals("shopping.txt");
	}

}
