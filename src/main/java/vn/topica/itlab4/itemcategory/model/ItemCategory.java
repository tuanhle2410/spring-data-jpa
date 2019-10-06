package vn.topica.itlab4.itemcategory.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@Table(name = "item_categoy")
public class ItemCategory {

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "category_id")
    private int categoryId;
}
