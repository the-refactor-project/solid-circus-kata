package com.therefactorproject.show;

import java.util.List;

public class Show {
    public String name;
    public String type;
    public List<String> jokes;
    public Double ropeLength;
    public Boolean isBlindfolded;
    public Integer performers;

    public Show(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
