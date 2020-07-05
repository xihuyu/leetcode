package stack;

/**
 * @ClassNameStackCaculator
 * @Description 用栈模拟计算器
 * @Author fenggaopan
 * @Date2020/7/4 9:40 下午
 * @Version V1.0
 **/
public class StackCaculator {

    public static void main(String[] args) {

        //表达式
        String expression = "30+2*6-2";

        //创建两个栈数栈，符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);


        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //每次扫描的char
        String temp = ""; //拼接多位数

        //while循环扫描
        while(true) {
            //得到每一个字符
            ch = expression.substring(index , index +1).charAt(0);
            if(operStack.isOper(ch)) {
                //如果是运算符，判读符号栈是否为空，
                if(operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    //不为空
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //运算结果入数栈
                        numStack.push(res);
                        //当前操作符入符号栈
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                }
            } else {
                //如果是数栈直接入栈,ascll码
                //多位数不能直接入栈
                //处理多位数需要向表达式index后再看一位，如果是数，继续扫描，符号才入栈
                //多位数
                temp += ch;

                //如果是最后一位，直接入栈
                if(index == expression.length() -1) {
                    numStack.push(Integer.parseInt(temp));
                } else {
                    //判断下一个是否是数字是继续扫描，运算符直接入数栈
                    //如果字符
                    if(operStack.isOper(expression.substring(index +1, index +2).charAt(0))) {
                        numStack.push(Integer.parseInt(temp));
                        temp = "";
                    }
                }

            }

            //让index+1，并判断是否扫描到最后
            index ++;
            if(index >= expression.length()) {
                break;
            }
        }


        //当扫描完毕后，数栈和符号栈计算，最后留在栈中的数就是结果
        while(true) {
            if(operStack.isEmpty()) {
                break;
            }

            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            //运算结果入数栈
            numStack.push(res);
        }

        //拿到最终的结果
        System.out.println("表达式最后的结果为:" + numStack.pop());
    }
}

class ArrayStack2 {
    private int maxSize; //栈的大小
    private int[] stack; //数组模拟
    private int top = -1; //栈顶

    public ArrayStack2(int maxSize) {
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

    /**
     * 获取栈顶元素，但是不弹出
     * @return
     */
    public int peek() {
        if(isEmpty()) {
            System.out.println("栈为空，不能出栈");
        }
        int value = stack[top];
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

    //返回运算符的优先级，优先级是程序员确定，数字大优先级高
    public int priority(int oper) {
        if(oper == '*' || oper == '/') {
            return 1;
        } else if(oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; //假定只有+,-,*,/
        }
    }

    /**
     * 判断是否是运算符
     * @param val
     * @return
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+' :
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; //注意顺序
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num1 / num2;
                break;
        }

        return res;
    }
}
