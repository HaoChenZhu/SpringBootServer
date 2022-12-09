package es.nebrija.SpringBootServer.Category.Infrastructure.mapper;

import es.nebrija.SpringBootServer.Category.Domain.Category;
import es.nebrija.SpringBootServer.Category.Infrastructure.dto.PostCategoryRequestDto;
import es.nebrija.SpringBootServer.Category.Infrastructure.dto.ResponseCategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    ResponseCategoryDto toDto(Category category);

    List<ResponseCategoryDto> toDto(List<Category> list);

    Category toEntity(PostCategoryRequestDto postCategoryRequestDto);
}
