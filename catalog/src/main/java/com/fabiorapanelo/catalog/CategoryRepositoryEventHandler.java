package com.fabiorapanelo.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CategoryRepositoryEventHandler {

	private SearchableItemRepository searchableItemRepository;

	@Autowired
	public CategoryRepositoryEventHandler(SearchableItemRepository searchableItemRepository) {
		this.searchableItemRepository = searchableItemRepository;
	}

	@HandleAfterCreate(Category.class)
	public void handleCategoryCreate(Category category) {

		SearchableItem searchableItem = SolrUtils.convertCategory2SearchableItem(category);
		searchableItemRepository.save(searchableItem);

	}

	@HandleAfterDelete(Category.class)
	public void handleCategoryDelete(Category category) {

		SearchableItem searchableItem = SolrUtils.convertCategory2SearchableItem(category);
		SearchableItem searchableItemFromSolr = searchableItemRepository.findOne(searchableItem.getId());
		if (searchableItemFromSolr != null) {
			searchableItemRepository.delete(searchableItem);
		}

	}

	@HandleAfterSave(Category.class)
	public void handleCategoryUpdate(Category category) {

		SearchableItem searchableItem = SolrUtils.convertCategory2SearchableItem(category);
		SearchableItem searchableItemFromSolr = searchableItemRepository.findOne(searchableItem.getId());

		if (searchableItemFromSolr != null) {
			searchableItemFromSolr.setName(searchableItem.getName());
			searchableItemRepository.save(searchableItemFromSolr);
		}

	}

}
