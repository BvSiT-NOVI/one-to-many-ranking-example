package nl.bvsit.onetomanyrankingexample;

import nl.bvsit.onetomanyrankingexample.domain.Stage;
import nl.bvsit.onetomanyrankingexample.repository.StageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToManyRankingExampleApplicationTests {

    @Autowired
    StageRepository stageRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void getRanking(){
        for(Stage stage: stageRepository.findAll()){
            System.out.println(stage.getStage_order());
        }
    }

}
