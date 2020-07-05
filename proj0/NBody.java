public class NBody {
    /**
     * Read radius from files
     */
    public static double readRadius(String fileName){
        In in=new In(fileName);
        int first=in.readInt();
        double radius=in.readDouble();
        return radius;
    }

    /**
     * Read planets from files
     */
    public static Planet[] readPlanets(String fileName){
        In in=new In(fileName);
        int N=in.readInt();
        Planet[] p=new Planet[N];
        double radius=in.readDouble();
        for(int i=0;i<N;i++){
            double xPos=in.readDouble();
            double yPos=in.readDouble();
            double xVel=in.readDouble();
            double yVel=in.readDouble();
            double m=in.readDouble();
            String img=in.readString();
            p[i]=new Planet(xPos,yPos,xVel,yVel,m,img);
        }
        return p;
    }

    /**
     * Draw th universe
     */
    public static void main(String[] args) {
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        Planet[] planets=readPlanets(filename);
        double radius=readRadius(filename);

        /**
         * Drawing the background
         */
        StdDraw.setScale(radius,-radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        /**
         * Drawing the planets
         */
        for(Planet p:planets){
            p.draw();
        }

        /**
         * Enable buffer
         */
        StdDraw.enableDoubleBuffering();
        double time=0;
        while(time<T){
            double[] xForces=new double[planets.length];
            double[] yForces=new double[planets.length];
            //store force information in array
            for(int i=0;i<planets.length;i++){
                double netX=planets[i].calcNetForceExertedByX(planets);
                double netY=planets[i].calcNetForceExertedByY(planets);
                xForces[i]=netX;
                yForces[i]=netY;
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            //draw updated planets
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(Planet p:planets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }
        /**
         * Print the final state of the universe
         */
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

}
