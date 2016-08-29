public class RandomBlock
{
    public static void main(int numBlocks)
    {
        for (int i = 0;i<numBlocks;i++)
        {
            int rNum = -1;
            while (rNum==-1||rNum==8||rNum==9||rNum==10||rNum==11||rNum==26||rNum==8||rNum==34||rNum==36||rNum==65||rNum==68
            ||rNum==75||rNum==76||rNum==90||rNum==97||rNum==98||rNum==95||rNum==94||rNum==119||rNum==64||rNum==70||rNum==39||rNum==40
            ||rNum==37||rNum==38)
            {
                rNum = (int)(Math.random()*164)+1;
            }
            System.out.print(rNum+", ");
        }
    }
}