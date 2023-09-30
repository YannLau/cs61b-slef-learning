public class NBody {
//    public static double readRadius(String FileName){
//        In scan =new In(FileName);
//        scan.readDouble();
//        return scan.readDouble();
//    }
    public static double readRadius(String FileName){
        In scan =new In(FileName);
        String[] content = scan.readAllLines();
        return Double.parseDouble(content[1]);
    }
    public static Planet[] readPlanets(String FileName){
        In scan =new In(FileName);
        int num = scan.readInt();
        scan.readDouble();
        Planet[] aim = new Planet[num];
        for (int i = 0; i < num; i++) {

            double xxPos= scan.readDouble();
            double yyPos= scan.readDouble();
            double xxVel= scan.readDouble();
            double yyVel= scan.readDouble();
            double mass=scan.readDouble();
            String imgFileName=scan.readString();
            aim[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
        }
        return aim;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];

        Planet[] planets = readPlanets(fileName);
        Double radius = readRadius(fileName);

        double scale = NBody.readRadius(fileName);
        final String image = "/images/starfield.jpg";
        StdDraw.setScale(-scale,scale);
        StdDraw.clear();
        StdDraw.picture(0,0,image);
        for (Planet planet : planets) {
           planet.draw();
        }

        double time = 0;

        StdDraw.enableDoubleBuffering();

        while(time<T){
            int len = planets.length;
            double[] xForces = new double[len];
            double[] yForces = new double[len];
            for (int i = 0; i < len; i++) {
               xForces[i]=planets[i].calcNetForceExertedByX(planets);
               yForces[i]=planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < len; i++) {
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,image);
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
