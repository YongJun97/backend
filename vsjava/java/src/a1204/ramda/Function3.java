package a1204.ramda;
interface Calculator {
    int sum(int a, int b);
    
}





public class Function3 {
    public static void main(String[] args) {
        Calculator mc = Integer::sum; // 각 요소를 합산해라 a + b
        
        int result =  mc.sum(3,4);
        System.out.println((result));
    }
}
