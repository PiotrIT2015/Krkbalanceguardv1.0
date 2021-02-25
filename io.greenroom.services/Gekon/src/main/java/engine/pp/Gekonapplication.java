package engine.pp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.awt.EventQueue;


//@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class Gekonapplication {

	public static void main(String[] args) {

		var ctx = new SpringApplicationBuilder(Gekonapplication.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {

			var ex = ctx.getBean(Gekonapplication.class);
			//ex.setVisible(true);
		});
	}
}
