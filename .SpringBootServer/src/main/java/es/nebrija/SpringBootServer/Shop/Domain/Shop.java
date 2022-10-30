package es.nebrija.SpringBootServer.Shop.Domain;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "shop")
public class Shop {
    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String identifier;
    private String name;
    private String telephone;
    private Location location = new Location();
    private String shop_img;
    private List<Product> productList= new ArrayList<Product>();


}
