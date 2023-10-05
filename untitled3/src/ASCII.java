public class ASCII {
    public static String asciiEncipher(String Begin,String Key){  //输入字符串以及10位密钥;
        int length = Begin.length();
        StringBuffer out = new StringBuffer();
        for(int i=0;i<length;i++){
            char change = Begin.charAt(i);
            int asciiValue = (int)change;
            String Binary = decimalToBinary(asciiValue);
            //确保转换成的二进制字符串有8位，不足的话前面补0
            if(Binary.length()<8){
                int paddingZeros = 8 - Binary.length();
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<paddingZeros;j++){
                    sb.append("0");
                }
                sb.append(Binary);
                Binary = sb.toString();
            }
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
            //确保转换成的二进制字符串有8位，不足的话前面补0
            if(Binary.length()<8){
                int paddingZeros = 8 - Binary.length();
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<paddingZeros;j++){
                    sb.append("0");
                }
                sb.append(Binary);
                Binary = sb.toString();
            }
            String Binary_en = Decipher.decipher(Binary,Key);
            int DecimalNumber = binaryToDecimal(Binary_en);
            char decimal = (char)(DecimalNumber);
            out.append(decimal);
        }
        return out.toString();
    }

    public static String decimalToBinary(int decimalNumber){
        StringBuilder binary = new StringBuilder();
        int temp = decimalNumber;
        while (temp > 0) {
            int remainder = temp % 2;
            binary.insert(0, remainder);
            temp = temp / 2;
        }
        return binary.toString();
    }

    public static int binaryToDecimal(String binaryString){
        int decimalNumber = 0;
        int binaryLength = binaryString.length();

        // 从二进制字符串的最左边（最高位）开始处理
        for (int i = 0; i < binaryLength; i++) {
            char binaryDigit = binaryString.charAt(i);
            int binaryValue = Character.getNumericValue(binaryDigit);

            // 计算对应位的十进制值，并累加到结果中
            decimalNumber += binaryValue * Math.pow(2, binaryLength - 1 - i);
        }

        return decimalNumber;
    }
}
