package top.smartsoftware.smarthr.model;

import java.io.Serializable;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-19
 */
public class OSSObjectVO implements Serializable {
    private String key;
    private String size;
    private String lastModified;
    private String owner;
    private Integer isFolder;
    private String contentType;
    private Integer iconCode;

    public OSSObjectVO() {
    }

    public Integer getIconCode() {
        return iconCode;
    }

    public void setIconCode(Integer iconCode) {
        this.iconCode = iconCode;
    }

    public String getContentType() {

        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "OSSObjectVO{" +
                "key='" + key + '\'' +
                ", size='" + size + '\'' +
                ", lastModified='" + lastModified + '\'' +
                ", owner='" + owner + '\'' +
                ", isFolder=" + isFolder +
                ", contentType='" + contentType + '\'' +
                ", iconCode=" + iconCode +
                '}';
    }

    public OSSObjectVO(String key) {
        this.key = key;
        this.size = "-";
        this.lastModified = "-";
        this.owner = "-";
        this.isFolder = 1;
        this.iconCode=0;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getIsFolder() {
        return isFolder;
    }

    public void setIsFolder(Integer isFolder) {
        this.isFolder = isFolder;
    }
}

