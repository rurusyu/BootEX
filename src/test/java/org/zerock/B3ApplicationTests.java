package org.zerock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class B3ApplicationTests {

	@Autowired
	BoardRepository repo;
	
	
	@Test
	public void testFind1(){
		
		Board board = repo.getByTitle("Title...196");
		log.info(""+board);
	}
	
	@Test
	public void testFind2(){
		
		Pageable page = new PageRequest(0, 20, Sort.Direction.DESC, "bno") ;
		
		Page<Board> result = repo.findByTitleContaining("1",page);
		log.info(""+result);
		log.info(""+result.getTotalPages());
		log.info(""+result.getSize());
		log.info(""+result.getNumber());
		log.info(""+result.getTotalElements());
		
		result.getContent().forEach(b -> log.info(""+b));
		
	}
	
	
	@Test
	public void insertTest(){
		
		for(int i=1; i<200; i++){
			
			Board board = new Board();
			board.setTitle("Title...." + i);
			board.setContent("Content..." +i);
			board.setWriter("user0"+(i%10));
			repo.save(board);
		}
		
	}
	
	@Test
	public void readTest(){
		repo.findOne((long) 3);
		
	}
	
	@Test
	public void updateTest(){
		
		Board board = new Board();
		board.setBno((long)3);
		board.setTitle("승규");
		board.setContent("섬큔");
		board.setWriter("성춘");
		repo.save(board);
		
		
	}
	
	
	@Test
	public void deleteTest(){
		
		repo.delete((long) 2);
	}
	
	@Test
	public void contextLoads() {
	}

}
