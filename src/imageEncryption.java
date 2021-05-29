import javax.swing.*;
import java.awt.*;
import java.io.*;

public class imageEncryption {

    public static void operate(int key) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        // file input stream reader
        try {

            FileInputStream fis = new FileInputStream(file);

            byte[] data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println(b);
                // here the file is encrypted and decrypted
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Hacked");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        System.out.println("trending");
        JFrame f = new JFrame();
        f.getContentPane().setBackground(Color.GREEN);
        f.setTitle("Image Operation");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto", Font.BOLD, 25);

        // creating Button for encryption
        JButton button = new JButton("+");
        button.setText("Encrypt");
        button.setBounds(100, 150, 100, 40);
        button.setFont(font);

        // creating Button for decryption
        JButton btn = new JButton();
        btn.setText("Decrypt");
        btn.setBounds(150, 100, 100, 40);
        btn.setFont(font);

        // Creating TextField
        JTextField textField = new JTextField(10);
        textField.setFont(font);
        f.setLayout(new FlowLayout());

        // set decrypt button disabled first time
        btn.setEnabled(false);
        button.addActionListener(e -> {
            System.out.println("Butoon Clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
            button.setEnabled(false);
            btn.setEnabled(true);
        });
        btn.addActionListener(e -> {
            System.out.println("Butoon Clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
            button.setEnabled(true);
            btn.setEnabled(false);
        });

        f.add(button);
        f.add(textField);
        f.add(btn);
        f.setVisible(true);

    }
}
