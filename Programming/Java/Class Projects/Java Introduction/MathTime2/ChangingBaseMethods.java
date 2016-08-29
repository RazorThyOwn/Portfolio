public class ChangingBaseMethods
{
    public static String getBinary(int dec)
    {
        String str = "";
        while (dec!=0)
        {
            int num = dec%2;
            String numString = "" + num;
            str = numString+=str;
            dec = dec/2;
        }
        return str;
    }

    public static String getOctal(int dec)
    {
        String str = "";
        while (dec!=0)
        {
            int num = dec%8;
            String numString = "" + num;
            str = numString+=str;
            dec = dec/8;
        }
        return str;
    }

    public static void main()
    {
        System.out.println("Decimal\tBinary\tOctal\tHexadecimal");
        int number = 0;
        while (number<20)
        {
            number++;
            String binNum = getBinary(number);
            String octNum = getOctal(number);
            String hexNum = decToBase(number,16);
            System.out.println(number + "\t" + binNum + "\t" + octNum + "\t" + hexNum);
        }
    }

    public static String decToBase(int dec, int base)
    {
        String str = "";
        while (dec!=0)
        {

            int num = dec%base;
            String numString = getDigit(num);
            str = numString+=str;
            dec = dec/base;

        }
        return str;
    }

    public static int baseToDec(String num, int base)
    {
        String changeNum = num;
        int limit = 1;
        int length = num.length();
        int returnVal = 0;
        while (limit<=length)
        {
            String sub = changeNum.substring(0,1);
            returnVal += getIntVal(sub)*(int)(Math.pow(base,length-limit));
            changeNum = changeNum.substring(1);
            limit++;
        }
        return returnVal;
    }

    public static String getDigit(int val)
    {
        if( val<10)
            return val+"";
        else
            return (char)(val+55)+"";
    }

    public static int getIntVal(String dig)
    {
        int aVal = (int)dig.charAt(0);

        if(aVal <65)
            return aVal - 48;
        else
            return aVal - 55;
    }
}