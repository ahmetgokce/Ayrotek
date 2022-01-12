package ayrotek.service;

import ayrotek.dto.ProductDTO;
import ayrotek.entity.Product;
import ayrotek.mapper.ProductMapper;
import ayrotek.repository.ProductRepository;
import ayrotek.response.AyrotekResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

     private final ProductRepository productRepository;
     private final ProductMapper productMapper;

    public AyrotekResponse<List<ProductDTO>> getAllProducts() {
        try {
            return new AyrotekResponse<>(true,productMapper.toDto(productRepository.findAll()));
        }catch (Exception e) {
            return new AyrotekResponse<>(false,null);
        }

    }

    public AyrotekResponse getProduct(Long productId){
        try {
            return new AyrotekResponse<>(true,productMapper.toDto(productRepository.findById(productId).get()));
        } catch (Exception e) {
            return new AyrotekResponse<>(false, null);
        }

    }

    public AyrotekResponse createProduct(ProductDTO product) {
        try {
            return new AyrotekResponse<>(true, productMapper.toDto(productRepository.save(productMapper.toEntity(product))));
        }catch (Exception e) {
            return new AyrotekResponse<>(false, null);
        }
    }

    public AyrotekResponse deleteProduct(Long productId) {
        try {
            productRepository.deleteById(productId);
            return new AyrotekResponse<>(true, null);
        } catch (Exception e) {
            return new AyrotekResponse<>(false, null);
        }

    }

    public AyrotekResponse updateProduct(Product product) {
        try {
            return new AyrotekResponse<>(true, productMapper.toDto(productRepository.save(product)));
        }catch (Exception e) {
            return new AyrotekResponse<>(false, null);
        }
    }
}
