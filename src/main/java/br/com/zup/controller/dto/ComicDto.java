package br.com.zup.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.modelo.Comic;
import lombok.Data;

@Data
public class ComicDto {
	
	private Integer id;
	private String isbn;
	private String title;
	private Float prices;
	private String creators;
	private String description;
	
	public ComicDto(Comic comic) {
		this.id = comic.getId();
		this.isbn = comic.getIsbn();
		this.title = comic.getTitle();
		this.prices = comic.getPrices();
		this.creators = comic.getCreators();
		this.description = comic.getDescription();
	}
	
	public static List<ComicDto> converter(List<Comic> comics) {
		return comics.stream().map(ComicDto::new).collect(Collectors.toList());
	}

}
