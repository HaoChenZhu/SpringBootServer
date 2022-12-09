package es.nebrija.SpringBootServer.Product.Infrastructure.dao;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends MongoRepository<Product, String> {

    Boolean existsProductByProductName(String product_name);

    Boolean existsProductByProductId(String productId);

    Product findProductByProductName(String product_name);

    Product findProductByProductId(String productId);

    void deleteByProductId(String productId);
}


