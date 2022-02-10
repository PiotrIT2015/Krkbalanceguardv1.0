package engine.pp.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import engine.pp.Reminderapplication;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SpringBootTest(classes=Reminderapplication.class)
class shoppingControllerTest {

	@Autowired
	private shoppingController shoppingController;

	@Test
	void testGeneruj() {
		assertNotNull("Data is uploaded", shoppingController);
	}

}
