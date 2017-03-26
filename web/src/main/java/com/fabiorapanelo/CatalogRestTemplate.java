package com.fabiorapanelo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

import com.fabiorapanelo.model.Category;
import com.fabiorapanelo.model.SearchableItem;

@Component
public class CatalogRestTemplate {
	
	private String searchableItemFindByNameQuery;
	private String categoryFindByParentCategoryIsNullQuery;
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	public CatalogRestTemplate(@Value("${catalog.query.searchable-item.find-by-name}") String searchableItemFindByNameQuery,
			@Value("${catalog.query.category.find-by-parent-category-is-null}") String categoryFindByParentCategoryIsNullQuery){
		this.searchableItemFindByNameQuery = searchableItemFindByNameQuery;
		this.categoryFindByParentCategoryIsNullQuery = categoryFindByParentCategoryIsNullQuery;
	}
	
	public List<SearchableItem> searchableItemFindByName(String name){
		
		ServiceInstance instance = loadBalancer.choose("catalog");
		String url = String.format("%s%s%s", instance.getUri(), searchableItemFindByNameQuery, name);
		CustomizedRestTemplate template = new CustomizedRestTemplate();
		List<SearchableItem> searchableItems = null;
		try {
			searchableItems = template.getForList(url, SearchableItem.class, "_embedded/searchableItems");
		} catch (IOException e) {}
		
		return searchableItems;
	}
	
	public List<Category> categoryFindByParentCategoryIsNull(){
		
		ServiceInstance instance = loadBalancer.choose("catalog");
		String url = String.format("%s%s", instance.getUri(), categoryFindByParentCategoryIsNullQuery);
		
		CustomizedRestTemplate template = new CustomizedRestTemplate();
		List<Category> categories = null;
		try {
			categories = template.getForList(url, Category.class, "_embedded/categories");
		} catch (IOException e) {}
		
		return categories;
	}
	
	@Autowired(required=true)
	public void setLoadBalancer(LoadBalancerClient loadBalancer) {
		this.loadBalancer = loadBalancer;
	}
	

}
