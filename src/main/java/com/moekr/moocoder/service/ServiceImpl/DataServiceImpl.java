package com.moekr.moocoder.service.ServiceImpl;

import com.moekr.moocoder.dao.ProblemDAO;
import com.moekr.moocoder.dao.UserDAO;
import com.moekr.moocoder.dao.final_statisticDAO;
import com.moekr.moocoder.entity.Problem;
import com.moekr.moocoder.entity.User;
import com.moekr.moocoder.entity.final_statistic;
import com.moekr.moocoder.service.DataService;
import com.moekr.moocoder.vo.ProblemVO;
import com.moekr.moocoder.vo.UserInfoVO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class DataServiceImpl implements DataService {

    private final UserDAO userDAO;
    private final final_statisticDAO finalStatisticDAO;
    private final ProblemDAO problemDAO;
    @Autowired
    public DataServiceImpl(UserDAO userDAO, final_statisticDAO finalStatisticDAO, ProblemDAO problemDAO) {
        this.userDAO = userDAO;
        this.finalStatisticDAO = finalStatisticDAO;
        this.problemDAO = problemDAO;
    }

    @Override
    public UserInfoVO retrieveUserInfo(int userId) throws ServiceException{
        UserInfoVO userInfoVO = new UserInfoVO();
        User user = userDAO.findById(userId);
        final_statistic finalStatistic = finalStatisticDAO.findById(userId);
        Optional<Problem> problem = problemDAO.findById(finalStatistic.getMax_commit_problem());

        userInfoVO.setUsername(user.getUsername());
        Duration duration = Duration.between(finalStatistic.getFirst_commit_time(), finalStatistic.getLast_commit_time());
        userInfoVO.setFirst_commit_time(finalStatistic.getFirst_commit_time().format((DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        userInfoVO.setLast_commit_time(finalStatistic.getLast_commit_time().format((DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        userInfoVO.setPeriod((int)duration.toDays());
        userInfoVO.setSolved_count(finalStatistic.getSolved_count());
        userInfoVO.setSolved_count_java(finalStatistic.getSolved_count_java());
        userInfoVO.setSolved_count_python(finalStatistic.getSolved_count_python());
        userInfoVO.setCommit_count(finalStatistic.getCommit_count());
        userInfoVO.setAverage_score(finalStatistic.getAverage_score());

        String latest_time = finalStatistic.getLatest_night_commit_time().toString().substring(0,17);
        userInfoVO.setLatest_night_commit_time(latest_time);
        userInfoVO.setMax_commit_problem_commit_count(finalStatistic.getMax_commit_problem_commit_count());
        userInfoVO.setProblem_name(problem.map(ProblemVO::new).orElse(null).getName());
        return userInfoVO;

    }
}
