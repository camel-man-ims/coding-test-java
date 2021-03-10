package inflearn_lecture.structures;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.empty());
        System.out.println(stack.isEmpty());

        System.out.println(stack);
    }
}
