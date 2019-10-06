package vn.topica.itlab4.itemcategory.service;

import org.springframework.stereotype.Service;
import vn.topica.itlab4.itemcategory.model.Item;

import java.util.List;

@Service
public interface ItemService {
    List<Item> findByCategory(String categoryName, int pageIndex, int pageSize);
}
