package nl.hu.bep.setup;

import nl.hu.bep.domeinmodel.Medewerker;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.HttpResources;

import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.Duration;

@WebListener
public class MyServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("Initializing application...");
        Medewerker m1 = new Medewerker("Jayro Patti", "608239", "kaasje123" );


    }
//    @Override
//    public void contextDestroyed(ServletContextEvent sce){
//        System.out.println("Terminating application");
//    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener-Destroyed");
        try{
            nl.hu.bep.Persistence.PersistenceManager.saveWorldToAzure();
        } catch (Exception e){
            System.out.println("Error loading data..." + e.getMessage());
            e.printStackTrace();
        }

        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();
    }

}
