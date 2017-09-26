package com.syuan0321.unitseed.LifecycleEvent;

public interface ILifecycle {

    /**
     * 
     * @throws LifecycleException
     */
    public void init() throws LifecycleException;

    /**
     * 
     * @throws LifecycleException
     */
    public void start() throws LifecycleException;

    /**
     * 
     * @throws LifecycleException
     */
    public void suspend() throws LifecycleException;

    /**
     * 
     * @throws LifecycleException
     */
    public void resume() throws LifecycleException;

    /**
     * 
     * @throws LifecycleException
     */
    public void destroy() throws LifecycleException;

    /**
     * 
     * @param listener
     */
    public void addLifecycleListener(ILifecycleListener listener);

    /**
     * 
     * @param listener
     */
    public void removeLifecycleListener(ILifecycleListener listener);
}
