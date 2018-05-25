package com.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Listenerlocalhost extends HttpServlet implements
        ServletRequestListener, ServletRequestAttributeListener {

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("�����ʼ��");
        ServletRequest sr = sre.getServletRequest();
        System.out.println("Զ�̻�����IP:" + sr.getRemoteAddr());
        System.out.println("���ػ�����IP:" + sr.getLocalAddr());
        if (sr.getRemoteHost().equals(sr.getLocalAddr())) {
            sr.setAttribute("login", "true");
        } else {
            sr.setAttribute("login", "false");
        }
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("��������");
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
