package org.intellij.sdk.toolWindow.actions;

import com.intellij.ide.impl.DataManagerImpl;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.Presentation;
import org.intellij.sdk.toolWindow.ContentMate;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApproveSubmitAction extends AnAction {

    public static boolean is_Ok = false;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Integer submitId = ContentMate.SubmitId();
        try {
            Process executable = Runtime.getRuntime().exec("python C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\button_skript.py " + submitId.toString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
