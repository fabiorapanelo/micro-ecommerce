package com.fabiorapanelo.catalog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BestDealRepository extends CrudRepository<BestDeal, Long> {

}
