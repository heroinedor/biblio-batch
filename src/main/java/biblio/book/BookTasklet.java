package biblio.book;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by heroinedor on 05/07/2017.
 */
public class BookTasklet implements Tasklet {

    private Resource resource;
    private BookDao bookDao;


    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        Book book = new Book();
        //book title
        String fileName = resource.getFilename();
        String title = resource.getFilename().substring(0, fileName.indexOf('.'));
        book.setTitle(title);

        //book content
        File contentFile = resource.getFile();
        String content = readFile(contentFile);
        book.setContent(content);

        //save in database
        long idBook = bookDao.add(book);

        //Add the "idBook" parameter in StepExecutionContext
        chunkContext
                .getStepContext()
                .getStepExecution()
                .getExecutionContext()
                .put("idBook", idBook);

        return RepeatStatus.FINISHED;
    }

    /**
     * Reads the file which name is passed in parameters and return the content in a String
     *
     * @param file String filename
     * @return String with file content
     * @throws IOException
     */
    private String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
