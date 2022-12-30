import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game{
    final private static String[] WORDS = {"oi", "sim", "nao", "amanha", "teste", "ontem"};
    final private static int NUMBER_OF_ELEMENTS = WORDS.length-1;

    Random rand = new Random();

    Scanner sc = new Scanner(System.in);

    String [] compare = new String [2];

    int wordTypedLength = 0;

    private double start;
    private double end;

    String generatedWord  = " ";


    public void play(){
        //inicio jogo

        window();

        /*
        this.start = LocalTime.now().toNanoOfDay();

        for (int i = 0; i < 10; i++){
            this.generatedWord  = WORDS[rand.nextInt(NUMBER_OF_ELEMENTS)];
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

         */

    }


    public void countdown(int countdownSec) throws InterruptedException {

        for (int i = countdownSec; i > 0; i--){
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }

    }
    public void window(){
        //Graph
        //window
        JFrame frame = new JFrame();
        //layout
        JPanel panel = new JPanel();
        //frame
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        //panel
        panel.setLayout(null);


        //GeneratedWords
        JLabel label = new JLabel();
        label.setText(WORDS[rand.nextInt(NUMBER_OF_ELEMENTS)]);
        label.setBounds(200, 20, 80, 25);
        panel.add(label);


        //Input
        JTextField type = new JTextField();
        type.setBounds(200, 60, 165, 25);
        type.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    label.setText(WORDS[rand.nextInt(NUMBER_OF_ELEMENTS)]);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        panel.add(type);

        //end Graph
    }

    public int wpm(){
        double totalTime = end - start;
        double seconds = totalTime / 1000000000.0;

        //wdp = (x characters / 5 ) / 1min = y WPM
        int numChars = wordTypedLength;
        int wpm = (int) ((((double) numChars / 5) / seconds) * 60);

        return wpm;
    }

}

