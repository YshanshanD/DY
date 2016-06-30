package cn.diy.dy.utils;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/27.
 */
public class StorageUtils {


    private Context context;

    public StorageUtils(Context context) {
        this.context = context;
    }

    public String writeFileToInternal(String fileName, byte[] data) {
        FileOutputStream outputStream = null;
        File cacheDir = context.getCacheDir();
        String file_path = new File(cacheDir, fileName).getAbsolutePath();
        try {
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(data, 0, data.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file_path;
    }

    /**
     * 从指定文件中读取数据
     * @param fileName
     * @return
     */
    public byte[] readFileFromInternal(String fileName) {
        FileInputStream inputStream = null;//定义一个读文件的流
        File cacheDir = context.getCacheDir();//得到缓存目录
        String filePath = new File(cacheDir, fileName).getAbsolutePath();//得到指定文件的全路径
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//定义一个字节输出流
        try {
            inputStream = context.openFileInput(fileName);//打开指定文件，不存在抛异常
            int len = 0;
            byte[] read_data = new byte[1024];
            while ((len = inputStream.read(read_data)) != -1) {
                byteArrayOutputStream.write(read_data, 0, len);
            }
        } catch (FileNotFoundException e) {
            return " ".getBytes();
        } catch (IOException e) {
            return " ".getBytes();
        } finally {
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                return " ".getBytes();
            }
        }
        return byteArrayOutputStream.toByteArray();//返回已读出数据、字节
    }

}
