package vn.topica.itlab4.itemcategory.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.itlab4.itemcategory.model.Type;

public interface TypeRepository extends PagingAndSortingRepository<Type, Integer> {
    Type findTypeById(int id);
}
