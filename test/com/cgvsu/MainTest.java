package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.model.Polygon;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.objwriter.ObjWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final String TEST_PATH_INPUT =
            "E:\\Admin\\DevAndProgs\\ProjectsJava\\ComputerGraphics\\ThirdTask\\ObjWriter\\assets\\testedModels\\Torus.obj";
    private static final String TEST_PATH_OUTPUT =
            "E:\\Admin\\DevAndProgs\\ProjectsJava\\ComputerGraphics\\ThirdTask\\ObjWriter\\assets\\testedModels\\output.obj";

    @Test
    void mainTest() throws IOException {
        Model expectedResult = ObjReader.read(Files.readString(Paths.get(TEST_PATH_INPUT)));
        ObjWriter.write(expectedResult, TEST_PATH_OUTPUT);
        Model result = ObjReader.read(Files.readString(Paths.get(TEST_PATH_OUTPUT)));

        // vertices
        for (int i = 0; i < result.vertices.size(); i++) {
            Assertions.assertTrue(result.vertices.get(i).equals(expectedResult.vertices.get(i)));
        }
        // texture vertices
        for (int i = 0; i < result.textureVertices.size(); i++) {
            Assertions.assertTrue(result.textureVertices.get(i).equals(expectedResult.textureVertices.get(i)));
        }
        // normals
        for (int i = 0; i < result.normals.size(); i++) {
            Assertions.assertTrue(result.normals.get(i).equals(expectedResult.normals.get(i)));
        }
        for (int i = 0; i < result.polygons.size(); i++) {
            Polygon resultFace = result.polygons.get(i);
            Polygon expectedFace = expectedResult.polygons.get(i);
            for (int j = 0; j < resultFace.getVertexIndices().size(); j++) {
                assertEquals(resultFace.getVertexIndices().get(j), expectedFace.getVertexIndices().get(j));
                if (resultFace.getTextureVertexIndices().size() != 0) {
                    assertEquals(resultFace.getTextureVertexIndices().get(j), expectedFace.getTextureVertexIndices().get(j));
                }
                if (expectedFace.getNormalIndices().size() != 0) {
                    assertEquals(resultFace.getNormalIndices().get(j), expectedFace.getNormalIndices().get(j));
                }
            }
        }

        System.out.println("WELL DONE!");
    }
}