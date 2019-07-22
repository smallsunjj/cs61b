public class Test{
    public static void main(String[] args) {
        In in = new In("./data/planets.txt");

        /* Every time you call a read method from the In class,
         * it reads the next thing from the file, assuming it is
         * of the specified type. */

        /* Compare the calls below to the contents of BasicInDemo_input_file.txt */

        int N = in.readInt();
        double radius = in.readDouble();
        if(!in.isEmpty()) {
            double d1 = in.readDouble();
            double d2 = in.readDouble();
            System.out.println(d1);
            System.out.println(d2);

        }
        //System.out.println(d1);
    }
}