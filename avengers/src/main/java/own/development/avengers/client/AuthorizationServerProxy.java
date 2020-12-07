package own.development.avengers.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "authorization-server")
public interface AuthorizationServerProxy {
}
