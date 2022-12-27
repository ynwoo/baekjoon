import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        System.out.println(numbers[numbers.length/2]);
    }
}