// Cho một văn bản, in ra các từ trong văn bản kèm số lần xuất hiện của chúng theo thứ tự số lượng giảm dần

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
    
public class S83 {
    public static void main(String[] args) {
        String st = "một năm có ba trăm sáu mươi lăm hoặc ba trăm sáu mươi sáu ngày";
        var words = st.split(" ");
        var counts = new HashMap<String, Integer>();
        
        for(var word: words) {
            if(counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            }else {
                counts.put(word, 1);
            }
        }
        
        var items = new ArrayList<>(counts.entrySet());
        items.sort((item1, item2) -> Integer.compare(item2.getValue(), item1.getValue()));        
        System.out.println(items);
    }
}
    