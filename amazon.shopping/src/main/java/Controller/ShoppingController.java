package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingController {

    @Autowired
    public RestTemplate restTemplate;
    @GetMapping("/amazon-payment/{price}")
    public String invokePaymentService(@PathVariable int price){

        //want to invoke payment service then we need RestTemplate
        //it is traditinal approach
        //here we need alll info ip and port
        //As we registered our payment service on eureka servier then we no need to add host and port no
        //String url = "http://localhost:8081/paymentProvider/payment/"+ price;
        //instead of localhost:8081 host and port we can add service name by wich we have registered on eureka
        String url = "http://payment-service/paymentProvider/payment/"+ price;

        return restTemplate.getForObject(url, String.class);
    }
}
