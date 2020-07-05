package stack;

/**
 * 使用数组模拟栈
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        //测试栈
        ArrayStack stack = new ArrayStack(5);

        //入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.list();

        System.out.println("出栈一个元素.....");
        stack.pop();

        stack.list();
    }


}

//栈
class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack; //数组模拟
    private int top = -1; //栈顶

    public ArrayStack(int maxSize) {
        stack = new int[maxSize];

    }

    /**
     * 判断栈满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param num
     */
    public void push(int num) {
        //判断是否满
        if(isFull()) {
            System.out.println("栈满了，不能放入元素了");
        }
        top ++;
        stack[top] = num;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if(isEmpty()) {
            System.out.println("栈为空，不能出栈");
        }
        int value = stack[top];
        top --;
        return value;
    }


    //遍历
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据....");
            return ;
        }
        for(int i=top; i>=0;i--) {
            System.out.println(stack[i]);;
        }
    }


}
