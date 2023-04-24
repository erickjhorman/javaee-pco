package org.example.utils;


import org.example.domain.UserDTO;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Stateless
public class CacheUtils {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(CacheUtils.class.toString());
    private Map<Integer, UserDTO> userMap;

    {
        userMap = loadCache();
    }

    public UserDTO getUser(int idUser) {
        LOGGER.info("Getting user info from cache" + idUser);
        return userMap.get(idUser);
    }

    private Map<Integer, UserDTO> loadCache() {
        userMap = new HashMap<Integer, UserDTO>();
        userMap.put(1, new UserDTO(1, "Jhonathan", 4)); //User libranza tradicional
        userMap.put(2, new UserDTO(2, "Alexis", 25)); //User libranza especial
        return userMap;
    }

}
