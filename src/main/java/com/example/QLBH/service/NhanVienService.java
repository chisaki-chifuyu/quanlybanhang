package com.example.QLBH.service;

import com.example.QLBH.entity.NhanVienEntity;
import com.example.QLBH.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    public List<NhanVienEntity> getAllNhanViens(){
        return nhanVienRepository.findAll();
    }
    public NhanVienEntity getNhanVienById(Long id){
        return nhanVienRepository.findById(id).orElse(null);
    }
    public NhanVienEntity saveNhanVien(NhanVienEntity nhanVien){
        return nhanVienRepository.save(nhanVien);
    }
    public void deleteNhanVien(Long id){
        nhanVienRepository.deleteById(id);
    }
    public List<NhanVienEntity> searchNhanViens(String ten){
        return nhanVienRepository.findByTenContaining(ten);
    }
}
