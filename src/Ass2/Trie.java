import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {
    // Trie implemented by HashMap approach, please see to class and constructor at the bottom
    // Each node contains a different letter
    // Each node has references to the children nodes associated with itself, stored in HashMap.
    // Also contains a boolean vale to say if current node is end of word.

    public TrieNode root;


    /**
     * Constructor which initialises the trie to be empty
     * Does so by calling constructor where root will be a new empty node.
     */
    public Trie() {
        root = new TrieNode();
    }


    /**
     * A method to add a word to the trie.
     *
     * @param word is a supplied String which will be added to the trie
     * @return true  : if successfully added to Trie
     *         false : if the word is already present
     *                 if the supplied String (@param word) does not contain only letters.
     */
    public boolean addWord(String word) {
        word = word.toUpperCase();

        if (!word.matches("[A-Z]+")) {
            // If word supplied does not contain only letter characters - output and return false!
            System.out.println("ERROR: String supplied" + word.toLowerCase() + "contains non-letters!");
            return false;
        }
        if (find(word)) {
            // If word is already present in Trie - return false!
            return false;
        } else {
            HashMap<Character, TrieNode> children = root.children;

            for (int i = 0; i < word.length(); i++) {
                TrieNode node;

                if (children.containsKey(word.charAt(i))) {
                    // Children contain the letter so step into this node of the children
                    node = children.get(word.charAt(i));
                } else {
                    //if  children does not contain the letter - add it and step into it
                    node = new TrieNode(word.charAt(i));
                    children.put(word.charAt(i), node);
                }

                children = node.children;
                if (i == word.length() - 1) {
                    // Word is complete, set boolean flag to true and loop will be ending after this executes
                    node.word = true;
                    return true;
                }
            }
            return false;
        }
    }


    private boolean find(String word) {
        word = word.toUpperCase();
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node;

        for (int i = 0; i < word.length(); i++) {
            if (children.containsKey(word.charAt(i))) {
                node = children.get(word.charAt(i));
                children = node.children;
            } else {
                return false;
            }
        }
        return true;
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

        testTrie.addWord("apple");
        testTrie.addWord("grape");
        testTrie.addWord("orange");
        testTrie.addWord("fish");

        System.out.println(testTrie.find("grape"));
        System.out.println(testTrie.find("pineapple"));

        //System.out.println(testTrie.getWords('o'));

        System.out.println(testTrie.root.children);
    }

}

class TrieNode {
    Character character;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    Boolean word;

    TrieNode() {
    }

    TrieNode(Character c) {
        // Trie implemented by HashMap approach
        // Each node contains a different letter
        // Each node has references to the children nodes associated with itself, stored in HashMap.
        // Also contains a boolean vale to say if current node is end of word.
        this.character = c;
        word = false;
    }
}
