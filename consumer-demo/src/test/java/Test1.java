import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        String str = "jstubavajfiewjavajfiowfjavagkljjava";
        System.out.println("请输入一个要查找的字符:");
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        System.out.println(str1 + "在字符串中出现了"+getCount(str,str1)+"次");
    }

    //经典的用String的indexOf和substring组合方法来求字符串中某个字符出现的次数
    public static int getCount(String str,String scan){
        int count = 0;
        int index = 0;
        while(((index = str.indexOf(scan)) != -1)){
            //想个办法截取字符串中查找字符,并将查找当前匹配字符之后的字符串重新
            //赋值给字符串
            str = str.substring(index+1);
            count++;
        }
        return count;
    }
}
