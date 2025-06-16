package com.example.QLBH.repository;

import com.example.QLBH.entity.BaoCaoThongKeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaoCaoThongKeRepository extends JpaRepository<BaoCaoThongKeEntity, Long> {
    List<BaoCaoThongKeEntity> findByTenBaoCaoContaining(String tenBaoCao);

    default Optional<BaoCaoThongKeEntity> findById(Long idBaoCao) {
        return null;
    }
}
