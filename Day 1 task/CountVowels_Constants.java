import java.util.Scanner;
public class CountVowels_Constants{
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      String s=sc.next();
      int l=s.length();
      int vowel_count=0;
      s=s.toLowerCase();
      for(int i=0;i<l;i++){
        char ch=s.charAt(i);
        if(ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u')
        vowel_count++;
      }  
      System.out.println("Vowel Count="+vowel_count);
      System.out.println("Constants Count="+ (l-vowel_count));
    }
}