package com.moekr.moocoder;

import com.moekr.moocoder.dao.UserDAO;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.util.List;

public class JGitUtil {
    static UserDAO userDAO;

    public static void main(String[] args) {
        List<String> username = userDAO.findUserNameById();
        for (String i : username) {
            System.out.println(i);
            String localPath = "/Users/cyz/Desktop/spide-data/" + i;
            String url = "http://192.168.48.201:8081/" + i + "/d9daba0607ec4b24b2575aedc38704b9.git";
            cloneRepository(url, localPath);
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

