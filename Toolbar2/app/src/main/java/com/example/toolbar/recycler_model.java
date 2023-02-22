package com.example.toolbar;

public class recycler_model {
    private int grp_image;
    private String grp_name;
    private String grp_cont;

    public recycler_model(int grp_image, String grp_name, String grp_cont) {
        this.grp_image = grp_image;
        this.grp_name = grp_name;
        this.grp_cont = grp_cont;
    }

    public int getGrp_image()
    {
        return grp_image;
    }
    public void setGrp_image(int grp_image)
    {
        this.grp_image = grp_image;
    }

    public String getGrp_name()
    {
        return grp_name;
    }
    public void setGrp_name(String grp_name)
    {
        this.grp_name = grp_name;
    }

    public String getGrp_cont()
    {
        return grp_cont;
    }
    public void setGrp_cont(String grp_cont)
    {
        this.grp_cont = grp_cont;
    }
}