package com.dinner.config.oss.factory;

public abstract class AbstractUpload {
    /**
     * 文件名验证
     * @param suffix 后拽名
     * @return
     */
    public abstract boolean  valid(String suffix);

    /**
     * 允许文件拓展名
     */
    public static final String[] DEFAULT_ALLOWED_EXTENSION = {
            // 图片
            "bmp", "gif", "jpg", "jpeg", "png",
            // word excel powerpoint
            "doc", "docx", "xls", "xlsx", "ppt", "pptx", "html", "htm", "txt",
            // 压缩文件
            "rar", "zip", "gz", "bz2",
            // pdf
            "pdf"};

}
