package vn.topica.itlab4.itemcategory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.topica.itlab4.itemcategory.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {


    @Query("SELECT obj FROM Category obj, Type t " +
            "WHERE obj.typeId = t.id " +
            "AND t.name = :typeName")
    Page<Category> findByType(@Param("typeName") String typeName, Pageable pageable);
}
