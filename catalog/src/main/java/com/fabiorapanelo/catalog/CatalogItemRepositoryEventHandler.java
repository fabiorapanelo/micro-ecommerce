package com.fabiorapanelo.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CatalogItemRepositoryEventHandler {

	private SearchableItemRepository searchableItemRepository;

	@Autowired
	public CatalogItemRepositoryEventHandler(SearchableItemRepository searchableItemRepository) {
		this.searchableItemRepository = searchableItemRepository;
	}

	@HandleAfterCreate(CatalogItem.class)
	public void handleCatalogItemCreate(CatalogItem catalogItem) {

		SearchableItem searchableItem = SolrUtils.convertCatalogItem2SearchableItem(catalogItem);
		searchableItemRepository.save(searchableItem);

	}

	@HandleAfterDelete(CatalogItem.class)
	public void handleCatalogItemDelete(CatalogItem catalogItem) {

		SearchableItem searchableItem = SolrUtils.convertCatalogItem2SearchableItem(catalogItem);
		SearchableItem searchableItemFromSolr = searchableItemRepository.findOne(searchableItem.getId());
		if (searchableItemFromSolr != null) {
			searchableItemRepository.delete(searchableItem);
		}

	}

	@HandleAfterSave(CatalogItem.class)
	public void handleCatalogItemUpdate(CatalogItem catalogItem) {

		SearchableItem searchableItem = SolrUtils.convertCatalogItem2SearchableItem(catalogItem);
		SearchableItem searchableItemFromSolr = searchableItemRepository.findOne(searchableItem.getId());

		if (searchableItemFromSolr != null) {
			searchableItemFromSolr.setName(searchableItem.getName());
			searchableItemFromSolr.setCategories(searchableItem.getCategories());
			searchableItemFromSolr.setChracteristics(searchableItem.getChracteristics());

			searchableItemRepository.save(searchableItemFromSolr);
		}

	}

}
