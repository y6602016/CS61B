public class TestPlanet {
    public static void main(String[] args) {
        checkPlanet();
    }
    /**
     * Method for checking the Planet class works well
     */
    private static void checkPlanet(){
        System.out.println("Checking calcDistance..");

        Planet p1=new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2=new Planet(2.0, 1.0, 3.0, 4.0, 5.0, "mars.gif");
        checkEquals(p1.calcDistance(p2),1.0, "calcDistance()", 0.01);
    }

    /**
     * checks whether or not two doubles are equal and print the results
     * @param expected Expected double
     * @param actual Double received
     * @param label label for the test case
     * @param eps Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps){
        System.out.println("Pairwise Force expected:"+expected+" and you gave:"+actual);
    }
}
