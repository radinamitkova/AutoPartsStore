package bg.startit.autoPartsStore.controller;

import bg.startit.autoPartsStore.dto.CreateOrderRequest;
import bg.startit.autoPartsStore.dto.UserRequest;
import bg.startit.autoPartsStore.model.Product;
import bg.startit.autoPartsStore.model.User;
import bg.startit.autoPartsStore.service.ProductService;
import bg.startit.autoPartsStore.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Validated
public class UserController {

    private final UserService userService;
    private final ProductService productService;

    public UserController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping(value = "order")
    public ResponseEntity<?> makeOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) throws Exception {
        userService.orderProduct(createOrderRequest.getClient(),
                createOrderRequest.getProduct(),
                createOrderRequest.getAmount());
        return ResponseEntity.ok("Your order has been sent successfully!");
    }

    @PostMapping(value = "register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequest userRequest) throws Exception {
        userService.createUser(userRequest.getName(),
                userRequest.getUsername(),
                userRequest.getPassword());
        return ResponseEntity.ok("User has been registered successfully!");
    }

    @GetMapping("search/car_brand")
    public ResponseEntity<?> searchForProductByCarBrand(String carBrand) {
        return ResponseEntity.ok(productService.getProductByCarBrand(carBrand));
    }

    @GetMapping("search/asc_price")
    public ResponseEntity<?> getAllProductsByASCPrice() {
        List<Product> productsByASCPrice = productService.getProductByOrderedPriceASC();
        return ResponseEntity.ok(productsByASCPrice);
    }

    @GetMapping("search/desc_price")
    public ResponseEntity<?> getAllProductsByDESCPrice() {
        List<Product> productsByDESCPrice = productService.getProductByOrderedPriceDESC();
        return ResponseEntity.ok(productsByDESCPrice);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable String id) {
        return ResponseEntity.ok(deleteUserById(id));
    }


}
