package ir.isc.BankCard.services.serviceImpl;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@Service
@EnableScheduling
public class MemoryManagementServiceImpl {

    @Scheduled(initialDelayString = "${scheduler.memory.management.initialDelay}", fixedDelayString = "${scheduler.memory.management.fixedDelay}")
    public void calculateMemoryUsage(){
        MemoryMXBean memoryMXBean =  ManagementFactory.getMemoryMXBean();
        System.out.println("heap memory usage : " + memoryMXBean.getHeapMemoryUsage().toString());
        System.out.println("not heap memory usage : " + memoryMXBean.getNonHeapMemoryUsage().toString());
    }
}
