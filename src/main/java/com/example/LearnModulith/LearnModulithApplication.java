package com.example.LearnModulith;

import com.example.LearnModulith.config.ModulithRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(ModulithRegistrar.class)
@SpringBootApplication
public class LearnModulithApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnModulithApplication.class, args);
	}

}
