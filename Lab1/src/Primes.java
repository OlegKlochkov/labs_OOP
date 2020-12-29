public class Primes {
    public static void main(String[] args){//вывод простых чисел от 1 до 100
        for (int i=2;i<=100;i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean isPrime(int n){//проверка на то, является ли число простым
        for (int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}