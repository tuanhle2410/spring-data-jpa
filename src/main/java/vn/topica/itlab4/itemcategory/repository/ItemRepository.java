package vn.topica.itlab4.itemcategory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.itlab4.itemcategory.model.Item;

import java.util.List;

public interface ItemRepository extends PagingAndSortingRepository<Item, Integer>, CrudRepository<Item, Integer> {

    @Query("SELECT obj FROM Item obj, ItemCategory ic, Category c " +
            "WHERE obj.id = ic.itemId " +
            "AND ic.categoryId = c.id " +
            "AND c.name = :categoryName")
    Page<Item> findAll(String categoryName, Pageable pageable);

    Item findById(Long id);
}
