package com.paypal.ecommerce.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paypal.ecommerce.model.SKU;
import com.paypal.ecommerce.repository.CatalogRepository;

@Component
public class CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;

	public List<SKU> getAllSku() {
		return (List<SKU>) catalogRepository.findAll();
	}

	public SKU getSkuById(Long id) {
		Optional<SKU> sku = catalogRepository.findById(id);
		return sku.isPresent() ? sku.get() : null;
	}

	public SKU createSku(SKU sku) {
		return catalogRepository.save(sku);
	}

	public String updateSku(SKU sku) {
		boolean exists = catalogRepository.findById(sku.getId()).isPresent();
		if(exists) {
			catalogRepository.save(sku);
			return "Updated the given catalog succcessfully";
		}
		else {
			return "Catalog doesn't exist, unable to update.";
		}
	}

	public String deleteSku(SKU sku) {
		boolean exists = catalogRepository.findById(sku.getId()).isPresent();
		if(exists) {
			catalogRepository.delete(sku);
			return "Catalog entry deleted successfully.";
		}
		else {
			return "Unable to delete catalog entry since entry doesn't exist.";
		}
	}

	public List<SKU> searchByTitleAndDescription(String keyword) {
		return catalogRepository.searchByTitleOrDescriptionLike(keyword);
	}

	public List<SKU> searchByPriceGreaterThan(BigDecimal price) {
		return catalogRepository.searchByPriceGreaterThan(price);
	}

}
