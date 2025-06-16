package com.example.QLBH.service;

import com.example.QLBH.entity.DonHangEntity;
import com.example.QLBH.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonHangService {
    @Autowired
    private DonHangRepository donHangRepository;
    public List<DonHangEntity> getAllDonHangs(){
        return donHangRepository.findAll();
    }
    public DonHangEntity saveDonHangById(DonHangEntity donHang){
        return donHangRepository.save(donHang);
    }
    public DonHangEntity getDonHangById(Long id){
        return donHangRepository.findById(id).orElse(null);
    }
    public void deleteDonHang(Long id){
        donHangRepository.deleteById(id);
    }
    public List<DonHangEntity> searchDonHang(String trangThai){
        return donHangRepository.findByTrangThai(trangThai);
    }
}
