package com.xinmang.feedbackproject.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;
import com.xinmang.feedbackproject.bean.UpdateBean;
import com.xinmang.feedbackproject.http.OkGoUpdateHttpUtil;

/**
 * Created by lipei on 2018/1/30.
 */

public class AppUpdateUtils {
    private final static String TAG = AppUpdateUtils.class.getName();
    private static String mUpdateUrl = "";//更新的url
    private static String chanel = "";//渠道包的名称

    public static void initAppUpdate(String url, String chanel_name) {
        mUpdateUrl = url;
        chanel = chanel_name;

    }

    public static void update(final Context mContext) {
        if (mUpdateUrl.isEmpty() || chanel.isEmpty()) {
            return;
        }
        new UpdateAppManager
                .Builder()
                //必须设置，当前Activity
                .setActivity((Activity) mContext)
                //必须设置，实现httpManager接口的对象
                .setHttpManager(new OkGoUpdateHttpUtil())
                //必须设置，更新地址
                .setUpdateUrl(mUpdateUrl)
                //以下设置，都是可选
                //设置请求方式，默认get
//                .setPost(false)
                //不显示通知栏进度条
//                .dismissNotificationProgress()
                //是否忽略版本
                .showIgnoreVersion()
//                //添加自定义参数，默认version=1.0.0（app的versionName）；apkKey=唯一表示（在AndroidManifest.xml配置）
//                .setParams(params)
                //设置点击升级后，消失对话框，默认点击升级后，对话框显示下载进度
                .hideDialogOnDownloading(false)
//                //设置头部，不设置显示默认的图片，设置图片后自动识别主色调，然后为按钮，进度条设置颜色
//                .setTopPic(R.mipmap.top_8)
                //为按钮，进度条设置颜色。
                .setThemeColor(0xffffac5d)
                //设置apk下砸路径，默认是在下载到sd卡下/Download/1.0.0/test.apk
//                .setTargetPath(path)
                .build()
                //检测是否有新版本
                .checkNewApp(new UpdateCallback() {
                    /**
                     * 解析json,自定义协议
                     *
                     * @param json 服务器返回的json
                     * @return UpdateAppBean
                     */
                    @Override
                    protected UpdateAppBean parseJson(String json) {
                        UpdateAppBean updateAppBean = new UpdateAppBean();


                        UpdateBean updateBean = new Gson().fromJson(json, UpdateBean.class);
                        if(updateBean.getCode()!=0){
                            return null;

                        }
                        if (Float.parseFloat(updateBean.getData().getNew_version()) > Float.parseFloat(com.vector.update_app.utils.AppUpdateUtils.getVersionName(mContext))) {
                            updateAppBean.setUpdate(updateBean.getData().getUpdate());
                        } else {
                            updateAppBean.setUpdate("No");
                        }
                        updateAppBean
                                .setNewVersion(updateBean.getData().getNew_version())
                                //（必须）下载地址
                                .setApkFileUrl(updateBean.getData().getApk_file_url())
                                .setUpdateLog(updateBean.getData().getUpdate_log())
                                //大小，不设置不显示大小，可以不设置
                                .setTargetSize(updateBean.getData().getTarget_size())
                                //是否强制更新，可以不设置
                                .setConstraint(updateBean.getData().isConstraint());

                        return updateAppBean;
                    }

                    @Override
                    protected void hasNewApp(UpdateAppBean updateApp, UpdateAppManager updateAppManager) {
                        updateAppManager.showDialogFragment();
                    }

                    /**
                     * 网络请求之前
                     */
                    @Override
                    public void onBefore() {
                        Log.e(TAG, "请求之前");
                    }

                    /**
                     * 网路请求之后
                     */
                    @Override
                    public void onAfter() {
                        Log.e(TAG, "请求完成");
                    }

                    /**
                     * 没有新版本
                     */
                    @Override
                    public void noNewApp() {
                        Log.e(TAG, "没有新版本");
                    }
                });

    }

}
