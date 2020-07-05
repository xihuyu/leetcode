package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassNamePolandNotation
 * @Description 逆波兰表达式
 * @Author fenggaopan
 * @Date2020/7/5 8:52 下午
 * @Version V1.0
 **/
public class PolandNotation {

    public static void main(String[] args) {
        //定义波兰表达式
        //(3+4)*5 - 6 =>3 4 + 5 * 6 -
        String expression = "3 4 + 5 * 6 -";

        //1.先将express放入arraylist
        List<String> stringList = getList(expression);
        System.out.println(stringList);
        //2.arraylist和栈结合
        Integer result = getSum(stringList);
        System.out.println("最后计算结果为:" + result);
    }

    //将逆波兰表达式依次将数据和运算符放入list
    public static List<String> getList(String expression) {
        //将字符串分割
        String[]  split = expression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String element : split) {
            list.add(element);
        }
        return list;
    }

    /**
     * 计算
     * @param express
     * @return
     */
    public static int getSum(List<String> express) {
        Stack<String> stack = new Stack<String>();
        //遍历
        for(String item: express) {
            //这里使用正则表达式取出数
            //匹配多位数
            if(item.matches("\\d+")) {
                //入栈
                stack.push(item);
            } else {
                //pop出两个数，并运算
                //然后入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")) {
                    res = num1 + num2;
                } else if(item.equals("-")) {
                    res = num1 - num2;
                } else if(item.equals("*")) {
                    res = num2 * num1;
                } else if(item.equals("/")) {
                    res = num1 /num2;
                } else {
                    throw new RuntimeException("输入有误");
                }
                stack.push("" + res);
            }
        }
        //最后保持的就是最终的结果
        return Integer.parseInt(stack.pop());
    }
}
