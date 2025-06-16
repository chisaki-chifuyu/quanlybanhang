package com.example.QLBH.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khachhang")
public class KhachHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_khach_hang")
    private Long idKhachHang;
    @Column(name = "ten")
    private String ten;
    @Column(name = "so_dien_thoai")
    private  String soDienThoai;
    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DonHangEntity> donHangs;
}
