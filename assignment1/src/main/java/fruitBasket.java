public class fruitBasket {

    //utilizes user input to determine which class to instantiate
    public Fruit getFruit(int fruitSelected){

        //if selected input is out of range, return null
        if(fruitSelected < 1 || fruitSelected > 5){
            System.out.println("Fruit does not exist(Out of Bounds).");
            return null;
        }
        if (fruitSelected == 1){ //apple selected by user (1rst option)
            return new Apple();

        } else if (fruitSelected == 2){ // banana selected by user (2nd option)
            return new Banana();

        } else if (fruitSelected == 3){ // Grapes selected by user (3rd option)
            return new Grapes();

        } else if (fruitSelected == 4){ //mango selected by user(4th option)
            return new Mango();

        } else if (fruitSelected == 5){ // orange selected by user(5th option)
            return new Orange();
        }

        return null;
    }
}
