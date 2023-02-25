import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Game{

    final private static int PANEL_HEIGHT = 300;
    final private static int PANEL_WIDTH = 650;

    int charSize = 0;

    public double start;
    public double end;

    Calculator calculator = new Calculator();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    Reader readLine = new Reader();
    final private static String filePath = "src/javaWords.txt";

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
    public void createGame() throws InterruptedException, IOException {
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
        
        String currentWord = readLine.lerLinha(filePath);
        
        //currentLabel
        JLabel currentLabel = new JLabel();
        currentLabel.setText(currentWord);
        currentLabel.setOpaque(false);
        currentLabel.setBackground(Color.gray);
        currentLabel.setBounds(290, 50, 200, 25);
        panel.add(currentLabel);
        
        //previous
        JLabel previous = new JLabel();
        previous.setText(null);
        previous.setBounds(290, 170, 80, 25);
        panel.add(previous);


        JLabel wpmLabel = new JLabel();
        wpmLabel.setText(null);
        wpmLabel.setBounds(230, 100, 165, 25);
        panel.add(wpmLabel);

        JLabel counter = new JLabel();
        counter.setBounds(160, 100, 165, 25);
        panel.add(counter);


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
                    currentLabel.setVisible(true);
                    type.setVisible(true);
                    wpmLabel.setVisible(false);
                    if (currentLabel.getText().equals(type.getText().trim())) {
                        charSize += currentLabel.getText().length();
                        System.out.println(charSize + " CERTO");
                        previous.setForeground(Color.green);
                    } else {
                        System.out.println(" ERRADO");
                        previous.setForeground(Color.red);
                    }
                    previous.setText(currentLabel.getText());
                    try {
                        currentLabel.setText(readLine.lerLinha(filePath));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    type.setText(null);
                }

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        panel.add(type);

        endGame(currentLabel, wpmLabel, type, previous);

    }

    public void endGame(JLabel currentLabel, JLabel wpmLabel, JTextField type, JLabel previous) throws InterruptedException {

        this.start = LocalTime.now().toNanoOfDay();
        for (int i = 0; i <= 60;){
            i++;
            TimeUnit.SECONDS.sleep(1);
            System.out.println(i);
        }
        this.end = LocalTime.now().toNanoOfDay();

        currentLabel.setVisible(false);
        wpmLabel.setVisible(true);
        type.setVisible(false);
        previous.setVisible(false);
        end = LocalTime.now().toNanoOfDay();
        wpmLabel.setText("wpm: " + calculator.wpm(end, start,charSize));
    }

}

