/**
 * FileName: FormatTest
 * Author:   jack.xue
 * Date:     2018/12/4 14:13
 * Description: FormatTest
 * History:
 * <author>          <time>          <version>          <desc>
 * jack.xue           2018/12/4           1.0.0              描述
 */
package cn.bw;

import cn.bw.core.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈TODO〉<br>
 *
 * @author jack.xue
 * @create 2018/12/4
 * @since 1.0.0
 */
@Slf4j
public class FormatTest {

    String datePattern = "'.'yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

    @Test
    public void FormatDate(){
        Date filedate = null;
        try {
            String fileDateStr = "2018-12-04-18-24";
            datePattern = "yyyy-MM-dd-HH";
            sdf = new SimpleDateFormat(datePattern);
            log.info("util parse : " + DateUtil.toDate(fileDateStr, datePattern));
            filedate = sdf.parse(fileDateStr);
            long fileDateLong = filedate.getTime();
            log.info("fileDateLong :{}",fileDateLong);
            String resName = sdf.format(fileDateLong);
            log.info("resName: {}, {}", resName, resName.equals(fileDateStr));
        } catch (ParseException e) {
            log.error("Parse File Date Throw Exception : " + e.getMessage());
        }
    }

}