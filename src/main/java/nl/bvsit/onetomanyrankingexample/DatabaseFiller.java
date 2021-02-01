package nl.bvsit.onetomanyrankingexample;

import nl.bvsit.onetomanyrankingexample.domain.Stage;
import nl.bvsit.onetomanyrankingexample.domain.Voyage;
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
public class DatabaseFiller implements CommandLineRunner {
    private static final Logger logger =  LoggerFactory.getLogger(DatabaseFiller.class);

    @PersistenceContext
    EntityManager em;

    @Override
    public void run(String... args)  {
        logger.info("Running "+ this.getClass().getName());
        Voyage voyage = saveVoyage("To the moon");
        saveStage("lift-off",voyage);
        saveStage("max-q",voyage);
        saveStage("earth orbit",voyage);
        saveStage("TLI",voyage);
        saveStage("LOI",voyage);

    }

    public Voyage saveVoyage(String name) {
        //em.getTransaction().begin();//NO, managed by spring boot
        Voyage voyage = new Voyage();
        voyage.setName(name);
        em.persist(voyage);
        return voyage;
        //em.getTransaction().commit();//NO, managed by spring boot
    }

    public void saveStage(String name,Voyage voyage) {
        Stage stage = new Stage();
        stage.setName(name);
        stage.setVoyage(voyage);
        em.persist(stage);
    }

}

