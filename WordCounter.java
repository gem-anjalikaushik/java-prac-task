//This code takes the file name as input, read its content and count the word occurences in it
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class WordCounter {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Prompt user for the file name
        System.out.print("Enter the name of the text file: ");
        String fileName = sc.nextLine();

        // Reading the contents of file
        String fileContents = readFile(fileName);

        // Counting  word occurrences
        Map<String, Integer> wordCount = countWords(fileContents);

        // Display results
        displayResults(wordCount);
    }

    private static String readFile(String fileName) {
        StringBuilder contents = new StringBuilder();
        try (BufferedReader readerOfFile = new BufferedReader(new FileReader(fileName))) {
            String hasLine;
            while ((hasLine = readerOfFile.readLine()) != null) {
                contents.append(hasLine).append(" ");
            }
        } catch (IOException e) {
            System.err.println("Error occured " );
            
        }
        return contents.toString();
    }

    private static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {
            // Removing non-alphabetic characters
            word = word.replaceAll("[^a-zA-Z]", "");

            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        return wordCount;
    }

    private static void displayResults(Map<String, Integer> wordCount) {
    //Display the file contents
    for (Map.Entry<String,Integer> entry : wordCount.entrySet())  
    System.out.println("Key = " + entry.getKey() + 
                     ", Value = " + entry.getValue()); 
} 
    }

