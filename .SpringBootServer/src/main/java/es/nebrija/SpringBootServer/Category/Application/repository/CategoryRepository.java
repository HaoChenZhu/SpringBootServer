package es.nebrija.SpringBootServer.Category.Application.repository;

import es.nebrija.SpringBootServer.Category.Domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    void save(Category category);

    void update(Category category);

    boolean existsByName(String name);

    Category findCategoryByName(String name);

    List<Category> findAll();

    void delete(String name);
}
