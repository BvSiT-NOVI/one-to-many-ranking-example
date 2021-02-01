package nl.bvsit.onetomanyrankingexample.repository;

import nl.bvsit.onetomanyrankingexample.domain.Stage;
import nl.bvsit.onetomanyrankingexample.domain.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageRepository extends JpaRepository<Voyage,Long> {
}
