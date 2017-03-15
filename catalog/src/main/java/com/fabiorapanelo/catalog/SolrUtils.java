package com.fabiorapanelo.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SolrUtils {
	
	public static final String SEARCHABLE_ITEM_CATALOG="CATALOG_ITEM";
	public static final String SEARCHABLE_ITEM_CATEGORY="CATEGORY";
	
	public static SearchableItem convertCategory2SearchableItem(Category category) {
		SearchableItem sci = new SearchableItem();
		
		sci.setId(category.getId().toString() + "-" + SEARCHABLE_ITEM_CATEGORY);
		sci.setName(category.getName());
		sci.setType(SEARCHABLE_ITEM_CATEGORY);
		return sci;
	}

	public static SearchableItem convertCatalogItem2SearchableItem(CatalogItem catalogItem) {
		SearchableItem sci = new SearchableItem();
		
		sci.setId(catalogItem.getId().toString() + "-" + SEARCHABLE_ITEM_CATALOG);
		sci.setName(catalogItem.getName());
		
		//Chracteristics
		List<String> chracteristics = catalogItem.getChracteristics()
				.stream()
				.map(c -> c.getValue())
				.collect(Collectors.toList());
		sci.setChracteristics(chracteristics);
		
		//Categories
		Set<String> categories = catalogItem.getCategories().
				stream()
				.map(c -> c.getName())
				.collect(Collectors.toSet());

		categories.add(catalogItem.getMainCategory().getName());
		sci.setCategories(new ArrayList<String>(categories));
		
		sci.setType(SEARCHABLE_ITEM_CATALOG);
		return sci;
	}

}
