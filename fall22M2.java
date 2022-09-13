package cop2805;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class fall22M2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

    Map<String, Integer> fileReaderMap = new HashMap<>();

    try (BufferedReader br = new BufferedReader(new FileReader("/Users/richardoquendo/Desktop/fall22m2.txt"))) {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!fileReaderMap.containsKey(words[i])) {
            fileReaderMap.put(words[i], 1);
            } else {
            int newValue = fileReaderMap.get(words[i]) + 1;
            fileReaderMap.put(words[i], newValue);
            }
        }
        sb.append(System.lineSeparator());
        line = br.readLine();
        }
    }
    List<Entry<String, Integer>> sorted = new ArrayList<>(fileReaderMap.entrySet());
    Collections.sort(sorted, new Comparator<Entry<String, Integer>>() {
        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        int comp = Integer.compare(o1.getValue(), o2.getValue());
        if (comp != 0) {
            return comp;
        }
        return o1.getKey().compareTo(o2.getKey());
        }
    });

    for (Entry<String, Integer> entry : sorted) {
        System.out.println( entry.getValue() + " = " + entry.getKey()); 
    }
    }
}