package com.moekr.moocoder.controller;

import com.moekr.moocoder.response.DataResponse;
import com.moekr.moocoder.response.Response;
import com.moekr.moocoder.service.DataService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/student")
@CommonsLog
public class DataController {
    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;

    }
    /**
     * 查看学生历史记录
     *
     * @param userId    学生Id
     * @return
     */
    @PostMapping("/student/{userId}")
    @CrossOrigin
    public Response retrieveUserInfo(@PathVariable int userId){

        return new DataResponse(dataService.retrieveUserInfo(userId));
    }


}
