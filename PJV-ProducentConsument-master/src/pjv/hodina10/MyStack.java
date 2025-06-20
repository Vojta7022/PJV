package pjv.hodina10;

public class MyStack implements Stack {
    private String[] stack;
    private int top;
    private final int size;

    public MyStack(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
    }

    public synchronized void push(String value) throws InterruptedException {
        while (top == size - 1) {
            wait();
        }
        stack[++top] = value;
        notifyAll();
    }

    @Override
    public void add(String word) {
        try {
            push(word);
        } catch (InterruptedException ex) {
            System.out.println("Error while adding to stack: " + ex.getMessage());
        }
    }

    public synchronized String pop() throws InterruptedException {
        while (top == -1) {
            wait();
        }
        String value = stack[top--];
        notifyAll();
        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
