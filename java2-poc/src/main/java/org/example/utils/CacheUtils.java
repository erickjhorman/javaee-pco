package org.example.utils;


import org.example.domain.User;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Stateless
public class CacheUtils {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(CacheUtils.class.toString());
    private Map<Integer, User> userMap;

    {
        userMap = loadCache();
    }

    public User getUser(int idUser) {
        LOGGER.info("Getting user info from cache" + idUser);
        return userMap.get(idUser);
    }

    private Map<Integer, User> loadCache() {
        userMap = new HashMap<Integer, User>();
        userMap.put(1, new User(1, "Jhonathan", 4)); //User libranza tradicional
        userMap.put(2, new User(2, "Alexis", 25)); //User libranza especial
        return userMap;
    }

}
