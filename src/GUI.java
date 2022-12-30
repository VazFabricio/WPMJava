import javax.swing.*;

public class GUI {

    public static void window(Game game){
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
        JLabel label = new JLabel("Word");
        label.setBounds(200, 20, 80, 25);
        panel.add(label);


        //Input
        JTextField type = new JTextField();
        type.setBounds(200, 60, 165, 25);
        panel.add(type);


    }

}
