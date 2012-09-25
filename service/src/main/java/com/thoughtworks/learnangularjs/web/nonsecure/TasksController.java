package com.thoughtworks.learnangularjs.web.nonsecure;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.learnangularjs.domain.TaskType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TasksController {

    @RequestMapping(value = "/tasktypes.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TaskType> getTaskTypes() {
        return ImmutableList.of(new TaskType("This is served from the Java service"),
                                new TaskType("Start the server"),
                                new TaskType("Set the alarm clock"));
    }
}
