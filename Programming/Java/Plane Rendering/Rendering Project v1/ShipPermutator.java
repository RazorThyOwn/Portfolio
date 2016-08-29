import java.util.List;
import java.util.ArrayList;
class ShipPermutator
{
    static void main()
    {
        String[] nameList = {"T2 Command Battlecruiser/T3 Cruiser","T2 Recon/Faction Battlecruiser/Ishtar","T1 Battlecruiser/T2 Logi",
                "T2 HAC/Faction Cruiser","T1 Support Cruiser","T1 Attack Cruiser/T2 EWAR Frigate",
                "T2 Frigates: Assault, Bomber, CovertOps/Interdictor","T2 Interceptor/T1 Destroyer/T1 Industrial","T1 Frig"};
        int[] points = {16,14,13,12,10,6,4,3,2};

        List<String> outputList = new ArrayList<String>();

        for (int n1 = 0; n1 < nameList.length; n1++)
            for (int n2 = 0; n2 < nameList.length; n2++)
                for (int n3 = 0; n3 < nameList.length; n3++)
                    for (int n4 = 0; n4 < nameList.length; n4++)
                        for (int n5 = 0; n5 < nameList.length; n5++)
                        {
                            int tPoints = points[n1]+points[n2]+points[n3]+points[n4]+points[n5];                            
                            if (tPoints<=30)
                            {
                                System.out.print(tPoints+": ");
                                String perm= "{"+nameList[n1]+" | "+nameList[n2]+" | "+nameList[n3]+" | "+nameList[n4]+" | "+nameList[n5]+"}";     
                                System.out.println(perm);
                            }
        }
    }
}