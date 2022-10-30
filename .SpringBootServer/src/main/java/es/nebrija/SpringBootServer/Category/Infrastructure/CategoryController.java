package es.nebrija.SpringBootServer.Category.Infrastructure;

import es.nebrija.SpringBootServer.Category.Application.CategoryRepository;
import es.nebrija.SpringBootServer.Category.Application.CategoryService;
import es.nebrija.SpringBootServer.Category.Domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server/category")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping
  public void addCategory(@RequestBody Category category){
    categoryService.addCategory(category);
  }

  @GetMapping
  public List<Category> getCategories(){
    return categoryService.getCategories();
  }

}
