import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        // ������� ��������� ������� ��������������
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        
        // �������� ��� ��������������
        double x = 0.5;
        
        // ������� � ������� ������ � ��������
        System.out.println(currencyFormatter.format(x)); // ��������: 0,50 ?
        System.out.println(percentFormatter.format(x));  // 50%
    }
}
