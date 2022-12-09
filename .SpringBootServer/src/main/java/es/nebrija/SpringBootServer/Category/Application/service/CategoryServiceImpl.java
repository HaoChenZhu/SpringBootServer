package es.nebrija.SpringBootServer.Category.Application.service;

import es.nebrija.SpringBootServer.Category.Application.repository.CategoryRepository;
import es.nebrija.SpringBootServer.Category.Domain.Category;
import es.nebrija.SpringBootServer.Category.Infrastructure.dto.PostCategoryRequestDto;
import es.nebrija.SpringBootServer.Category.Infrastructure.dto.ResponseCategoryDto;
import es.nebrija.SpringBootServer.Category.Infrastructure.mapper.CategoryMapper;
import es.nebrija.SpringBootServer.exceptions.CategoryAlreadyExistsException;
import es.nebrija.SpringBootServer.exceptions.CategoryNotFoundException;
import es.nebrija.SpringBootServer.exceptions.NotValuesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResponseCategoryDto getCategoryByName(String name) throws CategoryNotFoundException {
        if(!categoryRepository.existsByName(name)) throw new CategoryNotFoundException(name);
        Category category= categoryRepository.findCategoryByName(name);
        return categoryMapper.toDto(category);
    }

    @Override
    public List<ResponseCategoryDto> getAllCategory() throws NotValuesException {
        if(categoryRepository.findAll().size() <= 0) throw new NotValuesException();
        List<Category> list= categoryRepository.findAll();
        return categoryMapper.toDto(list);
    }

    @Override
    public void addCategory(PostCategoryRequestDto postCategoryRequestDto)throws CategoryAlreadyExistsException {
        if(categoryRepository.existsByName(postCategoryRequestDto.getName())) throw  new CategoryAlreadyExistsException(postCategoryRequestDto.getName());
        categoryRepository.save(categoryMapper.toEntity(postCategoryRequestDto));
    }

    @Override
    public void deleteCategory(String name) throws  CategoryNotFoundException{
        if(!categoryRepository.existsByName(name)) throw new CategoryNotFoundException(name);
        categoryRepository.delete(name);
    }

    @Override
    public void updateCategory(PostCategoryRequestDto postCategoryRequestDto)throws  CategoryNotFoundException {
        if(!categoryRepository.existsByName(postCategoryRequestDto.getName())) throw  new CategoryAlreadyExistsException(postCategoryRequestDto.getName());
        Category category=categoryRepository.findCategoryByName(postCategoryRequestDto.getName());
        category.setName(postCategoryRequestDto.getName());
        category.setCategory_detail(postCategoryRequestDto.getCategory_detail());


        categoryRepository.update(category);
    }
}
