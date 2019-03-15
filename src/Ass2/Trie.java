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
        root = new TrieNode(null);
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
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                if (node.children == null) {
                    //if tree is empty, if so just add it and step into it
                    root.children.put(word.charAt(i), new TrieNode<>(word.charAt(i)));
                    node = (TrieNode) node.children.get(word.charAt(i));
                } else if (!node.children.containsKey(word.charAt(i))) {
                    // Children do not contain the letter so add letter to the children of this node and step into it
                    node.children.put(word.charAt(i), new TrieNode<>(word.charAt(i)));
                    node = (TrieNode) node.children.get(word.charAt(i));
                } if (i == word.length() - 1){
                    // Word is complete, loop will be ending after this executes so set boolean flag to true
                    node.word = true;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children.containsKey(word.charAt(i))) {
                if (i == word.length() - 1) {
                    return true;
                }
                node = (TrieNode) node.children.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return false;
    }

    public List<String> getWords(char c) {
        List<String> words = new ArrayList<>();

        if (!root.children.containsKey(c)) {
            // First children of trie does not contain the letter supplied, so no words can exist
            System.out.println("ERROR: Trie does not contain any words starting with\"" + c + "\"!");
            return words;
        }
        if (!String.valueOf(c).matches("[a-zA-Z]+")) {
            System.out.println("ERROR: String supplied contains non-letters!");
            return words;
        } else {
            TrieNode node = root;

            //TODO
        }

        return words;
    }


    public static void main(String[] args) {
        Trie testTrie = new Trie();
        testTrie.addWord("pineapple");
        System.out.println(testTrie.root.children);
    }

}

class TrieNode<Character> {
    Character character;
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    Boolean word;

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
