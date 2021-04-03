package org.intellij.sdk.toolWindow.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.intellij.sdk.toolWindow.AppSettingsState;
import org.intellij.sdk.toolWindow.ContentMate;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ApproveSubmitAction extends AnAction {
    public AppSettingsState settings = AppSettingsState.getInstance();
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Integer submitId = ContentMate.SubmitId();
        try {
            Process executable = Runtime.getRuntime().exec(settings.ok_script + settings.sid + settings.tournament + submitId.toString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
