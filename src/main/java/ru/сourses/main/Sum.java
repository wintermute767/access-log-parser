

public class Sum {
    public static void main(String[] args) {
        double result = 0;

        for (String arg : args) {
            double argDouble;
            try {
                argDouble = Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                System.out.println("Аргумент " + arg + " не является числом. Ошибка: " + e.getMessage());
                argDouble = 0;
            }
            result+=argDouble;
        }
        System.out.println("результат: "+result);
    }
}
