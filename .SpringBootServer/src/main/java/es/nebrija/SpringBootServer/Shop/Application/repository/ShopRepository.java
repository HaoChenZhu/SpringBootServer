package es.nebrija.SpringBootServer.Shop.Application.repository;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository {

    void save(Shop shop);

    void update(Shop shop);

    boolean existsByName(String name);

    Shop findShopByName(String name);

    List<Shop> findAll();

    void delete(String name);


}
