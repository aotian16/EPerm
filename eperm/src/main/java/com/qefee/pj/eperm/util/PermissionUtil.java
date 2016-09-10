package com.qefee.pj.eperm.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * PermissionUtil.
 * <ul>
 * <li>date: 16/7/18</li>
 * </ul>
 *
 * @author tongjin
 */
public class PermissionUtil {
    /**
     * has permission.
     *
     * @param context    context
     * @param permission permission
     * @return result
     */
    public static boolean has(@NonNull Context context, @NonNull String permission) {
        return ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean hasReason(@NonNull Activity activity,
                                    @NonNull String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity,
                permission);
    }

    /**
     * request permission.
     *
     * @param activity    activity
     * @param permissions permissions
     * @param requestCode requestCode
     */
    public static void request(final @NonNull Activity activity,
                               final @NonNull String[] permissions,
                               final int requestCode) {
        ActivityCompat.requestPermissions(activity,
                permissions,
                requestCode);
    }

    /**
     * request permission.
     *
     * @param activity    activity
     * @param permission  permission
     * @param requestCode requestCode
     */
    public static void request(final @NonNull Activity activity,
                               final @NonNull String permission,
                               final int requestCode) {
        String[] permissions = {permission};
        request(activity,
                permissions,
                requestCode);
    }
}
