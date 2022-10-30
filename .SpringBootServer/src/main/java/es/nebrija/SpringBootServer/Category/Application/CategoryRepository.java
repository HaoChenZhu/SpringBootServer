package es.nebrija.SpringBootServer.Category.Application;

import es.nebrija.SpringBootServer.Category.Domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category,String> {
  Optional<Category> findByName(String name);
}
