package com.disco.test;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @ClassName: FastDFSTest
 * @Description: FastDFS测试类
 * @date: 2022/6/26
 * @author zhb
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FastDFSTest {

    @Resource
    private FastFileStorageClient storageClient;

    @Resource
    private ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload() throws FileNotFoundException {
        // 1.创建要上传的文件
        File file = new File("E:\\文档\\照片\\IMG_8859.jpg");
        // 2.上传并保存图片 参数 1.上传的文件流 2.文件的大小 3.文件的后缀 4.可以不管他
        StorePath storePath = this.storageClient.uploadFile(new FileInputStream(file), file.length(), "jpg", null);
        // 3.带分组的路径
        System.out.println(storePath.getFullPath());
        // 4.不带分组的路径
        System.out.println(storePath.getPath());
    }

    @Test
    public void testUploadAndCreateThumb() throws FileNotFoundException {
        File file = new File("E:\\文档\\照片\\IMG_8859.jpg");
        // 1.上传并生成缩略图
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(new FileInputStream(file), file.length(), "png", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
        String path = thumbImageConfig.getThumbImagePath(storePath.getPath());
        System.out.println(path);
    }
}
