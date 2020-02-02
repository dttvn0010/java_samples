// Cho một danh sách số (có thể trùng nhau). In ra số lần xuất hiện của mỗi số trong danh sách 

import java.util.List;
import java.util.HashMap;
    
public class S82 {
    public static void main(String[] args) {
        var lst = List.of(1, 2, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 4);
        var counts = new HashMap<Integer, Integer>();
        for(var x: lst) {
            if(counts.containsKey(x)) {
                counts.put(x, counts.get(x) + 1);
            }else {
                counts.put(x, 1);
            }
        }
        
        System.out.println(counts);
        
    }
}
    