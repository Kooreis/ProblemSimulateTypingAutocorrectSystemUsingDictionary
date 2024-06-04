Here is a simple console application in Java that simulates a typing autocorrect system using a dictionary. This application uses a Trie data structure to store the dictionary words and perform efficient search operations.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char l: word.toCharArray()) {
            current = current.children.computeIfAbsent(l, c -> new TrieNode());
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char l: word.toCharArray()) {
            TrieNode node = current.children.get(l);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }
}

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("java");
        trie.insert("python");
        trie.insert("javascript");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a word to check (or 'exit' to quit): ");
            String word = scanner.nextLine();
            if (word.equals("exit")) {
                break;
            }
            if (trie.search(word)) {
                System.out.println("The word is correct.");
            } else {
                System.out.println("The word is incorrect. Do you mean...");
                // Here you can implement a suggestion system
            }
        }
        scanner.close();
    }
}
```

This application will keep asking the user to enter a word until the user types 'exit'. If the word is in the dictionary (trie), it will print "The word is correct.". Otherwise, it will print "The word is incorrect. Do you mean...". You can implement a suggestion system at this point.