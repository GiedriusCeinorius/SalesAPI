package com.gce.salesapi.repository;

import com.gce.salesapi.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ItemRepository extends MongoRepository<Item, String> {


    @RestResource(rel = "searchItemByTitle")
    Page<Item> findItemByTitle(@Param("title") String title, Pageable pageable);

    @RestResource(rel = "searchItemsByPriceRange")
    List<Item> findItemsByPriceBetween(@Param("from") Double from, @Param("to") Double to);


}
