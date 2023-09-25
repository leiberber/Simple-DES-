public class IP {
    public static String IP(String In) {//初始置换IP
        int[] IP = {1, 5, 2, 0, 3, 7, 4, 6};//各数字需减去1以对应下标
        String[] Pro = In.split("");
        String[] Pro1 = In.split("");//复制一个备份字符串
        StringBuffer Ciphertext = new StringBuffer("");
        for (int i = 0; i < 8; i++) {
            int a = IP[i];
            Pro[i] = Pro1[a];
            Ciphertext.append(Pro[i]);
        }
        return Ciphertext.toString();//初始置换IP完成
    }//已测试可运行

    public static String IP_1(String In) {//最终置换IP-1
        int[] IP = {3, 0, 2, 4, 6, 1, 7, 5};//各数字需减去1以对应下标
        String[] Pro = In.split("");
        String[] Pro1 = In.split("");//复制一个备份字符串
        StringBuffer Ciphertext = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            Pro[i] = Pro1[IP[i]];
            Ciphertext.append(Pro[i]);
        }
        return Ciphertext.toString();
    }//已测试可运行
}