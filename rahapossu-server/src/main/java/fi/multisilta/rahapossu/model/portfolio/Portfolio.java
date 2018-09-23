package fi.multisilta.rahapossu.model.portfolio;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "portfolio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Asset> assets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Asset> getAssets() {
        return assets;
    }

    public void setAssets(Set<Asset> assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", id:" + getId();
    }
}
