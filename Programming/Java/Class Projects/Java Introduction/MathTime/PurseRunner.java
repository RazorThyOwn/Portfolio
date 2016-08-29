public class PurseRunner
{
    public static void main()
    {
        Purse prs = new Purse();
        prs.addNickle(7);
        prs.addDime(3);
        prs.addQuarter(13);
        int sum = prs.getNumberOfCoins();
        System.out.println(sum);
        double val = prs.getValue();
        System.out.println(val);
    }
}