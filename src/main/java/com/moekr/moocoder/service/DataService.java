package com.moekr.moocoder.service;

import com.moekr.moocoder.vo.UserInfoVO;
import org.hibernate.service.spi.ServiceException;

public interface DataService {
    UserInfoVO retrieveUserInfo(int userId) throws ServiceException;

}
