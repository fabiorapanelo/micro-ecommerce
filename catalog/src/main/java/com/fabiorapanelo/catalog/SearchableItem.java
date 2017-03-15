package com.fabiorapanelo.catalog;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "item")
public class SearchableItem {

	@Id
	@Field
	private String id;

	@Field("name_t")
	private String name;

	@Field("chracteristics_ss")
	private List<String> chracteristics;

	@Field("categories_ss")
	private List<String> categories;

	@Field("type_s")
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SearchableItem [id=" + id + ", name=" + name + ", chracteristics=" + chracteristics
				+ ", categories=" + categories + ", type=" + type + "]";
	}

}
