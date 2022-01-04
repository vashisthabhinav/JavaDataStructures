package circularqueue;

import java.util.LinkedList;

public class Palindrome {
    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String s) {

//        Using linked list for both the stack and the queue.
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowerCase = s.toLowerCase();//To remove the punctuation.

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {//To ensure other symbols such as '?' etc., are not calculated inside the palindrome.
                queue.addLast(c);
                stack.push(c);
            }
        }
//        Removed punctuation, spaces etc. in the above code.

        while (!stack.isEmpty()) {
//            Iterating through the stack till its empty.
            if (!stack.pop().equals(queue.removeFirst())) {
                /*
                 We are popping one character from the stack and removing one character from the front of  the queue.
                 The stack will be reading the string from right to left and queue from left to right.
                 So, if on each iteration, the character we pop and the character we remove are equal, then it is a palindrome otherwise not.
                */
                return false;
            }
        }

        return true;
    }

}
