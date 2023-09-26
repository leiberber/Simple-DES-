public class F_round {
    public static String EPBox(String In) {//位扩展
        int[] EPB = { 3, 0, 1, 2, 1, 2, 3, 0 };//各数字依然需要减去1
        String[] Begin = In.split("");
        String[] Begin1 = In.split("");
        StringBuffer EPBtext = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            EPBtext.append(Begin1[EPB[i]]);
        }
        return EPBtext.toString();
    }//已测试可运行

    public static String XOR(String In, String Kn) {//异或运算
        StringBuffer Xor = new StringBuffer();
        int k = In.length();
        String[] In1 = In.split("");
        String[] Kn1 = Kn.split("");
        for (int i = 0; i < k; i++) {
            if (In1[i].equals(Kn1[i])) {//这里不确定能否正常运行
                Xor.append("0");
            } else {
                Xor.append("1");
            }
        }
        return Xor.toString();
    }//已测试可运行

    public static String SBox1(String In) {
        String[] Begin = In.split("");
        String[][] Box1 = { { "01", "00", "11", "10" },
                { "11", "10", "01", "00" },
                { "00", "10", "01", "11" },
                { "11", "01", "00", "10" } };
        int x = 0;
        int y = 0;
        if (Begin[0].equals("0") && Begin[3].equals("0")) {
            y = 0;
        }
        if (Begin[0].equals("0") && Begin[3].equals("1")) {
            y = 1;
        }
        if (Begin[0].equals("1") && Begin[3].equals("0")) {
            y = 2;
        }
        if (Begin[0].equals("1") && Begin[3].equals("1")) {
            y = 3;
        }

        if (Begin[1].equals("0") && Begin[2].equals("0")) {
            x = 0;
        }
        if (Begin[1].equals("0") && Begin[2].equals("1")) {
            x = 1;
        }
        if (Begin[1].equals("1") && Begin[2].equals("0")) {
            x = 2;
        }
        if (Begin[1].equals("1") && Begin[2].equals("1")) {
            x = 3;
        }
        return Box1[x][y];
    }//已测试可运行

    public static String SBox2(String In) {
        String[] Begin = In.split("");
        String[][] Box2 = { { "00", "01", "10", "11" },
                { "10", "11", "01", "00" },
                { "11", "00", "01", "10" },
                { "10", "01", "00", "11" } };
        int x = 0;
        int y = 0;
        if (Begin[0].equals("0") && Begin[3].equals("0")) {
            y = 0;
        }
        if (Begin[0].equals("0") && Begin[3].equals("1")) {
            y = 1;
        }
        if (Begin[0].equals("1") && Begin[3].equals("0")) {
            y = 2;
        }
        if (Begin[0].equals("1") && Begin[3].equals("1")) {
            y = 3;
        }

        if (Begin[1].equals("0") && Begin[2].equals("0")) {
            x = 0;
        }
        if (Begin[1].equals("0") && Begin[2].equals("1")) {
            x = 1;
        }
        if (Begin[1].equals("1") && Begin[2].equals("0")) {
            x = 2;
        }
        if (Begin[1].equals("1") && Begin[2].equals("1")) {
            x = 3;
        }
        return Box2[x][y];
    }//已测试可运行

    public static String SPBox(String In) {
        String[] Begin = In.split("");
        int[] SPB = { 1, 3, 2, 0 };
        StringBuffer Out = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            Out.append(Begin[SPB[i]]);
        }
        return Out.toString();
    }//已测试可运行
}
