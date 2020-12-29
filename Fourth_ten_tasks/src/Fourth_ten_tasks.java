import java.util.Arrays;
import java.util.Scanner;

public class Fourth_ten_tasks {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Введите номер задачи, которую хотите протестировать");
        int test_num=sc.nextInt();
        switch (test_num){
            case 1:
                System.out.println("Введите числа");
                int n1 = sc.nextInt();
                int k1 = sc.nextInt();
                sc.nextLine();
                System.out.println("Введите строку");
                String s1 = sc.nextLine();
                essay(n1, k1, s1);
                break;
            case 2:
                sc.nextLine();
                System.out.println("Введите строку");
                String s2 = sc.nextLine();
                System.out.println(Arrays.toString(split(s2)));
                break;
            case 3:
                sc.nextLine();
                System.out.println("Введите строку");
                String s3 = sc.nextLine();
                System.out.println("Введите номер нужной функции: 1.toCamelCase 2.toSnakeCase");
                int choice = sc.nextInt();
                if(choice==1) {
                    System.out.println(toCamelCase(s3));
                }else{
                    System.out.println(toSnakeCase(s3));
                }
                break;
            case 4:
                double [] mas = new double[4];
                System.out.println("Введите числа");
                for(int i=0;i<4;i++){
                    mas[i]=sc.nextDouble();
                }
                System.out.println(overTime(mas));
                break;
            case 5:
                sc.nextLine();
                System.out.println("Введите вес");
                String s4 = sc.nextLine();
                System.out.println("Введите рост");
                String s5 = sc.nextLine();
                System.out.println(BMI(s4, s5));
                break;
            case 6:
                System.out.println("Введите число");
                int a1 = sc.nextInt();
                System.out.println(bugger(a1));
                break;
            case 7:
                sc.nextLine();
                System.out.println("Введите строку");
                String s6 = sc.nextLine();
                System.out.println(toStarShorthand(s6));
                break;
            case 8:
                sc.nextLine();
                System.out.println("Введите первую строку");
                String s7 = sc.nextLine();
                System.out.println("Введите вторую строку");
                String s8 = sc.nextLine();
                System.out.println(doesRhyme(s7, s8));
                break;
            case 9:
                System.out.println("Введите числа");
                int num1_1 = sc.nextInt();
                int num2_1 = sc.nextInt();
                System.out.println(trouble(num1_1, num2_1));
                break;
            case 10:
                sc.nextLine();
                System.out.println("Введите строку");
                String s9 = sc.nextLine();
                System.out.println("Введите символ");
                char a2 = sc.nextLine().charAt(0);
                System.out.println(countUniqueBooks(s9, a2));
                break;
        }
    }
    public static void essay(int n, int k, String s){
        String[] s1 = s.split(" ");
        for(int i = 0;i<=s1.length-2;i++){
            if(s1[i].length()+s1[i+1].length()==7){
                System.out.println(s1[i]+" "+s1[i+1]);
                if(i<s1.length-3){
                    i++;
                }
            }else{
                System.out.println(s1[i]);
            }
        }
    }
    public static String [] split(String s){//Допилить соответствие размера массива количеству кластеров
        String [] res = new String[s.length()/2];
        String s1 = "";
        int sc_left = 0;
        int sc_right = 0;
        int j = 0;
        //int pairs = 0;
        for(int i =0;i<=s.length()-1;i++){
            if(s.charAt(i)=='('){
                s1+=s.charAt(i);
                sc_left++;
            }else if(s.charAt(i)==')'){
                s1+=s.charAt(i);
                sc_right++;
                if(sc_left==sc_right){
                    res[j] = s1;
                    j++;
                    sc_left = sc_right = 0;
                    s1 = "";
                    //pairs+=1;
                }
            }
        }
        /*if(pairs!= res.length){
            String [] res1 = new String[pairs];
            for(int k = 0;j<res1.length;k++){
                res1[k] = res[k];
            }
            return res1;
        }*/
        return res;
    }
    public static String toCamelCase(String s){
        String[] s1 = s.split("_");
        String res = "";
        for(int i = 0;i<s1.length;i++){
            res+=Character.toUpperCase(s1[i].charAt(0))+s1[i].substring(1, s1[i].length());
        }
        return res;
    }
    public static String toSnakeCase(String s){
        String res = "";
        for(int i = 0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                res+="_"+Character.toLowerCase(s.charAt(i));
            }else {
                res += s.charAt(i);
            }
        }
        return res;
    }
    public static String overTime(double mas[]){
        if(mas[1]<=17){
            return ("$"+String.format("%1$,.2f",((mas[1]-mas[0])*mas[2])));
        }else{
            return ("$"+String.format("%1$,.2f",((17-mas[0])*mas[2]+(mas[1]-17)*mas[2]*mas[3])));
        }
    }
    public static String BMI(String weight, String height){
        double weight_num = 0;
        if(weight.indexOf("pounds")!=-1){
            weight_num = Double.parseDouble(weight.substring(0, weight.indexOf("pounds")))*0.4536;
        }else{
            weight_num = Double.parseDouble(weight.substring(0, weight.indexOf("kilos")));
        }
        double height_num = 0;
        if(height.indexOf("inches")!=-1){
            height_num = Double.parseDouble(height.substring(0, height.indexOf("inches")))*0.0254;
        }else{
            height_num = Double.parseDouble(height.substring(0, height.indexOf("meters")));
        }
        double mass_index = (weight_num/(height_num*height_num));//*10000;
        if(mass_index<18.5){
            return (String.format("%1$,.1f", mass_index)+" Underweight");
        }else if(mass_index<=24.9){
            return (String.format("%1$,.1f", mass_index)+" Normal Weight");
        }else{
            return (String.format("%1$,.1f", mass_index)+" Overweight");
        }
    }
    public static int bugger(int a){//Сомнительный код, скорее всего нужно будет много дебагать
        int plh = a;
        int sum = a;
        int count = 0;
        while(sum/10!=0){
            sum=plh%10;
            while(plh/10!=0){
                plh/=10;
                sum*=plh%10;
            }
            plh=sum;
            count+=1;
        }
        return count;
    }
    public static String toStarShorthand(String s){
        if(s.length()==1){
            return s;
        }
        int count = 1;
        String s1 = "";
        char plh = s.charAt(0);
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==plh){
                count+=1;
            }else{
                if(count>1){
                    s1+=plh+"*"+count;
                }else{
                    s1+=plh;
                }
                count = 1;
                plh = s.charAt(i);
            }
        }
        if(count>1){
            s1+=plh+"*"+count;
        }else{
            s1+=plh;
        }
        return s1;
    }
    public static boolean doesRhyme(String s1, String s2){
        String [] s1_words = s1.split(" ");
        String s1_last_word = s1_words[s1_words.length-1];
        String [] s2_words = s2.split(" ");
        String s2_last_word = s2_words[s2_words.length-1];
        String s1_gl = "";
        String s2_gl = "";
        for(int i = 0;i<s1_last_word.length();i++){
            if((Character.toLowerCase(s1_last_word.charAt(i))=='a')||(Character.toLowerCase(s1_last_word.charAt(i))=='e')||(Character.toLowerCase(s1_last_word.charAt(i))=='i')||(Character.toLowerCase(s1_last_word.charAt(i))=='o')||(Character.toLowerCase(s1_last_word.charAt(i))=='u')){
               s1_gl+=Character.toLowerCase(s1_last_word.charAt(i));
            }
        }
        for(int j = 0;j<s2_last_word.length();j++){
            if((Character.toLowerCase(s2_last_word.charAt(j))=='a')||(Character.toLowerCase(s2_last_word.charAt(j))=='e')||(Character.toLowerCase(s2_last_word.charAt(j))=='i')||(Character.toLowerCase(s2_last_word.charAt(j))=='o')||(Character.toLowerCase(s2_last_word.charAt(j))=='u')){
                s2_gl+=Character.toLowerCase(s2_last_word.charAt(j));
            }
        }
        return (s1_gl.equals(s2_gl));
    }
    public static boolean trouble(int num1, int num2){//Трабл не работает :D
        int count1 = 0;
        String str_num1 = String.valueOf(num1);
        char plh = str_num1.charAt(0);
        char repeat = str_num1.charAt(0);
        int count2 = 0;
        String str_num2 = String.valueOf(num2);
        for(int i = 1; i<str_num1.length();i++){
            if(str_num1.charAt(i)==plh){
                count1+=1;
            }else{
                plh=str_num1.charAt(i);
                count1 = 1;
            }
            if(count1==3){
                repeat = str_num1.charAt(i);
                break;
            }
        }
        for(int j = 0;j<str_num2.length();j++){
            if(str_num2.charAt(j)==repeat){
                count2+=1;
            }else{
                count2 = 0;
            }
            if(count2==2){
                return true;
            }
        }
        return false;
    }
    public static int countUniqueBooks(String s, char a){
        int count = 0;
        int a_in_txt = 0;
        int plh = 0;
        //int prev = -1;
        for(int i = 0;i<s.length();i++){
            //if(s.charAt(i)==a && prev==-1){
              //  prev = i;
            //}else
             if(s.charAt(i)==a){//&& prev!=-1
                //count+=i-prev-1;
               // prev=i;
                 a_in_txt+=1;
                 count+=plh;
                 plh = 0;
            }else if((s.charAt(i)!=s.charAt(i-1))&&(a_in_txt%2!=0)){
                 plh+=1;
             }
        }
        return count;
    }
}
