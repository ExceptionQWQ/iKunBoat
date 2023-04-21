package com.busybox.ikunboat;

public class ReportThread extends Thread{
    public static int upFlags = 0;
    public static int downFlags = 0;
    public static int leftFlags = 0;
    public static int rightFlags = 0;

    public void run()
    {
        while (true) {
            if (upFlags > 0) {
                upFlags -= 25;
                try {
                    Request.Request("w");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (downFlags > 0) {
                downFlags -= 25;
                try {
                    Request.Request("s");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (leftFlags > 0) {
                leftFlags -= 25;
                try {
                    Request.Request("a");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (rightFlags > 0) {
                rightFlags -= 25;
                try {
                    Request.Request("d");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
