import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {//определяет, являются ли введёные через консоль строки палиндромами
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] words= in.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(isPalindrome(words[i])){
                System.out.println("строка "+words[i]+" является палиндромом");
            }
        }
    }
    public static String reverseString(String s){//переворачивает строку
        String rev = "";
        for (int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        return rev;
    }
    public static boolean isPalindrome(String s){//определяет, является ли строка палиндромом
        String rev= reverseString(s);
        if (s.equals(rev)){
            return true;
        }
        else {
            return false;
        }
    }
}
