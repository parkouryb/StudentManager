package Main;

import java.util.Date;
import java.util.*;
import java.io.*;

import Interactive.*;
import Object.*;
import View.LoginForm;
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
    public void DataTest() {
        AccountIT ait = new AccountIT();
        ait.openSSF();
        for (int i = 1;i <= 10;++ i) {
            ait.Registration("admin" + i, "1", "1");
        }
        ait.closeSSF();

    }

    public static void main(String[] args) {
        AppMain ap = new AppMain();
        ap.DataTest();
        LoginForm login = new LoginForm();
        login.setVisible(true);
    }
}