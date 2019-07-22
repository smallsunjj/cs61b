import java.lang.Math;

public class Body{
    final static double g = 6.67e-11;
    public double xxPos,yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        return Math.sqrt((xxPos-b.xxPos)*(xxPos-b.xxPos)+(yyPos-b.yyPos)*(yyPos-b.yyPos));
    }

    public double calcForceExertedBy(Body b){
        return g*mass*b.mass/(calcDistance(b)*calcDistance(b));
    }

    public double calcForceExertedByX(Body b){
        return calcForceExertedBy(b)*(b.xxPos-xxPos)/calcDistance(b);
    }

    public double calcForceExertedByY(Body b){
        return calcForceExertedBy(b)*(b.yyPos-yyPos)/calcDistance(b);
    }

    public double calcNetForceExertedByX(Body[] allBodys){
        double netforce = 0;
        for (Body body :allBodys){
            if (body.equals(this)){
                continue;
            }
            netforce += this.calcForceExertedByX(body);
        }
        return netforce;
    }

    public double calcNetForceExertedByY(Body[] allBodys){
        double netforce = 0;
        for (Body body :allBodys){
            if (body.equals(this)){
                continue;
            }
            netforce += this.calcForceExertedByY(body);
        }
        return netforce;
    }

    public void update(double dt,double fx,double fy){
        double ax = fx/mass;
        double ay = fy/mass;
        xxVel = xxVel + dt*ax;
        yyVel = yyVel + dt*ay;
        xxPos = xxPos + dt*xxVel;
        yyPos = yyPos + dt*yyVel;
    }

    public void draw(){

        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);

    }



}