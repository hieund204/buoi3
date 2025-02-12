package com.example.Buoi3.service;

import com.example.Buoi3.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    private List<SinhVien> list = new ArrayList<>();

    public boolean addSinhVien( SinhVien sinhVien){
        return list.add(sinhVien);
    }

    public List<SinhVien> SearchSinhVien(int ma){
        for (SinhVien sv : list){
            if (sv.getMaSV() == ma){
                list.add(sv);
            }
        }
        return list;
    }

    public List<SinhVien> getSinhVien(){
        return list;
    }
}
