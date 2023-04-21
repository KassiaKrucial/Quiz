package cz.czechitas.webapp;

import java.io.*;
import java.util.*;
import org.springframework.core.io.*;
import org.springframework.core.io.support.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    private List<String> manFiles;

    public HlavniController() throws IOException {
        ResourcePatternResolver folderSearcher =
                new PathMatchingResourcePatternResolver();
        List<Resource> resources =
                Arrays.asList(folderSearcher.getResources(
                        "classpath:/static/images/men/*"));
        manFiles = new ArrayList<>(resources.size());
        for (Resource element : resources) {
            manFiles.add(element.getFilename());
        }

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView viewIndex() {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("manFiles", manFiles);
        modelAndView.addObject("answers", new HoboForm());

        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView submitIndex(HoboForm form) {

        ModelAndView modelAndView = new ModelAndView("results");

        List<String> listOfAnswers = new ArrayList<>();
        listOfAnswers.add("Hobo");
        listOfAnswers.add("Prof");
        listOfAnswers.add("Hobo");
        listOfAnswers.add("Prof");
        listOfAnswers.add("Prof");
        listOfAnswers.add("Hobo");
        listOfAnswers.add("Hobo");
        listOfAnswers.add("Prof");

        int resultNumber = 0;
        List<String> resultString = new ArrayList<>();

        for (int i = 0; i < form.getAnswers().size(); i++) {
            if (form.getAnswers().get(i).equals(listOfAnswers.get(i))) {
                resultNumber = resultNumber + 1;
                resultString.add("correct");
            } else {
                resultString.add("wrong");
            }
        }

        modelAndView.addObject("manFiles", manFiles);
        modelAndView.addObject("listOfAnswers", listOfAnswers);
        modelAndView.addObject("resultNumber", resultNumber);
        modelAndView.addObject("resultString", resultString);

        return modelAndView;
    }

}
