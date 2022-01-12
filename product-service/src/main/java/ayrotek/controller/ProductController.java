package ayrotek.controller;

import ayrotek.dto.ProductDTO;
import ayrotek.entity.Product;
import ayrotek.response.AyrotekResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ayrotek.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getProduct")
    public ResponseEntity<AyrotekResponse<ProductDTO>> getProduct(@RequestParam("productId") Long productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<AyrotekResponse<List<ProductDTO>>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/createProduct")
    public ResponseEntity<AyrotekResponse<ProductDTO>> createProduct(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PostMapping("/updateProduct")
    public ResponseEntity<AyrotekResponse> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<AyrotekResponse> deleteProduct(@RequestParam("productId") Long productId) {
       return ResponseEntity.ok(productService.deleteProduct(productId));
    }
}
