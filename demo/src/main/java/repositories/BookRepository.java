package repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
