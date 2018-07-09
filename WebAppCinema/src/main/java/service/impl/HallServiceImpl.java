package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.HallDTO;

import mapper.BeanMapper;
import model.Hall;
import model.User;
import service.api.Service;

import java.util.List;

public class HallServiceImpl implements Service<Integer, HallDTO> {

    private static HallServiceImpl  service;
    private Dao<Integer, Hall> hallDao;
    private BeanMapper beanMapper;


    private HallServiceImpl() {
        hallDao = DaoFactory.getInstance().getHallDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized HallServiceImpl getInstance() {
        if (service == null) {
            service = new HallServiceImpl();
        }
        return service;
    }


    @Override
    public List<HallDTO> getAll() {
        List<Hall> halls = hallDao.getAll();
        List<HallDTO> hallDTOs = beanMapper.listMapToList(halls, HallDTO.class);
        return hallDTOs;
    }

    @Override
    public HallDTO getById(Integer id) {
        Hall hall = hallDao.getById(id);
        HallDTO hallDTO = beanMapper.singleMapper(hall, HallDTO.class);
        return hallDTO;
    }

    @Override
    public void save(HallDTO entity) {
        Hall hall = beanMapper.singleMapper(entity, Hall.class);
        hallDao.save(hall);
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(HallDTO entity) {

    }
}
