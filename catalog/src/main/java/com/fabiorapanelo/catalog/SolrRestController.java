package com.fabiorapanelo.catalog;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolrRestController {

	private SearchableCatalogItemRepository searchableCatalogItemRepository;
	private CatalogItemRepository catalogItemRepository;

	public SolrRestController(SearchableCatalogItemRepository searchableCatalogItemRepository,
			CatalogItemRepository catalogItemRepository) {
		this.searchableCatalogItemRepository = searchableCatalogItemRepository;
		this.catalogItemRepository = catalogItemRepository;
	}

	@PutMapping("/solr/reindex")
	public void reindexSolr() {
		searchableCatalogItemRepository.deleteAll();

		Iterable<CatalogItem> catalogItems = catalogItemRepository.findAll();

		for (CatalogItem catalogItem : catalogItems) {

			SearchableCatalogItem sci = new SearchableCatalogItem();
			sci.setId(catalogItem.getId().toString());
			sci.setName(catalogItem.getName());
			List<String> chracteristics = catalogItem.getChracteristics()
					.stream()
					.map(c -> c.getValue())
					.collect(Collectors.toList());
			sci.setChracteristics(chracteristics);

			List<String> categories = catalogItem.getCategories().
					stream()
					.map(c -> c.getName())
					.collect(Collectors.toList());

			categories.add(catalogItem.getMainCategory().getName());
			sci.setCategories(categories);
			searchableCatalogItemRepository.save(sci);
		}
	}

}
