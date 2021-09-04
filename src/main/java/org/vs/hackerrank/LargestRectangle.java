package org.vs.hackerrank;

import java.util.List;
import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        List<Integer> list = List.of(11, 11, 10, 10, 10);
        System.out.println(largestRectangle1(list));
    }

    public static long largestRectangle(List<Integer> h) {
        //To keep track of max area
        long maxArea = 0;

        for (int i = 0; i < h.size(); i++) {
            //increase the width until next building is greater than current's building area, else break
            int k = i + 1;
            while (k < h.size() && h.get(k) >= h.get(i)) {
                k++;
            }

            //increase the width until previous building is greater than current's building area, else break
            int j = i - 1;
            while (j >= 0 && h.get(j) >= h.get(i)) {
                j--;
            }

            int width = k - j - 1;
            int area = h.get(i) * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static long largestRectangle1(List<Integer> heightList) {
        //list to hold stack of heights
        Stack<Integer> heightStack = new Stack<>();
        //list to hold stack of height indexes
        Stack<Integer> indexStack = new Stack<>();

        int maxArea = 0;
        int top = 0;

        int size = heightList.size();

        for (int i = 0; i < size; i++) {
            int height = heightList.get(i);

            //if height stack is empty or height is greater than last element in stack then push to stack
            if (heightStack.isEmpty() || height > heightStack.peek()) {
                heightStack.push(height);
                indexStack.push(i);
            } else {

                //if height is smaller than last element of height stack then keep popping
                while (!heightStack.isEmpty() && height < heightStack.peek()) {
                    Integer pop = heightStack.pop();
                    top = indexStack.pop();
                    int area = pop * (i - top);
                    maxArea = Math.max(maxArea, area);
                }

                if (heightStack.isEmpty() || height != heightStack.peek()) {
                    heightStack.push(height);
                    //retain index of last popped element
                    indexStack.push(top);
                }
            }
        }


        while (!heightStack.isEmpty()) {
            Integer pop = heightStack.pop();
            int area = pop * (size - indexStack.pop());
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
