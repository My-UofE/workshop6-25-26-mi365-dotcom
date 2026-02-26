public class Unchecked2App{
    public static void main(String args[]){
        System.out.println("### Enter main() ...");
        
        String s1 = null;

        if (args.length > 0) {
            s1 = args[0];
        }
        
        try{
            methodA(s1);
        } catch (NullPointerException e){
            System.out.println("### Exception caught: " + e.getClass().getName()); 
            System.out.println("### Exception message: " + e.getMessage()); 
        }
        System.out.println("### Exit main()!");
    }

    static void methodA(String s1){
        System.out.println("### Enter methodA() ...");
        try{
            methodB(s1);
        } catch (NullPointerException e){
            System.out.println("### Exception caught: " + e.getClass().getName()); 
            System.out.println("### Exception message: " + e.getMessage()); 
        }
        System.out.println("### Exit methodA()!");
    }

    static void methodB(String s1) {
        System.out.println("### Enter methodB() ...");

        String s2 = null;

        try{
            s2 = s1.toUpperCase();
        } catch (NullPointerException e){
            System.out.println("### Exception caught: " + e.getClass().getName()); 
            System.out.println("### Exception message: " + e.getMessage()); 
        }
        System.out.println("s1: " + s1);   
        System.out.println("s2: " + s2);   
        System.out.println("### Exit methodB()!");
    }
}