public class Easy_1 {

    public static void start(String args) {
        String strArr[] = args.split(" ");
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        sort(numArr);
        System.out.println(removeDuplicates(numArr)[1]);
    }

    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static int[] removeDuplicates(int[] values) {
        int count = 0;
        int[] newValues;
        for (int i = 0; i < values.length - count - 1; i++) {
            if (values[i] == values[i + 1]) {
                count++;
                for (int j = i + 1; j < values.length - count; j++) {
                    values[j] = values[j + 1];
                }
                i--;
            }
        }
        newValues = new int[values.length - count];
        for (int i = 0; i < newValues.length; i++) {
            newValues[i] = values[i];
        }
        return newValues;
    }
}
