import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncipherUI extends JFrame {
    private JTextField plaintextField; // 明文输入框
    private JTextField keyField; // 密钥输入框
    private JTextField ciphertextField; // 密文输出框
    private JTextField decryptKeyField; // 解密密钥输入框
    private JTextField decryptedField; // 解密后明文输出框

    public EncipherUI() {
        setTitle("加密解密程序"); // 设置窗口标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时的操作
        setSize(600, 400); // 设置窗口大小
        setLocationRelativeTo(null); // 设置窗口居中显示
        setLayout(new GridBagLayout()); // 设置布局为网格包布局
        GridBagConstraints gbc = new GridBagConstraints(); // 创建网格包布局的约束对象
        gbc.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距

        //开始添加组件
        gbc.gridx = 0; // 设置组件在网格中的列索引
        gbc.gridy = 0; // 设置组件在网格中的行索引
        add(new JLabel("明文（8位二进制数字）:"), gbc); // 添加标签组件到窗口

        gbc.gridx = 1; // 更新列索引
        plaintextField = new JTextField(10); // 创建一个文本框组件
        add(plaintextField, gbc); // 添加文本框组件到窗口

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("密钥（10位二进制数字）:"), gbc);

        gbc.gridx = 1;
        keyField = new JTextField(10);
        add(keyField, gbc);

        gbc.gridx = 2;
        JButton encryptButton = new JButton("加密");
        add(encryptButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("加密后密文:"), gbc);

        gbc.gridx = 1;
        ciphertextField = new JTextField(10);
        ciphertextField.setEditable(false);
        add(ciphertextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("解密密钥（10位二进制数字）:"), gbc);

        gbc.gridx = 1;
        decryptKeyField = new JTextField(10);
        add(decryptKeyField, gbc);

        gbc.gridx = 2;
        JButton decryptButton = new JButton("解密");
        add(decryptButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("解密后明文:"), gbc);

        gbc.gridx = 1;
        decryptedField = new JTextField(10);
        decryptedField.setEditable(false);
        add(decryptedField, gbc);

        JButton brute = new JButton("蛮力破解");
        gbc.gridx = 2;
        add(brute, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("破解结果:"), gbc);

        JTextArea result = new JTextArea(4, 10);
        result.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(result, gbc);

        //暴力破解监听器
        brute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciphertext = ciphertextField.getText();
                String plaintext = plaintextField.getText();
                String[] SameKey = Brute_force.brute_force(plaintext, ciphertext);
                String Key_list = new String();
                for (int i = 0; i < SameKey.length; i++) {
                    if (SameKey[i] != null) {
                        Key_list += SameKey[i] + "\n";
                    }
                }
                result.setText(Key_list);
            }
        });

        //加密监听器
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = plaintextField.getText();
                String key = keyField.getText();
                if (plaintext.length() != 8 || !isBinary(plaintext)) {
                    JOptionPane.showMessageDialog(EncipherUI.this, "明文必须为8位二进制数字", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (key.length() != 10 || !isBinary(key)) {
                    JOptionPane.showMessageDialog(EncipherUI.this, "密钥必须为10位二进制数字", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String ciphertext = Cipher.cipher(plaintext, key);
                ciphertextField.setText(ciphertext);
            }
        });

        //解密监听器
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciphertext = ciphertextField.getText();
                String decryptKey = decryptKeyField.getText();
                if (decryptKey.length() != 10 || !isBinary(decryptKey)) {
                    JOptionPane.showMessageDialog(EncipherUI.this, "解密密钥必须为10位二进制数字", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String decryptedText = Decipher.decipher(ciphertext, decryptKey);
                decryptedField.setText(decryptedText);
            }
        });
        setVisible(true);
    }
    
    //判断是否是二进制数
    private boolean isBinary(String str) {
        for (char c : str.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
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