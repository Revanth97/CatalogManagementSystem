package com.paypal.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

/**
 * 
 * An Entity holding basic information of a product in ecommerce.
 * 
 * @author Revanth
 *
 */
@Entity
public class SKU {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "SKU_ID")
	@NotNull
	private String skuId;
	
	@NotNull
	private String title;
	
	@NotNull
	private String description;
	
	@NotNull
	private Long quantity;

	@Column(precision = 14, scale = 3)
	@NotNull
	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
