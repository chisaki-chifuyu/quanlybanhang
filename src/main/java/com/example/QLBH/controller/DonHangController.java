package com.example.QLBH.controller;

import com.example.QLBH.entity.DonHangEntity;
import com.example.QLBH.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donhang")
public class DonHangController {
    @Autowired
    private DonHangService donHangService;
    @GetMapping
    public ResponseEntity<List<DonHangEntity>> getAllDonHangs(){
        List<DonHangEntity> donHangs = donHangService.getAllDonHangs();
        return new ResponseEntity<>(donHangs, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<DonHangEntity> createDonHang(@RequestBody DonHangEntity donHang){
        DonHangEntity createdDonHang = donHangService.saveDonHangById(donHang);
        return new ResponseEntity<>(createdDonHang, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DonHangEntity> updateDonHang(@PathVariable Long id,@RequestBody DonHangEntity donHang){
        DonHangEntity existingDonHang = donHangService.getDonHangById(id);
        if (existingDonHang != null){
            donHang.setIdDonHang(id);
            DonHangEntity updatedDonHang = donHangService.saveDonHangById(donHang);
            return new ResponseEntity<>(updatedDonHang, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonHang(@PathVariable Long id){
        if (donHangService.getDonHangById(id) != null){
            donHangService.deleteDonHang(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<List<DonHangEntity>> searchDonHangs(@RequestParam String trangThai){
        List<DonHangEntity> donHangs = donHangService.searchDonHang(trangThai);
        return new ResponseEntity<>(donHangs, HttpStatus.OK);
    }
}
