package com.paypal.ecommerce.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.paypal.ecommerce.model.SKU;

@Component
public interface CatalogRepository extends CrudRepository<SKU, Long> {
	
	SKU findBySkuId(String skuId);

	@Query("from SKU where lower(description) LIKE CONCAT('%',:keyword,'%') OR lower(title) LIKE CONCAT('%',:keyword,'%')")
	List<SKU> searchByTitleOrDescriptionLike(String keyword);
	
	@Query("from SKU where price > :greaterThan AND price < :lessThan")
	List<SKU> searchByPriceGreaterThanAndLessThan(BigDecimal greaterThan, BigDecimal lessThan);

}
