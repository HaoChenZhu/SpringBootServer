package es.nebrija.SpringBootServer.Shop.Infrastructure.dto;

import es.nebrija.SpringBootServer.Product.Infrastructure.dto.ResponseProductDto;
import lombok.Data;

import java.util.List;

@Data
public class ResponseShopProductDto {
    private String name;
    private List<ResponseProductDto> list;
}
