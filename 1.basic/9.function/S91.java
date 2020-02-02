// Viết hàm tính tổng một danh sách số

import java.util.List;

public class S91 {
    
    static int getSum(List<Integer> lst) {
        int s = 0;
        for(var x : lst) {
            s += x;
        }
        return s;
    }
    
    public static void main(String[] args) {        
        System.out.println(getSum(List.of(1, 3, 5, 7, 10)));
    }
}
