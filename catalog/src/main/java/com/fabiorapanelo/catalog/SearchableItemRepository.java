package com.fabiorapanelo.catalog;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

@RepositoryRestResource
public interface SearchableItemRepository extends SolrCrudRepository<SearchableItem, String> {

	@Query("name_t:?0")
	List<SearchableItem> findByName(@Param("name") String name, Pageable pageable);

}
