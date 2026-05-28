package com.rikkei.bai4.repository;

import com.rikkei.bai4.entity.Product; // Import thực thể Product vừa tạo ở bước 1
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository đã lo hết các hàm cơ bản, bạn không cần viết gì thêm ở đây
}