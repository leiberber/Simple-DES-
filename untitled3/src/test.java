import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("明文10101010 密文1010101010");
        String Ciphertext = Cipher.Cipher("10101010");
        System.out.println("加密后密文如下:" + Ciphertext);
        System.out.println("测试密钥1010101010");
        System.out.println("测试密钥1000001000");
        System.out.println("解密后明文如下:");
        System.out.println(Decipher.Decipher(Ciphertext,"1010101010"));
        System.out.println(Decipher.Decipher(Ciphertext, "1000001000"));
    }
    //错误在Sbox1 sbox2,已修正。能调通了。
}