package cz.czechitas.webapp;

import java.util.*;
import ch.qos.logback.core.pattern.*;

public class HoboForm {

    private List<String> answers;

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> newValue) {
        answers = newValue;
    }

    @Override
    public String toString() {
        return "HoboForm " +
                "answers=" + answers;
    }
}
