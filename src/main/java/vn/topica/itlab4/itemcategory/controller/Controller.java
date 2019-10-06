package vn.topica.itlab4.itemcategory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.topica.itlab4.itemcategory.model.Category;
import vn.topica.itlab4.itemcategory.model.Item;
import vn.topica.itlab4.itemcategory.service.CategoryService;
import vn.topica.itlab4.itemcategory.service.implement.CategoryServiceImpl;
import vn.topica.itlab4.itemcategory.service.implement.ItemServiceImpl;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    ItemServiceImpl itemService;
    @Autowired
    CategoryServiceImpl categoryService;

    @RequestMapping(value = "/item-filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> findItemByCategory(@RequestParam(name = "category_name") String categoryName){
        return itemService.findByCategory(categoryName,0,10);
    }

    @RequestMapping(value = "/category-filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> findCategoryByType(@RequestParam(name = "type_name") String typeName){
        return categoryService.findByType(typeName,0,10);
    }
    
    @RequestMapping(value = "/category-update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpStatus updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}
