import java.util.Scanner;

class Test1 {
    public static void main(String[] args) {
        String s1 = "10";
        int n1 = Integer.parseInt(s1, 8);
        System.out.println(s1 + " is " + n1 + " in base10");
        String s2 = Integer.toString(n1, 2);
        System.out.println(n1 + " is " + s2 + " in base2");
    }
}