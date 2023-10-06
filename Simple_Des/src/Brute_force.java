public class Brute_force {
    public static String[] brute_force(String Plaintext, String Ciphertext) {
        //把Key转化为二进制字符串，然后蛮力匹配明密文和密钥
        int Key = 0;
        String[] SameKey = new String[100];
        
        int num = 0; //满足条件的密钥的数量

        while (Key!= 1024) {
            int digits = 10; // 指定位数
            String K = String.format("%" + digits + "s", Integer.toBinaryString(Key)).replace(' ', '0');
            
            if (Plaintext.equals(Decipher.decipher(Ciphertext, K))) {
                SameKey[num] = K;
                num++;
            }

            else if (Plaintext.equals(ASCII.asciiDecipher(Ciphertext, K))) {
                SameKey[num] = K;
                num++;
            }
            Key += 1;
        }
        return SameKey;
    }
}
