
public class test {
    public static void main(String[] args) {
        String Plaintext = "dddddddd";
        String Key = "1000110010";
        String Ciphertext = ASCII.asciiEncipher(Plaintext,Key);
        System.out.println("明文:"+Plaintext+" 密钥:"+Key);
        System.out.println("加密后密文如下:" + Ciphertext);
        System.out.println("解密后明文如下:" + ASCII.asciiDecipher(Ciphertext,Key));
        System.out.println("蛮力破解");
        String[] SameKey = Brute_force.brute_force(Plaintext, Ciphertext);

        long millis1 = System.currentTimeMillis();
        //计时
        

        for (int i = 0; i < SameKey.length; i++) {
            if (SameKey[i] != null) {
                System.out.print("检测到密钥" + SameKey[i]);
                System.out.println(" 明文为" + ASCII.asciiDecipher(Ciphertext, SameKey[i]));
            }
        }

        long millis2 = System.currentTimeMillis();
        long time = millis2 - millis1;//经过的毫秒数
        System.out.println("耗时：" + time + "ms");
    }
}
