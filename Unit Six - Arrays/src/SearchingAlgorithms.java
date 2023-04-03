import java.util.Arrays;

public class SearchingAlgorithms{    
    public static void main(String[] args) {
        int[] arr = {3,3,4,7,5,6,2,8,9,1,2};

        
        int findme = 7;
        int index = sequentialSearch(arr, findme);
        System.out.println("number is at index " + index);
        
        /*Arrays.sort(arr);
        display(arr);
        System.out.println();*/
        
        findme = 6;
        index = binarySearch(arr, findme);
        System.out.println("number is at index " + index);

        /*for (int i = 0; i < 8; i++) {
            int[] arr = new int[(int)(Math.pow(10,i))];
            int findme = -1;
            binarySearch(arr, findme);
        }*/

    }

    private static int binarySearch(int[] arr, int findme) {
        int min = 0; int max = arr.length-1;
        int mid;
       
        while(min<=max){

            mid = (min + max)/2;
            if(arr[mid] == findme)
                return mid;
            else if(arr[mid]<findme)
                min = mid+1;
            else
                max = mid-1;
        }
        
        return -1;
    }

    private static int sequentialSearch(int[] arr, int findme) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == findme)
                return i;
        }

        return -1;
    }
      
    private static void display(int[] arr) {
        for (int el : arr) {
            System.out.print(el + " ");
        }
    }
}