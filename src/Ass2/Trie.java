import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {
    // Trie implemented by left-child, right-sibling approach
    // Each node contains a different letter and following a left-child, right-sibling implementation.
    // Each node has references to the child nodes associated with itself.


    /**
     * Constructor which initialises the trie to be empty
     * Does so by calling constructor where root will be null.
     */
    private TrieNode<Character> root;

    private Trie() {
        root = new TrieNode();
    }


    private boolean addWord(String word) {
        word = word.toUpperCase();
        if (!word.matches("[A-Z]+")) {
            System.out.println("ERROR: String supplied contains non-letters!");
            return false;
        }
        if (find(word)) {
            // word already exists in trie, so will not be added and return false
            return false;
        } else {
            //Checks are complete, now try adding word to Trie
            TrieNode node = null;
            HashMap<Character, TrieNode> children = root.children;

            for (int i = 0; i < word.length(); i++) {
                if (node.children == null) {
                    //if tree is empty, if so just add it and step into it
                    root.children.put(word.charAt(i), new TrieNode<>(word.charAt(i)));
                    node = (TrieNode) node.children.get(word.charAt(i));
                } else if (children.containsKey(word.charAt(i))) {
                    // Children do not contain the letter so add letter to the children of this node and step into it
                    node.children.put(word.charAt(i), new TrieNode<>(word.charAt(i)));
                    node = children.get(word.charAt(i));
                }
                if (i == word.length() - 1) {
                    // Word is complete, loop will be ending after this executes so set boolean flag to true
                    node.word = true;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(String word) {
        word = word.toUpperCase();

        HashMap<Character, TrieNode> children = root.children;

        TrieNode node = null;

        for (int i = 0; i < word.length(); i++) {
            if (children.containsKey(word.charAt(i))) {
                node = children.get(word.charAt(i));
                children = node.children;
            } else {
                node = null;
            }
        }
        return 
    }



    public List<String> getWords(char c) {
        c = Character.toUpperCase(c);
        List<String> words = null;

        if (!root.children.containsKey(c) || root == null) {
            // First children of trie does not contain the letter supplied, so no words can exist
            System.out.println("ERROR: Trie does not contain any words starting with\"" + c + "\"!");
            return words;
        }
        if (!String.valueOf(c).matches("[a-zA-Z]+")) {
            System.out.println("ERROR: String supplied contains non-letters!");
            return words;
        } else {
            TrieNode node = root;
            String word = "";
            if (node.children.containsKey(c)) {
                word += c;
                node = (TrieNode) node.children.get(c);
                if (node.word) words.add(word);
            }
        }
        return words;
    }


    public static void main(String[] args) {
        Trie testTrie = new Trie();
        testTrie.addWord("pineapple");
        testTrie.addWord("apple");
        testTrie.addWord("orange");
        testTrie.addWord("open");

        System.out.println(testTrie.find("pineapple"));

        System.out.println(testTrie.getWords('o'));

        System.out.println(testTrie.root.children);
    }

}

class TrieNode<Character> {
    Character character;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    Boolean word;

    TrieNode() {}

    TrieNode(Character o) {
        // Trie implemented by left-child, right-sibling approach
        // Each node contains a different letter and following a left-child, right-sibling implementation.
        // Each node has references to the children nodes associated with itself.
        // Also contains a boolean vale to say if node is end of word.
        character = o;
        children = new HashMap<>();
        word = false;
    }
}
