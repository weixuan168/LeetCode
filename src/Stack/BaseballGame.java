package Stack;

import java.util.Stack;

/**
 * Created by Xuan on 2017/11/30.
 * 第682题 篮球记分员，输出总分
 * 规则： Integer：本局实得分数
 * +  ：本局得分为前两局分数之和
 * D  ：本局得分为上一局分数的两倍
 * C  ：上一局得分无效，移除
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("+")) {
                int top = stack.pop();
                int thisPoint = top + stack.peek();
                stack.push(top);
                stack.push(thisPoint);
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        int sum=0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        BaseballGame baseballGame = new BaseballGame();
        System.out.println(baseballGame.calPoints(ops));
    }
}
