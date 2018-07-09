package dao;

import dao.api.Dao;
import dao.impl.*;

import helper.PropertyHolder;
import model.*;


public class DaoFactory {
    private static DaoFactory instance = null;

    private Dao<Integer, Movie> movieDao;
    private Dao<Integer, User> userDao;
    private Dao<Integer, Hall> hallDao;
    private Dao<Integer, Seance> seanceDao;
    private Dao<Integer, Place> placeDao;
    //private Dao<Integer, Role> roleDao;

    private DaoFactory(){
        loadDaos();
    }



    public static DaoFactory getInstance(){
        if(instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }

    private void loadDaos() {
       if(PropertyHolder.getInstance().isInMemoryDB()){
            //inmemory daos
       }else{
           //jdbc daos
           movieDao = MovieDaoImpl.getInstance();
           seanceDao= SeanceDaoImpl.getInstance();
           hallDao= HallDaoImpl.getInstance();
           placeDao= PlaceDaoImpl.getInstance();
           userDao = new UserDaoImpl();
         //  roleDao = new RoleDAOImpl();
       }
    }

    public Dao<Integer, Movie> getMovieDao() {
        return movieDao;
    }

    public Dao<Integer, Place> getPlaceDao() {
        return placeDao;
    }

    public Dao<Integer, Seance> getSeanceDao() {
        return seanceDao;
    }

    public void setMovieDao(Dao<Integer, Movie> movieDao) {
        this.movieDao = movieDao;
    }

    public static void setInstance(DaoFactory instance) {
        DaoFactory.instance = instance;
    }

    public Dao<Integer, User> getUserDao() {
        return userDao;
    }

    public Dao<Integer, Hall> getHallDao() {
        return hallDao;
    }


    public void setUserDao(Dao<Integer, User> userDao) {
        this.userDao = userDao;
    }

    public void setSeanceDao(Dao<Integer, Seance> seanceDao) {
        this.seanceDao = seanceDao;
    }
    public void setHallDao(Dao<Integer, Hall> hallDao) {
        this.hallDao = hallDao;
    }



 /*   public Dao<Integer, Role> getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(Dao<Integer, Role> roleDao) {
        this.roleDao = roleDao;
    }
*/}
