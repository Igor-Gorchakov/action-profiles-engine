import io.vertx.core.Vertx;

public class Main {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.setPeriodic(100000L, event -> {
        });
        vertx.setTimer(100000L, event -> {
        });
        vertx.deployVerticle(new RestVerticle());
    }
}
