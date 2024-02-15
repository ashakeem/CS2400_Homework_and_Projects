// Name: Hakeem, Ayomide
// Project: 1
// Due: 02/15/2024
// Course: cs-2400-03-SP24

// Description:
// The project involves implementing an interface `BagInterface` and a class `ArrayBag` in Java
// and creating an application `JavaKeywords` that utilizes the implemented interface and class to
// to determine Java keywords from input.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaKeywords {

  public static void main(String[] args) {
    ArrayBag<String> javaKeywordsBag = loadKeywords("javakeywords.txt");
    if (javaKeywordsBag == null) {
      System.out.println("Error: Could not load Java keywords.");
      return;
    }

    System.out.println("Java Keywords by A. Hakeem");
    System.out.println("# Java keywords loaded.");

    for (String arg : args) {
      if (javaKeywordsBag.contains(arg)) {
        System.out.println(arg + " is a keyword");
      } else {
        System.out.println(arg + " is not a keyword");
      }
    }
  }

  private static ArrayBag<String> loadKeywords(String fileName) {
    ArrayBag<String> bag = new ArrayBag<>();
    try {
      Scanner scanner = new Scanner(new File(fileName));
      while (scanner.hasNextLine()) {
        bag.add(scanner.nextLine());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }
    return bag;
  }
}
