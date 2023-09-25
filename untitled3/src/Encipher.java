import java.util.Scanner;
public class Encipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入明文（8位二进制数字）:");
        String Input = sc.nextLine();
        try {
            if (Input.length() != 8 || !isBinary(Input)) {
                throw new IllegalArgumentException("明文必须为8位二进制数字");
            }
            String Ciphertext = Cipher.Cipher(Input);
            System.out.println("加密后密文如下:" + Ciphertext);
            System.out.println("请输入密钥（10位二进制数字）:");
            String Key = sc.nextLine();
            if (Key.length() != 10 || !isBinary(Key)) {
                throw new IllegalArgumentException("密钥必须为10位二进制数字");
            }
            String Plaintext = Decipher.Decipher(Ciphertext, Key);
            System.out.println("解密后明文如下:" + Plaintext);
        } catch (IllegalArgumentException e) {
            System.out.println("输入错误：" + e.getMessage());
        }
    }
    // 判断字符串是否为二进制数字
    private static boolean isBinary(String str) {
        for (char c : str.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }
}