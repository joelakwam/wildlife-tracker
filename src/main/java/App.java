import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
    public static void main(String[] args){
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, respond) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/homepage", (request, respond) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/homepage.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/details", (request, respond) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            String ranger = request.queryParams("rander");
            String animal = request.queryParams("animal");
            String endangered = request.queryParams("endangered");
            String location = request.queryParams("location");
            String condition = request.queryParams("condition");
            String age = request.queryParams("age");
            model.put("template", "templates/homepage.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}