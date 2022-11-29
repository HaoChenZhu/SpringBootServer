package es.nebrija.SpringBootServer.Shop.Infrastructure.controller;

import es.nebrija.SpringBootServer.Shop.Application.service.ShopServiceImpl;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.PostShopRequestDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ShopUpdateRequest;
import es.nebrija.SpringBootServer.Shop.Infrastructure.exceptions.ApiException;
import es.nebrija.SpringBootServer.Shop.Infrastructure.exceptions.ShopAlreadyExistsException;
import es.nebrija.SpringBootServer.Shop.Infrastructure.exceptions.ShopNotFoundException;
import io.swagger.annotations.ApiResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/server/shop")
public class ShopController {
    @Autowired
    private ShopServiceImpl shopServiceImpl;


    @PostMapping
    private void addShop(@RequestBody @Valid PostShopRequestDto postShopRequestDto) throws ShopAlreadyExistsException {
        shopServiceImpl.addShop(postShopRequestDto);
    }

    @PostMapping("/addProduct/{name}/{idProduct}")
    public void addProduct(@PathVariable(value = "name") String name, @PathVariable(value = "idProduct") String productId) {
        ObjectId id = new ObjectId(productId);
        shopServiceImpl.addProductToShop(name, id);
    }

    @GetMapping
    private ResponseEntity<List<ResponseShopDto>> getShops() {
        return new ResponseEntity<>(shopServiceImpl.getAllShops(), HttpStatus.OK);
    }

    @ApiResponse(code = 404, message = "No records found", response = ApiException.class)
    @GetMapping("/name/{name}")
    private ResponseEntity<ResponseShopDto> getShop(@PathVariable String name) throws ShopNotFoundException {

        return new ResponseEntity<>(shopServiceImpl.getShopByName(name), HttpStatus.OK);
    }

    @PutMapping("/update")
    private void updateShop(@RequestBody @Valid ShopUpdateRequest shop) throws ShopNotFoundException{
        shopServiceImpl.updateShop(shop);
    }

    @PutMapping("/delete/{name}")
    private void deleteShop(@PathVariable String name) throws ShopNotFoundException {
        shopServiceImpl.deleteShop(name);
    }


}
