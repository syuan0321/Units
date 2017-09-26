/**********************************************************
Lifecycle Event Pattern (Tomcat style)

New -> Initializing -> Initianized -> Staring -> Started -> Suspending -> Suspended 
    -> Resuming -> Resumed -> Destroying -> Destroyed

Failed

If any one state above fails, turn to be Failed 
-------------------------------------------------------------
Interfaces :
1.ILifecycle //Any class implement this interface will be reconized as Lifecycle
2.ILifecycleListener //Listen to the trggers

-------------------------------------------------------------
AbstractLifecycle simplely implemented the all events and leave the sub abstract method let children to finish:

protected abstract void init0() throws LifecycleException;
protected abstract void start0() throws LifecycleException;
protected abstract void suspend0() throws LifecycleException;
protected abstract void resume0() throws LifecycleException;
protected abstract void destroy0() throws LifecycleException;

DefaultLifecycle is the port which let other implementation follows:
These two classes(AbstractLifecycle + DefaultLifecycle) enforce the state order and relationship as state sequence mentioned above



***********************************************************/