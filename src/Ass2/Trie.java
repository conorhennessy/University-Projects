import java.util.*;

class Trie {
    // Trie implemented by HashMap approach, please see to class and constructor at the bottom
    // Each node contains a different letter
    // Each node has references to the children nodes associated with itself, stored in HashMap.
    // Also contains a boolean vale to say if current node is end of word.

    private TrieNode root;
    
    /**
     * A constructor which initialises the trie to be empty
     * Does so by calling constructor where root will be a new empty node.
     */
    private Trie() {
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
    private boolean addWord(String word) {
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
            HashMap<Character, TrieNode> children = root.getChildren();

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

                children = node.getChildren();
                if (i == word.length() - 1) { // Part 2
                    // Word is complete, set boolean flag to true and loop will be ending after this executes
                    node.setWord(true);
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * A method to check if a word is present in the trie
     * @param word is a supplied String which will be sought from the Trie
     * @return true  : if word is found
     *         false : if word is not found in trie
     */
    private boolean find(String word) {
        word = word.toUpperCase();
        TrieNode node;

        HashMap<Character, TrieNode> children = root.getChildren();

        for (int i = 0; i < word.length(); i++) {
            if (children.containsKey(word.charAt(i))) {
                // If the children of current node has the right character, step into it
                node = children.get(word.charAt(i));
                children = node.getChildren();
                if ((i == word.length() - 1) && node.getWordState()){
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * A method that returns a list of all words in the trie that begin
     * with the letter specified by the argument, sorted alphabetically.
     * THIS HAS NOT BEEN FULLY IMPLEMENTED
     * @param c is the initial character which will be sought for.
     * @return a list of words found, sorted alphabetically.
     *         If no words with the specific letter are found an empty list is returned
     */
    private List<String> getWords(char c) {
        c = Character.toUpperCase(c);
        List<String> words = new ArrayList<>();

        if (!Character.isLetter(c)) {
            // If word supplied does not contain only letter characters - output and return false!
            System.out.println("ERROR: Character supplied" + c + "is a non-letter!");
        } else {
            if (!root.getChildren().containsKey(c) || root == null) {
                // First children of trie does not contain the letter supplied, so no words can exist
                System.out.println("ERROR: Trie does not contain any words starting with\"" + c + "\"!");
                return words;
            }
            if (!String.valueOf(c).matches("[a-zA-Z]+")) {
                System.out.println("ERROR: String supplied contains non-letters!");
                return words;
            } else {
                TrieNode node = root;
                HashMap<Character, TrieNode> children = root.getChildren();
                String word = "";

                //getWords not fully implemented.
                System.out.println("getWords() not fully implemented.");
                return words;
            }
        }
        Collections.sort(words);
        return words;
    }

    /**
     *  This should be a delete method but as I was unable to complete the method I have removed what I have done.
     *  Thus, the method just outputs a relevant method and returns false.
     *  THIS HAS NOT BEEN FULLY IMPLEMENTED
     *
     * @param word
     * @ false as method not complete
     */
    public boolean delete(String word) {
        word = word.toUpperCase();
        if (!word.matches("[A-Z]+")) {
            // If word supplied does not contain only letter characters - output and return false!
            System.out.println("ERROR: Word supplied" + word + "contains non-letter characters!");
            return false;
        } else {
            System.out.println("Delete() not fully implemented.");
            return false;
        }
    }

}


/**
 *  Class for the construction of Trie objects
 *  Implemented using a hash map approach
 *  Node Attributes: Character - the character of the specific node
 *                   Children - what other nodes is this node associated with, stored in a HashMap
 *                   Word - a boolean value to state if the current node is the end of a word.
 */
class TrieNode {
    private Character character;
    private HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    private Boolean word;

    TrieNode() {
    }

    TrieNode(Character c) {
        this.character = c;
        word = false;
    }

    /**
     * Various helper methods which are self explanatory.
     * They either get or set the respective attributes to the objects.
     * @return the corresponding values.
     */
    public boolean getWordState() {
        return this.word;
    }

    public void setWord(Boolean b) {
        this.word = b;
    }

    public HashMap<Character, TrieNode> getChildren(){
        return this.children;
    }
}
