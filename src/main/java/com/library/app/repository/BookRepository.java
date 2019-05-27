package com.library.app.repository;
	
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.library.app.dataobjects.Books;



@RepositoryRestResource
@CrossOrigin
public interface BookRepository extends CrudRepository<Books, Long> {


	@Query("FROM Books where status = 'A' ")
	public List<Books> getAllBooks();
	
	@Query("FROM Books where status = 'A' and id=:id")
	public Books findById(@Param("id") Long id);

	

}
