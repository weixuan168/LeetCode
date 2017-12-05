package Queue;

import java.util.*;

/**
 * Created by Xuan on 2017/12/1.
 * 第621题 给定一个数组代表CPU需要完成的任务，用A~Z来代表不同的任务，任务可以不按原始顺序来执行。
 *        每个任务完成需要一个时间间隔，对于一个时间间隔，CPU要么完成任务，要么空闲。
 *        给定一个非负整数n，CPU完成两个相同任务中间必须要有n个冷却的时间间隔，在这个间隔中CPU可以做
 *        不同的任务或是空闲。
 *      对于给定的任务数组和n，输出CPU所需要的最小总间隔数。
 */
public class TaskScheduler {
    /**
     * 将26个任务按出现频次排序，存到数组中，然后开始分配任务，用一个Int记录间隔数。
     * 每轮分配(n+1)个任务，按照出现次数最多、第二多、第三多...这样的顺序。每分配一个任务，该任务频次自减。
     * 如果一轮中任务不够分配，则Int自增（代表空闲）。
     * 一轮分配完后，重新对频次数组排序，再进行分配。
     * 直到对频次数组排序后，出现最多的次数也为0时，任务结束，返回Int。
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int intervals = 0;
        int[] array = new int[26]; //用来存放26个任务的出现次数
        //数组元素的默认初值都为0
//        for (int i : array) {
//            System.out.print(i + ",");
//            System.out.println();
//        }
        for (char c : tasks) {
            array[c - 'A']++;
        }
        Arrays.sort(array); //对数组元素按升序排序
        while (array[25] > 0) {       //对任务进行分配，直到每轮出现次数最多的任务被分配完（即所有任务被分配完）
            for(int i=0;i<=n;i++) {
                if (array[25] == 0) {
                    break;
                }
                if (i < 26 && array[25 - i] > 0) {
                    array[25 - i]--;
                }
                intervals++;
            }
            Arrays.sort(array);
//            System.out.println("排序");
        }
        return intervals;
    }

    /**
     * 使用优先队列，存放tasks中出现的任务的频次，然后开始分配任务，用一个Int记录间隔数。
     * 根据优先队列的性质，每次出队的都会是当前队列中最大的数。
     * 每轮分配(n+1)个任务，如果队列不为空，则将队头元素与1比较，若比1大，则出队并-1放入list中；否则仅出队。
     * 如果队列为空，则仅自增Int（代表空闲）。
     * 每轮分配结束，将list中的数再放回队列中，进行下一轮分配。
     * 考虑最后一轮的情况，如果队列为空，并且list为空，则说明分配完成。（这就是为什么队头元素不比1大时仅出队而不放入list的原因）
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval2(char[] tasks, int n) {
        int intervals = 0;
        //优先队列如果不指定初始化大小，默认是11；如果不指定排序方式，默认是排成小根堆（每次输出最小值）
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        int[] array = new int[26];
        for (char c : tasks) {
            array[c - 'A']++;
        }
        for (int i : array) {
            if (i > 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        list.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                intervals++;
                i++;
                if (queue.isEmpty() && list.isEmpty()) {
                    break;
                }
            }
            for (int j : list) {
                queue.add(j);
            }
        }
        return intervals;
    }
    public static void main(String[] args) {
        char[] chars = {'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'C', 'C', 'C', 'C', 'D', 'D', 'D', 'D'};
        char[] chars1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        TaskScheduler t = new TaskScheduler();
        System.out.println(t.leastInterval2(chars1, 2));
    }

}
