package ut.com.fpt.confluence.plans.approval;

import org.junit.Test;
import com.fpt.confluence.plans.approval.api.MyPluginComponent;
import com.fpt.confluence.plans.approval.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest {
    @Test
    public void testMyName() {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent", component.getName());
    }
}