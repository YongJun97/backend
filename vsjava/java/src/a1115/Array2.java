package a1115;

public class Array2 {
        public static void main(String[] args) {
            int[] arr = new int[5];

            for (int i =0; i < arr.length; i++){
                arr[i] = i+1;
            }
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[j] + " ");
            }



        }
}
// for 문을 이용해서 arr[0]=1 arr[0]=2 arr[0]=3 arr[0]=4 arr[0]=5