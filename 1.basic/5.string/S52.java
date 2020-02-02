// Nhập vào họ tên đầy đủ một người. In ra họ, tên đệm, tên

public class S52 {
    public static void main(String[] args) {
        String hoten = "Nguyen Van An";
        
        String[] items = hoten.split(" ");
        String ho = items[0];
        String ten = items[items.length-1];        
        String tendem = "";
        
        for(int i = 1; i < items.length-1; i++) {
            tendem += items[i];
        }
        
        System.out.println("Họ: " + ho);
        System.out.println("Tên đệm: " + tendem);
        System.out.println("Tên: " + ten);               
    }
}