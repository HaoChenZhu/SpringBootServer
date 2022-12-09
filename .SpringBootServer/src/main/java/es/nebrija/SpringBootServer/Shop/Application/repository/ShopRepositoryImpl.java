package es.nebrija.SpringBootServer.Shop.Application.repository;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dao.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopRepositoryImpl implements ShopRepository {

    @Autowired
    ShopDao shopDao;

    @Override
    public void save(Shop shop) {
            shopDao.save(shop);
    }

    @Override
    public void update(Shop shop) {
        shopDao.save(shop);
    }

    @Override
    public boolean existsByName(String name) {
        return shopDao.existsShopByName(name);
    }

    @Override
    public Shop findShopByName(String name) {
        return shopDao.findByName(name);
    }


    @Override
    public List<Shop> findAll() {
        return shopDao.findAll();
    }

    @Override
    public void delete(String name) {
        shopDao.deleteByName(name);
    }


}
