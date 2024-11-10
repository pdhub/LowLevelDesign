import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LoadBalancer {

    List<Server> servers;
    int currentIndex = -1;
    Random random = new Random();

    void simulateRequestCompletion(Server server){
        new Thread(()-> {
            try {
                Thread.sleep(1000);
                server.decrementLoad();
            }catch (InterruptedException e){

            }
        });
    }

    public void healthCheck(){
        for (Server server : servers)
            server.setHealthy(random.nextBoolean());
    }

    LoadBalancer(List<Server> servers){
        this.servers = servers;
    }

    public void handleRequest(){
        Server server = getNextAvailableServer();
        if (server != null){
            server.incrementLoad();
            System.out.println("Request Handled by "+ server);
        }else
            System.out.println("No server");
    }

    public Server getNextAvailableServer(){
        int checkedServers = 0;
        while(checkedServers < servers.size()){
            currentIndex = (currentIndex + 1)%servers.size();
            Server server = servers.get(currentIndex);
            if (server.isHealthy() && server.canHandleMoreLoad())
                return server;
            checkedServers++;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Server> servers = Arrays.asList
                (new Server("Server1",  3),
                new Server("Server2", 5),
                new Server("Server3", 2));
        LoadBalancer loadBalancer = new LoadBalancer(servers);
        for (int i = 0; i < 10; i++) {
            loadBalancer.handleRequest();
        }
    }
}

class Server {
    String name;
    boolean isHealthy;
    int load;
    int maxLoad;

    Server(String name, int maxLoad){
        this.name = name;
        this.maxLoad = maxLoad;
        this.load = 0;
        this.isHealthy = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public boolean canHandleMoreLoad() {
        if (load < maxLoad)
            return true;
        return false;
    }

    public void incrementLoad() {
        load++;
    }

    public void decrementLoad() {
        load--;
    }
}
