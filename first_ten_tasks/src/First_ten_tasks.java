import java.util.Scanner;

public class First_ten_tasks {
    public static void main(String[] args){//выбор задачи и ввод данных
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задачи, которую хотите протестировать");
        int test_num=sc.nextInt();
        switch (test_num){
            case 1:
                System.out.println("Введите числа");
                int n1=sc.nextInt();
                int m1=sc.nextInt();
                System.out.println(remainder(n1, m1));
                break;
            case 2:
                System.out.println("Введите числа");
                int osn1=sc.nextInt();
                int height1=sc.nextInt();
                System.out.println(triArea(osn1, height1));
                break;
            case 3:
                System.out.println("Введите числа");
                int chick1=sc.nextInt();
                int cow1=sc.nextInt();
                int pig1=sc.nextInt();
                System.out.println(animals(chick1, cow1, pig1));
                break;
            case 4:
                System.out.println("Введите числа");
                double prob1=sc.nextDouble();
                int prize1=sc.nextInt();
                int pay1=sc.nextInt();
                System.out.println(profitableGamble(prob1, prize1, pay1));
                break;
            case 5:
                System.out.println("Введите числа");
                int N1=sc.nextInt();
                int a1=sc.nextInt();
                int b1=sc.nextInt();
                System.out.println(operation(N1, a1, b1));
                break;
            case 6:
                System.out.println("Введите символ");
                char a2=sc.next().charAt(0);
                System.out.println(ctoa(a2));
                break;
            case 7:
                System.out.println("Введите число");
                int n2=sc.nextInt();
                System.out.println(addUpTo(n2));
                break;
            case 8:
                System.out.println("Введите числа");
                int s1_1=sc.nextInt();
                int s2_1=sc.nextInt();
                System.out.println(nextEdge(s1_1, s2_1));
                break;
            case 9:
                System.out.println("Введите количество элементов массива");
                //ввод массива чисел с клавиатуры
                int size = sc.nextInt();
                int [] mas = new int[size];
                System.out.println("Введите числа");
                for(int i=0;i<size;i++){
                    mas[i]=sc.nextInt();
                }
                System.out.println(sumOfCubes(mas));
                break;
            case 10:
                System.out.println("Введите числа");
                int a3=sc.nextInt();
                int b3=sc.nextInt();
                int c3=sc.nextInt();
                System.out.println(abcmath(a3, b3, c3));
        }
    }
    public static int remainder(int n, int m){//остаток от деления
        return n%m;
    }
    public static double triArea(int osn, int height){//площадь треугольника по основанию и высоте
        return 0.5*osn*height;
    }
    public static int animals(int chick, int cow, int pig){//суммарное кол-во ног животных фермера
        return chick*2+cow*4+pig*4;
    }
    public static boolean profitableGamble(double prob, int prize, int pay){//функция, принимающая3 аргумента (prob, prize, pay) и возвращает true, если prob * prize > pay
        return(prob*prize>pay);
    }
    public static String operation(int N,  int a, int b){//что нужно сделать с a и b, чтобы получить c
        if(a+b==N){
            return "added";
        }
        else{
            if(a-b==N){
                return "subtracted";
            }
            else{
                if(a*b==N){
                    return "multiplied";
                }
                else{
                    if((a/b==N)&&(a%b==0)){
                        return "divided";
                    }
                    else{
                        return "none";
                    }
                }
            }
        }
    }
    public static int ctoa(char a){//значение ASCII переданного символа
        return (int) a;
    }
    public static int addUpTo(int n){//сумма всех чисел до введённого включительно
        int sum =0;
        for (int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    public static int nextEdge(int s1, int s2){//максимальное значение 3-го ребра треугольника
        return s1+s2-1;
    }
    public static int sumOfCubes(int[] num){//сумма кубов элементов массива
        int sum=0;
        for(int i=0;i<num.length;i++){
            sum+=num[i]*num[i]*num[i];
        }
        return sum;
    }
    public static boolean abcmath(int a, int b, int c){//добавить a к себе b раз и проверить делимость результата на c
        int sumA=a;
        for(int i=0;i<b;i++){
            sumA+=a;
        }
        return (sumA%c==0);
    }
}
