package fi.multisilta.rahapossu.repo;

import fi.multisilta.rahapossu.model.portfolio.Portfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {

}
