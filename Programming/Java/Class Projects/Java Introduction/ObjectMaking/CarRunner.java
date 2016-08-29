public class CarRunner
{
    public static void main()
    {
    CarObj car = new CarObj();
    String str = car.toString();
    System.out.println(str);
    car.setPlate("CS4LIFE");
    str = car.toString();
    System.out.println(str);
    car.addMileage(50);
    str = car.toString();
    System.out.println(str);
    car.addMileage(99);
    str = car.toString();
    System.out.println(str);
}

}