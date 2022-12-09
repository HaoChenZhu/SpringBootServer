package es.nebrija.SpringBootServer.Category.Infrastructure.dao;

import es.nebrija.SpringBootServer.Category.Domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryDao extends MongoRepository<Category,String> {
  Category findByName(String name);

  Boolean existsByName(String name);

  void deleteByName(String name);
}
