package WellnessApp;

/**
 * Created by Hasan on 8/10/2017.
 */
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan
@SpringBootApplication
public class Example {

//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
