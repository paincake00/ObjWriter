package com.cgvsu.objwriter;

import com.cgvsu.math.Vector2f;
import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Polygon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ObjWriterTest {

    private static final String UNIT_TEST_PATH_FILE =
            "E:\\Admin\\DevAndProgs\\ProjectsJava\\ComputerGraphics\\ThirdTask\\ObjWriter\\assets\\testedModels\\unit-test_output.obj";

    private static void clearFile(String pathLine) throws IOException {
        Files.write(Paths.get(UNIT_TEST_PATH_FILE), "".getBytes());
    }

    @Test
    void writeVertices() throws Exception {
        clearFile(UNIT_TEST_PATH_FILE);
        FileWriter writer = new FileWriter(UNIT_TEST_PATH_FILE);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ArrayList<Vector3f> testedVertices = new ArrayList<>();
        testedVertices.add(new Vector3f(1.01f, 1.02f, 1.03f));
        ObjWriter.writeVertices(bufferedWriter, testedVertices);
        bufferedWriter.close();

        assertEquals("v  1.01 1.02 1.03\n",
                Files.readString(Paths.get(UNIT_TEST_PATH_FILE)));
    }

    @Test
    void writeTextureVertices() throws Exception {
        clearFile(UNIT_TEST_PATH_FILE);
        FileWriter writer = new FileWriter(UNIT_TEST_PATH_FILE);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ArrayList<Vector2f> testedTextureVertices = new ArrayList<>();
        testedTextureVertices.add(new Vector2f(0.5f, 0.5f));
        ObjWriter.writeTextureVertices(bufferedWriter, testedTextureVertices);
        bufferedWriter.close();

        assertEquals("vt 0.5 0.5\n", Files.readString(Paths.get(UNIT_TEST_PATH_FILE)));
    }

    @Test
    void writeNormals() throws Exception {
        clearFile(UNIT_TEST_PATH_FILE);
        FileWriter writer = new FileWriter(UNIT_TEST_PATH_FILE);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ArrayList<Vector3f> testedNormals = new ArrayList<>();
        testedNormals.add(new Vector3f(1f, 0f, 0f));
        ObjWriter.writeNormals(bufferedWriter, testedNormals);
        bufferedWriter.close();

        assertEquals("vn 1.0 0.0 0.0\n", Files.readString(Paths.get(UNIT_TEST_PATH_FILE)));
    }

    @Test
    void writeFaces() throws Exception {
        clearFile(UNIT_TEST_PATH_FILE);
        FileWriter writer = new FileWriter(UNIT_TEST_PATH_FILE);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ArrayList<Polygon> testedFaces = new ArrayList<>();
        Polygon polygon = new Polygon();
        polygon.setVertexIndices(new ArrayList<>(Arrays.asList(0, 2, 1)));
        polygon.setTextureVertexIndices(new ArrayList<>(Arrays.asList(0, 1, 2)));
        polygon.setNormalIndices(new ArrayList<>(Arrays.asList(2, 1, 0)));
        testedFaces.add(polygon);
        ObjWriter.writeFaces(bufferedWriter, testedFaces);
        bufferedWriter.close();

        assertEquals("f 1/1/3 3/2/2 2/3/1\n", Files.readString(Paths.get(UNIT_TEST_PATH_FILE)));
    }
}