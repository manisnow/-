package thamiz.ariviyal.thamizariviyalpinthalam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@RestController
@SpringBootApplication
public class ThamizariviyalPinthalamApplication {

@RequestMapping("/")
String home(){
return "Hello World!";	
}


	public static void main(String[] args) {
		SpringApplication.run(ThamizariviyalPinthalamApplication.class, args);
	}
}
