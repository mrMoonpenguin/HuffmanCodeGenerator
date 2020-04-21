package huffman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class Main {
    public static void main(String[] args){
        HashMap<String, Double> dict = new HashMap<>();
        BufferedReader reader;

        try{
           reader = new BufferedReader(new FileReader("C:/Users/Hasbi Dulger/Documents/Java/huffmancodes/exercise1.txt"));
           String line = reader.readLine();
           while(line != null){
               String[] entry = line.split(" ");
               dict.put(entry[0], Double.parseDouble(entry[1]));
               line = reader.readLine();
           }
           reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        new Huffman(dict);
    }
}
