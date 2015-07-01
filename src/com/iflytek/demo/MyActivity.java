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
import com.iflytek.downloader.event.DownloadEvents;
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
    private Button buttonCancel;
    private Button buttonCancel1;
    private Button buttonCancel2;
    private Button buttonCancel3;
    DownloadTask task;
    DownloadTask task1;
    DownloadTask task2;
    DownloadTask task3;
    ProgressBar progressBar;
    ProgressBar progressBar1;
    ProgressBar progressBar2;
    ProgressBar progressBar3;
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

        manager = new DownloadManager();
        //任务0
        task = new DownloadTask();
        task.setId("0");
        task.setUrl("http://p.gdown.baidu.com/87a32d31ed1b9023035612f950807ced97d81dd9da16bd5b0ae792421aed417886f3e9852127733d6cfc0e22005fa71a1eb3df963cb798e71094c36beb04008b913716f9a2a73195ae6925abec9e114f1efc59ea03b4ba9efdbe42168a7143c2c1250aa4f4faf971952a88ca12444b910b7ed899288972d6204acb2ece91a93b42beb268952e986d447a0bcd612704fc091db3acdec1351d6535fae331d9aaf9c5848237db1bbb8189187b167a53f4a5c57d2660614f3e30");
        task.setFileName("abc");
        task.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
        //任务1
        task1 = new DownloadTask();
        task1.setId("1");
        task1.setUrl("http://p.gdown.baidu.com/87a32d31ed1b9023035612f950807ced97d81dd9da16bd5b0ae792421aed417886f3e9852127733d6cfc0e22005fa71a1eb3df963cb798e71094c36beb04008b913716f9a2a73195ae6925abec9e114f1efc59ea03b4ba9efdbe42168a7143c2c1250aa4f4faf971952a88ca12444b910b7ed899288972d6204acb2ece91a93b42beb268952e986d447a0bcd612704fc091db3acdec1351d6535fae331d9aaf9c5848237db1bbb8189187b167a53f4a5c57d2660614f3e30");
        task1.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
        //任务2
        task2 = new DownloadTask();
        task2.setId("2");
        task2.setUrl("http://p.gdown.baidu.com/87a32d31ed1b9023035612f950807ced97d81dd9da16bd5b0ae792421aed417886f3e9852127733d6cfc0e22005fa71a1eb3df963cb798e71094c36beb04008b913716f9a2a73195ae6925abec9e114f1efc59ea03b4ba9efdbe42168a7143c2c1250aa4f4faf971952a88ca12444b910b7ed899288972d6204acb2ece91a93b42beb268952e986d447a0bcd612704fc091db3acdec1351d6535fae331d9aaf9c5848237db1bbb8189187b167a53f4a5c57d2660614f3e30");
        task2.setFileName("abc2");
        task2.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
        //任务3
        task3 = new DownloadTask();
        task3.setId("3");
        task3.setUrl("http://p.gdown.baidu.com/87a32d31ed1b9023035612f950807ced97d81dd9da16bd5b0ae792421aed417886f3e9852127733d6cfc0e22005fa71a1eb3df963cb798e71094c36beb04008b913716f9a2a73195ae6925abec9e114f1efc59ea03b4ba9efdbe42168a7143c2c1250aa4f4faf971952a88ca12444b910b7ed899288972d6204acb2ece91a93b42beb268952e986d447a0bcd612704fc091db3acdec1351d6535fae331d9aaf9c5848237db1bbb8189187b167a53f4a5c57d2660614f3e30");
        task3.setFileName("abc3");
        task3.setFileSavePath(Environment.getExternalStorageDirectory().getPath() + "/downloader/");
        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonDownload.getText().toString().equals("开始")) {
                    buttonDownload.setText("暂停");
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

//        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(MyActivity.this);
//        IntentFilter filter = new IntentFilter();
//        filter.addAction("Action");
//        localBroadcastManager.registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                Log.e("registerReceiver","registerReceiver");
//            }
//        },filter);
//        MyBroadcast.setLocalBroadcastManager(localBroadcastManager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(DownloadEvents event) {
        switch (event.getType()) {
            case EventsConfig.DOWNLOAD_SUCCESS:
                Toast.makeText(MyActivity.this, "DOWNLOAD_SUCCESS", Toast.LENGTH_SHORT).show();
                buttonCancel.setText("删除");
                break;
            case EventsConfig.DOWNLOAD_FAILURE:
                Toast.makeText(MyActivity.this, "DOWNLOAD_FAILURE", Toast.LENGTH_SHORT).show();
                break;
            case EventsConfig.DOWNLOAD_UPDATE:
                DownloadTask downloadTask = (DownloadTask) event.getData();
                if (downloadTask.getId().equals("0")) {
                    progressBar.setProgress((int) (downloadTask.getCurrentSize() * 100 / downloadTask.getTotalSize()));
                } else if (downloadTask.getId().equals("1")) {
                    progressBar1.setProgress((int) (downloadTask.getCurrentSize() * 100 / downloadTask.getTotalSize()));
                } else if (downloadTask.getId().equals("2")) {
                    progressBar2.setProgress((int) (downloadTask.getCurrentSize() * 100 / downloadTask.getTotalSize()));
                } else if (downloadTask.getId().equals("3")) {
                    progressBar3.setProgress((int) (downloadTask.getCurrentSize() * 100 / downloadTask.getTotalSize()));
                }
                break;
        }
    }

}
