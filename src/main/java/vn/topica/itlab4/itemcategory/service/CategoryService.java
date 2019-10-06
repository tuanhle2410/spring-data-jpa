package vn.topica.itlab4.itemcategory.service;

import org.springframework.stereotype.Service;
import vn.topica.itlab4.itemcategory.model.Category;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findByType(String typeName, int pageIndex, int pageSize);
}
