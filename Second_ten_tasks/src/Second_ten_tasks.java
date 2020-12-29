import java.util.Arrays;
import java.util.Scanner;

public class Second_ten_tasks {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задачи, которую хотите протестировать");
        int test_num=sc.nextInt();
        switch (test_num){
            case 1:
                sc.nextLine();
                System.out.println("Введите строку");
                String s = sc.nextLine();
                System.out.println("Введите число");
                int r = sc.nextInt();
                System.out.println(repeat(s, r));
                break;
            case 2:
                System.out.println("Введите количество элементов массива");
                int size = sc.nextInt();
                int [] mas = new int[size];
                System.out.println("Введите числа");
                for(int i=0;i<size;i++){
                    mas[i]=sc.nextInt();
                }
                System.out.println(differenceMaxMin(mas));
                break;
            case 3:
                System.out.println("Введите количество элементов массива");
                int size1 = sc.nextInt();
                int [] mas1 = new int[size1];
                System.out.println("Введите числа");
                for(int i=0;i<size1;i++){
                    mas1[i]=sc.nextInt();
                }
                System.out.println(isAvgWhole(mas1));
                break;
            case 4:
                System.out.println("Введите количество элементов массива");
                int size2 = sc.nextInt();
                int [] mas2 = new int[size2];
                System.out.println("Введите числа");
                for(int i=0;i<size2;i++){
                    mas2[i]=sc.nextInt();
                }
                System.out.println(Arrays.toString(cumulativeSum(mas2)));
                break;
            case 5:
                sc.nextLine();
                System.out.println("Введите число(в формате строки)");
                String a = sc.nextLine();
                System.out.println(getDecimalPlaces(a));
                break;
            case 6:
                System.out.println("Введите число");
                int a1 = sc.nextInt();
                System.out.println(Fibonacci(a1));
                break;
            case 7:
                sc.nextLine();
                System.out.println("Введите строку(индекс)");
                String s1 = sc.nextLine();
                System.out.println(isValid(s1));
                break;
            case 8:
                sc.nextLine();
                System.out.println("Введите первую строку");
                String s2 = sc.nextLine();
                System.out.println("Введите вторую строку");
                String s3 = sc.nextLine();
                System.out.println(isStrangePair(s2, s3));
                break;
            case 9:
                sc.nextLine();
                System.out.println("Введите номер функции, которую хотите протестировать: 1. isPrefix 2. isSuffix");
                int choice = sc.nextInt();
                sc.nextLine();
                System.out.println("Введите слово");
                String word = sc.nextLine();
                if(choice == 1){
                    System.out.println("Введите префикс");
                    String pref1 = sc.nextLine();
                    System.out.println(isPrefix(word, pref1));
                }else if(choice == 2){
                    System.out.println("Введите суффикс");
                    String suff1 = sc.nextLine();
                    System.out.println(isSuffix(word, suff1));
                }
                break;
            case 10:
                System.out.println("Введите число");
                int a2 = sc.nextInt();
                System.out.println(boxSeq(a2));
                break;
        }
    }
    public static String repeat(String s, int r){
        String res="";
        for (int i=0;i<s.length();i++){
            for(int j=1;j<=r;j++){
                res+=s.charAt(i);
            }
        }
        return res;
    }
    public static int differenceMaxMin(int [] mas){
        int max=0;
        int min=mas[0];
        for(int i=0;i<mas.length;i++){
            if(mas[i]>max){
                max=mas[i];
            }
            if(mas[i]<min){
                min=mas[i];
            }
        }
        return max-min;
    }
    public static boolean isAvgWhole(int [] mas){
        double avr=0;
        for(int i=0; i<mas.length;i++){
            avr+=mas[i];
        }
        avr=avr/mas.length;
        return(avr%1==0);
    }
    public static int [] cumulativeSum(int [] mas){
        int [] res = new int[mas.length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<=i;j++){
                res[i]+=mas[j];
            }
        }
        return(res);
    }
    public static int getDecimalPlaces(String s){
        return(s.length()-s.indexOf(".")-1);
    }
    public static int Fibonacci(int a){//проверить, наверняка есть ошибка
        int res = 1;
        int prev = 0;
        int pl = 0;
        for (int i=1; i<=a; i++){
            pl=res;
            res=res+prev;
            prev=pl;
        }
        return(res);
    }
    public static boolean isValid (String index){
        for(int i=0; i<=index.length()-1;i++){
            if(!(Character.isDigit(index.charAt(i)))){
                return false;
            }
        }
        return(index.length()<=5);
    }
    public static boolean isStrangePair(String s, String s1){
        return(((s=="")&&(s1==""))||((s.charAt(0)==s1.charAt(s1.length()-1))&&(s.charAt(s.length()-1)==s1.charAt(0))));
    }
    public static boolean isPrefix(String s, String pref){
        String s1 = "";
        for(int i=0;i<pref.indexOf("-");i++){
            s1+=s.charAt(i);
        }
        s1+="-";
        return(s1.equals(pref));
    }
    public static boolean isSuffix(String s, String suff){
        String s1 = "";
        for(int i=s.length()-1;i>s.length()-suff.length();i--){
            s1=s.charAt(i)+s1;
        }
        s1="-"+s1;
        return(s1.equals(suff));
    }
    public static int boxSeq(int a){
        int res=0;
        for (int i=1;i<=a;i++){
            if(i%2==0){
                res--;
            }
            else{
                res+=3;
            }
        }
        return(res);
    }
}
