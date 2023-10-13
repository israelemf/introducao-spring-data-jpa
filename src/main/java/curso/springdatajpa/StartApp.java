package curso.springdatajpa;

import curso.springdatajpa.model.User;
import curso.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Component = Objeto gerenciado pelo Spring Framework
@Component
public class StartApp implements CommandLineRunner {
    // Ao injetar o nosso repositório no programa principal, utilizamos o @Autowired para que exista a injeção de dependencia
    @Autowired
    private UserRepository userRepository;

    /* No Spring Boot, precisamos inicializar o CommandLineRunner, que é uma instrução semelhante ao método main,
	   que após executar o container, o comando principal ser iniciado automaticamente. */
    @Override
    public void run(String... args) throws Exception {
        User newUser = new User();
        newUser.setName("Israel");
        newUser.setUsername("israelemf");
        newUser.setPassword("12345");

        // Salvando o usuario no banco de dados, utilizando os métodos previamento implementados na JpaRepository do Spring Data
        userRepository.save(newUser);

        // Exibe o toString da classe User dos usuarios salvos no banco, no console
        userRepository.findAll().forEach(System.out::println);
    }
}
