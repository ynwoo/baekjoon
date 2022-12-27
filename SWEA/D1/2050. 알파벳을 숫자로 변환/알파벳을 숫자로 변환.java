import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(int i=0;i<s.length();i++) {
            System.out.print((int) (s.charAt(i) - '0' - 16) + " ");
        }
	}
}