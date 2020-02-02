// Mở 1 file và đọc từng dòng trong file

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class S10_2 {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new FileReader("test.txt"));
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
