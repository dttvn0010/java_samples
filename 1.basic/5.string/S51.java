// Nhập vào họ, tên đệm, tên của một người. In ra tên đầy đủ

public class S51 {
    public static void main(String[] args) {
        String ho = "Nguyen";
        String tendem = "Van";
        String ten = "An";
        
        String hoten = ho + " " + tendem + " " + ten;
        hoten = String.format("%s %s %s", ho, tendem, ten); // cách 2
        System.out.println("Họ và tên: " + hoten);        
    }
}