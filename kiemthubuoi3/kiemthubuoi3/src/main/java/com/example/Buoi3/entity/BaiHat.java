package com.example.Buoi3.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaiHat {

    private String id;
    private String ten;
    private String tenCaSi;
    private int doDai;
    private String tenNhacSi;
}
