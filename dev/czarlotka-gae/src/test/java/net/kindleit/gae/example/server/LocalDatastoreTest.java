package net.kindleit.gae.example.server;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Performs datastore setup, as described <a
 * href="http://code.google.com/appengine/docs/java/howto/unittesting.html">here</a>.
 *
 * @author androns
 */
public abstract class LocalDatastoreTest {

    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());


    public void setUp() {
        helper.setUp();

    }

    public void tearDown() {
        helper.tearDown();
    }
}
