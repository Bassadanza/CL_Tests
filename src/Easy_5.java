public class Easy_5 {

    public static void start(String text, String find) {
        findIndexOf(text, find, 0);
    }

    private static void findIndexOf(String text, String find, int index) {
        while (index < text.length()) {
            index = text.indexOf(find, index);
            if (index == -1) {
                System.out.println("Подстрока не найдена");
            } else {
                System.out.println("Вхождение подстроки в индексе " + index);
                findIndexOf(text, find, index + 1);
            }
            return;
        }
    }
}
