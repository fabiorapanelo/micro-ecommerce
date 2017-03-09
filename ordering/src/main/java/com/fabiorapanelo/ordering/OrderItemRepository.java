package com.fabiorapanelo.ordering;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
