package Main;

import java.util.Date;
import java.util.*;
import java.io.*;

import Interactive.*;
import Object.*;
import com.jcg.hibernate.maven.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppMain {

    static SessionFactory sessionFactoryObj;
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        RoomIT rit = new RoomIT();
        rit.openSSF();;
        rit.addRoom("1", "1", 1, 12);
        rit.searchRoom("1");
        rit.closeSSF();
    }
}