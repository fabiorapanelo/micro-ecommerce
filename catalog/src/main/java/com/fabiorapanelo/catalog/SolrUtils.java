package com.fabiorapanelo.catalog;

import java.util.ArrayList;
import java.util.HashSet;
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
		
		List<Category> subCategories = category.getSubCategories();
		if(subCategories != null){
			Set<String> categories = category.getSubCategories()
					.stream()
					.map(c -> c.getName())
					.collect(Collectors.toSet());
			
			sci.setCategories(new ArrayList<String>(categories));
		}
		
		sci.setType(SEARCHABLE_ITEM_CATEGORY);
		return sci;
	}

	public static SearchableItem convertCatalogItem2SearchableItem(CatalogItem catalogItem) {
		SearchableItem sci = new SearchableItem();
		
		sci.setId(catalogItem.getId().toString() + "-" + SEARCHABLE_ITEM_CATALOG);
		sci.setName(catalogItem.getName());
		
		List<Chracteristic> chracteristics = catalogItem.getChracteristics();
		
		if(chracteristics != null){
			List<String> chracteristicList = chracteristics.stream().map(c -> c.getValue()).collect(Collectors.toList());
			sci.setChracteristics(chracteristicList);
		}
		
		List<Category> categories = catalogItem.getCategories();
		Set<String> categoryList = new HashSet<>();
		
		if(categories != null){
			categoryList = categories.stream().map(c -> c.getName()).collect(Collectors.toSet());	
		}
		
		Category mainCategory = (Category) catalogItem.getMainCategory();
		if(mainCategory != null){
			categoryList.add(mainCategory.getName());
		}
		
		sci.setCategories(new ArrayList<String>(categoryList));		
		
		sci.setType(SEARCHABLE_ITEM_CATALOG);
		return sci;
	}

}
