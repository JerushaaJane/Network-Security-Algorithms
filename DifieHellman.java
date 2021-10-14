public class DiffieHellman {
    public static void main(String args[]) {
        int p = 23; /* publicly known (prime number) */
        int g = 5; /* publicly known (primitive root) */
        int x = 4; /* only Alice knows this secret */
        int y = 3; /* only Bob knows this secret */
        double aliceSends = (Math.pow(g, x)) % p;
        double bobComputes = (Math.pow(aliceSends, y)) % p;
        double bobSends = (Math.pow(g, y)) % p;
        double aliceComputes = (Math.pow(bobSends, x)) % p;
        double sharedSecret = (Math.pow(g, (x * y))) % p;
        System.out.println("simulation of Diffie-Hellman key exchange algorithm\n---------------------------------------------");
        System.out.println("Alice Sends : " + aliceSends);
        System.out.println("Bob Computes : " + bobComputes);
        System.out.println("Bob Sends : " + bobSends);
        System.out.println("Alice Computes : " + aliceComputes);
        System.out.println("Shared Secret : " + sharedSecret);
        /* shared secrets should match and equality is transitive */
        if ((aliceComputes == sharedSecret) && (aliceComputes == bobComputes))
            System.out.println("Success: Shared Secrets Matches! " + sharedSecret);
        else
            System.out.println("Error: Shared Secrets does not Match");
    }
}

/*
simulation of Diffie-Hellman key exchange algorithm
---------------------------------------------
Alice Sends : 4.0
Bob Computes : 18.0
Bob Sends : 10.0
Alice Computes : 18.0
Shared Secret : 18.0
Success: Shared Secrets Matches! 18.0
*/
