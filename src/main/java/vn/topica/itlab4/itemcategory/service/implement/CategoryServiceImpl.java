package vn.topica.itlab4.itemcategory.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.topica.itlab4.itemcategory.model.Category;
import vn.topica.itlab4.itemcategory.repository.CategoryRepository;
import vn.topica.itlab4.itemcategory.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public boolean updateCategory(Category category) {
        return categoryRepository.save(category) != null;
    }

    @Override
    public List<Category> findByType(String typeName, int pageIndex, int pageSize) {
        return categoryRepository.findByType(typeName, PageRequest.of(pageIndex,pageSize)).getContent();
    }
}
