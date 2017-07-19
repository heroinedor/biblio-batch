package biblio.sentence;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by heroindor on 06/07/2017.
 */
public class SentenceProcessor implements ItemProcessor<Sentence, Sentence>, StepExecutionListener {
    private long bookId;

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Sentence process(Sentence item) throws Exception {
        item.setIdBook(bookId);
        return item;
    }

    public void beforeStep(StepExecution stepExecution) {
        JobExecution jobExecution = stepExecution.getJobExecution();
        ExecutionContext jobContext = jobExecution.getExecutionContext();
        Long idBook = (Long) jobContext.get("idBook");
        this.bookId = idBook;
    }

    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
