package es.nebrija.SpringBootServer.Product.Infrastructure.mapper;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import es.nebrija.SpringBootServer.Product.Infrastructure.dao.ProductDao;
import es.nebrija.SpringBootServer.Product.Infrastructure.dto.PostProductRequestDto;
import es.nebrija.SpringBootServer.Product.Infrastructure.dto.ResponseProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(PostProductRequestDto postProductRequestDto);

    Product toEntity(ResponseProductDto responseProductDto);
    ResponseProductDto toDto(Product product);

    List<ResponseProductDto> fromEntitiesToDto(List<Product> products);
}
