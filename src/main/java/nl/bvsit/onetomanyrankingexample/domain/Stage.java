package nl.bvsit.onetomanyrankingexample.domain;

import javax.persistence.*;

@Entity
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "voyage_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name="fk_stage_voyage") )
    Voyage voyage;

    private int stage_order;

    public int getStage_order() {
        return stage_order;
    }

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
    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }
}
