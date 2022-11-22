package es.nebrija.SpringBootServer.Product.Application.repository;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
  Product findProductByProductName(String product_name);
  Product findProductByProductId(String productId);
}


