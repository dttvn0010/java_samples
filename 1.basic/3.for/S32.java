//Tính tổng các số từ 1 đến 100

public class S32 {
    public static void main(String[] args) {
        int S = 0;
        for(int i = 1; i <= 100; i++) {
            S += i;
        }
        System.out.println(S);
    }
}