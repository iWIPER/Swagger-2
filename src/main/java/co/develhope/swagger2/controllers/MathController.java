package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    String[] divProperties = new String[]{"distributive","invariant"};

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "User access-2", notes = "Make the user who accesses feel welcome")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal error", response = String.class)
    })

    public String welcomeMathMessage(){

        return "Welcome";
    }

    @GetMapping(value ="/division-info")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value ="Division",notes = "Display elements of a division")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal error")
    })

    public ArithmeticOperation division(){
        return new ArithmeticOperation ("Division", 2, "operation", divProperties);
    }

    @GetMapping(value = "/multiplication")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Multiplication",notes = "Display elements of a multiplication ")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal error")
    })

    public int product (@RequestParam Integer int1 , @RequestParam Integer int2){
        return (int1 * int2);
    }

    @GetMapping(value = "/square{n}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Square", notes = "Square number" )
    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal error")
    })

    public int square (@RequestParam int a){
        return a * a;
    }






}