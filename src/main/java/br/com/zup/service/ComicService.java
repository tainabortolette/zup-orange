package br.com.zup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnaudpiroelle.marvel.api.MarvelApi;
import com.arnaudpiroelle.marvel.api.exceptions.AuthorizationException;
import com.arnaudpiroelle.marvel.api.exceptions.EntityNotFoundException;
import com.arnaudpiroelle.marvel.api.exceptions.QueryException;
import com.arnaudpiroelle.marvel.api.exceptions.RateLimitException;
import com.arnaudpiroelle.marvel.api.objects.ref.DataWrapper;
import com.arnaudpiroelle.marvel.api.services.sync.ComicsService;

import br.com.zup.modelo.Comic;
import br.com.zup.repository.ComicRepository;

@Service
public class ComicService {

	@Autowired
	private ComicRepository repository;

	public List<Comic> lista() {
		return repository.findAll();
	}

	public void save(Integer comicId) throws AuthorizationException, QueryException, RateLimitException, EntityNotFoundException {
		MarvelApi.configure()
				.withApiKeys("4193fab77f516903827e79b85dd3d485", "01ad6fcd9e9e8ca8017bee2296468bd01aee843a").init();

		ComicsService comicsService = MarvelApi.getService(ComicsService.class);

		DataWrapper<com.arnaudpiroelle.marvel.api.objects.Comic> comicWrapper = comicsService
				.getComic(comicId);

		com.arnaudpiroelle.marvel.api.objects.Comic comicAchada = comicWrapper.getData().getResults().get(0);

		repository.save(Comic.builder().id(comicAchada.getId())
				.isbn(comicAchada.getIsbn())
				.title(comicAchada.getTitle())
				.prices(comicAchada.getPrices().get(0).getPrice())
				.creators(comicAchada.getCreators().getItems().toString())
				.description(comicAchada.getDescription()).build());

	}

}
