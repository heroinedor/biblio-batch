package biblio.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by edorso on 19/07/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context-test.xml"})
public class BookTaskletITCase {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testBookTaskletTest() throws Exception {
        //TODO write a test that launches only the "createBook" TaskletStep
    }
}
