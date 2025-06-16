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
@Table(name = "nhanvien")
public class NhanVienEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_nhan_vien")
    private Long idNhanVien;
    @Column(name = "ten")
    private String ten;
    @Column(name = "vi_tri")
    private String viTri;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private  String password;
    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DonHangEntity> donHangs;
}
