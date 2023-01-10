public class AccessingElements {
public static void main(String[] args) {
        declearingArrays();
        int[] arr = {1,2,3,4,5,6};
        accessingArrays(arr);
    }

    private static void accessingArrays(int[] arr) {
        System.out.println(arr[0]); //print 1
        System.out.println(arr[3]); //print 4
        System.out.println(arr[arr.length-1]); //print 6
        System.out.println(arr[arr.length/2]); //print the middle value or 4 in this case

        arr[0] = 100; // assinging the first element to 100
        System.out.println(arr[0]);
    }

    private static void declearingArrays() {
        //declearing int array arr and initialize it with a series of ints
        int[] arr = {1,2,3,4,5,6,7,8,9};


        //declearing a double array called nums and initialize it to a size/length of 10
        double[] nums = new double[10];

        //having num to refer to a new size/length/diffrent double array
        nums = new double[6];


    }
}