package dewu.scan;

import dewu.Duck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class LoginController {

    //搭配@qualifier
    @Autowired
    @Resource
    private LoginConfiguraton loginConfiguraton;

    @Autowired
    private Duck duck3;
}
