package Test;

import com.example.Buoi3.entity.SinhVien;
import com.example.Buoi3.service.SinhVienService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SinhVienTest {

    private SinhVienService sinhvienService;

    @BeforeEach
    public void setUp() {
        sinhvienService = new SinhVienService();
    }

    @Test
    public void addSinhVienIdLa1() {
        SinhVien sv = new SinhVien(1,"Pham A" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sv);
        assertEquals(1 , sinhvienService.getSinhVien().size());
        assertEquals(sv , sinhvienService.getSinhVien().get(0));
    }

    @Test
    public void addSinhVienIdLa2() {
        SinhVien sv = new SinhVien(2,"Pham B" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sv);
        assertEquals(sv , sinhvienService.getSinhVien().get(0));
    }

    @Test
    public void addSinhVienIdLa3() {
        SinhVien sv = new SinhVien(3,"Pham A" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sv);
        assertEquals(sv , sinhvienService.getSinhVien().get(0));
    }

    @Test
    public void addSinhVienIdLa5() {
        SinhVien sv = new SinhVien(5,"Pham A" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sv);
        assertEquals(sv , sinhvienService.getSinhVien().get(0));
    }

    @Test
    public void addSinhVienIdLa10() {
        SinhVien sv = new SinhVien(10,"Pham A" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sv);
        assertEquals(sv , sinhvienService.getSinhVien().get(0));
    }
    @Test
    public void addSinhVienTenLa4() {
        SinhVien sv = new SinhVien(1,"Pham b" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sv);
        assertEquals(sv , sinhvienService.getSinhVien().get(0));
    }

    @Test
    public void searchSinhVienValid() {
        SinhVien sinhVien = new SinhVien(1,"Pham A" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sinhVien);

        SinhVien sinhVien2 = new SinhVien(2,"Pham B" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sinhVien);

        List<SinhVien> list = sinhvienService.SearchSinhVien(2);
        assertEquals(1, list.size());
        assertEquals(sinhVien , sinhvienService.getSinhVien().get(0));
    }

    @Test
    public void searchSinhVien_NotFound() {
        SinhVien sinhVien = new SinhVien(1,"Pham A" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sinhVien);

        SinhVien sinhVien2 = new SinhVien(2,"Pham B" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sinhVien);

        List<SinhVien> list = sinhvienService.SearchSinhVien(3);
        assertEquals(1, list.size());
        assertEquals(sinhVien , sinhvienService.getSinhVien().get(0));
    }

    @Test
    public void searchSinhVienValid_Invalid() {
        SinhVien sinhVien = new SinhVien(1,"Pham A" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sinhVien);

        SinhVien sinhVien2 = new SinhVien(2,"Pham B" , "ABC" , "K19" , "Kiem thu");
        sinhvienService.addSinhVien(sinhVien);

        List<SinhVien> list = sinhvienService.SearchSinhVien(-10);
        assertEquals(1, list.size());
        assertEquals(sinhVien , sinhvienService.getSinhVien().get(0));
    }










}

