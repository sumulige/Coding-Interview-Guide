/**
 * Copyright (C), 2015-2019, 中信银行有限公司
 * FileName: MyStack1
 * Author:   willem
 * Date:     2019-09-21 17:24
 * Description: 实现一个特殊栈，实现栈的基本功能上，实现返回栈的最小值。
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sumulige.stack;

import java.util.Stack;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实现一个特殊栈，实现栈的基本功能上，实现返回栈的最小值。〉
 *   第一种设计方案：
 *   设进入的当前数据为newNum 先将其压入到stackData中 再判断stackMin是否为空
 *    * 如果为空直接压入stackMin中
 *    * 如果不为空 需要比较newNum和stackMin哪一个更小
 *      1.如果更小或者相等 则压入stackMin中
 *      2.如果栈顶元素更小 则不做任何操作
 * @author willem
 * @create 2019-09-21
 * @since 1.0.0
 */
public class MyStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        this.stackData.push(newNum);

        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(this.getMin() >= newNum){
            this.stackMin.push(newNum);
        }
    }
    
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("stackData是空的");
        }

        int value = this.stackData.pop();

        if(value  == this.getMin()){
            this.stackData.pop();
        }
        return value;
    }

    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("这个栈为空");
        }
        return this.stackMin.peek();
    }

}
