package dmitry.avgustis.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeApplication {


    public static void main(String[] args) {
        SpringApplication.run(PrototypeApplication.class, args);
		/*
		TODO exception handling, security, swagger customization, permissive mode, async api stack
		 */
		//http://localhost:8081/h2-console
    }
}
