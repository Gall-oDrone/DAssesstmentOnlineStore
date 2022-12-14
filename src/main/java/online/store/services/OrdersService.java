package online.store.services;

import org.springframework.stereotype.Service;

import online.store.model.Order;
import online.store.repositories.OrderRepository;

@Service
public class OrdersService {

	private final OrderRepository orderRepository;
	
	public OrdersService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public void placeOrders(Iterable<Order> orders) {
		orderRepository.saveAll(orders);
	}

	
}
