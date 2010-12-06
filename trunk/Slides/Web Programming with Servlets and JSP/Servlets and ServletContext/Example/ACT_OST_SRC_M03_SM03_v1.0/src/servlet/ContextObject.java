/*
 * ContextObject.java
 *
 * This program creates a context object
 *
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
package servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/** ContextObject class creates a context object
 *
 * @author vincent
 */
public class ContextObject {
    private List list=new ArrayList();
    private Timer timer=null;
    private boolean isCont=true;
    public ContextObject() {
    }
    public void time() {
        Date some=new Date();
        list.add(some);
    }
    public List getTime() {
        return list;
    }
    public void startTimeStamp() {
        timer=new Timer();
        timer.start();
    }
    public void stopTimeStamp() {
        isCont=false;
        timer.interrupt();
    }
    class Timer extends Thread {
        public void run() {
            while(isCont) {
                try {
                    sleep(1000);
                } catch(InterruptedException ex) {
                    interrupt();
                    break;
                }
                time();
            }
        }
    }
}
