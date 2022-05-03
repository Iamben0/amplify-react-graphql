// in java, array is considered as an instance
public class AboutArray {
    public static void main(String [] args) {
        int[] a = null;
        int[] b = new int[5];
        int[] c = b;
        System.out.println(b.length);
        for (int i = 0; i < b.length; i++) {
            b[i] = i * 10;
        }

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        // Accessing the same instance 
        // via different references
        for (int num : c) {
            System.out.println(num);
        }

        change(b);

        
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    public static void change(int[] data) {
        for (int i = 0; i < data.length; i++)
            data[i] = data[i] + 100;
    }

}