package com.moekr.moocoder;

import com.moekr.moocoder.dao.ExamDAO;
import com.moekr.moocoder.dao.UserDAO;
import com.moekr.moocoder.service.DataService;
import com.moekr.moocoder.vo.ProblemVO;
import com.moekr.moocoder.vo.UserVO;
import com.moekr.moocoder.vo.final_statisticVO;
import lombok.extern.apachecommons.CommonsLog;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@CommonsLog
public class MoocoderApplicationTests {
    @Autowired
    DataService dataService;

    @Autowired
    UserDAO userDAO;
    @Autowired
    ExamDAO examDAO;

    @Test
    public void finduser() {
        System.out.println(dataService.retrieveUserInfo(305).getProblem_name());

    }

    @Test
    public void spide() {
        List<String> username = userDAO.findUserNameById();
        List<String> examuuid = examDAO.findExamUUid();
        for (String uuid : examuuid) {
            for (String i : username) {
                System.out.println(i);
                String localPath = "/Users/cyz/Desktop/test/" + uuid + "/" + i;
                String url = "http://192.168.48.201:8081/" + i + "/" + uuid + ".git";
                cloneRepository(url, localPath);
            }
        }
    }

    public static String cloneRepository(String url, String localPath) {
        try {
            System.out.println("开始下载......");

            CloneCommand cc = Git.cloneRepository().setURI(url);
            cc.setCredentialsProvider(new UsernamePasswordCredentialsProvider("root", "NJU67gitlab"));
            cc.setDirectory(new File(localPath)).call();
            System.out.println("下载完成......");

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


}
