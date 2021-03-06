package org.intellij.sdk.toolWindow;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Provides controller functionality for application settings.
 */
public class AppSettingsConfigurable implements Configurable {

    private AppSettingsComponent mySettingsComponent;

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Contestmate";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return mySettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mySettingsComponent = new AppSettingsComponent();
        return mySettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        AppSettingsState settings = AppSettingsState.getInstance();
        boolean modified = !mySettingsComponent.getUserNameText().equals(settings.script1_makeJson_settings);
        //boolean modified2 = !mySettingsComponent.getUserNameText().equals(settings.script2_setting);
        //boolean modified3 = !mySettingsComponent.getUserNameText().equals(settings.script3_setting);
        //boolean modified4 = !mySettingsComponent.getUserNameText().equals(settings.sid);
        modified |= (mySettingsComponent.getIdeaUserStatus() != settings.ideaStatus) | (mySettingsComponent.getIdeaUserStatus() != settings.ideaStatus);
        //modified2 |= mySettingsComponent.getIdeaUserStatus() != settings.ideaStatus;
        //modified3 |= mySettingsComponent.getIdeaUserStatus() != settings.ideaStatus;
        //modified4 |= mySettingsComponent.getIdeaUserStatus() != settings.ideaStatus;
        return modified;
    }

    @Override
    public void apply() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.script1_makeJson_settings = mySettingsComponent.getUserNameText();
        settings.ideaStatus = mySettingsComponent.getIdeaUserStatus();
        settings.ok_script = mySettingsComponent.getUserNameText2();
        settings.wa_script = mySettingsComponent.getUserNameText3();
        settings.sid = mySettingsComponent.getUserNameTextSid();
        settings.tournament = mySettingsComponent.getUserNameTextTournament();
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        mySettingsComponent.setUserNameText(settings.script1_makeJson_settings);
        mySettingsComponent.setIdeaUserStatus(settings.ideaStatus);
        mySettingsComponent.setUserNameText2(settings.ok_script);
        mySettingsComponent.setUserNameText3(settings.wa_script);
        mySettingsComponent.setUserNameTextSid(settings.sid);
        mySettingsComponent.setUserNameTextTournament(settings.tournament);
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }

}