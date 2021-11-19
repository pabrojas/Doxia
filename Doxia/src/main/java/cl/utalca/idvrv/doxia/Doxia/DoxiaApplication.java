package cl.utalca.idvrv.doxia.Doxia;

import cl.utalca.idvrv.doxia.Doxia.models.User;
import cl.utalca.idvrv.doxia.Doxia.models.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class DoxiaApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DoxiaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository repository)
	{
		return (String[] args) -> {


				/*
				User user = new User();
				user.setUsername("doxia");
				user.setPassword("doxiapass");

				repository.save(user);
				 */

				Optional<User> ouser = repository.findById(1);
				if( ouser.isPresent() )
				{
					User user = ouser.get();
					System.out.println("USER : " + user.getUsername());

				}
				else
				{
					System.out.println("USER NOT FOUND");
				}







		};
	}



}
