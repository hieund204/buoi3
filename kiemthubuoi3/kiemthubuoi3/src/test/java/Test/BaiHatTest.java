package Test;

import com.example.Buoi3.entity.BaiHat;
import com.example.Buoi3.service.BaiHatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaiHatTest {
    private BaiHatService baiHatService;

    @BeforeEach
    public void setUp() {
        baiHatService = new BaiHatService();
    }

    @Test
    public void testAddBaiHat_Success() {
        BaiHat baiHat = new BaiHat("1", "Song 1", "Ca Si A", 19, "Nhac Si B");
        baiHatService.add(baiHat);
        assertEquals(1, baiHatService.danhSachBaiHat.size());
    }
    @Test
    public void testAddBaiHat_Success1() {
        BaiHat baiHat = new BaiHat("1", "Song 1", "Ca Si A", 18, "Nhac Si B");
        baiHatService.add(baiHat);
        assertEquals(1, baiHatService.danhSachBaiHat.size());
    }
    @Test
    public void testAddBaiHat_Success2() {
        BaiHat baiHat = new BaiHat("1", "Song 1", "Ca Si A", 18, "Nhac Si B");
        baiHatService.add(baiHat);
        assertEquals(1, baiHatService.danhSachBaiHat.size());
    }
    @Test
    public void testAddBaiHat_Success3() {
        BaiHat baiHat = new BaiHat("1", "Song 1", "Ca Si A", 180, "Nhac Si B");
        baiHatService.add(baiHat);
        assertEquals(1, baiHatService.danhSachBaiHat.size());
    }

    @Test
    public void testAddBaiHat_Fail_DoDaiNegative() {
        BaiHat baiHat = new BaiHat("2", "Song 2", "Ca Si B", -100, "Nhac Si C");
        assertThrows(IllegalArgumentException.class, () -> baiHatService.add(baiHat));
    }

    @Test
    public void testAddBaiHat_Fail_DoDaiZero() {
        BaiHat baiHat = new BaiHat("3", "Song 3", "Ca Si C", 0, "Nhac Si D");
        assertThrows(IllegalArgumentException.class, () -> baiHatService.add(baiHat));
    }

    @Test
    public void testDeleteBaiHat_Success() {
        BaiHat baiHat = new BaiHat("4", "Song 4", "Ca Si D", 200, "Nhac Si E");
        baiHatService.add(baiHat);
        baiHatService.delete("4");
        assertEquals(0, baiHatService.danhSachBaiHat.size());
    }
    @Test
    public void testDeleteBaiHat_Success1() {
        BaiHat baiHat = new BaiHat("4", "Song 4", "Ca Si D", 200, "Nhac Si E");
        baiHatService.add(baiHat);
        baiHatService.delete("4");
        assertEquals(0, baiHatService.danhSachBaiHat.size());
    }
    @Test
    public void testDeleteBaiHat_Success2() {
        BaiHat baiHat = new BaiHat("4", "Song 4", "Ca Si D", 200, "Nhac Si E");
        baiHatService.add(baiHat);
        baiHatService.delete("4");
        assertEquals(0, baiHatService.danhSachBaiHat.size());
    }

    @Test
    public void testDeleteBaiHat_Fail_NotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            baiHatService.delete("10");
        });
        assertEquals("Bài hát không tồn tại", exception.getMessage());
    }

    @Test
    public void testUpdateBaiHat_Success() {
        BaiHat baiHat = new BaiHat("5", "Song 5", "Ca Si F", 220, "Nhac Si G");
        baiHatService.add(baiHat);
        BaiHat baiHatMoi = new BaiHat("5", "Song 5 Moi", "Ca Si F", 250, "Nhac Si H");
        baiHatService.update("5", baiHatMoi);
        assertEquals("Song 5 Moi", baiHatService.danhSachBaiHat.get(0).getTen());
    }

    @Test
    public void testUpdateBaiHat_Fail_NotFound() {
        BaiHat baiHatMoi = new BaiHat("6", "Song 6 Moi", "Ca Si G", 300, "Nhac Si I");
        assertThrows(IllegalArgumentException.class, () -> baiHatService.update("6", baiHatMoi));
    }

    @Test
    public void testAddBaiHat_Fail_EmptyId() {
        BaiHat baiHat = new BaiHat("", "Song 4", "Ca Si D", 200, "Nhac Si E");
        assertThrows(IllegalArgumentException.class, () -> baiHatService.add(baiHat));
    }

    @Test
    public void testAddBaiHat_Fail_NullId() {
        BaiHat baiHat = new BaiHat(null, "Song 5", "Ca Si E", 300, "Nhac Si F");
        assertThrows(IllegalArgumentException.class, () -> baiHatService.add(baiHat));
    }

    @Test
    public void testDeleteBaiHat_Fail_EmptyId() {
        assertThrows(IllegalArgumentException.class, () -> baiHatService.delete(""));
    }

    @Test
    public void testDeleteBaiHat_Fail_NullId() {
        assertThrows(IllegalArgumentException.class, () -> baiHatService.delete(null));
    }

    @Test
    public void testDeleteBaiHat_Fail_MultipleDeletes() {
        BaiHat baiHat = new BaiHat("7", "Song 7", "Ca Si G", 250, "Nhac Si H");
        baiHatService.add(baiHat);
        baiHatService.delete("7");
        assertThrows(IllegalArgumentException.class, () -> baiHatService.delete("7"));
    }


}
