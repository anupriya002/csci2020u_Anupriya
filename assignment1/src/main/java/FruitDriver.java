/** Name: Anupriya Dubey
 *  Date: February 25, 2022
 *  CSCI 2020U - Assignment 1
 *
 *  The following program is a sample implementation of the Factory Design Pattern. Objects of the various fruit
 *  subclasses are created based on user input, which is handled by the fruitBasket class that then instantiates the
 *  appropriate subclass. All subclasses implement the Fruit interface to produce the appropriate output after
 *  instantiation.
 */

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
        System.out.println ("Enter an integer to create any of the possible fruits listed above. Select 6 to exit the program.");
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

            } else if (option == 1){ //user selects to create an Apple
                Fruit fruit1 = myBasket.getFruit(option);
                fruit1.describeFruit("Apple", "Red");
                System.out.println("Enter an option: ");
                option = input.nextInt();

            } else if (option == 2){ //user selects to create a Banana
                Fruit fruit2 = myBasket.getFruit(option);
                fruit2.describeFruit("Banana", "Yellow");
                System.out.println("Enter an option: ");
                option = input.nextInt();

            } else if (option == 3){ //user selects to create Grapes
                Fruit fruit3 = myBasket.getFruit(option);
                fruit3.describeFruit("Grapes", "Purple");
                System.out.println("Enter an option: ");
                option = input.nextInt();

            } else if (option == 4){ //user selects to create a Mango
                Fruit fruit4 = myBasket.getFruit(option);
                fruit4.describeFruit("Mango", "Reddish-yellow");
                System.out.println("Enter an option: ");
                option = input.nextInt();

            } else if (option == 5){ //user selects to create an Orange
                Fruit fruit5 = myBasket.getFruit(option);
                fruit5.describeFruit("Orange", "Orange");
                System.out.println("Enter an option: ");
                option = input.nextInt();
            }
        }
    }
}
