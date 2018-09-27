package com.plus.mmtp.controller;

import com.plus.mmtp.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName: ErrorController
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/9/26 16:28
 * @Version: 1.0
 **/
@Controller
public class AppErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(AppErrorController.class);
    private final static String ERROR_PATH = "/error";

    @Autowired
    ErrorAttributes errorAttributes;

    /*@ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model){
        String errorMsg = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMsg", errorMsg);
        return "error";
    }*/

    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 401) {
            return "error/401";
        } else if (statusCode == 402) {
            return "error/402";
        } else if (statusCode == 403) {
            return "error/403";
        } else if (statusCode == 404) {
            return "error/403";
        } else {
            return "error/500";
        }
    }

    @Override
    public String getErrorPath(){
        return "error";
    }

    /*@RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        logger.error("接口请求错误，http status：{}", status);
        Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        JsonResult<Object> result = new JsonResult<Object>(ResultCode.NOT_FOUND);
        model.put("restResponse", result);
        response.setStatus(status.value());
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
        return (modelAndView == null ? new ModelAndView("error", model) : modelAndView);
    }
    @RequestMapping
    @ResponseBody
    public ResponseEntity<JsonResult<String>> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        logger.error("接口请求错误，http status：{}", status);
        //这里构建自己的输出格式,详细代码就不贴出,如有需要可以到代码仓库查看
        if (Objects.equals(status.value(), 404)) {
            return new ResponseEntity<Object>(new JsonResult<Object>(ResultCode.NOT_FOUND), status);
        } else {
            return new ResponseEntity<Object>(new JsonResult<Object>(ResultCode.ERROR_SYSTEM), status);
        }
    }*/

    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> map = this.errorAttributes.getErrorAttributes((WebRequest) requestAttributes,includeStackTrace);
        String URL = request.getRequestURL().toString();
        map.put("URL", URL);
        logger.debug("AppErrorController.method [error info]: status-" + map.get("status") +", request url-" + URL);
        return map;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            }
            catch (Exception ex) {
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
