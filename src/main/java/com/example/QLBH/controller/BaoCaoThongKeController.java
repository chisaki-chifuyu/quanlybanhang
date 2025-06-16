package com.example.QLBH.controller;

import com.example.QLBH.entity.BaoCaoThongKeEntity;
import com.example.QLBH.service.BaoCaoThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baocaothongke")
public class BaoCaoThongKeController {
    @Autowired
    private BaoCaoThongKeService baoCaoThongKeService;
    @GetMapping
    public ResponseEntity<List<BaoCaoThongKeEntity>> getAllBaoCaoThongKes() {
        List<BaoCaoThongKeEntity> baoCaoThongKes = baoCaoThongKeService.getAllBaoCaoThongKes();
        return new ResponseEntity<>(baoCaoThongKes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BaoCaoThongKeEntity> getBaoCaoThongKeById(@PathVariable Long id){
        BaoCaoThongKeEntity baoCaoThongKe = baoCaoThongKeService.getBaoCaoThongKeById(id);
        if (baoCaoThongKe != null){
            return new ResponseEntity<>(baoCaoThongKe, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<BaoCaoThongKeEntity> createBaoCaoThongKe(@RequestBody BaoCaoThongKeEntity baoCaoThongKe){
        BaoCaoThongKeEntity createdBaoCaoThongKe = baoCaoThongKeService.saveBaoCaoThongKe(baoCaoThongKe);
        return new ResponseEntity<>(createdBaoCaoThongKe, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<BaoCaoThongKeEntity> updateBaoCaoThongKe(@PathVariable Long id, @RequestBody BaoCaoThongKeEntity baoCaoThongKe){
        BaoCaoThongKeEntity exisitngBaoCaoThongKe = baoCaoThongKeService.getBaoCaoThongKeById(id);
        if (exisitngBaoCaoThongKe !=null){
            baoCaoThongKe.setIdBaoCao(id);
            BaoCaoThongKeEntity updatedBaoCaoThongKe = baoCaoThongKeService.saveBaoCaoThongKe(baoCaoThongKe);
            return new ResponseEntity<>(updatedBaoCaoThongKe,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBaoCaoThongKe(@PathVariable Long id){
        if (baoCaoThongKeService.getBaoCaoThongKeById(id) != null){
            baoCaoThongKeService.deleteBaoCaoThongKe(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search")
    public  ResponseEntity<List<BaoCaoThongKeEntity>> searchBaoCaoThongKes(@RequestParam String tenBaoCao){
        List<BaoCaoThongKeEntity> baoCaoThongKes = baoCaoThongKeService.searchBaoCaoThongKe(tenBaoCao);
        return new ResponseEntity<>(baoCaoThongKes, HttpStatus.OK);
    }
}
