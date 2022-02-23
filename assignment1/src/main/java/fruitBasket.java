public class fruitBasket {

    public Fruit getFruit(int fruitName){

        //check if the fruit has a name(must have one to exist) -> always check for null first - best practice
        if(fruitName < 1 || fruitName > 5){
            System.out.println("Fruit does not exist(Out of Bounds).");
            return null;
        }
        if (fruitName == 1){ //apple selected by user
            return new Apple();

        } else if (fruitName == 2){ // banana selected by user
            return new Banana();

        } else if (fruitName == 3){ // Grapes selected by user
            return new Grapes();

        } else if (fruitName == 4){ //mango selected by user
            return new Mango();

        } else if (fruitName == 5){ // orange selected by user
            return new Orange();
        }

        return null;
    }
}
