
public class test {
    public static void main(String[] args) {
        String Plaintext = "10101010";
        String Key = "1010101010";
        String Ciphertext = Cipher.cipher(Plaintext,Key);
        System.out.println("明文:"+Plaintext+" 密钥:"+Key);
        System.out.println("加密后密文如下:" + Ciphertext);
        System.out.println("蛮力破解");
        String[] SameKey = Brute_force.brute_force(Plaintext, Ciphertext);
        for (int i = 0; i < SameKey.length; i++) {
            if (SameKey[i] != null) {
                System.out.print("检测到密钥" + SameKey[i]);
                System.out.println(" 明文为" + Decipher.decipher(Ciphertext, SameKey[i]));
            }
        }
    }
}