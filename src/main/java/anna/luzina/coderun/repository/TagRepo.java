package anna.luzina.coderun.repository;

import anna.luzina.coderun.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, Long> {
}
