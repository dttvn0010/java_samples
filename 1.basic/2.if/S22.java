// Nhập vào điểm trung bình, in ra loại học lực

public class S22 {
    public static void main(String[] args) {
        double x = 5.5;
        
        if(x < 5.0) {
            System.out.println("Học lực kém");
        } else if(x < 6.5) {
            System.out.println("Học lực trung bình");
        } else if(x < 8.0) {
            System.out.println("Học lực khá");
        } else {
            System.out.println("Học lực giỏi");
        }
    }
}