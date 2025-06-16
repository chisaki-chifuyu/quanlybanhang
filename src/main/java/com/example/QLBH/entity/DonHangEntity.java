package com.example.QLBH.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donhang")
public class DonHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_don_hang")
    private Long idDonHang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_khach_hang")
    @JsonBackReference
    private KhachHangEntity khachHang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nhan_vien")
    @JsonBackReference
    private NhanVienEntity nhanVien;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "tong_tien")
    private Double tongTien;
}
