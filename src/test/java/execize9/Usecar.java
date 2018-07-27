package execize9;

import org.testng.annotations.Test;

public class Usecar {

    @Test
    public void stelSamen() {
        Auto mijn = new Auto();
        mijn.setColor("groen");
        mijn.setBrand("jaguar");
        mijn.engineType("4.6D");
        mijn.setDoors(5);
        mijn.torqueCar(4, 5555);
    }

    @Test
    public void beter() {
        AutoAdvanced mijnEigen = new AutoAdvanced("Daf", 3, 3000);
        int tt = mijnEigen.torq;
        //mijnEigen.torq;
        System.out.println("force:" + tt);
    }

}
