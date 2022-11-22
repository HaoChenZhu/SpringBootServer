package es.nebrija.SpringBootServer.Shop.Application.repository;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dao.ShopDao;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopRepositoryImpl implements  ShopRepository{

    @Autowired
    ShopDao shopDao;

    @Override
    public void save(Shop shop) {
        if(!shopDao.existsShopByName(shop.getName())){
            shopDao.save(shop);
        }else {
            throw new RuntimeException("Shop already exists");
        }
    }

    @Override
    public boolean existsByName(String name) {
        return shopDao.existsShopByName(name);
    }

    @Override
    public Shop findByName(String name) {
       return shopDao.findByName(name);
    }

    @Override
    public List<Shop> findAll() {
        return shopDao.findAll();
    }


}
