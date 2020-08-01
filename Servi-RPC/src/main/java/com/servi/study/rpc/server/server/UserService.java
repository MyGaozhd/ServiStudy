package com.servi.study.rpc.server.server;

import com.servi.study.rpc.entry.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public int addUser(User userinfo) {
        logger.debug("create user success, uid=" + userinfo.getUid());
        return 0;
    }
}
