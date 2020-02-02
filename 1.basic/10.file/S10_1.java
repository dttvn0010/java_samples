// Tạo một file văn bản và ghi vào file một số dòng

import java.io.PrintWriter;
import java.io.IOException;

public class S10_1 {
    public static void main(String[] args) throws IOException {
        var f = new PrintWriter("test.txt", "UTF-8");
        f.write("Xin chào\n");
        f.write("Bạn có khỏe không?");
        f.close();
    }
}

