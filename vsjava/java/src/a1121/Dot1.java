package a1121;

public class Dot1 {
    public static void printNumbers(int... aa) {
        for(int number : aa){
            System.out.println(number);
        }
    }



    public static void main(String[] args) {
        printNumbers(1,2,3);
        printNumbers(10,20);
    }
                
                   
        
                    
}
