package com.sha.gestaoHoteleira;

import java.util.stream.LongStream;

import com.sha.gestaoHoteleira.model.Contact;
import com.sha.gestaoHoteleira.repository.ContactRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestaoHoteleiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoHoteleiraApplication.class, args);
	}

	@Bean
    CommandLineRunner init(ContactRepository repository) {
        return args -> {
            repository.deleteAll();
            LongStream.range(1, 3)
                    .mapToObj(i -> {
                        Contact c = new Contact();
                        c.setName("Contact " + i);
                        c.setEmail("contact" + i + "@email.com");
                        c.setPhone("(99) 000-000");
                        return c;
                    })
                    .map(v -> repository.save(v))
                    .forEach(System.out::println);
        };
    }

}
