package es.nebrija.SpringBootServer.Category.Application.service;

import es.nebrija.SpringBootServer.Category.Infrastructure.dto.PostCategoryRequestDto;
import es.nebrija.SpringBootServer.Category.Infrastructure.dto.ResponseCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    ResponseCategoryDto getCategoryByName(String name);

    List<ResponseCategoryDto> getAllCategory();

    void addCategory(PostCategoryRequestDto postCategoryRequestDto);

    void deleteCategory(String name);

    void updateCategory(PostCategoryRequestDto postCategoryRequestDto);


}
