
import static org.junit.Assert.*;
import org.junit.Test;


public class FlikTest {
    @Test
    public void testFlik() {

        Integer p =128;
        System.out.println(p);
        System.out.println(p==128);
        p=127;
        System.out.println(p==127);


        Integer a = 127;
        Integer b = 127;
        System.out.println(a==b);

        int i = 128;
        int j = 128;
        assertTrue(Flik.isSameNumber(i,j));



    }
}
