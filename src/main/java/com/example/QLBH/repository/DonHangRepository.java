package com.example.QLBH.repository;

import com.example.QLBH.entity.DonHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonHangRepository extends JpaRepository<DonHangEntity,Long> {
    Optional<DonHangEntity> findById(Long idDonHang);
    List<DonHangEntity> findByTrangThai(String trangThai);
}
