package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

import lombok.extern.java.Log;
@Log
@RestController
public class SampleController {

	@Autowired
	BoardRepository repo;
	
	@GetMapping("/list")
	public Page<Board> list(@PageableDefault(size=10,page=0,direction=Direction.DESC, sort="bno") Pageable page){
		
		String keyword ="1";
		
		log.info(page.getClass().getName());
		
		return repo.findByTitleContaining(keyword, page);
	}
	
	
}
