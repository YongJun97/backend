package a1121.computer;

public class Computer {

    public int sum(int... values) {
        int sum = 0;
        for(int value : values){
            sum += value;
        }

        return sum;
    }
    
}
