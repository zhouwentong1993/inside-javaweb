package com.puhui.generic;

/**
 * Created by wentong on 2016/7/30.
 * 栈结构
 */
public class LinkedStack<T> {

    private static class Node<U> {
        U item; // 值
        Node<U> next; // 下一个节点

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        public Node() {
            this.item = null;
            this.next = null;
        }

        boolean end() {
            return (next == null) && (item == null);
        }
    }

    private Node<T> top = new Node<>();

    private void push(T item) {
        top = new Node<>(item, top);
    }

    private T pop() {
        if (top.end()) {
            throw new RuntimeException("stack is empty!");
        }
        T result = top.item;
        top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("forth");
        stack.push("fifth");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
