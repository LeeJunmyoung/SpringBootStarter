package me.jun.web.errorTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleExceptionTestController {

    @GetMapping("/exException")
    public String exException() {

        throw new SampleExcetion();

    }

  /*  @ExceptionHandler(SampleExcetion.class)
    public @ResponseBody
    AppError sampleError(SampleExcetion e){
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK");

        return appError;
    }*/


}
