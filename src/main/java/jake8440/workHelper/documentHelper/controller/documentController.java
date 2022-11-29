package jake8440.workHelper.documentHelper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Controller
public class documentController {

    @GetMapping("document/textMerge")
    public String textMerge(Model model) throws IOException {
        // 파일 읽을 위치
        String filePath = "D:\\test\\";

        // 파일명
        String fileName = "test.txt";

        // File 객체 생성
        File file = new File(filePath + fileName);

        // 입력 스트림 생성
        FileReader fileReader = new FileReader(file);

        // BufferedReader 생성
        BufferedReader reader = new BufferedReader(fileReader);

        // 전체 메모 저장
        StringBuilder totalStr = new StringBuilder();

        // 메모장 내용 출력
        String str = "";
        int i = 0;
        while((str = reader.readLine()) != null){
            if(i++ == 0) continue;
            System.out.println(str);
            totalStr.append(str);
            totalStr.append("\n");
        }

        fileReader.close();

        System.out.println(totalStr);
        model.addAttribute("rsltCd", "Success");
        return "textMerge";
    }
}
