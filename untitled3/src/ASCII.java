public class ASCII {
    public static String asciiEncipher(String Begin,String Key){  //输入字符串以及10位密钥;
        int length = Begin.length();
        StringBuffer out = new StringBuffer();
        for(int i=0;i<length;i++){
            char change = Begin.charAt(i);
            int asciiValue = (int)change;
            String Binary = decimalToBinary(asciiValue);
            String Binary_en = Cipher.cipher(Binary,Key);
            int DecimalNumber = binaryToDecimal(Binary_en);
            char decimal = (char)(DecimalNumber);
            out.append(decimal);
        }
        return out.toString();
    }

    public static String asciiDecipher(String Begin,String Key){
        int length = Begin.length();
        StringBuffer out = new StringBuffer();
        for(int i=0;i<length;i++){
            char change = Begin.charAt(i);
            int asciiValue = (int)change;
            String Binary = decimalToBinary(asciiValue);
            String Binary_en = Decipher.decipher(Binary,Key);
            int DecimalNumber = binaryToDecimal(Binary_en);
            char decimal = (char)(DecimalNumber);
            out.append(decimal);
        }
        return out.toString();
    }

    public static String decimalToBinary(int decimalNumber) {
        int digits = 8; // 指定位数
        String binary = String.format("%" + digits + "s", Integer.toBinaryString(decimalNumber)).replace(' ', '0');
        return binary;
    }

    public static int binaryToDecimal(String binaryString) {
        int decimalNumber = Integer.parseInt(binaryString, 2);
        return decimalNumber;
    }
}
