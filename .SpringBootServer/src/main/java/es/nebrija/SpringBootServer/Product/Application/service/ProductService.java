package es.nebrija.SpringBootServer.Product.Application.service;

import es.nebrija.SpringBootServer.Product.Infrastructure.dto.PostProductRequestDto;
import es.nebrija.SpringBootServer.Product.Infrastructure.dto.ResponseProductDto;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ResponseProductDto getProductByName(String name);
    ResponseProductDto getProductById(String identifier);

    void updateProduct(String product_id, PostProductRequestDto postProductRequestDto);
    List<ResponseProductDto> getAllProducts();

    void addProduct(PostProductRequestDto postProductRequestDto);

    void deleteProduct(String identifier);


}
