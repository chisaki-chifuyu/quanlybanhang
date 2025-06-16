package com.example.QLBH.repository;

import com.example.QLBH.entity.KhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHangEntity,Long> {
    List<KhachHangEntity> findByTenContaining(String ten);
    Optional<KhachHangEntity> findById(Long IdKhachHang);
}
