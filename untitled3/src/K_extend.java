public class K_extend {
    public static String P10(String In){//十位原始密钥进行变换
        int[] P10 = {2,4,1,6,3,9,0,8,7,5};
        String[] K = In.split("");
        String[] K1 = In.split("");
        StringBuffer K_Pro = new StringBuffer();
        for(int i=0;i<10;i++){
            K[i] = K1[P10[i]];
            K_Pro.append(K[i]);
        }
        return K_Pro.toString();
    }//已测试可运行

    public static String P8(String In) {//密钥压缩至8
        int[] P10 = {5,2,6,3,7,4,9,8};
        String[] K = In.split("");
        String[] K1 = In.split("");
        StringBuffer K_Pro = new StringBuffer();
        for(int i=0;i<8;i++){
            K[i] = K1[P10[i]];
            K_Pro.append(K[i]);
        }
        return K_Pro.toString();
    }//已测试可运行

    public static String Leftshift1(String In) {
        String[] Begin = In.split("");
        String[] Begin1 = {Begin[0],Begin[1],Begin[2],Begin[3],Begin[4]};
        //String[] Begin2 = {Begin[5],Begin[6],Begin[7],Begin[8],Begin[9]};
        int[] leftshift1 = {1,2,3,4,0};//需要减去1;此处待核实！！！！！
        StringBuffer left1 = new StringBuffer();
        //StringBuffer left2 = new StringBuffer();
        for (int i=0;i<5;i++){
            left1.append(Begin1[leftshift1[i]]);
        }
        //for (int i=0;i<5;i++){
        //    left2.append(Begin2[leftshift1[i]]);
        //}
        StringBuffer left = new StringBuffer();
        left.append(left1);
        //left.append(left2);//这里还不确定能不能成功运行
        return left.toString();
    }//已测试可运行，但不知编程逻辑是否正确

    public static String Leftshift2(String In) {
        String[] Begin = In.split("");
        String[] Begin1 = {Begin[0],Begin[1],Begin[2],Begin[3],Begin[4]};
        //String[] Begin2 = {Begin[5],Begin[6],Begin[7],Begin[8],Begin[9]};
        int[] leftshift2 = {2,3,4,0,1};
        StringBuffer left1 = new StringBuffer();
        //StringBuffer left2 = new StringBuffer();
        for (int i=0;i<5;i++){
            left1.append(Begin1[leftshift2[i]]);
        }
        //for (int i=0;i<5;i++){
        //    left2.append(Begin2[leftshift2[i]]);
        //}
        StringBuffer left = new StringBuffer();
        left.append(left1);
        //left.append(left2);//这里还不确定能不能成功运行
        return left.toString();
    }//已测试可运行，但不知编程逻辑是否正确
}