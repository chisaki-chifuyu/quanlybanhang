package com.example.QLBH.service;

import com.example.QLBH.entity.KhachHangEntity;
import com.example.QLBH.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    public List<KhachHangEntity> getAllKhachHangs(){
        return khachHangRepository.findAll();
    }
    public KhachHangEntity getKhachHangById(Long id){
        return khachHangRepository.findById(id).orElse(null);
    }
    public KhachHangEntity saveKhachHang(KhachHangEntity khachHang){
        return khachHangRepository.save(khachHang);
    }
    public void deleteKhachHang(Long id){
        khachHangRepository.deleteById(id);
    }
    public List<KhachHangEntity> searchKhachHangs(String ten){
        return khachHangRepository.findByTenContaining(ten);
    }
}
