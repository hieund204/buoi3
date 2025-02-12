package com.example.Buoi3.service;

import com.example.Buoi3.entity.BaiHat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaiHatService {
    public List<BaiHat> danhSachBaiHat = new ArrayList<>();

    public void add(BaiHat baiHat) {
        if (baiHat.getDoDai() <= 0) {
            throw new IllegalArgumentException("Độ dài bài hát phải là số nguyên dương");
        } else if (baiHat.getDoDai() >=20) {
            throw new IllegalArgumentException("Độ dài bài hát phải nhỏ hơn 20 phút");
        }
        danhSachBaiHat.add(baiHat);
    }

    public void delete(String id) {
        boolean removed = danhSachBaiHat.removeIf(baiHat -> baiHat.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Bài hát không tồn tại");
        }
    }

    public void update(String id, BaiHat baiHatMoi) {
        Optional<BaiHat> baiHatOptional = danhSachBaiHat.stream().filter(b -> b.getId().equals(id)).findFirst();
        if (baiHatOptional.isPresent()) {
            danhSachBaiHat.remove(baiHatOptional.get());
            danhSachBaiHat.add(baiHatMoi);
        } else {
            throw new IllegalArgumentException("Bài hát không tồn tại");
        }
    }
}
