import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        // Создаем фабричные объекты форматирования
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        
        // Значение для форматирования
        double x = 0.5;
        
        // Выводим в формате валюты и процента
        System.out.println(currencyFormatter.format(x)); // Например: 0,50 ?
        System.out.println(percentFormatter.format(x));  // 50%
    }
}
