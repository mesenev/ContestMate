package org.intellij.sdk.toolWindow;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AppSettingsComponent {
    private final JPanel myMainPanel;
    private final JBTextField script1 = new JBTextField();
    private final JBTextField script2 = new JBTextField();
    private final JBTextField script3 = new JBTextField();
    private final JBTextField sid = new JBTextField();
    private final JBCheckBox myIdeaUserStatus = new JBCheckBox("Do you use IntelliJ IDEA? ");

    public AppSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Script 1: "), script1, 1, false)
                .addLabeledComponent(new JBLabel("Script 2: "), script2)
                .addLabeledComponent(new JBLabel("Script 3: "), script3)
                .addLabeledComponent(new JBLabel("Sid: "), sid)
                //.addComponent(myIdeaUserStatus, 1)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();

    }

    public JPanel getPanel() {
        return myMainPanel;
    }
    //1
    public JComponent getPreferredFocusedComponent() {
        return script1;
    }

    @NotNull
    public String getUserNameText() {
        return script1.getText();
    }

    public void setUserNameText(@NotNull String newText) {
        script1.setText(newText);
    }
    //1

    //2
    public JComponent getPreferredFocusedComponent2() {
        return script2;
    }

    @NotNull
    public String getUserNameText2() {
        return script2.getText();
    }

    public void setUserNameText2(@NotNull String newText) {
        script2.setText(newText);
    }
    //2

    //3
    public JComponent getPreferredFocusedComponent3() {
        return script3;
    }

    @NotNull
    public String getUserNameText3() {
        return script3.getText();
    }

    public void setUserNameText3(@NotNull String newText) {
        script3.setText(newText);
    }
    //3

    //4
    public JComponent getPreferredFocusedComponentSid() {
        return sid;
    }

    @NotNull
    public String getUserNameTextSid() {
        return sid.getText();
    }

    public void setUserNameTextSid(@NotNull String newText) {
        sid.setText(newText);
    }
    //4

    public boolean getIdeaUserStatus() {
        return myIdeaUserStatus.isSelected();
    }

    public void setIdeaUserStatus(boolean newStatus) {myIdeaUserStatus.setSelected(newStatus);
    }
}
