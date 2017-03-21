package com.fabiorapanelo.catalog;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatalogController {
	
	private CategoryRepository categoryRepository;
	private SearchableItemRepository searchableItemRepository; 
	
	@Autowired
	public CatalogController(CategoryRepository categoryRepository, SearchableItemRepository searchableItemRepository){
		this.categoryRepository = categoryRepository;
		this.searchableItemRepository = searchableItemRepository;
	}
	
	@GetMapping("/index.html")
	public String index(Model model, @RequestParam(name="query", required=false) String query){
		
		List<SearchableItem> items = null;
		if(StringUtils.isNotEmpty(query)){
			String solrQuery = this.createSolrQuery(query);
			items = searchableItemRepository.findByName(solrQuery, null);
		}
		model.addAttribute("items", items);
		
		List<Category> categories = categoryRepository.findByParentCategoryIsNull(null);
		model.addAttribute("categories", categories);
		model.addAttribute("query", query);
		
		return "index";
	}
	
	public String createSolrQuery(String query){
		String[] pieces = query.split(" ");
		StringBuilder sb = new StringBuilder();
		
		for(String piece: pieces){
			sb.append("*" + piece + "* ");
		}
		
		return sb.toString();
	}

}
