public class Unchecked1App{
    public static void main(String args[]){
        System.out.println("### Enter main() ...");
        
        String s1 = null;
        String s2 = null;

        if (args.length > 0) {
            s1 = args[0];
        }

        s2 = s1.toUpperCase();
        
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);   

        System.out.println("### Exit main()!");
  } 
}