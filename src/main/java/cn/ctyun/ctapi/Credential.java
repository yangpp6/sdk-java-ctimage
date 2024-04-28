package cn.ctyun.ctapi;

public class Credential {
    private String ak;
    private String sk;

    public String getAk() {
        return ak;
    }

    public String getSk() {
        return sk;
    }

    public Credential withAk(String ak) {
        this.ak = ak;
        return this;
    }

    public Credential withSk(String sk) {
        this.sk = sk;
        return this;
    }
}
