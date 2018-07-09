package service.impl;


import dao.DaoFactory;
import dao.api.Dao;
import dto.MovieDTO;
import mapper.BeanMapper;
import model.Movie;
import service.api.Service;

import java.util.List;

public class MovieServiceImpl implements Service<Integer, MovieDTO> {

    private static MovieServiceImpl service;
    private Dao<Integer, Movie> movieDao;
    private BeanMapper beanMapper;

    private MovieServiceImpl() {
        movieDao = DaoFactory.getInstance().getMovieDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized MovieServiceImpl getInstance() {
        if (service == null) {
            service = new MovieServiceImpl();
        }
        return service;
    }


    @Override
    public List<MovieDTO> getAll() {
        List<Movie> movies = movieDao.getAll();
        List<MovieDTO> movieDTOs = beanMapper.listMapToList(movies, MovieDTO.class);
        return movieDTOs;
    }

    @Override
    public void save(MovieDTO movieDto) {
        Movie movie = beanMapper.singleMapper(movieDto, Movie.class);
        movieDao.save(movie);
    }

    @Override
    public MovieDTO getById(Integer id) {
        Movie movie = movieDao.getById(id);
        MovieDTO movieDTO = beanMapper.singleMapper(movie, MovieDTO.class);
        return movieDTO;
    }


    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(MovieDTO entity) {

    }

}
