package es.nebrija.SpringBootServer.Category.Infrastructure.controller;

import es.nebrija.SpringBootServer.Category.Application.service.CategoryService;
import es.nebrija.SpringBootServer.Category.Infrastructure.dto.PostCategoryRequestDto;
import es.nebrija.SpringBootServer.Category.Infrastructure.dto.ResponseCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/server/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryServiceImpl;

    @PostMapping
    public void addCategory(@RequestBody PostCategoryRequestDto category) {
        categoryServiceImpl.addCategory(category);
    }

    @GetMapping
    public ResponseEntity<List<ResponseCategoryDto>> getCategories() {

        return new ResponseEntity<>(categoryServiceImpl.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ResponseCategoryDto> getCategoryByName(@PathVariable String name) {

        return new ResponseEntity<>(categoryServiceImpl.getCategoryByName(name), HttpStatus.OK);
    }

    @PutMapping
    public void updateCategory(@RequestBody PostCategoryRequestDto postCategoryRequestDto) {
        categoryServiceImpl.updateCategory(postCategoryRequestDto);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteCategory(@PathVariable String name) {
        categoryServiceImpl.deleteCategory(name);
    }

}
