package edu.wctc.springdataassignmentupdated.repo;

import edu.wctc.springdataassignmentupdated.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
