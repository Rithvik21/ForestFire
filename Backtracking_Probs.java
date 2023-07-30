import java.util.*;
public class Backtracking_Probs
{
    //4)
    public static void printBinary(int digits)
    {
        printBinaryHelper(digits, "");
    }
    
    private static void printBinaryHelper(int digits, String soFar)
    {
        if(soFar.length() == digits){
            System.out.print(soFar + " ");
        }
        else{
            printBinaryHelper(digits, soFar + 0);
            printBinaryHelper(digits, soFar + 1);
        }
    }
    
    //5)
    public static void climbStairs(int steps){
        climbStairsHelper(steps, "");
    }
    
    private static void climbStairsHelper(int steps, String soFar){
        
        if(steps == 0){
            System.out.println(soFar + " ");
        }
        else{
            if(steps >= 1){
                if(steps == 1){
                    climbStairsHelper(steps-1, soFar + 1 + " ");
                }
                else{
                    climbStairsHelper(steps-1, soFar + 1 + ", ");
                }
            }
            if(steps >= 2){
                if(steps == 2){
                    climbStairsHelper(steps-2, soFar + 2 + " ");
                }
                else{
                    climbStairsHelper(steps-2, soFar + 2 + ", ");
                }
            }
        }
    }
    
    //7)
    public static void campsite(int x, int y){
        campsiteHelper(x, y, 0, 0, "");
    }
    
    private static void campsiteHelper(int x, int y, int curX, int curY, String soFar){
        if(curX == x && curY == y){
            System.out.println(soFar + " ");
        }
        else{
            if(x >= curX + 1 && y >= curY + 1){
                campsiteHelper(x, y, curX+1, curY+1, soFar + "NE ");
            }
            if(x >= curX + 1){
                campsiteHelper(x, y, curX+1, curY, soFar + "E ");
            }
            if(y >= curY + 1){
                campsiteHelper(x, y, curX, curY+1, soFar + "N ");
            }
        }
    }
    
    //8)
    
    public static int getMax(List<Integer> nums, int limit) {
        return getMaxHelper(nums,limit,0,0);
    }

    public static int getMaxHelper(List<Integer> nums, int limit, int currentSum, int pos) {
        if (pos == nums.size()) {
            if (currentSum > limit) {
                return -1;
            }
            return currentSum;
        }
        return Math.max(getMaxHelper(nums, limit, currentSum, pos + 1), getMaxHelper(nums, limit, currentSum + nums.get(pos), pos + 1));
    }
    

    
    public static void main(String[] args){
        //4)
        printBinary(3);
        System.out.println();
        
        //5)
        climbStairs(4);
        
        //7)
        campsite(2,1);
        
        //8)
        System.out.println(getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 19));
    }

}