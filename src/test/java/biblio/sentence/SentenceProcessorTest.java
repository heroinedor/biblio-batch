package biblio.sentence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.StepExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by heroinedor on 19/07/2017.
 */
//TODO add the annotation that let use 2 TestExecutionListener :
// - one to inject dependencies defined in ContextConfiguration
// - one to create the StepExecution needed by the step-scoped components
@ContextConfiguration(locations = {"classpath:context-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SentenceProcessorTest {

    private Sentence item;
    private int idBook = 1;

    @Autowired
    private SentenceProcessor itemProcessor;

    @Before
    public void setUp() {
        item = new Sentence();
        item.setIdSentence(211);
        item.setSentence("Tester c'est douter.");
        itemProcessor = new SentenceProcessor();
    }

    public StepExecution getStepExecution() {
        //TODO return a StepExecution created with createStepExecution() and containing a JobExecutionContext
        //with a parameter "idBook" set with  idBook
        return null;
    }

    @Test
    public void testProcessor() {
        //TODO test the itemProcessor.process() method
        //don't forget to use the getStepExecution() to pass the StepExecution to the itemProcessor.beforeStep()
    }
}
