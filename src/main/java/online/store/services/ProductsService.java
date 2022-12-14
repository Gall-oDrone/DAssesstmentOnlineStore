package online.store.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import online.store.model.Product;
import online.store.repositories.ProductCategoryRepository;
import online.store.repositories.ProductRepository;

/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * Integrates with the database API and handles products and categories business logic
 */
@Service
public class ProductsService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductsService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }
    
    // Returns all available categories listed in the database
    public List<String> getAllSupportedCategories() {
        return productCategoryRepository.findAll()
                .stream()
                .map(productCategory -> productCategory.getCategory())
                .collect(Collectors.toList());
    }
    
    // Returns at most n products from the Products table
    public List<Product> getDealsOfTheDay(int atMostNumberOfProducts){
    	return productRepository.findAtMostNumberOfProducts(atMostNumberOfProducts);
    }
    
    public List<Product> getProductsByCategory(String productCategory) {
        return productRepository.findByCategory(productCategory);
    }
}
