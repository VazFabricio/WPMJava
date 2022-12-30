import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    final private static String[] words = {"oi", "sim", "nao", "amanha", "teste", "ontem"};
    final private static int numberOfElements = words.length-1;

    Random rand = new Random();

    Scanner sc = new Scanner(System.in);

    String [] compare = new String [2];

    int wordTypedLength = 0;

    private double start;
    private double end;

    String generatedWord  = " ";


    public void play(){
        //inicio jogo

        this.start = LocalTime.now().toNanoOfDay();

        for (int i = 0; i < 10; i++){
            this.generatedWord  = words[rand.nextInt(numberOfElements)];
            System.out.print( generatedWord + " ");
            System.out.println();
            String wordTyped = sc.nextLine();
            compare[0] = generatedWord;
            compare[1] = wordTyped;

            if (compare[0].equals(compare[1])){
                wordTypedLength += wordTyped.length();
            }

        }
        System.out.println();

        this.end = LocalTime.now().toNanoOfDay();

        //fim jogo

    }
    public int wpm(){
        double totalTime = end - start;
        double seconds = totalTime / 1000000000.0;

        //wdp = (x characters / 5 ) / 1min = y WPM
        int numChars = wordTypedLength;
        int wpm = (int) ((((double) numChars / 5) / seconds) * 60);

        return wpm;
    }

    public void countdown(int countdownSec) throws InterruptedException {

        for (int i = countdownSec; i > 0; i--){
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }

    }

    //Getters and Setters


    public String getGeneratedWord() {
        return generatedWord;
    }
}
