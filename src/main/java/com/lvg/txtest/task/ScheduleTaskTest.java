package com.lvg.txtest.task;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Victor Levchenko LVG Corp. on 20.11.16.
 */
public class ScheduleTaskTest {
    private static final Logger LOG = Logger.getLogger(ScheduleTaskTest.class);
    public static void main(String[] args) {
        LOG.info("STARTING SCHEDULE TASK TEST APPLICATION");

        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("META-INF/spring/task-namespace-app-context.xml");
        while (true){

        }

    }

}
