package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByDeletedFalse();

	List<Book> findByDeletedTrue();

	@Modifying
	@Query(value = "DELETE FROM book53 WHERE id = ?1", nativeQuery = true)
	void permanentDelete(Long id);

}