package engine.pp.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertNotNull;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import engine.pp.HealthMonitorapplication;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SpringBootTest(classes=HealthMonitorapplication.class)
class healthControllerTest {
	
	@Autowired
    private healthController healthController;

	@Test
	void testGeneruj() {
		assertNotNull("Data is uploaded", healthController);
	}

}
