package biblio.sentence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static junit.framework.TestCase.*;
import static org.springframework.batch.test.MetaDataInstanceFactory.createStepExecution;

/**
 * Created by heroinedor on 19/07/2017.
 */
@ContextConfiguration(locations = {"classpath:context-test.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        StepScopeTestExecutionListener.class})
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
        StepExecution execution = createStepExecution();
        execution.getJobExecution().getExecutionContext().putInt("idBook", idBook);
        return execution;
    }

    @Test
    public void testProcessor() {
        Sentence output;
        try {
            itemProcessor.beforeStep(getStepExecution());
            output = itemProcessor.process(item);
            assertNotNull(output);
            assertEquals(idBook, output.getIdBook());
        } catch (Exception e) {
            fail();
        }
    }
}