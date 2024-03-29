package engine.pp;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import engine.pp.controller.voterController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GekonApplicationTests {

	@Autowired
	voterController voterController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(voterController).isNot(null);
	}

}
