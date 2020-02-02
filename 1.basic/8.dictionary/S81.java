// Cho một từ điển. In ra nghĩa của từng từ trong từ điển. Nhập vào một từ, in ra nghĩa của từ đó nếu có, nếu từ không nằm trong từ điển thì in ra "Không tồn tại"

import java.util.HashMap;
import java.util.Map;

public class S11 {
    public static void main(String[] args) {
        var dict = Map.of(
                    "one", "một",
                    "two", "hai",
                    "three", "ba"
                );
                
        dict = new HashMap<>(dict);
        dict.put("four", "bốn");
        
        for(var key : dict.keySet()) {
            System.out.println(key + " : " + dict.get(key));
        }
        
        String word = "five";
        if(dict.containsKey(word)) {
            System.out.println(word + " : " + dict.get(word));
        }else {
            System.out.println("Không tồn tại từ: " + word);
        }
        
    }
}
