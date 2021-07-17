package com.sparta.week04.controller;

import com.sparta.week04.models.Product;
import com.sparta.week04.models.ProductMypriceRequestDto;
import com.sparta.week04.models.ProductRepository;
import com.sparta.week04.models.ProductRequestDto;
import com.sparta.week04.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//관심 상품 관련 컨트롤러
@RequiredArgsConstructor //productRestController를 사용할때는 반드시 final위에 있는 것들을 포함해줘야 합니다. 라고 알려주는것
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    // 등록된 전체 상품 조회
    @GetMapping("/api/products")
    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto){
        Product product = new Product(productRequestDto);
        productRepository.save(product);
        return product;
    }

    @PutMapping("/api/products/{id}")
    public Long updateProduct (@PathVariable Long id,@RequestBody ProductMypriceRequestDto mypriceRequestDto){
        return productService.update(id,mypriceRequestDto);
    }

}
