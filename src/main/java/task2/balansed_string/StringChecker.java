package task2.balansed_string;

import lombok.NonNull;
import task2.stack.ArrayStack;
import task2.stack.IStack;

import java.util.HashMap;
import java.util.Map;

public class StringChecker {

    static Map<Character, Character> braces;

    static {
        braces = new HashMap<>();
        braces.put('(', ')');
        braces.put('[', ']');
        braces.put('{', '}');
    }

    @NonNull
    public static boolean isStringBalanced(String string) {
        IStack<Character> stack = new ArrayStack<>();
        char[] characters = string.toCharArray();

        if (characters.length == 0) return true;
        for (char currentCharacter : characters) {
            for (Map.Entry entry : braces.entrySet()) {
                char openBrace = (char) entry.getKey();
                char closeBrace = (char) entry.getValue();
                if (currentCharacter == openBrace) {
                    stack.push(currentCharacter);
                }
                if (currentCharacter == closeBrace) {
                    if (stack.isEmpty()) return false;
                    else if (stack.peek() == openBrace) {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
