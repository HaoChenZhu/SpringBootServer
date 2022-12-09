package es.nebrija.SpringBootServer.Product.Infrastructure.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ResponseProductDto {


    private String productName;
    private String productDescription;
    private String productDetail;
    private double price;
    private String[] productCategory;
    private String productImg;
}
