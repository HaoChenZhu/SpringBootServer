package es.nebrija.SpringBootServer.Shop.Infrastructure.dao;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopDao extends MongoRepository<Shop,String> {
  Shop findByName(String name);
  Shop findByNameOrTelephone(String name,String telephone);
  Boolean existsShopByName(String name);



}
