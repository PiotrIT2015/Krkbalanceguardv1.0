package engine.pp.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class voterControllerTest {

    @Autowired
    private voterController voterController;

    @Test
    void testGeneruj() {
        assertNotNull("Data is uploaded", voterController);
    }
}
