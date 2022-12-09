package es.nebrija.SpringBootServer.Category.Domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Category {
  @Id
  private ObjectId identifier;
  private String name;
  private String category_detail;


}
