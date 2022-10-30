package es.nebrija.SpringBootServer.Category.Application;

import es.nebrija.SpringBootServer.Category.Domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public void addCategory(Category category){
    categoryRepository.save(category);
  }
  public void getCategoryByName(String name){
    categoryRepository.findByName(name);
  }

  public List<Category> getCategories(){
    return categoryRepository.findAll();
  }
}
