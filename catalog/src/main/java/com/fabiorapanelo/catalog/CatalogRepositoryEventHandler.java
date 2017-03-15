package com.fabiorapanelo.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CatalogRepositoryEventHandler {

	private SearchableItemRepository searchableItemRepository;

	@Autowired
	public CatalogRepositoryEventHandler(SearchableItemRepository searchableItemRepository) {
		this.searchableItemRepository = searchableItemRepository;
	}

	@HandleAfterCreate(Category.class)
	public void handleCategoryCreate(Category category) {
		
		SearchableItem searchableItem = SolrUtils.convertCategory2SearchableItem(category);
		searchableItemRepository.save(searchableItem);

	}
	
	@HandleAfterCreate(CatalogItem.class)
	public void handleCatalogItemCreate(CatalogItem catalogItem) {
		
		SearchableItem searchableItem = SolrUtils.convertCatalogItem2SearchableItem(catalogItem);
		searchableItemRepository.save(searchableItem);

	}

}
