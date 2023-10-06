# Simple-DES-
ASCII加密/解密程序开发手册
=================

一、项目简介
------

本项目实现了一个简单的ASCII码加密和解密程序，并包括了蛮力破解的功能。程序采用Java语言编写，主要包括以下类和方法：

* `ASCII`类：包含了`asciiEncipher`和`asciiDecipher`两个方法，分别用于对明文进行加密和对密文进行解密。
* `Brute_force`类：包含了`brute_force`方法，用于对密文进行蛮力破解。
* `IP`类：包含了`IP_0`和`IP_1`两个方法，分别用于进行初始置换和最终置换。
* `F_round`类：包含了`EPBox`、`XOR`、`SBox1`、`SBox2`、`SPBox`等多个方法，用于进行扩展置换、异或运算、S盒替换和P盒置换等操作。
* `K_extend`类：包含了`P10`和`P8`两个方法，用于进行密钥的扩展和压缩。
* `Leftshift1`和`Leftshift2`类：包含了`Leftshift1`和`Leftshift2`两个方法，用于进行循环左移操作。
* `test`类：包含了`main`方法，用于进行测试。

二、使用方法
------

1. 设置明文和密钥：在`test`类的`main`方法中，您可以设置明文和密钥。例如，以下代码将明文设置为"dddddddd"，密钥设置为"1000110010"：


```java
String Plaintext = "dddddddd";
String Key = "1000110010";
```
2. 加密明文：调用`ASCII`类的`asciiEncipher`方法，将明文和密钥作为参数传入，得到加密后的密文。例如，以下代码将明文加密为密文：


```java
String Ciphertext = ASCII.asciiEncipher(Plaintext, Key);
```
3. 解密密文：调用`ASCII`类的`asciiDecipher`方法，将密文和密钥作为参数传入，得到解密后的明文。例如，以下代码将密文解密为明文：


```java
String DecryptedText = ASCII.asciiDecipher(Ciphertext, Key);
```
4. 蛮力破解：调用`Brute_force`类的`brute_force`方法，将明文和密文作为参数传入，得到所有可能的密钥。例如，以下代码将密文进行蛮力破解：


```java
String[] SameKey = Brute_force.brute_force(Plaintext, Ciphertext);
```
5. 遍历密钥：遍历所有可能的密钥，对密文进行解密，并输出明文。例如，以下代码遍历所有可能的密钥，并输出对应的明文：


```java
for (int i = 0; i < SameKey.length; i++) {
    if (SameKey[i] != null) {
        System.out.print("检测到密钥" + SameKey[i]);
        System.out.println(" 明文为" + ASCII.asciiDecipher(Ciphertext, SameKey[i]));
    }
}
```
三、注意事项
------

1. 本程序只是一个简单的演示程序，仅供学习和交流使用，实际安全性较低。在实际应用中，应该采用更加复杂的加密算法和安全措施。
2. 在使用蛮力破解时，由于可能的密钥数量非常大，程序可能需要较长时间才能运行完毕。建议仅在必要时使用此功能，或者在保证安全性的前提下采用其他更加高效的破解方法。
3. 本程序的代码结构可能不够优化和合理，仅供参考和学习。在实际项目中，需要根据实际需求进行更合理的设计和实现。例如，可以将加密算法和安全措施进行模块化设计，提高代码的可读性和可维护性。
