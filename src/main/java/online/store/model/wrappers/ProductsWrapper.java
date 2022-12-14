package online.store.model.wrappers;

import java.util.Collections;
import java.util.List;

import online.store.model.Product;

public class ProductsWrapper {

	private List<Product> products = Collections.EMPTY_LIST;

	// Fields Constructor
	public ProductsWrapper(List<Product> products) {
		//super();
		this.products = Collections.unmodifiableList(products);
	}

	// Getters
	public List<Product> getProducts() {
		return products;
	}
	
	
}
