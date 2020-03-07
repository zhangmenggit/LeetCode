package com.zzm.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zhangmeneg
 * @date: 2020/3/7 22:14
 * @Description:
 */
public class InterviewQuestion59 {

    Queue<Integer> queue;
    Deque<Integer> deque;

    public InterviewQuestion59() {
        //队列,插入和删除
        queue = new LinkedList<>();
        //双端队列,获取最大值
        deque = new LinkedList<>();
    }

    public int max_value() {
        //双端队列的队首为queue的最大值
        return deque.size()>0?deque.peek():-1;
    }

    public void push_back(int value) {
        //value入队
        queue.offer(value);
        //将deque队尾小于value的元素删掉
        while (deque.size()>0 && deque.peekLast()<value) {
            deque.pollLast();
        }
        //将value放在deque队尾
        deque.offerLast(value);
    }

    public int pop_front() {
        int tmp = queue.size()>0?queue.poll():-1;
        if (deque.size()> 0 && tmp == deque.peek()) {
            //如果出队列的元素是当前最大值，将deque的队首删除
            deque.poll();
        }
        return tmp;
    }



}
