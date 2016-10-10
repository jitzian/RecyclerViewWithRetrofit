package net.sgoliver.android.navigationdrawer;

import android.content.Context;

import net.sgoliver.android.navigationdrawer.util.SimpleClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by User on 10/9/2016.
 */

/**
 * Created by evin on 4/29/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class SimpleMockitoUnitTest {

    private static final String FAKE_STRING = "Hello World";

    private SimpleClass mSimpleClass;

    @Mock
    Context mMockContext;

    @Before
    public void init_classes() {
        when(mMockContext.getString(R.string.hello_word)).thenReturn(FAKE_STRING + " a ");
        System.out.println(mMockContext);

        mSimpleClass = new SimpleClass(mMockContext);
    }


    @Test
    public void simpleClass_returnsString() {
        String result = mSimpleClass.getHelloWorldString();

        assertThat(result, is(FAKE_STRING));
    }

    @After
    public void clear_classes(){
        System.out.println("After test");
    }

    /**
     * Created by User on 10/9/2016.
     */

    public static class CheeseManagerTest {
    //    List mockedList = mock(List.class);
        public static final String TAG = CheeseManagerTest.class.getName();

        @Test
        public void testSomething(){
    //        Log.d(TAG, "Start");
            assertEquals(4, 2 + 2);
        }

    }
}
