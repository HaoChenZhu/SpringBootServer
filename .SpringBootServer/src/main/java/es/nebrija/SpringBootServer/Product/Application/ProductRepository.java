package es.nebrija.SpringBootServer.Product.Application;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

}


