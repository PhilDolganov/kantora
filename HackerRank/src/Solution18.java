import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution18 {

    Queue<Character> queue;
    Stack<Character> stack;


    Solution18() {
        this.queue = new LinkedList<Character>();
        this.stack = new Stack<Character>();
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution18 p = new Solution18();

        // Enqueue/Push all characters to their respective data structures:
        for (char c : s){
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }
        // Pop/Dequeque the characters at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }
        //Finally, print whether string s is palindrome or nt.
        System.out.println("The word, " + input + ", is " + ((!isPalindrome)? "not a palindrome." : "a palindrome"));
    }

    char popCharacter() {
        return this.stack.pop();
    }

    char dequeueCharacter() {
        return  this.queue.remove();
    }

    void enqueueCharacter(char ch) {
        this.queue.add(ch);
    }

    void pushCharacter(char ch) {
        this.stack.push(ch);
    }
}
