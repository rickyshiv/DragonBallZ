package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
public class ProgressBar extends AppCompatActivity {
    Button btn;

    ProgressDialog pd;
    int progressbarstatus = 0;
    long fileSize = 0;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);


        addListenerOnButtonClick();
    }

    private void addListenerOnButtonClick() {
        btn = findViewById(R.id.btnprog);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = new ProgressDialog(v.getContext());
                pd.setCancelable(true);
                pd.setMessage("File Downloading");
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setProgress(0);
                pd.setMax(100);

                pd.show();
                progressbarstatus = 0;
                fileSize = 0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressbarstatus < 100) {
                            progressbarstatus = doOperation();
                            try {
                                {
                                    Thread.sleep(1000);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pd.setProgress(progressbarstatus);
                                }
                            });
                        }
                        if (progressbarstatus >= 0) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pd.dismiss();
                        }
                    }
                }).start();

            }
        });
    }

    private int doOperation() {
        while (fileSize <= 10000) {
            fileSize++;
            if (fileSize == 1000) {
                return 10;
            } else if (fileSize == 2000) {
                return 20;
            } else if (fileSize == 3000) {
                return 30;
            } else if (fileSize == 4000) {
                return 40;
            } else if (fileSize == 5000) {
                return 50;
            } else if (fileSize == 6000) {
                return 60;
            } else if (fileSize == 7000) {
                return 70;
            } else if (fileSize == 8000) {
                return 80;
            } else if (fileSize == 9000) {
                return 90;
            }
        }
        return 100 ;

    }



}
