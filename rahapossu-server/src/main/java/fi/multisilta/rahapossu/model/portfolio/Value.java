package fi.multisilta.rahapossu.model.portfolio;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Value {

    @Enumerated(EnumType.STRING)
    @Column(name = "value_currency")
    private Currency currency;

    @Column(name = "value_amount")
    private Long amount;
}
