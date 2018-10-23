import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Collections {
    private static Map<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        //Map<String, Integer> map = new TreeMap<>();
        readAndSort(map);
        showResult(map);
        findMaximum(map);
    }

    private static void readAndSort(Map<String, Integer> map) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file.txt"));
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+").next();
            Integer value = map.get(word);
            if (value == null) {
                value = 0;
            }
            map.put(word, ++value);
        }
        scanner.close();
    }

    private static void showResult(Map<String, Integer> map){
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void findMaximum(Map<String, Integer> map){
        Integer maxCount = 0;
        String word = "";
        for (Map.Entry entry:map.entrySet()) {
            Integer value = (Integer) entry.getValue();
            if (value.compareTo(maxCount) > 0){
                maxCount = value;
                word = (String) entry.getKey();
            }
        }
        System.out.print("Максимальное число раз повторяется слово: ");
        System.out.println(word + " - " + maxCount);
    }
}
