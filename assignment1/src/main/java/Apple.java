public class Apple implements Fruit{

    @Override
    public void describeFruit(String name, String color) {
        System.out.println("This fruit is a " + name + ". The color of a " + name + " is " + color + ".");
    }
}