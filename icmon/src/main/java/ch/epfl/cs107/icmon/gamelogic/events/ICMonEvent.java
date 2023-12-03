package ch.epfl.cs107.icmon.gamelogic.events;

import ch.epfl.cs107.icmon.ICMon;
import ch.epfl.cs107.icmon.actor.ICMonActor;
import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.gamelogic.actions.Action;
import ch.epfl.cs107.icmon.gamelogic.actions.RegisterEventAction;
import ch.epfl.cs107.icmon.gamelogic.actions.UnregisterEventAction;
import ch.epfl.cs107.icmon.handler.ICMonInteractionVisitor;
import ch.epfl.cs107.play.engine.Updatable;
import ch.epfl.cs107.play.math.Orientation;

import java.util.ArrayList;
import java.util.List;

public abstract class ICMonEvent implements Updatable, ICMonInteractionVisitor {

    private boolean isStarted = false;
    private boolean isCompleted = false;
    private boolean isSuspended = false;

    private final List<Action> startActions = new ArrayList<>();
    private final List<Action> suspendActions = new ArrayList<>();
    private final List<Action> resumeActions = new ArrayList<>();
    private final List<Action> completeActions = new ArrayList<>();

    protected ICMon.ICMonEventManager eventManager;
    protected ICMonPlayer player;

    public ICMonEvent(ICMon.ICMonEventManager eventManager, ICMonPlayer player) {
        this.eventManager = eventManager;
        this.player = player;
    }

    public ICMon.ICMonEventManager getEventManager() {
        return eventManager;
    }

    private void performActions(List<Action> actions) {
        for (Action action : actions) {
            action.perform();
        }
    }

    final public void start() {
        if (!isStarted) {
            performActions(startActions);
            isStarted = true;
        }
    }

    final public void complete() {
        if (isStarted && !isCompleted) {
            performActions(completeActions);
            isCompleted = true;
        }
    }

    final public void suspend() {
        if (isStarted && !isCompleted && !isSuspended) {
            performActions(suspendActions);
            isSuspended = true;
        }
    }

    final public void resume() {
        if (!isCompleted && isSuspended && isStarted) {
            performActions(resumeActions);
            isSuspended = false;
        }
    }

    final public void onStart(Action action) {
        startActions.add(action);
    }

    final public void onComplete(Action action) {
        completeActions.add(action);
    }

    final public void onSuspension(Action action) {
        suspendActions.add(action);
    }

    final public void onResume(Action action) {
        resumeActions.add(action);
    }

    final public boolean isStarted() {
        return isStarted;
    }

    final public boolean isCompleted() {
        return isCompleted;
    }

    final public boolean isSuspended() {
        return isSuspended;
    }
}