package com.qefee.pj.eperm;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.qefee.pj.eperm.util.PermissionUtil;

/**
 * EPerm.
 * <ul>
 * <li>date: 16/9/10</li>
 * </ul>
 *
 * @author tongjin
 */
public class EPerm {

    public static EPerm make(@NonNull Activity activity,@NonNull String permission) {
        return new EPerm(activity, permission);
    }

    Activity activity;
    String permission;

    public EPerm(@NonNull Activity activity,@NonNull String permission) {
        this.activity = activity;
        this.permission = permission;
    }

    public Activity getActivity() {
        return activity;
    }

    public String getPermission() {
        return permission;
    }

    /**
     * has permission.
     *
     * @return result
     */
    public boolean has() {
        return PermissionUtil.has(activity, permission);
    }

    /**
     * reason for permission.
     *
     * @return result
     */
    public boolean hasReason() {
        return PermissionUtil.hasReason(activity,
                permission);
    }

    /**
     * request permission.
     *
     * @param requestCode requestCode
     */
    public void request(final int requestCode) {
        PermissionUtil.request(activity,
                permission,
                requestCode);
    }
}
