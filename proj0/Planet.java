public class Planet {
    /**
     * Instance variables for a planet
     */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Object copy;
    public static final double G = 6.67e-11;

    /**
     * Constructor of a planet
     */
    public Planet(double xPos, double yPos, double xVel,
              double yVel, double m, String img) {
        this.xxPos = xPos;
        this.yyPos = yPos;
        this.xxVel = xVel;
        this.yyVel = yVel;
        this.mass = m;
        this.imgFileName = img;
    }

    /**
     * Constructor of a planet copy
     */
    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**
     * Method for calculating the distance between the
        instance planet and the input planet
     */
    public double calcDistance(Planet p){
        double dx=p.xxPos-this.xxPos;
        double dy=p.yyPos-this.yyPos;
        double distance=Math.sqrt(dx * dx + dy*dy);
        return distance;
    }

    /**
     * Method for calculating the force exerted by the input planet
     */
    public double calcForceExertedBy(Planet p){
        double distance= calcDistance(p)*calcDistance(p);
        double force=(G*this.mass*p.mass)/distance;
        return force;
    }
    /**
     * Method for calculating the force exerted on the
     instance planet by the input planet with direction on X axis
     */
    public double calcForceExertedByX(Planet p){
        double Fx=(calcForceExertedBy(p)*(p.xxPos-this.xxPos))/calcDistance(p);
        return Fx;
    }

    /**
     * Method for calculating the force exerted on the
     instance planet by the input planet with direction on Y axis
     */
    public double calcForceExertedByY(Planet p){
        double Fx=(calcForceExertedBy(p)*(p.yyPos-this.yyPos))/calcDistance(p);
        return Fx;
    }

    /**
     * Method for calculating the net force exerted on the
     instance planet by the input planet array with direction on X axis
     */
    public double calcNetForceExertedByX(Planet[] p){
        double netForce=0;
        for(Planet planet:p){
            if(this.equals(planet)){
                continue;
            }
            else{
                netForce+=this.calcForceExertedByX(planet);
            }
        }
        return netForce;
    }

    /**
     * Method for calculating the net force exerted on the
     instance planet by the input planet array with direction on Y axis
     */
    public double calcNetForceExertedByY(Planet[] p){
        double netForce=0;
        for(Planet planet:p){
            if(this.equals(planet)){
                continue;
            }
            else{
                netForce+=this.calcForceExertedByY(planet);
            }
        }
        return netForce;
    }

    /**
     * Update velocity and position based on velocity
     */
    public void update(double dt, double fx, double fy){
        double ax=fx/this.mass;
        double ay=fy/this.mass;
        this.xxVel=this.xxVel+(dt*ax);
        this.yyVel=this.yyVel+(dt*ay);
        this.xxPos=xxPos+(dt*this.xxVel);
        this.yyPos=yyPos+(dt*this.yyVel);
    }
    /**
     * Draw the planets
     */
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }

}
