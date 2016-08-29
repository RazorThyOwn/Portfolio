public class DecToBin
{
    private int numToConv;
    
    public DecToBin(int tmpInt)
    {
        numToConv = tmpInt;
    }
    
    public String toBin()
    {
        int firstInt = numToConv % 2; // 1 .
        int nextInt = numToConv / 2; // 5 .
        int secondInt = nextInt % 2; // 1
        nextInt = nextInt / 2;
        int thirdInt = nextInt % 2;
        nextInt = nextInt / 2;
        int fourthInt = nextInt % 2;
        nextInt = nextInt / 2;
        int fifthInt = nextInt % 2;
        nextInt = nextInt / 2;
        int sixthInt = nextInt % 2;
        String str = "Your number in binary is "+sixthInt+fifthInt+fourthInt+thirdInt+secondInt+firstInt;
        return str;
    }
     
}