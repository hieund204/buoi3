package com.example.Buoi3.service;

import com.example.Buoi3.entity.XeOTO;

import java.util.ArrayList;
import java.util.List;

public class XeOTOService {
    private List<XeOTO> list = new ArrayList<>();

    public void addOTO(XeOTO oto){
        if (oto.getGia() < 0) {
            throw new IllegalArgumentException("Giá xe không thể âm");
        }
        if (oto.getTen() == null || oto.getTen().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên xe không thể trống");
        }
        for (XeOTO x : list) {
            if (x.getId() == oto.getId()) {
                throw new IllegalArgumentException("ID xe đã tồn tại");
            }
        }
        list.add(oto);
    }

    public void updateOTO(int id , XeOTO xeOTO){
        for (XeOTO oto : list){
            if (oto.getId() == id){
                oto.setTen(xeOTO.getTen());
                oto.setGia(xeOTO.getGia());
                oto.setGhiChu(xeOTO.getGhiChu());
                return ;
            }
        }
        throw new IllegalArgumentException("Xe không tồn tại");
    }

    public boolean deleteOTO(int id){
        return list.removeIf(xeOTO -> xeOTO.getId() == id);
    }

    public List<XeOTO> getOTO(){
        return list;
    }
}
