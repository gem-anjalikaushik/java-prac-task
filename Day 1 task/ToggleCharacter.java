import java.util.Scanner;
public class ToggleCharacter{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
      String s=sc.next();
    StringBuilder sb=new StringBuilder();
      int l=s.length();
      for(int i=0;i<l;i++){
        char ch=s.charAt(i);
        if(Character.isUpperCase(ch)){
        ch=Character.toLowerCase(ch);
        sb.append(ch);
        }
        else{
           ch=Character.toUpperCase(ch);
           sb.append(ch);
        }   
      }
      System.out.println("Toggled String is: "+sb);
    }
}