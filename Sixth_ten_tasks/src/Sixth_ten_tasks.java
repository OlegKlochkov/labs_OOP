import java.util.*;

public class Sixth_ten_tasks {
    public static void main(String [] args){
       /*System.out.println("Введите номер задачи");
       Scanner sc = new Scanner(System.in);
       int taskNum = sc.nextInt();
       switch (taskNum){
           case 1:
               System.out.println("Введите число");

        }
        */
        System.out.println("task 1 input:3");
        System.out.println(bell(3));

        System.out.println("task 2 input:flag");
        System.out.println(translateWord("flag"));

        System.out.println("task 2 input:apple");
        System.out.println(translateWord("apple"));


        System.out.println("task 3 input:rgba(0,0,0,0.123456789)");
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));

        System.out.println("task 4 input:https://edabit.com?a=1&b=2&a=2");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));

        System.out.println("task 4 input:\"https://edabit.com?a=1&b=2&a=2\", \"b\"");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", "b"));

        System.out.println("task 5 input:How the Avocado Became the Fruit of the Global Trade");
        System.out.println(Arrays.toString(getHashTags("How the Avocado Became the Fruit of the Global Trade")));

        System.out.println("task 6 input:9");
        System.out.println(ulam(9));

        System.out.println("task 7 input:abcabcbb");
        System.out.println(longestNonrepeatingSubstring("abcabcbb"));

        System.out.println("task 8 input:12");
        System.out.println(convertToRoman(12));

        System.out.println("task 9 input:6 * 4 = 24");
        System.out.println(formula("6 * 4 = 24"));

        System.out.println("task 10 input:11211230");
        System.out.println(palindromeDescendant(11211230));
    }
    public static int bell(int a){
        int[][] bell = new int[a+1][a+1];
        bell[0][0] = 1;

        for (int i=1; i<=a; i++)
        {
            bell[i][0] = bell[i-1][i-1];//Заполнение при j=0
            for (int j=1; j<=i; j++)//Заполнение при j!=0
                bell[i][j] = bell[i-1][j-1] + bell[i][j-1];
        }

        return bell[a][0];
    }
    public static String translateWord(String s){
        String vowel = "aeiouyAEIOUY";
        if (vowel.indexOf(s.charAt(0)) != -1) {
            s += "yay";
        }
        else {
            String newWord = s.split("[aeiouy]")[0];
            s = s.replaceFirst(newWord, "") + newWord + "ay";
        }
        return s;
    }
    public static String translateSentence(String s) {
        String vow = "aeiouyAEIOUY";
        String[] newword = s.substring(0, s.length() - 1).split(" ");
        s = "";
        for (String s1 : newword) {
            for (int j = 0; j < vow.length(); j++) {
                if (vow.indexOf(s1.charAt(j)) != -1) {
                    s1 += s1 + "yay ";
                    break;
                } else {
                    String newWord = s1.split("[aeiyouAEIYOU]")[0];
                    s1 += s1.replaceFirst(newWord, "") + newWord + "ay ";
                    break;
                }
            }

        }
        return s + ".";
    }
    public static boolean validColor(String s) {
        if ((s.indexOf("rgb") == -1) || (s.indexOf("(") == -1) || (s.indexOf(")") == -1)) {
            return false;
        } else {
            String[] colors = s.substring(s.indexOf("(")+1, s.indexOf(")")).split(",");
            if (s.indexOf("rgba") != -1) {
                //if (colors.length != 4) {
                //    return false;
                //}
                for (int i = 0; i < colors.length; i++) {
                    if ((Double.parseDouble(colors[i]) > 255) || (Double.parseDouble(colors[i]) < 0)) {
                        return false;
                    }
                }
                return true;
            } else {
                if (colors.length != 3) {
                    return false;
                }
                for (int i = 0; i < colors.length; i++) {
                    if ((Double.parseDouble(colors[i]) > 255) || (Double.parseDouble(colors[i]) < 0)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
    public static String stripUrlParams(String s, String ... paramsToStrip){
        String str = "";
        if (!s.contains("?"))
            return s;
        else {
            str = s.substring(s.indexOf("?") + 1);
            s = s.substring(0, s.indexOf("?") + 1);
        }
        char[] params = str.toCharArray();

        StringBuilder print = new StringBuilder();
        for (char param : params) {
            if (Character.isLetter(param))
                if (!(print.toString().contains(String.valueOf(param)))) {
                    if (paramsToStrip.length > 0) {
                        for (String arg : paramsToStrip) {
                            if (!(arg.contains(String.valueOf(param))))
                                print.append(str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3)).append("&");
                        }
                    }
                    else
                        print.append(str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3)).append("&");
                }
        }
        return s + print.substring(0, print.length()-1);
    }
    public static String [] getHashTags(String s){
        String [] words = s.replaceAll("\\p{Punct}", "").split(" ");
        if(words.length<3){
            for(int i = 0;i< words.length-1;i++){
                if(words[i+1].length()>words[i].length()){
                    String plh = words[i];
                    words[i]="#" + words[i+1].toLowerCase();
                    words[i+1]="#"+plh.toLowerCase();
                }
            }
            return words;
        }else {
            for (int i = 0; i < words.length - 1; i++) {
                for(int j = i;j< words.length;j++){
                    if(words[j].length()>words[i].length()){
                        String plh = words[i];
                        words[i]=words[j].toLowerCase();
                        words[j]=plh.toLowerCase();
                    }
                }
            }
            String [] hashtags = {"#" + words[0], "#" + words[1], "#" + words[2]};
            return hashtags;
        }
    }
    public static int ulam(int a){
        int[] mas = new int[a];
        mas[0]=1;
        mas[1]=2;
        int len=2, next=3;
        while (next<Integer.MAX_VALUE && len<a){
            int count =0;
            for (int i=0;i<len;i++){
                for (int j=len-1; j>i; j--){
                    if (mas[i]+mas[j]==next && mas[i]!=mas[j])
                        count++;
                    else if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                mas[len]=next;
                len++;
            }
            next++;
        }
        return mas[a-1];
    }
    public static String longestNonrepeatingSubstring(String s){
        /*String podstr = "";
        String plh = "";
        for(int i = 0;i<podstr.length();i++){
            if(plh.indexOf(podstr.charAt(i))!=-1){
                plh+=podstr.charAt(i);
            }else{
                if(plh.length()>podstr.length()){
                    podstr=plh;
                }
                plh=""+podstr.charAt(i);
            }
        }
        if(plh.length()>podstr.length()){
            podstr=plh;
        }
        return podstr;

         */
        String dlstr = "";
        char [] strSim = s.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        for (char c : strSim) {
            if (!strBuilder.toString().contains(String.valueOf(c)))
                strBuilder.append(c);
            else {
                if (strBuilder.length() > dlstr.length())
                    dlstr = strBuilder.toString();
                strBuilder = new StringBuilder("" + c);
            }
        }
        s = strBuilder.toString();
        if (s.length()>dlstr.length())
            dlstr=s;
        return dlstr;
    }
    public static String convertToRoman(int a){
        String roman = "";
        if (a < 1 || a > 3999)
            return "Некорректный формат числа";
        while (a >= 1000) {
            roman+="M";
            a -= 1000;        }
        while (a >= 900) {
            roman+="CM";
            a -= 900;
        }
        while (a >= 500) {
            roman+="D";
            a -= 500;
        }
        while (a >= 400) {
            roman+="CD";
            a -= 400;
        }
        while (a >= 100) {
            roman+="C";
            a -= 100;
        }
        while (a >= 90) {
            roman+="XC";
            a -= 90;
        }
        while (a >= 50) {
            roman+="L";
            a -= 50;
        }
        while (a >= 40) {
            roman+="XL";
            a -= 40;
        }
        while (a >= 10) {
            roman+="X";
            a -= 10;
        }
        while (a >= 9) {
            roman+="IX";
            a -= 9;
        }
        while (a >= 5) {
            roman+="V";
            a -= 5;
        }
        while (a >= 4) {
            roman+="IV";
            a -= 4;
        }
        while (a >= 1) {
            roman+="I";
            a -= 1;
        }
        return roman;
    }
    public static boolean formula(String formula){
        String[] mass = formula.split(" ");
        int ans = 0;
        int expectedResult = 0;
        if (!Character.isDigit(mass[0].charAt(0))) return false;
        else ans = Integer.parseInt(mass[0]);
        int i = 1;
        while (!mass[i].equals("=")) {
            if (mass[i].equals("+")){
                ans += Integer.parseInt(mass[i + 1]);
            }
            if (mass[i].equals("-")){
                ans -= Integer.parseInt(mass[i + 1]);
            }
            if (mass[i].equals("*")){
                ans *= Integer.parseInt(mass[i + 1]);
            }
            if (mass[i].equals("/")){
                ans /= Integer.parseInt(mass[i + 1]);
            }
            i += 2;
        }
        i = formula.indexOf('=');
        String check = formula.substring(i + 1, formula.length());
        if (check.contains("=")) return false;
        else expectedResult = Integer.parseInt(mass[mass.length - 1]);
        return ans == expectedResult;
    }
    public static boolean palindromeDescendant(int a){
        boolean check = false;
        StringBuffer nuum =new StringBuffer(a);
        String plh = String.valueOf(a);
        StringBuffer nuuum =new StringBuffer(a);
        String plh1 = "";
        if (plh.length()%2!=0)
            return false;
        else{
            while (!check && plh.length()>1){
                if(!plh.equals(reverse(plh))){
                    plh1 = "";
                    for(int i = 0;i<plh.length();i+=2){
                        int b = Integer.parseInt(String.valueOf(plh.charAt(i)));
                        int c = Integer.parseInt(String.valueOf(plh.charAt(i+1)));
                        plh1+=String.valueOf(b+c);
                    }
                    plh = plh1;
                }else{
                    return true;
                }
            }
        }
        return check;
    }
    public static String reverse(String s){
        String res = "";
        for(int i = s.length()-1;i>=0;i--){
            res+=s.charAt(i);
        }
        return res;
    }
}
