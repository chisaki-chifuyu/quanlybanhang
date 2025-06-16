package com.example.QLBH.service;

import com.example.QLBH.entity.BaoCaoThongKeEntity;
import com.example.QLBH.repository.BaoCaoThongKeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoCaoThongKeService {
    @Autowired
    private BaoCaoThongKeRepository baoCaoThongKeRepository;
    public List<BaoCaoThongKeEntity> getAllBaoCaoThongKes(){
        return baoCaoThongKeRepository.findAll();
    }
    public BaoCaoThongKeEntity getBaoCaoThongKeById(Long id){
        return baoCaoThongKeRepository.findById(id).orElse(null);
    }
    public BaoCaoThongKeEntity saveBaoCaoThongKe(BaoCaoThongKeEntity baoCaoThongKe){
        return baoCaoThongKeRepository.save(baoCaoThongKe);
    }
    public void deleteBaoCaoThongKe(Long id){
        baoCaoThongKeRepository.deleteById(id);
    }
    public List<BaoCaoThongKeEntity> searchBaoCaoThongKe(String tenBaoCao){
        return baoCaoThongKeRepository.findByTenBaoCaoContaining(tenBaoCao);
    }
}
