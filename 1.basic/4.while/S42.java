// Cho trước số N, tính số chữ số của N trong hệ nhị phân (số bit biểu diễn N)

public class S42 {
    public static void main(String[] args) {
        int N = 100; // cho trước
        
        int digits = 0;
        while(N > 0) {
            digits += 1;
            N /= 2;
        }
        
        System.out.println("Số bit biểu diễn N: " + digits);
    }
}