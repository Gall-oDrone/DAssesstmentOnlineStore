package online.store.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import online.store.model.ProductCategory;

/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * This represents an API through which we can perform CRUD operations against the
 * ProductsCategories table in the database
 * You do not need to modify this file
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    /**
     * Returns all the available categories of products in our online store
     */
    List<ProductCategory> findAll();
    
    public List<String> getAllSupportedCategories() {
        return productCategoryRepository.findAll()
                .stream()
                .map(productCategory -> productCategory.getCategory())
                .collect(Collectors.toList());
    }
}
