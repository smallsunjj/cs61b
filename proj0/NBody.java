public class NBody{
    public static double readRadius(String s){
        In in = new In(s);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String s){
        Body[] allbodies=new Body[0];
        In in = new In(s);
        int N = in.readInt();
        double radius = in.readDouble();
        while(!in.isEmpty()) {
            double d1 = in.readDouble();
            double d2 = in.readDouble();
            double d3 = in.readDouble();
            double d4 = in.readDouble();
            double d5 = in.readDouble();
            String name = in.readString();
            Body b = new Body(d1, d2, d3, d4, d5, name);
            int l = allbodies.length;
            Body[] oldbodies = allbodies;
            allbodies = new Body[l + 1];
            allbodies[l ] = b;
            System.arraycopy(oldbodies, 0, allbodies, 0, l);

        }
        return allbodies;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = readBodies(filename);
        double radius = readRadius(filename);

        String background = "images/starfield.jpg";
        StdDraw.enableDoubleBuffering();

        /** Sets up the universe so it goes from
         * -100, -100 up to 100, 100 */
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);

        /* Clears the drawing window. */
        StdDraw.clear();

        /* Stamps three copies of advice.png in a triangular pattern. */
        //StdDraw.picture(radius/2,radius/2,background);

        for(double time=0;time<T;time+=dt){
            double[] xForces = new double[5];
            double[] yForces = new double[5];
            for(int i =0;i<5;i++){
                xForces[i]=bodies[i].calcNetForceExertedByX(bodies);
                yForces[i]=bodies[i].calcNetForceExertedByY(bodies);
                //bodies[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,background);
            for(int i=0;i<5;i++){
                bodies[i].update(dt,xForces[i],yForces[i]);
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        //StdDraw.show();
        //StdDraw.pause(10);

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}