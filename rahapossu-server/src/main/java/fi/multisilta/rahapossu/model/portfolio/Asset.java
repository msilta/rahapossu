package fi.multisilta.rahapossu.model.portfolio;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AssetType type;

    /**
     * User-defined name for the asset.
     */
    @Column(name = "name")
    private String name;

    /**
     * General identifier for the asset (e.g. ETF ticker 'IS3N').
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "symbol")
    private String symbol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false, updatable = false)
    private Portfolio portfolio;

    @OneToMany(mappedBy = "asset", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("timestamp DESC")
    private List<ValueAtMoment> values;

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public AssetType getType() {
        return type;
    }

    public void setType(AssetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public List<ValueAtMoment> getValues() {
        return values;
    }

    public void setValues(List<ValueAtMoment> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", id:" + getId();
    }
}
