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
        StudentIT rit = new StudentIT();
        rit.openSSF();;
//        Student blah blah tu them
//        tuong tu vs cac cai khac
//        nho co open SSF va close SSF
//        da co student dau ma run :))
        rit.closeSSF();
    }
}