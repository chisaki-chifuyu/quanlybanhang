package com.example.QLBH.controller;

import com.example.QLBH.entity.NhanVienEntity;
import com.example.QLBH.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public ResponseEntity<List<NhanVienEntity>> getAllNhanViens() {
        List<NhanVienEntity> nhanViens = nhanVienService.getAllNhanViens();
        return new ResponseEntity<>(nhanViens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienEntity> getNhanVienById(@PathVariable Long id) {
        NhanVienEntity nhanVien = nhanVienService.getNhanVienById(id);
        if (nhanVien != null) {
            return new ResponseEntity<>(nhanVien, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<NhanVienEntity> createNhanVien(@RequestBody NhanVienEntity nhanVien) {
        NhanVienEntity createdNhanVien = nhanVienService.saveNhanVien(nhanVien);
        return new ResponseEntity<>(createdNhanVien, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVienEntity> updateNhanVien(@PathVariable Long id, @RequestBody NhanVienEntity nhanVien) {
        NhanVienEntity existingNhanVien = nhanVienService.getNhanVienById(id);
        if (existingNhanVien != null) {
            nhanVien.setIdNhanVien(id);
            NhanVienEntity updatedNhanVien = nhanVienService.saveNhanVien(nhanVien);
            return new ResponseEntity<>(updatedNhanVien, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable Long id) {
        if (nhanVienService.getNhanVienById(id) != null) {
            nhanVienService.deleteNhanVien(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<List<NhanVienEntity>> searchNhanViens(@RequestParam String ten){
        List<NhanVienEntity> nhanViens = nhanVienService.searchNhanViens(ten);
        return new ResponseEntity<>(nhanViens, HttpStatus.OK);
    }
}