package sample;

import java.util.Map;

public class ThymeleafTemplate {

    private String templateName;

    private Map<String, Object> variables;

    public ThymeleafTemplate(String templateName, Map<String, Object> variables) {
        this.templateName = templateName;
        this.variables = variables;
    }

    public String getTemplateName() {
        return templateName;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }
}
