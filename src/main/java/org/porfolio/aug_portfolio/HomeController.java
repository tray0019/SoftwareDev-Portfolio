package org.porfolio.aug_portfolio;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){

        return "index";
    }

    @GetMapping("/resume")
    public String resumePage(){
        return "resume";
    }

    @ResponseBody
    @GetMapping("/api/files/resume")
        public ResponseEntity<Resource> downloadResume() throws Exception{
            Resource pdf = new ClassPathResource("static/assets/Rustom_Trayvilla_Resume.pdf");
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"Rustom_Trayvilla_Resume.pdf\"")
                            .contentType(MediaType.APPLICATION_PDF)
                    .contentLength(pdf.contentLength())
                    .body(pdf);

        }
}
