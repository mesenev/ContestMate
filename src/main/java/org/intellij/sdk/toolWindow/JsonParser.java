package org.intellij.sdk.toolWindow;

import java.io.BufferedReader;
import java.io.IOException;

public class JsonParser {
    public void main() throws IOException {
        Process executable = Runtime.getRuntime().exec("python C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\test.py");
        System.out.println(executable);
    }
}
