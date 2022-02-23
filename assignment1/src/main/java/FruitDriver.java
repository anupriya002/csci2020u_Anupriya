import java.util.Scanner;
public class FruitDriver {

    public static void main(String[] args){
        fruitBasket myBasket = new fruitBasket();

        Scanner input = new Scanner (System.in);
        System.out.println("*********** MENU ***********");
        System.out.println("1. Apple");
        System.out.println("2. Banana");
        System.out.println("3. Grapes");
        System.out.println("4. Mango");
        System.out.println("5. Orange");
        System.out.println("6. Quit");
        System.out.println ("Enter an integer to add any of the fruits above to your fruit basket. Select 6 to exit the program.");
        System.out.println("Enter an option: ");

        //if input is out of range, prompt user to select again.
        int option = input.nextInt();
        while(option < 1 || option > 6){
            System.out.println ("That fruit is not available or it does not exist. Please select another fruit.");
            System.out.println("Enter an option: ");
            option = input.nextInt();
        }

        //program exits if user inputs 6
        while (option >= 1 && option <= 6){
            if (option == 6){
                System.out.println("Program Exited.");
                break;

            } else if (option == 1){
                Fruit fruit1 = myBasket.getFruit(option);
                fruit1.describeFruit("Apple", "Red");
                System.out.println("Enter an option: ");
                option = input.nextInt();

            } else if (option == 2){
                Fruit fruit2 = myBasket.getFruit(option);
                fruit2.describeFruit("Banana", "Yellow");
                System.out.println("Enter an option: ");
                option = input.nextInt();

            } else if (option == 3){
                Fruit fruit3 = myBasket.getFruit(option);
                fruit3.describeFruit("Grapes", "Purple");
                System.out.println("Enter an option: ");
                option = input.nextInt();

            } else if (option == 4){
                Fruit fruit4 = myBasket.getFruit(option);
                fruit4.describeFruit("Mango", "Reddish-yellow");
                System.out.println("Enter an option: ");
                option = input.nextInt();

            } else if (option == 5){
                Fruit fruit5 = myBasket.getFruit(option);
                fruit5.describeFruit("Orange", "Orange");
                System.out.println("Enter an option: ");
                option = input.nextInt();
            }
        }
    }
}
