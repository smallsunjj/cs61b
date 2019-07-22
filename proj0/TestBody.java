public class TestBody{
    public TestBody(){}

    public static void main(String[] args){
        Body a = new Body(1.0e12,2.0e11,0,0,2.0e30,"sun.gif");
        Body b = new Body(2.3e12,9.5e11,0,0,6.0e26,"saturn.gif");
        double force = a.calcForceExertedBy(b);

        System.out.println("The force is " +force);

    }
}