package anna.luzina.coderun.repository;

import anna.luzina.coderun.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    User findById(Long id);
}