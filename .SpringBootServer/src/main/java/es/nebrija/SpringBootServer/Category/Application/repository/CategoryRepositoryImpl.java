package es.nebrija.SpringBootServer.Category.Application.repository;

import es.nebrija.SpringBootServer.Category.Domain.Category;
import es.nebrija.SpringBootServer.Category.Infrastructure.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.save(category);
    }

    @Override
    public boolean existsByName(String name) {
        return categoryDao.existsByName(name);
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public void delete(String name) {
        categoryDao.deleteByName(name);
    }
}
