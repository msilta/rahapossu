package fi.multisilta.rahapossu.model.portfolio;

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
    @Column(name = "symbol")
    private String symbol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false, updatable = false)
    private Portfolio portfolio;

    @OneToMany(mappedBy = "asset", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("timestamp DESC")
    private List<ValueAtMoment> values;
}
