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

    public Trie() {
        root = new TrieNode(null);
    }


    public boolean addWord(String word){
        word = word.toUpperCase();
        if (!word.matches("[a-zA-Z]+")){
            System.out.println("ERROR: String supplied contains non-letters!");
            return false;
        }
        if (find(word)){
            return false;
        }
        else {
            //Checks are complete, now try adding word to Trie
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++){
                if (node.children == null) {
                    //if tree is empty, if so just add it
                    root.children.put(word.charAt(i), new TrieNode<>(word.charAt(i)));
                } else if (node.children.containsKey(word.charAt(i))){
                    // if children contains letter step into that node
                } else {
                    // else the children do not contain the letter so need to add letter to the children of this node
                    node.children.put(word.charAt(i), new TrieNode<>(word.charAt(i)));
                }
                node = (TrieNode) node.children.get(word.charAt(i));
                if (i == word.length() - 1){
                    // Word is complete, loop will be ending after this executes so set boolean flag to true
                    node.word = true;
                }
            }
            return true;
        }
    }

    public boolean find(String word){
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++){
            if (node.children.containsKey(word.charAt(i))){
                if (i == word.length() - 1){
                    // Letter is found but it's the last letter in word so we are done!
                    return true;
                }
                // Letter is found so step into that node
                node = (TrieNode) node.children.get(word.charAt(i));

            } else {
                return false;
            }
        }
    }

    public List<String> getWords(char c){
        List<String> words = null;



        return words;
    }


    public static void main(String[] args) {
        Trie testTrie = new Trie();
        testTrie.addWord("beast");
        System.out.println(testTrie.root.children);
    }

}
class TrieNode<Character> {
    Character character;
    Map<Character, TrieNode> children;
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
