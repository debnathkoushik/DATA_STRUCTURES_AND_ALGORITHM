import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class HourGlassSum
{

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr)
    {
        int max_sum = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                int sum =  arr.get(0).get(0);

                if (sum > max_sum)
                {
                    max_sum = sum;
                }
            }
        }

        return max_sum;

    }

}

public class Solution
{
    public static void main(String args[])
    {
        try{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter   (System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++)
        {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++)
            {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = HourGlassSum.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    catch (Exception e)
    {
        System.out.println("Exception in main" );
        e.printStackTrace();
    }
    }
}
