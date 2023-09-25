public class Brute_force {
    public static boolean Brute_force(String Plaintext, String Ciphertext) {
        String Key = "0000000000";
        String answer = Decipher.Decipher(Ciphertext, Key);
        System.out.println("解密后明文如下:" + answer);
        if (answer.equals(Plaintext)) {
            return true;
        }
        else
            Key += 1;
            return false;
        
    }
}