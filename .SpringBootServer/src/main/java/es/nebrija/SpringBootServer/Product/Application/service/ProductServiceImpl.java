package es.nebrija.SpringBootServer.Product.Application.service;

import es.nebrija.SpringBootServer.Product.Application.repository.ProductRepository;
import es.nebrija.SpringBootServer.Product.Domain.Product;
import es.nebrija.SpringBootServer.Product.Infrastructure.dao.ProductDao;
import es.nebrija.SpringBootServer.Product.Infrastructure.dto.PostProductRequestDto;
import es.nebrija.SpringBootServer.Product.Infrastructure.dto.ResponseProductDto;
import es.nebrija.SpringBootServer.Product.Infrastructure.mapper.ProductMapper;
import es.nebrija.SpringBootServer.exceptions.NotValuesException;
import es.nebrija.SpringBootServer.exceptions.ProductAlreadyExistsException;
import es.nebrija.SpringBootServer.exceptions.ProductNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;
    @Override
    public void updateProduct(String product_id, PostProductRequestDto postProductRequestDto) throws ProductNotFoundException {
        boolean existProduct = productRepository.existsByIdentifier(product_id);

        if (existProduct) {
            Product product = productRepository.findProductByIdentifier(product_id);
            product.setProductDescription(postProductRequestDto.getProductDescription());
            product.setProductCategory(postProductRequestDto.getProductCategory());
            product.setProductDetail(postProductRequestDto.getProductDetail());
            product.setProductImg(postProductRequestDto.getProductImg());
            product.setProductName(postProductRequestDto.getProductName());
            product.setPrice(postProductRequestDto.getPrice());

            productRepository.update(product);
        } else {
            throw new ProductNotFoundException(product_id);
        }
    }

    @Override
    public ResponseProductDto getProductByName(String name) throws ProductNotFoundException{
        if (!productRepository.existsByName(name)) throw new ProductNotFoundException(name);

        Product product = productRepository.findProductByName(name);
        return productMapper.toDto(product);
    }

    @Override
    public ResponseProductDto getProductById(String identifier) throws ProductNotFoundException {
        if (!productRepository.existsByIdentifier(identifier)) throw new ProductNotFoundException(identifier);
        Product product = productRepository.findProductByIdentifier(identifier);
        return productMapper.toDto(product);
    }

    @Override
    public List<ResponseProductDto> getAllProducts() throws NotValuesException {
        if(productRepository.findAll().size()<=0) throw new NotValuesException();
        return productMapper.fromEntitiesToDto(productRepository.findAll());
    }

    @Override
    public void addProduct(PostProductRequestDto postProductRequestDto) throws ProductAlreadyExistsException {
        if (productRepository.existsByName(postProductRequestDto.getProductName())) throw new ProductAlreadyExistsException(postProductRequestDto.getProductName());
        productRepository.save(productMapper.toEntity(postProductRequestDto));
    }

    @Override
    public void deleteProduct(String identifier) throws ProductNotFoundException{
        if (!productRepository.existsByIdentifier(identifier)) throw new ProductNotFoundException(identifier);
        productRepository.delete(identifier);

    }
}
