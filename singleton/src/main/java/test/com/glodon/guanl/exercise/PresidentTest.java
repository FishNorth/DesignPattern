package test.com.glodon.guanl.exercise;

import com.glodon.guanl.exercise.President;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * President Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>三月 13, 2019</pre>
 */
public class PresidentTest {

    /**
     * Method: getInstance()
     */
    @Test
    public void testGetOneInstance() {
        President zt1 = President.getInstance();
        String msg = zt1.getName();
        //断言得到的msg为帝释天，否则测试失败
        assertEquals("帝释天1", msg);
    }

    /**
     * Method: getInstance()
     */
    @Test
    public void testEqualTwoInstance() {
        President zt1 = President.getInstance();
        President zt2 = President.getInstance();
        //断言得到的msg为帝释天，否则测试失败
        assertTrue(zt1 == zt2);
    }

} 
