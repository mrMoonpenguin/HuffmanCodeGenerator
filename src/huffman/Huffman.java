package huffman;

import java.util.*;

public class Huffman {
    private final PriorityQueue<Node> queue;
    private final ArrayList<Integer> codeLengths;

    private static class Node{
        private final double freq;
        private final String value;
        private final Node left;
        private final Node right;

        Node(double freq, String value){
            this.freq = freq;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(Node left, Node right){
            this.freq = left.getFreq() + right.getFreq();
            this.value = null;
            this.left = left;
            this.right = right;
        }

        double getFreq(){
            return this.freq;
        }

        Node getLeft(){
            return this.left;
        }

        Node getRight(){
            return this.right;
        }
    }

    public Huffman(HashMap<String, Double> dict){
        this.queue = new PriorityQueue<>(Comparator.comparing(Node::getFreq));
        this.codeLengths = new ArrayList<>();

        for(Map.Entry<String, Double> element : dict.entrySet()){
            this.queue.add(new Node(element.getValue(), element.getKey()));
        }

        this.makeTree();
        Node head = this.queue.remove();
        this.getHuffmanEncoding(head, "");
        System.out.printf("\nAverage code length:\t%f\n", this.getAverageCodeLength());
    }

    private void makeTree(){
        while(this.queue.size() > 1){
            Node right = this.queue.remove();
            Node left = this.queue.remove();
            this.queue.add(new Node(left, right));
        }
    }

    private void getHuffmanEncoding(Node node, String code){
        if(node.value != null){
            System.out.printf("%s:\t%s\n", node.value, code);
            this.codeLengths.add(code.length());
            return;
        }
        getHuffmanEncoding(node.getLeft(), code + "0");
        getHuffmanEncoding(node.getRight(), code + "1");
    }

    private double getAverageCodeLength(){
        int sum = 0;
        for(int len : this.codeLengths){
            sum += len;
        }
        return (double) sum / this.codeLengths.size();
    }
}
