package biblio.sentence;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by heroindor on 06/07/2017.
 */
public class SentenceProcessor implements ItemProcessor<Sentence, Sentence> {
    private long bookId;

    @BeforeStep
    public void retrieveInterstepData(StepExecution stepExecution) {
        JobExecution jobExecution = stepExecution.getJobExecution();
        ExecutionContext jobContext = jobExecution.getExecutionContext();
        Integer idBook = (Integer) jobContext.get("idBook");
        this.bookId = idBook;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Sentence process(Sentence item) throws Exception {
        item.setIdBook(bookId);
        return item;
    }
}
