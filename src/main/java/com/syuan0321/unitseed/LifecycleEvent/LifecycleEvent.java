package com.syuan0321.unitseed.LifecycleEvent;

public final class LifecycleEvent {

    private LifecycleState state;

    public LifecycleEvent(LifecycleState state) {
        this.state = state;
    }

    /**
     * @return the state status
     */
    public LifecycleState getState() {
        return state;
    }

}