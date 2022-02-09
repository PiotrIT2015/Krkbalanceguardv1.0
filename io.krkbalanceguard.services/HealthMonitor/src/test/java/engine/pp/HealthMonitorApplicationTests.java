package engine.pp;

import engine.pp.services.windowService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertThat;

import engine.pp.controller.healthController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HealthMonitorApplicationTests {

	@Autowired
	  healthController healthController;
	 
	  @Test
	  public void contextLoads() {
	    Assertions.assertThat(healthController).isNot(null);
	  }

}
