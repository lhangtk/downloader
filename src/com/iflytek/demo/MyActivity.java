package com.iflytek.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.iflytek.downloader.DownloadManager;
import com.iflytek.downloader.DownloadTask;
import com.iflytek.downloader.R;
import com.iflytek.downloader.event.BaseEvents;
import com.iflytek.downloader.event.EventsConfig;
import de.greenrobot.event.EventBus;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private Button buttonDownload;
    private Button buttonDownload1;
    private Button buttonDownload2;
    private Button buttonDownload3;
    private Button buttonDownload4;
    private Button buttonDownload5;
    private Button buttonCancel;
    private Button buttonCancel1;
    private Button buttonCancel2;
    private Button buttonCancel3;
    private Button buttonCancel4;
    private Button buttonCancel5;
    DownloadTask task;
    DownloadTask task1;
    DownloadTask task2;
    DownloadTask task3;
    DownloadTask task4;
    DownloadTask task5;
    ProgressBar progressBar;
    ProgressBar progressBar1;
    ProgressBar progressBar2;
    ProgressBar progressBar3;
    ProgressBar progressBar4;
    ProgressBar progressBar5;
    DownloadManager manager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EventBus.getDefault().register(this);
        buttonDownload = (Button) findViewById(R.id.start);
        buttonCancel = (Button) findViewById(R.id.cancel);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        buttonDownload1 = (Button) findViewById(R.id.start1);
        buttonCancel1 = (Button) findViewById(R.id.cancel1);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar1.setMax(100);
        buttonDownload2 = (Button) findViewById(R.id.start2);
        buttonCancel2 = (Button) findViewById(R.id.cancel2);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar2.setMax(100);
        buttonDownload3 = (Button) findViewById(R.id.start3);
        buttonCancel3 = (Button) findViewById(R.id.cancel3);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        progressBar3.setMax(100);
        buttonDownload4 = (Button) findViewById(R.id.start4);
        buttonCancel4 = (Button) findViewById(R.id.cancel4);
        progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        progressBar4.setMax(100);
        buttonDownload5 = (Button) findViewById(R.id.start5);
        buttonCancel5 = (Button) findViewById(R.id.cancel5);
        progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);
        progressBar5.setMax(100);

        manager = new DownloadManager();

        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonDownload.getText().toString().equals("开始")) {
                    buttonDownload.setText("暂停");
                    task = new DownloadTask();
                    task.setUrl("http://ftp-apk.pconline.com.cn/f02d18c619e856e07a4e2392dcc88203/pub/download/201010/MicrosoftOfficeMobile_v15.0.3722.2000.apk");
                    task.setFileName("abc");
                    task.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
                    manager.addTask(task);
                } else if (buttonDownload.getText().toString().equals("暂停")) {
                    buttonDownload.setText("继续");
                    manager.pause(task);
                } else if (buttonDownload.getText().toString().equals("继续")) {
                    buttonDownload.setText("暂停");
                    manager.resume(task);
                }

            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDownload.setText("开始");
                progressBar.setProgress(0);
                manager.cancel(task);
            }
        });
        buttonDownload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonDownload1.getText().toString().equals("开始")) {
                    buttonDownload1.setText("暂停");
                    task1 = new DownloadTask();
                    task1.setUrl("http://ftp-apk.pconline.com.cn/f02d18c619e856e07a4e2392dcc88203/pub/download/201010/MicrosoftOfficeMobile_v15.0.3722.2000.apk");
                    task1.setFileName("abc1");
                    task1.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
                    manager.addTask(task1);
                } else if (buttonDownload1.getText().toString().equals("暂停")) {
                    buttonDownload1.setText("继续");
                    manager.pause(task1);
                } else if (buttonDownload1.getText().toString().equals("继续")) {
                    buttonDownload1.setText("暂停");
                    manager.resume(task1);
                }

            }
        });
        buttonCancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDownload1.setText("开始");
                progressBar1.setProgress(0);
                manager.cancel(task1);
            }
        });
        buttonDownload2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonDownload2.getText().toString().equals("开始")) {
                    buttonDownload2.setText("暂停");
                    task2 = new DownloadTask();
                    task2.setUrl("http://ftp-apk.pconline.com.cn/f02d18c619e856e07a4e2392dcc88203/pub/download/201010/MicrosoftOfficeMobile_v15.0.3722.2000.apk");
                    task2.setFileName("abc2");
                    task2.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
                    manager.addTask(task2);
                } else if (buttonDownload2.getText().toString().equals("暂停")) {
                    buttonDownload2.setText("继续");
                    manager.pause(task2);
                } else if (buttonDownload2.getText().toString().equals("继续")) {
                    buttonDownload2.setText("暂停");
                    manager.resume(task2);
                }

            }
        });
        buttonCancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDownload2.setText("开始");
                progressBar2.setProgress(0);
                manager.cancel(task2);
            }
        });
        buttonDownload3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonDownload3.getText().toString().equals("开始")) {
                    buttonDownload3.setText("暂停");
                    task3 = new DownloadTask();
                    task3.setUrl("http://ftp-apk.pconline.com.cn/f02d18c619e856e07a4e2392dcc88203/pub/download/201010/MicrosoftOfficeMobile_v15.0.3722.2000.apk");
                    task3.setFileName("abc3");
                    task3.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
                    manager.addTask(task3);
                } else if (buttonDownload3.getText().toString().equals("暂停")) {
                    buttonDownload3.setText("继续");
                    manager.pause(task3);
                } else if (buttonDownload3.getText().toString().equals("继续")) {
                    buttonDownload3.setText("暂停");
                    manager.resume(task3);
                }

            }
        });
        buttonCancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDownload3.setText("开始");
                progressBar3.setProgress(0);
                manager.cancel(task3);
            }
        });
        buttonDownload4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonDownload4.getText().toString().equals("开始")) {
                    buttonDownload4.setText("暂停");
                    task4 = new DownloadTask();
                    task4.setUrl("http://ftp-apk.pconline.com.cn/f02d18c619e856e07a4e2392dcc88203/pub/download/201010/MicrosoftOfficeMobile_v15.0.3722.2000.apk");
                    task4.setFileName("abc4");
                    task4.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
                    manager.addTask(task4);
                } else if (buttonDownload4.getText().toString().equals("暂停")) {
                    buttonDownload4.setText("继续");
                    manager.pause(task4);
                } else if (buttonDownload4.getText().toString().equals("继续")) {
                    buttonDownload4.setText("暂停");
                    manager.resume(task4);
                }

            }
        });
        buttonCancel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDownload4.setText("开始");
                progressBar4.setProgress(0);
                manager.cancel(task4);
            }
        });
        buttonDownload5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonDownload5.getText().toString().equals("开始")) {
                    buttonDownload5.setText("暂停");
                    task5 = new DownloadTask();
                    task5.setUrl("http://ftp-apk.pconline.com.cn/f02d18c619e856e07a4e2392dcc88203/pub/download/201010/MicrosoftOfficeMobile_v15.0.3722.2000.apk");
                    task5.setFileName("abc5");
                    task5.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
                    manager.addTask(task5);
                } else if (buttonDownload5.getText().toString().equals("暂停")) {
                    buttonDownload5.setText("继续");
                    manager.pause(task5);
                } else if (buttonDownload5.getText().toString().equals("继续")) {
                    buttonDownload5.setText("暂停");
                    manager.resume(task5);
                }

            }
        });
        buttonCancel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDownload5.setText("开始");
                progressBar5.setProgress(0);
                manager.cancel(task5);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(BaseEvents event) {
        switch (event.getType()) {
            case EventsConfig.DOWNLOAD_SUCCESS:
                Toast.makeText(MyActivity.this, "DOWNLOAD_SUCCESS", Toast.LENGTH_SHORT).show();
                buttonCancel.setText("删除");
                break;
            case EventsConfig.DOWNLOAD_FAILURE:
                Toast.makeText(MyActivity.this, "DOWNLOAD_FAILURE", Toast.LENGTH_SHORT).show();
                break;
            case EventsConfig.DOWNLOAD_UPDATE:
                progressBar.setProgress((int) (task.getCurrentSize()*100 / task.getTotalSize()));
                progressBar1.setProgress((int) (task1.getCurrentSize()*100 / task1.getTotalSize()));
                progressBar2.setProgress((int) (task2.getCurrentSize()*100 / task2.getTotalSize()));
                progressBar3.setProgress((int) (task3.getCurrentSize()*100 / task3.getTotalSize()));
                progressBar4.setProgress((int) (task4.getCurrentSize()*100 / task4.getTotalSize()));
                progressBar5.setProgress((int) (task5.getCurrentSize()*100 / task5.getTotalSize()));
                break;
        }
    }

}
