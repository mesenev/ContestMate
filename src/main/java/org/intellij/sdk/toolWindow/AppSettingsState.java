package org.intellij.sdk.toolWindow;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
        name = "org.intellij.sdk.toolWindow.AppSettingsState",
        storages = {@Storage("SdkSettingsPlugin.xml")}
)

public class AppSettingsState implements PersistentStateComponent<AppSettingsState> {
    public String script1_makeJson_settings = "python C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\makeJSON.py ";
    public String ok_script = "python C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\OK_script.py ";
    public String wa_script = "python C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\WA_script.py ";
    public String sid = "INdq61Hs5ch4gPjN6rKuZjv1nEEZn6 ";
    public String tournament = "5287221 ";
    public boolean ideaStatus = false;

    public static AppSettingsState getInstance() {
        return ServiceManager.getService(AppSettingsState.class);
    }

    @Nullable
    @Override
    public AppSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AppSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
