
import java.util.LinkedList;
import java.util.Random;
class Prime{
    private LinkedList<Integer> primes;

    public Prime(int max){
        primes = new LinkedList<>();
        boolean[] isPrime = new boolean[max + 1];
        for (int i =2; i<= max; i++){
            isPrime[i]=true;
        }
        for (int i =2; i<=Math.sqrt(max); i++){
            if (isPrime[i]){
                for (int j = i *i; j<=max; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for (int i =2; i<=max; i++){
            if (isPrime[i]){
                primes.add(i);
            }
            }
        }
        public boolean isPrime(int num){

            for (int prime : primes){
                if (num == prime){
                    return true;
                }
            }
            return false;
        }
        public int getPrime(int position){
            return primes.get(position);
        }
        public int getSize(){
        return primes.size();
        }
    }

class Main {
    private static final int MAX_CONSTANT = 10000;
    private static final Random random = new Random();

    public static int findFactor(int target, Prime prime) {
        if (target < 2) {
            return -1;
        }
        for (int i =0; i<prime.getSize(); i++){
            int primeNumber = prime.getPrime(i);
            if (target % primeNumber == 0) {
            return primeNumber;
        }
    }
    return-1;
}

    public static void main(String [] args){
        Prime prime = new Prime(MAX_CONSTANT);
        Random random = new Random();
        int target;
        do{
            target = random.nextInt(MAX_CONSTANT);
        }
        while(target<2 || prime.isPrime(target));
     System.out.println("What primes make up " + target + "?");
     int factor;
     while (target >=2){
         factor = findFactor(target, prime);
         System.out.print(factor);
         target /=factor;
         if (target>=2){
             System.out.print("x");
         }
     }

    }
}