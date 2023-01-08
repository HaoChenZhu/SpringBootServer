package es.nebrija.SpringBootServer.Shop.Infrastructure.controller;

import es.nebrija.SpringBootServer.Shop.Application.service.ShopService;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.PostShopRequestDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopProductDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ShopUpdateRequest;
import es.nebrija.SpringBootServer.exceptions.ApiException;
import es.nebrija.SpringBootServer.exceptions.ShopAlreadyExistsException;
import es.nebrija.SpringBootServer.exceptions.ShopNotFoundException;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/server/shop")
public class ShopController {
    @Autowired
    private ShopService shopServiceImpl;


    @PostMapping
    private void addShop(@RequestBody @Valid PostShopRequestDto postShopRequestDto) throws ShopAlreadyExistsException {
        shopServiceImpl.addShop(postShopRequestDto);
    }

    @PostMapping("/addProduct/{name}/{product_name}")
    public void addProduct(@PathVariable(value = "name") String name, @PathVariable(value = "product_name") String product_name) {
        shopServiceImpl.addProductToShop(name, product_name);
    }

    @GetMapping
    private ResponseEntity<List<ResponseShopDto>> getShops() throws NullPointerException {
        return new ResponseEntity<>(shopServiceImpl.getAllShops(), HttpStatus.OK);
    }

    @GetMapping("/products/{name}")
    private ResponseEntity<ResponseShopProductDto> getShopProduct(@PathVariable String name) throws ShopNotFoundException {

        return new ResponseEntity<>(shopServiceImpl.getShopProductByName(name), HttpStatus.OK);
    }


    @ApiResponse(code = 404, message = "No records found", response = ApiException.class)
    @GetMapping("/name/{name}")
    private ResponseEntity<ResponseShopDto> getShop(@PathVariable String name) throws ShopNotFoundException {

        return new ResponseEntity<>(shopServiceImpl.getShopByName(name), HttpStatus.OK);
    }

    @PutMapping("/update")
    private void updateShop(@RequestBody @Valid ShopUpdateRequest shop) throws ShopNotFoundException {
        shopServiceImpl.updateShop(shop);
    }

    @DeleteMapping("/delete/{name}")
    private void deleteShop(@PathVariable String name) throws ShopNotFoundException {
        shopServiceImpl.deleteShop(name);
    }


}
