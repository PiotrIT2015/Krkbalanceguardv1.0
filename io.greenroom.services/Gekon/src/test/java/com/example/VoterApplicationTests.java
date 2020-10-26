package com.example;

import com.example.service.VoterService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoterApplicationTests {

	private VoterService myFile;

	@After
	public void closeReaderIfPresent() {
		if (myFile != null) {
			System.out.println("The file is open.");
		}
	}

	@Test
	public void contextLoads() {
		myFile = new VoterService("./data/resolutions.txt");
		assert myFile.getPath().equals("./data/resolutions.txt");
		assert myFile.getNameOfFile().equals("shopping.txt");
	}

}
