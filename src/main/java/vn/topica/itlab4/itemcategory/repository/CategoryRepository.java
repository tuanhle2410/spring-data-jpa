package vn.topica.itlab4.itemcategory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.itlab4.itemcategory.model.Category;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    Page<Category> findByType(String typeName, Pageable pageable);

    @Query("SELECT obj FROM category obj, type " +
            "WHERE category.type_id = type.id " +
            "AND type.name = :typeName")
    List<Category> findByType(@Param("typeName") String typeName);
}
