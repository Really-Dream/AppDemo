package com.dream.Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

public class ListenerTest implements HttpSessionListener,HttpSessionAttributeListener {
    ServletContext sc;
    @SuppressWarnings("rawtypes")
	ArrayList list = new ArrayList();
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        sc = httpSessionEvent.getSession().getServletContext();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        if(!list.isEmpty()){
            list.remove((String) httpSessionEvent.getSession().getAttribute("username"));
            sc.setAttribute("list",list);
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        list.add((String)httpSessionBindingEvent.getValue());
        sc.setAttribute("list",list);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
