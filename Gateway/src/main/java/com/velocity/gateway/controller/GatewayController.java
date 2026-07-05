@RestController
public class GatewayController {

    private final WebClient webClient;
    private final RouteMatcher routeMatcher;

    public GatewayController(WebClient webClient,
                             RouteMatcher routeMatcher) {
        this.webClient = webClient;
        this.routeMatcher = routeMatcher;
    }

    @GetMapping("/{*path}")
    public String forward(HttpServletRequest request) {

        String path = request.getRequestURI();

        Route route = routeMatcher.findRoute(path);

        return webClient
                .get()
                .uri(route.getTarget() + path)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}