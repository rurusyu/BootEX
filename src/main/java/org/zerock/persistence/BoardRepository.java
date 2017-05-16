package org.zerock.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
//id타입은 반드시 serialrisable 걸려야함
	public Board findByBno(Long bno); //이값이 틀리면 못받음
	
	public Board getByTitle(String title);
	
	public Page<Board> findByTitleContaining(String keyword, Pageable page);
	
	@Query("SELECT b FROM Board b WHERE b.bno > 0")
	public List<Page> findAll(Pageable page);

}
