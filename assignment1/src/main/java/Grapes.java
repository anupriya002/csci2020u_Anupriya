public class Grapes implements Fruit{

    //function implemented from the Fruit interface
    //when the Grapes class is instantiated, the following function is called as well
    @Override
    public void describeFruit(String name, String color) {
        System.out.println("This fruit is a " + name + ". The color of a " + name + " is " + color + ".");
    }
}
