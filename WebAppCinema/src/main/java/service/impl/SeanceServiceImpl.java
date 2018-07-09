package service.impl;


import dao.DaoFactory;
import dao.api.Dao;
import dto.SeanceDTO;
import dto.UserDTO;
import mapper.BeanMapper;
import model.Movie;
import model.Seance;
import model.User;
import service.api.Service;

import java.util.List;

public class SeanceServiceImpl implements Service<Integer, SeanceDTO> {

    private static SeanceServiceImpl service;
    private Dao<Integer, Seance> seanceDao;
    private BeanMapper beanMapper;

    private SeanceServiceImpl() {
        seanceDao = DaoFactory.getInstance().getSeanceDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized SeanceServiceImpl getInstance() {
        if (service == null) {
            service = new SeanceServiceImpl();
        }
        return service;
    }

    @Override
    public List<SeanceDTO> getAll() {
        List<Seance> seances = seanceDao.getAll();
        List<SeanceDTO> seanceDTOs = beanMapper.listMapToList(seances, SeanceDTO.class);
        return seanceDTOs;
    }

    @Override
    public SeanceDTO getById(Integer id) {
        Seance seance = seanceDao.getById(id);
        SeanceDTO seanceDTO = beanMapper.singleMapper(seance, SeanceDTO.class);
        return seanceDTO;
    }

    public List<SeanceDTO>getByMovie(int id_movie){
        List<Seance> seances = seanceDao.getByInt("movie", id_movie, "Seance");

        List<SeanceDTO> seanceDTOs = beanMapper.listMapToList(seances, SeanceDTO.class);
        return seanceDTOs;
    }


    @Override
    public void save(SeanceDTO entity) {
        Seance seance = beanMapper.singleMapper(entity, Seance.class);
        seanceDao.save(seance);

    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(SeanceDTO entity) {

    }
}
