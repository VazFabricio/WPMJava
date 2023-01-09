import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game{

    final private static int PANEL_HEIGHT = 300;
    final private static int PANEL_WIDTH = 650;

    final private static String[] WORDS = {"palvra", "sim", "nao", "amanha","ontem", "teste", "hoje", "felicidade", "amor", "raiva", "medo", "sorte", "Brasil", "Estados Unidos"};
    final private static int NUMBER_OF_ELEMENTS = WORDS.length-1;

    Random rand = new Random();

    Scanner sc = new Scanner(System.in);

    String [] compare = new String [2];
    int charSize = 0;

    private double start;
    private double end;

    String generatedWord  = " ";
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();




    public void windowStart() throws InterruptedException {
        JLabel labelStart = new JLabel();
        labelStart.setBounds(290, 50, 80, 25);
        panel.add(labelStart);
        labelStart.setVisible(true);
        labelStart.setText("3");
        TimeUnit.SECONDS.sleep(1);
        labelStart.setText("2");
        TimeUnit.SECONDS.sleep(1);
        labelStart.setText("1");
        TimeUnit.SECONDS.sleep(2);
        labelStart.setVisible(false);
        labelStart.setText(null);

    }
    public void Game() throws InterruptedException {
        //Graph
        //window
        frame = new JFrame();
        //layout
        panel = new JPanel();
        //frame
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        //panel
        panel.setLayout(null);

       windowStart();

        //GeneratedWords
        //current
        JLabel label1 = new JLabel();
        label1.setText(WORDS[rand.nextInt(NUMBER_OF_ELEMENTS)]);
        label1.setBounds(290, 50, 80, 25);
        panel.add(label1);

        JLabel label2 = new JLabel();
        label2.setText(null);
        label2.setBounds(230, 100, 165, 25);
        panel.add(label2);


        //Input
        JTextField type = new JTextField();
        type.setBounds(230, 100, 165, 25);
        panel.add(type);
        type.setVisible(true);

        frame.setSize(PANEL_WIDTH-1, PANEL_HEIGHT-1);

        type.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_SPACE) {
                    label1.setVisible(true);
                    type.setVisible(true);
                    label2.setVisible(false);
                    if (label1.getText().equals(type.getText().trim())) {
                        charSize += label1.getText().length();
                        System.out.println(charSize + " CERTO");
                    } else {
                        System.out.println(" ERRADO");
                    }
                    label1.setText(WORDS[rand.nextInt(NUMBER_OF_ELEMENTS)]);

                    type.setText(null);
                }

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        panel.add(type);

        endGame(label1, label2, type);



    }


    public void endGame(JLabel label1, JLabel label2, JTextField type) throws InterruptedException {
        for (int i = 0; i < 30;){
            i++;
            TimeUnit.SECONDS.sleep(1);
            System.out.println(i);
        }

        label1.setVisible(false);
        label2.setVisible(true);
        type.setVisible(false);
        end = LocalTime.now().toNanoOfDay();
        label2.setText("wpm: " + wpm());
    }
    public int wpm(){
        double totalTime = 60;
        double seconds = totalTime / 1000000000.0;

        //wdp = (x characters / 5 ) / 1min = y WPM
        int numChars = charSize;
        int wpm = (int) ((((double) numChars / 5) / seconds) * 60);

        return wpm;
    }

}

