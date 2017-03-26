package com.fabiorapanelo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchableItem {

	private String id;

	private String name;

	private List<String> chracteristics;

	private List<String> categories;

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
