// Cho trước dãy số, nhập vào một số. Kiểm tra số có nằm trong dãy số hay không. Nếu có thì xóa số đó khỏi dãy số.
import java.util.List;
import java.util.ArrayList;

public class S62 {
    public static void main(String[] args) {
        List<Integer> lst = List.of(1, 2, 3, 4, 5, 7, 9, 11, 12, 14);
        lst = new ArrayList<>(lst);
        Integer x = 9;              // cho trước
        
        if(lst.contains(x)) {
            lst.remove(x);
            System.out.println("Dãy số mới: " + lst);
        }else {
            System.out.println(x + " không nằm trong dãy số");
        }
    }
}


    