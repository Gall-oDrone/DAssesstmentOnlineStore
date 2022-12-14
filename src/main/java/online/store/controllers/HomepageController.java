package online.store.controllers;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import online.store.services.ProductsService;

@RestController
public class HomepageController {
	
	private final ProductsService productService;
	
	public HomepageController(ProductsService productService) {
		this.productService = productService;
	}
	
	// Loads the cateogory names from the ProductService and formats it as a comma-separated string
	@GetMapping("/categories")
	public String getProductCategories() {
		return productService.getAllSupportedCategories()
				.stream()
				.collect(Collectors.joining(","));
	}
}
