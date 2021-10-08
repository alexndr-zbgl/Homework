package task_3;

import java.util.Stack;

public class MatrixOperation {




    public MatrixOperation(){

    }


    public static int matrixChallenge(int[][] matrix) {

        int maxArea = 0;
        int[] result = new int[matrix.length];

        for(int i=0; i<matrix.length; i++){

            int[] row = matrix[i];

            for(int j=0; j<row.length; j++){
                if(row[j] == 1)
                    result[j] = result[j] + 1;
                else
                    result[j]= 0;
            }
            maxArea = maxRectangleArea(result, maxArea);
        }

        return maxArea;
    }


    private static int maxRectangleArea(int[] result, int maxArea) {

        Stack<Integer> stack = new Stack<Integer>();

        int i = 0;

        for(; i<result.length;){
            if(stack.isEmpty() || result[stack.peek()] <= result[i]){
                stack.push(i);
                i++;
            }
            else {
                int index = stack.pop();
                int leftBound;
                int rightBound = i;

                if(stack.empty()){
                    leftBound = -1;
                }
                else{
                    leftBound = stack.peek();
                }

                int currentArea = (rightBound - leftBound - 1) * result[index];
                if(currentArea > maxArea){
                    maxArea = currentArea;
                }
            }
        }
        while(!stack.isEmpty()){

            int index = stack.pop();
            int leftBound;
            int rightBound = i;

            if(stack.empty()){
                leftBound = -1;
            }
            else{
                leftBound = stack.peek();
            }

            int currentArea = (rightBound - leftBound - 1) * result[index];

            if(currentArea > maxArea){
                maxArea = currentArea;
            }
        }
        return maxArea;
    }

}
