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
    public static void DataTest() {
        AccountIT ait = new AccountIT();
        RoomIT rit = new RoomIT();
        rit.openSSF();
        ait.openSSF();

        for (int i = 1;i <= 50;++ i) {
            ait.Registration("admin" + i, "1", "1");
        }
        rit.closeSSF();
        ait.closeSSF();

    }

    public static void main(String[] args) {
        DataTest();
    }
}