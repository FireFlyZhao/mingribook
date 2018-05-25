package com.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Listenerlocalhost extends HttpServlet implements
        ServletRequestListener, ServletRequestAttributeListener {

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("请求初始化");
        ServletRequest sr = sre.getServletRequest();
        System.out.println("远程机器的IP:" + sr.getRemoteAddr());
        System.out.println("本地机器的IP:" + sr.getLocalAddr());
        if (sr.getRemoteHost().equals(sr.getLocalAddr())) {
            sr.setAttribute("login", "true");
        } else {
            sr.setAttribute("login", "false");
        }
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("请求销毁");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.print("request attrbite add >>");
        System.out.println(srae.getName()+"="+srae.getValue());
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.print("request attrbite removed >>");
        System.out.println(srae.getName()+"="+srae.getValue());    }


    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.print("request attrbite replaced >>");
        System.out.println(srae.getName()+"="+srae.getValue());}
}
