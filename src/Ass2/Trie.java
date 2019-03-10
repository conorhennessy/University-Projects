import java.util.List;

public class Trie {
    // Trie implemented by left-child, right-sibling approach
    // Each node contains a different letter and following a left-child, right-sibling implementation.
    // Each node has references to the child nodes associated with itself.


    /**
     * Constructor which initialises the trie to be empty
     * Does so by calling constructor where root will be null.
     */
    private TrieNode<Character> root;

    public Trie() {
        root = null;
    }


    /**
     * Method which attempts to add the supplied word to the Trie.
     * But first checks if the word supplied contains non-letter characters, checked by use of a reg expression check.
     * Then checks if word supplied is already present in the Trie, checked by using the find() method created for this assignment.
     * @param word
     * @return true, if word is added successfully.
     *         false, if word cannot be added or if supplied @param word contains non-letters
     */
    public boolean addWord(String word){
        word = word.toUpperCase();
        if (!word.matches("^.*[^a-zA-Z].*$")){
            System.out.println("ERROR: String supplied contains non-letters!");
            return false;
        }
        if (find(word)){
            return false;
        }
        else {
            //Checks are complete, now try adding word to Trie
            List<TrieNode<Character>> n = root.children;
            int i = 0;

            while (n != null){
                for (TrieNode<Character> child : n){
                    char childChar = child.data;
                    n.contains(word)
                    if (childChar == word.charAt(i)){
                        // want to progress further in tree
                        n = child.children;

                    }
                }
                i++;
            }

/*
            if (root.left == null || root.right == null){  // If Trie empty, start node with char
                root.left = new TrieNode<>(word.charAt(0));
            } else {
                // Word is able to exist in this Trie so progress

                TrieNode<Character> n = root.left;
                int i = 0;
                while(n != null){
                    if (n.data == word.charAt(i)){
                        if (n.left.data == word.charAt(i)){
                            n = n.left;
                        } else if (n.left.data == word.charAt(i)){
                            n = n.right;
                        } else {
                            n.left.data = word.charAt(i);
                        }
                    }
                    else {
                        System.out.println("oooops");
                    }
                    i++;
                }

            }*/


            return true; //TODO this needs to be moved to where the word is created
        }
    }

    public boolean find(String word){
        return false;
    }

    public List<String> getWords(char c){
        List<String> words = null;



        return words;
    }
}

class TrieNode<T> {
    T data;
    List<TrieNode<T>> children;
    Boolean word;

    TrieNode(T o) {
        // Trie implemented by left-child, right-sibling approach
        // Each node contains a different letter and following a left-child, right-sibling implementation.
        // Each node has references to the children nodes associated with itself.
        // Also contains a boolean vale to say if node is end of word.
        data = o;
        children = null;
        word = false;
    }
}
