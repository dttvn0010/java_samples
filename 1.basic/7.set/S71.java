// Cho một danh sách số, in ra các số phân biệt trong danh sách

import java.util.List;
import java.util.HashSet;

public class S71 {
    public static void main(String[] args) {
        var lst = List.of(1, 2, 3, 1, 2, 4, 5, 7, 8);
        var s = new HashSet<Integer>();
        for(int x : lst) {
            s.add(x);
        }
        System.out.println(s);
    }
}
