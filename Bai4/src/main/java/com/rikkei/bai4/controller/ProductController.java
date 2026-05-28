package com.rikkei.bai4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rikkei.bai4.entity.Product;
import com.rikkei.bai4.repository.ProductRepository;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products") // Giả định route chung của controller là /products
public class ProductController {

    @Autowired
    private ProductRepository productRepository; // Repository của bạn

    // 1. Cập nhật toàn bộ sản phẩm (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateFull(@PathVariable Long id, @RequestBody Product product) {
        // Lưu ý: Kiểm tra client gửi đầy đủ name và price. Nếu thiếu -> 400 Bad Request
        if (product.getName() == null || product.getName().trim().isEmpty() || product.getPrice() == null) {
            return ResponseEntity.badRequest().build();
        }

        // Kiểm tra xem id có tồn tại không (dùng repository.existsById)
        if (!productRepository.existsById(id)) {
            // Nếu không -> 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // Nếu có: set id cho product (giữ nguyên id), gọi repository.save(product) -> cập nhật
        product.setId(id);
        Product updatedProduct = productRepository.save(product);

        // Trả về 200 OK kèm product đã cập nhật
        return ResponseEntity.ok(updatedProduct);
    }

    // 2. Cập nhật một phần (PATCH) – nhận Map
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updatePartial(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        // Tìm product từ DB, nếu không có -> 404 Not Found
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Product product = productOptional.get();

        // Duyệt updates, với mỗi key (name, price) cập nhật giá trị tương ứng
        if (updates.containsKey("name")) {
            product.setName((String) updates.get("name"));
        }

        if (updates.containsKey("price")) {
            // Mẹo nhỏ: Jackson có thể parse số nguyên thành Integer, dùng kiểu Number để ép kiểu an toàn cho cả Double/Long
            Object priceObj = updates.get("price");
            if (priceObj instanceof Number) {
                product.setPrice(((Number) priceObj).doubleValue()); // Hoặc .longValue() tùy kiểu dữ liệu của bạn
            }
        }

        // Lưu lại product
        Product updatedProduct = productRepository.save(product);

        // Trả về 200 OK kèm dữ liệu đã cập nhật
        return ResponseEntity.ok(updatedProduct);
    }

    // 3. Xóa sản phẩm (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // Kiểm tra tồn tại, nếu không -> 404 Not Found
        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Xóa bằng repository.deleteById(id)
        productRepository.deleteById(id);

        // Trả về 204 No Content
        return ResponseEntity.noContent().build();
    }
}