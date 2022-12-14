package online.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

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
    
    public List<String> getAllSupportedCategories(){
		return null;}
}
