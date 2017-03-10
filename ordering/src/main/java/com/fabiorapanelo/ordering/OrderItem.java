package com.fabiorapanelo.ordering;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItem {

	private Long id;
	private String catalogItemId;
	private String catalogItemName;
	private BigDecimal price;
	private int quantity;
	private Order order;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	public String getCatalogItemId() {
		return catalogItemId;
	}

	public void setCatalogItemId(String catalogItemId) {
		this.catalogItemId = catalogItemId;
	}

	@NotNull
	public String getCatalogItemName() {
		return catalogItemName;
	}

	public void setCatalogItemName(String catalogItemName) {
		this.catalogItemName = catalogItemName;
	}

	@NotNull
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Min(value=1)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "order_id")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
