package vn.topica.itlab4.itemcategory.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.itlab4.itemcategory.model.ItemCategory;

public interface ItemCategoryRepository extends PagingAndSortingRepository<ItemCategory, Integer> {
    ItemCategory findByItemId(int itemId);

    ItemCategory findByCategoryId(int categoryId);
}
