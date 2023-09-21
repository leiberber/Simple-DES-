import java.util.Scanner;


public class Encipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入明文:");
        String Input = sc.nextLine();
        String Ciphertext = Cipher(Input);
        System.out.println("加密后密文如下:" + Ciphertext);
        String Plaintext = Decipher.Decipher(Ciphertext);
        System.out.println("解将后明文如下:" + Plaintext);
    }

    private static String Cipher(String input) {
        //K_1,K_2两个密钥的生成
        String Key = "10101010"; //8位密钥
        String K_10[] = new String[10]; //扩展后的10位密钥
        String L_shift[] = new String[5]; //左五位
        String R_shift[] = new String[5]; //右五位
        String K_e10 = K_extend.P10(Key); //将Key扩展10位
        for (int i = 0; i < 10; i++) { //用K_10储存10位密钥
            K_10[i] = K_e10.substring(i, i + 1);
        }
        for (int i = 0; i < 5; i++) { //左右五位
            L_shift[i] = K_10[i];
            R_shift[i] = K_10[i + 5];
        }

        //将左右转化为字符串
        StringBuffer L_shift1 = new StringBuffer();
        StringBuffer R_shift1 = new StringBuffer();
        for (int i = 0; i < L_shift.length; i++) {
            L_shift1.append(L_shift[i]);
            R_shift1.append(R_shift[i]);
        }
        String L_s1 = L_shift1.toString();
        String R_s1 = R_shift1.toString();

        //左右分别Leftshift i次
        L_s1 = K_extend.Leftshift1(L_s1);
        R_s1 = K_extend.Leftshift1(R_s1);
        String L_s2 = K_extend.Leftshift2(L_s1);
        String R_s2 = K_extend.Leftshift2(R_s1);
        String K_S1 = L_s1 + R_s1;
        String K_S2 = L_s2 + R_s2;
        //将十位压缩为8位
        String K_1 = K_extend.P8(K_S1);
        String K_2 = K_extend.P8(K_S2);
        //结束

        //加密
        String text[] = new String[8]; //明文
        String L_text[] = new String[4]; //置换后左4位
        String R_text[] = new String[4]; //置换后右4位

        //IP置换
        String IP_text = IP.IP(input); //置换
        //字符串转化为字符串数组
        for (int i = 0; i < 8; i++) {
            text[i] = IP_text.substring(i, i + 1);
        }
        //分为左右两部分
        for (int i = 0; i < 4; i++) {
            L_text[i] = text[i];
            R_text[i] = text[i + 4];
        }
        //左右分别转化为字符串
        StringBuffer R_t1 = new StringBuffer();
        for (int i = 0; i < R_text.length; i++) {
            R_t1.append(R_text[i]);
        }
        StringBuffer L_t1 = new StringBuffer();
        for (int i = 0; i < L_text.length; i++) {
            L_t1.append(L_text[i]);
        }
        String R_Fk = R_t1.toString(); //右输入输出
        String L_IN = L_t1.toString(); //左输入

        //Fk1函数
        String R_E8 = F_round.EPBox(R_Fk); //E P-Box
        String R_S8 = F_round.XOR(R_E8, K_1); //亦或K_1和R_E8
        String R_S4 = F_round.SBox1(R_S8); //S-Box
        String R_P4 = F_round.SPBox(R_S4); //S P-Box
        String L_Fk = F_round.XOR(L_IN, R_P4); //亦或操作

        //SWAP
        String copy = R_Fk;
        R_Fk = L_Fk;
        L_Fk = copy;

        //Fk2函数
        R_E8 = F_round.EPBox(R_Fk);
        R_S8 = F_round.XOR(R_E8, K_2);
        R_S4 = F_round.SBox1(R_S8);
        R_P4 = F_round.SPBox(R_S4);
        L_Fk = F_round.XOR(L_Fk, R_P4);
        String IP_1_text = L_Fk + R_Fk;

        //IP_1置换
        String Ciphertext = IP.IP_1(IP_1_text);
        return Ciphertext; //返回密文
    }
}
