public class Easy_3 {

    public static void start(String args) {
        isPalindromeString(args);
    }

    private static void isPalindromeString(String str) {
        if (str == null)
            System.out.println("Пустая строка");
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                System.out.println("Строка не палиндром");
                break;
            } else {
                System.out.println("Строка - палиндром");
                break;
            }
        }
    }
}
