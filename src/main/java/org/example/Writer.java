package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Map;


@Slf4j
public class Writer {
    public void writeDownTasksResult(StopWatch methodStopWatch, List<EconomicsTask> tasks,
                                     Map<TaskResultStatus, List<EconomicsTask>> results) {
        log.info("Total task execution time: {} seconds. " +
                 "\n Results of the tasks:: {}" +
                 "\n Total tasks:: {}, Successfully completed: {}, Failed: {}" +
                 "\n Details of Failed Tasks: {}",
                methodStopWatch.getTotalTimeSeconds(),
                methodStopWatch.prettyPrint(),
                tasks.size(),
                results.get(TaskResultStatus.SUCCESS).size(),
                results.get(TaskResultStatus.FAILED).size(),
                results.get(TaskResultStatus.FAILED)
        );
    }
}