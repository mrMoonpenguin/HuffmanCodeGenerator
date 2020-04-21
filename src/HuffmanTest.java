import huffman.Huffman;
import org.junit.Test;

import java.util.HashMap;

public class HuffmanTest {
    @Test
    public void huffmanTest(){
        HashMap<String, Double> dict = new HashMap<String, Double>(){{
           put("a", 0.1);
           put("b", 0.3);
           put("c", 0.6);
        }};

        new Huffman(dict);
    }

//    @Test
//    public void exercise1(){
//        HashMap<String, Double> dict = new HashMap<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter key: ");
//        String key = scanner.nextLine();
//        System.out.println("Enter frequency: ");
//        Double freq = scanner.nextDouble();
//
//        while(!key.equals("q")){
//            dict.put(key, freq);
//        }
//
//        new Huffman(dict);
//    }
}
