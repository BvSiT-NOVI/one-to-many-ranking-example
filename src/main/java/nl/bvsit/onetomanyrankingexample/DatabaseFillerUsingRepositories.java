package nl.bvsit.onetomanyrankingexample;

import nl.bvsit.onetomanyrankingexample.domain.Stage;
import nl.bvsit.onetomanyrankingexample.domain.Voyage;
import nl.bvsit.onetomanyrankingexample.repository.StageRepository;
import nl.bvsit.onetomanyrankingexample.repository.VoyageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Copy from nl.novi.stuivenberg.springboot.example.security.DatabaseFiller
 * UITLEG COMPONENT ANNOTATIE
 * http://zetcode.com/springboot/component/
 */
@Transactional
@Component
public class DatabaseFillerUsingRepositories implements CommandLineRunner {
    private static final Logger logger =  LoggerFactory.getLogger(DatabaseFillerUsingRepositories.class);

    @Autowired
    VoyageRepository voyageRepository;
    @Autowired
    StageRepository stageRepository;

    @Override
    public void run(String... args)  {
        logger.info("Running "+ this.getClass().getName());
        Voyage voyage = saveVoyage("To the moon");
        saveStage("lift-off",voyage);
        saveStage("max-q",voyage);
        saveStage("earth orbit",voyage);
        saveStage("TLI",voyage);
        saveStage("LOI",voyage);

        for (int i = 0; i < 5; i++) {
            Voyage v = saveVoyage("vogage "+i);
            for (int j = 0; j < 10; j++) {
                saveStage("stage "+j,v);
            }
        }





    }

    public Voyage saveVoyage(String name) {
        //em.getTransaction().begin();//NO, managed by spring boot
        Voyage voyage = new Voyage();
        voyage.setName(name);
        voyageRepository.save(voyage);
        return voyage;
        //em.getTransaction().commit();//NO, managed by spring boot
    }

    public void saveStage(String name,Voyage voyage) {
        Stage stage = new Stage();
        stage.setName(name);
        voyage.getStages().add(stage);
        stage.setVoyage(voyage);
    }

}

