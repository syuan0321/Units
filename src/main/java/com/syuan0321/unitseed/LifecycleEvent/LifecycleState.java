package com.syuan0321.unitseed.LifecycleEvent;

public enum LifecycleState {

    NEW, 

    INITIALIZING, INITIALIZED, //Ini

    STARTING, STARTED, //Start

    SUSPENDING, SUSPENDED, //Pause

    RESUMING, RESUMED,//Resume

    DESTROYING, DESTROYED,//Deplete

    FAILED;//Fail

}
