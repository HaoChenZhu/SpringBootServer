package es.nebrija.SpringBootServer.Shop.Domain;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "shop")
public class Shop {
    @Id
    private ObjectId identifier;
    private String name;
    private String telephone;
    private Location location = new Location();
    private String shop_img;
    private List<Product> productList = new ArrayList<Product>();


}
