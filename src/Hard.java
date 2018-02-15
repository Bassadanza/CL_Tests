import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Hard {

    public static void start(String args) {
        try {
            generateTxt(args);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }

    private static void generateTxt(String args) throws InterruptedException, FileNotFoundException {
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 2);
        List<String> input = readFile(args);
        int[] result = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            int finalI = i;
            threadPool.submit(() -> {
                result[finalI] = parseString(input.get(finalI));
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);
        writeFile(result);
        System.out.println("Готово");
    }

    private static List<String> readFile(String args) throws FileNotFoundException {
        List<String> input = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(args));
        synchronized (input) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                input.add(line);
            }
        }
        scanner.close();
        return input;
    }

    private static void writeFile(int[] result) {
        try {
            File file = new File("result.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            for (int i = 0; i < result.length; i++) {
                writer.write((i + 1) + " " + result[i] + System.lineSeparator());
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("При записи файла что-то пошло не так...");
        }
    }


    private static int parseString(String string) {
        String strArr[] = string.split(" ");
        switch (strArr[0]) {
            case "ACK":
                return ack(Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]));
            case "F":
                return factorial(Integer.parseInt(strArr[1]));
            case "FIB":
                return fib(Integer.parseInt(strArr[1]));
            default:
                return -1;
        }
    }

    private static int ack(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0 && m > 0) {
            return ack(m - 1, 1);
        } else {
            return ack(m - 1, ack(m, n - 1));
        }
    }

    private static int factorial(int x) {
        int fact = 1;
        for (int i = 2; i <= x; i++)
            fact *= i;
        return fact;
    }

    private static int fib(int x) {
        if (x == 1) return 1;
        if (x == 2) return 1;
        return fib(x - 1) + fib(x - 2);
    }
}
