public class Recursion
{
    public static void main()
    {
        run();
    }

    public static void run()
    {
        int[] input = new int[6];

        input[0] = 67;
        input[1] = 76;
        input[2] = 81;
        input[3] = 89;
        input[4] = 95;
        input[5] = 100;

        A1mystery(5, 2);
        System.out.println("");
        B2guess(5, 2);
        System.out.println("");
        C3num(12, 27);
        System.out.println("");
        D4call(5);
        System.out.println("");
        E5printDollarSign(5);
        System.out.println("");
        F6bbb(7825);
        System.out.println("");
        G7bbb(21);
        System.out.println("");
        H8bbb("January",4);
        System.out.println("");
        I9bbb("January",4);
        System.out.println("");
        J10bbb(input, 6);
        System.out.println("");
        K11bbb(5);
        System.out.println("");
        L12bbb(45,30);
    }

    public static int A1mystery(int a, int b)
    {
        if( b == 1 )
            return a;
        else
            return a + A1mystery(a,b-1);
    }

    public static int B2guess(int a,int b )
    {
        if (a == 0)
            return 1;
        else
            return b * B2guess(a-1,b);
    }

    public static int C3num(int a,int b)
    {
        if (b == 0)
            return a;
        else if (b > a)
            return C3num(b,a);
        else
            return C3num(b, a % b);
    }

    public static void D4call(int k)
    {
        if (k > 1 )
        {
            D4call(k-2);
            D4call(k-1);
            System.out.print(k);
        }
    }

    public static void E5printDollarSign(int k)
    {
        int j;
        if (k > 0)
        {
            System.out.print("$");
            int output = k - 1;
            E5printDollarSign(output);
        }
    }

    public static void F6bbb(int num)
    {
        if (num > 0)
        {
            System.out.print(num % 10);
            F6bbb(num/10);
        }
    }

    public static void G7bbb(int num)
    {
        if (num > 0)
        {
            System.out.print(num % 2);
            G7bbb(num/2);
        }
    }

    public static void H8bbb(String s, int p)
    {
        if (p >= 0)
        {
            System.out.print(s.substring(p,p+1));
            H8bbb(s,p-1);
        }
    }

    public static void I9bbb(String s, int p)
    {
        if (p >= 0)
        {
            I9bbb(s,p-1);
            System.out.print(s.substring(p,p+1));
        }
    }

    public static void J10bbb(int[] arr, int p)
    {
        if (p > 0)
        {
            System.out.print(arr[p-1] + " ");
            J10bbb(arr, p-1);
        }
    }

    public static void K11bbb(int p)
    {
        if (p > 0)
        {
            System.out.print(p);
            K11bbb(p-1);
        }
    }

    public static int L12bbb(int x, int y)
    {
        int r;
        if (y == 0)
            return x;
        else
        {
            r = x % y;
            x = y;
            y = r;
            return L12bbb(x,y);
        }
    }
}