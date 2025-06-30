package org.example.server.testScripts;

import org.example.server.Script;
import org.example.server.ServerScript;

@ServerScript(method = "GET", path = "/getData")
public class ScriptOne implements Script {
    @Override
    public void execute() {
        System.out.println("Executing ScriptOne: GET /getData");
    }
}
