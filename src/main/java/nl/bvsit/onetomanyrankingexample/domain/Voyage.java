package nl.bvsit.onetomanyrankingexample.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OrderColumn(name="stage_order")
    @OneToMany(mappedBy="voyage",cascade = CascadeType.ALL ,orphanRemoval = true)
    //@OneToMany() //This creates a join table
    private Set<Stage> stages= new HashSet<>();

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

    public Set<Stage> getStages() {
        return stages;
    }

    public void setStages(Set<Stage> stages) {
        this.stages = stages;
    }
}
