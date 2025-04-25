
package GUIjava;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JavaGUI {

        
        JFrame frame = new JFrame("Login Form");

        
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JTextField txtUsername = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JButton btnLogin = new JButton("Login");

        
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        frame.add(lblUsername);
        frame.add(txtUsername);
        frame.add(lblPassword);
        frame.add(txtPassword);
        frame.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = txtUsername.getText();
                String enteredPassword = new String(txtPassword.getPassword());

                
                int key = 3;
                String encryptedPassword = passwordEncryption(enteredPassword, key);

                
                boolean isAuthenticated = authenticateUser(enteredUsername, encryptedPassword);

                if (isAuthenticated) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        });

        
        frame.setBounds(600, 300, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    
    public static String passwordEncryption(String password, int key) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
        }
        return new String(chars);
    }

    
    private boolean authenticateUser(String username, String encryptedPassword) {
        String filePath = "C:\\Users\\Eunace Faith Emactao\\OneDrive\\Desktop\\forJframePrac.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(",");
                if (userInfo.length == 2) {
                    String storedUsername = userInfo[0].trim();
                    String storedEncryptedPassword = userInfo[1].trim();

                    if (username.equals(storedUsername) && encryptedPassword.equals(storedEncryptedPassword)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ An error occurred while reading the file.");
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        new JavaGUI();
    }
}


