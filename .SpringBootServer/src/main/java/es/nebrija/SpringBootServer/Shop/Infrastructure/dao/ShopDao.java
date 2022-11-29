package es.nebrija.SpringBootServer.Shop.Infrastructure.dao;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShopDao extends MongoRepository<Shop, String> {
    Shop findByName(String name);

    Boolean existsShopByName(String name);

    void deleteByName(String name);

}
