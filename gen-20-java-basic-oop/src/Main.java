import java.util.InputMismatchException;
import java.lang.NullPointerException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Food food = new Food();
            Toys toy = new Toys();
            FoodProduct mieInstan = new FoodProduct("Indomie", 6.0);
            FoodProduct cookies = new FoodProduct("Regal Marie", 3.0);
            ToysProduct cardgame = new ToysProduct("YuGiOh", 6.0);
            ToysProduct console = new ToysProduct("GBA", 10.0);

            System.out.println(food.categoryDesc());
            mieInstan.displayProduct();
            System.out.println();
            cookies.displayProduct();
            System.out.println();

            System.out.println(toy.categoryDesc());
            cardgame.displayProduct();
            System.out.println();
            console.displayProduct();
            System.out.println();

            System.out.println("Harga Indomie: " + mieInstan.getPrice());
            System.out.println("Harga GBA: " + console.getPrice());
            System.out.println("Harga Regal Marie: "+cookies.getPrice());
            System.out.println("Harga YuGiOh: "+cardgame.getPrice());
            System.out.println();
        } catch (StackOverflowError e){
            System.err.println(e);
        }

    }

}
