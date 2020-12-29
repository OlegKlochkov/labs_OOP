import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Arrays;
//import java.lang.Math;
import java.security.MessageDigest;

public class Fifth_ten_tasks {
    public static void main(String [] args) throws NoSuchAlgorithmException {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Введите номер задачи, которую хотите протестировать");
        int test_num=sc.nextInt();
        switch (test_num){
            case 1:
                System.out.println("Введите номер нужной функции: 1.encrypt 2.decrypt");
                int choice = sc.nextInt();
                if(choice==1) {
                    sc.nextLine();
                    System.out.println("Введите строку");
                    String s1 = sc.nextLine();
                    System.out.println(Arrays.toString(encrypt(s1)));
                }else{
                    System.out.println("Введите количество элементов массива");
                    int size1 = sc.nextInt();
                    int [] mas1 = new int[size1];
                    System.out.println("Введите числа");
                    for(int i=0;i<size1;i++){
                        mas1[i]=sc.nextInt();
                    }
                    System.out.println(decrypt(mas1));
                }
                break;
            case 2:
                sc.nextLine();
                System.out.println("Введите фигуру");
                String s2 = sc.nextLine();
                System.out.println("Введите стартовую позицию");
                String s3 = sc.nextLine();
                System.out.println("Введите конечную позицию");
                String s4 = sc.nextLine();
                System.out.println(canMove(s2, s3, s4));
                break;
            case 3:
                sc.nextLine();
                System.out.println("Введите первую строку");
                String s5 = sc.nextLine();
                System.out.println("Введите вторую строку");
                String s6 = sc.nextLine();
                System.out.println(canComplete(s5, s6));
                break;
            case 4:
                System.out.println("Введите количество элементов массива");
                    int size2 = sc.nextInt();
                    int [] mas2 = new int[size2];
                    System.out.println("Введите числа");
                    for(int i=0;i<size2;i++){
                        mas2[i]=sc.nextInt();
                    }
                    System.out.println(sumDigProd(mas2));

                break;
            case 5:
                sc.nextLine();
                System.out.println("Введите массив строк");
                String [] words1 = sc.nextLine().split(" ");
                System.out.println(Arrays.toString(sameVowelGroup(words1)));
                break;
            case 6:
                System.out.println("Введите число");
                //int card = sc.nextInt();
                long card = sc.nextLong();
                System.out.println(validateCard(card));
                break;
            case 7:
                System.out.println("Введите число");
                int a2 = sc.nextInt();
                System.out.println("Введите номер нужной функции 1. numToEng 2. numToRu");
                int choice1 = sc.nextInt();
                if (choice1 == 1){
                    System.out.println(numToEng(a2));
                }else{
                    System.out.println(numToRu(a2));
                }
                break;
            case 8:
                sc.nextLine();
                System.out.println("Введите строку");
                String s8 = sc.nextLine();
                System.out.println(getSha256Hash(s8));
                break;
            case 9:
                sc.nextLine();
                System.out.println("Введите строку");
                String s7 = sc.nextLine();
                System.out.println(correctTitle(s7));
                break;
            case 10:
                System.out.println("Введите число");
                int a3 = sc.nextInt();
                System.out.println(hexLattice(a3));
                break;
        }
    }
    public static int [] encrypt(String s){
        int mas[] = new int[s.length()];//length()-1 ???
        //mas[0] = (int)(s.charAt(0));
        mas[0] = s.charAt(0);
        for(int i = 1;i<s.length();i++){
            //mas[i]=mas[0]-(int)(s.charAt(i));
            mas[i] = s.charAt(i)-s.charAt(i-1);
        }
        return mas;
    }
    public static String decrypt(int mas[]){
        String s = "" + (char)(mas[0]);
        for(int i = 1;i< mas.length;i++){
            s+=(char)(mas[i-1]+mas[i]);
            mas[i] = mas[i-1]+mas[i];
        }
        return s;
    }
    public static boolean canMove(String figure, String pos_1, String pos_2){
        switch (figure){
            case "Rook"://Ладья
                return ((pos_1.charAt(0)==pos_2.charAt(0))||(pos_1.charAt(1)==pos_2.charAt(1)));
            case "Knight"://Конь
                return (((Math.abs((int)(pos_1.charAt(0)-(int)(pos_2.charAt(0))))==1)&&(Math.abs((int)(pos_1.charAt(1)-(int)(pos_2.charAt(1))))==3))||((Math.abs((int)(pos_1.charAt(0)-(int)(pos_2.charAt(0))))==3)&&(Math.abs((int)(pos_1.charAt(1)-(int)(pos_2.charAt(1))))==1)));
            case "Bishop"://Слон
                return (Math.abs((int)(pos_1.charAt(0))-(int)(pos_2.charAt(0)))==(Math.abs((int)(pos_1.charAt(1)-(int)(pos_2.charAt(1))))));
            case "Pawn":
                return ((pos_1.charAt(0)==pos_2.charAt(0))&&(Math.abs((int)(pos_1.charAt(1)-(int)(pos_2.charAt(1))))==1));
            case "King":
                return ((Math.abs((int)(pos_1.charAt(0)-(int)(pos_2.charAt(0))))==1)&&(Math.abs((int)(pos_1.charAt(1)-(int)(pos_2.charAt(1))))==1));
            case "Queen":
                if(((Math.abs((int)(pos_1.charAt(0)-(int)(pos_2.charAt(0))))==1)&&(Math.abs((int)(pos_1.charAt(1)-(int)(pos_2.charAt(1))))>3))||((Math.abs((int)(pos_1.charAt(0)-(int)(pos_2.charAt(0))))>3)&&(Math.abs((int)(pos_1.charAt(1)-(int)(pos_2.charAt(1))))==1))){
                    return false;
                }else{
                    return true;
                }
        }
        return false;
    }
    public static boolean canComplete(String substr, String s){
        int pos = -1;
        int pos1 = -1;
        for(int i = 0;i<substr.length();i++){
            if(s.indexOf(substr.charAt(i))!=-1){
                pos1 = s.indexOf(substr.charAt(i));
                if(pos1<pos){
                    return false;
                }
                }else{
                return false;
            }
            pos = pos1;
        }
        return true;
    }
    public static int sumDigProd(int [] mas){
        int a = 0;
        for(int i = 0;i< mas.length; i++){
            a+=mas[i];
        }
        while (a/10!=0){
            int plh = 1;
            while(a>0){
                plh*= a%10;
                a=a/10;
            }
        a = plh;
        }
        return a;
    }
    public static String [] sameVowelGroup(String [] words){
        String res_s = "";
        String words_gl = "";
        for(int i = 0;i<words[0].length();i++){
            if((Character.toLowerCase(words[0].charAt(i))=='a')||(Character.toLowerCase(words[0].charAt(i))=='e')||(Character.toLowerCase(words[0].charAt(i))=='i')||(Character.toLowerCase(words[0].charAt(i))=='o')||(Character.toLowerCase(words[0].charAt(i))=='u')){
                words_gl+=Character.toLowerCase(words[0].charAt(i));
            }
        }
        res_s+=words[0];
        for(int j = 1;j< words.length;j++){
            boolean sameVowel = true;
            for(int k = 0;k<words[j].length();k++){
                if((Character.toLowerCase(words[j].charAt(k))=='a')||(Character.toLowerCase(words[j].charAt(k))=='e')||(Character.toLowerCase(words[j].charAt(k))=='i')||(Character.toLowerCase(words[j].charAt(k))=='o')||(Character.toLowerCase(words[j].charAt(k))=='u')){
                    if(words_gl.indexOf(words[j].charAt(k))==-1){
                        sameVowel = false;
                        break;
                    }
                }
            }
            if(sameVowel){
                res_s+=" "+words[j];
            }
        }
        String [] res = res_s.split(" ");
        return res;
    }
    public static boolean validateCard(long a){
        String s = String.valueOf(a/10);
        int last_digit = (int) (a%10);
        String reverse = "";
        for(int i = s.length()-1;i>=0;i--){
            reverse=s.charAt(i)+reverse;
        }
        int sum = 0;
        int mas[] = new int[reverse.length()];
        for(int j = 0;j< mas.length;j++){
            if((j%2==0)&&(j!=0)){
                mas[j] =reverse.charAt(j)*2;
                if(mas[j]%10!=0){
                    mas[j]=mas[j]/10+mas[j]%10;
                }
                sum+=mas[j];
            }else{
                mas[j] = reverse.charAt(j);
            }
        }
        return ((10-sum%10)==last_digit);
    }
    public static String numToEng(int a){
        String res = "";
        if((a%100)/10!=1){
            switch(a%10){
                case 0:
                    if(a%10==a){
                        return "zero";
                    }
                    break;
                case 1:
                    res+="one";
                    break;
                case 2:
                    res+="two";
                    break;
                case 3:
                    res+="three";
                    break;
                case 4:
                    res+="four";
                    break;
                case 5:
                    res+="five";
                    break;
                case 6:
                    res+="six";
                    break;
                case 7:
                    res+="seven";
                    break;
                case 8:
                    res+="eight";
                    break;
                case 9:
                    res+="nine";
                    break;

            }
            if((a%100)/10==0){
                return res;
            }else{
                switch((a%100)/10){
                    case 2:
                        res="twenty "+ res;
                        break;
                    case 3:
                        res="thirty " + res;
                        break;
                    case 4:
                        res="fourty " + res;
                        break;
                    case 5:
                        res="fifty " + res;
                        break;
                    case 6:
                        res="sixty " + res;
                        break;
                    case 7:
                        res="seventy " + res;
                        break;
                    case 8:
                        res="eighty " + res;
                        break;
                    case 9:
                        res="ninety " + res;
                }
                if(a/100==0){
                    return res;
                }else{
                    switch(a/100){
                        case 1:
                            res="one hundred " + res;
                            break;
                        case 2:
                            res="two hundred " + res;
                            break;
                        case 3:
                            res="three hundred " + res;
                            break;
                        case 4:
                            res="four hundred " + res;
                            break;
                        case 5:
                            res="five hundred " + res;
                            break;
                        case 6:
                            res="six hundred " + res;
                            break;
                        case 7:
                            res="seven hundred " + res;
                            break;
                        case 8:
                            res="eight hundred " + res;
                            break;
                        case 9:
                            res="nine hundred " + res;
                            break;
                    }
                    return res;
                }
            }
        }else{
            switch (a%100){
                case 10:
                    res="ten";
                    break;
                case 11:
                    res="eleven";
                    break;
                case 12:
                    res="twelve";
                    break;
                case 13:
                    res="thirteen";
                    break;
                case 14:
                    res="fourteen";
                    break;
                case 15:
                    res="fifteen";
                    break;
                case 16:
                    res="sixteen";
                    break;
                case 17:
                    res="seventeen";
                    break;
                case 18:
                    res="eighteen";
                    break;
                case 19:
                    res="nineteen";
                    break;
            }
            switch(a/100){
                case 1:
                    res="one hundred " + res;
                    break;
                case 2:
                    res="two hundred " + res;
                    break;
                case 3:
                    res="three hundred " + res;
                    break;
                case 4:
                    res="four hundred " + res;
                    break;
                case 5:
                    res="five hundred " + res;
                    break;
                case 6:
                    res="six hundred " + res;
                    break;
                case 7:
                    res="seven hundred " + res;
                    break;
                case 8:
                    res="eight hundred " + res;
                    break;
                case 9:
                    res="nine hundred " + res;
                    break;
            }
            return res;
        }
    }
    public static String numToRu(int a){//Заменить англ. цифры на русск.
        String res = "";
        if((a%100)/10!=1){
            switch(a%10){
                case 0:
                    if(a%10==a){
                        return "ноль";
                    }
                    break;
                case 1:
                    res+="один";
                    break;
                case 2:
                    res+="два";
                    break;
                case 3:
                    res+="три";
                    break;
                case 4:
                    res+="четыре";
                    break;
                case 5:
                    res+="пять";
                    break;
                case 6:
                    res+="шесть";
                    break;
                case 7:
                    res+="семь";
                    break;
                case 8:
                    res+="восемь";
                    break;
                case 9:
                    res+="девять";
                    break;

            }
            if((a%100)/10==0){
                return res;
            }else{
                switch((a%100)/10){
                    case 2:
                        res="двадцать "+ res;
                        break;
                    case 3:
                        res="тридцать " + res;
                        break;
                    case 4:
                        res="сорок " + res;
                        break;
                    case 5:
                        res="пятьдесят " + res;
                        break;
                    case 6:
                        res="шестьдесят " + res;
                        break;
                    case 7:
                        res="семьдесят " + res;
                        break;
                    case 8:
                        res="восемьдесят " + res;
                        break;
                    case 9:
                        res="девяносто " + res;
                }
                if(a/100==0){
                    return res;
                }else{
                    switch(a/100){
                        case 1:
                            res="сто " + res;
                            break;
                        case 2:
                            res="двести " + res;
                            break;
                        case 3:
                            res="триста " + res;
                            break;
                        case 4:
                            res="четыреста " + res;
                            break;
                        case 5:
                            res="пятьсот " + res;
                            break;
                        case 6:
                            res="шестьсот " + res;
                            break;
                        case 7:
                            res="семьсот " + res;
                            break;
                        case 8:
                            res="восемьсот " + res;
                            break;
                        case 9:
                            res="девятьсот " + res;
                            break;
                    }
                    return res;
                }
            }
        }else{
            switch (a%100){
                case 10:
                    res="десять";
                    break;
                case 11:
                    res="одиннадцать";
                    break;
                case 12:
                    res="двенадцать";
                    break;
                case 13:
                    res="тринадцать";
                    break;
                case 14:
                    res="четырнадцать";
                    break;
                case 15:
                    res="пятнадцать";
                    break;
                case 16:
                    res="шестнадцать";
                    break;
                case 17:
                    res="семнадцать";
                    break;
                case 18:
                    res="восемнадцать";
                    break;
                case 19:
                    res="девятнадцать";
                    break;
            }
            switch(a/100){
                case 1:
                    res="сто " + res;
                    break;
                case 2:
                    res="двести " + res;
                    break;
                case 3:
                    res="триста " + res;
                    break;
                case 4:
                    res="четыреста " + res;
                    break;
                case 5:
                    res="пятьсот " + res;
                    break;
                case 6:
                    res="шестьсот " + res;
                    break;
                case 7:
                    res="семьсот " + res;
                    break;
                case 8:
                    res="восемьсот " + res;
                    break;
                case 9:
                    res="девятьсот " + res;
                    break;
            }
            return res;
        }
    }
    public static String getSha256Hash(String s) throws NoSuchAlgorithmException {//StackOverflow выручает, но как оно работает - хз
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(s.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for(int i = 0; i<hash.length;i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append(0);
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String correctTitle(String s){
        String res = "";
        String [] parts = s.split(" ");
        for(int i = 0;i<parts.length;i++){
            if(parts[i].toLowerCase().equals("and") || parts[i].toLowerCase().equals("the") || parts[i].toLowerCase().equals("of") || parts[i].toLowerCase().equals("in")){
                res+=parts[i].toLowerCase() + " ";
            }else{
                res+= Character.toUpperCase(parts[i].charAt(0))+parts[i].substring(1).toLowerCase() + " ";
            }
        }
        return res;
    }
    public static String hexLattice(int a){
        /*
    n   число                    закономерность
    0    1                              -
    1    7 = 1+6                  n[0]+6n
    2    19 = 7 +12 = 7+6*2       n[1]+6n
    3    37 = 19+18 = 19+6*3      n[2]+6n
        Теперь к выводу шестиугольников
        кол-во строк = 1+2n
        в первой строке и последней строке по 1+n символов "о"
        дальше прибавляется по 1 "о" до средней строки включительно
        потом убывает по одному(или же можно приравнять к предыдущим строкам как-нибудь)
        через n-1:
        1+2(n-1)
        n
        Добавлять результат в одну строку, разделяя с помощью /n
        При возможности и желании оптимизировать без первого for
         */
        int n  = 1;
        int csc = 1;
        for (int i = 1; i<=a;i++){
            if (i == csc+6*n){
                csc = i;
                n++;
            }
        }
        //int kl = n;//кол-во пробелов для первой строки
        if (a == csc){
            int size = 1+2*(n-1);
            String [] res = new String[size];
            for(int j = 0;j<size;j++){
               if(j<=size/2) {
                   if (j == 0) {
                       res[j] = "";
                       for(int m = 0; m<(n-1);m++){//добавление пробелов
                           res[j]+=" ";
                       }
                       for (int k = 0; k < n; k++) {
                           res[j] += " o";
                       }
                   } else {
                       //res[j]=res[j-1]+"o";
                       res[j]=res[j-1].substring(1)+" o";
                   }
               }else{
                   res[j] = res[size - j - 1];
               }
            }
            String ret = "";
            for(int l = 0;l<size;l++){
                /*String otst = "";//строка с пробелами
                for(int m = 0; m<kl;m++){//пробелы
                    otst+=" ";
                    kl--;
                }
                 */
                ret+=res[l] +"\n";
            }
            return(ret);
        }else{
            return("недопустимое");
        }
    }
}
