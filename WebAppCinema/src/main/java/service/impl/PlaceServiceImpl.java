package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.PlaceDTO;
import dto.SeanceDTO;
import mapper.BeanMapper;
import model.Place;
import model.Seance;
import service.api.Service;

import java.util.List;

public class PlaceServiceImpl implements Service<Integer, PlaceDTO> {

    private static PlaceServiceImpl service;
    private Dao<Integer, Place> placeDao;
    private BeanMapper beanMapper;

    private PlaceServiceImpl() {
        placeDao = DaoFactory.getInstance().getPlaceDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized PlaceServiceImpl getInstance() {
        if (service == null) {
            service = new PlaceServiceImpl();
        }
        return service;
    }




    @Override
    public List<PlaceDTO> getAll() {
        List<Place> places = placeDao.getAll();
        List<PlaceDTO> placeDTOs = beanMapper.listMapToList(places, PlaceDTO.class);
        return placeDTOs;
    }

    @Override
    public PlaceDTO getById(Integer id) {
        Place place = placeDao.getById(id);
        PlaceDTO placeDTO = beanMapper.singleMapper(place, PlaceDTO.class);
        return placeDTO;
    }

    public List<PlaceDTO>getBySeance(int id_seance){
        List<Place> places = placeDao.getByInt("seance", id_seance, "Place");

        List<PlaceDTO> placeDTOs = beanMapper.listMapToList(places, PlaceDTO.class);
        return placeDTOs;
    }

    public List<PlaceDTO>getByUser(int id_user){
        List<Place> places = placeDao.getByInt("user", id_user, "Place");
        List<PlaceDTO> placeDTOs = beanMapper.listMapToList(places, PlaceDTO.class);
        return placeDTOs;
    }



    @Override
    public void save(PlaceDTO entity) {
        Place place = beanMapper.singleMapper(entity, Place.class);
        placeDao.save(place);

    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(PlaceDTO entity) {
        Place place = beanMapper.singleMapper(entity, Place.class);
        placeDao.update(place);

    }
}
