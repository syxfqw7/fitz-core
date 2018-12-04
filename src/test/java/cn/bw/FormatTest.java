///**
// * FileName: FormatTest
// * Author:   jack.xue
// * Date:     2018/12/4 14:13
// * Description: FormatTest
// * History:
// * <author>          <time>          <version>          <desc>
// * jack.xue           2018/12/4           1.0.0              描述
// */
//package cn.bw;
//
//import org.apache.log4j.helpers.LogLog;
//import org.junit.Test;
//
//import java.io.File;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//
///**
// * 〈TODO〉<br>
// *
// * @author jack.xue
// * @create 2018/12/4
// * @since 1.0.0
// */
//public class FormatTest {
//
//    String datePattern = "'.'yyyy-MM-dd";
//    SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
//
//    @Test
//    public void FormatDate(){
//        String fileName = "E:\\app\\shuku\\log\\ht-nlp-analysis";
//        File file = new File(fileName);
//        if (file.getParentFile().exists()){
//            File[] files = file.getParentFile().listFiles(new LogFileFilter(file.getName()));
//            Long[] dateArray = new Long[files.length];
//            for (int i = 0; i < files.length; i++) {
//                File fileItem = files[i];
//                String fileDateStr = fileItem.getName().replace(file.getName(), "");
//                Date filedate = null;
//                try {
//                    filedate = sdf.parse(fileDateStr);
//                    long fileDateLong = filedate.getTime();
//                    dateArray[i] = fileDateLong;
//                } catch (ParseException e) {
//                    LogLog.error("Parse File Date Throw Exception : " + e.getMessage());
//                }
//            }
//            Arrays.sort(dateArray);
//        }
//    }
//
//}