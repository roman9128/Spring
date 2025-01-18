package rt.bridge;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class Controller {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public Controller(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        restClient = restClientBuilder.build();
    }

    @GetMapping("/{serviceName}")
    public String hello(@PathVariable String serviceName) {
        ServiceInstance service = discoveryClient.getInstances(serviceName).getFirst();
        String serviceResponse = restClient.get()
                .uri(service.getUri() + "/hello")
                .retrieve()
                .body(String.class);
        return serviceResponse;
    }
}
