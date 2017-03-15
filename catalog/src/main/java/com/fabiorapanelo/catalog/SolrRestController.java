package com.fabiorapanelo.catalog;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolrRestController {

	private SearchableItemRepository searchableItemRepository;
	private CatalogItemRepository catalogItemRepository;
	private CategoryRepository categoryRepository;
	
	

	public SolrRestController(SearchableItemRepository searchableCatalogItemRepository,
			CatalogItemRepository catalogItemRepository,
			CategoryRepository categoryRepository) {
		this.searchableItemRepository = searchableCatalogItemRepository;
		this.catalogItemRepository = catalogItemRepository;
		this.categoryRepository = categoryRepository;
	}

	@PutMapping("/solr/reindex")
	public void reindexSolr() {
		searchableItemRepository.deleteAll();

		Iterable<CatalogItem> catalogItems = catalogItemRepository.findAll();

		for (CatalogItem catalogItem : catalogItems) {

			SearchableItem sci = SolrUtils.convertCatalogItem2SearchableItem(catalogItem);
			searchableItemRepository.save(sci);
		}
		
		Iterable<Category> categories = categoryRepository.findAll();
		
		for(Category category: categories){
			
			SearchableItem sci = SolrUtils.convertCategory2SearchableItem(category);
			searchableItemRepository.save(sci);
		}
	}

}
