package ch.LFG.controller;

import ch.LFG.entity.Appuser;
import ch.LFG.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;
    private boolean b;

    //further commands see https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations#OpenAPIDefinition
    @Operation(summary = "Get Users", description = "Get list of all users")
    @GetMapping
    public List<Appuser> findAll() {
        return userService.getAll();
    }

    @Operation(summary = "Get Users by id", description = "Get one user by his ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Appuser getUserProfile(@PathVariable int id){
        return userService.getUserProfil(id);
    }

    @Operation(summary = "Create new User", description = "Create new User")
    @RequestMapping(value="/set", method = RequestMethod.PUT)
    public void setUserProfil(@RequestBody Appuser user) {
        userService.setUserProfil(user);
    }

    @Operation(summary = "Update User", description = "Update existing user")
    @RequestMapping(value="/update", method = RequestMethod.PATCH)
    public Appuser updateUserProfil(@RequestBody Appuser user) {
        Appuser updatedUser = userService.updateUserProfile(user, user.getUserId());
        return updatedUser;
    }

    @Operation(summary = "Temporary test Implementation")
    @RequestMapping(value="/bool", method = RequestMethod.PUT)
    public void setBool(@RequestBody Boolean b) {
        this.b = b;
    }

    @Operation(summary = "Temporary test Implementation")
    @RequestMapping(value="/bool", method = RequestMethod.GET)
    public boolean getBool() {
        return this.b;
    }


}
