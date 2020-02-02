// Cho 2 văn bản. Viết hàm tìm danh sách từ chung nhau của 2 văn bản

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class S11 {
    static Set<String> getWordSet(String st) {
        var s = new HashSet<String>();
        for(var word : st.split(" ")) {
            s.add(word);
        }
        return s;
    }
    
    static Set<String> getCommonWords(String st1, String st2) {
        var s1 = getWordSet(st1);
        var s2 = getWordSet(st2);
        s1.retainAll(s2);
        return s1;
    }
    
    public static void main(String[] args) {
        String st1 = "nhiệt độ ở thủ đô Hà Nội ngày mai là 20-25 độ C";
        String st2 = "nhiệt độ ở TP.HCM hôm này là 30-35 độ C";
        System.out.println(getCommonWords(st1, st2));

    }
}
