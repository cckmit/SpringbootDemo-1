package com.example.springbootdemo.scheduled.demo;

import com.example.springbootdemo.scheduled.dao.ProductSkuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-14
 **/
//@Slf4j
//@Component
public class ScheduledComponent {

    /**
     * 保存任务
     */
    private Map<String, ScheduledFuture<?>> futuresMap = new ConcurrentHashMap<>();


    /**
     * 创建ThreadPoolTaskScheduler线程池
     */
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    private ProductSkuDao productSkuDao;


    /**
     * 初始化任务
     */
    @PostConstruct
    public void initTimmer() {
//        Long aLong = productSkuDao.selectProductSkuList();
//
//        System.out.println(1111);
        /*List<ScheduleConfig> list = new ArrayList<>();
        ScheduleConfig scheduleConfig = new ScheduleConfig();
        scheduleConfig.setClassName("com.example.springbootdemo.scheduled.servicer.SendMessage");
        scheduleConfig.setCron("0/10 * * * * ? ");
        scheduleConfig.setJobName("test1");
        scheduleConfig.setMethod("sendMessage");
        scheduleConfig.setStatus((byte) 0);
        list.add(scheduleConfig);
        for (ScheduleConfig s : list) {
            ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(getRunnable(s), getTrigger(s));
            futuresMap.put(s.getJobName(), future);
        }*/
    }




    public void addTask(Long i,Date date){
        ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            log.info(String.valueOf(i));
        }, date);
    }


    /**
     * 暂停任务
     * @param key
     * @return
     */
    public boolean pauseeTask(String key) {
        ScheduledFuture toBeRemovedFuture = futuresMap.remove(key);
        if (toBeRemovedFuture != null) {
            toBeRemovedFuture.cancel(true);
            return true;
        } else {
            return false;
        }
    }





}
