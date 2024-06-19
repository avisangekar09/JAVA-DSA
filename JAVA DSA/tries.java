//import org.w3c.dom.Node;
//import java.util.*;
class Node {
    Node[] children;
    boolean eow;
    int count_word;
    int count_pre;
    public Node() {
    children = new Node[26];
    for (int i = 0; i < 26; i++) {   
    children[i] = null;   
    }
    
    eow = false;  
    count_word = 0; 
    count_pre = 0; 
    }  
    }
    
public class tries {
    // static class Node{
    //     Node[] children;// = new Node[26];
    //     boolean eow;

    //     public Node(){
    //         // for(int i=0;i<26;i++){
    //         //     children[i] = null;
    //         // }
    //         children = new Node[26];
    //         eow = false;
    //     }
    // }

//Node root;

public tries() {

root = new Node();

}
    public static Node root = new Node();

    public static void insert(String word){
        int len = word.length();
        int idx = 0;
        Node curr = root;
        for(int i=0;i<len;i++){
              idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
                
            }
            curr = curr.children[idx];

        }
        curr.eow = true;
    }

    public static boolean search(String key){
        int len = key.length();
        int idx = 0;
        Node curr = root;
        for(int i=0;i<len;i++){
            idx = key.charAt(i) - 'a';

            if(curr.children[idx] == null) return false;

            curr = curr.children[idx];
        }
        return curr.eow==true;
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.       
        Node temp = root;       
        for (int i = 0; i < word.length(); i++) {      
        if (temp.children[word.charAt(i) - 'a'] == null)
        
        return 0;
        
        temp = temp.children[word.charAt(i) - 'a'];
        
        }
        
        // this was causing 7/10 tc pass only, I was returning temp.count directly
        
        if(temp.eow == true)
        
        return temp.count_word;
        
        return 0;
        
        }
        
         
        
        public int countWordsStartingWith(String word) {
        
        // Write your code here.
        
        Node temp = root;
        
        for (int i = 0; i < word.length(); i++) {
        
        if (temp.children[word.charAt(i) - 'a'] == null)
        
        return 0;
        
        temp = temp.children[word.charAt(i) - 'a'];
        
        }
        
        return temp.count_pre;
        
        }
        
         
        
        public void erase(String word) {
        
        // Write your code here.
        
        Node temp = root;
        
        for (int i = 0; i < word.length(); i++) {
        
        temp = temp.children[word.charAt(i) - 'a'];
        
        temp.count_pre--;
        
        }
        
        temp.count_word--;
        
        if(temp.count_word == 0)
        
        temp.eow = false;
        
        }
        
    public static void main(String args[]){
        String words[] = {"the","a","there","their","thee","any"};

        for(String word : words){
            insert(word);
            System.out.println("inserted word : " + word);
        }

        System.out.println("all inserted succeefully");

        System.out.println("thee = "+ search("thee"));
        System.out.println("thor = "+search("thor"));
    }
}
