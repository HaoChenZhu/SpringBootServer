package es.nebrija.SpringBootServer.Product.Application.repository;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import es.nebrija.SpringBootServer.Product.Infrastructure.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    ProductDao productDao;


    @Override
    public void save(Product product) {
        if (!productDao.existsProductByProductName(product.getProductName())) ;
        productDao.save(product);
    }

    @Override
    public void update(Product product) {
        productDao.save(product);
    }

    @Override
    public boolean existsByName(String name) {

        return productDao.existsProductByProductName(name);
    }

    @Override
    public boolean existsByIdentifier(String identifier) {
        return productDao.existsProductByProductId(identifier);
    }

    @Override
    public Product findProductByName(String name) {
        return productDao.findProductByProductName(name);
    }

    @Override
    public Product findProductByIdentifier(String identifier) {
        return productDao.findProductByProductId(identifier);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void delete(String identifier) {
        productDao.deleteByProductId(identifier);
    }
}
