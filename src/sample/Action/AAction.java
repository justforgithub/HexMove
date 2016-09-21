package sample.Action;

import sample.MyValues;

/**
 * Created by Deviltech on 12.09.2016.
 */
public abstract class AAction {

    public MyValues.ACTION_STATUS actionStatus;

    public abstract void execute();

    public boolean isObsolete(){
        return actionStatus.equals(MyValues.ACTION_STATUS.OBSOLETE);
    }

    public boolean isInit(){
        return actionStatus.equals(MyValues.ACTION_STATUS.INIT);
    }

    public boolean isReady(){
        return actionStatus.equals(MyValues.ACTION_STATUS.READY);
    }

    public boolean isWait(){
        return actionStatus.equals(MyValues.ACTION_STATUS.WAIT);
    }

    public void setReady(){
        actionStatus = MyValues.ACTION_STATUS.READY;
    }


}
