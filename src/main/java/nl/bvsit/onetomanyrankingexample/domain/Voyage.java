package nl.bvsit.onetomanyrankingexample.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy="voyage"
            ,cascade = CascadeType.ALL
            ,orphanRemoval = true)
    private List<Stage> stages = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }
}
