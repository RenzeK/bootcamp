package execize9;

public class AutoAdvanced {

    public String brand;
    public int force;
    public int rpmsEngine;
    public int torq;

    public AutoAdvanced(String brand, int force, int rpmsEngine){
        this.brand = brand;
        this.force = force;
        this.rpmsEngine = rpmsEngine;
        torq = ((force * 5252)/rpmsEngine);
        System.out.println("brand of the car " + brand);
        System.out.println("The torque of the car is about " + torq);
    }
}
