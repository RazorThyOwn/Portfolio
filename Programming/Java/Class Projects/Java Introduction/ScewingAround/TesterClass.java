class TesterClass
{
    private int testAmount = 56;
    private ArrayList r = new ArrayList<String>();

    TesterClass()
    {

    }

    private void testClass()
    {
        for (int i = 0; i < testAmount; i++)
        {
            String adding = "";

            do
            {
                adding+=(int)(Math.random()*100);
            }
            while (adding.length() < 5);
            r.add(adding);
        }
        for (int i = 0; i < testAmount; i++)
        {
            System.out.println(r.get(i));
        }
    }

    public static void main()
    {
        TesterClass tC = new TesterClass();
        tC.testClass();
    }
}
