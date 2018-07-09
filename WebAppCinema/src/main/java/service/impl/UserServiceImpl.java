package service.impl;


import dao.DaoFactory;
import dao.api.Dao;
import dto.UserDTO;
import mapper.BeanMapper;
import model.User;
import service.api.Service;

import java.util.List;

/**
 * Created by dmitr on 13.06.2016.
 */
public class UserServiceImpl implements Service<Integer, UserDTO> {

    private static UserServiceImpl service;
    private Dao<Integer, User> userDao;
    private BeanMapper beanMapper;

    private UserServiceImpl() {
        userDao = DaoFactory.getInstance().getUserDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized UserServiceImpl getInstance() {
        if (service == null) {
            service = new UserServiceImpl();
        }
        return service;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userDao.getAll();
        List<UserDTO> userDTOs = beanMapper.listMapToList(users, UserDTO.class);
        return userDTOs;
    }

    @Override
    public UserDTO getById(Integer id) {
        User user = userDao.getById(id);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public void save(UserDTO UserDTO) {
        User user = beanMapper.singleMapper(UserDTO, User.class);
       user.setRole(UserDTO.getRole().name());
        userDao.save(user);
    }

    public UserDTO getByLogin(String value){
        User user = userDao.getBy("login", value);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(UserDTO entity) {

    }
}
