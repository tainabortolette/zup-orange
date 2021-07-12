package br.com.zup.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Comic {
	
		@Id
		private Integer id;
		private String isbn;
		private String title;
		private Float prices;
		@Column(length=5000)
		private String creators;
		@Column(length=5000)
		private String description;


	
}
