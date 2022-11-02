package es.nebrija.SpringBootServer.Shop.Application;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends MongoRepository<Shop,String> {
  Shop findByName(String name);
  Shop findByNameOrTelephone(String name,String telephone);
}
