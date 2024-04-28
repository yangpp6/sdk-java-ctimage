package cn.ctyun.ctapi;

public class CTFile {

    String path;

    byte[] byteArr;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getByteArr() {
        return byteArr;
    }

    public void setByteArr(byte[] byteArr) {
        this.byteArr = byteArr;
    }

    public CTFile withPath(String path) {
        this.path = path;
        return this;
    }

    public CTFile withByteArr(byte[] byteArr) {
        this.byteArr = byteArr;
        return this;
    }
}
