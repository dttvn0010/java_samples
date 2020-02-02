// Cho 2 danh sách số, tìm các phần tử chung nhau (phân biệt) của 2 danh sách này.
import java.util.List;
import java.util.HashSet;

public class S71 {
    public static void main(String[] args) {
        var lst1 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        var lst2 = List.of(2, 3, 5, 7, 9);
        var commons = new HashSet<Integer>();
        
        for(var x: lst1) {
            if(lst2.contains(x)) {
                commons.add(x);
            }
        }
        
        System.out.println(commons);
    }
}
