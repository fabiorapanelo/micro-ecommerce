package com.fabiorapanelo.catalog;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "catalog-item")
public class SearchableCatalogItem {

	@Id
	@Field
	private String id;

	@Field
	private String name;

	@Field("chracteristics")
	private List<String> chracteristics;

	@Field("categories")
	private List<String> categories;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getChracteristics() {
		return chracteristics;
	}

	public void setChracteristics(List<String> chracteristics) {
		this.chracteristics = chracteristics;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "SearchableCatalogItem [id=" + id + ", name=" + name + ", chracteristics=" + chracteristics
				+ ", categories=" + categories + "]";
	}

	
}
