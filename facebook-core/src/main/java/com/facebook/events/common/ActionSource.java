package com.facebook.events.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public enum ActionSource implements Parcelable {
    UNKNOWN(0),
    PERMALINK(1),
    DASHBOARD(2),
    NEWSFEED(3),
    GROUP(4),
    PAGE(5),
    TIMELINE(22),
    NOTIFICATION(29),
    GRAPH_SEARCH(70),
    LAUNCHER(78),
    PAGE_UPCOMING_EVENTS_CARD(98),
    MOBILE_SUGGESTIONS_DASHBOARD(201),
    MOBILE_SUGGESTIONS_LIST(202),
    MOBILE_EVENT_COMPOSER(203),
    MOBILE_BOOKMARK_TAB(206),
    MOBILE_SYSTEM_NOTIFICATION(207),
    MOBILE_SUBSCRIPTIONS_DASHBOARD(208),
    MOBILE_SUBSCRIPTIONS_LIST(209),
    GUESTS_VIEW(400);

    public static final String ACTION_REF_PARAM = "action_ref";

    private final int mParamValue;

    public static final Creator<ActionSource> CREATOR = new Creator<ActionSource>() {
        @Override
        public ActionSource createFromParcel(Parcel source) {
            String name = source.readString();
            return ActionSource.valueOf(name);
        }

        @Override
        public ActionSource[] newArray(int size) {
            return new ActionSource[0];
        }
    };

    private ActionSource(int i) {
        this.mParamValue = i;
    }

    public int describeContents() {
        return 0;
    }

    public int getParamValue() {
        return this.mParamValue;
    }

    public static void putActionRef(Bundle bundle, ActionSource actionSource) {
        bundle.putParcelable(ACTION_REF_PARAM, actionSource);
    }

    public void writeToParcel(Parcel parcel, int i) {
        String name = name();
        parcel.writeString(name);
    }
}
