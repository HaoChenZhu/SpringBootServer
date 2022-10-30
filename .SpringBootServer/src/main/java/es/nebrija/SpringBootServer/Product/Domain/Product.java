package es.nebrija.SpringBootServer.Product.Domain;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.lang.reflect.Array;

@Data
@Document(value = "product")
public class Product {
  @Id
  @Field(targetType = FieldType.OBJECT_ID)
  private String product_id;
  private String product_name;
  private String product_description;
  private String product_detail;
  private double price;
  private String[] product_category;
  private String product_img;

}
