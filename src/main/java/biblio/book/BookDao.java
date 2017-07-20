package biblio.book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heroinedor on 05/07/2017.
 */
public class BookDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertActor;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertActor = new SimpleJdbcInsert(dataSource).withTableName("book").usingGeneratedKeyColumns("idbook");
    }

    /**
     * Insert a @{@link Book} in the database and return its generated id
     *
     * @param book
     * @return the generated id
     */
    public long add(Book book) {
        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("id", book.getIdBook());
        parameters.put("title", book.getTitle());
        parameters.put("content", book.getContent());
        Number key = insertActor.executeAndReturnKey(parameters);
        return key.longValue();
    }
}
