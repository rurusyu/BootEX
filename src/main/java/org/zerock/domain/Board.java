package org.zerock.domain;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="tbl_boards")
public class Board {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO) // autoIncrement
		private Long bno;
		private String title;
		private String content;
		private String writer;
		
}
