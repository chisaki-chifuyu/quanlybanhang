package com.example.QLBH.repository;

import com.example.QLBH.entity.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVienEntity,Long> {
    List<NhanVienEntity> findByTenContaining(String ten);
    Optional<NhanVienEntity> findById(Long IdNhanVien);
}
