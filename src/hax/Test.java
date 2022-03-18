package hax;

import java.util.Scanner;

public class Test {

    static int p;
    static int q;
    //Public Key
    static int e;
    //EULER'S TOTIENT FUNCTION ø(n)
    static int T;
    //message
    static int m;
    //encrypted text
    static int c;

    public static void main(String[] args) {
        RSA RivestShamirAdleman = new RSA();
        Scanner user = new Scanner(System.in);

        System.out.print("Enter P: (P should be a prime number): ");
        p = user.nextInt();
        System.out.print("Enter Q: (Q should be a prime number): ");
        q = user.nextInt();
        System.out.print("Choose e such that 1 < e < ø(n) where e and ø(n) are co-prime: ");
        e = user.nextInt();
        System.out.print("insert message: ");
        m = user.nextInt();
        int n = p * q;


        System.out.println("P is : " + p + " Q is: " +q);
        RivestShamirAdleman.ETF(T, p, q);
        RivestShamirAdleman.modInverse(e, T);
        System.out.println("The public Key exponent e is: " + e);
        RivestShamirAdleman.encrypt(c, m, e, n);
        RivestShamirAdleman.decrypt(m, c, n);


    }
}
