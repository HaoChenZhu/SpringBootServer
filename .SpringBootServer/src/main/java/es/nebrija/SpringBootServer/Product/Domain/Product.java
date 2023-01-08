package es.nebrija.SpringBootServer.Product.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {
    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private String productDetail;
    private double price;
    private String[] productCategory;
    private String productImg;
}
