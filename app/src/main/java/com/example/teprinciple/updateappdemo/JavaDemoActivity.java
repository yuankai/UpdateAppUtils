package com.example.teprinciple.updateappdemo;

import android.os.Bundle;
import android.os.Environment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import constacne.DownLoadBy;
import constacne.UiType;
import listener.UpdateDownloadListener;
import model.UiConfig;
import model.UpdateConfig;
import update.UpdateAppUtils;

/**
 * desc: java使用实例
 * time: 2019/6/27
 * @author yk
 */
public class JavaDemoActivity extends AppCompatActivity {

    private String apkUrl = "https://nexus.buymice.net/repository/maven-releases/net/buymice/animal-steward/4.0.27/animal-steward-4.0.27.apk";
    private String updateTitle = "发现新版本V2.0.0";
    private String updateContent = "1、Kotlin重构版\n2、支持自定义UI\n3、增加md5校验\n4、更多功能等你探索";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_demo);

        findViewById(R.id.btn_java).setOnClickListener(v -> {

            UpdateConfig updateConfig = new UpdateConfig();
            updateConfig.setCheckWifi(true);
            updateConfig.setNeedCheckMd5(false);
            updateConfig.setNotifyImgRes(R.drawable.ic_logo);
            updateConfig.setDownloadBy(DownLoadBy.APP);
            updateConfig.setForce(true);

            updateConfig.setApkSavePath(getBaseContext().getExternalFilesDir("test").getAbsolutePath());

            updateConfig.setDownloadAuthUser("appupdate");
            updateConfig.setDownloadAuthPwd("qykcuj-nihjo4-nabwUf");

            UiConfig uiConfig = new UiConfig();
            uiConfig.setUiType(UiType.PLENTIFUL);

            UpdateAppUtils
                    .getInstance()
                    .apkUrl(apkUrl)
                    .updateTitle(updateTitle)
                    .updateContent(updateContent)
                    .uiConfig(uiConfig)
                    .updateConfig(updateConfig)
                    .setMd5CheckResultListener(result -> {

                    })
                    .setUpdateDownloadListener(new UpdateDownloadListener() {
                        @Override
                        public void onStart() {

                        }

                        @Override
                        public void onDownload(int progress) {

                        }

                        @Override
                        public void onFinish() {

                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                        }
                    })
                    .update();

            UpdateAppUtils.getInstance().deleteInstalledApk();
        });
    }
}
