//importing required libraries

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        //Creating a scanner object
        Scanner scanner = new Scanner(System.in);
        String input;
        //A do-while loop to keep prompting user for input
        do {
            //Printing the options
            System.out.println("Select an option:");
            System.out.println("a. Convert a string to uppercase");
            System.out.println("b. Reverse a string");
            System.out.println("c. Count the number of vowels in a string");
            System.out.println("d. Count the number of words in a string");
            System.out.println("e. Convert a string to title case");
            System.out.println("f. Check if a string is a palindrome");
            System.out.println("g. Find the longest word in a string");
            System.out.println("h. Find the shortest word in a string");
            System.out.println("i. Find the most frequent word in a string");
            System.out.println("j. Perform all options");
            System.out.println("q. Quit");
            //Taking the input from user
            String choice = scanner.nextLine().toLowerCase();
            //A switch case to perform operations based on the user's input
            switch (choice) {
                //Convert a string to uppercase
                case "a" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("This is the string you entered converted to uppercase :  " +
                            input.toUpperCase());
                }
                //Reverse a string
                case "b" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("This is the reversed string : " + reverseStr(input));
                }
                //Count the number of vowels in a string
                case "c" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("This is the number of vowels contained in the string you entered : " +
                            countVowels(input));
                }
                //Count the number of words in a string
                case "d" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("This is the number of words contained in the string you entered : " +
                            countWords(input));
                }
                //Convert a string to title case
                case "e" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("This is the string converted to title case :  " + StrToTitleCase(input));
                }
                //Check if a string is a palindrome
                case "f" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("It is a palindrome = " + isPalindrome(input));
                }
                //Find the longest word in a string
                case "g" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("The longest word in the string is " + findLongestWord(input));
                }
                //Find the shortest word in a string
                case "h" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("The shortest word in the string is " + findShortestWord(input));
                }
                //Find the most frequent word in a string
                case "i" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("The most frequent word in the string is " + findMostFrequentWord(input));
                }
                //Perform all options on a string
                case "j" -> {
                    System.out.print("Enter a string: ");
                    input = scanner.nextLine();
                    System.out.println("This is the string you entered converted to uppercase :  " +
                            input.toUpperCase());
                    System.out.println("This is the reversed string : " + reverseStr(input));
                    System.out.println("This is the number of vowels contained in the string you entered : " +
                            countVowels(input));
                    System.out.println("This is the number of words contained in the string you entered : " +
                            countWords(input));
                    System.out.println("This is the string converted to title case :  " + StrToTitleCase(input));
                    System.out.println("It is a palindrome = " + isPalindrome(input));
                    System.out.println("The longest word in the string is " + findLongestWord(input));
                    System.out.println("The shortest word in the string is " + findShortestWord(input));
                    System.out.println("The most frequent word in the string is " + findMostFrequentWord(input));

                }
                //Quit the program
                case "q" -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                //Invalid choice
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (true);
    }

    /**
     * the method reverseStr performs the reverse operation on the given string by using the StringBuilder class method
     * reverse()
     *
     * @param inputString is the string we want to reverse
     * @return the sb StringBuilder object containing the reversed string str
     */
    public static String reverseStr(String inputString) {
        StringBuilder sb = new StringBuilder(inputString);
        sb.reverse();
        return sb.toString();
    }

    /**
     * the method countVowels converts the given string to a char array and determines by comparison the number of
     * vowels present in the given string
     *
     * @param inputString is the string we perform the vowels counting on
     * @return count representing the number of vowels contained in the string
     */
    public static int countVowels(String inputString) {
        int count = 0;
        for (char c : inputString.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    /**
     * the method countWords uses the split() function to add all the words separated by whitespace
     * to an array of strings and then returns the length of the array
     *
     * @param inputString is the string we try to find the number of words contained in
     * @return the length of the words array
     */
    public static int countWords(String inputString) {
        String[] words = inputString.split(" ");
        return words.length;
    }

    /**
     * the method StrToTitleCase uses a for loop to iterate through the inputString converted to a char array and
     * whenever a char is preceded by a white space it is converted to uppercase , the rest of the chars are converted
     * to lowercase if the condition is not met and after each iteration the current verified char is appended to the
     * StringBuilder object titleCase
     *
     * @param inputString is the string we want to be converted to title case
     * @return the inputString converted to title case
     */
    public static String StrToTitleCase(String inputString) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : inputString.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }

    /**
     * the method isPalindrome iterates through inputString from the start and the end at the same time to determine
     * whether it is a palindrome or not. A string is called a palindrome string if the reverse of that string is
     * the same as the original string
     *
     * @param inputString is the string we want to check
     * @return true or false
     */
    public static boolean isPalindrome(String inputString) {
        inputString = inputString.toLowerCase();
        int i = 0, j = inputString.length() - 1;

        while (i < j) {
            if (inputString.charAt(i) != inputString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    /**
     * the findLongestWord method splits the string by white spaces, adds them to an array of strings, then iterates
     * through it and compares each word to the longestWord string which is declared as null. Every time a longer
     * word is found it becomes longestWord
     *
     * @param inputString is the string from which we want to extract the longest word
     * @return the longest word in the string
     */
    public static String findLongestWord(String inputString) {
        String[] words = inputString.split(" ");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    /**
     * the findShortestWord method splits the string by white spaces, adds them to an array of strings, then iterates
     * through it and compares each word to the shortestWord string which is declared as null. At first iteration, the
     * first word that is compared with shortestWord becomes shortestWord. After that if a shorter word is found it
     * becomes shortestWord until the iteration ends
     *
     * @param inputString is the string from which we want to extract the shortest word
     * @return the shortest word in the string
     */
    public static String findShortestWord(String inputString) {
        String[] words = inputString.split(" ");
        String shortestWord = "";

        for (String word : words) {
            if (shortestWord.length() == 0 || word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }

        return shortestWord;
    }

    /**
     * the findMostFrequent method first splits the inputString by white spaces and adds the words to an array of
     * strings, then populates a hash map with the words obtained and assigns each key word an integer value,
     * incremented on each apparition of the word in the string array. At last the hash map is iterated through
     * and the key word with the biggest integer value is set as the mostFrequentWord
     *
     * @param inputString is the string from which we want to extract the most frequent word
     * @return the most frequent word in the given string
     */
    public static String findMostFrequentWord(String inputString) {
        String[] words = inputString.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        String mostFrequentWord = "";
        int highestCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > highestCount) {
                mostFrequentWord = word;
                highestCount = count;
            }
        }
        return mostFrequentWord;
    }
}
