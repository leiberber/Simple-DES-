import java.util.Scanner;

public class Encipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入明文:");
        String Input = sc.nextLine();
        String Ciphertext = Cipher.Cipher(Input);
        System.out.println("加密后密文如下:" + Ciphertext);
        String Plaintext = Decipher.Decipher(Ciphertext);
        System.out.println("解将后明文如下:" + Plaintext);
    }
}