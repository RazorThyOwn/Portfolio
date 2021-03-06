public class DeMorgansLaw
{
    public static boolean deMorgan1A(int x, int y)
    {
        return !( !(x < 5) && (y >= 7) );
    }

    public static boolean deMorgan1B(int x, int y)
    {
        return (x < 5 || y < 7);
    }

    //////////////////////////////////////////////////////
    public static boolean deMorgan2A(int a, int b, int c)
    {
        return !( a == b || !(c != 5));

    }

    public static boolean deMorgan2B(int a, int b, int c)
    {
        return (a != b && c != 5 );
    }

    //////////////////////////////////////////////////////    

    public static boolean deMorgan3A(int x, int y)
    {
        return !( (x <  8 ) && (y > 4) );

    }

    public static boolean deMorgan3B(int x, int y)
    {
        return ( x >= 8 || y<=4);
    }

    ////////////////////////////////////////////////////// 

    public static boolean deMorgan4A(int i, int j)
    {
        return !( (i >4) || (j <=  6));
    }

    public static boolean deMorgan4B(int i, int j)
    {
        return ( i <= 4 && j > 6);     
    }

    //////////////////////////////////////////////////////////

    public static boolean deMorgan5A(int i, String str)
    {
        return !( str.equals("hello") || (i-1)!= 7 );
    }

    public static boolean deMorgan5B(int i, String str)
    {
        return (str.equals("not hello") && (i-1)==7);   
    }

    /////////////YOU HAVE FINISHED.  TESTER METHODS BELOW/////////////////////////////////////////////

    public static boolean deMorgan1Tester()
    {
        boolean isCorrect = true;
        for( int x = -20; x < 20; x++)
        {
            for( int y = -20; y < 20; y++)
            {
                if( deMorgan1A(x,y) != deMorgan1B(x,y))
                {
                    System.out.printf("deMorgan1 incorrect when x=%d and y=%d\n",x,y);
                    isCorrect=false;
                }
            }
        }
        if( isCorrect) System.out.println("deMorgan1 is correct");
        return isCorrect;
    }

    public static boolean deMorgan2Tester()
    {
        boolean isCorrect = true;
        for( int a = 0; a < 10; a++)
        {
            for( int b = 0; b < 10; b++)
            {
                for( int c = 0; c < 10; c++)
                {
                    if( deMorgan2A(a,b,c) != deMorgan2B(a,b,c))
                    {
                        System.out.printf("deMorgan2 incorrect when a=%d, b=%d, and c=%d\n",a,b,c);
                        isCorrect=false;
                    }
                }
            }
        }
        if( isCorrect) System.out.println("deMorgan2 is correct");
        return isCorrect;
    } 

    public static boolean deMorgan3Tester()
    {
        boolean isCorrect = true;
        for( int x = -20; x < 20; x++)
        {
            for( int y = -20; y < 20; y++)
            {
                if( deMorgan3A(x,y) != deMorgan3B(x,y))
                {
                    System.out.printf("deMorgan3 incorrect when x=%d and y=%d\n",x,y);
                    isCorrect=false;
                }
            }
        }
        if( isCorrect) System.out.println("deMorgan3 is correct");
        return isCorrect;
    }

    public static boolean deMorgan4Tester()
    {
        boolean isCorrect = true;
        for( int i = -20; i < 20; i++)
        {
            for( int j = -20; j < 20; j++)
            {
                if( deMorgan4A(i,j) != deMorgan4B(i,j))
                {
                    System.out.printf("deMorgan4 incorrect when i=%d and j=%d\n",i,j);
                    isCorrect=false;
                }
            }
        }
        if( isCorrect) System.out.println("deMorgan4 is correct");
        return isCorrect;
    }

    public static boolean deMorgan5Tester()
    {
        boolean isCorrect=true;
        for( int i = 1; i<=10; i++)
        {
            for( int x =0; x<2; x++)
            {
                String str = x%2==0?"hello":"not hello";
                if( deMorgan5A(i,str) != deMorgan5B(i,str))
                {
                    System.out.printf("deMorgan5 incorrect when i=%d and str=%s\n",i,str);
                    isCorrect=false;
                }
            }
        }
        if( isCorrect) System.out.println("deMorgan5 is correct");

        return isCorrect;
    }

    public static void testAll()
    {
        int correctCount = 0;
        if(deMorgan1Tester())
            correctCount++;
        if(deMorgan2Tester())
            correctCount++;
        if(deMorgan3Tester())
            correctCount++;
        if(deMorgan4Tester())
            correctCount++;
        if(deMorgan5Tester())
            correctCount++;

        System.out.println(correctCount +" correct tests");
    }
}