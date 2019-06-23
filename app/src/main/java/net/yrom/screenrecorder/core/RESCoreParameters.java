package net.yrom.screenrecorder.core;

import net.yrom.screenrecorder.tools.LogTools;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by lake on 16-3-16.
 */
public class RESCoreParameters {
    public boolean done;
    public boolean printDetailMsg;
    public int filterMode;
    public int videoWidth;
    public int videoHeight;
    public int videoFPS;
    public int previewColorFormat;
    public int mediacodecAVCColorFormat;
    public int mediacdoecAVCBitRate;
    public int videoBufferQueueNum;
    public int mediacodecAVCFrameRate;
    public int mediacodecAVCIFrameInterval;
    public int mediacodecAVCProfile;
    public int mediacodecAVClevel;

    public int mediacodecAACProfile;
    public int mediacodecAACSampleRate;
    public int mediacodecAACChannelCount;
    public int mediacodecAACBitRate;
    public int mediacodecAACMaxInputSize;

    //sender
    public int senderQueueLength;

    public RESCoreParameters() {
        done = false;
        printDetailMsg = false;
        filterMode = -1;
        videoWidth = -1;
        videoHeight = -1;
        videoFPS = -1;
        previewColorFormat = -1;
        mediacodecAVCColorFormat = -1;
        mediacdoecAVCBitRate = -1;
        videoBufferQueueNum = -1;
        mediacodecAVCFrameRate = -1;
        mediacodecAVCIFrameInterval = -1;
        mediacodecAVCProfile = -1;
        mediacodecAVClevel = -1;
        mediacodecAACProfile = -1;
        mediacodecAACSampleRate = -1;
        mediacodecAACChannelCount = -1;
        mediacodecAACBitRate = -1;
        mediacodecAACMaxInputSize = -1;
    }

    public void dump() {
        LogTools.e(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResParameter:");
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            field.setAccessible(true);
            try {
                sb.append(field.getName());
                sb.append('=');
                sb.append(field.get(this));
                sb.append(';');
            } catch (IllegalAccessException e) {
            }
        }
        return sb.toString();
    }
}
