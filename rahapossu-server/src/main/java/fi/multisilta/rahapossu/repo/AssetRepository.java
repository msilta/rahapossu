package fi.multisilta.rahapossu.repo;

import fi.multisilta.rahapossu.model.portfolio.Asset;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AssetRepository extends PagingAndSortingRepository<Asset, Long> {

}
