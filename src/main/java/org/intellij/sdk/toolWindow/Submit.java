package org.intellij.sdk.toolWindow;

public class Submit {

    public int id_problem;
    public int id_submit;
    public String problem_name;
    public String username;
    public String content_link;
    public String current_status;
    public String pathfile;

    Submit(int id_problem, String pathfile, String problem_name, int id_submit, String username, String content_link, String current_status) {
        this.id_problem = id_problem;
        this.problem_name = problem_name;
        this.id_submit = id_submit;
        this.username = username;
        this.content_link = content_link;
        this.current_status = current_status;
        this.pathfile = pathfile;
    }
}
