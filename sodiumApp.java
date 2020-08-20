import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class sodiumApp {

    private static JFormattedTextField t1;
    private static JFormattedTextField t2;
    private static int z, x;

    public static void sodiumApp()
    {

        JFrame f = new JFrame("Lord Sexy Trellsters sodium chloride");
        JLabel l1, l2, l3;
        JButton b1, b2, b3;
        JTextArea te = new JTextArea(1,5);
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        String date = simpleDate.format(new Date());

        l1 = new JLabel("Sodium Chloride: ");
        l1.setBounds(20, 50, 150, 30);
        l2 = new JLabel("Multipliers: ");
        l2.setBounds(20, 90, 120 ,30);
        l3 = new JLabel("All todays added sodium Chloride: ");
        l3.setBounds(20, 120, 250, 30);
        te.setBounds(20, 145, 300, 100);
        te.setEditable(false);

        t1 = new JFormattedTextField();
        t1.setBounds(155, 50, 100, 30);
        t2 = new JFormattedTextField();
        t2.setBounds(155, 90, 100, 30);

        b1 = new JButton("Save");
        b1.setBounds(55, 250, 90,30);
        b2 = new JButton("Multiply & save");
        b2.setBounds(55, 300, 180, 30);
        b3 = new JButton("Save all data");
        b3.setBounds(165, 250, 180, 30);

        b1.addActionListener(e -> {
            if(e.getSource() == b1){
                try{
                    x = Integer.parseInt(t1.getText());
                } catch (NumberFormatException a){
                    System.out.println("Invalid option!");
                }
                try{
                    FileWriter w = new FileWriter("Sodium_to_add", true);
                    w.write(x + " ");
                    w.close();
                    te.append(t1.getText() + "\n");
                } catch (IOException a){
                    System.out.println("Please use numbers");
                }
            }

        });

        b2.addActionListener(e -> {
            int sum;
            try{
                x = Integer.parseInt(t1.getText());
            } catch (NumberFormatException a){
                System.out.println("Invalid option!");
            }
            try{
                z = Integer.parseInt(t2.getText());
            } catch (NumberFormatException a) {
                System.out.println("Invalid option!");
            }

            if(e.getSource()==b2) {
                try{
                    sum = x*z;
                    FileWriter w = new FileWriter("Sodium_to_add", true);
                    w.write(" " + sum + " ");
                    w.close();
                    te.append(sum + "\n");

                } catch (NumberFormatException | IOException a) {
                    System.out.println("Invalid option!");
                }
            }
        });

        b3.addActionListener(e -> {
            if(e.getSource()==b3) {
                try {
                    FileWriter w = new FileWriter("Sodium_to_add", true);
                    w.write(" " + date + " " + "\n");
                    w.close();
                    JOptionPane.showMessageDialog(null, "All data saved!");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(te);
        f.add(t1);
        f.add(t2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setLayout(null);
        f.setSize(350, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        sodiumApp();
    }
}
