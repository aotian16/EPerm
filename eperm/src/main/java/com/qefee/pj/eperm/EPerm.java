package com.qefee.pj.eperm;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
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

    private static EPerm readCalendarPerm;
    private static EPerm writeCalendarPerm;
    private static EPerm cameraPerm;
    private static EPerm readContactsPerm;
    private static EPerm writeContactsPerm;
    private static EPerm getAccountsPerm;
    private static EPerm accessFileLocationPerm;
    private static EPerm accessCoarseLocationPerm;
    private static EPerm recordAudioPerm;
    private static EPerm readPhoneStatePerm;
    private static EPerm callPhonePerm;
    private static EPerm readCallLogPerm;
    private static EPerm writeCallLogPerm;
    private static EPerm addVoiceMailPerm;
    private static EPerm useSipPerm;
    private static EPerm processOutgoingCallsPerm;
    private static EPerm bodySensorsPerm;
    private static EPerm sendSMSPerm;
    private static EPerm receiveSMSPerm;
    private static EPerm readSMSPerm;
    private static EPerm receiveWapPushPerm;
    private static EPerm receiveMMSPerm;
    private static EPerm readExternalStoragePerm;
    private static EPerm writeExternalStoragePerm;

    public static EPerm getReadCalendarPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.READ_CALENDAR, readCalendarPerm);
    }

    public static EPerm getWriteCalendarPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.WRITE_CALENDAR, writeCalendarPerm);
    }

    public static EPerm getCameraPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.CAMERA, cameraPerm);
    }

    public static EPerm getReadContactsPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.READ_CONTACTS, readContactsPerm);
    }

    public static EPerm getWriteContactsPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.WRITE_CONTACTS, writeContactsPerm);
    }

    public static EPerm getGetAccountsPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.GET_ACCOUNTS, getAccountsPerm);
    }

    public static EPerm getAccessFileLocationPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.ACCESS_FINE_LOCATION, accessFileLocationPerm);
    }

    public static EPerm getAccessCoarseLocationPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.ACCESS_COARSE_LOCATION, accessCoarseLocationPerm);
    }

    public static EPerm getRecordAudioPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.RECORD_AUDIO, recordAudioPerm);
    }

    public static EPerm getReadPhoneStatePerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.READ_PHONE_STATE, readPhoneStatePerm);
    }

    public static EPerm getCallPhonePerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.CALL_PHONE, callPhonePerm);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static EPerm getReadCallLogPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.READ_CALL_LOG, readCallLogPerm);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static EPerm getWriteCallLogPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.WRITE_CALL_LOG, writeCallLogPerm);
    }

    public static EPerm getAddVoiceMailPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.ADD_VOICEMAIL, addVoiceMailPerm);
    }

    public static EPerm getUseSipPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.USE_SIP, useSipPerm);
    }

    public static EPerm getProcessOutgoingCallsPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.PROCESS_OUTGOING_CALLS, processOutgoingCallsPerm);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    public static EPerm getBodySensorsPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.BODY_SENSORS, bodySensorsPerm);
    }

    public static EPerm getSendSMSPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.SEND_SMS, sendSMSPerm);
    }

    public static EPerm getReceiveSMSPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.RECEIVE_SMS, receiveSMSPerm);
    }

    public static EPerm getReadSMSPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.READ_SMS, readSMSPerm);
    }

    public static EPerm getReceiveWapPushPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.RECEIVE_WAP_PUSH, receiveWapPushPerm);
    }

    public static EPerm getReceiveMMSPerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.RECEIVE_MMS, receiveMMSPerm);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static EPerm getReadExternalStoragePerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.READ_EXTERNAL_STORAGE, readExternalStoragePerm);
    }

    public static EPerm getWriteExternalStoragePerm(@NonNull Activity activity) {
        return getPerm(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE, writeExternalStoragePerm);
    }

    private static EPerm getPerm(@NonNull Activity activity, @NonNull String permission, EPerm eperm) {
        if (eperm == null) {
            return make(activity, permission);
        } else {
            return eperm;
        }
    }

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
