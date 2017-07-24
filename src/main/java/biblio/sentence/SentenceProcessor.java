package biblio.sentence;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;

/**
 * Created by heroindor on 06/07/2017.
 */
public class SentenceProcessor {
    private long bookId;

    @BeforeStep
    public void retrieveInterstepData(StepExecution stepExecution) {
        //TODO set the bookId  with the "idBook" parameter extracted from the jobExecutioncontext
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    //TODO Implement the ItemProcessor interface  and the process method to set the bookId to the Sentence item
}
