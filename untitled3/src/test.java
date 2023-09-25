import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入明文:");
        String Input = sc.nextLine();
       // String Input1 = sc.nextLine();
        String Ciphertext = F_round.SPBox(Input);
        System.out.println("加密后密文如下:" + Ciphertext);
    }
}
