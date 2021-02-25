package engine.pp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.awt.EventQueue;


//@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class HealthMonitorapplication {

	public static void main(String[] args) {

		var ctx = new SpringApplicationBuilder(HealthMonitorapplication.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {

			var ex = ctx.getBean(HealthMonitorapplication.class);
			//ex.setVisible(true);
		});
	}
}
