package hax;

public class RSA {
    int d;
    public RSA() {

    }

    public int encrypt(int c, int m, int e, int n) {
        c = ((int) Math.pow(m, e)) % (n);
        System.out.println("C = (M^(e)) % n \n= (" + m + "^(" + e + ")) % " + n + " = " + c);
        System.out.println("Encrypted M is: " + c);
        return c;
    }

    public int decrypt(int m, int c, int n) {
        m = ((int) Math.pow(c, d)) % (n);
        System.out.println("M = (C^(d)) % n\n= (" + c + "^(" + d + ")) % " + n + " = " + m);
        System.out.println("Decrypted C is: " + m);
        return m;
    }








    public int modInverse(int e, int T) {
        int t;
        if (coPrime(e, T)) {
            System.out.println("the inverseE is:\nE^(-1) = " + "E % T");
            for (int x = 1; x < T; x++) {
                t = ((e % T) * (x % T)) % T;

                if (t == 1) {
                    System.out.println("= " + e + " % " + t + " = " + x);

                    d = x % T;
                    System.out.println("d = E^(-1) % T\n" + x + " % " + T + " = " + d);
                    return d;
                }
            }
            return 1;
        } else {
            System.out.print("E and T are not coPrime!!!");
            return -1;
        }

    }


    public int ETF(int T, int p, int q) {
        if (isPrime(p) && isPrime(q)) {
            System.out.println("EULER'S TOTIENT FUNCTION:  T = (p - 1) * (q - 1)");
            System.out.println("T = " + "(" + p + " - " + "1)  * (" + q + " - 1)");
            T = (p - 1) * (q - 1);
            System.out.println("T = " + T);
        } else {
            System.out.println("P *and* Q should be prime numbers!!");
            T = -1;
        }
        return T;

    }
    private boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    private boolean coPrime(int a, int b) {
        if (gcd(a, b) == 1) {

            System.out.println("E and N are Co-Prime");
            return true;
        } else {
            System.out.println("E and N are *not* Co-Prime");
            return false;
        }
    }
    private int gcd(int a, int b) {

        if (a == 0) {

            return b;
        }
        if (b == 0) {

            return a;
        }
        if (a == b) {

            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        } else {
            return gcd(a, b - a);
        }
    }


}
