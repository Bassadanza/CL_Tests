import java.util.InputMismatchException;
import java.util.Scanner;

public class CL_UI implements Runnable {

    private boolean RUNNING = true;
    private String[] ui = {
            "----------------------------------------------------",
            "Тестовые задания",
            "Легкие:",
            "1) Второй по величине элемент набора чисел",
            "2) Разложение числа на набор простых множителей",
            "3) Проверка строки на принадлежность к палиндрому",
            "4) Список разменов на 3,5 копеек и 3, 5, 7 копеек",
            "5) Поиск подстроки в строке",
            "Средние:",
            "6) n-ый по величине элемент набора чисел",
            "7) Run-length encoding строки",
            "8) Run-length decoding строки",
            "9) Количество разменов на n1... nk копеек",
            "Сложная:",
            "10) Command-Line утилита",
            "11) Выход",
            "----------------------------------------------------"
    };

    private void pritnUI() {
        for (int i = 0; i < ui.length; i++) {
            System.out.println(ui[i]);
        }
        try {
            scanner();
        } catch (InputMismatchException e) {
            System.out.println("Вводите только число!");
        }
    }

    @Override
    public void run() {
        while (RUNNING) {
                pritnUI();
        }
    }

    private void scanner() {
        try(Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Введите числа через пробел:");
                    Easy_1.start(getParam());
                    return;
                case 2:
                    System.out.println("Введите число для разложения:");
                    Easy_2.start(getSplitedParam());
                    break;
                case 3:
                    System.out.println("Введите строку для проверки:");
                    Easy_3.start(getParam());
                    break;
                case 4:
                    System.out.println("Не реализовано");
                    ;
                    break;
                case 5:
                    System.out.println("Введите строку:");
                    String temp = getParam();
                    System.out.println("Введите искому подстроку:");
                    Easy_5.start(temp, getParam());
                    break;
                case 6:
                    System.out.println("Введите набор чисел и последним укажите номер искомого элемента:");
                    Medium_1.start(getSplitedParam());
                    break;
                case 7:
                    System.out.println("Введите строку для кодирования:");
                    Medium_2.start(getParam());
                    break;
                case 8:
                    System.out.println("Введите строку для кодирования:");
                    Medium_3.start(getParam());
                    break;
                case 9:
                    System.out.println("Не реализовано");
                    ;
                    break;
                case 10:
                    System.out.println("Введите имя файла");
                    Hard.start(getParam());
                    break;
                case 11:
                    RUNNING = false;
                default:
                    break;
            }
        }
    }

    private String getParam() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        return str;
    }

    private String[] getSplitedParam() {
        String strArr[] = getParam().split(" ");
        return strArr;
    }
}
