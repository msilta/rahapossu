package fi.multisilta.rahapossu.config;

import fi.multisilta.rahapossu.model.portfolio.Asset;
import fi.multisilta.rahapossu.model.portfolio.Portfolio;
import fi.multisilta.rahapossu.model.portfolio.ValueAtMoment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Configure Spring Data REST.
 */
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config) {
        config.exposeIdsFor(Portfolio.class, Asset.class, ValueAtMoment.class);
    }
}
