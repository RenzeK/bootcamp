import org.testng.annotations.Test;

public class AboutMethods {

    public int multiply (int first, int second)
    {
        return( first * second);
    }
    @Test
    public void printProduct() {

        System.out.println("result " +  multiply(20, 30));
    }
}
