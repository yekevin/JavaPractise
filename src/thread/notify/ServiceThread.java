/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package threadNotify;



/**
 * @author shijia.wxr
 */
public abstract class ServiceThread implements Runnable {
    private static final long JoinTime = 90 * 1000;

    protected final Thread thread;

    protected volatile boolean hasNotified = false;

    protected volatile boolean stoped = false;


    public ServiceThread() {
        this.thread = new Thread(this, this.getServiceName());
    }


    public abstract String getServiceName();


    public void start() {
        this.thread.start();
    }

    // 等待线程执行完任务自动停止
    public void shutdown() {
        this.shutdown(false);
    }

    // interrupt 中断正在执行的线程
    public void shutdown(final boolean interrupt) {
        this.stoped = true;
        synchronized (this) {
            if (!this.hasNotified) {
                this.hasNotified = true;
                this.notify();
            }
        }

        try {
            if (interrupt) {
                this.thread.interrupt();
            }

            long beginTime = System.currentTimeMillis();
            if (!this.thread.isDaemon()) {
                // 非守护线程,等待joinTime 线程死亡时间
                this.thread.join(this.getJointime());
            }
            long eclipseTime = System.currentTimeMillis() - beginTime;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getJointime() {
        return JoinTime;
    }

    public void stop() {
        this.stop(false);
    }

    public void stop(final boolean interrupt) {
        this.stoped = true;
        synchronized (this) {
            if (!this.hasNotified) {
                this.hasNotified = true;
                this.notify();
            }
        }

        if (interrupt) {
            this.thread.interrupt();
        }
    }

    public void makeStop() {
        this.stoped = true;
    }

    // 唤醒线程
    public void wakeup() {
        synchronized (this) {
            if (!this.hasNotified) {
                this.hasNotified = true;
                this.notify();
            }
        }
    }

    // wait
    protected void waitForRunning(long interval) {
        synchronized (this) {
            if (this.hasNotified) {
                this.hasNotified = false;
                this.onWaitEnd();
                return;
            }

            try {
                this.wait(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.hasNotified = false;
                this.onWaitEnd();
            }
        }
    }

    protected void onWaitEnd() {
    }

    public boolean isStoped() {
        return stoped;
    }
}
