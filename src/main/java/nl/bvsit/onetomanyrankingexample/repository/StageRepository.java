package nl.bvsit.onetomanyrankingexample.repository;

import nl.bvsit.onetomanyrankingexample.domain.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepository extends JpaRepository<Stage,Long> {
}
