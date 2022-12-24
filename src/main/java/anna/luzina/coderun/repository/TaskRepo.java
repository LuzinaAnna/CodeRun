package anna.luzina.coderun.repository;

import anna.luzina.coderun.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
