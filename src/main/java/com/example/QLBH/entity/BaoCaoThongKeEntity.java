package com.example.QLBH.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "baocaothongke")
public class BaoCaoThongKeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bao_cao")
    private Long idBaoCao;
    @Column(name = "ten_bao_cao")
    private String tenBaoCao;
    @Column(name = "mo_ta")
    private  String moTa;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "noi_dung_bao_cao", columnDefinition = "TEXT")
    private String noiDungBaoCao;
}
