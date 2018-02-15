public class Easy_2 {

    public static void start(String[] args) {
        int[] numArr = new int[args.length];
        try {

            for (int i = 0; i < args.length; i++) {
                numArr[i] = Integer.parseInt(args[i]);
            }
            if (numArr[0] != 0 && numArr[0] != 1) {
                recursion(numArr[0]);
            } else {
                System.out.println("Ноль и единицу нельзя разложить на множители");
            }
        } catch (NumberFormatException e) {
            System.out.println("Вводите только число без символов!");
        }
    }

    private static void recursion(int n) {
        int a = 2;
        while (a <= n) {
            if ((n % a) == 0) {
                if (a != n) {
                    System.out.print(a + " ");
                    recursion(n / a);
                } else {
                    System.out.println(a);
                }
                return;
            }
            a++;
        }
    }
}
