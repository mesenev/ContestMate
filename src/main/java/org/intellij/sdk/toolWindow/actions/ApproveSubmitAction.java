package org.intellij.sdk.toolWindow.actions;

import com.intellij.ide.impl.DataManagerImpl;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.Presentation;
import org.intellij.sdk.toolWindow.ContentMate;
import org.jetbrains.annotations.NotNull;

public class ApproveSubmitAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        int context = e.getDataContext()getData("qwe");
    }

}
