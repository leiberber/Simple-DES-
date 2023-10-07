public class Cipher {
    public static String cipher(String input,String Key) {
        //K_1,K_2两个密钥的生成  无问题
        String []K_10 = new String[10]; //转换的10位密钥
        String []L_shift = new String[5]; //左五位
        String []R_shift = new String[5]; //右五位  
        K_10 = K_extend.P10(Key).split(""); //P10BOX
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
        String L_s2 = K_extend.Leftshift2(L_s1);
        String R_s2 = K_extend.Leftshift2(R_s1);
        L_s1 = K_extend.Leftshift1(L_s1);
        R_s1 = K_extend.Leftshift1(R_s1);
        
        StringBuffer K_S1 = new StringBuffer();
        K_S1.append(L_s1);
        K_S1.append(R_s1);
        String K_1S = K_S1.toString();
        StringBuffer K_S2 = new StringBuffer();
        K_S2.append(L_s2);
        K_S2.append(R_s2);
        String K_2S = K_S2.toString();
        //将十位压缩为8位
        String K_1 = K_extend.P8(K_1S);
        String K_2 = K_extend.P8(K_2S);
        //结束

        //加密
        String text[] = new String[8]; //明文
        String L_text[] = new String[4]; //置换后左4位
        String R_text[] = new String[4]; //置换后右4位

        //IP置换
        String IP_text = IP.IP_0(input); //置换
        //字符串转化为字符串数组
        text = IP_text.split("");
        //分为左右两部分
        for (int i = 0; i < 4; i++) {
            L_text[i] = text[i];
            R_text[i] = text[i + 4];
        }
        //左右分别转化为字符串
        StringBuffer R_t1 = new StringBuffer();
        StringBuffer L_t1 = new StringBuffer();
        for (int i = 0; i < R_text.length; i++) {
            R_t1.append(R_text[i]);
            L_t1.append(L_text[i]);
        }

        String R_Fk = R_t1.toString(); //右输入输出
        String L_IN = L_t1.toString(); //左输入

        //Fk1函数
        String R_E8 = F_round.EPBox(R_Fk); //E P-Box
        String R_S8 = F_round.XOR(R_E8, K_1); //亦或K_1和R_E8
        StringBuffer R_S4_1 = new StringBuffer();
        StringBuffer R_S4_2 = new StringBuffer();
        for(int i=0;i<4;i++){
            String []a = R_S8.split("");
            R_S4_1.append(a[i]);
            R_S4_2.append(a[i+4]);
        }
        String R_S4_12 = F_round.SBox1(R_S4_1.toString());
        String R_S4_22 = F_round.SBox2(R_S4_2.toString());
        StringBuffer R_S4_3 = new StringBuffer();
        R_S4_3.append(R_S4_12);
        R_S4_3.append(R_S4_22);
        String R_S4 = R_S4_3.toString();//S-Box
        String R_P4 = F_round.SPBox(R_S4); //S P-Box
        String L_Fk = F_round.XOR(L_IN, R_P4); //亦或操作
        
        //SWAP
        String copy = R_Fk;
        R_Fk = L_Fk;
        L_Fk = copy;

        //Fk2函数
        String R2_E8 = F_round.EPBox(R_Fk); // E P-Box
        String R2_S8 = F_round.XOR(R2_E8, K_2); // 亦或K_2和R_E8
        StringBuffer R2_S4_1 = new StringBuffer();
        StringBuffer R2_S4_2 = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String[] a = R2_S8.split("");
            R2_S4_1.append(a[i]);
            R2_S4_2.append(a[i + 4]);
        }
        String R2_S4_12 = F_round.SBox1(R2_S4_1.toString());
        String R2_S4_22 = F_round.SBox2(R2_S4_2.toString());
        StringBuffer R2_S4_3 = new StringBuffer();
        R2_S4_3.append(R2_S4_12);
        R2_S4_3.append(R2_S4_22);
        String R2_S4 = R2_S4_3.toString();// S-Box
        String R2_P4 = F_round.SPBox(R2_S4); // S P-Box
        String L2_Fk = F_round.XOR(L_Fk, R2_P4); // 亦或操作


        StringBuffer IP_1_text = new StringBuffer();
        IP_1_text.append(L2_Fk);
        IP_1_text.append(R_Fk);
        String IP_1_text_string = IP_1_text.toString();

        //IP_1置换
        String Ciphertext = IP.IP_1(IP_1_text_string);
        return Ciphertext; //返回密文
    }
}
