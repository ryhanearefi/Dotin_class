//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        char male='F';
        byte maleByte= 123;
        byte maleByte2= 123;

        String file ="Hello world!!!";
        String file1 ="Hello world!!!Hello world!!!";
        String file2 ="Hello world!!! hi";


        String str1="Reyhane";
        String str2="Arefi";
        String str =String.format("Hello to %s,my name is %s,",str1,str2);

        String name7="Reyhane";
        String age="34";
        String name8=String.format("My Name is %s, My Age is %s", name7,age);
        System.out.println(name8);
        System.out.println(name8.toUpperCase());
        //System.out.println(name8.replace("AmirHossetin","Fanap"));
        String s=name8.replace("Reyhane","Fanap");

        System.out.println(s.substring(0,s.indexOf("Fanap")+5));

        StringBuffer sb =new StringBuffer();

        sb.append("hello");
        System.out.println(sb);

       // System.out.println(s);





    }
}