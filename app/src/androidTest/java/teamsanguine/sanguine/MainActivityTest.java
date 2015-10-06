package teamsanguine.sanguine;

import android.support.design.widget.FloatingActionButton;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Toolbar;

/**
 * Created by Timmy on 10/6/2015.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    MainActivity activity;
    public  MainActivityTest()
    {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity=getActivity();
    }

    public void testMainActivityLoaded(){
        //Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        FloatingActionButton fab = (FloatingActionButton) activity.findViewById(R.id.fab);
        //assertNotNull(toolbar);
        assertNotNull(fab); //TODO: Change to other control once the Main Activity updates
    }
}
