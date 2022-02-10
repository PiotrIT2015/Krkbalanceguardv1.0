package engine.pp.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

import engine.pp.Gekonapplication;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SpringBootTest(classes=Gekonapplication.class)
public class voterControllerTest {

    @Autowired
    private voterController voterController;

    @Test
    void testGeneruj() {
        assertNotNull("Data is uploaded", voterController);
    }
}
