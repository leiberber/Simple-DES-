import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EncipherUI extends JFrame {
    private JTextField inputTextField;
    private JButton encryptButton;
    private JTextField keyTextField;
    private JButton decryptButton;
    private JTextField ciphertextTextField;
    private JTextField plaintextTextField;
    public EncipherUI() {
        initUI();
    }
    private void initUI() {
        setTitle("加密解密程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        JLabel inputLabel = new JLabel("请输入明文（8位二进制数字）：");
        inputTextField = new JTextField();
        encryptButton = new JButton("加密");
        JLabel keyLabel = new JLabel("请输入密钥（10位二进制数字）：");
        keyTextField = new JTextField();
        decryptButton = new JButton("解密");
        JLabel ciphertextLabel = new JLabel("加密后密文：");
        ciphertextTextField = new JTextField();
        JLabel plaintextLabel = new JLabel("解密后明文：");
        plaintextTextField = new JTextField();
        add(inputLabel);
        add(inputTextField);
        add(encryptButton);
        add(keyLabel);
        add(keyTextField);
        add(decryptButton);
        add(ciphertextLabel);
        add(ciphertextTextField);
        add(plaintextLabel);
        add(plaintextTextField);
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextField.getText();
                // 调用加密方法，并将结果显示在ciphertextTextField中
                String ciphertext = Cipher.Cipher(input);
                ciphertextTextField.setText(ciphertext);
            }
        });
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciphertext = ciphertextTextField.getText();
                String key = keyTextField.getText();
                // 调用解密方法，并将结果显示在plaintextTextField中
                String plaintext = Decipher.Decipher(ciphertext, key);
                plaintextTextField.setText(plaintext);
            }
        });
        pack();
        setLocationRelativeTo(null); // 居中显示窗口
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EncipherUI();
            }
        });
    }
}