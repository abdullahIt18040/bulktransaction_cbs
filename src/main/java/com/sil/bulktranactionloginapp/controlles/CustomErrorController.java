//package com.sil.bulktranactionloginapp.controlles;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.error.ErrorAttributeOptions;
//import org.springframework.boot.web.error.ErrorAttributeOptions.Include.*;
//import org.springframework.boot.webmvc.error.ErrorAttributes;
//import org.springframework.boot.webmvc.error.ErrorController;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.context.request.WebRequest;
//
//import java.util.Map;
//
//import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.*;
//
//@Controller
//@RequestMapping("/error")
//public class CustomErrorController implements ErrorController {
//
//    @Autowired
//     private ErrorAttributes errorAttributes;
//
//// @ResponseBody
// @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//    public String errorHtmlpage(HttpServletRequest request, Model model)
//    {
//
//        WebRequest webRequest = new ServletWebRequest(request);
//
//     Map<String,Object> map = errorAttributes.getErrorAttributes(webRequest,
//             ErrorAttributeOptions.of(
//            MESSAGE,STACK_TRACE,PATH,STATUS,ERROR
//     ));
////     model.addAttribute(map);
//        map.forEach(model::addAttribute);
//return "error2";
////        return """
////        <h1>Something went wrong</h1>
////        <p><b>Timestamp:</b> %s</p>
////        <p><b>Status:</b> %s</p>
////        <p><b>Error:</b> %s</p>
////        <p><b>Message:</b> %s</p>
////        <p><b>Path:</b> %s</p>
////        <pre><b>Stack Trace:</b>\n%s</pre>
////        """
////                .formatted(
////                        map.get("timestamp"),
////                        map.get("status"),
////                        map.get("error"),
////                        map.get("message"),
////                        map.get("path"),
////                        map.get("trace")
////                );
//    };
//
//    @ResponseBody
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> restErrorHandler(HttpServletRequest request)
//    {
//        WebRequest webRequest = new ServletWebRequest(request);
//
//        Map<String,Object> map = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(
//                MESSAGE,STACK_TRACE,PATH,STATUS,ERROR
//        ));
//        map.put("extra-infa","this is extra-info");
//        map.put("info","this is info");
//
//        return ResponseEntity.status((Integer) map.get("status")).body(map);
//
//    }
//
//}
