package com.fabiorapanelo.catalog;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.solr.repository.SolrCrudRepository;

@RepositoryRestResource
public interface SearchableCatalogItemRepository extends SolrCrudRepository<SearchableCatalogItem, String> {

	List<SearchableCatalogItem> findByNameStartingWith(@Param("name") String name);

}
