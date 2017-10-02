package com.syuan0321.unitseed.LifecycleEvent.main;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.syuan0321.unitseed.LifecycleEvent.DefaultLifecycleManager;
import com.syuan0321.unitseed.LifecycleEvent.LifecycleException;

public class MySocketServer extends DefaultLifecycleManager {

    private ServerSocket acceptor = null;
    private int port = 9527;
    /* 
     * @see DefaultLifecycle#init0()
     */
    @Override
    protected void init0() throws LifecycleException {
        try {
            acceptor = new ServerSocket(port);
        } catch (IOException e) {
            throw new LifecycleException(e.getMessage());
        }
    }

    /* 
     * @see DefaultLifecycle#start0()
     */
    @Override
    protected void start0() throws LifecycleException {
        Socket socket = null;
        try {
            socket = acceptor.accept();
            //do something with socket
            
            
        } catch (IOException e) {
            throw new LifecycleException(e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /* 
     * @see DefaultLifecycle#destroy0()
     */
    @Override
    protected void destroy0() throws LifecycleException {
        if (acceptor != null) {
            try {
                acceptor.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
