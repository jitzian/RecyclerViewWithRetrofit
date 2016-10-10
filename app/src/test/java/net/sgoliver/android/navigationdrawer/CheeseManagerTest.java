package net.sgoliver.android.navigationdrawer;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.sgoliver.android.navigationdrawer.managers.CheeseManager;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Libin
 */
public class CheeseManagerTest {

    private CheeseManager mCheeseManager;
    private Context mContext;

    @Before
    public void setUp() throws Exception {
        mCheeseManager = null;
        mContext = null;
    }

    @Test
    public void getSortedCheeseListFromAssets() throws Exception {
        //TODO: Create Unit test for the CheeseManager.getSortedCheeseListFromAssets() method.
    }

    @Test
    public void filterByName() throws Exception {
        //FIXME: Finish the Unit test for the CheeseManager.filterByName() method.
        ArrayList<String> expectedFilteredCheeseList = new ArrayList<>();
        expectedFilteredCheeseList.add("Provolone");
        expectedFilteredCheeseList.add("Provolone (Australian)");

        ArrayList<String> filteredCheeseList = mCheeseManager.filterByName(mContext, "Provolone");

        assertNotNull("The filtered list is not null", filteredCheeseList);
        assertEquals("The filtered list should only contain 2 cheeses", 2 , filteredCheeseList.size());
        assertTrue("The filtered list contains the provolone cheeses", filteredCheeseList.containsAll(expectedFilteredCheeseList));
    }

    /**
     * Retrieves a test list of cheeses.
     * @param testInstance the test instance.
     * @return the list of cheeses.
     */
    public static ArrayList<String> getCheeseList(Object testInstance) {
        String fromFile = getStringFromFile(testInstance, "cheese_list.json");
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(fromFile , listType);
    }

    /**
     * Retrieves a requested resource file as a string for a test.
     * @param test The test class instance.
     * @param fileName The requested file name.
     * @return a String content from the requested file.
     */
    public static String getStringFromFile(Object test, String fileName) {
        StringBuilder output = new StringBuilder();
        try {
            InputStream inputStream = test.getClass().getClassLoader().getResourceAsStream(fileName);
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = r.readLine()) != null) {
                output.append(line).append('\n');
            }
        } catch (IOException e) {
            //NOP
        }
        return output.toString();
    }

}
