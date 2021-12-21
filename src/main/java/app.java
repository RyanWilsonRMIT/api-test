import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.Handler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class app {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.addSinglePageRoot("/","/public/index.html");
            config.registerPlugin(new RouteOverviewPlugin("/routes"));
        }).start(80);

        app.routes(() -> {
            get("/api/test", testAPI);
        });
    }
    public static Handler root = ctx -> {
      ctx.json("This is the homepage");
    };
    public static Handler testAPI = ctx -> {
        ctx.json("This is a test API response");
    };

}
