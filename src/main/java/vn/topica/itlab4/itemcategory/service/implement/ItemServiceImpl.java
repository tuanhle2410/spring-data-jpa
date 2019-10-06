package vn.topica.itlab4.itemcategory.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.topica.itlab4.itemcategory.model.Item;
import vn.topica.itlab4.itemcategory.repository.ItemRepository;
import vn.topica.itlab4.itemcategory.service.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public Item getById(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public List<Item> findByCategory(String categoryName, int pageIndex, int pageSize) {
        return itemRepository.findByCategory(categoryName, new PageRequest(pageIndex,pageSize)).getContent();
    }
}
