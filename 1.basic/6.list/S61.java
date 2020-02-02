// Cho trước dãy số, tách các số chẵn và số lẻ thành 2 dãy số mới.
import java.util.List;
import java.util.ArrayList;

public class S61 {
    public static void main(String[] args) {
        List<Integer> lst = List.of(1, 2, 3, 4, 5, 7, 9, 11, 12, 14);
        List<Integer> lstChan = new ArrayList<>();
        List<Integer> lstLe = new ArrayList<>();
        
        for(int x : lst) {
            if(x%2 == 0) {
                lstChan.add(x);
            }else {
                lstLe.add(x);
            }
        }
        System.out.println(lstChan);
        System.out.println(lstLe);
    }
}
