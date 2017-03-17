package com.fabiorapanelo.catalog;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	public List<Category> findByParentCategoryIsNull(Pageable pageable);

}
