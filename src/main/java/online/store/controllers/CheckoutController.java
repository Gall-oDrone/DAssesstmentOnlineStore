package online.store.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import online.store.model.CheckoutRequest;
import online.store.model.Order;
import online.store.services.OrdersService;
import online.store.services.ProductsService;

@RestController
public class CheckoutController {

	private final OrdersService ordersService;
	private final ProductsService productsService;
	
	public CheckoutController(OrdersService ordersService, ProductsService productsService) {
		super();
		this.ordersService = ordersService;
		this.productsService = productsService;
	}
	
	@PostMapping("/checkout")
	public String checkout(@RequestBody CheckoutRequest checkoutRequest) {
		Set<Order> orders = new HashSet<>(checkoutRequest.getProducts().size());
		
		for (CheckoutRequest.ProductInfo productInfo : checkoutRequest.getProducts()) {
			Order order = new Order(checkoutRequest.getFirstName(),
					checkoutRequest.getLastName(),
					checkoutRequest.getEmail(),
					checkoutRequest.getShippingAddress(),
					productInfo.getQuantity(),
					productsService.getProductById(productInfo.getProductId()),
					checkoutRequest.getCreditCard());
			orders.add(order);
		}
		ordersService.placeOrders(orders);
		return "success";
	}
	
	
}
