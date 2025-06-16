package com.example.QLBH.controller;

import com.example.QLBH.entity.KhachHangEntity;
import com.example.QLBH.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    @GetMapping
    public ResponseEntity<List<KhachHangEntity>> getAllKhachHangs(){
        List<KhachHangEntity> khachHangs = khachHangService.getAllKhachHangs();
        return new ResponseEntity<>(khachHangs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<KhachHangEntity> getKhachHangById(@PathVariable Long id){
        KhachHangEntity khachHang = khachHangService.getKhachHangById(id);
        if (khachHang != null){
            return new ResponseEntity<>(khachHang, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<KhachHangEntity> createKhachHang(@RequestBody KhachHangEntity khachHang){
        KhachHangEntity createdKhachHang = khachHangService.saveKhachHang(khachHang);
        return new ResponseEntity<>(createdKhachHang, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<KhachHangEntity> updateKhachHang(@PathVariable Long id,@RequestBody KhachHangEntity khachHang){
        KhachHangEntity existingKhachHang = khachHangService.getKhachHangById(id);
        if (existingKhachHang != null){
            khachHang.setIdKhachHang(id);
            KhachHangEntity updatedKhachHang = khachHangService.saveKhachHang(khachHang);
            return new ResponseEntity<>(updatedKhachHang, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteKhachHang(@PathVariable Long id){
        if (khachHangService.getKhachHangById(id) != null){
            khachHangService.deleteKhachHang(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{search}")
    public ResponseEntity<List<KhachHangEntity>> searchKhachHangs(@RequestParam String ten){
        List<KhachHangEntity> khachHangs = khachHangService.searchKhachHangs(ten);
        return new ResponseEntity<>(khachHangs,HttpStatus.OK);
    }
}
