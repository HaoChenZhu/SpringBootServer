package es.nebrija.SpringBootServer.Product.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.lang.reflect.Array;

@Data
@Document
public class Product {
  @Id
  @Field(targetType = FieldType.OBJECT_ID)
  private String productId;
  private String productName;
  private String productDescription;
  private String productDetail;
  private double price;
  private String[] productCategory;
  private String productImg;

}
