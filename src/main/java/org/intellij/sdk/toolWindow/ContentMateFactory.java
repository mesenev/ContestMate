// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.ide.impl.DataManagerImpl;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ContentMateFactory implements ToolWindowFactory {

  /**
   * Create the tool window content.
   *
   * @param project    current project
   * @param toolWindow current tool window
   */
  public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
    ContentMate contentMate = null;
    try {
      contentMate = new ContentMate(toolWindow);
    } catch (IOException e) {
      e.printStackTrace();
    }
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

    Content content = contentFactory.createContent(
            contentMate.getContent(), "", false
    );
    toolWindow.getContentManager().addContent(content);
    DataManagerImpl manager = (DataManagerImpl) DataManagerImpl.getInstance();
    DataManagerImpl.MyDataContext dataContext = (DataManagerImpl.MyDataContext) manager.getDataContext();

  }

}
