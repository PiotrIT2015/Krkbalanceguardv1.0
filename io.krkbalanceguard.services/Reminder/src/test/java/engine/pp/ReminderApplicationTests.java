package engine.pp;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import engine.pp.controller.shoppingController;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReminderApplicationTests {

    @Autowired
    shoppingController shoppingController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(shoppingController).isNot(null);
    }

}
