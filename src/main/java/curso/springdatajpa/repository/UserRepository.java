package curso.springdatajpa.repository;

import curso.springdatajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    // QueryMethod
    List<User> findByNameContaining(String name);
    User findByUsername(String username);

    // Query Override
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> filterByName(@Param("name") String name);
}
