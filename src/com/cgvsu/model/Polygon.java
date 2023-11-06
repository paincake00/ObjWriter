package com.cgvsu.model;

import java.util.ArrayList;

public class Polygon {
    private ArrayList<Integer> vertexIndices;
    private ArrayList<Integer> textureVertexIndices;
    private ArrayList<Integer> normalIndices;

    public Polygon() {
        vertexIndices = new ArrayList<>();
        textureVertexIndices = new ArrayList<>();
        normalIndices = new ArrayList<>();
    }

    public ArrayList<Integer> getVertexIndices() {
        return vertexIndices;
    }

    public void setVertexIndices(ArrayList<Integer> vertexIndices) {
        this.vertexIndices = vertexIndices;
    }

    public ArrayList<Integer> getTextureVertexIndices() {
        return textureVertexIndices;
    }

    public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
        this.textureVertexIndices = textureVertexIndices;
    }

    public ArrayList<Integer> getNormalIndices() {
        return normalIndices;
    }

    public void setNormalIndices(ArrayList<Integer> normalIndices) {
        this.normalIndices = normalIndices;
    }
}
