package es.nebrija.SpringBootServer.Category.Infrastructure.dto;

import lombok.Data;

@Data
public class PostCategoryRequestDto {

    private String name;
    private String category_detail;
}
