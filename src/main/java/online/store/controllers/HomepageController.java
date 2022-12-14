package online.store.controllers;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import online.store.model.wrappers.ProductsWrapper;
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
	
	@GetMapping("/deals_of_the_day/{number_of_products}")
	public ProductsWrapper getDealsOfTheDay(@PathVariable(name = "number_of_products") int numberOfProducts) {
		return new ProductsWrapper(productService.getDealsOfTheDay(numberOfProducts));
	}
	
	@GetMapping("/products")
    public ProductsWrapper getProductsForCategory(
            @RequestParam(name = "category") String category) {
            return new ProductsWrapper(productService.getProductsByCategory(category));
    }
}
