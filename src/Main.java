import java.time.LocalTime;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();

        //GUI.window(game);



        game.countdown(4);
        game.play();
        System.out.println(game.wpm());



    }


}