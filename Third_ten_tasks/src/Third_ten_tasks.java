import java.util.Scanner;

public class Third_ten_tasks {
    public static void main(String [] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Введите номер задачи, которую хотите протестировать");
        int test_num=sc.nextInt();
        switch (test_num){
            case 1:
                System.out.println("Введите числа");
                int a1 = sc.nextInt();
                int b1 = sc.nextInt();
                int c1 = sc.nextInt();
                System.out.println(solutions(a1, b1, c1));
                break;
            case 2:
                sc.nextLine();
                System.out.println("Введите строку");
                String s = sc.nextLine();
                System.out.println(findZip(s));
                break;
            case 3:
                System.out.println("Введите число");
                int a2 = sc.nextInt();
                System.out.println(checkPerfect(a2));
                break;
            case 4:
                sc.nextLine();
                System.out.println("Введите строку");
                String s1 = sc.nextLine();
                System.out.println(flipEndChars(s1));
                break;
            case 5:
                sc.nextLine();
                System.out.println("Введите строку");
                String s2 = sc.nextLine();
                System.out.println(isValidHexCode(s2));
                break;
            case 6:
                System.out.println("Введите количество элементов первого массива");
                int size = sc.nextInt();
                int [] mas = new int[size];
                System.out.println("Введите числа");
                for(int i=0;i<size;i++){
                    mas[i]=sc.nextInt();
                }
                System.out.println("Введите количество элементов второго массива");
                int size1 = sc.nextInt();
                int [] mas1 = new int[size1];
                System.out.println("Введите числа");
                for(int i=0;i<size1;i++){
                    mas1[i]=sc.nextInt();
                }
                System.out.println(same(mas, mas1));
                break;
            case 7:
                System.out.println("Введите число");
                int a3 = sc.nextInt();
                System.out.println(isKaprekar(a3));
                break;
            case 8:
                sc.nextLine();
                System.out.println("Введите строку");
                String s3 = sc.nextLine();
                System.out.println(longestZero(s3));
                break;
            case 9:
                System.out.println("Введите число");
                int a4 = sc.nextInt();
                System.out.println(nextPrime(a4));
                break;
            case 10:
                System.out.println("Введите числа");
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int z1 = sc.nextInt();
                System.out.println(rightTriangle(x1, y1, z1));
                break;
        }
    }
    public static int solutions(int a, int b, int c){
        int D = b*b-4*a*c;
        if (D>0){
            return 2;
        }else{
            if (D==0){
                return 1;
            }else return 0;
        }
    }
    public static int findZip(String s){
        String substr = "zip";
        int zip1 = s.indexOf(substr);
        String s1 = s.substring(zip1+3, s.length());
        if(s1.indexOf(substr)==-1){
            return(s1.indexOf(substr));
        }
        return(s1.indexOf(substr)+s.indexOf(substr)+3);
    }
    public static boolean checkPerfect(int a){
        int sum = 0;
        for(int i=1;i<a;i++){
            if(a%i==0){
                sum+=i;
            }
        }
        return (sum==a);
    }
    public static String flipEndChars(String s){
        if(s.length()<2){
            return("несовместимо");
        }else{
            if(s.charAt(0)==s.charAt(s.length()-1)){
                return("два - это пара.");
            }else{
                String s1 = s.charAt(s.length()-1) + s.substring(1, s.length()-1) + s.charAt(0);
                return s1;
            }
        }
    }
    public static boolean isValidHexCode(String s){
        if((s.charAt(0) != '#')||(s.length()!=7)){
            return false;
        }else{
            for(int i=1;i<=s.length()-1;i++){
                if(!((Character.isDigit(s.charAt(i)))||(s.charAt(i)>='A' && s.charAt(i)<='F'))){
                    return false;
                }
            }
            return true;
        }
    }
    public static boolean same(int mas[], int mas1[]){
        int unique1 = 0;
        int unique2 = 0;
        for(int i=0;i<= mas.length-1;i++){
            boolean unique = true;
            for(int j=0;j<=mas.length-1;j++){
                if((mas[j]==mas[i])&&(j!=i)&&(j>i)){
                    unique = false;
                }
                //System.out.println(unique);
                //System.out.println(unique1);
            }
            if(unique){
                unique1+=1;
            }
        }
        for(int i=0;i<= mas1.length-1;i++){
            boolean unique_mas1 = true;
            for(int j=0;j<=mas1.length-1;j++){
                if((mas1[j]==mas1[i])&&(j!=i)&&(j>i)){
                    unique_mas1 = false;
                }
            }
            if(unique_mas1){
                unique2+=1;
            }
        }
        return(unique1==unique2);
    }
    public static boolean isKaprekar(int a){
        String num = String.valueOf(a*a);
        String left = "";
        String right = "";
        if(num.length()==1){
            return(num==String.valueOf(a));
        }else{
                left = num.substring(0, num.length()/2);
                right = num.substring(num.length()/2, num.length());

        }
        return((Integer.parseInt(left)+Integer.parseInt(right))==a);
    }
    public static String longestZero(String s){
        String longest_zero = "";
        String s1 = "";
        for(int i=0;i<=s.length()-1;i++){
            if(s.charAt(i)=='0'){
                s1+=s.charAt(i);
            }else{
                if(s1.length()>longest_zero.length()){
                    longest_zero = s1;
                }
                s1 = "";
            }
        }
        return longest_zero;
    }
    public static int nextPrime(int a){
        int plh = a;
        while(true){
            boolean check = true;
            for(int i=2;i<plh;i++){
                if(plh%i==0){
                    check = false;
                    break;
                }
            }
            if(check){
               return plh;
            }
            plh++;
        }
    }
    public static boolean rightTriangle(int x, int y , int z){
        if((x>y)&&(x>z)){
            return(x == Math.sqrt(y*y+z*z));
        }else{
            if((y>x)&&(y>z)){
                return(y == Math.sqrt(x*x+z*z));
            }else{
                return(z == Math.sqrt(y*y+x*x));
            }
        }
    }
}