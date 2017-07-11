package hello;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * Tasklet to print "Hello World!" in the console
 */
public class PrintTasklet implements Tasklet {

    private String message = "\n--------------------------\n" +
            "\n       Hello World !       \n" +
            "\n--------------------------\n";

    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext attributes) throws Exception {
        System.out.print(message);

        return RepeatStatus.FINISHED;
    }
}
