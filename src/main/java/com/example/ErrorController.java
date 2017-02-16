package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Joe Kutner on 2/16/17.
 *         Twitter: @codefinger
 */
@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {
  private static final String ERROR_PATH = "/error";

  @Autowired
  private ErrorAttributes errorAttributes;

  @Override
  public String getErrorPath() {
    return ERROR_PATH;
  }

  @RequestMapping(ERROR_PATH)
  String error(HttpServletRequest request, Model model) {
    Map<String, Object> errorMap = errorAttributes.getErrorAttributes(new ServletRequestAttributes(request), false);
    model.addAttribute("errors", errorMap);
    return "error";
  }
}