package com.paypal.ecommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.ecommerce.model.SKU;
import com.paypal.ecommerce.service.CatalogService;

/**
 * 
 * A simple rest controller handling all APIs for CRUD operations on the entity {@link SKU}
 * 
 * @author Revanth
 *
 */
@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	@GetMapping(value = "/all")
	public List<SKU> getAllSku() {
		return catalogService.getAllSku();
	}
	
	@GetMapping(value = "/{id}") 
	public SKU getSkuById(@PathVariable("id") Long id){
		return catalogService.getSkuById(id);
	}
	
	@PostMapping(value = "/create")
	public SKU createSku(@RequestBody SKU sku) {
		return catalogService.createSku(sku);
		
	}
	
	@PostMapping(value = "/update")
	public String updateSku(@RequestBody SKU sku) {
		return catalogService.updateSku(sku);
	}
	
	@PostMapping(value = "/delete")
	public String deleteSku(@RequestBody SKU sku) {
		return catalogService.deleteSku(sku);
	}
	
	@GetMapping(value = "/search/keyword/{keyword}")
	public List<SKU> searchByTitleAndDescription(@PathVariable("keyword") String keyword) {
		return catalogService.searchByTitleAndDescription(keyword);
	}
	
	@GetMapping(value = "/search/price")
	public List<SKU> searchByPriceGreaterThan(@RequestParam("gt") BigDecimal greaterThan, @RequestParam("lt") BigDecimal lessThan) {
		return catalogService.searchByPriceGreaterThanAndLessThan(greaterThan, lessThan);
	}

}
