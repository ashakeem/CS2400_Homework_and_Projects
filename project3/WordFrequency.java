//
// Name: Hakeem, Ayomide
// Project: 3
// Due: 03/29/2024
// Course: cs-2400-03-sp24
//
// Description: This program reads a text file and counts the frequency of each word in the file. It then prints  the frequency of each word in the file. 
// The program also prints the number of unique words in the file and the number of collisions that occurred when adding the words to the dictionary. 
// 
// 
//


import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) throws Exception {
        final int[] tableLength = {1361, 2003, 3001};
        HashedDictionary<String, Integer> dictionary = new HashedDictionary<>(1361);
        HashedDictionary<String, Integer> dict2 = new HashedDictionary<>(2003);
        HashedDictionary<String, Integer> dict3 = new HashedDictionary<>(3001);

        Scanner scnr = new Scanner(new File("usconstitution.txt"));
        while (scnr.hasNext()) {
            String nextWord = scnr.next().toLowerCase();
            try {
                Integer.parseInt(nextWord);
            } catch (NumberFormatException e) {
                Integer frequency = dictionary.getValue(nextWord);
                if (frequency == null) {
                    dictionary.add(nextWord, 1);
                    dict2.add(nextWord, 1);
                    dict3.add(nextWord, 1);
                } else {
                    dictionary.add(nextWord, frequency + 1);
                    dict2.add(nextWord, frequency + 1);
                    dict3.add(nextWord, frequency + 1);
                }
            }
        }

        System.out.println("Word Frequency by A. Hakeem\n");
        System.out.println("Count Word");
        System.out.println("----- -----------------");

        Iterator<String> keyIterator = dictionary.getKeyIterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            int count = dictionary.getValue(key);
            System.out.println(count + "\t" + key);
        }

        int[] collisions = new int[tableLength.length];
        for (int i = 0; i < tableLength.length; i++) {
            Iterator<String> keyIterator2 = dictionary.getKeyIterator();
            while (keyIterator2.hasNext()) {
                String nextWord = keyIterator2.next();
                int count = dictionary.getValue(nextWord);
                dictionary.add(nextWord, count);
            }
            collisions[i] = dictionary.getCollisionCount();
        }
        System.out.println("\nUnique Words: " + dictionary.getUniqueWordCount());
        System.out.println("\n\nTable\nLength\tCollisions");
        System.out.println(dictionary.getSize() + "\t" + dictionary.getCollisionCount());
        System.out.println(dict2.getSize() + "\t" + dict2.getCollisionCount());
        System.out.println(dict3.getSize() + "\t" + dict3.getCollisionCount());
    }
}
