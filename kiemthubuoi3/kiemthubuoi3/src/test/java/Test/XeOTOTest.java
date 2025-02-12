package Test;


import com.example.Buoi3.entity.XeOTO;
import com.example.Buoi3.service.XeOTOService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class XeOTOTest {

    XeOTOService service;

    @BeforeEach
    public void setup(){
        service = new XeOTOService();
    }

    @Test
    public void add_Valid(){
        XeOTO xe = new XeOTO(1, "Toyota" , 1000f, "Khong");
        service.addOTO(xe);
        assertEquals(1, service.getOTO().size());
        assertEquals(xe, service.getOTO().get(0));
    }

    @Test
    public void testaddOTO_Valid() {
        XeOTO xe = new XeOTO(1, "Toyota", 50000f, "Mới");
        service.addOTO(xe);
        Assertions.assertEquals(1, service.getOTO().size());
    }

    @Test
    public void testaddOTO_Invalid() {
        XeOTO xe = new XeOTO(1, "Toyota", 10000f, "Mới");
        service.addOTO(xe);
        Assertions.assertEquals(1, service.getOTO().size());
    }


    @Test
    public void testaddOTO_DuplicateId() {
        service.addOTO(new XeOTO(1, "Toyota", 50000f, "Mới"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                service.addOTO(new XeOTO(1, "Honda", 60000f, "Cũ"))
        );
    }

    @Test
    public void testaddOTO_InvalidPrice() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                service.addOTO(new XeOTO(2, "BMW", -1000f, "Lỗi"))
        );
    }

    @Test
    public void testUpdateXeOto_Valid() {
        service.addOTO(new XeOTO(1, "Toyota", 50000f, "Mới"));
        XeOTO xeUpdate = new XeOTO(1, "Toyota Altis", 55000f, "Nâng cấp");
        service.updateOTO( 1,xeUpdate);
        Assertions.assertEquals("Toyota Altis", service.getOTO().get(0).getTen());
    }


    @Test
    public void testDeleteXeOto_Valid() {
        service.addOTO(new XeOTO(1, "Toyota", 50000f, "Mới"));
        service.deleteOTO(1);
        Assertions.assertEquals(0, service.getOTO().size());
    }



    @Test
    public void testAddMultipleXeOto() {
        service.addOTO(new XeOTO(1, "Toyota", 50000f, "Mới"));
        service.addOTO(new XeOTO(2, "Honda", 45000f, "Mới"));
        Assertions.assertEquals(2, service.getOTO().size());
    }

    @Test
    public void testDeleteAllXeOto() {
        service.addOTO(new XeOTO(1, "Toyota", 50000f, "Mới"));
        service.addOTO(new XeOTO(2, "Honda", 45000f, "Mới"));
        service.deleteOTO(1);
        service.deleteOTO(2);
        Assertions.assertEquals(0, service.getOTO().size());
    }


}
