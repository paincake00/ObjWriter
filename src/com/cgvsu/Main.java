package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.objwriter.ObjWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static final String DEFAULT_PATH_INPUT =
            "E:\\Admin\\DevAndProgs\\ProjectsJava\\ComputerGraphics\\ThirdTask\\ObjWriter\\assets\\models\\Torus.obj";
    public static final String DEFAULT_PATH_OUTPUT =
            "E:\\Admin\\DevAndProgs\\ProjectsJava\\ComputerGraphics\\ThirdTask\\ObjWriter\\assets\\models\\output.obj";

    public static void main(String[] args) throws IOException {
        String pathInputFile, pathOutputFile;
        if (args.length == 2) {
            pathInputFile = args[0];
            pathOutputFile = args[1];
        } else {
            pathInputFile = DEFAULT_PATH_INPUT;
            pathOutputFile = DEFAULT_PATH_OUTPUT;
        }

        Model model = ObjReader.read(Files.readString(Paths.get(pathInputFile)));
        ObjWriter.write(model, pathOutputFile);
    }
}