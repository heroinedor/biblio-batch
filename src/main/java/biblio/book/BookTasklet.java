package biblio.book;

import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by heroinedor on 05/07/2017.
 */
public class BookTasklet {

    private Resource resource;
    private BookDao bookDao;

    //TODO implement the Tasklet interface and the "execute" method to open the book file using the readFile method
    // and save the title and the content in DB

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
