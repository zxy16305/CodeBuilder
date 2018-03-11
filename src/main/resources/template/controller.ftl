
import org.springframework.stereotype.Controller;

@Controller
public class ${controller.name}Controller{

@Autowired

<#list param?values as value>
    @GetMapping("/data/${ControllerName}")
    @R
    public void get${}{

    }
</#list>

}