import java.io.File;
import java.io.IOException;
import java.util.*;

/*
In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of
elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the last
element that was added.

A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are
correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
Given a string, determine if it is balanced or not.

INPUT:
There will be multiple lines in the input file, each having a single non-empty string. You should read input till
end-of-file.
The part of the code that handles input operation is already provided in the editor.

    {}()
    ({()})
    {}(
    []

OUTPUT:
For each case, print 'true' if the string is balanced, 'false' otherwise.

    true
    true
    false
    true

 */
public class Solution {

    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        Stack<Character> stack = new Stack<>();

        boolean parenthesis;
        boolean bracket;
        boolean curly;

        while(sc.hasNext()) {
            parenthesis = false;
            bracket = false;
            curly = false;

            String input = sc.next();
//            System.out.println(input);
            for(int i = 0; i < input.length(); i++){
                stack.push(input.charAt(i));
            }
//            System.out.println("Size: " + stack.size());
            if (stack.size() % 2 == 0) {
                if (stack.search('(') == -1 && stack.search(')') == -1)
                    parenthesis = true;
                if (stack.search('{') == -1 && stack.search('}') == -1)
                    curly = true;
                if (stack.search('[') == -1 && stack.search(']') == -1)
                    bracket = true;

                while (!stack.empty()) {
                    char point = stack.pop();
                    if (point == ')') {
//                    System.out.println("found parenthesis");
                        if (stack.search('(') > -1 && stack.search('(') % 2 != 0) {
                            parenthesis = true;
//                            System.out.println("p: " + stack.search('('));
                        } else
                            parenthesis = false;
                    }
                    if (point == ']') {
                        if (stack.search('[') > -1 && stack.search('[') % 2 != 0) {
                            bracket = true;
//                            System.out.println("b: " + stack.search('['));
                        } else
                            bracket = false;
                    }
                    if (point == '}') {
                        if (stack.search('{') > -1 && stack.search('{') % 2 != 0) {
                            curly = true;
//                            System.out.println("c: " + stack.search('{'));
                        } else
                            curly = false;
                    }
                }
                System.out.println(parenthesis && bracket && curly);
            } else {
                while (!stack.empty())
                    stack.pop();
                System.out.println("false");
            }
        }
    }
}
