import org.junit.Test;

import static java.lang.Math.PI;

/**
 * Created by aleksandr.neguritsa on 8/1/2017.
 */

public class MathTest {

    @Test
    public void testArea() throws Exception {
        Calculation c = new Calculation(50);
        double ahoy = c.getArea();
        System.out.print("Circle area = " +ahoy);
    }

    public class Calculation {

        double area;
        double radius;


        Calculation(double radius) {
            this.area = Math.pow(radius, 2) * PI;
            this.radius = radius;

        }

        double getArea(){
            return area;
        }

        }
    }

