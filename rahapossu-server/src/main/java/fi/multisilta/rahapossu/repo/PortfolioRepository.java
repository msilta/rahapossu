package fi.multisilta.rahapossu.repo;

import fi.multisilta.rahapossu.model.portfolio.Portfolio;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PortfolioRepository extends PagingAndSortingRepository<Portfolio, Long> {

}
