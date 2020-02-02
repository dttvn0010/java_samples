// Cho trước số N, tìm số K nhỏ nhất để 1+2+...+K > N
public class S41 {
    public static void main(String[] args) {
        int N = 10; // cho trước
        
        int K = 0, S = 0;
        while(S <= N) {
            K += 1;
            S += K;
        }
        
        System.out.println("K= " + K);
    }
}