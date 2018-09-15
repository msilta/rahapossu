package fi.multisilta.rahapossu.model.portfolio;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "value_at_moment")
public class ValueAtMoment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "timestamp")
    private Instant timestamp;

    @Embedded
    private Value value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", nullable = false, updatable = false)
    private Asset asset;

}
