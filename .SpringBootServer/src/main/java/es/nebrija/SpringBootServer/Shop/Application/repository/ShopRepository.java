package es.nebrija.SpringBootServer.Shop.Application.repository;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository {

    void save(Shop shop);

    boolean existsByName(String name);

    Shop findByName(String name);

    List<Shop> findAll();

}
