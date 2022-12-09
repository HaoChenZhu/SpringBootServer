package es.nebrija.SpringBootServer.Product.Application.repository;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    void save(Product product);

    void update(Product product);

    boolean existsByName(String name);

    boolean existsByIdentifier(String identifier);

    Product findProductByName(String name);

    Product findProductByIdentifier(String identifier);

    List<Product> findAll();

    void delete(String identifier);

}
