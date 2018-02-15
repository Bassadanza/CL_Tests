public class Medium_1 {

    public static void start(String[] args) {
        try {
            int n = Integer.parseInt(args[args.length - 1]) - 1;
            int[] numArr = new int[args.length - 1];
            for (int i = 0; i < args.length - 1; i++) {
                numArr[i] = Integer.parseInt(args[i]);
            }
            Easy_1.sort(numArr);
            System.out.println(Easy_1.removeDuplicates(numArr)[n]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Количество уникальных элементов меньше, чем заданный номер элемента");
        } catch (NumberFormatException e) {
            System.out.println("Вводите только числа!");
        }
    }


}
