//Project Euler p351 MatthewC3297
public class Main {
    public static void main(String[] args) {
        int n = (int)1E8;

        //sieve
        int[] prime = new int[n+1];
        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == 0) {
                for (int j = i*i; j < prime.length; j += i) {
                    if ((long)i * i > n) break;
                    try {prime[j] = i;} catch (Exception e) {break;}
                }
            }
        }

        long[] totient = new long[n+1];
        //calculate the primes
        for (int i = 2; i <= n; i++) 
            if (prime[i] == 0) totient[i] = i-1;
        //composites
        for (int i = 2; i <= n; i++) {
            if (prime[i] != 0) {
                //didnt have factor
                if ((i/prime[i])%prime[i] != 0) totient[i] = totient[i/prime[i]] * (prime[i]-1);
                //already had the factor
                else totient[i] = totient[i/prime[i]] * prime[i];
            }
        }
        for (int i = 2; i <= n; i++) totient[i] = i-totient[i];
        
        long sum = 0;
        for (int i = 1; i <= n; i++) sum += totient[i];
        System.out.println(sum*6);
    }
}