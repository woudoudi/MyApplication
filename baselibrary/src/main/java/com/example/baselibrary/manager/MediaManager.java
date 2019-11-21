package com.example.baselibrary.manager;

import android.graphics.Camera;
import android.media.MediaRecorder;

public class MediaManager {

    private MediaRecorder mediaRecorder;
    private Camera camera;


    private MediaManager(){
        mediaRecorder = new MediaRecorder();
    }

    public boolean init(){
        mediaRecorder.reset();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

        return true;

    }
}
