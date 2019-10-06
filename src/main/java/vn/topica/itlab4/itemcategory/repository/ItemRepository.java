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
    Page<Item> findByCategory(String categoryName, Pageable pageable);

    @Query("SELECT obj FROM item obj, item_category, category " +
            "WHERE item.id = item_category.item_id " +
            "AND item_category.category_id = category.id " +
            "AND category.name = :categoryName")
    List<Item> findByCategory(@Param("categoryName") String categoryName);

    Item findOne(Long id);
}
