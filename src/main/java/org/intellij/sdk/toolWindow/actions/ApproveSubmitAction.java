package org.intellij.sdk.toolWindow.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.intellij.sdk.toolWindow.ContentMate;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ApproveSubmitAction extends AnAction {

    public static boolean is_Ok = false;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Integer submitId = ContentMate.SubmitId();
        try {
            Process executable = Runtime.getRuntime().exec("python C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\OK_script.py " + submitId.toString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
