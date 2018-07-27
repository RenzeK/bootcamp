package execize9;


public class Auto {

    public void setColor(String carColor) {
        System.out.println("The colour of the car is " + carColor);
    }

    public void setBrand(String brand) {
        System.out.println("The brand of the car is " + brand);

    }
public void setDoors (int nrDoors){
    System.out.println("The nr of doors for the car is " + nrDoors);

}
public void engineType (String engineType){
    System.out.println("The engine of the car is " + engineType);

}
public void torqueCar (int force, int rpmsEngine){
    System.out.println("The torque of the car is about " + ((force * 5252)/rpmsEngine));

}

}
