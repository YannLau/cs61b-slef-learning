import static java.lang.Math.sqrt;

public class Planet {
    //private final Planet p;
    public static double G = 6.67E-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = "./images/"+imgFileName;
    }
    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        return sqrt(dx*dx+dy*dy);
    }
    public double calcForceExertedBy(Planet p){
        double i = this.calcDistance(p);
        return G*this.mass*p.mass/(i*i);
    }
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos-this.xxPos;
        return this.calcForceExertedBy(p)*dx/this.calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos-this.yyPos;
        return this.calcForceExertedBy(p)*dy/this.calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] p){
        double x_net = 0;

        for (Planet planet : p) {
            if(this.equals(planet)){
                continue;
            }
            x_net+=this.calcForceExertedByX(planet);
        }
        return x_net;
    }
    public double calcNetForceExertedByY(Planet[] p){
        double y_net = 0;

        for (Planet planet : p) {
            if(this.equals(planet)){
                continue;
            }
            y_net+=this.calcForceExertedByY(planet);
        }
        return y_net;
    }
    public void update(double time,double f_x,double f_y){
        double a_x = f_x/this.mass;
        double a_y = f_y/this.mass;
        this.xxVel += a_x*time;
        this.yyVel += a_y*time;
        this.xxPos += this.xxVel*time;
        this.yyPos += this.yyVel*time;
    }
    public void draw(){
        StdDraw.picture(xxPos,yyPos,imgFileName);
    }
}
