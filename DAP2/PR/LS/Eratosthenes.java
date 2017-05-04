public class Eratosthenes{

  public static void main(String[] args) {

    int n = Integer.parseInt(args[0]);
            boolean[] primeList = sieve(n);
            if(args.length > 1){
                String param = args[1];
                if(param.charAt(0) == '-' && param.charAt(1) == 'o'){
                    int primeCount = 0;
                    int nCount = 0;
                    for(boolean bool : primeList){
                        if(bool){
                            System.out.print(nCount+"\t");
                            ++primeCount;
                        }
                        ++nCount;
                    }
                    System.out.println("\nTotal primes:\t"+primeCount);
                }else{
                    throw new IllegalArgumentException("Unknown parameter:\t"+param);
                }
            }else{
                int primeCount = 0;
                int len = primeList.length;
                for(int i = 0; i < len; ++i)
                    if(primeList[i]) ++primeCount;
                System.out.println("Total primes:\t"+primeCount);
            }

  }


  public static boolean[] sieve(int n){
        boolean[] result = new boolean[n];
        for(boolean b : result){
            b = true;
        }
        for(int i=0; i<n; ++i){
            if(result[i]){
                for(int j=2; i*j<n; ++j){
                    result[j] = false;
                }
            }
        }
        return result;
    }


}
